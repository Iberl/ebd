//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.medien_und_trassen._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDTrasseKante;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Medium zur �bermittlung von Energie und/oder Information.
 * 
 * <p>Java-Klasse f�r CKabel complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CKabel">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}CKabel_Bezeichnung"/>
 *         &lt;element name="ID_Trasse_Kante" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Trasse_Kante" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Kabel_Allg" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}CKabel_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CKabel", propOrder = {
    "bezeichnung",
    "idTrasseKante",
    "kabelAllg"
})
public class CKabel
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CKabelBezeichnung bezeichnung;
    @XmlElement(name = "ID_Trasse_Kante")
    protected List<TCIDTrasseKante> idTrasseKante;
    @XmlElement(name = "Kabel_Allg", required = true)
    protected CKabelAllg kabelAllg;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CKabelBezeichnung }
     *     
     */
    public CKabelBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CKabelBezeichnung }
     *     
     */
    public void setBezeichnung(CKabelBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Gets the value of the idTrasseKante property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idTrasseKante property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDTrasseKante().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDTrasseKante }
     * 
     * 
     */
    public List<TCIDTrasseKante> getIDTrasseKante() {
        if (idTrasseKante == null) {
            idTrasseKante = new ArrayList<TCIDTrasseKante>();
        }
        return this.idTrasseKante;
    }

    /**
     * Ruft den Wert der kabelAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CKabelAllg }
     *     
     */
    public CKabelAllg getKabelAllg() {
        return kabelAllg;
    }

    /**
     * Legt den Wert der kabelAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CKabelAllg }
     *     
     */
    public void setKabelAllg(CKabelAllg value) {
        this.kabelAllg = value;
    }

}
