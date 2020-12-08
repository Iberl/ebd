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
 * <p>Java-Klasse f�r CFT_ETCS_Trans_Paket_41 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFT_ETCS_Trans_Paket_41">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="D_LEVELTR" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCD_LEVELTR"/>
 *         &lt;element name="L_ACKLEVELTR" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCL_ACKLEVELTR"/>
 *         &lt;element name="M_LEVELTR" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCM_LEVELTR"/>
 *         &lt;element name="NID_STM" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCNID_STM" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFT_ETCS_Trans_Paket_41", propOrder = {
    "dleveltr",
    "lackleveltr",
    "mleveltr",
    "nidstm"
})
public class CFTETCSTransPaket41 {

    @XmlElement(name = "D_LEVELTR", required = true)
    protected TCDLEVELTR dleveltr;
    @XmlElement(name = "L_ACKLEVELTR", required = true)
    protected TCLACKLEVELTR lackleveltr;
    @XmlElement(name = "M_LEVELTR", required = true)
    protected TCMLEVELTR mleveltr;
    @XmlElement(name = "NID_STM")
    protected TCNIDSTM nidstm;

    /**
     * Ruft den Wert der dleveltr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDLEVELTR }
     *     
     */
    public TCDLEVELTR getDLEVELTR() {
        return dleveltr;
    }

    /**
     * Legt den Wert der dleveltr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDLEVELTR }
     *     
     */
    public void setDLEVELTR(TCDLEVELTR value) {
        this.dleveltr = value;
    }

    /**
     * Ruft den Wert der lackleveltr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLACKLEVELTR }
     *     
     */
    public TCLACKLEVELTR getLACKLEVELTR() {
        return lackleveltr;
    }

    /**
     * Legt den Wert der lackleveltr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLACKLEVELTR }
     *     
     */
    public void setLACKLEVELTR(TCLACKLEVELTR value) {
        this.lackleveltr = value;
    }

    /**
     * Ruft den Wert der mleveltr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMLEVELTR }
     *     
     */
    public TCMLEVELTR getMLEVELTR() {
        return mleveltr;
    }

    /**
     * Legt den Wert der mleveltr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMLEVELTR }
     *     
     */
    public void setMLEVELTR(TCMLEVELTR value) {
        this.mleveltr = value;
    }

    /**
     * Ruft den Wert der nidstm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNIDSTM }
     *     
     */
    public TCNIDSTM getNIDSTM() {
        return nidstm;
    }

    /**
     * Legt den Wert der nidstm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNIDSTM }
     *     
     */
    public void setNIDSTM(TCNIDSTM value) {
        this.nidstm = value;
    }

}
