//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.ortung._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFMA_Anlage_Kaskade complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFMA_Anlage_Kaskade">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FMA_Kaskade_Bezeichnung" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}TCFMA_Kaskade_Bezeichnung"/>
 *         &lt;element name="FMA_Kaskade_Einzelauswertung" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}TCFMA_Kaskade_Einzelauswertung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFMA_Anlage_Kaskade", propOrder = {
    "fmaKaskadeBezeichnung",
    "fmaKaskadeEinzelauswertung"
})
public class CFMAAnlageKaskade {

    @XmlElement(name = "FMA_Kaskade_Bezeichnung", required = true)
    protected TCFMAKaskadeBezeichnung fmaKaskadeBezeichnung;
    @XmlElement(name = "FMA_Kaskade_Einzelauswertung", required = true)
    protected TCFMAKaskadeEinzelauswertung fmaKaskadeEinzelauswertung;

    /**
     * Ruft den Wert der fmaKaskadeBezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMAKaskadeBezeichnung }
     *     
     */
    public TCFMAKaskadeBezeichnung getFMAKaskadeBezeichnung() {
        return fmaKaskadeBezeichnung;
    }

    /**
     * Legt den Wert der fmaKaskadeBezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMAKaskadeBezeichnung }
     *     
     */
    public void setFMAKaskadeBezeichnung(TCFMAKaskadeBezeichnung value) {
        this.fmaKaskadeBezeichnung = value;
    }

    /**
     * Ruft den Wert der fmaKaskadeEinzelauswertung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMAKaskadeEinzelauswertung }
     *     
     */
    public TCFMAKaskadeEinzelauswertung getFMAKaskadeEinzelauswertung() {
        return fmaKaskadeEinzelauswertung;
    }

    /**
     * Legt den Wert der fmaKaskadeEinzelauswertung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMAKaskadeEinzelauswertung }
     *     
     */
    public void setFMAKaskadeEinzelauswertung(TCFMAKaskadeEinzelauswertung value) {
        this.fmaKaskadeEinzelauswertung = value;
    }

}
