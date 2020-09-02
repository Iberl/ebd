//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.gleis._1_8;

import modell.basisobjekte._1_8.CBereichObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Feste_Fahrbahn" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}TCFeste_Fahrbahn"/>
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
    "festeFahrbahn"
})
public class CGleisFahrbahn
    extends CBereichObjekt
{

    @XmlElement(name = "Feste_Fahrbahn", required = true)
    protected TCFesteFahrbahn festeFahrbahn;

    /**
     * Ruft den Wert der festeFahrbahn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFesteFahrbahn }
     *     
     */
    public TCFesteFahrbahn getFesteFahrbahn() {
        return festeFahrbahn;
    }

    /**
     * Legt den Wert der festeFahrbahn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFesteFahrbahn }
     *     
     */
    public void setFesteFahrbahn(TCFesteFahrbahn value) {
        this.festeFahrbahn = value;
    }

}
