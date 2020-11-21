//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basisobjekte._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDTOPKante;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBereich_Objekt_Teilbereich complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBereich_Objekt_Teilbereich">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Begrenzung_A" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCBegrenzung_A"/>
 *         &lt;element name="Begrenzung_B" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCBegrenzung_B"/>
 *         &lt;element name="ID_TOP_Kante" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_TOP_Kante"/>
 *         &lt;element name="Richtungsbezug" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCRichtungsbezug" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBereich_Objekt_Teilbereich", propOrder = {
    "begrenzungA",
    "begrenzungB",
    "idtopKante",
    "richtungsbezug"
})
public class CBereichObjektTeilbereich {

    @XmlElement(name = "Begrenzung_A", required = true)
    protected TCBegrenzungA begrenzungA;
    @XmlElement(name = "Begrenzung_B", required = true)
    protected TCBegrenzungB begrenzungB;
    @XmlElement(name = "ID_TOP_Kante", required = true)
    protected TCIDTOPKante idtopKante;
    @XmlElement(name = "Richtungsbezug")
    protected TCRichtungsbezug richtungsbezug;

    /**
     * Ruft den Wert der begrenzungA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBegrenzungA }
     *     
     */
    public TCBegrenzungA getBegrenzungA() {
        return begrenzungA;
    }

    /**
     * Legt den Wert der begrenzungA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBegrenzungA }
     *     
     */
    public void setBegrenzungA(TCBegrenzungA value) {
        this.begrenzungA = value;
    }

    /**
     * Ruft den Wert der begrenzungB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBegrenzungB }
     *     
     */
    public TCBegrenzungB getBegrenzungB() {
        return begrenzungB;
    }

    /**
     * Legt den Wert der begrenzungB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBegrenzungB }
     *     
     */
    public void setBegrenzungB(TCBegrenzungB value) {
        this.begrenzungB = value;
    }

    /**
     * Ruft den Wert der idtopKante-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDTOPKante }
     *     
     */
    public TCIDTOPKante getIDTOPKante() {
        return idtopKante;
    }

    /**
     * Legt den Wert der idtopKante-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDTOPKante }
     *     
     */
    public void setIDTOPKante(TCIDTOPKante value) {
        this.idtopKante = value;
    }

    /**
     * Ruft den Wert der richtungsbezug-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRichtungsbezug }
     *     
     */
    public TCRichtungsbezug getRichtungsbezug() {
        return richtungsbezug;
    }

    /**
     * Legt den Wert der richtungsbezug-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRichtungsbezug }
     *     
     */
    public void setRichtungsbezug(TCRichtungsbezug value) {
        this.richtungsbezug = value;
    }

}
