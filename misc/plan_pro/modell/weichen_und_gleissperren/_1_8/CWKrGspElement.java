//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.weichen_und_gleissperren._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.basistypen._1_8.CBezeichnungElement;
import modell.verweise._1_8.TCIDRegelzeichnung;
import modell.verweise._1_8.TCIDStellelement;
import modell.verweise._1_8.TCIDWKrAnlage;
import modell.verweise._1_8.TCIDWeichenlaufkette;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Einzeln stellbarer Teil einer Weichenanlage oder einer Gleissperre, der h�chstens zwei Stellungen (Fahrrichtung rechts oder links bzw. Entgleisungsschuh aufgelegt oder abgelegt) annehmen kann. Weichenanlagen bekommen 1 bzw. 2 Weichenelemente zugeordnet. Jedes Weichenelement besteht aus mindestens einer (ggf. mehreren) Komponenten (Zungenpaare, Herzst�ckspitzen), die die technische Sicht darstellen. Eine Kreuzung hat zwei Weichenelemente (A- und B-Seite). Im Fall beweglicher doppelter Herzst�ckspitzen hat die Kreuzung auch zwei Endlagen. Eine starre Kreuzung hat keine Regelzeichnung, da diese keinen Antrieb besitzt. Gleissperren haben kein Objekt im Sinn einer Anlage. Die Attributgruppen GZ_Freimeldung_R bzw. GZ_Freimeldung_L werden nur angegeben, wenn der rechte bzw. linke Schenkel einer Weiche nicht grenzzeichenfrei freigemeldet ist. Wenn das Element weder f�r eine Weiche oder Gleissperre genutzt wird (z.B. Verrrieglung einer beweglichen Br�cke oder eines Tors), werden die Attributgruppen Gleissperre_Element und Weiche_Element nicht verwendet (optionale Choice). Die Verfeinerung der Modellierung erfolgt nach Version 1.8.0. Siehe auch Modellierung Weichen. DB-Regelwerk Weichen werden gem�� Richtlinie 800.0120 gebaut. F�r die Anordnung der Bauteile (einschlie�lich Antriebe) an einer Weiche und der Gleissperren existieren Regelzeichnungen der Gruppe S 73xx. F�r die Planung von Weichen ist das Regelwerk 819 zu beachten.
 * 
 * <p>Java-Klasse f�r CW_Kr_Gsp_Element complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CW_Kr_Gsp_Element">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/BasisTypen/1.8.0}CBezeichnung_Element"/>
 *         &lt;element name="ID_Regelzeichnung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Regelzeichnung" minOccurs="0"/>
 *         &lt;element name="ID_Stellelement" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Stellelement" minOccurs="0"/>
 *         &lt;element name="ID_W_Kr_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_W_Kr_Anlage" minOccurs="0"/>
 *         &lt;element name="ID_Weichenlaufkette" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Weichenlaufkette" minOccurs="0"/>
 *         &lt;element name="W_Kr_Gsp_Element_Allg" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}CW_Kr_Gsp_Element_Allg"/>
 *         &lt;choice>
 *           &lt;element name="Gleissperre_Element" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}CGleissperre_Element" minOccurs="0"/>
 *           &lt;element name="Weiche_Element" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}CWeiche_Element" minOccurs="0"/>
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
@XmlType(name = "CW_Kr_Gsp_Element", propOrder = {
    "bezeichnung",
    "idRegelzeichnung",
    "idStellelement",
    "idwKrAnlage",
    "idWeichenlaufkette",
    "wKrGspElementAllg",
    "gleissperreElement",
    "weicheElement"
})
public class CWKrGspElement
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CBezeichnungElement bezeichnung;
    @XmlElement(name = "ID_Regelzeichnung")
    protected TCIDRegelzeichnung idRegelzeichnung;
    @XmlElement(name = "ID_Stellelement")
    protected TCIDStellelement idStellelement;
    @XmlElement(name = "ID_W_Kr_Anlage")
    protected TCIDWKrAnlage idwKrAnlage;
    @XmlElement(name = "ID_Weichenlaufkette")
    protected TCIDWeichenlaufkette idWeichenlaufkette;
    @XmlElement(name = "W_Kr_Gsp_Element_Allg", required = true)
    protected CWKrGspElementAllg wKrGspElementAllg;
    @XmlElement(name = "Gleissperre_Element")
    protected CGleissperreElement gleissperreElement;
    @XmlElement(name = "Weiche_Element")
    protected CWeicheElement weicheElement;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBezeichnungElement }
     *     
     */
    public CBezeichnungElement getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBezeichnungElement }
     *     
     */
    public void setBezeichnung(CBezeichnungElement value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idRegelzeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDRegelzeichnung }
     *     
     */
    public TCIDRegelzeichnung getIDRegelzeichnung() {
        return idRegelzeichnung;
    }

    /**
     * Legt den Wert der idRegelzeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDRegelzeichnung }
     *     
     */
    public void setIDRegelzeichnung(TCIDRegelzeichnung value) {
        this.idRegelzeichnung = value;
    }

    /**
     * Ruft den Wert der idStellelement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDStellelement }
     *     
     */
    public TCIDStellelement getIDStellelement() {
        return idStellelement;
    }

    /**
     * Legt den Wert der idStellelement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDStellelement }
     *     
     */
    public void setIDStellelement(TCIDStellelement value) {
        this.idStellelement = value;
    }

    /**
     * Ruft den Wert der idwKrAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDWKrAnlage }
     *     
     */
    public TCIDWKrAnlage getIDWKrAnlage() {
        return idwKrAnlage;
    }

    /**
     * Legt den Wert der idwKrAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDWKrAnlage }
     *     
     */
    public void setIDWKrAnlage(TCIDWKrAnlage value) {
        this.idwKrAnlage = value;
    }

    /**
     * Ruft den Wert der idWeichenlaufkette-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDWeichenlaufkette }
     *     
     */
    public TCIDWeichenlaufkette getIDWeichenlaufkette() {
        return idWeichenlaufkette;
    }

    /**
     * Legt den Wert der idWeichenlaufkette-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDWeichenlaufkette }
     *     
     */
    public void setIDWeichenlaufkette(TCIDWeichenlaufkette value) {
        this.idWeichenlaufkette = value;
    }

    /**
     * Ruft den Wert der wKrGspElementAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CWKrGspElementAllg }
     *     
     */
    public CWKrGspElementAllg getWKrGspElementAllg() {
        return wKrGspElementAllg;
    }

    /**
     * Legt den Wert der wKrGspElementAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CWKrGspElementAllg }
     *     
     */
    public void setWKrGspElementAllg(CWKrGspElementAllg value) {
        this.wKrGspElementAllg = value;
    }

    /**
     * Ruft den Wert der gleissperreElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CGleissperreElement }
     *     
     */
    public CGleissperreElement getGleissperreElement() {
        return gleissperreElement;
    }

    /**
     * Legt den Wert der gleissperreElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CGleissperreElement }
     *     
     */
    public void setGleissperreElement(CGleissperreElement value) {
        this.gleissperreElement = value;
    }

    /**
     * Ruft den Wert der weicheElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CWeicheElement }
     *     
     */
    public CWeicheElement getWeicheElement() {
        return weicheElement;
    }

    /**
     * Legt den Wert der weicheElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CWeicheElement }
     *     
     */
    public void setWeicheElement(CWeicheElement value) {
        this.weicheElement = value;
    }

}
