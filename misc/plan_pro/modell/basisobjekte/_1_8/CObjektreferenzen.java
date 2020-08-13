//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.basisobjekte._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CObjektreferenzen complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CObjektreferenzen">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DB_GDI_Referenz" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}TCDB_GDI_Referenz" minOccurs="0"/>
 *         &lt;element name="Technischer_Platz" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}TCTechnischer_Platz" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CObjektreferenzen", propOrder = {
    "dbgdiReferenz",
    "technischerPlatz"
})
public class CObjektreferenzen {

    @XmlElement(name = "DB_GDI_Referenz")
    protected TCDBGDIReferenz dbgdiReferenz;
    @XmlElement(name = "Technischer_Platz")
    protected TCTechnischerPlatz technischerPlatz;

    /**
     * Ruft den Wert der dbgdiReferenz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDBGDIReferenz }
     *     
     */
    public TCDBGDIReferenz getDBGDIReferenz() {
        return dbgdiReferenz;
    }

    /**
     * Legt den Wert der dbgdiReferenz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDBGDIReferenz }
     *     
     */
    public void setDBGDIReferenz(TCDBGDIReferenz value) {
        this.dbgdiReferenz = value;
    }

    /**
     * Ruft den Wert der technischerPlatz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTechnischerPlatz }
     *     
     */
    public TCTechnischerPlatz getTechnischerPlatz() {
        return technischerPlatz;
    }

    /**
     * Legt den Wert der technischerPlatz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTechnischerPlatz }
     *     
     */
    public void setTechnischerPlatz(TCTechnischerPlatz value) {
        this.technischerPlatz = value;
    }

}
