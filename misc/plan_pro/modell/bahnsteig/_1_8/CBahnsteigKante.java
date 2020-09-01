//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bahnsteig._1_8;

import modell.basisobjekte._1_8.CBereichObjekt;
import modell.verweise._1_8.TCIDBahnsteigAnlage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Parallel zum Gleis verlaufende Kante eines Bahnsteigs, die f�r den Fahrgastwechsel nutzbar ist. F�r die LST-Planung sind Beginn und Ende der genutzten Bahnsteigkante z. B. f�r die Zugbeeinflussung (PZB 90) sowie die Festlegung von Signalstandorten und Gefahrpunkten ma�gebend. Die Baul�nge der Bahnsteigkante wird im Datenmodell durch die L�nge des Bereichsobjekts Bahnsteig_Kante abgebildet. Eventuell daran anschlie�ende Tiefbauobjekte (auch stillgelegte Bahnsteigbereiche) k�nnen als Ingenieurbauwerke (momentan noch nicht modelliert) abgebildet werden. DB-Regelwerk Darstellung einer Doppellinie im sicherungstechnischen Lageplan
 * 
 * <p>Java-Klasse f�r CBahnsteig_Kante complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBahnsteig_Kante">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bahnsteig_Kante_Allg" type="{http://www.plan-pro.org/modell/Bahnsteig/1.8.0}CBahnsteig_Kante_Allg"/>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Bahnsteig/1.8.0}CBahnsteig_Kante_Bezeichnung"/>
 *         &lt;element name="ID_Bahnsteig_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Bahnsteig_Anlage"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBahnsteig_Kante", propOrder = {
    "bahnsteigKanteAllg",
    "bezeichnung",
    "idBahnsteigAnlage"
})
public class CBahnsteigKante
    extends CBereichObjekt
{

    @XmlElement(name = "Bahnsteig_Kante_Allg", required = true)
    protected CBahnsteigKanteAllg bahnsteigKanteAllg;
    @XmlElement(name = "Bezeichnung", required = true)
    protected CBahnsteigKanteBezeichnung bezeichnung;
    @XmlElement(name = "ID_Bahnsteig_Anlage", required = true)
    protected TCIDBahnsteigAnlage idBahnsteigAnlage;

    /**
     * Ruft den Wert der bahnsteigKanteAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBahnsteigKanteAllg }
     *     
     */
    public CBahnsteigKanteAllg getBahnsteigKanteAllg() {
        return bahnsteigKanteAllg;
    }

    /**
     * Legt den Wert der bahnsteigKanteAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBahnsteigKanteAllg }
     *     
     */
    public void setBahnsteigKanteAllg(CBahnsteigKanteAllg value) {
        this.bahnsteigKanteAllg = value;
    }

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBahnsteigKanteBezeichnung }
     *     
     */
    public CBahnsteigKanteBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBahnsteigKanteBezeichnung }
     *     
     */
    public void setBezeichnung(CBahnsteigKanteBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idBahnsteigAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBahnsteigAnlage }
     *     
     */
    public TCIDBahnsteigAnlage getIDBahnsteigAnlage() {
        return idBahnsteigAnlage;
    }

    /**
     * Legt den Wert der idBahnsteigAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBahnsteigAnlage }
     *     
     */
    public void setIDBahnsteigAnlage(TCIDBahnsteigAnlage value) {
        this.idBahnsteigAnlage = value;
    }

}
