//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.gleis._1_8;

import modell.basisobjekte._1_8.CBereichObjekt;
import modell.basistypen._1_8.CBezeichnungElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tr�ger der betrieblichen Bezeichnung eines Gleises. Ein Gleis erh�lt dann eine Bezeichnung, wenn es f�r die betriebliche Nutzung ben�tigt wird. Topologische Knoten (z. B. Weichen) unterbrechen nicht die Gleisbezeichnung. F�r die durchgehenden Hauptgleise in einem Bahnhof wird das Bereichsobjekt f�r das Gleis in der Regel von einem Einfahrsignal bis zum Einfahrsignal der Gegenrichtung modelliert. Wenn das Gleis hinsichtlich der betrieblichen Bezeichnung geteilt ist (z.B. Gleis 1 und Gleis 21) sind getrennte Bereichsobjekte f�r diese Gleise anzulegen. Weitere Bezeichnungen von Bahnhofsgleisen werden in der Regel zwischen topologischen Knoten gebildet, wobei auch weitere Knoten enthalten sein k�nnen. Gleise, die aus betrieblicher Sicht keine Bezeichnung ben�tigen (z. B. Gleisverbindungen), erhalten keine Gleisbezeichnung. Streckengleise werden in der Regel zwischen den Bahnhofsgrenzen (ggf. auch andere Zugmeldestellen) durchgehend bezeichnet. Die Klammersetzung der Bezeichung von Streckengleisen ist Bestandteil der Bezeichung das Steckengleises. Die Attributgruppe Gleis_Bezeichnung_Allg soll nach Version 1.8.0 entfernt und daher nicht mehr verwendet werden.
 * 
 * <p>Java-Klasse f�r CGleis_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGleis_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/BasisTypen/1.8.0}CBezeichnung_Element"/>
 *         &lt;element name="Gleis_Bezeichnung_Allg" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}CGleis_Bezeichnung_Allg" minOccurs="0"/>
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
    "bezeichnung",
    "gleisBezeichnungAllg"
})
public class CGleisBezeichnung
    extends CBereichObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CBezeichnungElement bezeichnung;
    @XmlElement(name = "Gleis_Bezeichnung_Allg")
    protected CGleisBezeichnungAllg gleisBezeichnungAllg;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBezeichnungElement }
     *     
     */
    public CBezeichnungElement getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBezeichnungElement }
     *     
     */
    public void setBezeichnung(CBezeichnungElement value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der gleisBezeichnungAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CGleisBezeichnungAllg }
     *     
     */
    public CGleisBezeichnungAllg getGleisBezeichnungAllg() {
        return gleisBezeichnungAllg;
    }

    /**
     * Legt den Wert der gleisBezeichnungAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CGleisBezeichnungAllg }
     *     
     */
    public void setGleisBezeichnungAllg(CGleisBezeichnungAllg value) {
        this.gleisBezeichnungAllg = value;
    }

}
