//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.nahbedienbereich._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDMarkanterPunkt;
import plan_pro.modell.verweise._1_9_0.TCIDNBZone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Grenze der NB Zone gegen�ber dem der Zone angrenzenden Bereich. Die NB Zone wird mittels (technischem) Flankenschutz gegen�ber dem benachbarten Bereich (ESTW oder einer weiteren Zone) abgegrenzt. Grenzelemente bilden Signale, Weichen oder Gleissperren, welche in jeweiliger Flankenschutzlage verschlossen werden. Auch die Angabe eines Achz�hlpunkts ist m�glich. Bei an die NB Zone angrenzendem Ortstellbereich ist die TM 2010-388 I.NVT 3 \"Planungsregeln Bedienbereiche - Schnittstellen Stellwerksbereiche\" zu beachten. DB-Regelwerk TM 2010-388 I.NVT 3 Die Angabe von Grenzelementen au�erhalb der NB-Zone finden sich in der Nahbedienungstabelle, Spalte 7.
 * 
 * <p>Java-Klasse f�r CNB_Zone_Grenze complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CNB_Zone_Grenze">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Markanter_Punkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Markanter_Punkt"/>
 *         &lt;element name="ID_NB_Zone" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_NB_Zone"/>
 *         &lt;element name="NB_Grenze_Art" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}TCNB_Grenze_Art"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CNB_Zone_Grenze", propOrder = {
    "idMarkanterPunkt",
    "idnbZone",
    "nbGrenzeArt"
})
public class CNBZoneGrenze
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Markanter_Punkt", required = true)
    protected TCIDMarkanterPunkt idMarkanterPunkt;
    @XmlElement(name = "ID_NB_Zone", required = true)
    protected TCIDNBZone idnbZone;
    @XmlElement(name = "NB_Grenze_Art", required = true)
    protected TCNBGrenzeArt nbGrenzeArt;

    /**
     * Ruft den Wert der idMarkanterPunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDMarkanterPunkt }
     *     
     */
    public TCIDMarkanterPunkt getIDMarkanterPunkt() {
        return idMarkanterPunkt;
    }

    /**
     * Legt den Wert der idMarkanterPunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDMarkanterPunkt }
     *     
     */
    public void setIDMarkanterPunkt(TCIDMarkanterPunkt value) {
        this.idMarkanterPunkt = value;
    }

    /**
     * Ruft den Wert der idnbZone-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDNBZone }
     *     
     */
    public TCIDNBZone getIDNBZone() {
        return idnbZone;
    }

    /**
     * Legt den Wert der idnbZone-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDNBZone }
     *     
     */
    public void setIDNBZone(TCIDNBZone value) {
        this.idnbZone = value;
    }

    /**
     * Ruft den Wert der nbGrenzeArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNBGrenzeArt }
     *     
     */
    public TCNBGrenzeArt getNBGrenzeArt() {
        return nbGrenzeArt;
    }

    /**
     * Legt den Wert der nbGrenzeArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNBGrenzeArt }
     *     
     */
    public void setNBGrenzeArt(TCNBGrenzeArt value) {
        this.nbGrenzeArt = value;
    }

}
