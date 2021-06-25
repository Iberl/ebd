//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.flankenschutz._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDFlaSchutz;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFla_Schutz_Weitergabe complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFla_Schutz_Weitergabe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Fla_Weitergabe_L" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fla_Schutz" minOccurs="0"/>
 *         &lt;element name="ID_Fla_Weitergabe_R" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fla_Schutz" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFla_Schutz_Weitergabe", propOrder = {
    "idFlaWeitergabeL",
    "idFlaWeitergabeR"
})
public class CFlaSchutzWeitergabe {

    @XmlElement(name = "ID_Fla_Weitergabe_L")
    protected TCIDFlaSchutz idFlaWeitergabeL;
    @XmlElement(name = "ID_Fla_Weitergabe_R")
    protected TCIDFlaSchutz idFlaWeitergabeR;

    /**
     * Ruft den Wert der idFlaWeitergabeL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFlaSchutz }
     *     
     */
    public TCIDFlaSchutz getIDFlaWeitergabeL() {
        return idFlaWeitergabeL;
    }

    /**
     * Legt den Wert der idFlaWeitergabeL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFlaSchutz }
     *     
     */
    public void setIDFlaWeitergabeL(TCIDFlaSchutz value) {
        this.idFlaWeitergabeL = value;
    }

    /**
     * Ruft den Wert der idFlaWeitergabeR-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFlaSchutz }
     *     
     */
    public TCIDFlaSchutz getIDFlaWeitergabeR() {
        return idFlaWeitergabeR;
    }

    /**
     * Legt den Wert der idFlaWeitergabeR-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFlaSchutz }
     *     
     */
    public void setIDFlaWeitergabeR(TCIDFlaSchutz value) {
        this.idFlaWeitergabeR = value;
    }

}
