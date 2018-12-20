
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
 * &lt;complexType name="VisualParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StalkColor" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/>
 *         &lt;element name="ColorOfLeaves" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AveragePlantSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
		return "VisualParameters [stalkColor=" + stalkColor + ", colorOfLeaves=" + colorOfLeaves + ", averagePlantSize="
				+ averagePlantSize + "]";
	}

}
