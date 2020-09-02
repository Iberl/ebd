//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.block._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBlockElement;
import plan_pro.modell.verweise._1_9_0.TCIDGleisBezeichnung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Technische Einrichtungen f�r die blocktechnische Sicherung von Zugfahrten auf Streckengleisen. Die zugeh�rige Bezeichnung des Streckengleises wird �ber das Objekt Gleis Bezeichnung ermittelt. Die Klammern der Gleisbezeichnung f�r Streckengleise sind Bestandteil der Gleisbezeichnung. F�r die Darstellung der Streckendaten f�r eine Blockstrecke wird �ber das Objekt Block Element das Objekt Block Strecke verwendet. Ist Streckenblock geplant, wird einem Streckengleis eine Block_Anlage zugeordnet. Bei einer zweigleisigen Strecke, bei der beide Streckengleise mit Streckenblock ausger�stet sind, wird den beiden Streckengleisen jeweils eine eigene Block_Anlage zugeordnet. Eine Block_Anlage verf�gt �ber zwei Block_Elemente A und B (Blockendstellen), die entsprechend der Regelfahrrichtung zugewiesen werden. Bei eingleisigen Strecken ergibt sich der Richtungssinn A - B aus der Streckenkilometrierung. Eine Ausnahme bildet der Stichstreckenblock, dem nur ein Block Element zugeordnet wird. Als Zusammenfassung aller Objekte wird auch die Bezeichnung Block verwendet. 
 * 
 * <p>Java-Klasse f�r CBlock_Anlage complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBlock_Anlage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Block_Anlage_Allg" type="{http://www.plan-pro.org/modell/Block/1.9.0.2}CBlock_Anlage_Allg"/>
 *         &lt;element name="ID_Block_Element_A" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Block_Element"/>
 *         &lt;element name="ID_Block_Element_B" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Block_Element" minOccurs="0"/>
 *         &lt;element name="ID_Gleis_Bezeichnung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Gleis_Bezeichnung"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBlock_Anlage", propOrder = {
    "blockAnlageAllg",
    "idBlockElementA",
    "idBlockElementB",
    "idGleisBezeichnung"
})
public class CBlockAnlage
    extends CBasisObjekt
{

    @XmlElement(name = "Block_Anlage_Allg", required = true)
    protected CBlockAnlageAllg blockAnlageAllg;
    @XmlElement(name = "ID_Block_Element_A", required = true)
    protected TCIDBlockElement idBlockElementA;
    @XmlElement(name = "ID_Block_Element_B")
    protected TCIDBlockElement idBlockElementB;
    @XmlElement(name = "ID_Gleis_Bezeichnung", required = true)
    protected TCIDGleisBezeichnung idGleisBezeichnung;

    /**
     * Ruft den Wert der blockAnlageAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBlockAnlageAllg }
     *     
     */
    public CBlockAnlageAllg getBlockAnlageAllg() {
        return blockAnlageAllg;
    }

    /**
     * Legt den Wert der blockAnlageAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBlockAnlageAllg }
     *     
     */
    public void setBlockAnlageAllg(CBlockAnlageAllg value) {
        this.blockAnlageAllg = value;
    }

    /**
     * Ruft den Wert der idBlockElementA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBlockElement }
     *     
     */
    public TCIDBlockElement getIDBlockElementA() {
        return idBlockElementA;
    }

    /**
     * Legt den Wert der idBlockElementA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBlockElement }
     *     
     */
    public void setIDBlockElementA(TCIDBlockElement value) {
        this.idBlockElementA = value;
    }

    /**
     * Ruft den Wert der idBlockElementB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBlockElement }
     *     
     */
    public TCIDBlockElement getIDBlockElementB() {
        return idBlockElementB;
    }

    /**
     * Legt den Wert der idBlockElementB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBlockElement }
     *     
     */
    public void setIDBlockElementB(TCIDBlockElement value) {
        this.idBlockElementB = value;
    }

    /**
     * Ruft den Wert der idGleisBezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGleisBezeichnung }
     *     
     */
    public TCIDGleisBezeichnung getIDGleisBezeichnung() {
        return idGleisBezeichnung;
    }

    /**
     * Legt den Wert der idGleisBezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGleisBezeichnung }
     *     
     */
    public void setIDGleisBezeichnung(TCIDGleisBezeichnung value) {
        this.idGleisBezeichnung = value;
    }

}
