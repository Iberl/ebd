//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDZN;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Logisches Objekt, welches die Verbindung zwischen ZN und ggf. der einzelnen Fahrstra�e herstellt, f�r die das Telegramm 85 gesendet werden soll. Herstellerbezogen kann die Sendung des Telegramms 85 f�r jede einzelne Fahrstra�e oder nur f�r alle Fahrstra�en programmiert werden. DB-Regelwerk 819.0731A02 1 (5) 
 * 
 * <p>Java-Klasse f�r CZN_Telegramm_85_Zuordnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_Telegramm_85_Zuordnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_ZN" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZN"/>
 *         &lt;choice>
 *           &lt;element name="Telegramm_85_Alle_Fstr" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}CTelegramm_85_Alle_Fstr"/>
 *           &lt;element name="Telegramm_85_Einzelne_Fstr" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}CTelegramm_85_Einzelne_Fstr"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZN_Telegramm_85_Zuordnung", propOrder = {
    "idzn",
    "telegramm85AlleFstr",
    "telegramm85EinzelneFstr"
})
public class CZNTelegramm85Zuordnung
    extends CBasisObjekt
{

    @XmlElement(name = "ID_ZN", required = true)
    protected TCIDZN idzn;
    @XmlElement(name = "Telegramm_85_Alle_Fstr")
    protected CTelegramm85AlleFstr telegramm85AlleFstr;
    @XmlElement(name = "Telegramm_85_Einzelne_Fstr")
    protected CTelegramm85EinzelneFstr telegramm85EinzelneFstr;

    /**
     * Ruft den Wert der idzn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZN }
     *     
     */
    public TCIDZN getIDZN() {
        return idzn;
    }

    /**
     * Legt den Wert der idzn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZN }
     *     
     */
    public void setIDZN(TCIDZN value) {
        this.idzn = value;
    }

    /**
     * Ruft den Wert der telegramm85AlleFstr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CTelegramm85AlleFstr }
     *     
     */
    public CTelegramm85AlleFstr getTelegramm85AlleFstr() {
        return telegramm85AlleFstr;
    }

    /**
     * Legt den Wert der telegramm85AlleFstr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CTelegramm85AlleFstr }
     *     
     */
    public void setTelegramm85AlleFstr(CTelegramm85AlleFstr value) {
        this.telegramm85AlleFstr = value;
    }

    /**
     * Ruft den Wert der telegramm85EinzelneFstr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CTelegramm85EinzelneFstr }
     *     
     */
    public CTelegramm85EinzelneFstr getTelegramm85EinzelneFstr() {
        return telegramm85EinzelneFstr;
    }

    /**
     * Legt den Wert der telegramm85EinzelneFstr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CTelegramm85EinzelneFstr }
     *     
     */
    public void setTelegramm85EinzelneFstr(CTelegramm85EinzelneFstr value) {
        this.telegramm85EinzelneFstr = value;
    }

}
