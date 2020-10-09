//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.geodaten._1_8;

import modell.basisobjekte._1_8.CBereichObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Topologische Darstellung der Kilometrierungsachse. Die topologische Kilometrierungsachse wird durch fortlaufende Aneinanderreihung von GEO-Kanten gebildet, die mittels ID GEO Art auf diese Strecke verweisen. 
 * 
 * <p>Java-Klasse f�r CStrecke complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CStrecke">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CStrecke_Bezeichnung"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CStrecke", propOrder = {
    "bezeichnung"
})
public class CStrecke
    extends CBereichObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CStreckeBezeichnung bezeichnung;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CStreckeBezeichnung }
     *     
     */
    public CStreckeBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CStreckeBezeichnung }
     *     
     */
    public void setBezeichnung(CStreckeBezeichnung value) {
        this.bezeichnung = value;
    }

}
