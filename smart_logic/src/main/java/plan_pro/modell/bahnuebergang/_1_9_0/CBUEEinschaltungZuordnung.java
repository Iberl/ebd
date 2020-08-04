//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBUEEinschaltung;
import plan_pro.modell.verweise._1_9_0.TCIDBUEGleisbezogenerGefahrraum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Logisches Objekt zur Zuordnung zwischen BUE Einschaltung und zugeh�rigem BUE Gleisbezogener Gefahrraum. Im Regelfall wirkt eine BUE_Einschaltung direkt auf einen gleisbezogenen Gefahrraum; das Zuordnungsobjekt w�re nicht erforderlich. Liegt jedoch zwischen BUE_Einschaltung und dem B� eine Weichenverbindung, wird eine Zuordnung der BUE_Einschaltung auf mehrere gleisbezogene Gefahrr�ume notwendig. Diese Verbindung stellt das Zuordnungsobjekt her. Zur Vereinheitlichung wurde auf eine Choice zwischen direktem Verweis von BUE_Einschaltung auf BUE_Gleisbezogener_Gefahrraum und den Verweisen durch das Zuordnungsobjekt verzichtet. DB-Regelwerk Dieser Anwendungsfall ist im Regelwerk der DB AG nicht explizit beschrieben. 
 * 
 * <p>Java-Klasse f�r CBUE_Einschaltung_Zuordnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Einschaltung_Zuordnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_BUE_Einschaltung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_BUE_Einschaltung"/>
 *         &lt;element name="ID_BUE_Gleisbez_Gefahrraum" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_BUE_Gleisbezogener_Gefahrraum"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Einschaltung_Zuordnung", propOrder = {
    "idbueEinschaltung",
    "idbueGleisbezGefahrraum"
})
public class CBUEEinschaltungZuordnung
    extends CBasisObjekt
{

    @XmlElement(name = "ID_BUE_Einschaltung", required = true)
    protected TCIDBUEEinschaltung idbueEinschaltung;
    @XmlElement(name = "ID_BUE_Gleisbez_Gefahrraum", required = true)
    protected TCIDBUEGleisbezogenerGefahrraum idbueGleisbezGefahrraum;

    /**
     * Ruft den Wert der idbueEinschaltung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBUEEinschaltung }
     *     
     */
    public TCIDBUEEinschaltung getIDBUEEinschaltung() {
        return idbueEinschaltung;
    }

    /**
     * Legt den Wert der idbueEinschaltung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBUEEinschaltung }
     *     
     */
    public void setIDBUEEinschaltung(TCIDBUEEinschaltung value) {
        this.idbueEinschaltung = value;
    }

    /**
     * Ruft den Wert der idbueGleisbezGefahrraum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBUEGleisbezogenerGefahrraum }
     *     
     */
    public TCIDBUEGleisbezogenerGefahrraum getIDBUEGleisbezGefahrraum() {
        return idbueGleisbezGefahrraum;
    }

    /**
     * Legt den Wert der idbueGleisbezGefahrraum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBUEGleisbezogenerGefahrraum }
     *     
     */
    public void setIDBUEGleisbezGefahrraum(TCIDBUEGleisbezogenerGefahrraum value) {
        this.idbueGleisbezGefahrraum = value;
    }

}
