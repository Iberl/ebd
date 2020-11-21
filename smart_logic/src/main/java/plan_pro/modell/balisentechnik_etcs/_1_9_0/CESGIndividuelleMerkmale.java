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
 * <p>Java-Klasse f�r CESG_Individuelle_Merkmale complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CESG_Individuelle_Merkmale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ESG_Ind_Erlaeuterung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCESG_Ind_Erlaeuterung" minOccurs="0"/>
 *         &lt;element name="ESG_Ind_Parameter" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCESG_Ind_Parameter"/>
 *         &lt;element name="ESG_Ind_Parameterwert" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCESG_Ind_Parameterwert"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CESG_Individuelle_Merkmale", propOrder = {
    "esgIndErlaeuterung",
    "esgIndParameter",
    "esgIndParameterwert"
})
public class CESGIndividuelleMerkmale {

    @XmlElement(name = "ESG_Ind_Erlaeuterung")
    protected TCESGIndErlaeuterung esgIndErlaeuterung;
    @XmlElement(name = "ESG_Ind_Parameter", required = true)
    protected TCESGIndParameter esgIndParameter;
    @XmlElement(name = "ESG_Ind_Parameterwert", required = true)
    protected TCESGIndParameterwert esgIndParameterwert;

    /**
     * Ruft den Wert der esgIndErlaeuterung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCESGIndErlaeuterung }
     *     
     */
    public TCESGIndErlaeuterung getESGIndErlaeuterung() {
        return esgIndErlaeuterung;
    }

    /**
     * Legt den Wert der esgIndErlaeuterung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCESGIndErlaeuterung }
     *     
     */
    public void setESGIndErlaeuterung(TCESGIndErlaeuterung value) {
        this.esgIndErlaeuterung = value;
    }

    /**
     * Ruft den Wert der esgIndParameter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCESGIndParameter }
     *     
     */
    public TCESGIndParameter getESGIndParameter() {
        return esgIndParameter;
    }

    /**
     * Legt den Wert der esgIndParameter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCESGIndParameter }
     *     
     */
    public void setESGIndParameter(TCESGIndParameter value) {
        this.esgIndParameter = value;
    }

    /**
     * Ruft den Wert der esgIndParameterwert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCESGIndParameterwert }
     *     
     */
    public TCESGIndParameterwert getESGIndParameterwert() {
        return esgIndParameterwert;
    }

    /**
     * Legt den Wert der esgIndParameterwert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCESGIndParameterwert }
     *     
     */
    public void setESGIndParameterwert(TCESGIndParameterwert value) {
        this.esgIndParameterwert = value;
    }

}
