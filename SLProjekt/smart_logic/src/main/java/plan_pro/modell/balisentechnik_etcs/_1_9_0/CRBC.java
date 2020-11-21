//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDESTWZentraleinheit;
import plan_pro.modell.verweise._1_9_0.TCIDUnterbringung;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Radio Block Centre (ETCS-Streckenzentrale).
 * 
 * <p>Java-Klasse f�r CRBC complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CRBC">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ETCS_Adresse" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CETCS_Adresse"/>
 *         &lt;element name="ID_ESTW_Zentraleinheit" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ESTW_Zentraleinheit" maxOccurs="unbounded"/>
 *         &lt;element name="ID_Unterbringung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Unterbringung"/>
 *         &lt;element name="RBC_Allg" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CRBC_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRBC", propOrder = {
    "etcsAdresse",
    "idestwZentraleinheit",
    "idUnterbringung",
    "rbcAllg"
})
public class CRBC
    extends CBasisObjekt
{

    @XmlElement(name = "ETCS_Adresse", required = true)
    protected CETCSAdresse etcsAdresse;
    @XmlElement(name = "ID_ESTW_Zentraleinheit", required = true)
    protected List<TCIDESTWZentraleinheit> idestwZentraleinheit;
    @XmlElement(name = "ID_Unterbringung", required = true)
    protected TCIDUnterbringung idUnterbringung;
    @XmlElement(name = "RBC_Allg", required = true)
    protected CRBCAllg rbcAllg;

    /**
     * Ruft den Wert der etcsAdresse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CETCSAdresse }
     *     
     */
    public CETCSAdresse getETCSAdresse() {
        return etcsAdresse;
    }

    /**
     * Legt den Wert der etcsAdresse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CETCSAdresse }
     *     
     */
    public void setETCSAdresse(CETCSAdresse value) {
        this.etcsAdresse = value;
    }

    /**
     * Gets the value of the idestwZentraleinheit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idestwZentraleinheit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDESTWZentraleinheit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDESTWZentraleinheit }
     * 
     * 
     */
    public List<TCIDESTWZentraleinheit> getIDESTWZentraleinheit() {
        if (idestwZentraleinheit == null) {
            idestwZentraleinheit = new ArrayList<TCIDESTWZentraleinheit>();
        }
        return this.idestwZentraleinheit;
    }

    /**
     * Ruft den Wert der idUnterbringung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDUnterbringung }
     *     
     */
    public TCIDUnterbringung getIDUnterbringung() {
        return idUnterbringung;
    }

    /**
     * Legt den Wert der idUnterbringung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDUnterbringung }
     *     
     */
    public void setIDUnterbringung(TCIDUnterbringung value) {
        this.idUnterbringung = value;
    }

    /**
     * Ruft den Wert der rbcAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CRBCAllg }
     *     
     */
    public CRBCAllg getRBCAllg() {
        return rbcAllg;
    }

    /**
     * Legt den Wert der rbcAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CRBCAllg }
     *     
     */
    public void setRBCAllg(CRBCAllg value) {
        this.rbcAllg = value;
    }

}
