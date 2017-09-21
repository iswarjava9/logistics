package com.suis.logistics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.Arrays;

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

import com.suis.logistics.model.BookingDetail;

public class PDF_And_XML_GeneratorMain {

	public static void main(String[] s) {
		try {


			// generateXMLSourceFromJavaObject();
			generateJavaToPDF();
			// generateXMLFileFromJavaObject();

			//generateBOOKING_DEATIL_XML();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void generateJavaToPDF() {
		try {
			//File xslt = new File("src//main//resources//xsl-templates//booking-dto.xsl");

			File xslt = new File("src//main//resources//xsl-templates//final-booking-template.xsl");
			File pdf = new File("src//main//resources//generated-pdf//booking-confirmation.pdf");
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
			/*
			 * String xmlString = generateXMLSourceFromJavaObject();
			 *
			 * Source xmlSource=new StreamSource(new StringReader(xmlString));
			 */
			generateXMLFileFromJavaObject();
			StreamSource xmlSource = new StreamSource(new File("src//main//resources//xml-data//booking-USOE-1437842627.xml"));
			Result res = new SAXResult(fop.getDefaultHandler());
			// Start XSLT transformation and FOP processing
			// That's where the XML is first transformed to XSL-FO and then
			// PDF is created
			transformer.transform(xmlSource, res);
			System.out.println(pdf.getName()+" PDF Generated");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static String generateXMLSourceFromJavaObject() throws Exception {
		EmployeeDto emp = new EmployeeDto("JOHN", 34, 25000.50, LocalDate.now(), "Department1",
				Arrays.asList(new AddressDto("77878", "chennai address"), new AddressDto("635353", "bangalore1")));
		JAXBContext jc = JAXBContext.newInstance(EmployeeDto.class);
		JAXBElement<EmployeeDto> jaxbElement = new JAXBElement<EmployeeDto>(new QName("EmployeeDto"), EmployeeDto.class,
				emp);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		OutputStream out = new java.io.FileOutputStream("src//main//resources//xsl-templates//empdto.xml");
		// This method will print the xml in console
		// marshaller.marshal(jaxbElement, System.out);
		StringWriter stringWriter = new StringWriter();
		// This method will write the xml as a string
		marshaller.marshal(jaxbElement, stringWriter);
		// System.out.println(stringWriter.toString());
		return stringWriter.toString();
	}

	public static void generateXMLFileFromJavaObject() throws Exception {
		EmployeeDto emp = new EmployeeDto("JOHN", 34, 25000.50, LocalDate.now(), "Department1",
				Arrays.asList(new AddressDto("77878", "chennai address"), new AddressDto("635353", "bangalore1")));
		JAXBContext jc = JAXBContext.newInstance(EmployeeDto.class);
		JAXBElement<EmployeeDto> jaxbElement = new JAXBElement<EmployeeDto>(new QName("EmployeeDto"), EmployeeDto.class,
				emp);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		File xmlDataFile = new File("src//main//resources//xml-data//empdto.xml");
		xmlDataFile.createNewFile(); // if file already exists will do nothing

		OutputStream out = new FileOutputStream(xmlDataFile);
		marshaller.marshal(jaxbElement, out);
	}

	public static void generateBOOKING_DEATIL_XML() throws Exception{
		BookingDetail bk = new BookingDetail();
		JAXBContext jc = JAXBContext.newInstance(BookingDetail.class);
		JAXBElement<BookingDetail> jaxbElement = new JAXBElement<BookingDetail>(new QName("bookinginfo"), BookingDetail.class,
				bk);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		OutputStream out = new java.io.FileOutputStream("src//main//resources//xml-data//booking-detail.xml");
		marshaller.marshal(jaxbElement, out);
	}
}
