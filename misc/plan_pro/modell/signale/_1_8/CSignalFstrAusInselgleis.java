//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.signale._1_8;

import modell.verweise._1_8.TCIDSignal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSignal_Fstr_Aus_Inselgleis complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_Fstr_Aus_Inselgleis">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_RaFahrt_Gleichzeitig_Verbot" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Signal" minOccurs="0"/>
 *         &lt;element name="ID_ZgFahrt_Gleichzeitig_Verbot" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Signal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_Fstr_Aus_Inselgleis", propOrder = {
    "idRaFahrtGleichzeitigVerbot",
    "idZgFahrtGleichzeitigVerbot"
})
public class CSignalFstrAusInselgleis {

    @XmlElement(name = "ID_RaFahrt_Gleichzeitig_Verbot")
    protected TCIDSignal idRaFahrtGleichzeitigVerbot;
    @XmlElement(name = "ID_ZgFahrt_Gleichzeitig_Verbot")
    protected TCIDSignal idZgFahrtGleichzeitigVerbot;

    /**
     * Ruft den Wert der idRaFahrtGleichzeitigVerbot-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignal }
     *     
     */
    public TCIDSignal getIDRaFahrtGleichzeitigVerbot() {
        return idRaFahrtGleichzeitigVerbot;
    }

    /**
     * Legt den Wert der idRaFahrtGleichzeitigVerbot-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignal }
     *     
     */
    public void setIDRaFahrtGleichzeitigVerbot(TCIDSignal value) {
        this.idRaFahrtGleichzeitigVerbot = value;
    }

    /**
     * Ruft den Wert der idZgFahrtGleichzeitigVerbot-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignal }
     *     
     */
    public TCIDSignal getIDZgFahrtGleichzeitigVerbot() {
        return idZgFahrtGleichzeitigVerbot;
    }

    /**
     * Legt den Wert der idZgFahrtGleichzeitigVerbot-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignal }
     *     
     */
    public void setIDZgFahrtGleichzeitigVerbot(TCIDSignal value) {
        this.idZgFahrtGleichzeitigVerbot = value;
    }

}
