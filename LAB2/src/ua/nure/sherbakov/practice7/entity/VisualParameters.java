//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0-b170531.0717 
//         See <a href="https://jaxb.java.net/">https://jaxb.java.net/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2018.11.07 at 12:10:04 PM CET 
//

package ua.nure.sherbakov.practice7.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>
 * Java class for VisualParameters complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="VisualParameters"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="StalkColor" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="ColorOfLeaves"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *               &lt;minLength value="3"/&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AveragePlantSize"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minExclusive value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisualParameters", propOrder = { "stalkColor", "colorOfLeaves", "averagePlantSize" })
public class VisualParameters {

	@XmlElement(name = "StalkColor")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "token")
	protected String stalkColor;
	@XmlElement(name = "ColorOfLeaves")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String colorOfLeaves;
	@XmlElement(name = "AveragePlantSize")
	protected Integer averagePlantSize;

	/**
	 * Gets the value of the stalkColor property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStalkColor() {
		return stalkColor;
	}

	/**
	 * Sets the value of the stalkColor property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStalkColor(String value) {
		this.stalkColor = value;
	}

	/**
	 * Gets the value of the colorOfLeaves property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getColorOfLeaves() {
		return colorOfLeaves;
	}

	/**
	 * Sets the value of the colorOfLeaves property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setColorOfLeaves(String value) {
		this.colorOfLeaves = value;
	}

	/**
	 * Gets the value of the averagePlantSize property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getAveragePlantSize() {
		return averagePlantSize;
	}

	/**
	 * Sets the value of the averagePlantSize property.
	 * 
	 * @param value allowed object is {@link Integer }
	 * 
	 */
	public void setAveragePlantSize(Integer value) {
		this.averagePlantSize = value;
	}

	@Override
	public String toString() {
		return "[stalkColor=" + stalkColor + ", colorOfLeaves=" + colorOfLeaves + ", averagePlantSize="
				+ averagePlantSize + "]";
	}

}
