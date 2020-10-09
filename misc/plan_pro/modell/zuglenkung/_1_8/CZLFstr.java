//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zuglenkung._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDFstrZugRangier;
import modell.verweise._1_8.TCIDZL;
import modell.verweise._1_8.TCIDZLFstr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Objekt zur Aufnahme verschiedener Anstosspunkte (mittels ZL Fstr Anstoss) abh�ngig von den zugeh�rigen Vorsignalen und den Geschwindigkeitsklassen f�r die ZL. �ber den Verweis zur Fstr Zug Rangier ist die Verbindung zur Fstr des ESTW hergestellt. F�r eine Fstr des ESTW kann es mehrere ZL_Fstr geben, umgekehrt gilt dies nicht. DB-Regelwerk 819.0732 6 (1)b In der Tabelle der Zuglenkanst��e entspricht eine Zeile einer ZL-Fahrstra�e. 
 * 
 * <p>Java-Klasse f�r CZL_Fstr complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZL_Fstr">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Fstr_Zug_Rangier" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Fstr_Zug_Rangier" minOccurs="0"/>
 *         &lt;element name="ID_ZL" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_ZL"/>
 *         &lt;element name="ID_ZL_Fstr" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_ZL_Fstr" minOccurs="0"/>
 *         &lt;element name="ZL_Fstr_Allg" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}CZL_Fstr_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZL_Fstr", propOrder = {
    "idFstrZugRangier",
    "idzl",
    "idzlFstr",
    "zlFstrAllg"
})
public class CZLFstr
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Fstr_Zug_Rangier")
    protected TCIDFstrZugRangier idFstrZugRangier;
    @XmlElement(name = "ID_ZL", required = true)
    protected TCIDZL idzl;
    @XmlElement(name = "ID_ZL_Fstr")
    protected TCIDZLFstr idzlFstr;
    @XmlElement(name = "ZL_Fstr_Allg", required = true)
    protected CZLFstrAllg zlFstrAllg;

    /**
     * Ruft den Wert der idFstrZugRangier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFstrZugRangier }
     *     
     */
    public TCIDFstrZugRangier getIDFstrZugRangier() {
        return idFstrZugRangier;
    }

    /**
     * Legt den Wert der idFstrZugRangier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFstrZugRangier }
     *     
     */
    public void setIDFstrZugRangier(TCIDFstrZugRangier value) {
        this.idFstrZugRangier = value;
    }

    /**
     * Ruft den Wert der idzl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZL }
     *     
     */
    public TCIDZL getIDZL() {
        return idzl;
    }

    /**
     * Legt den Wert der idzl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZL }
     *     
     */
    public void setIDZL(TCIDZL value) {
        this.idzl = value;
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
     * Ruft den Wert der zlFstrAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZLFstrAllg }
     *     
     */
    public CZLFstrAllg getZLFstrAllg() {
        return zlFstrAllg;
    }

    /**
     * Legt den Wert der zlFstrAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZLFstrAllg }
     *     
     */
    public void setZLFstrAllg(CZLFstrAllg value) {
        this.zlFstrAllg = value;
    }

}
