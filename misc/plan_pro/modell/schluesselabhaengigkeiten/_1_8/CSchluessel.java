//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.schluesselabhaengigkeiten._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Sicherungstechnisches Element zur Herstellung von Schl�sselabh�ngigkeiten �ber Schl�sser an Elementen. Der Schl�ssel im sicherungstechnischen Sinn ist ein repr�sentativer und innerhalb einer �rtlichkeit einmaliger Gegenstand. Durch den Besitz des Schl�ssels kann sicher und eindeutig auf einen bestimmten Anlagenzustand geschlossen werden. Somit k�nnen durch Verkn�pfung mit weiteren Fahrwegelementen oder einer informationsverarbeitenden Einheit sichere Abh�ngigkeiten geschaffen werden. In der Regel gibt es �rtlich immer zwei gleich schlie�ende Schl�sser, selten mehr. Wird eine Schl�sselsperre nur als Schalter benutzt (z. B. um Fahrstra�en zu sperren), gibt es zu einem Schl�ssel nur ein Schloss. Um die �rtliche Einmaligkeit herzustellen, darf eine Schl�sselform nur einmal innerhalb einer Betriebsstelle oder besser noch eines Streckenabschnitts verwendet werden. Dazu sind 24 verschiedene Schl�sselbartformen vorhanden, die mit sechs Schl�sselgruppen kombiniert werden k�nnen. Nicht jede Bartform wird mit jeder Gruppe kombiniert. So stehen insgesamt 92 verschiedene Schl�sselformen zur Verf�gung. DB-Regelwerk Die Planung der Schl�sselformen ist bisher nicht Bestandteil des PT1. F�r die Formen existieren Regelzeichnungen.
 * 
 * <p>Java-Klasse f�r CSchluessel complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchluessel">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.8.0}CSchluessel_Bezeichnung" minOccurs="0"/>
 *         &lt;element name="Schluessel_Allg" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.8.0}CSchluessel_Allg" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSchluessel", propOrder = {
    "bezeichnung",
    "schluesselAllg"
})
public class CSchluessel
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung")
    protected CSchluesselBezeichnung bezeichnung;
    @XmlElement(name = "Schluessel_Allg")
    protected CSchluesselAllg schluesselAllg;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSchluesselBezeichnung }
     *     
     */
    public CSchluesselBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSchluesselBezeichnung }
     *     
     */
    public void setBezeichnung(CSchluesselBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der schluesselAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSchluesselAllg }
     *     
     */
    public CSchluesselAllg getSchluesselAllg() {
        return schluesselAllg;
    }

    /**
     * Legt den Wert der schluesselAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSchluesselAllg }
     *     
     */
    public void setSchluesselAllg(CSchluesselAllg value) {
        this.schluesselAllg = value;
    }

}
