//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDFMAAnlageRangierFrei;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CFstr_Rangier complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Rangier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Automatische_Einstellung" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCAutomatische_Einstellung" minOccurs="0"/>
 *         &lt;element name="ID_FMA_Anlage_Rangier_Frei" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_FMA_Anlage_Rangier_Frei" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Rangier_Gegenfahrtausschluss" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCRangier_Gegenfahrtausschluss" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_Rangier", propOrder = {
    "automatischeEinstellung",
    "idfmaAnlageRangierFrei",
    "rangierGegenfahrtausschluss"
})
public class CFstrRangier {

    @XmlElement(name = "Automatische_Einstellung")
    protected TCAutomatischeEinstellung automatischeEinstellung;
    @XmlElement(name = "ID_FMA_Anlage_Rangier_Frei")
    protected List<TCIDFMAAnlageRangierFrei> idfmaAnlageRangierFrei;
    @XmlElement(name = "Rangier_Gegenfahrtausschluss")
    protected TCRangierGegenfahrtausschluss rangierGegenfahrtausschluss;

    /**
     * Ruft den Wert der automatischeEinstellung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAutomatischeEinstellung }
     *     
     */
    public TCAutomatischeEinstellung getAutomatischeEinstellung() {
        return automatischeEinstellung;
    }

    /**
     * Legt den Wert der automatischeEinstellung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAutomatischeEinstellung }
     *     
     */
    public void setAutomatischeEinstellung(TCAutomatischeEinstellung value) {
        this.automatischeEinstellung = value;
    }

    /**
     * Gets the value of the idfmaAnlageRangierFrei property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idfmaAnlageRangierFrei property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDFMAAnlageRangierFrei().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDFMAAnlageRangierFrei }
     * 
     * 
     */
    public List<TCIDFMAAnlageRangierFrei> getIDFMAAnlageRangierFrei() {
        if (idfmaAnlageRangierFrei == null) {
            idfmaAnlageRangierFrei = new ArrayList<TCIDFMAAnlageRangierFrei>();
        }
        return this.idfmaAnlageRangierFrei;
    }

    /**
     * Ruft den Wert der rangierGegenfahrtausschluss-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRangierGegenfahrtausschluss }
     *     
     */
    public TCRangierGegenfahrtausschluss getRangierGegenfahrtausschluss() {
        return rangierGegenfahrtausschluss;
    }

    /**
     * Legt den Wert der rangierGegenfahrtausschluss-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRangierGegenfahrtausschluss }
     *     
     */
    public void setRangierGegenfahrtausschluss(TCRangierGegenfahrtausschluss value) {
        this.rangierGegenfahrtausschluss = value;
    }

}
