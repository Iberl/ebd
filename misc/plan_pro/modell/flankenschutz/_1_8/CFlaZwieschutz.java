//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.flankenschutz._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDWKrGspElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Beschreibung der Verhaltensweise einer Zwieschutzweiche, wenn sie gleichzeitig in beiden Stellungen f�r den Flankenschutz angefordert wird. DB-Regelwerk Zwieschutzweichentabelle
 * 
 * <p>Java-Klasse f�r CFla_Zwieschutz complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFla_Zwieschutz">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Fla_Zwieschutz_Element" type="{http://www.plan-pro.org/modell/Flankenschutz/1.8.0}CFla_Zwieschutz_Element"/>
 *         &lt;element name="ID_W_Element" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_W_Kr_Gsp_Element"/>
 *         &lt;element name="Zwieschutz_Art" type="{http://www.plan-pro.org/modell/Flankenschutz/1.8.0}TCZwieschutz_Art"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFla_Zwieschutz", propOrder = {
    "flaZwieschutzElement",
    "idwElement",
    "zwieschutzArt"
})
public class CFlaZwieschutz
    extends CBasisObjekt
{

    @XmlElement(name = "Fla_Zwieschutz_Element", required = true)
    protected CFlaZwieschutzElement flaZwieschutzElement;
    @XmlElement(name = "ID_W_Element", required = true)
    protected TCIDWKrGspElement idwElement;
    @XmlElement(name = "Zwieschutz_Art", required = true)
    protected TCZwieschutzArt zwieschutzArt;

    /**
     * Ruft den Wert der flaZwieschutzElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFlaZwieschutzElement }
     *     
     */
    public CFlaZwieschutzElement getFlaZwieschutzElement() {
        return flaZwieschutzElement;
    }

    /**
     * Legt den Wert der flaZwieschutzElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFlaZwieschutzElement }
     *     
     */
    public void setFlaZwieschutzElement(CFlaZwieschutzElement value) {
        this.flaZwieschutzElement = value;
    }

    /**
     * Ruft den Wert der idwElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public TCIDWKrGspElement getIDWElement() {
        return idwElement;
    }

    /**
     * Legt den Wert der idwElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public void setIDWElement(TCIDWKrGspElement value) {
        this.idwElement = value;
    }

    /**
     * Ruft den Wert der zwieschutzArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZwieschutzArt }
     *     
     */
    public TCZwieschutzArt getZwieschutzArt() {
        return zwieschutzArt;
    }

    /**
     * Legt den Wert der zwieschutzArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZwieschutzArt }
     *     
     */
    public void setZwieschutzArt(TCZwieschutzArt value) {
        this.zwieschutzArt = value;
    }

}
