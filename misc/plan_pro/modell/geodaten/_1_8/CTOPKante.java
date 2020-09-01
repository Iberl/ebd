//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.geodaten._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDTOPKnoten;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Kante des topologischen Knoten_Kanten-Modells zur Darstellung der Gleislinien. Die TOP_Kante ist vom Knoten A zum Knoten B gerichtet und muss immer an zwei TOP Knoten enden. Eine TOP_Kante kann mehrere topographische Kanten (GEO_Kanten) beinhalten, die �ber GEO Knoten fortlaufend miteinander verbunden sind. Ein TOP Knoten ist immer auch ein GEO Knoten. Die L�nge einer TOP Kante zwischen den Knoten A und B entspricht der Summe der GEO_Kanten zwischen A und B (reale Gleisl�nge) und wird auf Millimetergenauigkeit gerundet. Die maximale L�nge einer TOP_Kante ist im Modell auf 99999,999 m (\u0026lt;100 km) begrenzt. Um ein eindeutiges Routing im topologischen Modell zu erm�glichen, sind die Anschlussarten der Kante an den beiden Knoten A und B anzugeben (siehe Attribute TOP_Anschluss_A bzw. TOP_Anschluss_B). Hierbei ist zu beachten, dass ein Routing �ber die Verbindung Anschluss Links - Rechts ausgeschlossen ist. 
 * 
 * <p>Java-Klasse f�r CTOP_Kante complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CTOP_Kante">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_TOP_Knoten_A" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_TOP_Knoten"/>
 *         &lt;element name="ID_TOP_Knoten_B" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_TOP_Knoten"/>
 *         &lt;element name="TOP_Kante_Allg" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CTOP_Kante_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTOP_Kante", propOrder = {
    "idtopKnotenA",
    "idtopKnotenB",
    "topKanteAllg"
})
public class CTOPKante
    extends CBasisObjekt
{

    @XmlElement(name = "ID_TOP_Knoten_A", required = true)
    protected TCIDTOPKnoten idtopKnotenA;
    @XmlElement(name = "ID_TOP_Knoten_B", required = true)
    protected TCIDTOPKnoten idtopKnotenB;
    @XmlElement(name = "TOP_Kante_Allg", required = true)
    protected CTOPKanteAllg topKanteAllg;

    /**
     * Ruft den Wert der idtopKnotenA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDTOPKnoten }
     *     
     */
    public TCIDTOPKnoten getIDTOPKnotenA() {
        return idtopKnotenA;
    }

    /**
     * Legt den Wert der idtopKnotenA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDTOPKnoten }
     *     
     */
    public void setIDTOPKnotenA(TCIDTOPKnoten value) {
        this.idtopKnotenA = value;
    }

    /**
     * Ruft den Wert der idtopKnotenB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDTOPKnoten }
     *     
     */
    public TCIDTOPKnoten getIDTOPKnotenB() {
        return idtopKnotenB;
    }

    /**
     * Legt den Wert der idtopKnotenB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDTOPKnoten }
     *     
     */
    public void setIDTOPKnotenB(TCIDTOPKnoten value) {
        this.idtopKnotenB = value;
    }

    /**
     * Ruft den Wert der topKanteAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CTOPKanteAllg }
     *     
     */
    public CTOPKanteAllg getTOPKanteAllg() {
        return topKanteAllg;
    }

    /**
     * Legt den Wert der topKanteAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CTOPKanteAllg }
     *     
     */
    public void setTOPKanteAllg(CTOPKanteAllg value) {
        this.topKanteAllg = value;
    }

}
