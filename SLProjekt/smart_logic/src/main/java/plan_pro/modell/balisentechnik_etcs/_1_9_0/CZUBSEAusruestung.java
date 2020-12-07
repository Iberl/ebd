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
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CZUB_SE_Ausruestung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZUB_SE_Ausruestung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Anwendungssystem" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCAnwendungssystem" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZUB_SE_Ausruestung", propOrder = {
    "anwendungssystem"
})
public class CZUBSEAusruestung {

    @XmlElement(name = "Anwendungssystem", required = true)
    protected List<TCAnwendungssystem> anwendungssystem;

    /**
     * Gets the value of the anwendungssystem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anwendungssystem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnwendungssystem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCAnwendungssystem }
     * 
     * 
     */
    public List<TCAnwendungssystem> getAnwendungssystem() {
        if (anwendungssystem == null) {
            anwendungssystem = new ArrayList<TCAnwendungssystem>();
        }
        return this.anwendungssystem;
    }

}
