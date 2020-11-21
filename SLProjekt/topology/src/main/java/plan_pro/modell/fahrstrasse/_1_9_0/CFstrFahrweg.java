//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBereichObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDSignal;
import plan_pro.modell.verweise._1_9_0.TCIDZiel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Unverzweigter Bereich auf dem Gleisnetz, der als Grundlage f�r den befahrenen Teil bzw. den Durchrutschweg einer Fahrstra�e dient. Der Start befindet sich immer an einem Signal, das Ziel beim befahrenen Teil an einem Signal, beim Durchrutschweg (bzw. Gefahrpunktabstand) an einem markanten Punkt. F�r Zug- und Rangierstra�en mit gleichem Fahrweg kann die gleiche Instanz von Fstr_Fahrweg verwendet werden; Ausnahmen siehe Fstr Abhaengigkeit. Hinweis zur Modellierung beim Durchrutschweg, wenn der Markante Punkt eine Weichenspitze ist: L�uft ein Durchrutschweg spitz auf eine Weiche zu und die Spitze dieser Weiche ist das Ende des Durchrutschwegs, dann endet das Bereichsobjekt Fstr_Fahrweg am Ende der Kante vor der Spitze der Weiche, ist der markante Punkt das Punktobjekt W_Kr_Gsp_Komponente, was auf anschlie�enden Kanten verweist. Damit liegen das Ende des Bereichsobjekts und der markante Punkt auf verschiedenen Kanten (jeweils mit Abstand 0 zum Knoten), dennoch beschreiben sie geografisch den gleichen Punkt. DB-Regelwerk Im heutigen Planungswerk findet sich der Weg nur implizit durch die Angabe f�r den befahrenen Teil von Start, Ziel und Entscheidungsweichen in der Zug- bzw. Rangierstra�entabelle, f�r den Durchrutschweg und Gefahrpunktabstand von Start und Ziel und allen Weichen in der Durchrutschweg- bzw. Gefahrpunkttabelle. 
 * 
 * <p>Java-Klasse f�r CFstr_Fahrweg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Fahrweg">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Fstr_V_Hg" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCFstr_V_Hg" minOccurs="0"/>
 *         &lt;element name="ID_Start" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal"/>
 *         &lt;element name="ID_Ziel" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Ziel"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_Fahrweg", propOrder = {
    "fstrVHg",
    "idStart",
    "idZiel"
})
public class CFstrFahrweg
    extends CBereichObjekt
{

    @XmlElement(name = "Fstr_V_Hg")
    protected TCFstrVHg fstrVHg;
    @XmlElement(name = "ID_Start", required = true)
    protected TCIDSignal idStart;
    @XmlElement(name = "ID_Ziel", required = true)
    protected TCIDZiel idZiel;

    /**
     * Ruft den Wert der fstrVHg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFstrVHg }
     *     
     */
    public TCFstrVHg getFstrVHg() {
        return fstrVHg;
    }

    /**
     * Legt den Wert der fstrVHg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFstrVHg }
     *     
     */
    public void setFstrVHg(TCFstrVHg value) {
        this.fstrVHg = value;
    }

    /**
     * Ruft den Wert der idStart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignal }
     *     
     */
    public TCIDSignal getIDStart() {
        return idStart;
    }

    /**
     * Legt den Wert der idStart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignal }
     *     
     */
    public void setIDStart(TCIDSignal value) {
        this.idStart = value;
    }

    /**
     * Ruft den Wert der idZiel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZiel }
     *     
     */
    public TCIDZiel getIDZiel() {
        return idZiel;
    }

    /**
     * Legt den Wert der idZiel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZiel }
     *     
     */
    public void setIDZiel(TCIDZiel value) {
        this.idZiel = value;
    }

}
