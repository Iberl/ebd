//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.nahbedienbereich._1_8;

import modell.basistypen._1_8.CBasisAttribut;

import javax.xml.bind.annotation.*;


/**
 * <p>Java-Klasse f�r TCNB_Unterstellungsverhaeltnis complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TCNB_Unterstellungsverhaeltnis">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/BasisTypen/1.8.0}CBasisAttribut">
 *       &lt;sequence>
 *         &lt;element name="Wert" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}ENUMNB_Unterstellungsverhaeltnis"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCNB_Unterstellungsverhaeltnis", propOrder = {
    "wert"
})
public class TCNBUnterstellungsverhaeltnis
    extends CBasisAttribut
{

    @XmlElement(name = "Wert", required = true, nillable = true)
    @XmlSchemaType(name = "string")
    protected ENUMNBUnterstellungsverhaeltnis wert;

    /**
     * Ruft den Wert der wert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ENUMNBUnterstellungsverhaeltnis }
     *     
     */
    public ENUMNBUnterstellungsverhaeltnis getWert() {
        return wert;
    }

    /**
     * Legt den Wert der wert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ENUMNBUnterstellungsverhaeltnis }
     *     
     */
    public void setWert(ENUMNBUnterstellungsverhaeltnis value) {
        this.wert = value;
    }

}
