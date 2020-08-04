//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.gleis._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBereichObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Markierung eines Gleisbereiches als Baubereich. Mit diesem Objekt wird der Bereich markiert, der w�hrend einer Planung als Baubereich verwendet wird. Die Topologie des Baubereiches und die verorteten Objekte bleiben erhalten. 
 * 
 * <p>Java-Klasse f�r CGleis_Baubereich complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGleis_Baubereich">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Baubereich_Art" type="{http://www.plan-pro.org/modell/Gleis/1.9.0.2}TCBaubereich_Art"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGleis_Baubereich", propOrder = {
    "baubereichArt"
})
public class CGleisBaubereich
    extends CBereichObjekt
{

    @XmlElement(name = "Baubereich_Art", required = true)
    protected TCBaubereichArt baubereichArt;

    /**
     * Ruft den Wert der baubereichArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBaubereichArt }
     *     
     */
    public TCBaubereichArt getBaubereichArt() {
        return baubereichArt;
    }

    /**
     * Legt den Wert der baubereichArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBaubereichArt }
     *     
     */
    public void setBaubereichArt(TCBaubereichArt value) {
        this.baubereichArt = value;
    }

}
