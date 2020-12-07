//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.gleis._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBereichObjekt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Klassifizierung des Gleises aus betrieblicher Sicht. Es erfolgt die Unterscheidung in Haupt- und Nebengleise in einem Bahnhof, sowie die Abgrenzung von Strecken und Anschlussgleisen. 
 * 
 * <p>Java-Klasse f�r CGleis_Art complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGleis_Art">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Gleisart" type="{http://www.plan-pro.org/modell/Gleis/1.9.0.2}TCGleisart"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGleis_Art", propOrder = {
    "gleisart"
})
public class CGleisArt
    extends CBereichObjekt
{

    @XmlElement(name = "Gleisart", required = true)
    protected TCGleisart gleisart;

    /**
     * Ruft den Wert der gleisart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGleisart }
     *     
     */
    public TCGleisart getGleisart() {
        return gleisart;
    }

    /**
     * Legt den Wert der gleisart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGleisart }
     *     
     */
    public void setGleisart(TCGleisart value) {
        this.gleisart = value;
    }

}
