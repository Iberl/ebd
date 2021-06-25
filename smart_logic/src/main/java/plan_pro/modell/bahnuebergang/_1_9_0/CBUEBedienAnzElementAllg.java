//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDBedienAnzeigeElement;
import plan_pro.modell.verweise._1_9_0.TCIDHandschaltWirkfunktion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBUE_Bedien_Anz_Element_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Bedien_Anz_Element_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BUE_Handschalteinrichtung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBUE_Handschalteinrichtung"/>
 *         &lt;element name="ID_Bedien_Anzeige_Element" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Bedien_Anzeige_Element"/>
 *         &lt;element name="ID_Handschalt_Wirkfunktion" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Handschalt_Wirkfunktion"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Bedien_Anz_Element_Allg", propOrder = {
    "bueHandschalteinrichtung",
    "idBedienAnzeigeElement",
    "idHandschaltWirkfunktion"
})
public class CBUEBedienAnzElementAllg {

    @XmlElement(name = "BUE_Handschalteinrichtung", required = true)
    protected TCBUEHandschalteinrichtung bueHandschalteinrichtung;
    @XmlElement(name = "ID_Bedien_Anzeige_Element", required = true)
    protected TCIDBedienAnzeigeElement idBedienAnzeigeElement;
    @XmlElement(name = "ID_Handschalt_Wirkfunktion", required = true)
    protected TCIDHandschaltWirkfunktion idHandschaltWirkfunktion;

    /**
     * Ruft den Wert der bueHandschalteinrichtung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBUEHandschalteinrichtung }
     *     
     */
    public TCBUEHandschalteinrichtung getBUEHandschalteinrichtung() {
        return bueHandschalteinrichtung;
    }

    /**
     * Legt den Wert der bueHandschalteinrichtung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBUEHandschalteinrichtung }
     *     
     */
    public void setBUEHandschalteinrichtung(TCBUEHandschalteinrichtung value) {
        this.bueHandschalteinrichtung = value;
    }

    /**
     * Ruft den Wert der idBedienAnzeigeElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBedienAnzeigeElement }
     *     
     */
    public TCIDBedienAnzeigeElement getIDBedienAnzeigeElement() {
        return idBedienAnzeigeElement;
    }

    /**
     * Legt den Wert der idBedienAnzeigeElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBedienAnzeigeElement }
     *     
     */
    public void setIDBedienAnzeigeElement(TCIDBedienAnzeigeElement value) {
        this.idBedienAnzeigeElement = value;
    }

    /**
     * Ruft den Wert der idHandschaltWirkfunktion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDHandschaltWirkfunktion }
     *     
     */
    public TCIDHandschaltWirkfunktion getIDHandschaltWirkfunktion() {
        return idHandschaltWirkfunktion;
    }

    /**
     * Legt den Wert der idHandschaltWirkfunktion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDHandschaltWirkfunktion }
     *     
     */
    public void setIDHandschaltWirkfunktion(TCIDHandschaltWirkfunktion value) {
        this.idHandschaltWirkfunktion = value;
    }

}
