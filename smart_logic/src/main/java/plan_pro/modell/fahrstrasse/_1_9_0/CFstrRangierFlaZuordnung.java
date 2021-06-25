//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDFlaSchutz;
import plan_pro.modell.verweise._1_9_0.TCIDFstrZugRangier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Zuordnung von zu gew�hrleistenden Flankenschutzma�nahmen zur Rangierstra�e. Nur in Ausnahmef�llen wird Flankenschutz f�r Rangierstra�en realisiert. Dann kann f�r jede Weiche einzeln bestimmt werden, ob sie Flankenschutz bekommt.
 * 
 * <p>Java-Klasse f�r CFstr_Rangier_Fla_Zuordnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Rangier_Fla_Zuordnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Fla_Schutz" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fla_Schutz"/>
 *         &lt;element name="ID_Fstr_Rangier" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fstr_Zug_Rangier"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_Rangier_Fla_Zuordnung", propOrder = {
    "idFlaSchutz",
    "idFstrRangier"
})
public class CFstrRangierFlaZuordnung
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Fla_Schutz", required = true)
    protected TCIDFlaSchutz idFlaSchutz;
    @XmlElement(name = "ID_Fstr_Rangier", required = true)
    protected TCIDFstrZugRangier idFstrRangier;

    /**
     * Ruft den Wert der idFlaSchutz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFlaSchutz }
     *     
     */
    public TCIDFlaSchutz getIDFlaSchutz() {
        return idFlaSchutz;
    }

    /**
     * Legt den Wert der idFlaSchutz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFlaSchutz }
     *     
     */
    public void setIDFlaSchutz(TCIDFlaSchutz value) {
        this.idFlaSchutz = value;
    }

    /**
     * Ruft den Wert der idFstrRangier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFstrZugRangier }
     *     
     */
    public TCIDFstrZugRangier getIDFstrRangier() {
        return idFstrRangier;
    }

    /**
     * Legt den Wert der idFstrRangier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFstrZugRangier }
     *     
     */
    public void setIDFstrRangier(TCIDFstrZugRangier value) {
        this.idFstrRangier = value;
    }

}
