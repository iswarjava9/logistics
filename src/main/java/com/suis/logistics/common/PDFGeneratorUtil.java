package com.suis.logistics.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.suis.logistics.web.booking.BookingDto;

@Component
public class PDFGeneratorUtil {
	@Value("${booking.pdf.url}")
	private String	bookingPDFUrl;
	@Value("${booking.xsl.url}")
	private String	bookingXSLUrl;
	@Value("${booking.xmldata.url}")
	private String	bookingXMLDataUrl;
	@Value("${logo.image.url}")
	private String	logoPath;

	public void generateBookingConfirmationPDF(BookingDto bookingDto) throws Exception {
		bookingDto.setLogoPath(logoPath);
		File bookingXML = parseBookingDtoToXML(bookingDto);
		createBookingConfirmationPDFfromXML(bookingXML, bookingDto.getForwarderRefNo());
	}

	private File parseBookingDtoToXML(BookingDto bookingDto) throws Exception {
		JAXBContext jc;
		jc = JAXBContext.newInstance(BookingDto.class);
		JAXBElement<BookingDto> jaxbElement = new JAXBElement<BookingDto>(new QName("bookinginfo"), BookingDto.class,
				bookingDto);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// URL url = this.getClass().getResource("/resources");
		// File xmlDataFile = new
		// File(url.toURI().getPath()+"booking-"+bookingDto.getId()+".xml");
		File xmlDataFile = new File(bookingXMLDataUrl + "//booking-" + bookingDto.getForwarderRefNo() + ".xml");
		xmlDataFile.createNewFile(); // if file already exists will do
										// nothing
		OutputStream out = new FileOutputStream(xmlDataFile);
		marshaller.marshal(jaxbElement, out);
		out.flush();
		return xmlDataFile;
	}

	private void createBookingConfirmationPDFfromXML(File bookingXML, String bookingNo) throws Exception {
		File xslt = new File(bookingXSLUrl + "//final-booking-template.xsl");
		File pdf = new File(bookingPDFUrl + "//booking-" + bookingNo + ".pdf");
		// outDir.mkdirs();
		// Setup input and output
		FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
		// a user agent is needed for transformation
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
		OutputStream out;
		out = new java.io.FileOutputStream(pdf);
		Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(new StreamSource(xslt));
		StreamSource xmlSource = new StreamSource(bookingXML);
		Result res = new SAXResult(fop.getDefaultHandler());
		// Start XSLT transformation and FOP processing
		// That's where the XML is first transformed to XSL-FO and then
		// PDF is created
		transformer.transform(xmlSource, res);
		System.out.println(pdf.getName() + " PDF Generated");
	}
}
