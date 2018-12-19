
package ua.nure.sherbakov.practice7.server.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ua.nure.sherbakov.practice7.entity.Flower;


/**
 * <p>Java class for getFlowerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getFlowerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://practice7.sherbakov.nure.ua/entity}return" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFlowerResponse", propOrder = {
    "_return"
})
public class GetFlowerResponse {

    @XmlElement(name = "return", namespace = "http://practice7.sherbakov.nure.ua/entity")
    protected Flower _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link Flower }
     *     
     */
    public Flower getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link Flower }
     *     
     */
    public void setReturn(Flower value) {
        this._return = value;
    }

}
