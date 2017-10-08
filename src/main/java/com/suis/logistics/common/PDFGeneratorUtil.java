package com.suis.logistics.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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
import org.springframework.util.CollectionUtils;

import com.suis.logistics.web.billoflading.BillOfLadingDto;
import com.suis.logistics.web.booking.BookingDto;
import com.suis.logistics.web.container.ContainerDto;
import com.suis.logistics.web.container.ContainerShortDto;

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

	@Value("${billoflading.xmldata.url}")
	private String	billofLadingXMLDataUrl;
	@Resource
	ConverterUtil converterUtil;

	public void generateBookingConfirmationPDF(BookingDto bookingDto) throws Exception {
		bookingDto.setLogoPath(logoPath);
		converterUtil.convertDateTimeFromUTCtoPlaceTimeZone(bookingDto);
		setContainerDetailsToBookingDto(bookingDto);
		File bookingXML = parseBookingDtoToXML(bookingDto);
		createBookingConfirmationPDFfromXML(bookingXML, bookingDto.getForwarderRefNo());
	}
	
	public void generateBillOfLadingPDF(BillOfLadingDto billOfLadingDto) throws Exception {
		billOfLadingDto.setLogoPath(logoPath);
		File billofladingXML = parseBillOfLadingDtoToXML(billOfLadingDto);
		createBillOfLadingPDFfromXML(billofladingXML, billOfLadingDto.getBlNo());
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
		File xmlDataFile = new File(bookingXMLDataUrl + "/booking-" + bookingDto.getForwarderRefNo() + ".xml");
		xmlDataFile.createNewFile(); // if file already exists will do
										// nothing
		OutputStream out = new FileOutputStream(xmlDataFile);
		marshaller.marshal(jaxbElement, out);
		out.flush();
		return xmlDataFile;
	}
	
	private File parseBillOfLadingDtoToXML(BillOfLadingDto billOfLadingDto) throws Exception {
		JAXBContext jc;
		jc = JAXBContext.newInstance(BillOfLadingDto.class);
		JAXBElement<BillOfLadingDto> jaxbElement = new JAXBElement<BillOfLadingDto>(new QName("bookinginfo"), BillOfLadingDto.class,
				billOfLadingDto);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// URL url = this.getClass().getResource("/resources");
		// File xmlDataFile = new
		// File(url.toURI().getPath()+"booking-"+bookingDto.getId()+".xml");
		File xmlDataFile = new File(billofLadingXMLDataUrl + "/billoflading-" + billOfLadingDto.getBlNo() + ".xml");
		xmlDataFile.createNewFile(); // if file already exists will do
										// nothing
		OutputStream out = new FileOutputStream(xmlDataFile);
		marshaller.marshal(jaxbElement, out);
		out.flush();
		return xmlDataFile;
	}

	private void createBookingConfirmationPDFfromXML(File bookingXML, String bookingNo) throws Exception {
		File xslt = new File(bookingXSLUrl + "/final-booking-template.xsl");
		File pdf = new File(bookingPDFUrl + "/booking-" + bookingNo + ".pdf");
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

	private void createBillOfLadingPDFfromXML(File billofladingXML, String blNo) throws Exception {
		File xslt = new File(bookingXSLUrl + "/final-BL-template.xsl");
		File pdf = new File(bookingPDFUrl + "/billoflading-" + blNo + ".pdf");
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
		StreamSource xmlSource = new StreamSource(billofladingXML);
		Result res = new SAXResult(fop.getDefaultHandler());
		// Start XSLT transformation and FOP processing
		// That's where the XML is first transformed to XSL-FO and then
		// PDF is created
		transformer.transform(xmlSource, res);
		System.out.println(pdf.getName() + " PDF Generated");
	}

	/**
	 * This method is used to implement the logic to print (noOfContainer X
	 * ContainerType) format i.e. 2X20 in booking confirmation pdf
	 *
	 * @param bookingDto
	 */
	private void setContainerDetailsToBookingDto(BookingDto bookingDto) {
		List<ContainerDto> containerDetails = bookingDto.getContainerDetails();
		List<ContainerShortDto> containerShortDtoList = new ArrayList<>();
		Map<String, ContainerShortDto> noOfContainerTypeMap = new HashMap<>();
		if (! CollectionUtils.isEmpty(containerDetails)) {
			for (ContainerDto containerDto : containerDetails) {
				String containerTypeText = containerDto.getContainerType().getType();
				ContainerShortDto containerShortInfo = null;
				if (noOfContainerTypeMap.containsKey(containerTypeText)) {
					containerShortInfo = noOfContainerTypeMap.get(containerTypeText);
					int count = containerShortInfo.getNoOfContainer() + 1;
					containerShortInfo.setNoOfContainer(count);
				} else {
					containerShortInfo = new ContainerShortDto();
					if (containerDto.getContainerType() != null && containerDto.getCommodity() != null) {
						containerShortInfo.setCommodity(containerDto.getCommodity().getName());
						containerShortInfo.setContainerType(containerDto.getContainerType().getType());
						containerShortInfo.setNoOfContainer(1);
						noOfContainerTypeMap.put(containerTypeText, containerShortInfo);
						containerShortDtoList.add(containerShortInfo);
					}
				}
			}
		}
		bookingDto.setContainerTypes(containerShortDtoList);
	}
}
