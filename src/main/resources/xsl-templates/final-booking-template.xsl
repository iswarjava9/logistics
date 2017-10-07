<?xml version="1.0"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:s="http://www.stylusstudio.com/xquery"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format"
			font-family="Tahoma">
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
						<!-- Header Table -->
						<fo:table width="100%" border-style="inset" border-width="0pt"
							background-repeat="repeat">
							<fo:table-column column-width="30%" />
							<fo:table-column column-width="30%" />
							<fo:table-column column-width="40%" />
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell border-style="inset" border-width="0pt"
										padding="0pt" background-repeat="repeat" display-align="center">
										<fo:block>
											<xsl:variable name="logo" select="/bookinginfo/logoPath" />
											<fo:external-graphic background="transparent"
												width="180pt" content-width="scale-to-fit" height="50pt"
												content-height="scale-to-fit" scaling="non-uniform"
												src="url(file:///{/bookinginfo/logoPath})" />
										</fo:block>
										<fo:block text-indent="10pt">
											FMC-OTI No.
											<fo:inline font-weight="bold">026642NF</fo:inline>
										</fo:block>
									</fo:table-cell>

									<fo:table-cell text-indent="1pt" border-style="inset"
										border-width="0pt" padding="0pt" background-repeat="repeat"
										display-align="center">

										<fo:block font-size="9pt" font-weight="normal"
											text-align="left" color="blue">

											<xsl:text>operations@logiisticsinternational.com</xsl:text>
											<fo:block>Tel: (814) 580-0466</fo:block>

										</fo:block>



									</fo:table-cell>
									<fo:table-cell text-indent="2pt" border-style="inset"
										border-width="0pt" padding="0pt" background-repeat="repeat"
										display-align="before">

										<fo:block font-size="14pt" font-weight="bold"
											text-align="center" border="2pt solid grey">

											<xsl:text>BOOKING CONFIRMATION</xsl:text>

										</fo:block>



									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
					</fo:block>

					<!-- block - 2 -->
					<fo:block>

						<!-- Body Table -->

						<fo:table width="100%" border-style="outset"
							border-width="1pt" background-repeat="repeat">
							<fo:table-column column-width="40%" />
							<fo:table-column />
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell padding-left="1mm" font-size="x-small"
										border-style="inset" border-width="0pt" border-right="1pt"
										padding="0pt" background-repeat="repeat" display-align="center"
										border-color="grey">
										<fo:block space-after="7pt" space-before.minimum="6pt"
											space-before.optimum="8pt" space-before.maximum="10pt">
										</fo:block>

										<fo:block>Shipper</fo:block>
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
														<fo:table-cell padding-left="1mm"
															border-style="inset" border-width="0pt" padding="0pt"
															background-repeat="repeat" display-align="center"
															border-right="1pt" border-bottom="1pt" border-color="grey">
															<fo:block>
																Carrier
															</fo:block>
															<fo:block></fo:block>
															<fo:block font-weight="bold">
																<xsl:value-of select="/bookinginfo/carrier/name" />
															</fo:block>
														</fo:table-cell>
														<fo:table-cell padding-left="1mm"
															border-style="inset" border-width="0pt" padding="0pt"
															background-repeat="repeat" display-align="center"
															border-right="1pt" border-bottom="1pt" border-color="grey">
															<fo:block>
																Carrier Booking No#
															</fo:block>
															<fo:block></fo:block>
															<fo:block font-weight="bold">
																<xsl:value-of select="/bookinginfo/carrierBookingNo" />
															</fo:block>
														</fo:table-cell>
														<fo:table-cell padding-left="1mm"
															border-style="inset" border-width="0pt" padding="0pt"
															background-repeat="repeat" display-align="center"
															border-bottom="1pt" border-color="grey">
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
										padding="0pt" background-repeat="repeat" display-align="center"
										border-color="grey" border-right="1pt">
										<fo:block>

											<fo:table display-align="before" width="100%"
												border-style="inset" border-width="0pt" border-color="grey">
												<fo:table-column column-width="100%" />

												<!-- <fo:table-column column-width="50%" /> <fo:table-column 
													column-width="50%" /> -->
												<fo:table-body>
													<fo:table-row height="100pt"
														border-bottom-width="thick">
														<fo:table-cell padding-left="1mm"
															border-style="inset" border-width="0pt" padding="0pt"
															background-repeat="repeat" border-right="0pt"
															border-bottom="1pt" border-color="grey" border-top="1pt">

															<fo:block font-size="small" font-weight="bold">
																<fo:block>

																	<xsl:value-of select="/bookinginfo/shipper/name" />

																</fo:block>
																<fo:block>

																	<xsl:value-of select="/bookinginfo/shipper/address" />

																</fo:block>
																<fo:block>
																	<xsl:if test="/bookinginfo/shipper/city">
																		<xsl:value-of select="/bookinginfo/shipper/city/name" />
																		<xsl:text> , </xsl:text>
																		<xsl:value-of select="/bookinginfo/shipper/city/stateName" />
																		<xsl:text> , </xsl:text>
																		<xsl:value-of select="/bookinginfo/shipper/city/countryName" />
																	</xsl:if>
																</fo:block>

															</fo:block>
														</fo:table-cell>

													</fo:table-row>

													<fo:table-row height="100pt">
														<fo:table-cell padding-left="1mm"
															border-style="inset" border-width="0pt" padding="0pt"
															background-repeat="repeat" border-right="0pt" border-top="1pt"
															border-color="grey">
															<fo:block font-size="x-small">

																Forwarding Agent

															</fo:block>
															<fo:block font-size="small" font-weight="bold">
																<fo:block>

																	<xsl:value-of select="/bookinginfo/bookingAgent/name" />

																</fo:block>
																<fo:block>

																	<xsl:value-of select="/bookinginfo/bookingAgent/address" />

																</fo:block>
																<fo:block>
																	<xsl:if test="/bookinginfo/bookingAgent/city">
																		<xsl:value-of select="/bookinginfo/bookingAgent/city/name" />
																		<xsl:text> , </xsl:text>
																		<xsl:value-of
																			select="/bookinginfo/bookingAgent/city/stateName" />
																		<xsl:text> , </xsl:text>
																		<xsl:value-of
																			select="/bookinginfo/bookingAgent/city/countryName" />
																	</xsl:if>
																</fo:block>

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
												<!-- <fo:table-column column-width="50%" /> <fo:table-column 
													column-width="50%" /> -->
												<fo:table-body>
													<fo:table-row height="100pt"
														border-bottom-width="thick">
														<fo:table-cell padding-left="1mm"
															border-style="inset" border-width="0pt" padding="0pt"
															background-repeat="repeat" border-right="1pt"
															border-bottom="1pt" border-color="grey">


															<fo:table display-align="before" width="100%"
																border-style="inset" border-width="0pt" border-color="grey">
																<fo:table-column column-width="100%" />

																<!-- <fo:table-column column-width="50%" /> <fo:table-column 
																	column-width="50%" /> -->
																<fo:table-body>
																	<fo:table-row height="90pt"
																		border-bottom-width="thick">
																		<fo:table-cell>
																			<fo:block font-size="x-small">

																				Empty Container Pickup
																				Depot

																			</fo:block>
																			<fo:block font-size="small" font-weight="bold">
																				<fo:block>

																					<xsl:value-of
																						select="/bookinginfo/emptyContainerPickup/name" />

																				</fo:block>
																				<fo:block>

																					<xsl:value-of
																						select="/bookinginfo/emptyContainerPickup/address" />

																				</fo:block>
																				<fo:block>
																					<xsl:if test="/bookinginfo/emptyContainerPickup/city">
																						<xsl:value-of
																							select="/bookinginfo/emptyContainerPickup/city/name" />
																						<xsl:text> , </xsl:text>



																						<xsl:value-of
																							select="/bookinginfo/emptyContainerPickup/city/stateName" />
																						<xsl:text> , </xsl:text>



																						<xsl:value-of
																							select="/bookinginfo/emptyContainerPickup/city/countryName" />
																					</xsl:if>
																				</fo:block>
																			</fo:block>
																		</fo:table-cell>
																	</fo:table-row>
																	<fo:table-row height="10pt"
																		border-bottom-width="thick">
																		<fo:table-cell>
																			<fo:block space-before="1em" font-weight="normal"
																				font-size="x-small">
																				Empty Container Pickup Date:
																				<fo:inline font-weight="bold">
																					<xsl:value-of select="/bookinginfo/emptyPickupDate" />
																				</fo:inline>
																			</fo:block>
																		</fo:table-cell>
																	</fo:table-row>
																</fo:table-body>
															</fo:table>






														</fo:table-cell>
														<fo:table-cell padding-left="1mm"
															border-style="inset" border-width="0pt" padding="0pt"
															background-repeat="repeat" border-right="0pt"
															border-bottom="1pt" border-color="grey">





															<fo:table display-align="before" width="100%"
																border-style="inset" border-width="0pt" border-color="grey">
																<fo:table-column column-width="100%" />

																<!-- <fo:table-column column-width="50%" /> <fo:table-column 
																	column-width="50%" /> -->
																<fo:table-body>
																	<fo:table-row height="90pt"
																		border-bottom-width="thick">
																		<fo:table-cell>
																			<fo:block font-size="x-small">

																				Ingate At Terminal

																			</fo:block>
																			<fo:block font-size="small" font-weight="bold">
																				<fo:block>


																					<xsl:value-of select="/bookinginfo/ingateAtTerminal/name" />

																				</fo:block>
																				<fo:block>


																					<xsl:value-of
																						select="/bookinginfo/ingateAtTerminal/address" />

																				</fo:block>

																				<fo:block>
																					<xsl:if test="/bookinginfo/ingateAtTerminal/city">

																						<xsl:value-of
																							select="/bookinginfo/ingateAtTerminal/city/name" />
																						<xsl:text> , </xsl:text>


																						<xsl:value-of
																							select="/bookinginfo/ingateAtTerminal/city/stateName" />

																						<xsl:text> , </xsl:text>

																						<xsl:value-of
																							select="/bookinginfo/ingateAtTerminal/city/countryName" />
																					</xsl:if>
																				</fo:block>

																			</fo:block>
																		</fo:table-cell>
																	</fo:table-row>
																	<fo:table-row height="10pt"
																		border-bottom-width="thick">
																		<fo:table-cell>
																			<fo:block space-before="1em" font-weight="normal"
																				font-size="x-small">
																				Early Receiving Date:
																				<fo:inline font-weight="bold">
																					<xsl:value-of select="/bookinginfo/earlyReceivingDate" />
																				</fo:inline>
																			</fo:block>
																		</fo:table-cell>
																	</fo:table-row>
																</fo:table-body>
															</fo:table>



														</fo:table-cell>
													</fo:table-row>

													<fo:table-row height="100pt">
														<fo:table-cell padding-left="1mm"
															border-style="inset" border-width="0pt" padding="0pt"
															background-repeat="repeat" border-right="1pt"
															border-color="grey">
															<fo:block font-size="x-small">

																Cargo Supplier

															</fo:block>
															<fo:block font-size="small" font-weight="bold">

																<fo:block>

																	<xsl:value-of select="/bookinginfo/cargoSupplier/name" />

																</fo:block>
																<fo:block>


																	<xsl:value-of select="/bookinginfo/cargoSupplier/address" />
																</fo:block>
																<fo:block>
																	<xsl:if test="/bookinginfo/cargoSupplier/city">

																		<xsl:value-of select="/bookinginfo/cargoSupplier/city/name" />
																		<xsl:text> , </xsl:text>

																		<xsl:value-of
																			select="/bookinginfo/cargoSupplier/city/stateName" />
																		<xsl:text> , </xsl:text>



																		<xsl:value-of
																			select="/bookinginfo/cargoSupplier/city/countryName" />
																	</xsl:if>
																</fo:block>
															</fo:block>
														</fo:table-cell>
														<fo:table-cell padding-left="1mm">
															<fo:block font-size="x-small">

																Service Provider

															</fo:block>
															<fo:block font-size="small" font-weight="bold">
																<fo:block>



																</fo:block>
																<fo:block>



																</fo:block>
															</fo:block>
														</fo:table-cell>
													</fo:table-row>
												</fo:table-body>
											</fo:table>


										</fo:block>
									</fo:table-cell>
								</fo:table-row>

							</fo:table-body>
						</fo:table>

						<fo:table text-indent="2pt" width="100%" border-style="inset"
							border-width="1pt" border-color="grey" border-top="0pt">
							<fo:table-column column-width="20%" />
							<fo:table-column column-width="20%" />
							<fo:table-column column-width="30%" />
							<fo:table-column column-width="30%" />
							<fo:table-body>
								<fo:table-row border-style="inset" border-color="grey">
									<fo:table-cell border-color="grey" border-style="inset"
										border-right="1pt" border-bottom="0pt">
										<fo:block font-size="x-small">

											Place Of Receipt

										</fo:block>
										<fo:block font-size="small" font-weight="bold">
											<fo:block>

												<xsl:value-of select="/bookinginfo/placeOfReceipt/name" />

											</fo:block>

										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-color="grey" border-style="inset"
										border-right="0pt" border-bottom="0pt">
										<fo:block font-size="x-small">

											Port Of Loading

										</fo:block>
										<fo:block font-size="small" font-weight="bold">
											<fo:block>

												<xsl:value-of select="/bookinginfo/portOfLoad/name" />

											</fo:block>

										</fo:block>
									</fo:table-cell>

									<fo:table-cell border-color="grey" border-style="inset"
										border-right="1pt" border-bottom="0pt">
										<fo:block font-size="x-small">Vessel</fo:block>
										<fo:block font-size="small" font-weight="bold">
											<xsl:value-of select="/bookinginfo/vessel/name" />

										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-style="inset"
										border-bottom="0pt" border-color="grey">
										<fo:block font-size="x-small">Voyage No</fo:block>
										<fo:block font-size="small" font-weight="bold"
											border-bottom="0pt">
											<xsl:value-of select="/bookinginfo/carrierVoyage" />
										</fo:block>
									</fo:table-cell>

								</fo:table-row>


							</fo:table-body>

						</fo:table>

						<fo:table text-indent="2pt" width="100%" border-style="inset"
							border-width="0pt" border-top="0pt">
							<fo:table-column column-width="20%" />
							<fo:table-column column-width="20%" />
							<fo:table-column column-width="15%" />
							<fo:table-column column-width="15%" />
							<fo:table-column column-width="15%" />
							<fo:table-column column-width="15%" />
							<fo:table-body>


								<fo:table-row height="auto">
									<fo:table-cell border-color="grey" border-style="inset"
										border-right="1pt" border-top="0pt">
										<fo:block font-size="x-small">

											Port Of Discharge

										</fo:block>
										<fo:block font-size="small" font-weight="bold">
											<fo:block>

												<xsl:value-of select="/bookinginfo/portOfDischarge/name" />

											</fo:block>

										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-color="grey" border-style="inset"
										border-right="1pt" border-top="0pt">
										<fo:block font-size="x-small">

											Place Of Delivery

										</fo:block>
										<fo:block font-size="small" font-weight="bold">
											<fo:block>

												<xsl:value-of select="/bookinginfo/placeOfDelivery/name" />

											</fo:block>

										</fo:block>
									</fo:table-cell>



									<fo:table-cell border-color="grey" border-style="inset"
										border-right="1pt" border-bottom="1pt" border-top="0pt">
										<fo:block font-size="x-small">Port Cut Off Date</fo:block>
										<fo:block font-size="small" font-weight="bold">
											<xsl:value-of select="/bookinginfo/portCutOffDate" />

										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-color="grey" border-style="inset"
										border-right="1pt" border-bottom="1pt" border-top="0pt">
										<fo:block font-size="x-small">Docs Cut Off Date</fo:block>
										<fo:block font-size="small" font-weight="bold">
											<xsl:value-of select="/bookinginfo/docsCutOffDateTime" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-color="grey" border-style="inset"
										border-right="1pt" border-bottom="1pt" border-top="0pt">
										<fo:block font-size="x-small">ETD</fo:block>
										<fo:block font-size="small" font-weight="bold">
											<xsl:value-of select="/bookinginfo/sailDate" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-width="0pt" border-style="inset"
										border-bottom="1pt" border-color="grey" border-right="1pt"
										border-top="0pt">
										<fo:block font-size="x-small">ETA</fo:block>
										<fo:block font-size="small" font-weight="bold">
											<xsl:value-of select="/bookinginfo/eta" />
										</fo:block>
									</fo:table-cell>












								</fo:table-row>
							</fo:table-body>

						</fo:table>

						<!-- Tableeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee -->

						<fo:block text-indent="2pc" space-after="7pt"
							space-before.minimum="6pt" space-before.optimum="8pt"
							space-before.maximum="10pt">
						</fo:block>
						<fo:block>

							<fo:table text-indent="2pt" width="100%" border-style="inset"
								border-width="1pt" border-color="grey" border-top="1pt"
								border-bottom="0pt">
								<fo:table-column column-width="50%" />
								<fo:table-column column-width="50%" />

								<fo:table-body>
									<fo:table-row>
										<fo:table-cell border-color="grey" border-style="inset"
											border-right="1pt" border-bottom="0pt">
											<fo:block font-size="x-small">

												Number/Type of Containers

											</fo:block>
											<fo:block font-size="small" font-weight="bold">
												<fo:block>


												</fo:block>

											</fo:block>
										</fo:table-cell>
										<fo:table-cell border-color="grey" border-style="inset"
											border-right="1pt" border-bottom="0pt">
											<fo:block font-size="x-small">

												Commodity

											</fo:block>

										</fo:table-cell>

									</fo:table-row>
									<fo:table-row>
										<fo:table-cell border-color="grey" border-style="inset"
											border-right="1pt" border-bottom="0pt">
											<fo:block font-size="small" font-weight="bold">
												<!-- type container value comes here TBD -->
												<xsl:for-each select="bookinginfo/containerTypes">
													<fo:block>
														<xsl:value-of select="noOfContainer" />
														X
														<xsl:value-of select="containerType" />
													</fo:block>
												</xsl:for-each>


											</fo:block>

										</fo:table-cell>
										<fo:table-cell border-color="grey" border-style="inset"
											border-right="1pt" border-bottom="0pt">
											<fo:block font-size="small" font-weight="bold">
												<!-- commodity value comes here TBD -->
												<xsl:for-each select="bookinginfo/containerTypes">
													<fo:block>
														<xsl:value-of select="commodity" />
													</fo:block>
												</xsl:for-each>

											</fo:block>

										</fo:table-cell>

									</fo:table-row>
								</fo:table-body>

							</fo:table>
						</fo:block>

						<!-- Tableeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee -->

						<fo:block>
							<fo:table width="100%" border-style="inset"
								border-width="1pt" border-color="grey" border-top="1pt">
								<fo:table-column />


								<fo:table-body>
									<fo:table-row>
										<fo:table-cell padding-left="1mm" border-color="grey"
											border-style="inset" border-right="1pt" border-top="0pt"
											border-bottom="1pt">
											<fo:block font-size="x-small">

												Remarks

											</fo:block>
											<fo:block font-size="x-small" font-weight="bold">
												<fo:block linefeed-treatment="preserve"
													white-space-treatment="preserve" white-space-collapse="false">

													<!-- <xsl:call-template name="split"> <xsl:with-param name="text" 
														select="/bookinginfo/remarks" /> </xsl:call-template> -->

													<xsl:variable name="text1">
														<xsl:call-template name="string-replace-all">
															<xsl:with-param name="text"
																select="/bookinginfo/remarks" />
															<xsl:with-param name="replace" select="'\n'" />
															<xsl:with-param name="by" select="'&#xA;'" />
														</xsl:call-template>
													</xsl:variable>
													<xsl:call-template name="string-replace-all">
														<xsl:with-param name="text" select="$text1" />
														<xsl:with-param name="replace" select="'\t'" />
														<xsl:with-param name="by" select="'&#x9;'" />
													</xsl:call-template>

												</fo:block>

											</fo:block>
										</fo:table-cell>


									</fo:table-row>

								</fo:table-body>

							</fo:table>
						</fo:block>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template name="split">
		<xsl:param name="text" select="." />

		<xsl:if test="string-length($text) > 0">
			<xsl:variable name="output-text">
				<xsl:value-of
					select="normalize-space(substring-before(concat($text, '\n'), '\n'))" />
			</xsl:variable>

			<xsl:if test="normalize-space($output-text) != ''">
				<xsl:value-of select="$output-text" />
				<xsl:text>&#xA;</xsl:text>
			</xsl:if>

			<xsl:call-template name="split">
				<xsl:with-param name="text" select="substring-after($text, '\n')" />
			</xsl:call-template>
		</xsl:if>
	</xsl:template>

	<xsl:template name="string-replace-all">
		<xsl:param name="text" />
		<xsl:param name="replace" />
		<xsl:param name="by" />
		<xsl:choose>
			<xsl:when test="$text = '' or $replace = ''or not($replace)">
				<!-- Prevent this routine from hanging -->
				<xsl:value-of select="$text" />
			</xsl:when>
			<xsl:when test="contains($text, $replace)">
				<xsl:value-of select="substring-before($text,$replace)" />
				<xsl:value-of select="$by" />
				<xsl:call-template name="string-replace-all">
					<xsl:with-param name="text"
						select="substring-after($text,$replace)" />
					<xsl:with-param name="replace" select="$replace" />
					<xsl:with-param name="by" select="$by" />
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$text" />
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>


</xsl:stylesheet>