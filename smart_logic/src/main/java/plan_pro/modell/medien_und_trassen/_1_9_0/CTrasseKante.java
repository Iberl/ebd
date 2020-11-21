//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.medien_und_trassen._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDTrasseKnoten;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Kante des topologischen Knoten-Kanten-Modells zur Darstellung des Kabelgef��systems (Kabeltrasse) oder gleichartiger Medientrassen. Die Trasse Kante ist vom Knoten A zum Knoten B gerichtet und muss immer an zwei Trasse Knoten enden. Der geometrische Verlauf einer Trasse_Kante kann durch eine oder mehrere GEO_Kanten beschrieben werden (siehe auch TOP_Kante).
 * 
 * <p>Java-Klasse f�r CTrasse_Kante complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CTrasse_Kante">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Trasse_Knoten_A" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Trasse_Knoten"/>
 *         &lt;element name="ID_Trasse_Knoten_B" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Trasse_Knoten"/>
 *         &lt;element name="Trasse_Kante_Art" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}TCTrasse_Kante_Art"/>
 *         &lt;element name="Trasse_Nutzer" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}TCTrasse_Nutzer" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTrasse_Kante", propOrder = {
    "idTrasseKnotenA",
    "idTrasseKnotenB",
    "trasseKanteArt",
    "trasseNutzer"
})
public class CTrasseKante
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Trasse_Knoten_A", required = true)
    protected TCIDTrasseKnoten idTrasseKnotenA;
    @XmlElement(name = "ID_Trasse_Knoten_B", required = true)
    protected TCIDTrasseKnoten idTrasseKnotenB;
    @XmlElement(name = "Trasse_Kante_Art", required = true)
    protected TCTrasseKanteArt trasseKanteArt;
    @XmlElement(name = "Trasse_Nutzer", required = true)
    protected List<TCTrasseNutzer> trasseNutzer;

    /**
     * Ruft den Wert der idTrasseKnotenA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDTrasseKnoten }
     *     
     */
    public TCIDTrasseKnoten getIDTrasseKnotenA() {
        return idTrasseKnotenA;
    }

    /**
     * Legt den Wert der idTrasseKnotenA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDTrasseKnoten }
     *     
     */
    public void setIDTrasseKnotenA(TCIDTrasseKnoten value) {
        this.idTrasseKnotenA = value;
    }

    /**
     * Ruft den Wert der idTrasseKnotenB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDTrasseKnoten }
     *     
     */
    public TCIDTrasseKnoten getIDTrasseKnotenB() {
        return idTrasseKnotenB;
    }

    /**
     * Legt den Wert der idTrasseKnotenB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDTrasseKnoten }
     *     
     */
    public void setIDTrasseKnotenB(TCIDTrasseKnoten value) {
        this.idTrasseKnotenB = value;
    }

    /**
     * Ruft den Wert der trasseKanteArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTrasseKanteArt }
     *     
     */
    public TCTrasseKanteArt getTrasseKanteArt() {
        return trasseKanteArt;
    }

    /**
     * Legt den Wert der trasseKanteArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTrasseKanteArt }
     *     
     */
    public void setTrasseKanteArt(TCTrasseKanteArt value) {
        this.trasseKanteArt = value;
    }

    /**
     * Gets the value of the trasseNutzer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trasseNutzer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrasseNutzer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCTrasseNutzer }
     * 
     * 
     */
    public List<TCTrasseNutzer> getTrasseNutzer() {
        if (trasseNutzer == null) {
            trasseNutzer = new ArrayList<TCTrasseNutzer>();
        }
        return this.trasseNutzer;
    }

}
