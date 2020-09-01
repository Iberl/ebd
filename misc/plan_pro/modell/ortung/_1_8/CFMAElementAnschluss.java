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
 * <p>Java-Klasse f�r CFMA_Element_Anschluss complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFMA_Element_Anschluss">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FMA_Anschluss_Bezeichnung" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}TCFMA_Anschluss_Bezeichnung"/>
 *         &lt;element name="FMA_Anschluss_Speiserichtung" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}TCFMA_Anschluss_Speiserichtung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFMA_Element_Anschluss", propOrder = {
    "fmaAnschlussBezeichnung",
    "fmaAnschlussSpeiserichtung"
})
public class CFMAElementAnschluss {

    @XmlElement(name = "FMA_Anschluss_Bezeichnung", required = true)
    protected TCFMAAnschlussBezeichnung fmaAnschlussBezeichnung;
    @XmlElement(name = "FMA_Anschluss_Speiserichtung", required = true)
    protected TCFMAAnschlussSpeiserichtung fmaAnschlussSpeiserichtung;

    /**
     * Ruft den Wert der fmaAnschlussBezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMAAnschlussBezeichnung }
     *     
     */
    public TCFMAAnschlussBezeichnung getFMAAnschlussBezeichnung() {
        return fmaAnschlussBezeichnung;
    }

    /**
     * Legt den Wert der fmaAnschlussBezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMAAnschlussBezeichnung }
     *     
     */
    public void setFMAAnschlussBezeichnung(TCFMAAnschlussBezeichnung value) {
        this.fmaAnschlussBezeichnung = value;
    }

    /**
     * Ruft den Wert der fmaAnschlussSpeiserichtung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMAAnschlussSpeiserichtung }
     *     
     */
    public TCFMAAnschlussSpeiserichtung getFMAAnschlussSpeiserichtung() {
        return fmaAnschlussSpeiserichtung;
    }

    /**
     * Legt den Wert der fmaAnschlussSpeiserichtung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMAAnschlussSpeiserichtung }
     *     
     */
    public void setFMAAnschlussSpeiserichtung(TCFMAAnschlussSpeiserichtung value) {
        this.fmaAnschlussSpeiserichtung = value;
    }

}
