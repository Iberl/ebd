//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDFstrFahrweg;
import plan_pro.modell.verweise._1_9_0.TCIDUmfahrpunkt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Bezeichner des Umfahrpunkts durch eine Weiche oder einen Gleisabschnitt. Der Bezeichner dient nur dazu, den Umfahrweg zu benennen, nicht dazu, den Fahrweg zu beschreiben; die Beschreibung erfolgt in Fstr Fahrweg (Bereich Objekt). Die Festlegung des Umfahrpunkts gilt je Fahrweg und damit f�r alle Zug- und Rangierstra�en, die diesen Fahrweg nutzen. Das Objekt ist Bestandteil des Untergewerks \"Bedienung Fdl\". DB-Regelwerk Bestandteil des Bezeichners der Umfahrstra�e in der Zug-/Rangierstra�entabelle, Spalte 1 \"Start/Ziel\"
 * 
 * <p>Java-Klasse f�r CFstr_Umfahrpunkt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Umfahrpunkt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Fstr_Fahrweg" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fstr_Fahrweg"/>
 *         &lt;element name="ID_Umfahrpunkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Umfahrpunkt"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_Umfahrpunkt", propOrder = {
    "idFstrFahrweg",
    "idUmfahrpunkt"
})
public class CFstrUmfahrpunkt
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Fstr_Fahrweg", required = true)
    protected TCIDFstrFahrweg idFstrFahrweg;
    @XmlElement(name = "ID_Umfahrpunkt", required = true)
    protected TCIDUmfahrpunkt idUmfahrpunkt;

    /**
     * Ruft den Wert der idFstrFahrweg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFstrFahrweg }
     *     
     */
    public TCIDFstrFahrweg getIDFstrFahrweg() {
        return idFstrFahrweg;
    }

    /**
     * Legt den Wert der idFstrFahrweg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFstrFahrweg }
     *     
     */
    public void setIDFstrFahrweg(TCIDFstrFahrweg value) {
        this.idFstrFahrweg = value;
    }

    /**
     * Ruft den Wert der idUmfahrpunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDUmfahrpunkt }
     *     
     */
    public TCIDUmfahrpunkt getIDUmfahrpunkt() {
        return idUmfahrpunkt;
    }

    /**
     * Legt den Wert der idUmfahrpunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDUmfahrpunkt }
     *     
     */
    public void setIDUmfahrpunkt(TCIDUmfahrpunkt value) {
        this.idUmfahrpunkt = value;
    }

}
