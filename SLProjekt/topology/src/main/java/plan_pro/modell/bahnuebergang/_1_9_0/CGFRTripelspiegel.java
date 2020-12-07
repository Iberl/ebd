//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CPunktObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDGFRAnlageOhneProxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Ortungshilfe f�r GFR-Anlagen der Firma Honeywell.
 * 
 * <p>Java-Klasse f�r CGFR_Tripelspiegel complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGFR_Tripelspiegel">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CGFR_Tripelspiegel_Bezeichnung"/>
 *         &lt;element name="GFR_Tripelspiegel_Allg" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CGFR_Tripelspiegel_Allg"/>
 *         &lt;element name="ID_GFR_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_GFR_Anlage_ohne_Proxy"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGFR_Tripelspiegel", propOrder = {
    "bezeichnung",
    "gfrTripelspiegelAllg",
    "idgfrAnlage"
})
public class CGFRTripelspiegel
    extends CPunktObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CGFRTripelspiegelBezeichnung bezeichnung;
    @XmlElement(name = "GFR_Tripelspiegel_Allg", required = true)
    protected CGFRTripelspiegelAllg gfrTripelspiegelAllg;
    @XmlElement(name = "ID_GFR_Anlage", required = true)
    protected TCIDGFRAnlageOhneProxy idgfrAnlage;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CGFRTripelspiegelBezeichnung }
     *     
     */
    public CGFRTripelspiegelBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CGFRTripelspiegelBezeichnung }
     *     
     */
    public void setBezeichnung(CGFRTripelspiegelBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der gfrTripelspiegelAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CGFRTripelspiegelAllg }
     *     
     */
    public CGFRTripelspiegelAllg getGFRTripelspiegelAllg() {
        return gfrTripelspiegelAllg;
    }

    /**
     * Legt den Wert der gfrTripelspiegelAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CGFRTripelspiegelAllg }
     *     
     */
    public void setGFRTripelspiegelAllg(CGFRTripelspiegelAllg value) {
        this.gfrTripelspiegelAllg = value;
    }

    /**
     * Ruft den Wert der idgfrAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGFRAnlageOhneProxy }
     *     
     */
    public TCIDGFRAnlageOhneProxy getIDGFRAnlage() {
        return idgfrAnlage;
    }

    /**
     * Legt den Wert der idgfrAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGFRAnlageOhneProxy }
     *     
     */
    public void setIDGFRAnlage(TCIDGFRAnlageOhneProxy value) {
        this.idgfrAnlage = value;
    }

}
