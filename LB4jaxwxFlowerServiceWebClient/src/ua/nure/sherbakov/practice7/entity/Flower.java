
package ua.nure.sherbakov.practice7.entity;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>
 * Java class for Flower complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Flower">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="Origin" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="VisualParameters" type="{http://sherbakov.nure.ua/practice7/entity}VisualParameters"/>
 *         &lt;element name="GrovingTips" type="{http://sherbakov.nure.ua/practice7/entity}GrovingTips"/>
 *         &lt;element name="Multipling" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Soil" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Flower", propOrder = { "name", "origin", "visualParameters", "grovingTips", "multipling", "price" })
public class Flower {

	@XmlElement(name = "Name", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "token")
	protected String name;
	@XmlElement(name = "Origin", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "token")
	protected String origin;
	@XmlElement(name = "VisualParameters", required = true)
	protected VisualParameters visualParameters;
	@XmlElement(name = "GrovingTips", required = true)
	protected GrovingTips grovingTips;
	@XmlElement(name = "Multipling", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "token")
	protected String multipling;
	@XmlElement(name = "Price", required = true)
	protected BigDecimal price;
	@XmlAttribute(name = "Soil")
	protected String soil;
	@XmlAttribute(name = "Id", required = true)
	protected int id;

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the origin property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Sets the value of the origin property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setOrigin(String value) {
		this.origin = value;
	}

	/**
	 * Gets the value of the visualParameters property.
	 * 
	 * @return possible object is {@link VisualParameters }
	 * 
	 */
	public VisualParameters getVisualParameters() {
		return visualParameters;
	}

	/**
	 * Sets the value of the visualParameters property.
	 * 
	 * @param value allowed object is {@link VisualParameters }
	 * 
	 */
	public void setVisualParameters(VisualParameters value) {
		this.visualParameters = value;
	}

	/**
	 * Gets the value of the grovingTips property.
	 * 
	 * @return possible object is {@link GrovingTips }
	 * 
	 */
	public GrovingTips getGrovingTips() {
		return grovingTips;
	}

	/**
	 * Sets the value of the grovingTips property.
	 * 
	 * @param value allowed object is {@link GrovingTips }
	 * 
	 */
	public void setGrovingTips(GrovingTips value) {
		this.grovingTips = value;
	}

	/**
	 * Gets the value of the multipling property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMultipling() {
		return multipling;
	}

	/**
	 * Sets the value of the multipling property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setMultipling(String value) {
		this.multipling = value;
	}

	/**
	 * Gets the value of the price property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Sets the value of the price property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPrice(BigDecimal value) {
		this.price = value;
	}

	/**
	 * Gets the value of the soil property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSoil() {
		return soil;
	}

	/**
	 * Sets the value of the soil property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setSoil(String value) {
		this.soil = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 */
	public void setId(int value) {
		this.id = value;
	}

	@Override
	public String toString() {
		return "Flower [name=" + name + ", origin=" + origin + ", visualParameters=" + visualParameters
				+ ", grovingTips=" + grovingTips + ", multipling=" + multipling + ", price=" + price + ", soil=" + soil
				+ ", id=" + id + "]";
	}

}
