//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDTOPKnoten;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Abbildung des Knotens des ETCS-spezifischen Knoten-Kanten-Modells auf das topologische PlanPro-Knoten-Kanten-Modell. Bei Kreuzungsweichen erfolgt die Verortung zweifach, sonst einfach.
 * 
 * <p>Java-Klasse f�r CETCS_Knoten complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CETCS_Knoten">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="ID_TOP_Knoten" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_TOP_Knoten"/>
 *           &lt;element name="Knoten_Auf_TOP_Kante" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CKnoten_Auf_TOP_Kante"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CETCS_Knoten", propOrder = {
    "idtopKnoten",
    "knotenAufTOPKante"
})
public class CETCSKnoten
    extends CBasisObjekt
{

    @XmlElement(name = "ID_TOP_Knoten")
    protected TCIDTOPKnoten idtopKnoten;
    @XmlElement(name = "Knoten_Auf_TOP_Kante")
    protected CKnotenAufTOPKante knotenAufTOPKante;

    /**
     * Ruft den Wert der idtopKnoten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDTOPKnoten }
     *     
     */
    public TCIDTOPKnoten getIDTOPKnoten() {
        return idtopKnoten;
    }

    /**
     * Legt den Wert der idtopKnoten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDTOPKnoten }
     *     
     */
    public void setIDTOPKnoten(TCIDTOPKnoten value) {
        this.idtopKnoten = value;
    }

    /**
     * Ruft den Wert der knotenAufTOPKante-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CKnotenAufTOPKante }
     *     
     */
    public CKnotenAufTOPKante getKnotenAufTOPKante() {
        return knotenAufTOPKante;
    }

    /**
     * Legt den Wert der knotenAufTOPKante-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CKnotenAufTOPKante }
     *     
     */
    public void setKnotenAufTOPKante(CKnotenAufTOPKante value) {
        this.knotenAufTOPKante = value;
    }

}
