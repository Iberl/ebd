//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.pzb._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDAnhang;
import plan_pro.modell.verweise._1_9_0.TCIDBahnsteigKante;
import plan_pro.modell.verweise._1_9_0.TCIDMarkanterPunkt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CPZB_Element_Zuordnung_INA complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPZB_Element_Zuordnung_INA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Anhang_INA" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang"/>
 *         &lt;element name="ID_Bahnsteig_Kante" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Bahnsteig_Kante"/>
 *         &lt;element name="ID_Markanter_Punkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Markanter_Punkt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPZB_Element_Zuordnung_INA", propOrder = {
    "idAnhangINA",
    "idBahnsteigKante",
    "idMarkanterPunkt"
})
public class CPZBElementZuordnungINA {

    @XmlElement(name = "ID_Anhang_INA", required = true)
    protected TCIDAnhang idAnhangINA;
    @XmlElement(name = "ID_Bahnsteig_Kante", required = true)
    protected TCIDBahnsteigKante idBahnsteigKante;
    @XmlElement(name = "ID_Markanter_Punkt", required = true)
    protected TCIDMarkanterPunkt idMarkanterPunkt;

    /**
     * Ruft den Wert der idAnhangINA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangINA() {
        return idAnhangINA;
    }

    /**
     * Legt den Wert der idAnhangINA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangINA(TCIDAnhang value) {
        this.idAnhangINA = value;
    }

    /**
     * Ruft den Wert der idBahnsteigKante-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBahnsteigKante }
     *     
     */
    public TCIDBahnsteigKante getIDBahnsteigKante() {
        return idBahnsteigKante;
    }

    /**
     * Legt den Wert der idBahnsteigKante-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBahnsteigKante }
     *     
     */
    public void setIDBahnsteigKante(TCIDBahnsteigKante value) {
        this.idBahnsteigKante = value;
    }

    /**
     * Ruft den Wert der idMarkanterPunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDMarkanterPunkt }
     *     
     */
    public TCIDMarkanterPunkt getIDMarkanterPunkt() {
        return idMarkanterPunkt;
    }

    /**
     * Legt den Wert der idMarkanterPunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDMarkanterPunkt }
     *     
     */
    public void setIDMarkanterPunkt(TCIDMarkanterPunkt value) {
        this.idMarkanterPunkt = value;
    }

}
