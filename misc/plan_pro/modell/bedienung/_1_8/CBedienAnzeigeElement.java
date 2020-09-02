//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bedienung._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDBedienEinrichtungOertlich;
import modell.verweise._1_8.TCIDVerknuepftesElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Zuordnung von Stellelementen zu einer �rtlichen Bedieneinrichtung und Abbildung von Meldern, Tasten und Schaltern einer �rtlichen Bedieneinrichtung. 
 * 
 * <p>Java-Klasse f�r CBedien_Anzeige_Element complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Anzeige_Element">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bedien_Anzeige_Element_Allg" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Anzeige_Element_Allg"/>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Anzeige_Element_Bezeichnung" minOccurs="0"/>
 *         &lt;element name="ID_Bedien_Einrichtung_Oertlich" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Bedien_Einrichtung_Oertlich"/>
 *         &lt;element name="ID_Verknuepftes_Element" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Verknuepftes_Element" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Anzeige_Element", propOrder = {
    "bedienAnzeigeElementAllg",
    "bezeichnung",
    "idBedienEinrichtungOertlich",
    "idVerknuepftesElement"
})
public class CBedienAnzeigeElement
    extends CBasisObjekt
{

    @XmlElement(name = "Bedien_Anzeige_Element_Allg", required = true)
    protected CBedienAnzeigeElementAllg bedienAnzeigeElementAllg;
    @XmlElement(name = "Bezeichnung")
    protected CBedienAnzeigeElementBezeichnung bezeichnung;
    @XmlElement(name = "ID_Bedien_Einrichtung_Oertlich", required = true)
    protected TCIDBedienEinrichtungOertlich idBedienEinrichtungOertlich;
    @XmlElement(name = "ID_Verknuepftes_Element")
    protected TCIDVerknuepftesElement idVerknuepftesElement;

    /**
     * Ruft den Wert der bedienAnzeigeElementAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedienAnzeigeElementAllg }
     *     
     */
    public CBedienAnzeigeElementAllg getBedienAnzeigeElementAllg() {
        return bedienAnzeigeElementAllg;
    }

    /**
     * Legt den Wert der bedienAnzeigeElementAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedienAnzeigeElementAllg }
     *     
     */
    public void setBedienAnzeigeElementAllg(CBedienAnzeigeElementAllg value) {
        this.bedienAnzeigeElementAllg = value;
    }

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedienAnzeigeElementBezeichnung }
     *     
     */
    public CBedienAnzeigeElementBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedienAnzeigeElementBezeichnung }
     *     
     */
    public void setBezeichnung(CBedienAnzeigeElementBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idBedienEinrichtungOertlich-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBedienEinrichtungOertlich }
     *     
     */
    public TCIDBedienEinrichtungOertlich getIDBedienEinrichtungOertlich() {
        return idBedienEinrichtungOertlich;
    }

    /**
     * Legt den Wert der idBedienEinrichtungOertlich-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBedienEinrichtungOertlich }
     *     
     */
    public void setIDBedienEinrichtungOertlich(TCIDBedienEinrichtungOertlich value) {
        this.idBedienEinrichtungOertlich = value;
    }

    /**
     * Ruft den Wert der idVerknuepftesElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDVerknuepftesElement }
     *     
     */
    public TCIDVerknuepftesElement getIDVerknuepftesElement() {
        return idVerknuepftesElement;
    }

    /**
     * Legt den Wert der idVerknuepftesElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDVerknuepftesElement }
     *     
     */
    public void setIDVerknuepftesElement(TCIDVerknuepftesElement value) {
        this.idVerknuepftesElement = value;
    }

}
