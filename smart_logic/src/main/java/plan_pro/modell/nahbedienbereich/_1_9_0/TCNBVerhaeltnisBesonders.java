//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.nahbedienbereich._1_9_0;

import plan_pro.modell.basistypen._1_9_0.CBasisAttribut;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Java-Klasse f�r TCNB_Verhaeltnis_Besonders complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TCNB_Verhaeltnis_Besonders">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}CBasisAttribut">
 *       &lt;sequence>
 *         &lt;element name="Wert" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}ENUMNB_Verhaeltnis_Besonders"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCNB_Verhaeltnis_Besonders", propOrder = {
    "wert"
})
public class TCNBVerhaeltnisBesonders
    extends CBasisAttribut
{

    @XmlElement(name = "Wert", required = true, nillable = true)
    @XmlSchemaType(name = "string")
    protected ENUMNBVerhaeltnisBesonders wert;

    /**
     * Ruft den Wert der wert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ENUMNBVerhaeltnisBesonders }
     *     
     */
    public ENUMNBVerhaeltnisBesonders getWert() {
        return wert;
    }

    /**
     * Legt den Wert der wert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ENUMNBVerhaeltnisBesonders }
     *     
     */
    public void setWert(ENUMNBVerhaeltnisBesonders value) {
        this.wert = value;
    }

}
