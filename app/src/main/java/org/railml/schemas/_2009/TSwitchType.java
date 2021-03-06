//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.06 at 11:34:29 AM CET 
//


package org.railml.schemas._2009;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tSwitchType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tSwitchType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ordinarySwitch"/>
 *     &lt;enumeration value="insideCurvedSwitch"/>
 *     &lt;enumeration value="outsideCurvedSwitch"/>
 *     &lt;enumeration value="threeWaySwitch"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tSwitchType")
@XmlEnum
public enum TSwitchType {

    @XmlEnumValue("ordinarySwitch")
    ORDINARY_SWITCH("ordinarySwitch"),
    @XmlEnumValue("insideCurvedSwitch")
    INSIDE_CURVED_SWITCH("insideCurvedSwitch"),
    @XmlEnumValue("outsideCurvedSwitch")
    OUTSIDE_CURVED_SWITCH("outsideCurvedSwitch"),
    @XmlEnumValue("threeWaySwitch")
    THREE_WAY_SWITCH("threeWaySwitch");
    private final String value;

    TSwitchType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TSwitchType fromValue(String v) {
        for (TSwitchType c: TSwitchType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
