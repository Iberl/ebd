//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.signale._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDBlockElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSignal_Fstr complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_Fstr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Besetzte_Ausfahrt" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}TCBesetzte_Ausfahrt" minOccurs="0"/>
 *         &lt;element name="DA_Manuell" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}TCDA_Manuell" minOccurs="0"/>
 *         &lt;element name="Durchfahrt" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}TCDurchfahrt" minOccurs="0"/>
 *         &lt;element name="ID_RaZiel_Erlaubnisabhaengig" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Block_Element" minOccurs="0"/>
 *         &lt;element name="Rangierstrasse_Restaufloesung" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}TCRangierstrasse_Restaufloesung" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_Fstr", propOrder = {
    "besetzteAusfahrt",
    "daManuell",
    "durchfahrt",
    "idRaZielErlaubnisabhaengig",
    "rangierstrasseRestaufloesung"
})
public class CSignalFstr {

    @XmlElement(name = "Besetzte_Ausfahrt")
    protected TCBesetzteAusfahrt besetzteAusfahrt;
    @XmlElement(name = "DA_Manuell")
    protected TCDAManuell daManuell;
    @XmlElement(name = "Durchfahrt")
    protected TCDurchfahrt durchfahrt;
    @XmlElement(name = "ID_RaZiel_Erlaubnisabhaengig")
    protected TCIDBlockElement idRaZielErlaubnisabhaengig;
    @XmlElement(name = "Rangierstrasse_Restaufloesung")
    protected TCRangierstrasseRestaufloesung rangierstrasseRestaufloesung;

    /**
     * Ruft den Wert der besetzteAusfahrt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBesetzteAusfahrt }
     *     
     */
    public TCBesetzteAusfahrt getBesetzteAusfahrt() {
        return besetzteAusfahrt;
    }

    /**
     * Legt den Wert der besetzteAusfahrt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBesetzteAusfahrt }
     *     
     */
    public void setBesetzteAusfahrt(TCBesetzteAusfahrt value) {
        this.besetzteAusfahrt = value;
    }

    /**
     * Ruft den Wert der daManuell-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDAManuell }
     *     
     */
    public TCDAManuell getDAManuell() {
        return daManuell;
    }

    /**
     * Legt den Wert der daManuell-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDAManuell }
     *     
     */
    public void setDAManuell(TCDAManuell value) {
        this.daManuell = value;
    }

    /**
     * Ruft den Wert der durchfahrt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDurchfahrt }
     *     
     */
    public TCDurchfahrt getDurchfahrt() {
        return durchfahrt;
    }

    /**
     * Legt den Wert der durchfahrt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDurchfahrt }
     *     
     */
    public void setDurchfahrt(TCDurchfahrt value) {
        this.durchfahrt = value;
    }

    /**
     * Ruft den Wert der idRaZielErlaubnisabhaengig-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBlockElement }
     *     
     */
    public TCIDBlockElement getIDRaZielErlaubnisabhaengig() {
        return idRaZielErlaubnisabhaengig;
    }

    /**
     * Legt den Wert der idRaZielErlaubnisabhaengig-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBlockElement }
     *     
     */
    public void setIDRaZielErlaubnisabhaengig(TCIDBlockElement value) {
        this.idRaZielErlaubnisabhaengig = value;
    }

    /**
     * Ruft den Wert der rangierstrasseRestaufloesung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRangierstrasseRestaufloesung }
     *     
     */
    public TCRangierstrasseRestaufloesung getRangierstrasseRestaufloesung() {
        return rangierstrasseRestaufloesung;
    }

    /**
     * Legt den Wert der rangierstrasseRestaufloesung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRangierstrasseRestaufloesung }
     *     
     */
    public void setRangierstrasseRestaufloesung(TCRangierstrasseRestaufloesung value) {
        this.rangierstrasseRestaufloesung = value;
    }

}
