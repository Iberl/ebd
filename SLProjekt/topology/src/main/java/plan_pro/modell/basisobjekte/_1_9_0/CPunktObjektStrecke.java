//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basisobjekte._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDStrecke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CPunkt_Objekt_Strecke complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPunkt_Objekt_Strecke">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Strecke" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Strecke"/>
 *         &lt;element name="Strecke_Km" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCStrecke_Km"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPunkt_Objekt_Strecke", propOrder = {
    "idStrecke",
    "streckeKm"
})
public class CPunktObjektStrecke {

    @XmlElement(name = "ID_Strecke", required = true)
    protected TCIDStrecke idStrecke;
    @XmlElement(name = "Strecke_Km", required = true)
    protected TCStreckeKm streckeKm;

    /**
     * Ruft den Wert der idStrecke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDStrecke }
     *     
     */
    public TCIDStrecke getIDStrecke() {
        return idStrecke;
    }

    /**
     * Legt den Wert der idStrecke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDStrecke }
     *     
     */
    public void setIDStrecke(TCIDStrecke value) {
        this.idStrecke = value;
    }

    /**
     * Ruft den Wert der streckeKm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCStreckeKm }
     *     
     */
    public TCStreckeKm getStreckeKm() {
        return streckeKm;
    }

    /**
     * Legt den Wert der streckeKm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCStreckeKm }
     *     
     */
    public void setStreckeKm(TCStreckeKm value) {
        this.streckeKm = value;
    }

}
