<?xml version="1.0"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:s="http://www.stylusstudio.com/xquery"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="default-page"
					page-height="11in" page-width="8.5in" margin-left="0.2in"
					margin-right="0.2in" margin-top="0.2in" margin-bottom="0.2in">
					<fo:region-body />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="default-page">
				<fo:flow flow-name="xsl-region-body">
					<fo:block>

						<fo:table width="100%" border-style="inset" border-width="0pt"
							background-repeat="repeat">
							<fo:table-column column-width="60%" />
							<fo:table-column column-width="40%" />
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell border-style="inset" border-width="0pt"
										padding="0pt" background-repeat="repeat" display-align="center">
										<fo:block>
											<fo:external-graphic background="transparent"
												width="320pt" content-width="scale-to-fit" height="70pt"
												content-height="scale-to-fit" scaling="non-uniform"
												src="url(file:///c:/My%20Drive/WORKSPACEs/Logistics/logistics/src/main/resources/xsl-templates/li-logo.jpg)" />

										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-style="inset" border-width="0pt"
										padding="0pt" background-repeat="repeat" display-align="before">

										<fo:block font-size="14pt" font-weight="bold"
											text-align="left" border="2pt solid grey">

											<xsl:text>BOOKING CONFIRMATION</xsl:text>

										</fo:block>



									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
					</fo:block>

					<!-- block - 2 -->
					<fo:block>
						<xsl:text>&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;</xsl:text>
						<fo:table width="100%" border-style="outset"
							border-width="2pt" background-repeat="repeat">
							<fo:table-column column-width="40%" />
							<fo:table-column />
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell border-style="inset" border-width="0pt" border-right="1pt"
										padding="0pt" background-repeat="repeat" display-align="center" border-color="grey">
										<fo:block />
									</fo:table-cell>
									<fo:table-cell border-style="inset" border-width="0pt"
										padding="0pt" background-repeat="repeat" display-align="center">
										<fo:block>
											<fo:table width="100%" border-style="inset"
												border-width="0pt" background-repeat="repeat" border-color="grey">
												<fo:table-column />
												<fo:table-column />
												<fo:table-column />
												<fo:table-body>


													<fo:table-row height="auto" font-size="x-small">
														<fo:table-cell border-style="inset"
															border-width="0pt" padding="0pt" background-repeat="repeat"
															display-align="center" border-right=".75pt"
															border-bottom="1pt" border-color="grey">
															<fo:block>
																Carrier
															</fo:block>
															<fo:block></fo:block>
															<fo:block font-weight="bold">
																<xsl:value-of select="/bookinginfo/carrier/name" />
															</fo:block>
														</fo:table-cell>
														<fo:table-cell border-style="inset"
															border-width="0pt" padding="0pt" background-repeat="repeat"
															display-align="center" border-right=".75pt"
															border-bottom="1pt" border-color="grey">
															<fo:block>
																Carrier Booking No#
															</fo:block>
															<fo:block></fo:block>
															<fo:block font-weight="bold">
																<xsl:value-of select="/bookinginfo/carrierBookingNo" />
															</fo:block>
														</fo:table-cell>
														<fo:table-cell border-style="inset"
															border-width="0pt" padding="0pt" background-repeat="repeat"
															display-align="center" border-bottom="1pt" border-color="grey">
															<fo:block>
																Forwarder Booking No#
															</fo:block>
															<fo:block></fo:block>
															<fo:block font-weight="bold">
																<xsl:value-of select="/bookinginfo/forwarderRefNo" />
															</fo:block>
														</fo:table-cell>
													</fo:table-row>

												</fo:table-body>
											</fo:table>
										</fo:block>



									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell border-style="inset" border-width="0pt"
										padding="0pt" background-repeat="repeat" display-align="center" border-color="grey" border-right="1pt">
										<fo:block>
										
										<fo:table width="100%" border-style="inset"
												border-width="0pt" border-color="grey">
												<fo:table-column column-width="100%" />
											
												<!-- <fo:table-column column-width="50%" />
												<fo:table-column column-width="50%" /> -->
												<fo:table-body>
													<fo:table-row height="auto" border-bottom-width="thick">
														<fo:table-cell border-style="inset"
															border-width="0pt" padding="0pt" background-repeat="repeat"
															display-align="center" border-right=".75pt"
															border-bottom="1pt" border-color="grey" border-top="1pt">
															<fo:block>

																cell-1tttttttttttttttt
																ttttttttttRRRR
																RRRRRRRRRRRRRR

															</fo:block>
														</fo:table-cell>
														
													</fo:table-row>

													<fo:table-row height="auto">
														<fo:table-cell border-style="inset"
															border-width="0pt" padding="0pt" background-repeat="repeat"
															display-align="center" border-right=".75pt" border-top="1pt"
															border-color="grey">
															<fo:block>

																cell-1tttttttttttttttt
																ttttttttttRRRR
																RRRRRRRRRRRRRR

															</fo:block>
														</fo:table-cell>
														
													</fo:table-row>
												</fo:table-body>
											</fo:table>
										
										</fo:block>
									</fo:table-cell>
									<fo:table-cell>
										<fo:block>
											<fo:table width="100%" border-style="inset"
												border-width="0pt" border-color="grey">
												<fo:table-column column-width="50%" />
												<fo:table-column column-width="50%" />
												<!-- <fo:table-column column-width="50%" />
												<fo:table-column column-width="50%" /> -->
												<fo:table-body>
													<fo:table-row height="auto" border-bottom-width="thick">
														<fo:table-cell border-style="inset"
															border-width="0pt" padding="0pt" background-repeat="repeat"
															display-align="center" border-right=".75pt"
															border-bottom="1pt" border-color="grey">
															<fo:block>

																cell-1tttttttttttttttt
																ttttttttttRRRR
																RRRRRRRRRRRRRR

															</fo:block>
														</fo:table-cell>
														<fo:table-cell border-style="inset"
															border-width="0pt" padding="0pt" background-repeat="repeat"
															display-align="center" border-right=".75pt"
															border-bottom="1pt" border-color="grey">
															<fo:block>cell-2</fo:block>
														</fo:table-cell>
													</fo:table-row>

													<fo:table-row height="auto">
														<fo:table-cell border-style="inset"
															border-width="0pt" padding="0pt" background-repeat="repeat"
															display-align="center" border-right=".75pt"
															border-color="grey">
															<fo:block>

																cell-1tttttttttttttttt
																ttttttttttRRRR
																RRRRRRRRRRRRRR

															</fo:block>
														</fo:table-cell>
														<fo:table-cell>
															<fo:block>cell-2</fo:block>
														</fo:table-cell>
													</fo:table-row>
												</fo:table-body>
											</fo:table>


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