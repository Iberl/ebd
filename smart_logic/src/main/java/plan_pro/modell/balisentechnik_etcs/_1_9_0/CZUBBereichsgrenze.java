//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CPunktObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDOertlichkeitProxy;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Grenze des Ausr�stungsbereichs eines Zugbeeinflussungssystems oder RBC-Grenze bei L2. Auch im Lastenheft bzw. Planungsregelwerk als Ausstieg definierte Bereichsgrenzen werden im Datenmodell generell als Einstieg abgebildet. Sp�ter Einstieg wird nicht abgebildet
 * 
 * <p>Java-Klasse f�r CZUB_Bereichsgrenze complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZUB_Bereichsgrenze">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CZUB_Bereichsgrenze_Bezeichnung" minOccurs="0"/>
 *         &lt;element name="ID_Oertlichkeit" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Oertlichkeit_Proxy"/>
 *         &lt;element name="ZUB_Bereichsgrenze_Allg" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CZUB_Bereichsgrenze_Allg"/>
 *         &lt;choice>
 *           &lt;element name="ZUB_Bereichsgrenze_Nach_ESG" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CZUB_Bereichsgrenze_Nach_ESG" maxOccurs="unbounded"/>
 *           &lt;element name="ZUB_Bereichsgrenze_Nach_GNT" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CZUB_Bereichsgrenze_Nach_GNT" maxOccurs="unbounded"/>
 *           &lt;element name="ZUB_Bereichsgrenze_Nach_L2" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CZUB_Bereichsgrenze_Nach_L2" maxOccurs="unbounded"/>
 *           &lt;element name="ZUB_Bereichsgrenze_Nach_LZB" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CZUB_Bereichsgrenze_Nach_LZB" maxOccurs="unbounded"/>
 *           &lt;element name="ZUB_Bereichsgrenze_Nach_Ohne" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CZUB_Bereichsgrenze_Nach_Ohne" maxOccurs="unbounded"/>
 *           &lt;element name="ZUB_Bereichsgrenze_Nach_PZB" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CZUB_Bereichsgrenze_Nach_PZB" maxOccurs="unbounded"/>
 *           &lt;element name="ZUB_Bereichsgrenze_Nach_Sonstige" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CZUB_Bereichsgrenze_Nach_Sonstige" maxOccurs="unbounded"/>
 *           &lt;element name="ZUB_Bgrenze_RBC_Wechsel" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CZUB_Bgrenze_RBC_Wechsel" maxOccurs="unbounded"/>
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
@XmlType(name = "CZUB_Bereichsgrenze", propOrder = {
    "bezeichnung",
    "idOertlichkeit",
    "zubBereichsgrenzeAllg",
    "zubBereichsgrenzeNachESG",
    "zubBereichsgrenzeNachGNT",
    "zubBereichsgrenzeNachL2",
    "zubBereichsgrenzeNachLZB",
    "zubBereichsgrenzeNachOhne",
    "zubBereichsgrenzeNachPZB",
    "zubBereichsgrenzeNachSonstige",
    "zubBgrenzeRBCWechsel"
})
public class CZUBBereichsgrenze
    extends CPunktObjekt
{

    @XmlElement(name = "Bezeichnung")
    protected CZUBBereichsgrenzeBezeichnung bezeichnung;
    @XmlElement(name = "ID_Oertlichkeit", required = true)
    protected TCIDOertlichkeitProxy idOertlichkeit;
    @XmlElement(name = "ZUB_Bereichsgrenze_Allg", required = true)
    protected CZUBBereichsgrenzeAllg zubBereichsgrenzeAllg;
    @XmlElement(name = "ZUB_Bereichsgrenze_Nach_ESG")
    protected List<CZUBBereichsgrenzeNachESG> zubBereichsgrenzeNachESG;
    @XmlElement(name = "ZUB_Bereichsgrenze_Nach_GNT")
    protected List<CZUBBereichsgrenzeNachGNT> zubBereichsgrenzeNachGNT;
    @XmlElement(name = "ZUB_Bereichsgrenze_Nach_L2")
    protected List<CZUBBereichsgrenzeNachL2> zubBereichsgrenzeNachL2;
    @XmlElement(name = "ZUB_Bereichsgrenze_Nach_LZB")
    protected List<CZUBBereichsgrenzeNachLZB> zubBereichsgrenzeNachLZB;
    @XmlElement(name = "ZUB_Bereichsgrenze_Nach_Ohne")
    protected List<CZUBBereichsgrenzeNachOhne> zubBereichsgrenzeNachOhne;
    @XmlElement(name = "ZUB_Bereichsgrenze_Nach_PZB")
    protected List<CZUBBereichsgrenzeNachPZB> zubBereichsgrenzeNachPZB;
    @XmlElement(name = "ZUB_Bereichsgrenze_Nach_Sonstige")
    protected List<CZUBBereichsgrenzeNachSonstige> zubBereichsgrenzeNachSonstige;
    @XmlElement(name = "ZUB_Bgrenze_RBC_Wechsel")
    protected List<CZUBBgrenzeRBCWechsel> zubBgrenzeRBCWechsel;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZUBBereichsgrenzeBezeichnung }
     *     
     */
    public CZUBBereichsgrenzeBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZUBBereichsgrenzeBezeichnung }
     *     
     */
    public void setBezeichnung(CZUBBereichsgrenzeBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idOertlichkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public TCIDOertlichkeitProxy getIDOertlichkeit() {
        return idOertlichkeit;
    }

    /**
     * Legt den Wert der idOertlichkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public void setIDOertlichkeit(TCIDOertlichkeitProxy value) {
        this.idOertlichkeit = value;
    }

    /**
     * Ruft den Wert der zubBereichsgrenzeAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZUBBereichsgrenzeAllg }
     *     
     */
    public CZUBBereichsgrenzeAllg getZUBBereichsgrenzeAllg() {
        return zubBereichsgrenzeAllg;
    }

    /**
     * Legt den Wert der zubBereichsgrenzeAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZUBBereichsgrenzeAllg }
     *     
     */
    public void setZUBBereichsgrenzeAllg(CZUBBereichsgrenzeAllg value) {
        this.zubBereichsgrenzeAllg = value;
    }

    /**
     * Gets the value of the zubBereichsgrenzeNachESG property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zubBereichsgrenzeNachESG property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZUBBereichsgrenzeNachESG().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZUBBereichsgrenzeNachESG }
     * 
     * 
     */
    public List<CZUBBereichsgrenzeNachESG> getZUBBereichsgrenzeNachESG() {
        if (zubBereichsgrenzeNachESG == null) {
            zubBereichsgrenzeNachESG = new ArrayList<CZUBBereichsgrenzeNachESG>();
        }
        return this.zubBereichsgrenzeNachESG;
    }

    /**
     * Gets the value of the zubBereichsgrenzeNachGNT property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zubBereichsgrenzeNachGNT property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZUBBereichsgrenzeNachGNT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZUBBereichsgrenzeNachGNT }
     * 
     * 
     */
    public List<CZUBBereichsgrenzeNachGNT> getZUBBereichsgrenzeNachGNT() {
        if (zubBereichsgrenzeNachGNT == null) {
            zubBereichsgrenzeNachGNT = new ArrayList<CZUBBereichsgrenzeNachGNT>();
        }
        return this.zubBereichsgrenzeNachGNT;
    }

    /**
     * Gets the value of the zubBereichsgrenzeNachL2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zubBereichsgrenzeNachL2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZUBBereichsgrenzeNachL2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZUBBereichsgrenzeNachL2 }
     * 
     * 
     */
    public List<CZUBBereichsgrenzeNachL2> getZUBBereichsgrenzeNachL2() {
        if (zubBereichsgrenzeNachL2 == null) {
            zubBereichsgrenzeNachL2 = new ArrayList<CZUBBereichsgrenzeNachL2>();
        }
        return this.zubBereichsgrenzeNachL2;
    }

    /**
     * Gets the value of the zubBereichsgrenzeNachLZB property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zubBereichsgrenzeNachLZB property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZUBBereichsgrenzeNachLZB().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZUBBereichsgrenzeNachLZB }
     * 
     * 
     */
    public List<CZUBBereichsgrenzeNachLZB> getZUBBereichsgrenzeNachLZB() {
        if (zubBereichsgrenzeNachLZB == null) {
            zubBereichsgrenzeNachLZB = new ArrayList<CZUBBereichsgrenzeNachLZB>();
        }
        return this.zubBereichsgrenzeNachLZB;
    }

    /**
     * Gets the value of the zubBereichsgrenzeNachOhne property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zubBereichsgrenzeNachOhne property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZUBBereichsgrenzeNachOhne().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZUBBereichsgrenzeNachOhne }
     * 
     * 
     */
    public List<CZUBBereichsgrenzeNachOhne> getZUBBereichsgrenzeNachOhne() {
        if (zubBereichsgrenzeNachOhne == null) {
            zubBereichsgrenzeNachOhne = new ArrayList<CZUBBereichsgrenzeNachOhne>();
        }
        return this.zubBereichsgrenzeNachOhne;
    }

    /**
     * Gets the value of the zubBereichsgrenzeNachPZB property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zubBereichsgrenzeNachPZB property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZUBBereichsgrenzeNachPZB().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZUBBereichsgrenzeNachPZB }
     * 
     * 
     */
    public List<CZUBBereichsgrenzeNachPZB> getZUBBereichsgrenzeNachPZB() {
        if (zubBereichsgrenzeNachPZB == null) {
            zubBereichsgrenzeNachPZB = new ArrayList<CZUBBereichsgrenzeNachPZB>();
        }
        return this.zubBereichsgrenzeNachPZB;
    }

    /**
     * Gets the value of the zubBereichsgrenzeNachSonstige property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zubBereichsgrenzeNachSonstige property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZUBBereichsgrenzeNachSonstige().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZUBBereichsgrenzeNachSonstige }
     * 
     * 
     */
    public List<CZUBBereichsgrenzeNachSonstige> getZUBBereichsgrenzeNachSonstige() {
        if (zubBereichsgrenzeNachSonstige == null) {
            zubBereichsgrenzeNachSonstige = new ArrayList<CZUBBereichsgrenzeNachSonstige>();
        }
        return this.zubBereichsgrenzeNachSonstige;
    }

    /**
     * Gets the value of the zubBgrenzeRBCWechsel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zubBgrenzeRBCWechsel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZUBBgrenzeRBCWechsel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZUBBgrenzeRBCWechsel }
     * 
     * 
     */
    public List<CZUBBgrenzeRBCWechsel> getZUBBgrenzeRBCWechsel() {
        if (zubBgrenzeRBCWechsel == null) {
            zubBgrenzeRBCWechsel = new ArrayList<CZUBBgrenzeRBCWechsel>();
        }
        return this.zubBgrenzeRBCWechsel;
    }

}
