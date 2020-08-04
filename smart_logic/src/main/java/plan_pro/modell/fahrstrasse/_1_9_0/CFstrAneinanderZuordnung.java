//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDFstrAneinander;
import plan_pro.modell.verweise._1_9_0.TCIDFstrZugRangier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Zuordnung der aneinandergereihten Zug- oder Rangierstra�e zu den Fahrstra�en Fstr Zug Rangier (\"Elementarfahrstra�en\"), aus denen sie besteht. DB-Regelwerk Tabelle der aneinandergereihten Zugstra�en Tabelle der aneinandergereihten Rangierstra�en 
 * 
 * <p>Java-Klasse f�r CFstr_Aneinander_Zuordnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Aneinander_Zuordnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Fstr_Aneinander" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fstr_Aneinander"/>
 *         &lt;element name="ID_Fstr_Zug_Rangier" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fstr_Zug_Rangier"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_Aneinander_Zuordnung", propOrder = {
    "idFstrAneinander",
    "idFstrZugRangier"
})
public class CFstrAneinanderZuordnung
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Fstr_Aneinander", required = true)
    protected TCIDFstrAneinander idFstrAneinander;
    @XmlElement(name = "ID_Fstr_Zug_Rangier", required = true)
    protected TCIDFstrZugRangier idFstrZugRangier;

    /**
     * Ruft den Wert der idFstrAneinander-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFstrAneinander }
     *     
     */
    public TCIDFstrAneinander getIDFstrAneinander() {
        return idFstrAneinander;
    }

    /**
     * Legt den Wert der idFstrAneinander-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFstrAneinander }
     *     
     */
    public void setIDFstrAneinander(TCIDFstrAneinander value) {
        this.idFstrAneinander = value;
    }

    /**
     * Ruft den Wert der idFstrZugRangier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFstrZugRangier }
     *     
     */
    public TCIDFstrZugRangier getIDFstrZugRangier() {
        return idFstrZugRangier;
    }

    /**
     * Legt den Wert der idFstrZugRangier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFstrZugRangier }
     *     
     */
    public void setIDFstrZugRangier(TCIDFstrZugRangier value) {
        this.idFstrZugRangier = value;
    }

}
