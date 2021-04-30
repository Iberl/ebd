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
 * <p>Java-Klasse f�r CLST_Planung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLST_Planung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fachdaten" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CFachdaten"/>
 *         &lt;element name="Objektmanagement" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CObjektmanagement"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLST_Planung", propOrder = {
    "fachdaten",
    "objektmanagement"
})
public class CLSTPlanung {

    @XmlElement(name = "Fachdaten", required = true)
    protected CFachdaten fachdaten;
    @XmlElement(name = "Objektmanagement", required = true)
    protected CObjektmanagement objektmanagement;

    /**
     * Ruft den Wert der fachdaten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFachdaten }
     *     
     */
    public CFachdaten getFachdaten() {
        return fachdaten;
    }

    /**
     * Legt den Wert der fachdaten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFachdaten }
     *     
     */
    public void setFachdaten(CFachdaten value) {
        this.fachdaten = value;
    }

    /**
     * Ruft den Wert der objektmanagement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CObjektmanagement }
     *     
     */
    public CObjektmanagement getObjektmanagement() {
        return objektmanagement;
    }

    /**
     * Legt den Wert der objektmanagement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CObjektmanagement }
     *     
     */
    public void setObjektmanagement(CObjektmanagement value) {
        this.objektmanagement = value;
    }

}
