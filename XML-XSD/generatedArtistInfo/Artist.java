//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.09.24 at 10:56:00 AM CEST 
//


package generated;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element ref="{}tags"/>
 *           &lt;element ref="{}bio"/>
 *         &lt;/sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element ref="{}image"/>
 *           &lt;element ref="{}mbid"/>
 *           &lt;element ref="{}name"/>
 *           &lt;element ref="{}ontour"/>
 *           &lt;element ref="{}similar"/>
 *           &lt;element ref="{}stats"/>
 *           &lt;element ref="{}streamable"/>
 *           &lt;element ref="{}url"/>
 *         &lt;/choice>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tags",
    "bio",
    "imageOrMbidOrName"
})
@XmlRootElement(name = "artist")
public class Artist {

    protected Tags tags;
    protected Bio bio;
    @XmlElementRefs({
        @XmlElementRef(name = "stats", type = Stats.class, required = false),
        @XmlElementRef(name = "similar", type = Similar.class, required = false),
        @XmlElementRef(name = "image", type = Image.class, required = false),
        @XmlElementRef(name = "mbid", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "streamable", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "url", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "name", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ontour", type = JAXBElement.class, required = false)
    })
    protected List<Object> imageOrMbidOrName;

    /**
     * Gets the value of the tags property.
     * 
     * @return
     *     possible object is
     *     {@link Tags }
     *     
     */
    public Tags getTags() {
        return tags;
    }

    /**
     * Sets the value of the tags property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tags }
     *     
     */
    public void setTags(Tags value) {
        this.tags = value;
    }

    /**
     * Gets the value of the bio property.
     * 
     * @return
     *     possible object is
     *     {@link Bio }
     *     
     */
    public Bio getBio() {
        return bio;
    }

    /**
     * Sets the value of the bio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bio }
     *     
     */
    public void setBio(Bio value) {
        this.bio = value;
    }

    /**
     * Gets the value of the imageOrMbidOrName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the imageOrMbidOrName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImageOrMbidOrName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Stats }
     * {@link Similar }
     * {@link Image }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * 
     */
    public List<Object> getImageOrMbidOrName() {
        if (imageOrMbidOrName == null) {
            imageOrMbidOrName = new ArrayList<Object>();
        }
        return this.imageOrMbidOrName;
    }

}
