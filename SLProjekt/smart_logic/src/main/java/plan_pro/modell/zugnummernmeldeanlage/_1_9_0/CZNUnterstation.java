//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDGEOPunkt;
import plan_pro.modell.verweise._1_9_0.TCIDStreckePunkt;
import plan_pro.modell.verweise._1_9_0.TCIDZNZBS;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Verbindung zwischen ZN und ZLV Bus und/oder ZN ZBS. �ber Modems wird die ZN an einen oder mehrere ZLV-Busse und ggf. an eine ZBS (Verbindung zu einer Bedien Zentrale) angebunden. Die Attributgruppe ZN_Unterstation_Bf_Nr kann mehrfach eingebunden werden. Damit werden alle Betriebsstellen, die ZN-seitig �ber diese Unterstation verwaltet bzw \"angesprochen\" werden, beschrieben. Der ZN-seitigen Bahnhofsnummer wird eine �rtlichkeit (Ril-100-Bezeichner der zugewiesenen Betriebsstelle) und ggf. eine Priorit�t zugeordnet. Letztere wird nur f�r diejenige Bahnhosnummer angegeben, die f�r die Kommunikation der ZN_Unterstation mit dem ZLV-Bus ma�gebend ist. In allen anderen F�llen wird das Attribut nicht bef�llt. Die Darstellung erfolgt auf dem ZLV-Bus-�bersichtsplan als tabellarischer Block mit den Zeilen \u0026lt;Bf-Nr\u0026gt; \u0026lt;Oertlichkeit_Abkuerzung\u0026gt; in dem Symbol f�r die ZN_Unterstation. Die Bahnhofsnummer mit Priorit�t wird direkt neben dem ZLV-Bus-Anschluss angeordnet. DB-Regelwerk 819.0731 5 Die Darstellung der Angaben erfolgt im ZLV-Bus-�bersichtsplan nach 819.0731 A01 
 * 
 * <p>Java-Klasse f�r CZN_Unterstation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_Unterstation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_GEO_Punkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_GEO_Punkt" minOccurs="0"/>
 *         &lt;element name="ID_Strecke_Punkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Strecke_Punkt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_ZN_ZBS" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZN_ZBS" minOccurs="0"/>
 *         &lt;element name="ZN_Unterstation_Allg" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}CZN_Unterstation_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZN_Unterstation", propOrder = {
    "idgeoPunkt",
    "idStreckePunkt",
    "idznzbs",
    "znUnterstationAllg"
})
public class CZNUnterstation
    extends CBasisObjekt
{

    @XmlElement(name = "ID_GEO_Punkt")
    protected TCIDGEOPunkt idgeoPunkt;
    @XmlElement(name = "ID_Strecke_Punkt")
    protected List<TCIDStreckePunkt> idStreckePunkt;
    @XmlElement(name = "ID_ZN_ZBS")
    protected TCIDZNZBS idznzbs;
    @XmlElement(name = "ZN_Unterstation_Allg", required = true)
    protected CZNUnterstationAllg znUnterstationAllg;

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
     * Gets the value of the idStreckePunkt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idStreckePunkt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDStreckePunkt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDStreckePunkt }
     * 
     * 
     */
    public List<TCIDStreckePunkt> getIDStreckePunkt() {
        if (idStreckePunkt == null) {
            idStreckePunkt = new ArrayList<TCIDStreckePunkt>();
        }
        return this.idStreckePunkt;
    }

    /**
     * Ruft den Wert der idznzbs-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZNZBS }
     *     
     */
    public TCIDZNZBS getIDZNZBS() {
        return idznzbs;
    }

    /**
     * Legt den Wert der idznzbs-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZNZBS }
     *     
     */
    public void setIDZNZBS(TCIDZNZBS value) {
        this.idznzbs = value;
    }

    /**
     * Ruft den Wert der znUnterstationAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZNUnterstationAllg }
     *     
     */
    public CZNUnterstationAllg getZNUnterstationAllg() {
        return znUnterstationAllg;
    }

    /**
     * Legt den Wert der znUnterstationAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZNUnterstationAllg }
     *     
     */
    public void setZNUnterstationAllg(CZNUnterstationAllg value) {
        this.znUnterstationAllg = value;
    }

}
