//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDZN;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Logisches Objekt, welches die Verbindung zwischen ZN und ggf. der einzelnen Fahrstra�e herstellt, f�r die das Telegramm 84 gesendet werden soll. Herstellerbezogen kann die Sendung des Telegramms 84 f�r jede einzelne Fahrstra�e oder nur f�r alle Fahrstra�en programmiert werden. DB-Regelwerk 819.0731A02 1 (5) 
 * 
 * <p>Java-Klasse f�r CZN_Telegramm_84_Zuordnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_Telegramm_84_Zuordnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_ZN" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZN"/>
 *         &lt;choice>
 *           &lt;element name="Telegramm_84_Alle_Fstr" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}CTelegramm_84_Alle_Fstr"/>
 *           &lt;element name="Telegramm_84_Einzelne_Fstr" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}CTelegramm_84_Einzelne_Fstr"/>
 *           &lt;element name="Telegramm_84_Verzicht" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCTelegramm_84_Verzicht"/>
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
@XmlType(name = "CZN_Telegramm_84_Zuordnung", propOrder = {
    "idzn",
    "telegramm84AlleFstr",
    "telegramm84EinzelneFstr",
    "telegramm84Verzicht"
})
public class CZNTelegramm84Zuordnung
    extends CBasisObjekt
{

    @XmlElement(name = "ID_ZN", required = true)
    protected TCIDZN idzn;
    @XmlElement(name = "Telegramm_84_Alle_Fstr")
    protected CTelegramm84AlleFstr telegramm84AlleFstr;
    @XmlElement(name = "Telegramm_84_Einzelne_Fstr")
    protected CTelegramm84EinzelneFstr telegramm84EinzelneFstr;
    @XmlElement(name = "Telegramm_84_Verzicht")
    protected TCTelegramm84Verzicht telegramm84Verzicht;

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
     * Ruft den Wert der telegramm84AlleFstr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CTelegramm84AlleFstr }
     *     
     */
    public CTelegramm84AlleFstr getTelegramm84AlleFstr() {
        return telegramm84AlleFstr;
    }

    /**
     * Legt den Wert der telegramm84AlleFstr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CTelegramm84AlleFstr }
     *     
     */
    public void setTelegramm84AlleFstr(CTelegramm84AlleFstr value) {
        this.telegramm84AlleFstr = value;
    }

    /**
     * Ruft den Wert der telegramm84EinzelneFstr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CTelegramm84EinzelneFstr }
     *     
     */
    public CTelegramm84EinzelneFstr getTelegramm84EinzelneFstr() {
        return telegramm84EinzelneFstr;
    }

    /**
     * Legt den Wert der telegramm84EinzelneFstr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CTelegramm84EinzelneFstr }
     *     
     */
    public void setTelegramm84EinzelneFstr(CTelegramm84EinzelneFstr value) {
        this.telegramm84EinzelneFstr = value;
    }

    /**
     * Ruft den Wert der telegramm84Verzicht-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTelegramm84Verzicht }
     *     
     */
    public TCTelegramm84Verzicht getTelegramm84Verzicht() {
        return telegramm84Verzicht;
    }

    /**
     * Legt den Wert der telegramm84Verzicht-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTelegramm84Verzicht }
     *     
     */
    public void setTelegramm84Verzicht(TCTelegramm84Verzicht value) {
        this.telegramm84Verzicht = value;
    }

}
