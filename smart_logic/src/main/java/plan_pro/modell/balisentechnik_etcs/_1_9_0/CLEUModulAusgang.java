//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDBalise;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CLEU_Modul_Ausgang complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLEU_Modul_Ausgang">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Balise" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Balise" minOccurs="0"/>
 *         &lt;element name="LEU_Ausgang_Nr" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCLEU_Ausgang_Nr" minOccurs="0"/>
 *         &lt;element name="Port_Nr_Ausg_Physisch" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCPort_Nr_Ausg_Physisch" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLEU_Modul_Ausgang", propOrder = {
    "idBalise",
    "leuAusgangNr",
    "portNrAusgPhysisch"
})
public class CLEUModulAusgang {

    @XmlElement(name = "ID_Balise")
    protected TCIDBalise idBalise;
    @XmlElement(name = "LEU_Ausgang_Nr")
    protected TCLEUAusgangNr leuAusgangNr;
    @XmlElement(name = "Port_Nr_Ausg_Physisch")
    protected TCPortNrAusgPhysisch portNrAusgPhysisch;

    /**
     * Ruft den Wert der idBalise-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBalise }
     *     
     */
    public TCIDBalise getIDBalise() {
        return idBalise;
    }

    /**
     * Legt den Wert der idBalise-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBalise }
     *     
     */
    public void setIDBalise(TCIDBalise value) {
        this.idBalise = value;
    }

    /**
     * Ruft den Wert der leuAusgangNr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLEUAusgangNr }
     *     
     */
    public TCLEUAusgangNr getLEUAusgangNr() {
        return leuAusgangNr;
    }

    /**
     * Legt den Wert der leuAusgangNr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLEUAusgangNr }
     *     
     */
    public void setLEUAusgangNr(TCLEUAusgangNr value) {
        this.leuAusgangNr = value;
    }

    /**
     * Ruft den Wert der portNrAusgPhysisch-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPortNrAusgPhysisch }
     *     
     */
    public TCPortNrAusgPhysisch getPortNrAusgPhysisch() {
        return portNrAusgPhysisch;
    }

    /**
     * Legt den Wert der portNrAusgPhysisch-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPortNrAusgPhysisch }
     *     
     */
    public void setPortNrAusgPhysisch(TCPortNrAusgPhysisch value) {
        this.portNrAusgPhysisch = value;
    }

}
