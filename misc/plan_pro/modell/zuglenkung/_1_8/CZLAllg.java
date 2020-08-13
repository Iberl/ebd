//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zuglenkung._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZL_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZL_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Anzahl_Wiederhol_ZL_Anstoesse" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}TCAnzahl_Wiederhol_ZL_Anstoesse" minOccurs="0"/>
 *         &lt;element name="Deadlockpruefung" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}TCDeadlockpruefung" minOccurs="0"/>
 *         &lt;element name="Einstellkontrollzeit" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}TCEinstellkontrollzeit" minOccurs="0"/>
 *         &lt;element name="Lenkabbruchzeit" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}TCLenkabbruchzeit" minOccurs="0"/>
 *         &lt;element name="Personal_Reaktionszeit" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}TCPersonal_Reaktionszeit" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZL_Allg", propOrder = {
    "anzahlWiederholZLAnstoesse",
    "deadlockpruefung",
    "einstellkontrollzeit",
    "lenkabbruchzeit",
    "personalReaktionszeit"
})
public class CZLAllg {

    @XmlElement(name = "Anzahl_Wiederhol_ZL_Anstoesse")
    protected TCAnzahlWiederholZLAnstoesse anzahlWiederholZLAnstoesse;
    @XmlElement(name = "Deadlockpruefung")
    protected TCDeadlockpruefung deadlockpruefung;
    @XmlElement(name = "Einstellkontrollzeit")
    protected TCEinstellkontrollzeit einstellkontrollzeit;
    @XmlElement(name = "Lenkabbruchzeit")
    protected TCLenkabbruchzeit lenkabbruchzeit;
    @XmlElement(name = "Personal_Reaktionszeit")
    protected TCPersonalReaktionszeit personalReaktionszeit;

    /**
     * Ruft den Wert der anzahlWiederholZLAnstoesse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAnzahlWiederholZLAnstoesse }
     *     
     */
    public TCAnzahlWiederholZLAnstoesse getAnzahlWiederholZLAnstoesse() {
        return anzahlWiederholZLAnstoesse;
    }

    /**
     * Legt den Wert der anzahlWiederholZLAnstoesse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAnzahlWiederholZLAnstoesse }
     *     
     */
    public void setAnzahlWiederholZLAnstoesse(TCAnzahlWiederholZLAnstoesse value) {
        this.anzahlWiederholZLAnstoesse = value;
    }

    /**
     * Ruft den Wert der deadlockpruefung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDeadlockpruefung }
     *     
     */
    public TCDeadlockpruefung getDeadlockpruefung() {
        return deadlockpruefung;
    }

    /**
     * Legt den Wert der deadlockpruefung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDeadlockpruefung }
     *     
     */
    public void setDeadlockpruefung(TCDeadlockpruefung value) {
        this.deadlockpruefung = value;
    }

    /**
     * Ruft den Wert der einstellkontrollzeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEinstellkontrollzeit }
     *     
     */
    public TCEinstellkontrollzeit getEinstellkontrollzeit() {
        return einstellkontrollzeit;
    }

    /**
     * Legt den Wert der einstellkontrollzeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEinstellkontrollzeit }
     *     
     */
    public void setEinstellkontrollzeit(TCEinstellkontrollzeit value) {
        this.einstellkontrollzeit = value;
    }

    /**
     * Ruft den Wert der lenkabbruchzeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLenkabbruchzeit }
     *     
     */
    public TCLenkabbruchzeit getLenkabbruchzeit() {
        return lenkabbruchzeit;
    }

    /**
     * Legt den Wert der lenkabbruchzeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLenkabbruchzeit }
     *     
     */
    public void setLenkabbruchzeit(TCLenkabbruchzeit value) {
        this.lenkabbruchzeit = value;
    }

    /**
     * Ruft den Wert der personalReaktionszeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPersonalReaktionszeit }
     *     
     */
    public TCPersonalReaktionszeit getPersonalReaktionszeit() {
        return personalReaktionszeit;
    }

    /**
     * Legt den Wert der personalReaktionszeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPersonalReaktionszeit }
     *     
     */
    public void setPersonalReaktionszeit(TCPersonalReaktionszeit value) {
        this.personalReaktionszeit = value;
    }

}
