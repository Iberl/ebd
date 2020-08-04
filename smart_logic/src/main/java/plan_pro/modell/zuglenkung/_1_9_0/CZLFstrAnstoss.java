//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zuglenkung._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDEinschaltpunkt;
import plan_pro.modell.verweise._1_9_0.TCIDSignal;
import plan_pro.modell.verweise._1_9_0.TCIDZLFstr;
import plan_pro.modell.verweise._1_9_0.TCIDZNAnzeigefeldAnstoss;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Mit ZL_Fstr_Anstoss wird f�r eine Fahrstrasse der Zuglenkung der Anstosspunkt gebildet. Die f�r diese ZL-Fahrstra�e relevante(n) Geschwindigkeitsklasse(n) (GK) wird/werden �ber die entsprechende Attributgruppe zugeordnet. DB-Regelwerk 819.0732 11 In der Tabelle der Zuglenkanst��e findet sich die Angabe in der Spalte \"EP-MO\".
 * 
 * <p>Java-Klasse f�r CZL_Fstr_Anstoss complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZL_Fstr_Anstoss">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Einschaltpunkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Einschaltpunkt" minOccurs="0"/>
 *         &lt;element name="ID_Vorsignal" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal" minOccurs="0"/>
 *         &lt;element name="ID_ZL_Fstr" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZL_Fstr"/>
 *         &lt;element name="ID_ZN_Anzeigefeld_Anstoss" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZN_Anzeigefeld_Anstoss" minOccurs="0"/>
 *         &lt;element name="ZL_Fstr_Anstoss_Allg" type="{http://www.plan-pro.org/modell/Zuglenkung/1.9.0.2}CZL_Fstr_Anstoss_Allg"/>
 *         &lt;element name="ZL_Fstr_Anstoss_GK" type="{http://www.plan-pro.org/modell/Zuglenkung/1.9.0.2}CZL_Fstr_Anstoss_GK" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZL_Fstr_Anstoss", propOrder = {
    "idEinschaltpunkt",
    "idVorsignal",
    "idzlFstr",
    "idznAnzeigefeldAnstoss",
    "zlFstrAnstossAllg",
    "zlFstrAnstossGK"
})
public class CZLFstrAnstoss
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Einschaltpunkt")
    protected TCIDEinschaltpunkt idEinschaltpunkt;
    @XmlElement(name = "ID_Vorsignal")
    protected TCIDSignal idVorsignal;
    @XmlElement(name = "ID_ZL_Fstr", required = true)
    protected TCIDZLFstr idzlFstr;
    @XmlElement(name = "ID_ZN_Anzeigefeld_Anstoss")
    protected TCIDZNAnzeigefeldAnstoss idznAnzeigefeldAnstoss;
    @XmlElement(name = "ZL_Fstr_Anstoss_Allg", required = true)
    protected CZLFstrAnstossAllg zlFstrAnstossAllg;
    @XmlElement(name = "ZL_Fstr_Anstoss_GK")
    protected List<CZLFstrAnstossGK> zlFstrAnstossGK;

    /**
     * Ruft den Wert der idEinschaltpunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDEinschaltpunkt }
     *     
     */
    public TCIDEinschaltpunkt getIDEinschaltpunkt() {
        return idEinschaltpunkt;
    }

    /**
     * Legt den Wert der idEinschaltpunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDEinschaltpunkt }
     *     
     */
    public void setIDEinschaltpunkt(TCIDEinschaltpunkt value) {
        this.idEinschaltpunkt = value;
    }

    /**
     * Ruft den Wert der idVorsignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignal }
     *     
     */
    public TCIDSignal getIDVorsignal() {
        return idVorsignal;
    }

    /**
     * Legt den Wert der idVorsignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignal }
     *     
     */
    public void setIDVorsignal(TCIDSignal value) {
        this.idVorsignal = value;
    }

    /**
     * Ruft den Wert der idzlFstr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZLFstr }
     *     
     */
    public TCIDZLFstr getIDZLFstr() {
        return idzlFstr;
    }

    /**
     * Legt den Wert der idzlFstr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZLFstr }
     *     
     */
    public void setIDZLFstr(TCIDZLFstr value) {
        this.idzlFstr = value;
    }

    /**
     * Ruft den Wert der idznAnzeigefeldAnstoss-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZNAnzeigefeldAnstoss }
     *     
     */
    public TCIDZNAnzeigefeldAnstoss getIDZNAnzeigefeldAnstoss() {
        return idznAnzeigefeldAnstoss;
    }

    /**
     * Legt den Wert der idznAnzeigefeldAnstoss-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZNAnzeigefeldAnstoss }
     *     
     */
    public void setIDZNAnzeigefeldAnstoss(TCIDZNAnzeigefeldAnstoss value) {
        this.idznAnzeigefeldAnstoss = value;
    }

    /**
     * Ruft den Wert der zlFstrAnstossAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZLFstrAnstossAllg }
     *     
     */
    public CZLFstrAnstossAllg getZLFstrAnstossAllg() {
        return zlFstrAnstossAllg;
    }

    /**
     * Legt den Wert der zlFstrAnstossAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZLFstrAnstossAllg }
     *     
     */
    public void setZLFstrAnstossAllg(CZLFstrAnstossAllg value) {
        this.zlFstrAnstossAllg = value;
    }

    /**
     * Gets the value of the zlFstrAnstossGK property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zlFstrAnstossGK property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZLFstrAnstossGK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZLFstrAnstossGK }
     * 
     * 
     */
    public List<CZLFstrAnstossGK> getZLFstrAnstossGK() {
        if (zlFstrAnstossGK == null) {
            zlFstrAnstossGK = new ArrayList<CZLFstrAnstossGK>();
        }
        return this.zlFstrAnstossGK;
    }

}
