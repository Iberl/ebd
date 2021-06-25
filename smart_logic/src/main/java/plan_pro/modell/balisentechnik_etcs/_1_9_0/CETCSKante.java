//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDETCSKnotenOhneProxy;
import plan_pro.modell.verweise._1_9_0.TCIDRBC;
import plan_pro.modell.verweise._1_9_0.TCIDTOPKanteOhneProxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Abbildung der Kante des ETCS-spezifischen Knoten-Kanten-Modells auf das topologische PlanPro-Knoten-Kanten-Modell.
 * 
 * <p>Java-Klasse f�r CETCS_Kante complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CETCS_Kante">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CETCS_Kante_Bezeichnung"/>
 *         &lt;element name="ID_ETCS_Knoten_A" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ETCS_Knoten_ohne_Proxy"/>
 *         &lt;element name="ID_ETCS_Knoten_B" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ETCS_Knoten_ohne_Proxy"/>
 *         &lt;element name="ID_RBC" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_RBC" maxOccurs="unbounded"/>
 *         &lt;element name="ID_TOP_Kante" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_TOP_Kante_ohne_Proxy" maxOccurs="3"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CETCS_Kante", propOrder = {
    "bezeichnung",
    "idetcsKnotenA",
    "idetcsKnotenB",
    "idrbc",
    "idtopKante"
})
public class CETCSKante
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CETCSKanteBezeichnung bezeichnung;
    @XmlElement(name = "ID_ETCS_Knoten_A", required = true)
    protected TCIDETCSKnotenOhneProxy idetcsKnotenA;
    @XmlElement(name = "ID_ETCS_Knoten_B", required = true)
    protected TCIDETCSKnotenOhneProxy idetcsKnotenB;
    @XmlElement(name = "ID_RBC", required = true)
    protected List<TCIDRBC> idrbc;
    @XmlElement(name = "ID_TOP_Kante", required = true)
    protected List<TCIDTOPKanteOhneProxy> idtopKante;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CETCSKanteBezeichnung }
     *     
     */
    public CETCSKanteBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CETCSKanteBezeichnung }
     *     
     */
    public void setBezeichnung(CETCSKanteBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idetcsKnotenA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDETCSKnotenOhneProxy }
     *     
     */
    public TCIDETCSKnotenOhneProxy getIDETCSKnotenA() {
        return idetcsKnotenA;
    }

    /**
     * Legt den Wert der idetcsKnotenA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDETCSKnotenOhneProxy }
     *     
     */
    public void setIDETCSKnotenA(TCIDETCSKnotenOhneProxy value) {
        this.idetcsKnotenA = value;
    }

    /**
     * Ruft den Wert der idetcsKnotenB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDETCSKnotenOhneProxy }
     *     
     */
    public TCIDETCSKnotenOhneProxy getIDETCSKnotenB() {
        return idetcsKnotenB;
    }

    /**
     * Legt den Wert der idetcsKnotenB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDETCSKnotenOhneProxy }
     *     
     */
    public void setIDETCSKnotenB(TCIDETCSKnotenOhneProxy value) {
        this.idetcsKnotenB = value;
    }

    /**
     * Gets the value of the idrbc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idrbc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDRBC().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDRBC }
     * 
     * 
     */
    public List<TCIDRBC> getIDRBC() {
        if (idrbc == null) {
            idrbc = new ArrayList<TCIDRBC>();
        }
        return this.idrbc;
    }

    /**
     * Gets the value of the idtopKante property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idtopKante property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDTOPKante().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDTOPKanteOhneProxy }
     * 
     * 
     */
    public List<TCIDTOPKanteOhneProxy> getIDTOPKante() {
        if (idtopKante == null) {
            idtopKante = new ArrayList<TCIDTOPKanteOhneProxy>();
        }
        return this.idtopKante;
    }

}
