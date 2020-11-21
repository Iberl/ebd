//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.schluesselabhaengigkeiten._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDSchluessel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Mechanisches Bauelement, das durch das Ein- oder Ausschlie�en eines Schl�ssels einen Riegel aus- oder einfahren l�sst bzw. einen elektrischen Kontakt schlie�t oder �ffnet. Je nach verschlossenem Element wird die entsprechende Attributgruppe ausgew�hlt: Bahn�bergang, Gleissperre, Schlosskombination, Sonderanlage (z. B. bewegliche Br�cke), Schl�sselsperre, Weiche. DB-Regelwerk Auf dem Lageplan werden nach 819.9002 3 dargestellt: Schl�sser durch ein Symbol (z. B. Schl�sselsperre) oder zus�tzliche Angaben zu anderen Symbolen (z. B. Weiche); Abh�ngigkeiten durch eine Zeichnung mit wiederholter Darstellung der Schlossstellungen als gef�lltes oder leeres Schl�sselloch. 
 * 
 * <p>Java-Klasse f�r CSchloss complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchloss">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}CSchloss_Bezeichnung"/>
 *         &lt;element name="ID_Schluessel" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Schluessel"/>
 *         &lt;element name="Schluessel_In_Grdst_Eingeschl" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}TCSchluessel_In_Grdst_Eingeschl"/>
 *         &lt;choice>
 *           &lt;element name="Schloss_BUE" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}CSchloss_BUE"/>
 *           &lt;element name="Schloss_Gsp" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}CSchloss_Gsp"/>
 *           &lt;element name="Schloss_Sk" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}CSchloss_Sk"/>
 *           &lt;element name="Schloss_Sonderanlage" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}CSchloss_Sonderanlage"/>
 *           &lt;element name="Schloss_Ssp" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}CSchloss_Ssp"/>
 *           &lt;element name="Schloss_W" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}CSchloss_W"/>
 *           &lt;element name="Technisch_Berechtigter" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}TCTechnisch_Berechtigter"/>
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
@XmlType(name = "CSchloss", propOrder = {
    "bezeichnung",
    "idSchluessel",
    "schluesselInGrdstEingeschl",
    "schlossBUE",
    "schlossGsp",
    "schlossSk",
    "schlossSonderanlage",
    "schlossSsp",
    "schlossW",
    "technischBerechtigter"
})
public class CSchloss
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CSchlossBezeichnung bezeichnung;
    @XmlElement(name = "ID_Schluessel", required = true)
    protected TCIDSchluessel idSchluessel;
    @XmlElement(name = "Schluessel_In_Grdst_Eingeschl", required = true)
    protected TCSchluesselInGrdstEingeschl schluesselInGrdstEingeschl;
    @XmlElement(name = "Schloss_BUE")
    protected CSchlossBUE schlossBUE;
    @XmlElement(name = "Schloss_Gsp")
    protected CSchlossGsp schlossGsp;
    @XmlElement(name = "Schloss_Sk")
    protected CSchlossSk schlossSk;
    @XmlElement(name = "Schloss_Sonderanlage")
    protected CSchlossSonderanlage schlossSonderanlage;
    @XmlElement(name = "Schloss_Ssp")
    protected CSchlossSsp schlossSsp;
    @XmlElement(name = "Schloss_W")
    protected CSchlossW schlossW;
    @XmlElement(name = "Technisch_Berechtigter")
    protected TCTechnischBerechtigter technischBerechtigter;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSchlossBezeichnung }
     *     
     */
    public CSchlossBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSchlossBezeichnung }
     *     
     */
    public void setBezeichnung(CSchlossBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idSchluessel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSchluessel }
     *     
     */
    public TCIDSchluessel getIDSchluessel() {
        return idSchluessel;
    }

    /**
     * Legt den Wert der idSchluessel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSchluessel }
     *     
     */
    public void setIDSchluessel(TCIDSchluessel value) {
        this.idSchluessel = value;
    }

    /**
     * Ruft den Wert der schluesselInGrdstEingeschl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSchluesselInGrdstEingeschl }
     *     
     */
    public TCSchluesselInGrdstEingeschl getSchluesselInGrdstEingeschl() {
        return schluesselInGrdstEingeschl;
    }

    /**
     * Legt den Wert der schluesselInGrdstEingeschl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSchluesselInGrdstEingeschl }
     *     
     */
    public void setSchluesselInGrdstEingeschl(TCSchluesselInGrdstEingeschl value) {
        this.schluesselInGrdstEingeschl = value;
    }

    /**
     * Ruft den Wert der schlossBUE-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSchlossBUE }
     *     
     */
    public CSchlossBUE getSchlossBUE() {
        return schlossBUE;
    }

    /**
     * Legt den Wert der schlossBUE-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSchlossBUE }
     *     
     */
    public void setSchlossBUE(CSchlossBUE value) {
        this.schlossBUE = value;
    }

    /**
     * Ruft den Wert der schlossGsp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSchlossGsp }
     *     
     */
    public CSchlossGsp getSchlossGsp() {
        return schlossGsp;
    }

    /**
     * Legt den Wert der schlossGsp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSchlossGsp }
     *     
     */
    public void setSchlossGsp(CSchlossGsp value) {
        this.schlossGsp = value;
    }

    /**
     * Ruft den Wert der schlossSk-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSchlossSk }
     *     
     */
    public CSchlossSk getSchlossSk() {
        return schlossSk;
    }

    /**
     * Legt den Wert der schlossSk-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSchlossSk }
     *     
     */
    public void setSchlossSk(CSchlossSk value) {
        this.schlossSk = value;
    }

    /**
     * Ruft den Wert der schlossSonderanlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSchlossSonderanlage }
     *     
     */
    public CSchlossSonderanlage getSchlossSonderanlage() {
        return schlossSonderanlage;
    }

    /**
     * Legt den Wert der schlossSonderanlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSchlossSonderanlage }
     *     
     */
    public void setSchlossSonderanlage(CSchlossSonderanlage value) {
        this.schlossSonderanlage = value;
    }

    /**
     * Ruft den Wert der schlossSsp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSchlossSsp }
     *     
     */
    public CSchlossSsp getSchlossSsp() {
        return schlossSsp;
    }

    /**
     * Legt den Wert der schlossSsp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSchlossSsp }
     *     
     */
    public void setSchlossSsp(CSchlossSsp value) {
        this.schlossSsp = value;
    }

    /**
     * Ruft den Wert der schlossW-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSchlossW }
     *     
     */
    public CSchlossW getSchlossW() {
        return schlossW;
    }

    /**
     * Legt den Wert der schlossW-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSchlossW }
     *     
     */
    public void setSchlossW(CSchlossW value) {
        this.schlossW = value;
    }

    /**
     * Ruft den Wert der technischBerechtigter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTechnischBerechtigter }
     *     
     */
    public TCTechnischBerechtigter getTechnischBerechtigter() {
        return technischBerechtigter;
    }

    /**
     * Legt den Wert der technischBerechtigter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTechnischBerechtigter }
     *     
     */
    public void setTechnischBerechtigter(TCTechnischBerechtigter value) {
        this.technischBerechtigter = value;
    }

}
