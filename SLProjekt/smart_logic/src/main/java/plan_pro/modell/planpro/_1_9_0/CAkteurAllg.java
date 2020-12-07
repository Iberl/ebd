//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CAkteur_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CAkteur_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name_Akteur" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCName_Akteur"/>
 *         &lt;element name="Name_Akteur_10" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCName_Akteur_10"/>
 *         &lt;element name="Name_Akteur_5" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCName_Akteur_5"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CAkteur_Allg", propOrder = {
    "nameAkteur",
    "nameAkteur10",
    "nameAkteur5"
})
public class CAkteurAllg {

    @XmlElement(name = "Name_Akteur", required = true)
    protected TCNameAkteur nameAkteur;
    @XmlElement(name = "Name_Akteur_10", required = true)
    protected TCNameAkteur10 nameAkteur10;
    @XmlElement(name = "Name_Akteur_5", required = true)
    protected TCNameAkteur5 nameAkteur5;

    /**
     * Ruft den Wert der nameAkteur-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNameAkteur }
     *     
     */
    public TCNameAkteur getNameAkteur() {
        return nameAkteur;
    }

    /**
     * Legt den Wert der nameAkteur-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNameAkteur }
     *     
     */
    public void setNameAkteur(TCNameAkteur value) {
        this.nameAkteur = value;
    }

    /**
     * Ruft den Wert der nameAkteur10-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNameAkteur10 }
     *     
     */
    public TCNameAkteur10 getNameAkteur10() {
        return nameAkteur10;
    }

    /**
     * Legt den Wert der nameAkteur10-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNameAkteur10 }
     *     
     */
    public void setNameAkteur10(TCNameAkteur10 value) {
        this.nameAkteur10 = value;
    }

    /**
     * Ruft den Wert der nameAkteur5-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNameAkteur5 }
     *     
     */
    public TCNameAkteur5 getNameAkteur5() {
        return nameAkteur5;
    }

    /**
     * Legt den Wert der nameAkteur5-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNameAkteur5 }
     *     
     */
    public void setNameAkteur5(TCNameAkteur5 value) {
        this.nameAkteur5 = value;
    }

}
