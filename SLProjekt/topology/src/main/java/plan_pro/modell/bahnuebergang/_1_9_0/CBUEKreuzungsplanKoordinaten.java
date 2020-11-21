//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDGEOPunktOhneProxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBUE_Kreuzungsplan_Koordinaten complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Kreuzungsplan_Koordinaten">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_GEO_Punkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_GEO_Punkt_ohne_Proxy"/>
 *         &lt;element name="Pixel_Koordinate_X" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCPixel_Koordinate_X"/>
 *         &lt;element name="Pixel_Koordinate_Y" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCPixel_Koordinate_Y"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Kreuzungsplan_Koordinaten", propOrder = {
    "idgeoPunkt",
    "pixelKoordinateX",
    "pixelKoordinateY"
})
public class CBUEKreuzungsplanKoordinaten {

    @XmlElement(name = "ID_GEO_Punkt", required = true)
    protected TCIDGEOPunktOhneProxy idgeoPunkt;
    @XmlElement(name = "Pixel_Koordinate_X", required = true)
    protected TCPixelKoordinateX pixelKoordinateX;
    @XmlElement(name = "Pixel_Koordinate_Y", required = true)
    protected TCPixelKoordinateY pixelKoordinateY;

    /**
     * Ruft den Wert der idgeoPunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGEOPunktOhneProxy }
     *     
     */
    public TCIDGEOPunktOhneProxy getIDGEOPunkt() {
        return idgeoPunkt;
    }

    /**
     * Legt den Wert der idgeoPunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGEOPunktOhneProxy }
     *     
     */
    public void setIDGEOPunkt(TCIDGEOPunktOhneProxy value) {
        this.idgeoPunkt = value;
    }

    /**
     * Ruft den Wert der pixelKoordinateX-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPixelKoordinateX }
     *     
     */
    public TCPixelKoordinateX getPixelKoordinateX() {
        return pixelKoordinateX;
    }

    /**
     * Legt den Wert der pixelKoordinateX-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPixelKoordinateX }
     *     
     */
    public void setPixelKoordinateX(TCPixelKoordinateX value) {
        this.pixelKoordinateX = value;
    }

    /**
     * Ruft den Wert der pixelKoordinateY-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPixelKoordinateY }
     *     
     */
    public TCPixelKoordinateY getPixelKoordinateY() {
        return pixelKoordinateY;
    }

    /**
     * Legt den Wert der pixelKoordinateY-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPixelKoordinateY }
     *     
     */
    public void setPixelKoordinateY(TCPixelKoordinateY value) {
        this.pixelKoordinateY = value;
    }

}
