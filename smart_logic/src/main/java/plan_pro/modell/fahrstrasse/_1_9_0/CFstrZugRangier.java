//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDFstrAusschlussBesonders;
import plan_pro.modell.verweise._1_9_0.TCIDFstrFahrweg;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Zug- oder Rangierstra�e. Jeder Zugstra�e ist ein Durchrutschweg (modelliert in Fstr DWeg) zugeordnet. Gibt es Fahrstra�en mit mehreren Durchrutschwegen, so werden daf�r mehrere Zugstra�en angelegt, die auf dem gleichen befahrenen Teil (modelliert in Fstr Fahrweg) basieren. Mit dem Datenmodell werden auch Zentralblockfahrstra�en geplant. Der hiermit verkn�pfte Gefahrpunktabstand wird in Fstr DWeg abgebildet. Eine Zentralblockfahrstra�e (Fstr_Art==ZB) �ber die ESTW-Zentraleinheit-Grenze wird in zwei Teilblockfahrstra�en (Fstr_Art==ZB) im Bereich der jeweiligen ESTW-Zentraleinheit geplant. Dabei kann ein befahrener Teil der L�nge Null entstehen, wenn die zweite Teilblockfahrstra�e nur aus dem Durchrutschweg besteht. Zielsignal der ersten ist Startsignal der zweiten Teilblockfahrstra�e. Fahrstra�en �ber eine ESTW-Zentraleinheit-Grenze (FAP) werden als zwei Teilfahrstra�en (Fstr_Art==ZT/ZTU/RT/RTU) geplant. Kann die erste Teilfahrstra�e mit mehreren weiteren Teilfahrstra�en fortgesetzt werden, so muss f�r jede geplante Kombination eine eigene Instanz der ersten Teilfahrstra�e angelegt werden (analog der Zuordnung mehrerer Durchrutschwege). Die Verkn�pfung zur zweiten Teilfahrstra�e geschieht �ber Fstr_Zug_Rangier.ID Fstr Folgeabhaengigkeit. Eine Mittelweichenteilfahrstra�e besitzt keinen Durchrutschweg. Eine explizite Verkn�pfung von Mittelweichenteilfahrstra�en untereinander und mit der Zugstra�e erfolgt nicht, da sich diese �ber die Topologie und insbesondere �ber Start und Ziel ergeben. Eine Rangierstra�e besitzt ebenfalls keinen Durchrutschweg. Die speziellen Attribute von Zug-/Rangier-/Mittelweichenteilfahrstra�e werden in eigenen Attributgruppen gespeichert, die sich gegenseitig ausschlie�en. Gruppenausfahrten werden als Zugstra�en ohne besondere Eigenschaft abgebildet. Das Gruppenausfahrsignal wird unter ID Signal Gruppenausfahrt explizit angegeben, die Gruppenausfahrstra�e ist somit eindeutig erkennbar. DB-Regelwerk Zugstra�entabelle (eine Zeile), Rangierstra�entabelle (eine Zeile), Mittelweichenteilfahrstra�entabelle (eine Zeile). 
 * 
 * <p>Java-Klasse f�r CFstr_Zug_Rangier complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Zug_Rangier">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Fstr_Zug_Rangier_Allg" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}CFstr_Zug_Rangier_Allg"/>
 *         &lt;element name="ID_Fstr_Ausschluss_Besonders" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fstr_Ausschluss_Besonders" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_Fstr_Fahrweg" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fstr_Fahrweg"/>
 *         &lt;choice>
 *           &lt;element name="Fstr_Mittel" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}CFstr_Mittel"/>
 *           &lt;element name="Fstr_Rangier" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}CFstr_Rangier"/>
 *           &lt;element name="Fstr_Zug" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}CFstr_Zug"/>
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
@XmlType(name = "CFstr_Zug_Rangier", propOrder = {
    "fstrZugRangierAllg",
    "idFstrAusschlussBesonders",
    "idFstrFahrweg",
    "fstrMittel",
    "fstrRangier",
    "fstrZug"
})
public class CFstrZugRangier
    extends CBasisObjekt
{

    @XmlElement(name = "Fstr_Zug_Rangier_Allg", required = true)
    protected CFstrZugRangierAllg fstrZugRangierAllg;
    @XmlElement(name = "ID_Fstr_Ausschluss_Besonders")
    protected List<TCIDFstrAusschlussBesonders> idFstrAusschlussBesonders;
    @XmlElement(name = "ID_Fstr_Fahrweg", required = true)
    protected TCIDFstrFahrweg idFstrFahrweg;
    @XmlElement(name = "Fstr_Mittel")
    protected CFstrMittel fstrMittel;
    @XmlElement(name = "Fstr_Rangier")
    protected CFstrRangier fstrRangier;
    @XmlElement(name = "Fstr_Zug")
    protected CFstrZug fstrZug;

    /**
     * Ruft den Wert der fstrZugRangierAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFstrZugRangierAllg }
     *     
     */
    public CFstrZugRangierAllg getFstrZugRangierAllg() {
        return fstrZugRangierAllg;
    }

    /**
     * Legt den Wert der fstrZugRangierAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFstrZugRangierAllg }
     *     
     */
    public void setFstrZugRangierAllg(CFstrZugRangierAllg value) {
        this.fstrZugRangierAllg = value;
    }

    /**
     * Gets the value of the idFstrAusschlussBesonders property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idFstrAusschlussBesonders property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDFstrAusschlussBesonders().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDFstrAusschlussBesonders }
     * 
     * 
     */
    public List<TCIDFstrAusschlussBesonders> getIDFstrAusschlussBesonders() {
        if (idFstrAusschlussBesonders == null) {
            idFstrAusschlussBesonders = new ArrayList<TCIDFstrAusschlussBesonders>();
        }
        return this.idFstrAusschlussBesonders;
    }

    /**
     * Ruft den Wert der idFstrFahrweg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFstrFahrweg }
     *     
     */
    public TCIDFstrFahrweg getIDFstrFahrweg() {
        return idFstrFahrweg;
    }

    /**
     * Legt den Wert der idFstrFahrweg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFstrFahrweg }
     *     
     */
    public void setIDFstrFahrweg(TCIDFstrFahrweg value) {
        this.idFstrFahrweg = value;
    }

    /**
     * Ruft den Wert der fstrMittel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFstrMittel }
     *     
     */
    public CFstrMittel getFstrMittel() {
        return fstrMittel;
    }

    /**
     * Legt den Wert der fstrMittel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFstrMittel }
     *     
     */
    public void setFstrMittel(CFstrMittel value) {
        this.fstrMittel = value;
    }

    /**
     * Ruft den Wert der fstrRangier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFstrRangier }
     *     
     */
    public CFstrRangier getFstrRangier() {
        return fstrRangier;
    }

    /**
     * Legt den Wert der fstrRangier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFstrRangier }
     *     
     */
    public void setFstrRangier(CFstrRangier value) {
        this.fstrRangier = value;
    }

    /**
     * Ruft den Wert der fstrZug-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFstrZug }
     *     
     */
    public CFstrZug getFstrZug() {
        return fstrZug;
    }

    /**
     * Legt den Wert der fstrZug-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFstrZug }
     *     
     */
    public void setFstrZug(CFstrZug value) {
        this.fstrZug = value;
    }

}
