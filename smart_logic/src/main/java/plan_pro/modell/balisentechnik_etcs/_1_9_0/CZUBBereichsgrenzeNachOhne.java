//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CZUB_Bereichsgrenze_Nach_Ohne complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZUB_Bereichsgrenze_Nach_Ohne">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bgrenze_Nach_Ohne_Bed_Einstieg" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CBgrenze_Nach_Ohne_Bed_Einstieg" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZUB_Bereichsgrenze_Nach_Ohne", propOrder = {
    "bgrenzeNachOhneBedEinstieg"
})
public class CZUBBereichsgrenzeNachOhne {

    @XmlElement(name = "Bgrenze_Nach_Ohne_Bed_Einstieg")
    protected List<CBgrenzeNachOhneBedEinstieg> bgrenzeNachOhneBedEinstieg;

    /**
     * Gets the value of the bgrenzeNachOhneBedEinstieg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bgrenzeNachOhneBedEinstieg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBgrenzeNachOhneBedEinstieg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBgrenzeNachOhneBedEinstieg }
     * 
     * 
     */
    public List<CBgrenzeNachOhneBedEinstieg> getBgrenzeNachOhneBedEinstieg() {
        if (bgrenzeNachOhneBedEinstieg == null) {
            bgrenzeNachOhneBedEinstieg = new ArrayList<CBgrenzeNachOhneBedEinstieg>();
        }
        return this.bgrenzeNachOhneBedEinstieg;
    }

}
