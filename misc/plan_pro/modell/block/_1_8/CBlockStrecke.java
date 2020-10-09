//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.block._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDOertlichkeitProxy;
import modell.verweise._1_8.TCIDStrecke;

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
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Block_Strecke_Allg" type="{http://www.plan-pro.org/modell/Block/1.8.0}CBlock_Strecke_Allg"/>
 *         &lt;element name="ID_Betriebsstelle" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Oertlichkeit_Proxy"/>
 *         &lt;element name="ID_Knotenbahnhof" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Oertlichkeit_Proxy" minOccurs="0"/>
 *         &lt;element name="ID_Strecke" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Strecke"/>
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
    "idBetriebsstelle",
    "idKnotenbahnhof",
    "idStrecke"
})
public class CBlockStrecke
    extends CBasisObjekt
{

    @XmlElement(name = "Block_Strecke_Allg", required = true)
    protected CBlockStreckeAllg blockStreckeAllg;
    @XmlElement(name = "ID_Betriebsstelle", required = true)
    protected TCIDOertlichkeitProxy idBetriebsstelle;
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
     * Ruft den Wert der idBetriebsstelle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public TCIDOertlichkeitProxy getIDBetriebsstelle() {
        return idBetriebsstelle;
    }

    /**
     * Legt den Wert der idBetriebsstelle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public void setIDBetriebsstelle(TCIDOertlichkeitProxy value) {
        this.idBetriebsstelle = value;
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
