//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CUrObjekt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Ausgabe der Fachdaten einer Planung im PlanPro-Format.\r\nAn dieser Stelle werden die LST-Fachinhalte getrennt von den Angaben des Objektmanagements eingebunden.\r\nDB-Regelwerk\r\nBisher keine eindeutige Abbildung.
 * 
 * <p>Java-Klasse f�r CAusgabe_Fachdaten complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CAusgabe_Fachdaten">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="LST_Zustand_Start" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CLST_Zustand"/>
 *         &lt;element name="LST_Zustand_Ziel" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CLST_Zustand"/>
 *         &lt;element name="Untergewerk_Art" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCUntergewerk_Art"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CAusgabe_Fachdaten", propOrder = {
    "lstZustandStart",
    "lstZustandZiel",
    "untergewerkArt"
})
public class CAusgabeFachdaten
    extends CUrObjekt
{

    @XmlElement(name = "LST_Zustand_Start", required = true)
    protected CLSTZustand lstZustandStart;
    @XmlElement(name = "LST_Zustand_Ziel", required = true)
    protected CLSTZustand lstZustandZiel;
    @XmlElement(name = "Untergewerk_Art", required = true)
    protected TCUntergewerkArt untergewerkArt;

    /**
     * Ruft den Wert der lstZustandStart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CLSTZustand }
     *     
     */
    public CLSTZustand getLSTZustandStart() {
        return lstZustandStart;
    }

    /**
     * Legt den Wert der lstZustandStart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CLSTZustand }
     *     
     */
    public void setLSTZustandStart(CLSTZustand value) {
        this.lstZustandStart = value;
    }

    /**
     * Ruft den Wert der lstZustandZiel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CLSTZustand }
     *     
     */
    public CLSTZustand getLSTZustandZiel() {
        return lstZustandZiel;
    }

    /**
     * Legt den Wert der lstZustandZiel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CLSTZustand }
     *     
     */
    public void setLSTZustandZiel(CLSTZustand value) {
        this.lstZustandZiel = value;
    }

    /**
     * Ruft den Wert der untergewerkArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUntergewerkArt }
     *     
     */
    public TCUntergewerkArt getUntergewerkArt() {
        return untergewerkArt;
    }

    /**
     * Legt den Wert der untergewerkArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUntergewerkArt }
     *     
     */
    public void setUntergewerkArt(TCUntergewerkArt value) {
        this.untergewerkArt = value;
    }

}
