//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.block._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDOertlichkeitProxy;
import plan_pro.modell.verweise._1_9_0.TCIDStrecke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Speicherung der betrieblich relevanter Streckendaten einer Blockstrecke. Das Objekt enth�lt die zwischen zwei Zugmeldestellen typischen betrieblichen Informationen (Streckendaten) zur Information. Es wird dem Blockelement der zugeh�rigen Blockstelle zugeordnet.
 * 
 * <p>Java-Klasse f�r CBlock_Strecke complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBlock_Strecke">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Block_Strecke_Allg" type="{http://www.plan-pro.org/modell/Block/1.9.0.2}CBlock_Strecke_Allg"/>
 *         &lt;element name="ID_Betriebsstelle_Nachbar" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Oertlichkeit_Proxy"/>
 *         &lt;element name="ID_Knotenbahnhof" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Oertlichkeit_Proxy" minOccurs="0"/>
 *         &lt;element name="ID_Strecke" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Strecke"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBlock_Strecke", propOrder = {
    "blockStreckeAllg",
    "idBetriebsstelleNachbar",
    "idKnotenbahnhof",
    "idStrecke"
})
public class CBlockStrecke
    extends CBasisObjekt
{

    @XmlElement(name = "Block_Strecke_Allg", required = true)
    protected CBlockStreckeAllg blockStreckeAllg;
    @XmlElement(name = "ID_Betriebsstelle_Nachbar", required = true)
    protected TCIDOertlichkeitProxy idBetriebsstelleNachbar;
    @XmlElement(name = "ID_Knotenbahnhof")
    protected TCIDOertlichkeitProxy idKnotenbahnhof;
    @XmlElement(name = "ID_Strecke", required = true)
    protected TCIDStrecke idStrecke;

    /**
     * Ruft den Wert der blockStreckeAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBlockStreckeAllg }
     *     
     */
    public CBlockStreckeAllg getBlockStreckeAllg() {
        return blockStreckeAllg;
    }

    /**
     * Legt den Wert der blockStreckeAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBlockStreckeAllg }
     *     
     */
    public void setBlockStreckeAllg(CBlockStreckeAllg value) {
        this.blockStreckeAllg = value;
    }

    /**
     * Ruft den Wert der idBetriebsstelleNachbar-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public TCIDOertlichkeitProxy getIDBetriebsstelleNachbar() {
        return idBetriebsstelleNachbar;
    }

    /**
     * Legt den Wert der idBetriebsstelleNachbar-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public void setIDBetriebsstelleNachbar(TCIDOertlichkeitProxy value) {
        this.idBetriebsstelleNachbar = value;
    }

    /**
     * Ruft den Wert der idKnotenbahnhof-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public TCIDOertlichkeitProxy getIDKnotenbahnhof() {
        return idKnotenbahnhof;
    }

    /**
     * Legt den Wert der idKnotenbahnhof-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public void setIDKnotenbahnhof(TCIDOertlichkeitProxy value) {
        this.idKnotenbahnhof = value;
    }

    /**
     * Ruft den Wert der idStrecke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDStrecke }
     *     
     */
    public TCIDStrecke getIDStrecke() {
        return idStrecke;
    }

    /**
     * Legt den Wert der idStrecke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDStrecke }
     *     
     */
    public void setIDStrecke(TCIDStrecke value) {
        this.idStrecke = value;
    }

}
