//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CFT_ESG_Merkmale complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFT_ESG_Merkmale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bremsweg" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCBremsweg"/>
 *         &lt;element name="DP_Typ_V_La" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDP_Typ_V_La" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ESG_Individuelle_Merkmale" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CESG_Individuelle_Merkmale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ESG_Spezifische_Merkmale" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CESG_Spezifische_Merkmale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FT_ESG_Subtyp" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCFT_ESG_Subtyp" minOccurs="0"/>
 *         &lt;element name="FT_ESG_Typ" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCFT_ESG_Typ"/>
 *         &lt;element name="LfdNr_in_Telegr_Spec" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCLfdNr_in_Telegr_Spec"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFT_ESG_Merkmale", propOrder = {
    "bremsweg",
    "dpTypVLa",
    "esgIndividuelleMerkmale",
    "esgSpezifischeMerkmale",
    "ftesgSubtyp",
    "ftesgTyp",
    "lfdNrInTelegrSpec"
})
public class CFTESGMerkmale {

    @XmlElement(name = "Bremsweg", required = true)
    protected TCBremsweg bremsweg;
    @XmlElement(name = "DP_Typ_V_La")
    protected List<TCDPTypVLa> dpTypVLa;
    @XmlElement(name = "ESG_Individuelle_Merkmale")
    protected List<CESGIndividuelleMerkmale> esgIndividuelleMerkmale;
    @XmlElement(name = "ESG_Spezifische_Merkmale")
    protected List<CESGSpezifischeMerkmale> esgSpezifischeMerkmale;
    @XmlElement(name = "FT_ESG_Subtyp")
    protected TCFTESGSubtyp ftesgSubtyp;
    @XmlElement(name = "FT_ESG_Typ", required = true)
    protected TCFTESGTyp ftesgTyp;
    @XmlElement(name = "LfdNr_in_Telegr_Spec", required = true)
    protected TCLfdNrInTelegrSpec lfdNrInTelegrSpec;

    /**
     * Ruft den Wert der bremsweg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBremsweg }
     *     
     */
    public TCBremsweg getBremsweg() {
        return bremsweg;
    }

    /**
     * Legt den Wert der bremsweg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBremsweg }
     *     
     */
    public void setBremsweg(TCBremsweg value) {
        this.bremsweg = value;
    }

    /**
     * Gets the value of the dpTypVLa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dpTypVLa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDPTypVLa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCDPTypVLa }
     * 
     * 
     */
    public List<TCDPTypVLa> getDPTypVLa() {
        if (dpTypVLa == null) {
            dpTypVLa = new ArrayList<TCDPTypVLa>();
        }
        return this.dpTypVLa;
    }

    /**
     * Gets the value of the esgIndividuelleMerkmale property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the esgIndividuelleMerkmale property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getESGIndividuelleMerkmale().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CESGIndividuelleMerkmale }
     * 
     * 
     */
    public List<CESGIndividuelleMerkmale> getESGIndividuelleMerkmale() {
        if (esgIndividuelleMerkmale == null) {
            esgIndividuelleMerkmale = new ArrayList<CESGIndividuelleMerkmale>();
        }
        return this.esgIndividuelleMerkmale;
    }

    /**
     * Gets the value of the esgSpezifischeMerkmale property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the esgSpezifischeMerkmale property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getESGSpezifischeMerkmale().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CESGSpezifischeMerkmale }
     * 
     * 
     */
    public List<CESGSpezifischeMerkmale> getESGSpezifischeMerkmale() {
        if (esgSpezifischeMerkmale == null) {
            esgSpezifischeMerkmale = new ArrayList<CESGSpezifischeMerkmale>();
        }
        return this.esgSpezifischeMerkmale;
    }

    /**
     * Ruft den Wert der ftesgSubtyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFTESGSubtyp }
     *     
     */
    public TCFTESGSubtyp getFTESGSubtyp() {
        return ftesgSubtyp;
    }

    /**
     * Legt den Wert der ftesgSubtyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFTESGSubtyp }
     *     
     */
    public void setFTESGSubtyp(TCFTESGSubtyp value) {
        this.ftesgSubtyp = value;
    }

    /**
     * Ruft den Wert der ftesgTyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFTESGTyp }
     *     
     */
    public TCFTESGTyp getFTESGTyp() {
        return ftesgTyp;
    }

    /**
     * Legt den Wert der ftesgTyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFTESGTyp }
     *     
     */
    public void setFTESGTyp(TCFTESGTyp value) {
        this.ftesgTyp = value;
    }

    /**
     * Ruft den Wert der lfdNrInTelegrSpec-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLfdNrInTelegrSpec }
     *     
     */
    public TCLfdNrInTelegrSpec getLfdNrInTelegrSpec() {
        return lfdNrInTelegrSpec;
    }

    /**
     * Legt den Wert der lfdNrInTelegrSpec-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLfdNrInTelegrSpec }
     *     
     */
    public void setLfdNrInTelegrSpec(TCLfdNrInTelegrSpec value) {
        this.lfdNrInTelegrSpec = value;
    }

}
