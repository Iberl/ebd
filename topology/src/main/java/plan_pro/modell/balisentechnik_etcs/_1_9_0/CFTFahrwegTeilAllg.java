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


/**
 * <p>Java-Klasse f�r CFT_Fahrweg_Teil_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFT_Fahrweg_Teil_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Umfahrstrasse" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCUmfahrstrasse"/>
 *         &lt;element name="Ziel_Ist_Fahrwegende" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCZiel_Ist_Fahrwegende"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFT_Fahrweg_Teil_Allg", propOrder = {
    "umfahrstrasse",
    "zielIstFahrwegende"
})
public class CFTFahrwegTeilAllg {

    @XmlElement(name = "Umfahrstrasse", required = true)
    protected TCUmfahrstrasse umfahrstrasse;
    @XmlElement(name = "Ziel_Ist_Fahrwegende", required = true)
    protected TCZielIstFahrwegende zielIstFahrwegende;

    /**
     * Ruft den Wert der umfahrstrasse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUmfahrstrasse }
     *     
     */
    public TCUmfahrstrasse getUmfahrstrasse() {
        return umfahrstrasse;
    }

    /**
     * Legt den Wert der umfahrstrasse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUmfahrstrasse }
     *     
     */
    public void setUmfahrstrasse(TCUmfahrstrasse value) {
        this.umfahrstrasse = value;
    }

    /**
     * Ruft den Wert der zielIstFahrwegende-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZielIstFahrwegende }
     *     
     */
    public TCZielIstFahrwegende getZielIstFahrwegende() {
        return zielIstFahrwegende;
    }

    /**
     * Legt den Wert der zielIstFahrwegende-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZielIstFahrwegende }
     *     
     */
    public void setZielIstFahrwegende(TCZielIstFahrwegende value) {
        this.zielIstFahrwegende = value;
    }

}
