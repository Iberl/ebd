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
 * <p>Java-Klasse f�r CFT_ETCS_Trans_Merkmale complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFT_ETCS_Trans_Merkmale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FT_ETCS_Trans_Paket_41" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CFT_ETCS_Trans_Paket_41" maxOccurs="unbounded"/>
 *         &lt;element name="FT_ETCS_Trans_Paket_N" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CFT_ETCS_Trans_Paket_N" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFT_ETCS_Trans_Merkmale", propOrder = {
    "ftetcsTransPaket41",
    "ftetcsTransPaketN"
})
public class CFTETCSTransMerkmale {

    @XmlElement(name = "FT_ETCS_Trans_Paket_41", required = true)
    protected List<CFTETCSTransPaket41> ftetcsTransPaket41;
    @XmlElement(name = "FT_ETCS_Trans_Paket_N")
    protected List<CFTETCSTransPaketN> ftetcsTransPaketN;

    /**
     * Gets the value of the ftetcsTransPaket41 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ftetcsTransPaket41 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFTETCSTransPaket41().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFTETCSTransPaket41 }
     * 
     * 
     */
    public List<CFTETCSTransPaket41> getFTETCSTransPaket41() {
        if (ftetcsTransPaket41 == null) {
            ftetcsTransPaket41 = new ArrayList<CFTETCSTransPaket41>();
        }
        return this.ftetcsTransPaket41;
    }

    /**
     * Gets the value of the ftetcsTransPaketN property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ftetcsTransPaketN property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFTETCSTransPaketN().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFTETCSTransPaketN }
     * 
     * 
     */
    public List<CFTETCSTransPaketN> getFTETCSTransPaketN() {
        if (ftetcsTransPaketN == null) {
            ftetcsTransPaketN = new ArrayList<CFTETCSTransPaketN>();
        }
        return this.ftetcsTransPaketN;
    }

}
