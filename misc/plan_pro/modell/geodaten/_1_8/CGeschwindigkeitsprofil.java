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
 * Zul�ssige Geschwindigkeit der Strecke, bei ETCS auch au�erhalb der durchgehenden Hauptgleise. Das Geschwindigkeitsprofil wird zusammengesetzt aus Bereichen mit konstanten Geschwindigkeiten. Es kann in unterschiedlichen Arten (z. B. NeiTec, ETCS) ausgepr�gt sein. F�r jede Art wird ein separates Geschwindigkeitsprofil angelegt. \"Geschwindigkeitsband\" ist ein Synonym f�r Geschwindigkeitsprofil. Unabh�ngig vom Geschwindigkeitsprofil k�nnen in Elementen (Weiche, Gleisabschnitt) eigene Geschwindigkeiten hinterlegt sein. Je nach Anwendung wird �ber die G�ltigkeit der in den Elementen hinterlegten Geschwindigkeit oder der des Geschwindigkeitsprofils entschieden.
 * 
 * <p>Java-Klasse f�r CGeschwindigkeitsprofil complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGeschwindigkeitsprofil">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Geschwindigkeitsprofil_Allg" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CGeschwindigkeitsprofil_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGeschwindigkeitsprofil", propOrder = {
    "geschwindigkeitsprofilAllg"
})
public class CGeschwindigkeitsprofil
    extends CBereichObjekt
{

    @XmlElement(name = "Geschwindigkeitsprofil_Allg", required = true)
    protected CGeschwindigkeitsprofilAllg geschwindigkeitsprofilAllg;

    /**
     * Ruft den Wert der geschwindigkeitsprofilAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CGeschwindigkeitsprofilAllg }
     *     
     */
    public CGeschwindigkeitsprofilAllg getGeschwindigkeitsprofilAllg() {
        return geschwindigkeitsprofilAllg;
    }

    /**
     * Legt den Wert der geschwindigkeitsprofilAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CGeschwindigkeitsprofilAllg }
     *     
     */
    public void setGeschwindigkeitsprofilAllg(CGeschwindigkeitsprofilAllg value) {
        this.geschwindigkeitsprofilAllg = value;
    }

}
