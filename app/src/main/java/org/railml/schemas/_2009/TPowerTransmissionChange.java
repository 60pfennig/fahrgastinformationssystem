//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.06 at 11:34:29 AM CET 
//


package org.railml.schemas._2009;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tPowerTransmissionChange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPowerTransmissionChange">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.railml.org/schemas/2009}tOrientedElement">
 *       &lt;attGroup ref="{http://www.railml.org/schemas/2009}aPowerTransmission"/>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPowerTransmissionChange")
public class TPowerTransmissionChange
    extends TOrientedElement
{

    @XmlAttribute(name = "type")
    protected TPowerTransmissionType type;
    @XmlAttribute(name = "style")
    protected String style;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TPowerTransmissionType }
     *     
     */
    public TPowerTransmissionType getType() {
        if (type == null) {
            return TPowerTransmissionType.ADHESION;
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPowerTransmissionType }
     *     
     */
    public void setType(TPowerTransmissionType value) {
        this.type = value;
    }

    /**
     * Gets the value of the style property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyle(String value) {
        this.style = value;
    }

}