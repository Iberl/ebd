//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.fahrstrasse._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDBlockElement;
import modell.verweise._1_8.TCIDMarkanteStelle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Punkt in der �rtlichkeit, der eindeutig aufzufinden und beschreibbar ist. Haupts�chlicher Anwendungsfall ist die Definition des Gefahrpunktes oder des Endes eines Durchrutschweges. Auch der PZB-Gefahrpunkt wird damit verortet. Die eindeutige Auffindbarkeit dient der Freimeldung durch Hinsehen in der R�ckfallebene. Wegen schlechter Erkennbarkeit soll eine Gleisfreimeldegrenze nur ausnahmsweise als markanter Punkt genutzt werden, wenn sich in vertretbarer Entfernung kein anderer Punkt finden l�sst. Antennen von Zugbeeinflussungen (z. B. PZB-Gleismagnet) gelten nicht als markanter Punkt. Das Ende des Durchrutschweges muss nicht mit einer Freimeldegrenze zusammenfallen. Ein weiterer Anwendungsfall ist die Verortung von Freimeldegrenzen als Hilfestellung f�r deren Montage. Markante Punkte sind: Signal (insbesondere Haupt- und Sperrsignal, Grenzzeichen, Schutzhaltsignal), Weichenspitze (W Kr Gsp Komponente), Gleissperre (W Kr Gsp Komponente), Kante des Gefahrraums an B� (Sonstiger Punkt), Besondere Objekte, z. B. an Deckungsstellen (derzeit noch nicht modelliert), Gleisfreimeldegrenze (nur ausnahmsweise), Beginn eines Bahnsteigs (Sonstiger Punkt), Zugschluss bzw. -spitze (Sonstiger Punkt), Sonstige Punkte (Sonstiger Punkt). DB-Regelwerk Ende Durchrutschweg: Durchrutschwegtabelle, Spalte 2: \"bis\"; Gefahrpunkt: Gefahrpunkttabelle, Spalte 2: \"ma�gebender Gefahrpunkt\"; Verortung Gleisfreimeldegrenze: Bema�ungsangabe im sicherungstechnischen Lageplan und Achsz�hlpunkttabelle, Spalte 17: \"Bezugspunkt\". 
 * 
 * <p>Java-Klasse f�r CMarkanter_Punkt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CMarkanter_Punkt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CMarkanter_Punkt_Bezeichnung"/>
 *         &lt;element name="ID_DWeg_Erlaubnisabhaengig" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Block_Element" minOccurs="0"/>
 *         &lt;element name="ID_Markante_Stelle" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Markante_Stelle"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CMarkanter_Punkt", propOrder = {
    "bezeichnung",
    "iddWegErlaubnisabhaengig",
    "idMarkanteStelle"
})
public class CMarkanterPunkt
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CMarkanterPunktBezeichnung bezeichnung;
    @XmlElement(name = "ID_DWeg_Erlaubnisabhaengig")
    protected TCIDBlockElement iddWegErlaubnisabhaengig;
    @XmlElement(name = "ID_Markante_Stelle", required = true)
    protected TCIDMarkanteStelle idMarkanteStelle;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CMarkanterPunktBezeichnung }
     *     
     */
    public CMarkanterPunktBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CMarkanterPunktBezeichnung }
     *     
     */
    public void setBezeichnung(CMarkanterPunktBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der iddWegErlaubnisabhaengig-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBlockElement }
     *     
     */
    public TCIDBlockElement getIDDWegErlaubnisabhaengig() {
        return iddWegErlaubnisabhaengig;
    }

    /**
     * Legt den Wert der iddWegErlaubnisabhaengig-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBlockElement }
     *     
     */
    public void setIDDWegErlaubnisabhaengig(TCIDBlockElement value) {
        this.iddWegErlaubnisabhaengig = value;
    }

    /**
     * Ruft den Wert der idMarkanteStelle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDMarkanteStelle }
     *     
     */
    public TCIDMarkanteStelle getIDMarkanteStelle() {
        return idMarkanteStelle;
    }

    /**
     * Legt den Wert der idMarkanteStelle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDMarkanteStelle }
     *     
     */
    public void setIDMarkanteStelle(TCIDMarkanteStelle value) {
        this.idMarkanteStelle = value;
    }

}
