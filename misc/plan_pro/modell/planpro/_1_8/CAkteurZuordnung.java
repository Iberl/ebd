//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.planpro._1_8;

import modell.basisobjekte._1_8.CAnhang;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Basisattributgruppe zur Zuordnung von Akteur-spezifischen Daten in Abh�ngigkeit von der ausgef�hrten Rolle w�hrend der Lebensdauer einer Planung Einzel. Die Attributgruppe enth�lt allgemeine Attribute, die rollenspezifisch unterschiedliche Bedeutungen haben. Erg�nzende Beschreibung zum Umgang im PlanPro-Planungsprozess Eine Abbildung der (Planungs-)Historie in PlanPro, z. B. jeweilige Ersteller, Pr�fer, etc., ist nicht sinnvoll, da sie auch aufgrund der unterschiedlichen Zuschnitte der Planungsbereiche auch nur sehr schwer umsetzbar w�re. Auch eine Abfrage, welche Ma�nahme als letztes in einem (Anzeige-)Bereich stattgefunden hat, soll nicht vorgesehen werden. Stattdessen k�nnen unter Nutzung des Planungsarchivs der LST-Datenbank bei Bedarf die durchgef�hrten Planungen reproduziert und die darin vorgenommenen Ver�nderungen ausgewertet werden. DB-Regelwerk Schriftfeldeintr�ge gem�� Ril 819.0103
 * 
 * 
 * <p>Java-Klasse f�r CAkteur_Zuordnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CAkteur_Zuordnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Anhang_Dokumentation" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CAnhang" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Datum" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCDatum"/>
 *         &lt;element name="Handelnder" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CAkteur"/>
 *         &lt;element name="Ident_Rolle" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCIdent_Rolle" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CAkteur_Zuordnung", propOrder = {
    "anhangDokumentation",
    "datum",
    "handelnder",
    "identRolle"
})
public class CAkteurZuordnung {

    @XmlElement(name = "Anhang_Dokumentation")
    protected List<CAnhang> anhangDokumentation;
    @XmlElement(name = "Datum", required = true)
    protected TCDatum datum;
    @XmlElement(name = "Handelnder", required = true)
    protected CAkteur handelnder;
    @XmlElement(name = "Ident_Rolle")
    protected TCIdentRolle identRolle;

    /**
     * Gets the value of the anhangDokumentation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anhangDokumentation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnhangDokumentation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAnhang }
     * 
     * 
     */
    public List<CAnhang> getAnhangDokumentation() {
        if (anhangDokumentation == null) {
            anhangDokumentation = new ArrayList<CAnhang>();
        }
        return this.anhangDokumentation;
    }

    /**
     * Ruft den Wert der datum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDatum }
     *     
     */
    public TCDatum getDatum() {
        return datum;
    }

    /**
     * Legt den Wert der datum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDatum }
     *     
     */
    public void setDatum(TCDatum value) {
        this.datum = value;
    }

    /**
     * Ruft den Wert der handelnder-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CAkteur }
     *     
     */
    public CAkteur getHandelnder() {
        return handelnder;
    }

    /**
     * Legt den Wert der handelnder-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CAkteur }
     *     
     */
    public void setHandelnder(CAkteur value) {
        this.handelnder = value;
    }

    /**
     * Ruft den Wert der identRolle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIdentRolle }
     *     
     */
    public TCIdentRolle getIdentRolle() {
        return identRolle;
    }

    /**
     * Legt den Wert der identRolle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIdentRolle }
     *     
     */
    public void setIdentRolle(TCIdentRolle value) {
        this.identRolle = value;
    }

}
