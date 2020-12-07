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
 * Bereich, in dem eine besondere Fahrbahnkonstruktion vorhanden ist, die f�r die Leit- und Sicherungstechnik relevant ist (z. B. Feste Fahrbahn). 
 * 
 * <p>Java-Klasse f�r CGleis_Fahrbahn complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGleis_Fahrbahn">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Konstruktion" type="{http://www.plan-pro.org/modell/Gleis/1.9.0.2}TCKonstruktion"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGleis_Fahrbahn", propOrder = {
    "konstruktion"
})
public class CGleisFahrbahn
    extends CBereichObjekt
{

    @XmlElement(name = "Konstruktion", required = true)
    protected TCKonstruktion konstruktion;

    /**
     * Ruft den Wert der konstruktion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKonstruktion }
     *     
     */
    public TCKonstruktion getKonstruktion() {
        return konstruktion;
    }

    /**
     * Legt den Wert der konstruktion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKonstruktion }
     *     
     */
    public void setKonstruktion(TCKonstruktion value) {
        this.konstruktion = value;
    }

}
