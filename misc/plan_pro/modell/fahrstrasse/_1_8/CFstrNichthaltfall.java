//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.fahrstrasse._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDFMAAnlage;
import modell.verweise._1_8.TCIDFstrFahrweg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Nichthaltfallabschnitt (auch: Haltfallverhinderungsabschnitt). Im Gegensatz zur bisherigen Praxis der LST-Planung, den Haltfallabschnitt zu planen, werden im Datenmodell nur die Nichthaltfallabschnitte f�r jede Zugstra�e geplant. In der Regel ist es einer, selten mehrere. DB-Regelwerk Haltfallabschnitt bisher: Zugstra�entabelle, Spalte 6: Signalhaltfall
 * 
 * <p>Java-Klasse f�r CFstr_Nichthaltfall complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Nichthaltfall">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_FMA_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_FMA_Anlage"/>
 *         &lt;element name="ID_Fstr_Fahrweg" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Fstr_Fahrweg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_Nichthaltfall", propOrder = {
    "idfmaAnlage",
    "idFstrFahrweg"
})
public class CFstrNichthaltfall
    extends CBasisObjekt
{

    @XmlElement(name = "ID_FMA_Anlage", required = true)
    protected TCIDFMAAnlage idfmaAnlage;
    @XmlElement(name = "ID_Fstr_Fahrweg", required = true)
    protected TCIDFstrFahrweg idFstrFahrweg;

    /**
     * Ruft den Wert der idfmaAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFMAAnlage }
     *     
     */
    public TCIDFMAAnlage getIDFMAAnlage() {
        return idfmaAnlage;
    }

    /**
     * Legt den Wert der idfmaAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFMAAnlage }
     *     
     */
    public void setIDFMAAnlage(TCIDFMAAnlage value) {
        this.idfmaAnlage = value;
    }

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

}
