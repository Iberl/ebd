//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CRBC_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CRBC_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RBC_SRS_Unterversion" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCRBC_SRS_Unterversion"/>
 *         &lt;element name="RBC_SRS_Version" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCRBC_SRS_Version"/>
 *         &lt;element name="Rufnummer" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCRufnummer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRBC_Allg", propOrder = {
    "rbcsrsUnterversion",
    "rbcsrsVersion",
    "rufnummer"
})
public class CRBCAllg {

    @XmlElement(name = "RBC_SRS_Unterversion", required = true)
    protected TCRBCSRSUnterversion rbcsrsUnterversion;
    @XmlElement(name = "RBC_SRS_Version", required = true)
    protected TCRBCSRSVersion rbcsrsVersion;
    @XmlElement(name = "Rufnummer", required = true)
    protected TCRufnummer rufnummer;

    /**
     * Ruft den Wert der rbcsrsUnterversion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRBCSRSUnterversion }
     *     
     */
    public TCRBCSRSUnterversion getRBCSRSUnterversion() {
        return rbcsrsUnterversion;
    }

    /**
     * Legt den Wert der rbcsrsUnterversion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRBCSRSUnterversion }
     *     
     */
    public void setRBCSRSUnterversion(TCRBCSRSUnterversion value) {
        this.rbcsrsUnterversion = value;
    }

    /**
     * Ruft den Wert der rbcsrsVersion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRBCSRSVersion }
     *     
     */
    public TCRBCSRSVersion getRBCSRSVersion() {
        return rbcsrsVersion;
    }

    /**
     * Legt den Wert der rbcsrsVersion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRBCSRSVersion }
     *     
     */
    public void setRBCSRSVersion(TCRBCSRSVersion value) {
        this.rbcsrsVersion = value;
    }

    /**
     * Ruft den Wert der rufnummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRufnummer }
     *     
     */
    public TCRufnummer getRufnummer() {
        return rufnummer;
    }

    /**
     * Legt den Wert der rufnummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRufnummer }
     *     
     */
    public void setRufnummer(TCRufnummer value) {
        this.rufnummer = value;
    }

}
