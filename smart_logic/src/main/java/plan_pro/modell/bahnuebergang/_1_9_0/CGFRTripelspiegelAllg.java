//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CGFR_Tripelspiegel_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGFR_Tripelspiegel_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Montagehoehe" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCMontagehoehe" minOccurs="0"/>
 *         &lt;element name="Pegel" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCPegel" minOccurs="0"/>
 *         &lt;element name="Winkel_Alpha" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCWinkel_Alpha" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGFR_Tripelspiegel_Allg", propOrder = {
    "montagehoehe",
    "pegel",
    "winkelAlpha"
})
public class CGFRTripelspiegelAllg {

    @XmlElement(name = "Montagehoehe")
    protected TCMontagehoehe montagehoehe;
    @XmlElement(name = "Pegel")
    protected TCPegel pegel;
    @XmlElement(name = "Winkel_Alpha")
    protected TCWinkelAlpha winkelAlpha;

    /**
     * Ruft den Wert der montagehoehe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMontagehoehe }
     *     
     */
    public TCMontagehoehe getMontagehoehe() {
        return montagehoehe;
    }

    /**
     * Legt den Wert der montagehoehe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMontagehoehe }
     *     
     */
    public void setMontagehoehe(TCMontagehoehe value) {
        this.montagehoehe = value;
    }

    /**
     * Ruft den Wert der pegel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPegel }
     *     
     */
    public TCPegel getPegel() {
        return pegel;
    }

    /**
     * Legt den Wert der pegel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPegel }
     *     
     */
    public void setPegel(TCPegel value) {
        this.pegel = value;
    }

    /**
     * Ruft den Wert der winkelAlpha-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWinkelAlpha }
     *     
     */
    public TCWinkelAlpha getWinkelAlpha() {
        return winkelAlpha;
    }

    /**
     * Legt den Wert der winkelAlpha-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWinkelAlpha }
     *     
     */
    public void setWinkelAlpha(TCWinkelAlpha value) {
        this.winkelAlpha = value;
    }

}
