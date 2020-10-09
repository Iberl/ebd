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
 * Bereich, in dem besondere Lichtraumbedingungen vorhanden sind. Es werden nur die Bereiche angegeben, in denen von der EBO abweichende und LST-relevante Lichtraumbedingungen vorhanden oder zu beachten sind. 
 * 
 * <p>Java-Klasse f�r CGleis_Lichtraum complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGleis_Lichtraum">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Lichtraumprofil" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}TCLichtraumprofil"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGleis_Lichtraum", propOrder = {
    "lichtraumprofil"
})
public class CGleisLichtraum
    extends CBereichObjekt
{

    @XmlElement(name = "Lichtraumprofil", required = true)
    protected TCLichtraumprofil lichtraumprofil;

    /**
     * Ruft den Wert der lichtraumprofil-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLichtraumprofil }
     *     
     */
    public TCLichtraumprofil getLichtraumprofil() {
        return lichtraumprofil;
    }

    /**
     * Legt den Wert der lichtraumprofil-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLichtraumprofil }
     *     
     */
    public void setLichtraumprofil(TCLichtraumprofil value) {
        this.lichtraumprofil = value;
    }

}
