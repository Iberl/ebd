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
 * Tr�ger der betrieblichen Bezeichnung eines Gleises. Ein Gleis erh�lt dann eine Bezeichnung, wenn es f�r die betriebliche Nutzung ben�tigt wird. Topologische Knoten (z. B. Weichen) unterbrechen nicht die Gleisbezeichnung. F�r die durchgehenden Hauptgleise in einem Bahnhof wird das Bereichsobjekt f�r das Gleis in der Regel von einem Einfahrsignal bis zum Einfahrsignal der Gegenrichtung modelliert. Wenn das Gleis hinsichtlich der betrieblichen Bezeichnung geteilt ist (z.B. Gleis 1 und Gleis 21) sind getrennte Bereichsobjekte f�r diese Gleise anzulegen. Weitere Bezeichnungen von Bahnhofsgleisen werden in der Regel zwischen topologischen Knoten gebildet, wobei auch weitere Knoten enthalten sein k�nnen. Gleise, die aus betrieblicher Sicht keine Bezeichnung ben�tigen (z. B. Gleisverbindungen), erhalten keine Gleisbezeichnung. Streckengleise werden in der Regel zwischen den Bahnhofsgrenzen (ggf. auch andere Zugmeldestellen) durchgehend bezeichnet. Die Klammersetzung der Bezeichung von Streckengleisen ist Bestandteil der Bezeichung das Steckengleises.
 * 
 * <p>Java-Klasse f�r CGleis_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGleis_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Gleis/1.9.0.2}CGleis_Bezeichnung_Bezeichnung"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGleis_Bezeichnung", propOrder = {
    "bezeichnung"
})
public class CGleisBezeichnung
    extends CBereichObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CGleisBezeichnungBezeichnung bezeichnung;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CGleisBezeichnungBezeichnung }
     *     
     */
    public CGleisBezeichnungBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CGleisBezeichnungBezeichnung }
     *     
     */
    public void setBezeichnung(CGleisBezeichnungBezeichnung value) {
        this.bezeichnung = value;
    }

}
