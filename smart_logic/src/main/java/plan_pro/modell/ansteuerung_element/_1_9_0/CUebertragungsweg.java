//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ansteuerung_element._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDAnhang;
import plan_pro.modell.verweise._1_9_0.TCIDUebertragungswegNach;
import plan_pro.modell.verweise._1_9_0.TCIDUebertragungswegVon;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Physikalischer/logischer �bertragungsweg zwischen zwei Objekten f�r eine erforderliche Informations�bertragung. Die Angabe erfolgt, wenn der �bertragungsweg vom Betreiber beigestellt wird oder die Informations�bertragung vom Lieferanten zus�tzlich zu schalten ist. Es geht um die Erfassung der physikalischen/logischen Verbindung zweier Objekte, die entweder einer funktionalen Verbindung zwischen den Objekten des Modells selbst dient, z.B. der ESTW-Bus zwischen zwei Aussenelementansteuerungen; einer funktionalen Verbindung eines Objektes des Modells zu einer nicht im Modell befindlichen Komponente dient, z.B. der Anbindung der KUS �ber die ZN_ZBS an die Leittechnik der BZ; einer funktionalen Verbindung zwischen zwei Komponenten, die nicht im Modell abgebildet sind, aber �ber diese angebunden werden und darum f�r die SBI dokumentiert werden m�ssen, z.B. die Verbindung von der LZB-Zentrale in der ESTW Zentraleinheit zum LZB-Bedienplatz in der Bedien Zentrale. Je nach Art und Anwendungsfall kann ein Objekt nur eine oder auch mehrere Verbindungen zu einem oder mehreren anderen Objekten haben. Der Anschluss von stellwerkstypischen Elementen an das Stellwerk (Kabelanlage) wird nicht mit diesem Objekt abgebildet. 
 * 
 * <p>Java-Klasse f�r CUebertragungsweg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CUebertragungsweg">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Anhang_UeWeg_Nach" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_Anhang_UeWeg_Von" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_Uebertragungsweg_Nach" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Uebertragungsweg_Nach"/>
 *         &lt;element name="ID_Uebertragungsweg_Von" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Uebertragungsweg_Von"/>
 *         &lt;element name="Uebertragungsweg_Art" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCUebertragungsweg_Art"/>
 *         &lt;element name="Uebertragungsweg_Technik" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}CUebertragungsweg_Technik"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CUebertragungsweg", propOrder = {
    "idAnhangUeWegNach",
    "idAnhangUeWegVon",
    "idUebertragungswegNach",
    "idUebertragungswegVon",
    "uebertragungswegArt",
    "uebertragungswegTechnik"
})
public class CUebertragungsweg
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Anhang_UeWeg_Nach")
    protected List<TCIDAnhang> idAnhangUeWegNach;
    @XmlElement(name = "ID_Anhang_UeWeg_Von")
    protected List<TCIDAnhang> idAnhangUeWegVon;
    @XmlElement(name = "ID_Uebertragungsweg_Nach", required = true)
    protected TCIDUebertragungswegNach idUebertragungswegNach;
    @XmlElement(name = "ID_Uebertragungsweg_Von", required = true)
    protected TCIDUebertragungswegVon idUebertragungswegVon;
    @XmlElement(name = "Uebertragungsweg_Art", required = true)
    protected TCUebertragungswegArt uebertragungswegArt;
    @XmlElement(name = "Uebertragungsweg_Technik", required = true)
    protected CUebertragungswegTechnik uebertragungswegTechnik;

    /**
     * Gets the value of the idAnhangUeWegNach property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idAnhangUeWegNach property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDAnhangUeWegNach().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDAnhang }
     * 
     * 
     */
    public List<TCIDAnhang> getIDAnhangUeWegNach() {
        if (idAnhangUeWegNach == null) {
            idAnhangUeWegNach = new ArrayList<TCIDAnhang>();
        }
        return this.idAnhangUeWegNach;
    }

    /**
     * Gets the value of the idAnhangUeWegVon property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idAnhangUeWegVon property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDAnhangUeWegVon().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDAnhang }
     * 
     * 
     */
    public List<TCIDAnhang> getIDAnhangUeWegVon() {
        if (idAnhangUeWegVon == null) {
            idAnhangUeWegVon = new ArrayList<TCIDAnhang>();
        }
        return this.idAnhangUeWegVon;
    }

    /**
     * Ruft den Wert der idUebertragungswegNach-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDUebertragungswegNach }
     *     
     */
    public TCIDUebertragungswegNach getIDUebertragungswegNach() {
        return idUebertragungswegNach;
    }

    /**
     * Legt den Wert der idUebertragungswegNach-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDUebertragungswegNach }
     *     
     */
    public void setIDUebertragungswegNach(TCIDUebertragungswegNach value) {
        this.idUebertragungswegNach = value;
    }

    /**
     * Ruft den Wert der idUebertragungswegVon-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDUebertragungswegVon }
     *     
     */
    public TCIDUebertragungswegVon getIDUebertragungswegVon() {
        return idUebertragungswegVon;
    }

    /**
     * Legt den Wert der idUebertragungswegVon-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDUebertragungswegVon }
     *     
     */
    public void setIDUebertragungswegVon(TCIDUebertragungswegVon value) {
        this.idUebertragungswegVon = value;
    }

    /**
     * Ruft den Wert der uebertragungswegArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUebertragungswegArt }
     *     
     */
    public TCUebertragungswegArt getUebertragungswegArt() {
        return uebertragungswegArt;
    }

    /**
     * Legt den Wert der uebertragungswegArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUebertragungswegArt }
     *     
     */
    public void setUebertragungswegArt(TCUebertragungswegArt value) {
        this.uebertragungswegArt = value;
    }

    /**
     * Ruft den Wert der uebertragungswegTechnik-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CUebertragungswegTechnik }
     *     
     */
    public CUebertragungswegTechnik getUebertragungswegTechnik() {
        return uebertragungswegTechnik;
    }

    /**
     * Legt den Wert der uebertragungswegTechnik-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CUebertragungswegTechnik }
     *     
     */
    public void setUebertragungswegTechnik(CUebertragungswegTechnik value) {
        this.uebertragungswegTechnik = value;
    }

}
