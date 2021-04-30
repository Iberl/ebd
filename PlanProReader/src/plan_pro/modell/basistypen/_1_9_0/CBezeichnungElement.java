//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basistypen._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Basisattributgruppe zur einheitlichen Modellierung der Bezeichnung von Stell- und weiteren Elementen. Die Bildung der resultierenden Bezeichnung eines Elements in den verschiedenen Auspr�gungen ist in Bildung der Bezeichnungen beschrieben. DB-Regelwerk Ril 819.9001 (Symbolbezeichnungen sicherungstechnischer Pl�ne)
 * 
 * <p>Java-Klasse f�r CBezeichnung_Element complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBezeichnung_Element">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_Aussenanlage" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}TCBezeichnung_Aussenanlage" minOccurs="0"/>
 *         &lt;element name="Bezeichnung_Lageplan_Kurz" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}TCBezeichnung_Lageplan_Kurz" minOccurs="0"/>
 *         &lt;element name="Bezeichnung_Lageplan_Lang" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}TCBezeichnung_Lageplan_Lang" minOccurs="0"/>
 *         &lt;element name="Bezeichnung_Tabelle" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}TCBezeichnung_Tabelle"/>
 *         &lt;element name="Kennzahl" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}TCKennzahl" minOccurs="0"/>
 *         &lt;element name="Oertlicher_Elementname" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}TCOertlicher_Elementname" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBezeichnung_Element", propOrder = {
    "bezeichnungAussenanlage",
    "bezeichnungLageplanKurz",
    "bezeichnungLageplanLang",
    "bezeichnungTabelle",
    "kennzahl",
    "oertlicherElementname"
})
public class CBezeichnungElement {

    @XmlElement(name = "Bezeichnung_Aussenanlage")
    protected TCBezeichnungAussenanlage bezeichnungAussenanlage;
    @XmlElement(name = "Bezeichnung_Lageplan_Kurz")
    protected TCBezeichnungLageplanKurz bezeichnungLageplanKurz;
    @XmlElement(name = "Bezeichnung_Lageplan_Lang")
    protected TCBezeichnungLageplanLang bezeichnungLageplanLang;
    @XmlElement(name = "Bezeichnung_Tabelle", required = true)
    protected TCBezeichnungTabelle bezeichnungTabelle;
    @XmlElement(name = "Kennzahl")
    protected TCKennzahl kennzahl;
    @XmlElement(name = "Oertlicher_Elementname")
    protected TCOertlicherElementname oertlicherElementname;

    /**
     * Ruft den Wert der bezeichnungAussenanlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungAussenanlage }
     *     
     */
    public TCBezeichnungAussenanlage getBezeichnungAussenanlage() {
        return bezeichnungAussenanlage;
    }

    /**
     * Legt den Wert der bezeichnungAussenanlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungAussenanlage }
     *     
     */
    public void setBezeichnungAussenanlage(TCBezeichnungAussenanlage value) {
        this.bezeichnungAussenanlage = value;
    }

    /**
     * Ruft den Wert der bezeichnungLageplanKurz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungLageplanKurz }
     *     
     */
    public TCBezeichnungLageplanKurz getBezeichnungLageplanKurz() {
        return bezeichnungLageplanKurz;
    }

    /**
     * Legt den Wert der bezeichnungLageplanKurz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungLageplanKurz }
     *     
     */
    public void setBezeichnungLageplanKurz(TCBezeichnungLageplanKurz value) {
        this.bezeichnungLageplanKurz = value;
    }

    /**
     * Ruft den Wert der bezeichnungLageplanLang-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungLageplanLang }
     *     
     */
    public TCBezeichnungLageplanLang getBezeichnungLageplanLang() {
        return bezeichnungLageplanLang;
    }

    /**
     * Legt den Wert der bezeichnungLageplanLang-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungLageplanLang }
     *     
     */
    public void setBezeichnungLageplanLang(TCBezeichnungLageplanLang value) {
        this.bezeichnungLageplanLang = value;
    }

    /**
     * Ruft den Wert der bezeichnungTabelle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungTabelle }
     *     
     */
    public TCBezeichnungTabelle getBezeichnungTabelle() {
        return bezeichnungTabelle;
    }

    /**
     * Legt den Wert der bezeichnungTabelle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungTabelle }
     *     
     */
    public void setBezeichnungTabelle(TCBezeichnungTabelle value) {
        this.bezeichnungTabelle = value;
    }

    /**
     * Ruft den Wert der kennzahl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKennzahl }
     *     
     */
    public TCKennzahl getKennzahl() {
        return kennzahl;
    }

    /**
     * Legt den Wert der kennzahl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKennzahl }
     *     
     */
    public void setKennzahl(TCKennzahl value) {
        this.kennzahl = value;
    }

    /**
     * Ruft den Wert der oertlicherElementname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCOertlicherElementname }
     *     
     */
    public TCOertlicherElementname getOertlicherElementname() {
        return oertlicherElementname;
    }

    /**
     * Legt den Wert der oertlicherElementname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOertlicherElementname }
     *     
     */
    public void setOertlicherElementname(TCOertlicherElementname value) {
        this.oertlicherElementname = value;
    }

}
