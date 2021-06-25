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
 * <p>Java-Klasse f�r CDP_Typ_GETCS complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CDP_Typ_GETCS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DP_Typ_ETCS" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDP_Typ_ETCS" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CDP_Typ_GETCS", propOrder = {
    "dpTypETCS"
})
public class CDPTypGETCS {

    @XmlElement(name = "DP_Typ_ETCS", required = true)
    protected List<TCDPTypETCS> dpTypETCS;

    /**
     * Gets the value of the dpTypETCS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dpTypETCS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDPTypETCS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCDPTypETCS }
     * 
     * 
     */
    public List<TCDPTypETCS> getDPTypETCS() {
        if (dpTypETCS == null) {
            dpTypETCS = new ArrayList<TCDPTypETCS>();
        }
        return this.dpTypETCS;
    }

}
