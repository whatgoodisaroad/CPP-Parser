//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.06.08 at 09:15:46 PM PDT 
//


package tosc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Let complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Let">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="binding" type="{}Binding"/>
 *         &lt;element name="body">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{}object"/>
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
@XmlType(name = "Let", propOrder = {
    "binding",
    "body"
})
public class Let {

    @XmlElement(required = true)
    protected Binding binding;
    @XmlElement(required = true)
    protected Let.Body body;

    /**
     * Gets the value of the binding property.
     * 
     * @return
     *     possible object is
     *     {@link Binding }
     *     
     */
    public Binding getBinding() {
        return binding;
    }

    /**
     * Sets the value of the binding property.
     * 
     * @param value
     *     allowed object is
     *     {@link Binding }
     *     
     */
    public void setBinding(Binding value) {
        this.binding = value;
    }

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link Let.Body }
     *     
     */
    public Let.Body getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link Let.Body }
     *     
     */
    public void setBody(Let.Body value) {
        this.body = value;
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
     *         &lt;element ref="{}object"/>
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
        "object"
    })
    public static class Body {

        @XmlElementRef(name = "object", type = JAXBElement.class)
        protected JAXBElement<?> object;

        /**
         * Gets the value of the object property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link Variable }{@code >}
         *     {@link JAXBElement }{@code <}{@link java.lang.Object }{@code >}
         *     {@link JAXBElement }{@code <}{@link Choice }{@code >}
         *     {@link JAXBElement }{@code <}{@link Part }{@code >}
         *     {@link JAXBElement }{@code <}{@link Let }{@code >}
         *     
         */
        public JAXBElement<?> getObject() {
            return object;
        }

        /**
         * Sets the value of the object property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link Variable }{@code >}
         *     {@link JAXBElement }{@code <}{@link java.lang.Object }{@code >}
         *     {@link JAXBElement }{@code <}{@link Choice }{@code >}
         *     {@link JAXBElement }{@code <}{@link Part }{@code >}
         *     {@link JAXBElement }{@code <}{@link Let }{@code >}
         *     
         */
        public void setObject(JAXBElement<?> value) {
            this.object = ((JAXBElement<?> ) value);
        }

    }

}
