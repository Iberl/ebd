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
 * Am PlanPro-Planungsprozess beteiligter Akteur.\r\nIn PlanPro werden der Name und Kontaktdaten des Akteurs erfasst. Einschr�nkungen hinsichtlich der zul�ssigen Rolle des Akteurs sind durch entsprechende Attributbezeichnungen und -beschreibungen ersichtlich.\r\nDB-Regelwerk\r\n� Schriftfeldeintrag gem�� Ril 819.0103\r\n
 * 
 * <p>Java-Klasse f�r CAkteur complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CAkteur">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Akteur_Allg" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CAkteur_Allg"/>
 *         &lt;element name="Kontaktdaten" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}COrganisation"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CAkteur", propOrder = {
    "akteurAllg",
    "kontaktdaten"
})
public class CAkteur
    extends CUrObjekt
{

    @XmlElement(name = "Akteur_Allg", required = true)
    protected CAkteurAllg akteurAllg;
    @XmlElement(name = "Kontaktdaten", required = true)
    protected COrganisation kontaktdaten;

    /**
     * Ruft den Wert der akteurAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CAkteurAllg }
     *     
     */
    public CAkteurAllg getAkteurAllg() {
        return akteurAllg;
    }

    /**
     * Legt den Wert der akteurAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CAkteurAllg }
     *     
     */
    public void setAkteurAllg(CAkteurAllg value) {
        this.akteurAllg = value;
    }

    /**
     * Ruft den Wert der kontaktdaten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link COrganisation }
     *     
     */
    public COrganisation getKontaktdaten() {
        return kontaktdaten;
    }

    /**
     * Legt den Wert der kontaktdaten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link COrganisation }
     *     
     */
    public void setKontaktdaten(COrganisation value) {
        this.kontaktdaten = value;
    }

}
