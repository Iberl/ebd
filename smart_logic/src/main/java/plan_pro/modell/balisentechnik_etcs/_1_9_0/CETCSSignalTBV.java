//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CETCS_Signal_TBV complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CETCS_Signal_TBV">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TBV_Meldepunkt" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCTBV_Meldepunkt" minOccurs="0"/>
 *         &lt;element name="TBV_Tunnelbereich_Laenge" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCTBV_Tunnelbereich_Laenge" minOccurs="0"/>
 *         &lt;element name="TBV_Tunnelsignal" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCTBV_Tunnelsignal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CETCS_Signal_TBV", propOrder = {
    "tbvMeldepunkt",
    "tbvTunnelbereichLaenge",
    "tbvTunnelsignal"
})
public class CETCSSignalTBV {

    @XmlElement(name = "TBV_Meldepunkt")
    protected TCTBVMeldepunkt tbvMeldepunkt;
    @XmlElement(name = "TBV_Tunnelbereich_Laenge")
    protected TCTBVTunnelbereichLaenge tbvTunnelbereichLaenge;
    @XmlElement(name = "TBV_Tunnelsignal")
    protected TCTBVTunnelsignal tbvTunnelsignal;

    /**
     * Ruft den Wert der tbvMeldepunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTBVMeldepunkt }
     *     
     */
    public TCTBVMeldepunkt getTBVMeldepunkt() {
        return tbvMeldepunkt;
    }

    /**
     * Legt den Wert der tbvMeldepunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTBVMeldepunkt }
     *     
     */
    public void setTBVMeldepunkt(TCTBVMeldepunkt value) {
        this.tbvMeldepunkt = value;
    }

    /**
     * Ruft den Wert der tbvTunnelbereichLaenge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTBVTunnelbereichLaenge }
     *     
     */
    public TCTBVTunnelbereichLaenge getTBVTunnelbereichLaenge() {
        return tbvTunnelbereichLaenge;
    }

    /**
     * Legt den Wert der tbvTunnelbereichLaenge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTBVTunnelbereichLaenge }
     *     
     */
    public void setTBVTunnelbereichLaenge(TCTBVTunnelbereichLaenge value) {
        this.tbvTunnelbereichLaenge = value;
    }

    /**
     * Ruft den Wert der tbvTunnelsignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTBVTunnelsignal }
     *     
     */
    public TCTBVTunnelsignal getTBVTunnelsignal() {
        return tbvTunnelsignal;
    }

    /**
     * Legt den Wert der tbvTunnelsignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTBVTunnelsignal }
     *     
     */
    public void setTBVTunnelsignal(TCTBVTunnelsignal value) {
        this.tbvTunnelsignal = value;
    }

}
