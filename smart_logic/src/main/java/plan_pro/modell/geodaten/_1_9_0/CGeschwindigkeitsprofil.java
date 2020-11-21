//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBereichObjekt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


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
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Geschwindigkeitsprofil_Allg" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}CGeschwindigkeitsprofil_Allg"/>
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
