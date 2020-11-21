//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDDatenpunkt;
import plan_pro.modell.verweise._1_9_0.TCIDSignal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Teil des Fahrwegs, auf den sich die Informationen des Fachtelegramms beziehen. Die Fahrwegteile k�nnen au�erhalb der betroffenen Fahrstra�e liegen. Im Unterschied zum Fahrweg der Fahrstra�e wird der Fahrwegteil nicht als Bereichsobjekt abgebildet, da in einigen F�llen kein Zielelement existiert (z. B. �bergang in Rangierbereich) oder das exakte Ende des Fahrwegteils nicht bestimmt wird (Kreuzungsweichen). Fahrwegteile mit mehreren Zielpunkten sind durch mehrere Instanzen von FT_Fahrweg_Teil abzubilden.
 * 
 * <p>Java-Klasse f�r CFT_Fahrweg_Teil complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFT_Fahrweg_Teil">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="FT_Fahrweg_Teil_Allg" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CFT_Fahrweg_Teil_Allg"/>
 *         &lt;choice>
 *           &lt;element name="ID_Ziel_Datenpunkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Datenpunkt" minOccurs="0"/>
 *           &lt;element name="ID_Ziel_Signal" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal" minOccurs="0"/>
 *           &lt;element name="Ziel_W_Element" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CZiel_W_Element" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element name="ID_Start_Datenpunkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Datenpunkt"/>
 *           &lt;element name="ID_Start_Signal" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal"/>
 *           &lt;element name="Start_W_Element" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CStart_W_Element"/>
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
@XmlType(name = "CFT_Fahrweg_Teil", propOrder = {
    "ftFahrwegTeilAllg",
    "idZielDatenpunkt",
    "idZielSignal",
    "zielWElement",
    "idStartDatenpunkt",
    "idStartSignal",
    "startWElement"
})
public class CFTFahrwegTeil
    extends CBasisObjekt
{

    @XmlElement(name = "FT_Fahrweg_Teil_Allg", required = true)
    protected CFTFahrwegTeilAllg ftFahrwegTeilAllg;
    @XmlElement(name = "ID_Ziel_Datenpunkt")
    protected TCIDDatenpunkt idZielDatenpunkt;
    @XmlElement(name = "ID_Ziel_Signal")
    protected TCIDSignal idZielSignal;
    @XmlElement(name = "Ziel_W_Element")
    protected CZielWElement zielWElement;
    @XmlElement(name = "ID_Start_Datenpunkt")
    protected TCIDDatenpunkt idStartDatenpunkt;
    @XmlElement(name = "ID_Start_Signal")
    protected TCIDSignal idStartSignal;
    @XmlElement(name = "Start_W_Element")
    protected CStartWElement startWElement;

    /**
     * Ruft den Wert der ftFahrwegTeilAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFTFahrwegTeilAllg }
     *     
     */
    public CFTFahrwegTeilAllg getFTFahrwegTeilAllg() {
        return ftFahrwegTeilAllg;
    }

    /**
     * Legt den Wert der ftFahrwegTeilAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFTFahrwegTeilAllg }
     *     
     */
    public void setFTFahrwegTeilAllg(CFTFahrwegTeilAllg value) {
        this.ftFahrwegTeilAllg = value;
    }

    /**
     * Ruft den Wert der idZielDatenpunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDDatenpunkt }
     *     
     */
    public TCIDDatenpunkt getIDZielDatenpunkt() {
        return idZielDatenpunkt;
    }

    /**
     * Legt den Wert der idZielDatenpunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDDatenpunkt }
     *     
     */
    public void setIDZielDatenpunkt(TCIDDatenpunkt value) {
        this.idZielDatenpunkt = value;
    }

    /**
     * Ruft den Wert der idZielSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignal }
     *     
     */
    public TCIDSignal getIDZielSignal() {
        return idZielSignal;
    }

    /**
     * Legt den Wert der idZielSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignal }
     *     
     */
    public void setIDZielSignal(TCIDSignal value) {
        this.idZielSignal = value;
    }

    /**
     * Ruft den Wert der zielWElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZielWElement }
     *     
     */
    public CZielWElement getZielWElement() {
        return zielWElement;
    }

    /**
     * Legt den Wert der zielWElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZielWElement }
     *     
     */
    public void setZielWElement(CZielWElement value) {
        this.zielWElement = value;
    }

    /**
     * Ruft den Wert der idStartDatenpunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDDatenpunkt }
     *     
     */
    public TCIDDatenpunkt getIDStartDatenpunkt() {
        return idStartDatenpunkt;
    }

    /**
     * Legt den Wert der idStartDatenpunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDDatenpunkt }
     *     
     */
    public void setIDStartDatenpunkt(TCIDDatenpunkt value) {
        this.idStartDatenpunkt = value;
    }

    /**
     * Ruft den Wert der idStartSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignal }
     *     
     */
    public TCIDSignal getIDStartSignal() {
        return idStartSignal;
    }

    /**
     * Legt den Wert der idStartSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignal }
     *     
     */
    public void setIDStartSignal(TCIDSignal value) {
        this.idStartSignal = value;
    }

    /**
     * Ruft den Wert der startWElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CStartWElement }
     *     
     */
    public CStartWElement getStartWElement() {
        return startWElement;
    }

    /**
     * Legt den Wert der startWElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CStartWElement }
     *     
     */
    public void setStartWElement(CStartWElement value) {
        this.startWElement = value;
    }

}
