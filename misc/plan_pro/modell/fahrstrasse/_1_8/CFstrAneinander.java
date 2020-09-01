//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.fahrstrasse._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Aneinandergereihte Zug- oder Rangierstra�e. Die Reihenfolge der aneinandergereihten Fahrstra�en wird nicht mit abgespeichert, da diese aus Start und Ziel erkennbar ist. Durch die Auswahl der letzten Fahrstra�e (bei Zugstra�en) wird der Durchrutschweg festgelegt. Sollen f�r die aneinandergereihte Zugstra�e mehrere Durchrutschwege m�glich sein, so sind entsprechend viele aneinandergereihte Zugstra�en zu planen (Ausnahmefall). F�r die erste bis vorletzte Fahrstra�e muss jeweils ein Durchrutschweg gew�hlt werden, dessen Weg Bestandteil der folgenden Fahrstra�e ist; sollten hiervon mehrere existieren, wird der mit den geringsten betrieblichen Einschr�nkungen (i. d. R. der l�ngste) verwendet. DB-Regelwerk Aneinandergereihte Zugstra�entabelle Aneinandergereihte Rangierstra�entabelle 
 * 
 * <p>Java-Klasse f�r CFstr_Aneinander complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Aneinander">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CFstr_Aneinander_Bezeichnung"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_Aneinander", propOrder = {
    "bezeichnung"
})
public class CFstrAneinander
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CFstrAneinanderBezeichnung bezeichnung;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFstrAneinanderBezeichnung }
     *     
     */
    public CFstrAneinanderBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFstrAneinanderBezeichnung }
     *     
     */
    public void setBezeichnung(CFstrAneinanderBezeichnung value) {
        this.bezeichnung = value;
    }

}
