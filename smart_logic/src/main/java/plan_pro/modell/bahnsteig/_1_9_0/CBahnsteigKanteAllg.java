//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnsteig._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBahnsteig_Kante_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBahnsteig_Kante_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Lage_Zum_Gleis" type="{http://www.plan-pro.org/modell/Bahnsteig/1.9.0.2}TCLage_Zum_Gleis"/>
 *         &lt;element name="Systemhoehe" type="{http://www.plan-pro.org/modell/Bahnsteig/1.9.0.2}TCSystemhoehe" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBahnsteig_Kante_Allg", propOrder = {
    "lageZumGleis",
    "systemhoehe"
})
public class CBahnsteigKanteAllg {

    @XmlElement(name = "Lage_Zum_Gleis", required = true)
    protected TCLageZumGleis lageZumGleis;
    @XmlElement(name = "Systemhoehe")
    protected TCSystemhoehe systemhoehe;

    /**
     * Ruft den Wert der lageZumGleis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLageZumGleis }
     *     
     */
    public TCLageZumGleis getLageZumGleis() {
        return lageZumGleis;
    }

    /**
     * Legt den Wert der lageZumGleis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLageZumGleis }
     *     
     */
    public void setLageZumGleis(TCLageZumGleis value) {
        this.lageZumGleis = value;
    }

    /**
     * Ruft den Wert der systemhoehe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSystemhoehe }
     *     
     */
    public TCSystemhoehe getSystemhoehe() {
        return systemhoehe;
    }

    /**
     * Legt den Wert der systemhoehe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSystemhoehe }
     *     
     */
    public void setSystemhoehe(TCSystemhoehe value) {
        this.systemhoehe = value;
    }

}
