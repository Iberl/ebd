//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDAnhang;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Informationen auf Planungsebene, die einem Datenpunkt in Abh�ngkeit eines Signalbegriffs oder anderer Eingangsinformationen zugeordnet werden.
 * 
 * <p>Java-Klasse f�r CFachtelegramm complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFachtelegramm">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="FT_Fahrweg_Teile" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CFT_Fahrweg_Teile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_Doku_Telegrammkodierung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang" minOccurs="0"/>
 *         &lt;element name="Wirkrichtung_In_Datenpunkt" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCWirkrichtung_In_Datenpunkt"/>
 *         &lt;choice>
 *           &lt;element name="FT_ESG_Merkmale" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CFT_ESG_Merkmale"/>
 *           &lt;element name="FT_ETCS_L2_Merkmale" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CFT_ETCS_L2_Merkmale"/>
 *           &lt;element name="FT_ETCS_Trans_Merkmale" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CFT_ETCS_Trans_Merkmale"/>
 *           &lt;element name="FT_GNT_Merkmale" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CFT_GNT_Merkmale"/>
 *           &lt;element name="FT_ZBS_Merkmale" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CFT_ZBS_Merkmale"/>
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
@XmlType(name = "CFachtelegramm", propOrder = {
    "ftFahrwegTeile",
    "idDokuTelegrammkodierung",
    "wirkrichtungInDatenpunkt",
    "ftesgMerkmale",
    "ftetcsl2Merkmale",
    "ftetcsTransMerkmale",
    "ftgntMerkmale",
    "ftzbsMerkmale"
})
public class CFachtelegramm
    extends CBasisObjekt
{

    @XmlElement(name = "FT_Fahrweg_Teile")
    protected List<CFTFahrwegTeile> ftFahrwegTeile;
    @XmlElement(name = "ID_Doku_Telegrammkodierung")
    protected TCIDAnhang idDokuTelegrammkodierung;
    @XmlElement(name = "Wirkrichtung_In_Datenpunkt", required = true)
    protected TCWirkrichtungInDatenpunkt wirkrichtungInDatenpunkt;
    @XmlElement(name = "FT_ESG_Merkmale")
    protected CFTESGMerkmale ftesgMerkmale;
    @XmlElement(name = "FT_ETCS_L2_Merkmale")
    protected CFTETCSL2Merkmale ftetcsl2Merkmale;
    @XmlElement(name = "FT_ETCS_Trans_Merkmale")
    protected CFTETCSTransMerkmale ftetcsTransMerkmale;
    @XmlElement(name = "FT_GNT_Merkmale")
    protected CFTGNTMerkmale ftgntMerkmale;
    @XmlElement(name = "FT_ZBS_Merkmale")
    protected CFTZBSMerkmale ftzbsMerkmale;

    /**
     * Gets the value of the ftFahrwegTeile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ftFahrwegTeile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFTFahrwegTeile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFTFahrwegTeile }
     * 
     * 
     */
    public List<CFTFahrwegTeile> getFTFahrwegTeile() {
        if (ftFahrwegTeile == null) {
            ftFahrwegTeile = new ArrayList<CFTFahrwegTeile>();
        }
        return this.ftFahrwegTeile;
    }

    /**
     * Ruft den Wert der idDokuTelegrammkodierung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDDokuTelegrammkodierung() {
        return idDokuTelegrammkodierung;
    }

    /**
     * Legt den Wert der idDokuTelegrammkodierung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDDokuTelegrammkodierung(TCIDAnhang value) {
        this.idDokuTelegrammkodierung = value;
    }

    /**
     * Ruft den Wert der wirkrichtungInDatenpunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWirkrichtungInDatenpunkt }
     *     
     */
    public TCWirkrichtungInDatenpunkt getWirkrichtungInDatenpunkt() {
        return wirkrichtungInDatenpunkt;
    }

    /**
     * Legt den Wert der wirkrichtungInDatenpunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWirkrichtungInDatenpunkt }
     *     
     */
    public void setWirkrichtungInDatenpunkt(TCWirkrichtungInDatenpunkt value) {
        this.wirkrichtungInDatenpunkt = value;
    }

    /**
     * Ruft den Wert der ftesgMerkmale-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFTESGMerkmale }
     *     
     */
    public CFTESGMerkmale getFTESGMerkmale() {
        return ftesgMerkmale;
    }

    /**
     * Legt den Wert der ftesgMerkmale-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFTESGMerkmale }
     *     
     */
    public void setFTESGMerkmale(CFTESGMerkmale value) {
        this.ftesgMerkmale = value;
    }

    /**
     * Ruft den Wert der ftetcsl2Merkmale-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFTETCSL2Merkmale }
     *     
     */
    public CFTETCSL2Merkmale getFTETCSL2Merkmale() {
        return ftetcsl2Merkmale;
    }

    /**
     * Legt den Wert der ftetcsl2Merkmale-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFTETCSL2Merkmale }
     *     
     */
    public void setFTETCSL2Merkmale(CFTETCSL2Merkmale value) {
        this.ftetcsl2Merkmale = value;
    }

    /**
     * Ruft den Wert der ftetcsTransMerkmale-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFTETCSTransMerkmale }
     *     
     */
    public CFTETCSTransMerkmale getFTETCSTransMerkmale() {
        return ftetcsTransMerkmale;
    }

    /**
     * Legt den Wert der ftetcsTransMerkmale-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFTETCSTransMerkmale }
     *     
     */
    public void setFTETCSTransMerkmale(CFTETCSTransMerkmale value) {
        this.ftetcsTransMerkmale = value;
    }

    /**
     * Ruft den Wert der ftgntMerkmale-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFTGNTMerkmale }
     *     
     */
    public CFTGNTMerkmale getFTGNTMerkmale() {
        return ftgntMerkmale;
    }

    /**
     * Legt den Wert der ftgntMerkmale-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFTGNTMerkmale }
     *     
     */
    public void setFTGNTMerkmale(CFTGNTMerkmale value) {
        this.ftgntMerkmale = value;
    }

    /**
     * Ruft den Wert der ftzbsMerkmale-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFTZBSMerkmale }
     *     
     */
    public CFTZBSMerkmale getFTZBSMerkmale() {
        return ftzbsMerkmale;
    }

    /**
     * Legt den Wert der ftzbsMerkmale-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFTZBSMerkmale }
     *     
     */
    public void setFTZBSMerkmale(CFTZBSMerkmale value) {
        this.ftzbsMerkmale = value;
    }

}
