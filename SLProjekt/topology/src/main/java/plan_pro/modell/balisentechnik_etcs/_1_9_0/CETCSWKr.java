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
import plan_pro.modell.verweise._1_9_0.TCIDWKrAnlageOhneProxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Zusatzangaben f�r Weichen und Kreuzungen im Zusammenhang mit ETCS L2. Ortsgestellte Weichen sind gem�� der Vorgaben in Ril 819.1344 zu ber�cksichtigen.
 * 
 * <p>Java-Klasse f�r CETCS_W_Kr complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CETCS_W_Kr">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_ETCS_Knoten" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ETCS_Knoten_ohne_Proxy"/>
 *         &lt;element name="ID_RBC" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_RBC" maxOccurs="unbounded"/>
 *         &lt;element name="ID_W_Kr_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_W_Kr_Anlage_ohne_Proxy"/>
 *         &lt;choice>
 *           &lt;element name="ETCS_W_Kr_MUKA" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CETCS_W_Kr_MUKA"/>
 *           &lt;element name="ETCS_W_Ortsgestellt" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCETCS_W_Ortsgestellt"/>
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
@XmlType(name = "CETCS_W_Kr", propOrder = {
    "idetcsKnoten",
    "idrbc",
    "idwKrAnlage",
    "etcswKrMUKA",
    "etcswOrtsgestellt"
})
public class CETCSWKr
    extends CBasisObjekt
{

    @XmlElement(name = "ID_ETCS_Knoten", required = true)
    protected TCIDETCSKnotenOhneProxy idetcsKnoten;
    @XmlElement(name = "ID_RBC", required = true)
    protected List<TCIDRBC> idrbc;
    @XmlElement(name = "ID_W_Kr_Anlage", required = true)
    protected TCIDWKrAnlageOhneProxy idwKrAnlage;
    @XmlElement(name = "ETCS_W_Kr_MUKA")
    protected CETCSWKrMUKA etcswKrMUKA;
    @XmlElement(name = "ETCS_W_Ortsgestellt")
    protected TCETCSWOrtsgestellt etcswOrtsgestellt;

    /**
     * Ruft den Wert der idetcsKnoten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDETCSKnotenOhneProxy }
     *     
     */
    public TCIDETCSKnotenOhneProxy getIDETCSKnoten() {
        return idetcsKnoten;
    }

    /**
     * Legt den Wert der idetcsKnoten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDETCSKnotenOhneProxy }
     *     
     */
    public void setIDETCSKnoten(TCIDETCSKnotenOhneProxy value) {
        this.idetcsKnoten = value;
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
     * Ruft den Wert der idwKrAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDWKrAnlageOhneProxy }
     *     
     */
    public TCIDWKrAnlageOhneProxy getIDWKrAnlage() {
        return idwKrAnlage;
    }

    /**
     * Legt den Wert der idwKrAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDWKrAnlageOhneProxy }
     *     
     */
    public void setIDWKrAnlage(TCIDWKrAnlageOhneProxy value) {
        this.idwKrAnlage = value;
    }

    /**
     * Ruft den Wert der etcswKrMUKA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CETCSWKrMUKA }
     *     
     */
    public CETCSWKrMUKA getETCSWKrMUKA() {
        return etcswKrMUKA;
    }

    /**
     * Legt den Wert der etcswKrMUKA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CETCSWKrMUKA }
     *     
     */
    public void setETCSWKrMUKA(CETCSWKrMUKA value) {
        this.etcswKrMUKA = value;
    }

    /**
     * Ruft den Wert der etcswOrtsgestellt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCETCSWOrtsgestellt }
     *     
     */
    public TCETCSWOrtsgestellt getETCSWOrtsgestellt() {
        return etcswOrtsgestellt;
    }

    /**
     * Legt den Wert der etcswOrtsgestellt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCETCSWOrtsgestellt }
     *     
     */
    public void setETCSWOrtsgestellt(TCETCSWOrtsgestellt value) {
        this.etcswOrtsgestellt = value;
    }

}
