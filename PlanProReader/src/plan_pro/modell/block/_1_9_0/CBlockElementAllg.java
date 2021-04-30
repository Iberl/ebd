//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.block._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBlock_Element_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBlock_Element_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Block_Bauform" type="{http://www.plan-pro.org/modell/Block/1.9.0.2}TCBlock_Bauform"/>
 *         &lt;element name="Rueckblockwecker" type="{http://www.plan-pro.org/modell/Block/1.9.0.2}TCRueckblockwecker"/>
 *         &lt;element name="Vorblockwecker" type="{http://www.plan-pro.org/modell/Block/1.9.0.2}TCVorblockwecker"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBlock_Element_Allg", propOrder = {
    "blockBauform",
    "rueckblockwecker",
    "vorblockwecker"
})
public class CBlockElementAllg {

    @XmlElement(name = "Block_Bauform", required = true)
    protected TCBlockBauform blockBauform;
    @XmlElement(name = "Rueckblockwecker", required = true)
    protected TCRueckblockwecker rueckblockwecker;
    @XmlElement(name = "Vorblockwecker", required = true)
    protected TCVorblockwecker vorblockwecker;

    /**
     * Ruft den Wert der blockBauform-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBlockBauform }
     *     
     */
    public TCBlockBauform getBlockBauform() {
        return blockBauform;
    }

    /**
     * Legt den Wert der blockBauform-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBlockBauform }
     *     
     */
    public void setBlockBauform(TCBlockBauform value) {
        this.blockBauform = value;
    }

    /**
     * Ruft den Wert der rueckblockwecker-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRueckblockwecker }
     *     
     */
    public TCRueckblockwecker getRueckblockwecker() {
        return rueckblockwecker;
    }

    /**
     * Legt den Wert der rueckblockwecker-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRueckblockwecker }
     *     
     */
    public void setRueckblockwecker(TCRueckblockwecker value) {
        this.rueckblockwecker = value;
    }

    /**
     * Ruft den Wert der vorblockwecker-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVorblockwecker }
     *     
     */
    public TCVorblockwecker getVorblockwecker() {
        return vorblockwecker;
    }

    /**
     * Legt den Wert der vorblockwecker-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVorblockwecker }
     *     
     */
    public void setVorblockwecker(TCVorblockwecker value) {
        this.vorblockwecker = value;
    }

}
