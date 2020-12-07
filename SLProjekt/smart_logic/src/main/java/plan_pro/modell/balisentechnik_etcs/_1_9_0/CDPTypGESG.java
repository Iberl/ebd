//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CDP_Typ_GESG complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CDP_Typ_GESG">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bremsweg" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCBremsweg"/>
 *         &lt;element name="DP_Typ_ESG" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDP_Typ_ESG"/>
 *         &lt;element name="Individuell" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCIndividuell" minOccurs="0"/>
 *         &lt;element name="Lfd_Nr_Am_Bezugspunkt" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCLfd_Nr_Am_Bezugspunkt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CDP_Typ_GESG", propOrder = {
    "bremsweg",
    "dpTypESG",
    "individuell",
    "lfdNrAmBezugspunkt"
})
public class CDPTypGESG {

    @XmlElement(name = "Bremsweg", required = true)
    protected TCBremsweg bremsweg;
    @XmlElement(name = "DP_Typ_ESG", required = true)
    protected TCDPTypESG dpTypESG;
    @XmlElement(name = "Individuell")
    protected TCIndividuell individuell;
    @XmlElement(name = "Lfd_Nr_Am_Bezugspunkt")
    protected TCLfdNrAmBezugspunkt lfdNrAmBezugspunkt;

    /**
     * Ruft den Wert der bremsweg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBremsweg }
     *     
     */
    public TCBremsweg getBremsweg() {
        return bremsweg;
    }

    /**
     * Legt den Wert der bremsweg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBremsweg }
     *     
     */
    public void setBremsweg(TCBremsweg value) {
        this.bremsweg = value;
    }

    /**
     * Ruft den Wert der dpTypESG-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDPTypESG }
     *     
     */
    public TCDPTypESG getDPTypESG() {
        return dpTypESG;
    }

    /**
     * Legt den Wert der dpTypESG-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDPTypESG }
     *     
     */
    public void setDPTypESG(TCDPTypESG value) {
        this.dpTypESG = value;
    }

    /**
     * Ruft den Wert der individuell-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIndividuell }
     *     
     */
    public TCIndividuell getIndividuell() {
        return individuell;
    }

    /**
     * Legt den Wert der individuell-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIndividuell }
     *     
     */
    public void setIndividuell(TCIndividuell value) {
        this.individuell = value;
    }

    /**
     * Ruft den Wert der lfdNrAmBezugspunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLfdNrAmBezugspunkt }
     *     
     */
    public TCLfdNrAmBezugspunkt getLfdNrAmBezugspunkt() {
        return lfdNrAmBezugspunkt;
    }

    /**
     * Legt den Wert der lfdNrAmBezugspunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLfdNrAmBezugspunkt }
     *     
     */
    public void setLfdNrAmBezugspunkt(TCLfdNrAmBezugspunkt value) {
        this.lfdNrAmBezugspunkt = value;
    }

}
