
package ua.nure.sherbakov.practice7.server.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ua.nure.sherbakov.practice7.entity.Flower;

/**
 * <p>
 * Java class for addFlower complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="addFlower">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://practice7.sherbakov.nure.ua/entity}Flowers" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addFlower", propOrder = { "flowers" })
public class AddFlower {

	@XmlElement(name = "Flowers", namespace = "http://practice7.sherbakov.nure.ua/entity")
	protected Flower flowers;

	/**
	 * Gets the value of the flowers property.
	 * 
	 * @return possible object is {@link Flower }
	 * 
	 */
	public Flower getFlowers() {
		return flowers;
	}

	/**
	 * Sets the value of the flowers property.
	 * 
	 * @param value allowed object is {@link Flower }
	 * 
	 */
	public void setFlowers(Flower value) {
		this.flowers = value;
	}

}
