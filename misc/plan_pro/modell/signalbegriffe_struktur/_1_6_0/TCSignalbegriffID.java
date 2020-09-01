//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.signalbegriffe_struktur._1_6_0;

import modell.signalbegriffe_ril_301._1_8.*;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Signalbegriff gem�� Ril 301 (Signalbuch).
 * 
 * F�r jeden Signalbegriff wird eine eigene Instanz des Objektes angelegt. Die Attribute 
 * 
 * <p>Java-Klasse f�r TCSignalbegriff_ID complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TCSignalbegriff_ID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Symbol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Anmerkungen" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Beleuchtbar" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Beschreibung" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Geltungsbereich_DS" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Geltungsbereich_DV" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Geltungsbereich_SBahn_B" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Geltungsbereich_SBahn_HH" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Gueltig_Ab" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="Gueltig_Bis" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="Kurzbezeichnung_DS" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Kurzbezeichnung_DV" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Langbezeichnung" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Schaltbar" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Zusatz_Moeglich" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCSignalbegriff_ID", propOrder = {
    "symbol"
})
@XmlSeeAlso({
    Zs8A.class,
    So15 .class,
    Zs2V.class,
    So14 .class,
    Lf12 .class,
    Ne7A.class,
    Ne7B.class,
    So1 .class,
    Ne34Str.class,
    Hp02Lp.class,
    Sk2 .class,
    Sk1 .class,
    MsGeD.class,
    Ks2 .class,
    Ks1 .class,
    OzLZBBer.class,
    Zs103 .class,
    BSVRVA.class,
    OzFa.class,
    MsWsSwWs.class,
    Ra11B.class,
    El1V.class,
    So20 .class,
    MsRt.class,
    Ne31Str.class,
    MsWsGeWs.class,
    Hl11 .class,
    Hl10 .class,
    Hl12B.class,
    Hl12A.class,
    ElPfL.class,
    Lf4DS.class,
    ElPfO.class,
    ElPfB.class,
    Bue00Lp.class,
    BueKT.class,
    MsSkGe.class,
    Sv3 .class,
    Bue5 .class,
    Sv2 .class,
    Sv1 .class,
    Sv0 .class,
    Wvs.class,
    Zp10Ls.class,
    Sv6 .class,
    Bue2 .class,
    Sv5 .class,
    So106 .class,
    Bue3 .class,
    Sv4 .class,
    SvWPf.class,
    Bue4 .class,
    Zs3V.class,
    OzAutoET.class,
    Ne33Str.class,
    Hl9A.class,
    Bue11SBli.class,
    Pf2 .class,
    Hl9B.class,
    Bue02S.class,
    BSWdh.class,
    OzHET.class,
    MsUESWdh.class,
    Ne2VRVA.class,
    ElTDC.class,
    Ukr.class,
    BueAT.class,
    Zp10 .class,
    Kl.class,
    LfPf.class,
    OzICE.class,
    MsVw.class,
    Bue01Lp.class,
    Bue23R.class,
    So191P.class,
    Bue01S.class,
    BSZusatz.class,
    OzBk.class,
    BSVAUES.class,
    OzZf.class,
    El1 .class,
    El2 .class,
    El3 .class,
    El4 .class,
    El5 .class,
    OzOBGrenze.class,
    El6 .class,
    Hl3A.class,
    Ra12 .class,
    Ra11 .class,
    Hl3B.class,
    Ra13 .class,
    OzAutoHET.class,
    Zp7 .class,
    Vr0 .class,
    Zp8 .class,
    Vr1 .class,
    Vr2 .class,
    Zp6 .class,
    Bue22R.class,
    Ne35Str.class,
    Bue12SSt.class,
    Ts3 .class,
    Ts2 .class,
    Ts1 .class,
    MsSkRt.class,
    ElPfR.class,
    Lf4DV.class,
    Zp9 .class,
    Ra10 .class,
    Sh1 .class,
    Wn1 .class,
    LfPfL.class,
    Sh0 .class,
    Wn3 .class,
    Ne13A.class,
    Wn2 .class,
    Wn5 .class,
    Wn4 .class,
    Wn7 .class,
    LfPfR.class,
    Wn6 .class,
    Ne32Str.class,
    Bue21R.class,
    Bue02Lp.class,
    Ne13B.class,
    Hl6B.class,
    So193P.class,
    Hl6A.class,
    Sh2 .class,
    Bue11LpBli.class,
    Zp9Ls.class,
    Zs1A.class,
    Lf5DV.class,
    ElTAC.class,
    Zs1 .class,
    Zs13 .class,
    ZlU.class,
    Lf5DS.class,
    Zs2 .class,
    NISESHM.class,
    Zs3 .class,
    ZlO.class,
    Lf1 .class,
    Ne4 .class,
    Lf2 .class,
    Ne5 .class,
    Lf3 .class,
    Ne6 .class,
    Zs10 .class,
    Ne1 .class,
    So192P.class,
    Zs12 .class,
    Ne2 .class,
    MsWsRtWs.class,
    OzET.class,
    Ne14 .class,
    Ne12 .class,
    Hl1 .class,
    Hl2 .class,
    Lf6 .class,
    Bue12LpSt.class,
    Lf7 .class,
    Bue10LpBli.class,
    Hp1 .class,
    Hl5 .class,
    Zs8 .class,
    Hp2 .class,
    Zs9 .class,
    Zs6 .class,
    Hp0 .class,
    Hl4 .class,
    Zs7 .class,
    OzPZBBUE.class,
    MsWs2SwP.class,
    Hl7 .class,
    Hl8 .class
})
public abstract class TCSignalbegriffID {

    @XmlElement(name = "Symbol")
    protected String symbol;
    @XmlAttribute(name = "Anmerkungen")
    protected String anmerkungen;
    @XmlAttribute(name = "Beleuchtbar")
    protected Boolean beleuchtbar;
    @XmlAttribute(name = "Beschreibung")
    protected String beschreibung;
    @XmlAttribute(name = "Geltungsbereich_DS")
    protected Boolean geltungsbereichDS;
    @XmlAttribute(name = "Geltungsbereich_DV")
    protected Boolean geltungsbereichDV;
    @XmlAttribute(name = "Geltungsbereich_SBahn_B")
    protected Boolean geltungsbereichSBahnB;
    @XmlAttribute(name = "Geltungsbereich_SBahn_HH")
    protected Boolean geltungsbereichSBahnHH;
    @XmlAttribute(name = "Gueltig_Ab")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar gueltigAb;
    @XmlAttribute(name = "Gueltig_Bis")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar gueltigBis;
    @XmlAttribute(name = "Kurzbezeichnung_DS")
    protected String kurzbezeichnungDS;
    @XmlAttribute(name = "Kurzbezeichnung_DV")
    protected String kurzbezeichnungDV;
    @XmlAttribute(name = "Langbezeichnung")
    protected String langbezeichnung;
    @XmlAttribute(name = "Schaltbar")
    protected Boolean schaltbar;
    @XmlAttribute(name = "Zusatz_Moeglich")
    protected Boolean zusatzMoeglich;

    /**
     * Ruft den Wert der symbol-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Legt den Wert der symbol-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbol(String value) {
        this.symbol = value;
    }

    /**
     * Ruft den Wert der anmerkungen-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnmerkungen() {
        return anmerkungen;
    }

    /**
     * Legt den Wert der anmerkungen-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnmerkungen(String value) {
        this.anmerkungen = value;
    }

    /**
     * Ruft den Wert der beleuchtbar-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBeleuchtbar() {
        return beleuchtbar;
    }

    /**
     * Legt den Wert der beleuchtbar-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBeleuchtbar(Boolean value) {
        this.beleuchtbar = value;
    }

    /**
     * Ruft den Wert der beschreibung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     * Legt den Wert der beschreibung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeschreibung(String value) {
        this.beschreibung = value;
    }

    /**
     * Ruft den Wert der geltungsbereichDS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGeltungsbereichDS() {
        return geltungsbereichDS;
    }

    /**
     * Legt den Wert der geltungsbereichDS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGeltungsbereichDS(Boolean value) {
        this.geltungsbereichDS = value;
    }

    /**
     * Ruft den Wert der geltungsbereichDV-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGeltungsbereichDV() {
        return geltungsbereichDV;
    }

    /**
     * Legt den Wert der geltungsbereichDV-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGeltungsbereichDV(Boolean value) {
        this.geltungsbereichDV = value;
    }

    /**
     * Ruft den Wert der geltungsbereichSBahnB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGeltungsbereichSBahnB() {
        return geltungsbereichSBahnB;
    }

    /**
     * Legt den Wert der geltungsbereichSBahnB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGeltungsbereichSBahnB(Boolean value) {
        this.geltungsbereichSBahnB = value;
    }

    /**
     * Ruft den Wert der geltungsbereichSBahnHH-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGeltungsbereichSBahnHH() {
        return geltungsbereichSBahnHH;
    }

    /**
     * Legt den Wert der geltungsbereichSBahnHH-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGeltungsbereichSBahnHH(Boolean value) {
        this.geltungsbereichSBahnHH = value;
    }

    /**
     * Ruft den Wert der gueltigAb-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGueltigAb() {
        return gueltigAb;
    }

    /**
     * Legt den Wert der gueltigAb-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGueltigAb(XMLGregorianCalendar value) {
        this.gueltigAb = value;
    }

    /**
     * Ruft den Wert der gueltigBis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGueltigBis() {
        return gueltigBis;
    }

    /**
     * Legt den Wert der gueltigBis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGueltigBis(XMLGregorianCalendar value) {
        this.gueltigBis = value;
    }

    /**
     * Ruft den Wert der kurzbezeichnungDS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKurzbezeichnungDS() {
        return kurzbezeichnungDS;
    }

    /**
     * Legt den Wert der kurzbezeichnungDS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKurzbezeichnungDS(String value) {
        this.kurzbezeichnungDS = value;
    }

    /**
     * Ruft den Wert der kurzbezeichnungDV-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKurzbezeichnungDV() {
        return kurzbezeichnungDV;
    }

    /**
     * Legt den Wert der kurzbezeichnungDV-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKurzbezeichnungDV(String value) {
        this.kurzbezeichnungDV = value;
    }

    /**
     * Ruft den Wert der langbezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLangbezeichnung() {
        return langbezeichnung;
    }

    /**
     * Legt den Wert der langbezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLangbezeichnung(String value) {
        this.langbezeichnung = value;
    }

    /**
     * Ruft den Wert der schaltbar-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSchaltbar() {
        return schaltbar;
    }

    /**
     * Legt den Wert der schaltbar-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSchaltbar(Boolean value) {
        this.schaltbar = value;
    }

    /**
     * Ruft den Wert der zusatzMoeglich-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isZusatzMoeglich() {
        return zusatzMoeglich;
    }

    /**
     * Legt den Wert der zusatzMoeglich-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setZusatzMoeglich(Boolean value) {
        this.zusatzMoeglich = value;
    }

}
