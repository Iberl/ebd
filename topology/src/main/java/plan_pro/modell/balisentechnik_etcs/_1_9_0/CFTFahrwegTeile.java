//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDFTFahrwegTeil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFT_Fahrweg_Teile complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFT_Fahrweg_Teile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_FT_Fahrweg_Teil" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_FT_Fahrweg_Teil"/>
 *         &lt;element name="Ist_Befahren" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCIst_Befahren"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFT_Fahrweg_Teile", propOrder = {
    "idftFahrwegTeil",
    "istBefahren"
})
public class CFTFahrwegTeile {

    @XmlElement(name = "ID_FT_Fahrweg_Teil", required = true)
    protected TCIDFTFahrwegTeil idftFahrwegTeil;
    @XmlElement(name = "Ist_Befahren", required = true)
    protected TCIstBefahren istBefahren;

    /**
     * Ruft den Wert der idftFahrwegTeil-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFTFahrwegTeil }
     *     
     */
    public TCIDFTFahrwegTeil getIDFTFahrwegTeil() {
        return idftFahrwegTeil;
    }

    /**
     * Legt den Wert der idftFahrwegTeil-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFTFahrwegTeil }
     *     
     */
    public void setIDFTFahrwegTeil(TCIDFTFahrwegTeil value) {
        this.idftFahrwegTeil = value;
    }

    /**
     * Ruft den Wert der istBefahren-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIstBefahren }
     *     
     */
    public TCIstBefahren getIstBefahren() {
        return istBefahren;
    }

    /**
     * Legt den Wert der istBefahren-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIstBefahren }
     *     
     */
    public void setIstBefahren(TCIstBefahren value) {
        this.istBefahren = value;
    }

}
