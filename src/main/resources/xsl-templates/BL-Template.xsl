<?xml version="1.0" encoding="iso-8859-1"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:barcode="org.krysalis.barcode4j.xalan.BarcodeExt" xmlns:common="http://exslt.org/common"
	xmlns:xalan="http://xml.apache.org" exclude-result-prefixes="barcode common xalan">
	<xsl:variable name="image-dir" select="'/images'"/>
	<xsl:template match="dummyData">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simple"
					page-height="20cm" page-width="10.5cm" margin-left="0.2cm"
					margin-right="0.2cm">
					<fo:region-body margin-top="0.5cm" />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="simple">
				<fo:flow flow-name="xsl-region-body">
					<fo:block font-family="Arial" font-weight="normal">
						<fo:table>
							<fo:table-column column-number="1" column-width="3cm" />
							<fo:table-column column-number="2" column-width="5cm" />
							<fo:table-column column-number="3" column-width="3cm" />
							<fo:table-body height="10cm">
									<fo:table-row height="0.7cm">  <!-- border="solid 0.1mm black" -->
										<fo:table-cell text-align="left">
											<fo:block margin-top="-7pt">
										        <!-- <fo:external-graphic src="url(/logo.png)"></fo:external-graphic> -->
										        
										        <fo:external-graphic>
													<xsl:attribute name="src">
														url('<xsl:value-of select="logo"/>')
													</xsl:attribute>
												</fo:external-graphic> 
										    </fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="center">
											<fo:block>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block font-family="Arial" font-weight="bold" font-size="7pt">
												BILL OF LADING
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
									<fo:table-row height="0.7cm">
										<fo:table-cell text-align="left">
											<fo:block font-family="Arial" font-style="italic" font-weight="bold" font-size="6pt">
												FMC-OTI No. <xsl:value-of select="fmcOtiNumber" />
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="center">
											<fo:block font-size="4.5px" padding-top="2pt">
												FOR PORT-TO-PORT OR COMBINED TRANSPORT
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
							</fo:table-body>
						</fo:table>
						
						<fo:table>
							<fo:table-column column-number="1" column-width="2.5cm" />
							<fo:table-column column-number="2" column-width="2.5cm" />
							<fo:table-column column-number="3" column-width="2.5cm" />
							<fo:table-column column-number="4" column-width="2.5cm" />
							<fo:table-body height="10cm">
								<!-- 1 -->
								<fo:table-row height="0.5cm">
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="2" number-rows-spanned="3">
										<fo:block font-family="Arial" font-size="3pt">
											EXPORTER/SHIPPER
										</fo:block>
										<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
											<xsl:value-of select="exportedShipped"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											BOOKING NUMBER
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="bookingNumber"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											BILL OF LADING NUMBER
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="billLandingNumber"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row height="0.5cm">
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											CONSOLIDATION NUMBER
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="consolidationNumber"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											CONTAINER NUMBER
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="containerNumber"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row height="0.5cm">
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											EXPORT REFERENCES
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="exportReferences"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											SHIPPER'S REFERENCES
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="shippersReferences"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<!-- 2 -->
								<fo:table-row height="0.5cm">
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="2" number-rows-spanned="2">
										<fo:block font-family="Arial" font-size="3pt">
											CONSIGNED TO
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="consignedTo"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="2">
										<fo:block font-family="Arial" font-size="3pt">
											FORWARDING AGENT
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="forwardingAgent"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row height="0.5cm">
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="2">
										<fo:block font-family="Arial" font-size="3pt">
											POINT (STATE) OF ORIGIN OR FTZ NUMBER
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="pointOfOriginFTZNumber"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<!-- 4 -->
								<fo:table-row height="0.5cm">
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="2" height="1cm">
										<fo:block font-family="Arial" font-size="3pt">
											NOTIFY PARTY/INTERMEDIATE CONSIGNEE
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="notifyPartyIntermediateConsignee"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="2" number-rows-spanned="2">
										<fo:block font-family="Arial" font-size="3pt">
											DESTINATION AGENT
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="destinationAgent"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row height="0.5cm">
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											PRE-CARRIAGE BY 
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="preCarriageBy"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											PLACE OF RECEIPT BY PRE-CARRIER
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="placeReceiptyByPreCarrier"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<!-- 5 -->
								<fo:table-row height="0.5cm">
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											VESSEL
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="vessel"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
										<fo:table-cell text-align="left" border="solid 0.1mm black">
											<fo:block font-family="Arial" font-size="3pt">
											PORT OF LOADING/EXPORT
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="portLoadingExport"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="2">
										<fo:block font-family="Arial" font-size="3pt">
											LOADING PIER/TERMINAL
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="loadingPierTerminal"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row height="0.5cm">
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											FOREIGN PORT OF UNLOADING
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="foreignPortUnloading"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											PLACE OF DELIVERY BY ON-CARRIER
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="placeDeliveryByOnCarrier"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											CO-LOADED WITH 
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="coLoadedWith"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											CONTAINERIZED
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="containerized"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<!-- 6 -->
								<fo:table-row height="0.1cm">
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="2">
										<fo:block font-family="Arial" font-size="3pt">
											CARRIER'S RECEIPT 
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<!-- <xsl:value-of select=""/> -->
											</fo:block>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="2">
										<fo:block font-family="Arial" font-size="3pt">
											PARTICULARS FURNISHED BY SHIPPER
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<!-- <xsl:value-of select=""/> -->
											</fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
						
						<fo:table>
							<fo:table-column column-number="1" column-width="1.3cm" border="solid 0.1mm black" />
							<fo:table-column column-number="2" column-width="1.2cm" border="solid 0.1mm black" />
							<fo:table-column column-number="3" column-width="1.5cm" border="solid 0.1mm black" />
							<fo:table-column column-number="4" column-width="1.2cm" border="solid 0.1mm black" />
							<fo:table-column column-number="5" column-width="1.2cm" border="solid 0.1mm black" />
							<fo:table-column column-number="6" column-width="1.2cm" border="solid 0.1mm black" />
							<fo:table-column column-number="7" column-width="1.2cm" border="solid 0.1mm black" />
							<fo:table-column column-number="8" column-width="1.2cm" border="solid 0.1mm black" />
							<fo:table-body height="10cm" border="solid 0.1mm black">
								<!-- 1 -->
								<fo:table-row height="0.1cm">
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="2">
										<fo:block font-family="Arial" font-size="3pt">
											MARKS AND NUMBERS
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											NO. OF PKGS
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center" border="solid 0.1mm black" number-columns-spanned="3">
										<fo:block font-family="Arial" font-size="3pt">
											DESCRIPTION OF PACKAGES AND GOODS
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											GROSS WEIGHT
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black">
										<fo:block font-family="Arial" font-size="3pt">
											MEASUREMENT
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<!-- 2 -->
								<xsl:for-each select="./packageList/package">
									<fo:table-row height="0.1cm">
										<fo:table-cell text-align="center" number-columns-spanned="2">
											<fo:block font-family="Arial" font-size="5pt" font-weight="bold" padding-top="1pt" padding-bottom="1pt">
												<xsl:value-of select="mark" /> &#160;&#160; <xsl:value-of select="number" />
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="center">
											<fo:block font-family="Arial" font-size="5pt" font-weight="bold" padding-top="1pt" padding-bottom="1pt">
												<xsl:value-of select="packageNumber" />
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="center" number-columns-spanned="3">
											<fo:block font-family="Arial" font-size="5pt" font-weight="bold" padding-top="1pt" padding-bottom="1pt">
												<xsl:value-of select="packageGoodDescription" />
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="center">
											<fo:block font-family="Arial" font-size="5pt" font-weight="bold" padding-top="1pt" padding-bottom="1pt">
												<xsl:value-of select="grossWeight" />
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="center">
											<fo:block font-family="Arial" font-size="5pt" font-weight="bold" padding-top="1pt" padding-bottom="1pt">
												<xsl:value-of select="measurement" />
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
								</xsl:for-each>
								<!-- 3 -->
								<fo:table-row height="0.3cm" border="solid 0.1mm black">
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="4">
										<fo:block font-family="Arial" font-size="3pt">
											APPLICABLE ONLY WHEN DOCUMENT USED AS COMBINED TRANSPORT BILL OF LADING
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="4" padding-top="3pt" padding-start="1pt" padding-end="20pt" text-align="left">
										<fo:block font-family="Arial" font-size="3pt">
											DECLARED VALUE  (FOR AD VALOREM PURPOSE ONLY).
										</fo:block>
										<fo:block font-family="Arial" font-size="3pt">
											(REFER TO CLAUSE 26 ON REVERSE HEREOF) IN US$
										</fo:block>
										<fo:block font-family="Arial" font-size="3pt" text-align="right" padding-top="-7pt">
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="declaredValue"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
									<!-- <fo:table-cell text-align="left" number-columns-spanned="1" padding-top="3pt" border-left-color="white">
										<fo:block font-family="Arial" font-size="3pt">
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="declaredValue"/>
											</fo:block>
										</fo:block>
									</fo:table-cell> -->
								</fo:table-row>
								<!-- 4 -->
								<fo:table-row height="0.1cm">
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="2" number-rows-spanned="2">
										<fo:block font-family="Arial" font-size="2.9pt" space-after="1mm">
											In accepting this bill of lading, any local customs
											or privileges to the contrary notwithstanding, the
											shipper, consignee and owner of the goods and
											the holder of this bill of lading, agree to be bound
											by all the stipulations, exceptions and conditions
											stated herein whether written, printed, stamped
											or incorporated on the front or reverse side hereof,
											as fully as if they were all signed by such shipper,
											consignee, owner or holder.  
										</fo:block>
										<fo:block font-family="Arial" font-size="2.9pt" space-before="1mm">
											In witness whereof three (3) bills of lading, all
											of the tenor and date have been signed, one of 
											which being accomplished, the others to stand void.
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center" border="solid 0.1mm black" number-columns-spanned="6">
										<fo:block font-family="Arial" font-size="3pt">
											FREIGHT AND CHARGES
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row height="2cm">
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="6">
										<fo:block font-family="Arial" font-size="3pt">
											DESCRIPTION OF CHARGES
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="descriptionCharges"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<!-- 5 -->
								<fo:table-row height="0.8cm">
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="2">
										<fo:block font-family="Arial" font-size="3pt">
											BY:  COMPANY NAME, As Carrier
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="6">
										<fo:block font-family="Arial" font-size="3pt">
											TOTAL PREPAID 
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="totalPrepaid"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row height="0.8cm">
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="2">
										<fo:block font-family="Arial" font-size="3pt">
											DATE
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" border="solid 0.1mm black" number-columns-spanned="6">
										<fo:block font-family="Arial" font-size="3pt">
											TOTAL COLLECT
											<fo:block font-family="Arial" font-size="7pt" font-weight="bold">
												<xsl:value-of select="totalCollect"/>
											</fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
					</fo:block>

				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>