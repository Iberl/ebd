//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CUrObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Angabe einer am PlanPro-Planungsprozess beteiligten Organisation.\nDerzeit insbesondere verwendet zur Abbildung des beteiligten Ingenieurb�ros.\nBisher werden in PlanPro lediglich Name und Kontaktdaten der Organisation erfasst. Die Vergabe von Berechtigungen erfolgt in der Prozessrolle des LST-Fachplaners im Zusammenhang mit den definierten Planungsschritten und Planungsstatus.\nDB-Regelwerk\nSchriftfeldeintrag gem�� Ril 819.0103.
 * 
 * <p>Java-Klasse f�r COrganisation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="COrganisation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Adresse_PLZ_Ort" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCAdresse_PLZ_Ort" minOccurs="0"/>
 *         &lt;element name="Adresse_Strasse_Nr" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCAdresse_Strasse_Nr" minOccurs="0"/>
 *         &lt;element name="E_Mail_Adresse" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCE_Mail_Adresse" minOccurs="0"/>
 *         &lt;element name="Name_Organisation" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCName_Organisation"/>
 *         &lt;element name="Organisationseinheit" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCOrganisationseinheit" minOccurs="0"/>
 *         &lt;element name="Telefonnummer" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCTelefonnummer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COrganisation", propOrder = {
    "adressePLZOrt",
    "adresseStrasseNr",
    "eMailAdresse",
    "nameOrganisation",
    "organisationseinheit",
    "telefonnummer"
})
public class COrganisation
    extends CUrObjekt
{

    @XmlElement(name = "Adresse_PLZ_Ort")
    protected TCAdressePLZOrt adressePLZOrt;
    @XmlElement(name = "Adresse_Strasse_Nr")
    protected TCAdresseStrasseNr adresseStrasseNr;
    @XmlElement(name = "E_Mail_Adresse")
    protected TCEMailAdresse eMailAdresse;
    @XmlElement(name = "Name_Organisation", required = true)
    protected TCNameOrganisation nameOrganisation;
    @XmlElement(name = "Organisationseinheit")
    protected TCOrganisationseinheit organisationseinheit;
    @XmlElement(name = "Telefonnummer")
    protected TCTelefonnummer telefonnummer;

    /**
     * Ruft den Wert der adressePLZOrt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAdressePLZOrt }
     *     
     */
    public TCAdressePLZOrt getAdressePLZOrt() {
        return adressePLZOrt;
    }

    /**
     * Legt den Wert der adressePLZOrt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAdressePLZOrt }
     *     
     */
    public void setAdressePLZOrt(TCAdressePLZOrt value) {
        this.adressePLZOrt = value;
    }

    /**
     * Ruft den Wert der adresseStrasseNr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAdresseStrasseNr }
     *     
     */
    public TCAdresseStrasseNr getAdresseStrasseNr() {
        return adresseStrasseNr;
    }

    /**
     * Legt den Wert der adresseStrasseNr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAdresseStrasseNr }
     *     
     */
    public void setAdresseStrasseNr(TCAdresseStrasseNr value) {
        this.adresseStrasseNr = value;
    }

    /**
     * Ruft den Wert der eMailAdresse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEMailAdresse }
     *     
     */
    public TCEMailAdresse getEMailAdresse() {
        return eMailAdresse;
    }

    /**
     * Legt den Wert der eMailAdresse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEMailAdresse }
     *     
     */
    public void setEMailAdresse(TCEMailAdresse value) {
        this.eMailAdresse = value;
    }

    /**
     * Ruft den Wert der nameOrganisation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNameOrganisation }
     *     
     */
    public TCNameOrganisation getNameOrganisation() {
        return nameOrganisation;
    }

    /**
     * Legt den Wert der nameOrganisation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNameOrganisation }
     *     
     */
    public void setNameOrganisation(TCNameOrganisation value) {
        this.nameOrganisation = value;
    }

    /**
     * Ruft den Wert der organisationseinheit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCOrganisationseinheit }
     *     
     */
    public TCOrganisationseinheit getOrganisationseinheit() {
        return organisationseinheit;
    }

    /**
     * Legt den Wert der organisationseinheit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOrganisationseinheit }
     *     
     */
    public void setOrganisationseinheit(TCOrganisationseinheit value) {
        this.organisationseinheit = value;
    }

    /**
     * Ruft den Wert der telefonnummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTelefonnummer }
     *     
     */
    public TCTelefonnummer getTelefonnummer() {
        return telefonnummer;
    }

    /**
     * Legt den Wert der telefonnummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTelefonnummer }
     *     
     */
    public void setTelefonnummer(TCTelefonnummer value) {
        this.telefonnummer = value;
    }

}
