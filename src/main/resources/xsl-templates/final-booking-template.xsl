<?xml version="1.0"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:s="http://www.stylusstudio.com/xquery"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="default-page"
					page-height="11in" page-width="8.5in" margin-left="0.6in"
					margin-right="0.6in" margin-top="0.79in" margin-bottom="0.79in">
					<fo:region-body />
				</fo:simple-page-master>
			</fo:layout-master-set>
		 <fo:page-sequence master-reference="default-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        <fo:table width="50%" border-style="outset" border-width="0pt" background-repeat="repeat">
                            <fo:table-column column-width="0pt"/>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell border-style="inset" border-width="0pt" padding="0pt" background-repeat="repeat" display-align="center">
                                        <fo:block>
                                            <fo:external-graphic background="transparent" width="350pt" content-width="scale-to-fit" height="70pt" content-height="scale-to-fit" scaling="non-uniform" src="url(file:///c:/My%20Drive/WORKSPACEs/Logistics/logistics/src/main/resources/xsl-templates/li-logo.jpg)"/>
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