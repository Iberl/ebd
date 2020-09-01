//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.flankenschutz._1_8;

import modell.verweise._1_8.TCIDFlaSchutz;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFla_Zwieschutz_Element complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFla_Zwieschutz_Element">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Fla_Schutz_L" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Fla_Schutz" minOccurs="0"/>
 *         &lt;element name="ID_Fla_Schutz_R" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Fla_Schutz" minOccurs="0"/>
 *         &lt;element name="Massnahme_L" type="{http://www.plan-pro.org/modell/Flankenschutz/1.8.0}TCMassnahme"/>
 *         &lt;element name="Massnahme_R" type="{http://www.plan-pro.org/modell/Flankenschutz/1.8.0}TCMassnahme"/>
 *         &lt;element name="Nachlaufverhinderung" type="{http://www.plan-pro.org/modell/Flankenschutz/1.8.0}TCNachlaufverhinderung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFla_Zwieschutz_Element", propOrder = {
    "idFlaSchutzL",
    "idFlaSchutzR",
    "massnahmeL",
    "massnahmeR",
    "nachlaufverhinderung"
})
public class CFlaZwieschutzElement {

    @XmlElement(name = "ID_Fla_Schutz_L")
    protected TCIDFlaSchutz idFlaSchutzL;
    @XmlElement(name = "ID_Fla_Schutz_R")
    protected TCIDFlaSchutz idFlaSchutzR;
    @XmlElement(name = "Massnahme_L", required = true)
    protected TCMassnahme massnahmeL;
    @XmlElement(name = "Massnahme_R", required = true)
    protected TCMassnahme massnahmeR;
    @XmlElement(name = "Nachlaufverhinderung", required = true)
    protected TCNachlaufverhinderung nachlaufverhinderung;

    /**
     * Ruft den Wert der idFlaSchutzL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFlaSchutz }
     *     
     */
    public TCIDFlaSchutz getIDFlaSchutzL() {
        return idFlaSchutzL;
    }

    /**
     * Legt den Wert der idFlaSchutzL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFlaSchutz }
     *     
     */
    public void setIDFlaSchutzL(TCIDFlaSchutz value) {
        this.idFlaSchutzL = value;
    }

    /**
     * Ruft den Wert der idFlaSchutzR-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFlaSchutz }
     *     
     */
    public TCIDFlaSchutz getIDFlaSchutzR() {
        return idFlaSchutzR;
    }

    /**
     * Legt den Wert der idFlaSchutzR-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFlaSchutz }
     *     
     */
    public void setIDFlaSchutzR(TCIDFlaSchutz value) {
        this.idFlaSchutzR = value;
    }

    /**
     * Ruft den Wert der massnahmeL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMassnahme }
     *     
     */
    public TCMassnahme getMassnahmeL() {
        return massnahmeL;
    }

    /**
     * Legt den Wert der massnahmeL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMassnahme }
     *     
     */
    public void setMassnahmeL(TCMassnahme value) {
        this.massnahmeL = value;
    }

    /**
     * Ruft den Wert der massnahmeR-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMassnahme }
     *     
     */
    public TCMassnahme getMassnahmeR() {
        return massnahmeR;
    }

    /**
     * Legt den Wert der massnahmeR-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMassnahme }
     *     
     */
    public void setMassnahmeR(TCMassnahme value) {
        this.massnahmeR = value;
    }

    /**
     * Ruft den Wert der nachlaufverhinderung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNachlaufverhinderung }
     *     
     */
    public TCNachlaufverhinderung getNachlaufverhinderung() {
        return nachlaufverhinderung;
    }

    /**
     * Legt den Wert der nachlaufverhinderung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNachlaufverhinderung }
     *     
     */
    public void setNachlaufverhinderung(TCNachlaufverhinderung value) {
        this.nachlaufverhinderung = value;
    }

}
