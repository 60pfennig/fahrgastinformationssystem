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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				container for installed train radio systems
 * 			
 * 
 * <p>Java class for tTrainRadio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tTrainRadio">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.railml.org/schemas/2009}tElementWithIDAndName">
 *       &lt;attGroup ref="{http://www.railml.org/schemas/2009}aMonitoringGeneric"/>
 *       &lt;attGroup ref="{http://www.railml.org/schemas/2009}aTrainRadio"/>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTrainRadio")
@XmlSeeAlso({
    ETrainRadio.class
})
public class TTrainRadio
    extends TElementWithIDAndName
{

    @XmlAttribute(name = "onBoardUnitID")
    protected String onBoardUnitID;
    @XmlAttribute(name = "softwareVersion")
    protected String softwareVersion;
    @XmlAttribute(name = "modulation")
    protected String modulation;

    /**
     * Gets the value of the onBoardUnitID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnBoardUnitID() {
        return onBoardUnitID;
    }

    /**
     * Sets the value of the onBoardUnitID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnBoardUnitID(String value) {
        this.onBoardUnitID = value;
    }

    /**
     * Gets the value of the softwareVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoftwareVersion() {
        return softwareVersion;
    }

    /**
     * Sets the value of the softwareVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoftwareVersion(String value) {
        this.softwareVersion = value;
    }

    /**
     * Gets the value of the modulation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModulation() {
        return modulation;
    }

    /**
     * Sets the value of the modulation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModulation(String value) {
        this.modulation = value;
    }

}
