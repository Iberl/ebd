//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBereichObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBUEAnlage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Bereichsobjekt, das den Gefahrraum eines B� f�r ein Gleis abbildet. Die Grenzen des Bereichsobjektes liegen jeweils auf dem Schnittpunkt zwischen Gefahrraumkante und zugeh�rigem Gleis. Die zugeh�rigen Ein- und Ausschaltelemente verweisen auf die jeweilige Grenze des Bereichsobjektes. F�r jedes Gleis am B� ist ein solches Objekt vorzusehen. Somit hat ein B� bzw. eine BUE Anlage immer genauso viele Instanzen von BUE_Gleisbezogener_Gefahrraum wie B�-Gleise. Zu einem sp�teren Zeitpunkt werden ggf. weitere, Gefahrraum-spezifische Angaben erg�nzt. DB-Regelwerk 819.1210 7 (1)-(3) 
 * 
 * <p>Java-Klasse f�r CBUE_Gleisbezogener_Gefahrraum complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Gleisbezogener_Gefahrraum">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Ersatzstecker_Gleisbezogen" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCErsatzstecker_Gleisbezogen" minOccurs="0"/>
 *         &lt;element name="Gleis_Am_Bue" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCGleis_Am_Bue"/>
 *         &lt;element name="ID_BUE_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_BUE_Anlage"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Gleisbezogener_Gefahrraum", propOrder = {
    "ersatzsteckerGleisbezogen",
    "gleisAmBue",
    "idbueAnlage"
})
public class CBUEGleisbezogenerGefahrraum
    extends CBereichObjekt
{

    @XmlElement(name = "Ersatzstecker_Gleisbezogen")
    protected TCErsatzsteckerGleisbezogen ersatzsteckerGleisbezogen;
    @XmlElement(name = "Gleis_Am_Bue", required = true)
    protected TCGleisAmBue gleisAmBue;
    @XmlElement(name = "ID_BUE_Anlage", required = true)
    protected TCIDBUEAnlage idbueAnlage;

    /**
     * Ruft den Wert der ersatzsteckerGleisbezogen-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCErsatzsteckerGleisbezogen }
     *     
     */
    public TCErsatzsteckerGleisbezogen getErsatzsteckerGleisbezogen() {
        return ersatzsteckerGleisbezogen;
    }

    /**
     * Legt den Wert der ersatzsteckerGleisbezogen-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCErsatzsteckerGleisbezogen }
     *     
     */
    public void setErsatzsteckerGleisbezogen(TCErsatzsteckerGleisbezogen value) {
        this.ersatzsteckerGleisbezogen = value;
    }

    /**
     * Ruft den Wert der gleisAmBue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGleisAmBue }
     *     
     */
    public TCGleisAmBue getGleisAmBue() {
        return gleisAmBue;
    }

    /**
     * Legt den Wert der gleisAmBue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGleisAmBue }
     *     
     */
    public void setGleisAmBue(TCGleisAmBue value) {
        this.gleisAmBue = value;
    }

    /**
     * Ruft den Wert der idbueAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBUEAnlage }
     *     
     */
    public TCIDBUEAnlage getIDBUEAnlage() {
        return idbueAnlage;
    }

    /**
     * Legt den Wert der idbueAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBUEAnlage }
     *     
     */
    public void setIDBUEAnlage(TCIDBUEAnlage value) {
        this.idbueAnlage = value;
    }

}
