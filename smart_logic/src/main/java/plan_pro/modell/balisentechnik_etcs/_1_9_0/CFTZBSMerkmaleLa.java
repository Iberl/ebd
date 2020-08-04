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
 * <p>Java-Klasse f�r CFT_ZBS_Merkmale_La complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFT_ZBS_Merkmale_La">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ZBS_La_Bereich_Distanz" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCZBS_La_Bereich_Distanz"/>
 *         &lt;element name="ZBS_La_Bereich_Geschwindigkeit" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCZBS_La_Bereich_Geschwindigkeit"/>
 *         &lt;element name="ZBS_La_Bereich_Laenge" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCZBS_La_Bereich_Laenge"/>
 *         &lt;element name="ZBS_La_Bereich_Neigung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCZBS_La_Bereich_Neigung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFT_ZBS_Merkmale_La", propOrder = {
    "zbsLaBereichDistanz",
    "zbsLaBereichGeschwindigkeit",
    "zbsLaBereichLaenge",
    "zbsLaBereichNeigung"
})
public class CFTZBSMerkmaleLa {

    @XmlElement(name = "ZBS_La_Bereich_Distanz", required = true)
    protected TCZBSLaBereichDistanz zbsLaBereichDistanz;
    @XmlElement(name = "ZBS_La_Bereich_Geschwindigkeit", required = true)
    protected TCZBSLaBereichGeschwindigkeit zbsLaBereichGeschwindigkeit;
    @XmlElement(name = "ZBS_La_Bereich_Laenge", required = true)
    protected TCZBSLaBereichLaenge zbsLaBereichLaenge;
    @XmlElement(name = "ZBS_La_Bereich_Neigung", required = true)
    protected TCZBSLaBereichNeigung zbsLaBereichNeigung;

    /**
     * Ruft den Wert der zbsLaBereichDistanz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZBSLaBereichDistanz }
     *     
     */
    public TCZBSLaBereichDistanz getZBSLaBereichDistanz() {
        return zbsLaBereichDistanz;
    }

    /**
     * Legt den Wert der zbsLaBereichDistanz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZBSLaBereichDistanz }
     *     
     */
    public void setZBSLaBereichDistanz(TCZBSLaBereichDistanz value) {
        this.zbsLaBereichDistanz = value;
    }

    /**
     * Ruft den Wert der zbsLaBereichGeschwindigkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZBSLaBereichGeschwindigkeit }
     *     
     */
    public TCZBSLaBereichGeschwindigkeit getZBSLaBereichGeschwindigkeit() {
        return zbsLaBereichGeschwindigkeit;
    }

    /**
     * Legt den Wert der zbsLaBereichGeschwindigkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZBSLaBereichGeschwindigkeit }
     *     
     */
    public void setZBSLaBereichGeschwindigkeit(TCZBSLaBereichGeschwindigkeit value) {
        this.zbsLaBereichGeschwindigkeit = value;
    }

    /**
     * Ruft den Wert der zbsLaBereichLaenge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZBSLaBereichLaenge }
     *     
     */
    public TCZBSLaBereichLaenge getZBSLaBereichLaenge() {
        return zbsLaBereichLaenge;
    }

    /**
     * Legt den Wert der zbsLaBereichLaenge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZBSLaBereichLaenge }
     *     
     */
    public void setZBSLaBereichLaenge(TCZBSLaBereichLaenge value) {
        this.zbsLaBereichLaenge = value;
    }

    /**
     * Ruft den Wert der zbsLaBereichNeigung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZBSLaBereichNeigung }
     *     
     */
    public TCZBSLaBereichNeigung getZBSLaBereichNeigung() {
        return zbsLaBereichNeigung;
    }

    /**
     * Legt den Wert der zbsLaBereichNeigung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZBSLaBereichNeigung }
     *     
     */
    public void setZBSLaBereichNeigung(TCZBSLaBereichNeigung value) {
        this.zbsLaBereichNeigung = value;
    }

}
