//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import plan_pro.modell.basistypen._1_9_0.CBasisAttribut;

import javax.xml.bind.annotation.*;


/**
 * <p>Java-Klasse f�r TCTP_Art complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TCTP_Art">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}CBasisAttribut">
 *       &lt;sequence>
 *         &lt;element name="Wert" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}ENUMTP_Art"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCTP_Art", propOrder = {
    "wert"
})
public class TCTPArt
    extends CBasisAttribut
{

    @XmlElement(name = "Wert", required = true, nillable = true)
    @XmlSchemaType(name = "string")
    protected ENUMTPArt wert;

    /**
     * Ruft den Wert der wert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ENUMTPArt }
     *     
     */
    public ENUMTPArt getWert() {
        return wert;
    }

    /**
     * Legt den Wert der wert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ENUMTPArt }
     *     
     */
    public void setWert(ENUMTPArt value) {
        this.wert = value;
    }

}
