//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBUEAnlageOhneProxy;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Stra�enbezogene Angaben zur BUE_Anlage, die im Wesentlichen im Rahmen der bautechnischen Planung ben�tigt werden. Die Themen L�ngsneigung und Ausrundungshalbmesser werden aufgrund der Vielzahl notwendiger Angaben nicht im Modell abgebildet (separate Betrachtung erforderlich).
 * 
 * <p>Java-Klasse f�r CBUE_Anlage_Strasse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Anlage_Strasse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="BUE_Anlage_Fuss_Rad" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CBUE_Anlage_Fuss_Rad" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BUE_Anlage_Strasse_Allg" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CBUE_Anlage_Strasse_Allg"/>
 *         &lt;element name="ID_BUE_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_BUE_Anlage_ohne_Proxy"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Anlage_Strasse", propOrder = {
    "bueAnlageFussRad",
    "bueAnlageStrasseAllg",
    "idbueAnlage"
})
public class CBUEAnlageStrasse
    extends CBasisObjekt
{

    @XmlElement(name = "BUE_Anlage_Fuss_Rad")
    protected List<CBUEAnlageFussRad> bueAnlageFussRad;
    @XmlElement(name = "BUE_Anlage_Strasse_Allg", required = true)
    protected CBUEAnlageStrasseAllg bueAnlageStrasseAllg;
    @XmlElement(name = "ID_BUE_Anlage", required = true)
    protected TCIDBUEAnlageOhneProxy idbueAnlage;

    /**
     * Gets the value of the bueAnlageFussRad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bueAnlageFussRad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBUEAnlageFussRad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBUEAnlageFussRad }
     * 
     * 
     */
    public List<CBUEAnlageFussRad> getBUEAnlageFussRad() {
        if (bueAnlageFussRad == null) {
            bueAnlageFussRad = new ArrayList<CBUEAnlageFussRad>();
        }
        return this.bueAnlageFussRad;
    }

    /**
     * Ruft den Wert der bueAnlageStrasseAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBUEAnlageStrasseAllg }
     *     
     */
    public CBUEAnlageStrasseAllg getBUEAnlageStrasseAllg() {
        return bueAnlageStrasseAllg;
    }

    /**
     * Legt den Wert der bueAnlageStrasseAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBUEAnlageStrasseAllg }
     *     
     */
    public void setBUEAnlageStrasseAllg(CBUEAnlageStrasseAllg value) {
        this.bueAnlageStrasseAllg = value;
    }

    /**
     * Ruft den Wert der idbueAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBUEAnlageOhneProxy }
     *     
     */
    public TCIDBUEAnlageOhneProxy getIDBUEAnlage() {
        return idbueAnlage;
    }

    /**
     * Legt den Wert der idbueAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBUEAnlageOhneProxy }
     *     
     */
    public void setIDBUEAnlage(TCIDBUEAnlageOhneProxy value) {
        this.idbueAnlage = value;
    }

}
