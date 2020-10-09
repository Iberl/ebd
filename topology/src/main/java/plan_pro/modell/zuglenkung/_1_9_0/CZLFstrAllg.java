//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zuglenkung._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZL_Fstr_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZL_Fstr_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Annaeherungsgeschwindigkeit" type="{http://www.plan-pro.org/modell/Zuglenkung/1.9.0.2}TCAnnaeherungsgeschwindigkeit" minOccurs="0"/>
 *         &lt;element name="DWeg_Prio" type="{http://www.plan-pro.org/modell/Zuglenkung/1.9.0.2}TCDWeg_Prio" minOccurs="0"/>
 *         &lt;element name="FUEM_Auswertung" type="{http://www.plan-pro.org/modell/Zuglenkung/1.9.0.2}TCFUEM_Auswertung" minOccurs="0"/>
 *         &lt;element name="Sichtzeit_Vorsignal" type="{http://www.plan-pro.org/modell/Zuglenkung/1.9.0.2}TCSichtzeit_Vorsignal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZL_Fstr_Allg", propOrder = {
    "annaeherungsgeschwindigkeit",
    "dWegPrio",
    "fuemAuswertung",
    "sichtzeitVorsignal"
})
public class CZLFstrAllg {

    @XmlElement(name = "Annaeherungsgeschwindigkeit")
    protected TCAnnaeherungsgeschwindigkeit annaeherungsgeschwindigkeit;
    @XmlElement(name = "DWeg_Prio")
    protected TCDWegPrio dWegPrio;
    @XmlElement(name = "FUEM_Auswertung")
    protected TCFUEMAuswertung fuemAuswertung;
    @XmlElement(name = "Sichtzeit_Vorsignal", required = true)
    protected TCSichtzeitVorsignal sichtzeitVorsignal;

    /**
     * Ruft den Wert der annaeherungsgeschwindigkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAnnaeherungsgeschwindigkeit }
     *     
     */
    public TCAnnaeherungsgeschwindigkeit getAnnaeherungsgeschwindigkeit() {
        return annaeherungsgeschwindigkeit;
    }

    /**
     * Legt den Wert der annaeherungsgeschwindigkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAnnaeherungsgeschwindigkeit }
     *     
     */
    public void setAnnaeherungsgeschwindigkeit(TCAnnaeherungsgeschwindigkeit value) {
        this.annaeherungsgeschwindigkeit = value;
    }

    /**
     * Ruft den Wert der dWegPrio-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDWegPrio }
     *     
     */
    public TCDWegPrio getDWegPrio() {
        return dWegPrio;
    }

    /**
     * Legt den Wert der dWegPrio-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDWegPrio }
     *     
     */
    public void setDWegPrio(TCDWegPrio value) {
        this.dWegPrio = value;
    }

    /**
     * Ruft den Wert der fuemAuswertung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFUEMAuswertung }
     *     
     */
    public TCFUEMAuswertung getFUEMAuswertung() {
        return fuemAuswertung;
    }

    /**
     * Legt den Wert der fuemAuswertung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFUEMAuswertung }
     *     
     */
    public void setFUEMAuswertung(TCFUEMAuswertung value) {
        this.fuemAuswertung = value;
    }

    /**
     * Ruft den Wert der sichtzeitVorsignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSichtzeitVorsignal }
     *     
     */
    public TCSichtzeitVorsignal getSichtzeitVorsignal() {
        return sichtzeitVorsignal;
    }

    /**
     * Legt den Wert der sichtzeitVorsignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSichtzeitVorsignal }
     *     
     */
    public void setSichtzeitVorsignal(TCSichtzeitVorsignal value) {
        this.sichtzeitVorsignal = value;
    }

}
