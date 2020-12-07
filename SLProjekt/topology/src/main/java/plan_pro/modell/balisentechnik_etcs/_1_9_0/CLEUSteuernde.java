//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDLEUAnlage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CLEU_Steuernde complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLEU_Steuernde">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_LEU_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_LEU_Anlage"/>
 *         &lt;element name="LEU_Ausgang_Nr" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCLEU_Ausgang_Nr" maxOccurs="16"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLEU_Steuernde", propOrder = {
    "idleuAnlage",
    "leuAusgangNr"
})
public class CLEUSteuernde {

    @XmlElement(name = "ID_LEU_Anlage", required = true)
    protected TCIDLEUAnlage idleuAnlage;
    @XmlElement(name = "LEU_Ausgang_Nr", required = true)
    protected List<TCLEUAusgangNr> leuAusgangNr;

    /**
     * Ruft den Wert der idleuAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDLEUAnlage }
     *     
     */
    public TCIDLEUAnlage getIDLEUAnlage() {
        return idleuAnlage;
    }

    /**
     * Legt den Wert der idleuAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDLEUAnlage }
     *     
     */
    public void setIDLEUAnlage(TCIDLEUAnlage value) {
        this.idleuAnlage = value;
    }

    /**
     * Gets the value of the leuAusgangNr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the leuAusgangNr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLEUAusgangNr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCLEUAusgangNr }
     * 
     * 
     */
    public List<TCLEUAusgangNr> getLEUAusgangNr() {
        if (leuAusgangNr == null) {
            leuAusgangNr = new ArrayList<TCLEUAusgangNr>();
        }
        return this.leuAusgangNr;
    }

}
