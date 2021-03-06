//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.21 at 04:05:03 PM CEST 
//


package generated.deezer.track;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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

    private final static QName _Readable_QNAME = new QName("", "readable");
    private final static QName _Isrc_QNAME = new QName("", "isrc");
    private final static QName _DiskNumber_QNAME = new QName("", "disk_number");
    private final static QName _Link_QNAME = new QName("", "link");
    private final static QName _Type_QNAME = new QName("", "type");
    private final static QName _Bpm_QNAME = new QName("", "bpm");
    private final static QName _Gain_QNAME = new QName("", "gain");
    private final static QName _Picture_QNAME = new QName("", "picture");
    private final static QName _Id_QNAME = new QName("", "id");
    private final static QName _TrackPosition_QNAME = new QName("", "track_position");
    private final static QName _Cover_QNAME = new QName("", "cover");
    private final static QName _Title_QNAME = new QName("", "title");
    private final static QName _Duration_QNAME = new QName("", "duration");
    private final static QName _Rank_QNAME = new QName("", "rank");
    private final static QName _Preview_QNAME = new QName("", "preview");
    private final static QName _Name_QNAME = new QName("", "name");
    private final static QName _Item_QNAME = new QName("", "item");
    private final static QName _ReleaseDate_QNAME = new QName("", "release_date");
    private final static QName _Radio_QNAME = new QName("", "radio");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Root }
     * 
     */
    public Root createRoot() {
        return new Root();
    }

    /**
     * Create an instance of {@link ExplicitLyrics }
     * 
     */
    public ExplicitLyrics createExplicitLyrics() {
        return new ExplicitLyrics();
    }

    /**
     * Create an instance of {@link AvailableCountries }
     * 
     */
    public AvailableCountries createAvailableCountries() {
        return new AvailableCountries();
    }

    /**
     * Create an instance of {@link Artist }
     * 
     */
    public Artist createArtist() {
        return new Artist();
    }

    /**
     * Create an instance of {@link Album }
     * 
     */
    public Album createAlbum() {
        return new Album();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "readable")
    public JAXBElement<BigInteger> createReadable(BigInteger value) {
        return new JAXBElement<BigInteger>(_Readable_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "isrc")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createIsrc(String value) {
        return new JAXBElement<String>(_Isrc_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "disk_number")
    public JAXBElement<BigInteger> createDiskNumber(BigInteger value) {
        return new JAXBElement<BigInteger>(_DiskNumber_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "link")
    public JAXBElement<String> createLink(String value) {
        return new JAXBElement<String>(_Link_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "type")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createType(String value) {
        return new JAXBElement<String>(_Type_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bpm")
    public JAXBElement<BigDecimal> createBpm(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Bpm_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "gain")
    public JAXBElement<BigDecimal> createGain(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Gain_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "picture")
    public JAXBElement<String> createPicture(String value) {
        return new JAXBElement<String>(_Picture_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id")
    public JAXBElement<BigInteger> createId(BigInteger value) {
        return new JAXBElement<BigInteger>(_Id_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "track_position")
    public JAXBElement<BigInteger> createTrackPosition(BigInteger value) {
        return new JAXBElement<BigInteger>(_TrackPosition_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cover")
    public JAXBElement<String> createCover(String value) {
        return new JAXBElement<String>(_Cover_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "title")
    public JAXBElement<String> createTitle(String value) {
        return new JAXBElement<String>(_Title_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "duration")
    public JAXBElement<BigInteger> createDuration(BigInteger value) {
        return new JAXBElement<BigInteger>(_Duration_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "rank")
    public JAXBElement<BigInteger> createRank(BigInteger value) {
        return new JAXBElement<BigInteger>(_Rank_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "preview")
    public JAXBElement<String> createPreview(String value) {
        return new JAXBElement<String>(_Preview_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "item")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createItem(String value) {
        return new JAXBElement<String>(_Item_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "release_date")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createReleaseDate(String value) {
        return new JAXBElement<String>(_ReleaseDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "radio")
    public JAXBElement<BigInteger> createRadio(BigInteger value) {
        return new JAXBElement<BigInteger>(_Radio_QNAME, BigInteger.class, null, value);
    }

}
