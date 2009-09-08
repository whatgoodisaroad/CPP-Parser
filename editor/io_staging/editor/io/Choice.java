//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.09.08 at 12:28:00 PM PDT 
//


package editor.io;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Choice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dim" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alternatives">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="alternative" type="{}Alternative" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Choice", propOrder = {
    "dim",
    "alternatives"
})
public class Choice {

    @XmlElement(required = true)
    protected String dim;
    @XmlElement(required = true)
    protected Choice.Alternatives alternatives;

    /**
     * Gets the value of the dim property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDim() {
        return dim;
    }

    /**
     * Sets the value of the dim property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDim(String value) {
        this.dim = value;
    }

    /**
     * Gets the value of the alternatives property.
     * 
     * @return
     *     possible object is
     *     {@link Choice.Alternatives }
     *     
     */
    public Choice.Alternatives getAlternatives() {
        return alternatives;
    }

    /**
     * Sets the value of the alternatives property.
     * 
     * @param value
     *     allowed object is
     *     {@link Choice.Alternatives }
     *     
     */
    public void setAlternatives(Choice.Alternatives value) {
        this.alternatives = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="alternative" type="{}Alternative" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "alternative"
    })
    public static class Alternatives {

        @XmlElement(required = true)
        protected List<Alternative> alternative;

        /**
         * Gets the value of the alternative property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the alternative property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAlternative().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Alternative }
         * 
         * 
         */
        public List<Alternative> getAlternative() {
            if (alternative == null) {
                alternative = new ArrayList<Alternative>();
            }
            return this.alternative;
        }

    }

}
