//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.flankenschutz._1_8;

import modell.verweise._1_8.TCIDSignal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFla_Schutz_Signal complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFla_Schutz_Signal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fla_Signal_Zielsperrung" type="{http://www.plan-pro.org/modell/Flankenschutz/1.8.0}TCFla_Signal_Zielsperrung" minOccurs="0"/>
 *         &lt;element name="ID_Fla_Signal" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Signal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFla_Schutz_Signal", propOrder = {
    "flaSignalZielsperrung",
    "idFlaSignal"
})
public class CFlaSchutzSignal {

    @XmlElement(name = "Fla_Signal_Zielsperrung")
    protected TCFlaSignalZielsperrung flaSignalZielsperrung;
    @XmlElement(name = "ID_Fla_Signal", required = true)
    protected TCIDSignal idFlaSignal;

    /**
     * Ruft den Wert der flaSignalZielsperrung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFlaSignalZielsperrung }
     *     
     */
    public TCFlaSignalZielsperrung getFlaSignalZielsperrung() {
        return flaSignalZielsperrung;
    }

    /**
     * Legt den Wert der flaSignalZielsperrung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFlaSignalZielsperrung }
     *     
     */
    public void setFlaSignalZielsperrung(TCFlaSignalZielsperrung value) {
        this.flaSignalZielsperrung = value;
    }

    /**
     * Ruft den Wert der idFlaSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignal }
     *     
     */
    public TCIDSignal getIDFlaSignal() {
        return idFlaSignal;
    }

    /**
     * Legt den Wert der idFlaSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignal }
     *     
     */
    public void setIDFlaSignal(TCIDSignal value) {
        this.idFlaSignal = value;
    }

}
