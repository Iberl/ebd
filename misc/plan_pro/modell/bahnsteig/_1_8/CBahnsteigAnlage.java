//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bahnsteig._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Parallel zum Gleis gelegenes Element des Tiefbaus mit befestigter Oberfl�che zum Zwecke des Zugangs der Reisenden von bzw. zu den Z�gen. Ein Bahnsteig kann eine oder mehrere Bahnsteigkanten besitzen. Mehr als zwei Bahnsteigkanten k�nnen dazugeh�ren, wenn z. B. an einen Mittelbahnsteig noch ein Zungenbahnsteig anschlie�t. DB-Regelwerk Ril 813.0201 
 * 
 * <p>Java-Klasse f�r CBahnsteig_Anlage complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBahnsteig_Anlage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Bahnsteig/1.8.0}CBahnsteig_Anlage_Bezeichnung" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBahnsteig_Anlage", propOrder = {
    "bezeichnung"
})
public class CBahnsteigAnlage
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung")
    protected CBahnsteigAnlageBezeichnung bezeichnung;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBahnsteigAnlageBezeichnung }
     *     
     */
    public CBahnsteigAnlageBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBahnsteigAnlageBezeichnung }
     *     
     */
    public void setBezeichnung(CBahnsteigAnlageBezeichnung value) {
        this.bezeichnung = value;
    }

}
