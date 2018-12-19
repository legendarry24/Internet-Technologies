
package ua.nure.sherbakov.practice7.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Multipling.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Multipling">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="leaves"/>
 *     &lt;enumeration value="feces"/>
 *     &lt;enumeration value="seeds"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Multipling")
@XmlEnum
public enum Multipling {

    @XmlEnumValue("leaves")
    LEAVES("leaves"),
    @XmlEnumValue("feces")
    FECES("feces"),
    @XmlEnumValue("seeds")
    SEEDS("seeds");
    private final String value;

    Multipling(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Multipling fromValue(String v) {
        for (Multipling c: Multipling.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
