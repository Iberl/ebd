//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zugnummernmeldeanlage._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDZN;
import modell.verweise._1_8.TCIDZNAnzeigefeld;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_ZN" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_ZN"/>
 *         &lt;element name="ID_ZN_Fortschalt_Krit_Start" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_ZN_Anzeigefeld"/>
 *         &lt;element name="ID_ZN_Fortschalt_Krit_Ziel" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_ZN_Anzeigefeld"/>
 *         &lt;element name="ZN_Fortschalt_Krit_Druck" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZN_Fortschalt_Krit_Druck" minOccurs="0"/>
 *         &lt;element name="ZN_Fortschalt_Krit_Schalt" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZN_Fortschalt_Krit_Schalt"/>
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
    @XmlElement(name = "ID_ZN_Fortschalt_Krit_Ziel", required = true)
    protected TCIDZNAnzeigefeld idznFortschaltKritZiel;
    @XmlElement(name = "ZN_Fortschalt_Krit_Druck")
    protected CZNFortschaltKritDruck znFortschaltKritDruck;
    @XmlElement(name = "ZN_Fortschalt_Krit_Schalt", required = true)
    protected CZNFortschaltKritSchalt znFortschaltKritSchalt;

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
     * Ruft den Wert der idznFortschaltKritZiel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZNAnzeigefeld }
     *     
     */
    public TCIDZNAnzeigefeld getIDZNFortschaltKritZiel() {
        return idznFortschaltKritZiel;
    }

    /**
     * Legt den Wert der idznFortschaltKritZiel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZNAnzeigefeld }
     *     
     */
    public void setIDZNFortschaltKritZiel(TCIDZNAnzeigefeld value) {
        this.idznFortschaltKritZiel = value;
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
     * Ruft den Wert der znFortschaltKritSchalt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZNFortschaltKritSchalt }
     *     
     */
    public CZNFortschaltKritSchalt getZNFortschaltKritSchalt() {
        return znFortschaltKritSchalt;
    }

    /**
     * Legt den Wert der znFortschaltKritSchalt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZNFortschaltKritSchalt }
     *     
     */
    public void setZNFortschaltKritSchalt(CZNFortschaltKritSchalt value) {
        this.znFortschaltKritSchalt = value;
    }

}
