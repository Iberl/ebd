//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDSignalSignalbegriff;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CBedingung_Signal complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedingung_Signal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Signal_Signalbegriff" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal_Signalbegriff" maxOccurs="unbounded"/>
 *         &lt;element name="Verwendung_Als_Rueckfall" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCVerwendung_Als_Rueckfall" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedingung_Signal", propOrder = {
    "idSignalSignalbegriff",
    "verwendungAlsRueckfall"
})
public class CBedingungSignal {

    @XmlElement(name = "ID_Signal_Signalbegriff", required = true)
    protected List<TCIDSignalSignalbegriff> idSignalSignalbegriff;
    @XmlElement(name = "Verwendung_Als_Rueckfall")
    protected TCVerwendungAlsRueckfall verwendungAlsRueckfall;

    /**
     * Gets the value of the idSignalSignalbegriff property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idSignalSignalbegriff property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDSignalSignalbegriff().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDSignalSignalbegriff }
     * 
     * 
     */
    public List<TCIDSignalSignalbegriff> getIDSignalSignalbegriff() {
        if (idSignalSignalbegriff == null) {
            idSignalSignalbegriff = new ArrayList<TCIDSignalSignalbegriff>();
        }
        return this.idSignalSignalbegriff;
    }

    /**
     * Ruft den Wert der verwendungAlsRueckfall-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVerwendungAlsRueckfall }
     *     
     */
    public TCVerwendungAlsRueckfall getVerwendungAlsRueckfall() {
        return verwendungAlsRueckfall;
    }

    /**
     * Legt den Wert der verwendungAlsRueckfall-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVerwendungAlsRueckfall }
     *     
     */
    public void setVerwendungAlsRueckfall(TCVerwendungAlsRueckfall value) {
        this.verwendungAlsRueckfall = value;
    }

}
