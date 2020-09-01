//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.pzb._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDFstrZugRangier;
import modell.verweise._1_8.TCIDPZBElementBezugspunkt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Zuordnung von PZB Element zu einem Signal, einer Fahrstra�e oder auch anderen Objekten, die im Bezug zum PZB_Element stehen. Der Verweis von einem PZB Element �ber das Zuordnungsobjekt auf ein Signal ist dabei immer gef�llt. Die Verkn�pfung mit einer Fahrstra�e (nur Zugstra�en sind relevant) oder weiteren Objekten (INA-Berechnungsrelevante Objekte) ist fallbezogen notwendig. Beispiele f�r die Zuordnung sind unter ID Fstr Zug Rangier zu finden. DB-Regelwerk Eintrag in der Gleismagnettabelle; die Zuordnung zu einzelnen Fahrstra�en wird heute �ber Fu�noten gel�st. 
 * 
 * <p>Java-Klasse f�r CPZB_Element_Zuordnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPZB_Element_Zuordnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Fstr_Zug_Rangier" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Fstr_Zug_Rangier" minOccurs="0"/>
 *         &lt;element name="ID_PZB_Element_Bezugspunkt" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_PZB_Element_Bezugspunkt"/>
 *         &lt;element name="PZB_Element_Zuordnung_INA" type="{http://www.plan-pro.org/modell/PZB/1.8.0}CPZB_Element_Zuordnung_INA" minOccurs="0"/>
 *         &lt;element name="Wirksamkeit" type="{http://www.plan-pro.org/modell/PZB/1.8.0}TCWirksamkeit"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPZB_Element_Zuordnung", propOrder = {
    "idFstrZugRangier",
    "idpzbElementBezugspunkt",
    "pzbElementZuordnungINA",
    "wirksamkeit"
})
public class CPZBElementZuordnung
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Fstr_Zug_Rangier")
    protected TCIDFstrZugRangier idFstrZugRangier;
    @XmlElement(name = "ID_PZB_Element_Bezugspunkt", required = true)
    protected TCIDPZBElementBezugspunkt idpzbElementBezugspunkt;
    @XmlElement(name = "PZB_Element_Zuordnung_INA")
    protected CPZBElementZuordnungINA pzbElementZuordnungINA;
    @XmlElement(name = "Wirksamkeit", required = true)
    protected TCWirksamkeit wirksamkeit;

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

    /**
     * Ruft den Wert der idpzbElementBezugspunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDPZBElementBezugspunkt }
     *     
     */
    public TCIDPZBElementBezugspunkt getIDPZBElementBezugspunkt() {
        return idpzbElementBezugspunkt;
    }

    /**
     * Legt den Wert der idpzbElementBezugspunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDPZBElementBezugspunkt }
     *     
     */
    public void setIDPZBElementBezugspunkt(TCIDPZBElementBezugspunkt value) {
        this.idpzbElementBezugspunkt = value;
    }

    /**
     * Ruft den Wert der pzbElementZuordnungINA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPZBElementZuordnungINA }
     *     
     */
    public CPZBElementZuordnungINA getPZBElementZuordnungINA() {
        return pzbElementZuordnungINA;
    }

    /**
     * Legt den Wert der pzbElementZuordnungINA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPZBElementZuordnungINA }
     *     
     */
    public void setPZBElementZuordnungINA(CPZBElementZuordnungINA value) {
        this.pzbElementZuordnungINA = value;
    }

    /**
     * Ruft den Wert der wirksamkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWirksamkeit }
     *     
     */
    public TCWirksamkeit getWirksamkeit() {
        return wirksamkeit;
    }

    /**
     * Legt den Wert der wirksamkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWirksamkeit }
     *     
     */
    public void setWirksamkeit(TCWirksamkeit value) {
        this.wirksamkeit = value;
    }

}
