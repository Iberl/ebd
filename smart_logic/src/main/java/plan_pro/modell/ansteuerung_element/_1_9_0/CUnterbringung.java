//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ansteuerung_element._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektStrecke;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektTOPKante;
import plan_pro.modell.verweise._1_9_0.TCIDGEOPunkt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Ort der Anordnung von nicht an das Gleis gebundenen Komponenten. Die Verortung der U. erfolgt entweder analog zum Punkt Objekt, mit einem GEO Punkt oder durch einen beschreibenden Text. Eine U. beschreibt in der Regel die Umhausung der Komponente. Ist sie nicht eingehaust, wird als Unterbringung Art \"keine\" angegeben. In diesen F�llen hat die Komponente dennoch eine Unterbringung Befestigung. Das ist z. B. der Fall, wenn eine wetterfeste Komponente (z. B. Schl�sselschalter) ohne Einhausung direkt an einem Pfosten befestigt ist. In einer U. k�nnen mehrere LST-Objekte untergebracht sein. Eine U. ist z. B. ein Betonschalthaus oder ein Schaltkasten. DB-Regelwerk Darstellung des Geb�udes im sicherungstechnischen Lageplan nach Ril 819.9002 oder Beschreibung im Erl�uterungsbericht
 * 
 * <p>Java-Klasse f�r CUnterbringung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CUnterbringung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Punkt_Objekt_Strecke" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CPunkt_Objekt_Strecke" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Unterbringung_Allg" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}CUnterbringung_Allg"/>
 *         &lt;choice>
 *           &lt;element name="ID_GEO_Punkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_GEO_Punkt"/>
 *           &lt;element name="Punkt_Objekt_TOP_Kante" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CPunkt_Objekt_TOP_Kante"/>
 *           &lt;element name="Standort_Beschreibung" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCStandort_Beschreibung"/>
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
@XmlType(name = "CUnterbringung", propOrder = {
    "punktObjektStrecke",
    "unterbringungAllg",
    "idgeoPunkt",
    "punktObjektTOPKante",
    "standortBeschreibung"
})
public class CUnterbringung
    extends CBasisObjekt
{

    @XmlElement(name = "Punkt_Objekt_Strecke")
    protected List<CPunktObjektStrecke> punktObjektStrecke;
    @XmlElement(name = "Unterbringung_Allg", required = true)
    protected CUnterbringungAllg unterbringungAllg;
    @XmlElement(name = "ID_GEO_Punkt")
    protected TCIDGEOPunkt idgeoPunkt;
    @XmlElement(name = "Punkt_Objekt_TOP_Kante")
    protected CPunktObjektTOPKante punktObjektTOPKante;
    @XmlElement(name = "Standort_Beschreibung")
    protected TCStandortBeschreibung standortBeschreibung;

    /**
     * Gets the value of the punktObjektStrecke property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the punktObjektStrecke property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPunktObjektStrecke().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CPunktObjektStrecke }
     * 
     * 
     */
    public List<CPunktObjektStrecke> getPunktObjektStrecke() {
        if (punktObjektStrecke == null) {
            punktObjektStrecke = new ArrayList<CPunktObjektStrecke>();
        }
        return this.punktObjektStrecke;
    }

    /**
     * Ruft den Wert der unterbringungAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CUnterbringungAllg }
     *     
     */
    public CUnterbringungAllg getUnterbringungAllg() {
        return unterbringungAllg;
    }

    /**
     * Legt den Wert der unterbringungAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CUnterbringungAllg }
     *     
     */
    public void setUnterbringungAllg(CUnterbringungAllg value) {
        this.unterbringungAllg = value;
    }

    /**
     * Ruft den Wert der idgeoPunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGEOPunkt }
     *     
     */
    public TCIDGEOPunkt getIDGEOPunkt() {
        return idgeoPunkt;
    }

    /**
     * Legt den Wert der idgeoPunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGEOPunkt }
     *     
     */
    public void setIDGEOPunkt(TCIDGEOPunkt value) {
        this.idgeoPunkt = value;
    }

    /**
     * Ruft den Wert der punktObjektTOPKante-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPunktObjektTOPKante }
     *     
     */
    public CPunktObjektTOPKante getPunktObjektTOPKante() {
        return punktObjektTOPKante;
    }

    /**
     * Legt den Wert der punktObjektTOPKante-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPunktObjektTOPKante }
     *     
     */
    public void setPunktObjektTOPKante(CPunktObjektTOPKante value) {
        this.punktObjektTOPKante = value;
    }

    /**
     * Ruft den Wert der standortBeschreibung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCStandortBeschreibung }
     *     
     */
    public TCStandortBeschreibung getStandortBeschreibung() {
        return standortBeschreibung;
    }

    /**
     * Legt den Wert der standortBeschreibung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCStandortBeschreibung }
     *     
     */
    public void setStandortBeschreibung(TCStandortBeschreibung value) {
        this.standortBeschreibung = value;
    }

}
