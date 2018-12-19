
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
 * &lt;complexType name="GrovingTips">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Temperature" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Lighting" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Watering" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
		return "GrovingTips [temperature=" + temperature + ", lighting=" + lighting + ", watering=" + watering + "]";
	}

}
