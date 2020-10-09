//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDZN;
import plan_pro.modell.verweise._1_9_0.TCIDZNAnzeigefeld;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Objekt, welches die funktionellen ZN-Fortschaltkriterien beschreibt. Die Attributgruppe ZN_Fortschalt_Krit_Druck wird nur angelegt, wenn aus dem Fortschaltkriterium ein Druck erzeugt wird. DB-Regelwerk 819.0731 6 (16) und (17) 
 * 
 * <p>Java-Klasse f�r CZN_Fortschalt_Kriterium complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_Fortschalt_Kriterium">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_ZN" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZN"/>
 *         &lt;element name="ID_ZN_Fortschalt_Krit_Start" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZN_Anzeigefeld"/>
 *         &lt;element name="ID_ZN_Fortschalt_Krit_Ziel" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZN_Anzeigefeld" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZN_Fortschalt_Krit_Druck" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}CZN_Fortschalt_Krit_Druck" minOccurs="0"/>
 *         &lt;element name="ZN_Fortschalt_Krit_Schalt" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}CZN_Fortschalt_Krit_Schalt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZN_Fortschalt_Kriterium", propOrder = {
    "idzn",
    "idznFortschaltKritStart",
    "idznFortschaltKritZiel",
    "znFortschaltKritDruck",
    "znFortschaltKritSchalt"
})
public class CZNFortschaltKriterium
    extends CBasisObjekt
{

    @XmlElement(name = "ID_ZN", required = true)
    protected TCIDZN idzn;
    @XmlElement(name = "ID_ZN_Fortschalt_Krit_Start", required = true)
    protected TCIDZNAnzeigefeld idznFortschaltKritStart;
    @XmlElement(name = "ID_ZN_Fortschalt_Krit_Ziel")
    protected List<TCIDZNAnzeigefeld> idznFortschaltKritZiel;
    @XmlElement(name = "ZN_Fortschalt_Krit_Druck")
    protected CZNFortschaltKritDruck znFortschaltKritDruck;
    @XmlElement(name = "ZN_Fortschalt_Krit_Schalt")
    protected List<CZNFortschaltKritSchalt> znFortschaltKritSchalt;

    /**
     * Ruft den Wert der idzn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZN }
     *     
     */
    public TCIDZN getIDZN() {
        return idzn;
    }

    /**
     * Legt den Wert der idzn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZN }
     *     
     */
    public void setIDZN(TCIDZN value) {
        this.idzn = value;
    }

    /**
     * Ruft den Wert der idznFortschaltKritStart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZNAnzeigefeld }
     *     
     */
    public TCIDZNAnzeigefeld getIDZNFortschaltKritStart() {
        return idznFortschaltKritStart;
    }

    /**
     * Legt den Wert der idznFortschaltKritStart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZNAnzeigefeld }
     *     
     */
    public void setIDZNFortschaltKritStart(TCIDZNAnzeigefeld value) {
        this.idznFortschaltKritStart = value;
    }

    /**
     * Gets the value of the idznFortschaltKritZiel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idznFortschaltKritZiel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDZNFortschaltKritZiel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDZNAnzeigefeld }
     * 
     * 
     */
    public List<TCIDZNAnzeigefeld> getIDZNFortschaltKritZiel() {
        if (idznFortschaltKritZiel == null) {
            idznFortschaltKritZiel = new ArrayList<TCIDZNAnzeigefeld>();
        }
        return this.idznFortschaltKritZiel;
    }

    /**
     * Ruft den Wert der znFortschaltKritDruck-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZNFortschaltKritDruck }
     *     
     */
    public CZNFortschaltKritDruck getZNFortschaltKritDruck() {
        return znFortschaltKritDruck;
    }

    /**
     * Legt den Wert der znFortschaltKritDruck-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZNFortschaltKritDruck }
     *     
     */
    public void setZNFortschaltKritDruck(CZNFortschaltKritDruck value) {
        this.znFortschaltKritDruck = value;
    }

    /**
     * Gets the value of the znFortschaltKritSchalt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the znFortschaltKritSchalt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZNFortschaltKritSchalt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZNFortschaltKritSchalt }
     * 
     * 
     */
    public List<CZNFortschaltKritSchalt> getZNFortschaltKritSchalt() {
        if (znFortschaltKritSchalt == null) {
            znFortschaltKritSchalt = new ArrayList<CZNFortschaltKritSchalt>();
        }
        return this.znFortschaltKritSchalt;
    }

}
