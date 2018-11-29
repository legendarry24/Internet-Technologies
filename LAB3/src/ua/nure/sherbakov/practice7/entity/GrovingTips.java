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
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for GrovingTips complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="GrovingTips"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="Temperature" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *               &lt;maxInclusive value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Lighting" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="Watering" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GrovingTips", propOrder = {

})
public class GrovingTips {

	@XmlElement(name = "Temperature")
	protected Integer temperature;
	@XmlElement(name = "Lighting")
	protected Boolean lighting;
	@XmlElement(name = "Watering")
	protected Integer watering;

	/**
	 * Gets the value of the temperature property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getTemperature() {
		return temperature;
	}

	/**
	 * Sets the value of the temperature property.
	 * 
	 * @param value allowed object is {@link Integer }
	 * 
	 */
	public void setTemperature(Integer value) {
		this.temperature = value;
	}

	/**
	 * Gets the value of the lighting property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isLighting() {
		return lighting;
	}

	/**
	 * Sets the value of the lighting property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 * 
	 */
	public void setLighting(Boolean value) {
		this.lighting = value;
	}

	/**
	 * Gets the value of the watering property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getWatering() {
		return watering;
	}

	/**
	 * Sets the value of the watering property.
	 * 
	 * @param value allowed object is {@link Integer }
	 * 
	 */
	public void setWatering(Integer value) {
		this.watering = value;
	}

	@Override
	public String toString() {
		return "[temperature=" + temperature + ", lighting=" + lighting + ", watering=" + watering + "]";
	}

}
