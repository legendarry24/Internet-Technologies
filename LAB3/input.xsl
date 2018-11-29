<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:tns="http://sherbakov.nure.ua/practice7/entity">
	<xsl:template match="/tns:Flowers">
		<html>
			<head>
				<title>Flowers</title>
				<style type="text/css">
					td {border: 2px solid green; padding: 6px;}
					table{
					border: 2px solid green;
					float: left;
					margin-left:60px;
					}
				</style>
			</head>
			<body>
				<title>Flower</title>
				<xsl:apply-templates select="Flower" />
			</body>
		</html>
	</xsl:template>

	<xsl:template match="Flower">
		<table>
			<tr>
				<td>
					Flower:
				</td>
				<td>
					<xsl:value-of select="@Id" />
				</td>
			</tr>
			<tr>
				<td>
					Name:
				</td>
				<td>
					<xsl:value-of select="Name" />
				</td>
			</tr>
			<tr>
				<td>
					Soil:
				</td>
				<td>
					<xsl:value-of select="@Soil" />
				</td>
			</tr>
			<tr>
				<td>
					Origin:
				</td>
				<td>
					<xsl:value-of select="Origin" />
				</td>
			</tr>
			<tr>
				<td>
					Visual Parameters:
				</td>
				<td>
					<xsl:apply-templates select="VisualParameters" />
				</td>
			</tr>
			<tr>
				<td>
					Groving Tips:
				</td>
				<td>
					<xsl:apply-templates select="GrovingTips" />
				</td>
			</tr>
			<tr>
				<td>
					Multipling:
				</td>
				<td>
					<xsl:value-of select="Multipling" />
				</td>
			</tr>
		</table>
	</xsl:template>

	<xsl:template match="VisualParameters">
		<table>
			<tr>
				<td>
					Stalk Color:
				</td>
				<td>
					<xsl:value-of select="StalkColor" />
				</td>
			</tr>
			<tr>
				<td>
					Color of leaves:
				</td>
				<td>
					<xsl:value-of select="ColorOfLeaves" />
				</td>
			</tr>
			<tr>
				<td>
					Average plant size:
				</td>
				<td>
					<xsl:value-of select="AveragePlantSize" />
				</td>
			</tr>
		</table>
	</xsl:template>

	<xsl:template match="GrovingTips">
		<table>
			<tr>
				<td>
					Temperature:
				</td>
				<td>
					<xsl:value-of select="Temperature" />
				</td>
			</tr>
			<tr>
				<td>
					Lighting:
				</td>
				<td>
					<xsl:value-of select="Lighting" />
				</td>
			</tr>
			<tr>
				<td>
					Watering:
				</td>
				<td>
					<xsl:value-of select="Watering" />
				</td>
			</tr>
		</table>
	</xsl:template>
</xsl:stylesheet>