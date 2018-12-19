
package ua.nure.sherbakov.practice7.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ua.nure.sherbakov.practice7.entity package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Flowers_QNAME = new QName("http://practice7.sherbakov.nure.ua/entity", "Flowers");
    private final static QName _Return_QNAME = new QName("http://practice7.sherbakov.nure.ua/entity", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ua.nure.sherbakov.practice7.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Flower }
     * 
     */
    public Flower createFlower() {
        return new Flower();
    }

    /**
     * Create an instance of {@link GrovingTips }
     * 
     */
    public GrovingTips createGrovingTips() {
        return new GrovingTips();
    }

    /**
     * Create an instance of {@link VisualParameters }
     * 
     */
    public VisualParameters createVisualParameters() {
        return new VisualParameters();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Flower }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://practice7.sherbakov.nure.ua/entity", name = "Flowers")
    public JAXBElement<Flower> createFlowers(Flower value) {
        return new JAXBElement<Flower>(_Flowers_QNAME, Flower.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Flower }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://practice7.sherbakov.nure.ua/entity", name = "return")
    public JAXBElement<Flower> createReturn(Flower value) {
        return new JAXBElement<Flower>(_Return_QNAME, Flower.class, null, value);
    }

}
