//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDDatenpunkt;
import plan_pro.modell.verweise._1_9_0.TCIDFachtelegramm;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Linking-Information zu einem nachfolgenden Datenpunkt. Die Information kann in mehreren Fachtelegrammen verwendet werden. Die Festlegung erfolgt nur bei ZBS und GNT im Rahmen des PT 1.
 * 
 * <p>Java-Klasse f�r CDatenpunkt_Link complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CDatenpunkt_Link">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_DP_Link_Start" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Datenpunkt"/>
 *         &lt;element name="ID_DP_Link_Ziel" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Datenpunkt"/>
 *         &lt;element name="ID_Fachtelegramm" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fachtelegramm" maxOccurs="unbounded"/>
 *         &lt;element name="Link_Distanz" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCLink_Distanz"/>
 *         &lt;element name="Ziel_DP_Ausrichtung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCZiel_DP_Ausrichtung"/>
 *         &lt;choice>
 *           &lt;element name="GNT_Merkmale" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CGNT_Merkmale"/>
 *           &lt;element name="ZBS_Merkmale" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CZBS_Merkmale"/>
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
@XmlType(name = "CDatenpunkt_Link", propOrder = {
    "iddpLinkStart",
    "iddpLinkZiel",
    "idFachtelegramm",
    "linkDistanz",
    "zielDPAusrichtung",
    "gntMerkmale",
    "zbsMerkmale"
})
public class CDatenpunktLink
    extends CBasisObjekt
{

    @XmlElement(name = "ID_DP_Link_Start", required = true)
    protected TCIDDatenpunkt iddpLinkStart;
    @XmlElement(name = "ID_DP_Link_Ziel", required = true)
    protected TCIDDatenpunkt iddpLinkZiel;
    @XmlElement(name = "ID_Fachtelegramm", required = true)
    protected List<TCIDFachtelegramm> idFachtelegramm;
    @XmlElement(name = "Link_Distanz", required = true)
    protected TCLinkDistanz linkDistanz;
    @XmlElement(name = "Ziel_DP_Ausrichtung", required = true)
    protected TCZielDPAusrichtung zielDPAusrichtung;
    @XmlElement(name = "GNT_Merkmale")
    protected CGNTMerkmale gntMerkmale;
    @XmlElement(name = "ZBS_Merkmale")
    protected CZBSMerkmale zbsMerkmale;

    /**
     * Ruft den Wert der iddpLinkStart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDDatenpunkt }
     *     
     */
    public TCIDDatenpunkt getIDDPLinkStart() {
        return iddpLinkStart;
    }

    /**
     * Legt den Wert der iddpLinkStart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDDatenpunkt }
     *     
     */
    public void setIDDPLinkStart(TCIDDatenpunkt value) {
        this.iddpLinkStart = value;
    }

    /**
     * Ruft den Wert der iddpLinkZiel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDDatenpunkt }
     *     
     */
    public TCIDDatenpunkt getIDDPLinkZiel() {
        return iddpLinkZiel;
    }

    /**
     * Legt den Wert der iddpLinkZiel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDDatenpunkt }
     *     
     */
    public void setIDDPLinkZiel(TCIDDatenpunkt value) {
        this.iddpLinkZiel = value;
    }

    /**
     * Gets the value of the idFachtelegramm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idFachtelegramm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDFachtelegramm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDFachtelegramm }
     * 
     * 
     */
    public List<TCIDFachtelegramm> getIDFachtelegramm() {
        if (idFachtelegramm == null) {
            idFachtelegramm = new ArrayList<TCIDFachtelegramm>();
        }
        return this.idFachtelegramm;
    }

    /**
     * Ruft den Wert der linkDistanz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLinkDistanz }
     *     
     */
    public TCLinkDistanz getLinkDistanz() {
        return linkDistanz;
    }

    /**
     * Legt den Wert der linkDistanz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLinkDistanz }
     *     
     */
    public void setLinkDistanz(TCLinkDistanz value) {
        this.linkDistanz = value;
    }

    /**
     * Ruft den Wert der zielDPAusrichtung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZielDPAusrichtung }
     *     
     */
    public TCZielDPAusrichtung getZielDPAusrichtung() {
        return zielDPAusrichtung;
    }

    /**
     * Legt den Wert der zielDPAusrichtung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZielDPAusrichtung }
     *     
     */
    public void setZielDPAusrichtung(TCZielDPAusrichtung value) {
        this.zielDPAusrichtung = value;
    }

    /**
     * Ruft den Wert der gntMerkmale-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CGNTMerkmale }
     *     
     */
    public CGNTMerkmale getGNTMerkmale() {
        return gntMerkmale;
    }

    /**
     * Legt den Wert der gntMerkmale-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CGNTMerkmale }
     *     
     */
    public void setGNTMerkmale(CGNTMerkmale value) {
        this.gntMerkmale = value;
    }

    /**
     * Ruft den Wert der zbsMerkmale-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZBSMerkmale }
     *     
     */
    public CZBSMerkmale getZBSMerkmale() {
        return zbsMerkmale;
    }

    /**
     * Legt den Wert der zbsMerkmale-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZBSMerkmale }
     *     
     */
    public void setZBSMerkmale(CZBSMerkmale value) {
        this.zbsMerkmale = value;
    }

}
