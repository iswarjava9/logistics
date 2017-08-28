<?xml version="1.0"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:s="http://www.stylusstudio.com/xquery">
    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="default-page" page-height="11in" page-width="8.5in" margin-left="0.2in" margin-right="0.2in" margin-top="0.2in" margin-bottom="0.2in">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="default-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/carrierBookingNo"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/carrierVoyage"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/forwarderRefNo"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/shipperRefNo"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/bookingDate"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/delieveryEta"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/shipper/name"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/shipper/address"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/loadTerminal/name"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/placeOfDelivery/name"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/portOfDischarge/name"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/portOfLoad/name"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/forwarder/name"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/forwarder/address"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/vessel/name"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/carrier/name"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/bookinginfo/carrier/address"/>
                        </fo:block>
                        <fo:block>
                            <xsl:text>&#xA0;</xsl:text>
                        </fo:block>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>