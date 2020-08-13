//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.nahbedienbereich._1_8;

import modell.basisobjekte._1_8.CPunktObjekt;
import modell.verweise._1_8.TCIDGrenzelement;
import modell.verweise._1_8.TCIDNBZone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Grenze der NB Zone gegen�ber dem der Zone angrenzenden Bereich. Die NB Zone wird mittels (technischem) Flankenschutz gegen�ber dem benachbarten Bereich (ESTW oder einer weiteren Zone) abgegrenzt. Grenzelemente bilden Signale, Weichen oder Gleissperren, welche in jeweiliger Flankenschutzlage verschlossen werden. Bei an die NB Zone angrenzendem Ortstellbereich ist die TM 2010-388 I.NVT 3 \"Planungsregeln Bedienbereiche - Schnittstellen Stellwerksbereiche\" zu beachten. DB-Regelwerk TM 2010-388 I.NVT 3 Die Angabe von Grenzelementen au�erhalb der NB-Zone finden sich in der Nahbedienungstabelle, Spalte 7.
 * 
 * <p>Java-Klasse f�r CNB_Zone_Grenze complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CNB_Zone_Grenze">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Grenzelement" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Grenzelement"/>
 *         &lt;element name="ID_NB_Zone" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_NB_Zone"/>
 *         &lt;element name="NB_Grenze_Art" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}TCNB_Grenze_Art"/>
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
    "idGrenzelement",
    "idnbZone",
    "nbGrenzeArt"
})
public class CNBZoneGrenze
    extends CPunktObjekt
{

    @XmlElement(name = "ID_Grenzelement", required = true)
    protected TCIDGrenzelement idGrenzelement;
    @XmlElement(name = "ID_NB_Zone", required = true)
    protected TCIDNBZone idnbZone;
    @XmlElement(name = "NB_Grenze_Art", required = true)
    protected TCNBGrenzeArt nbGrenzeArt;

    /**
     * Ruft den Wert der idGrenzelement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGrenzelement }
     *     
     */
    public TCIDGrenzelement getIDGrenzelement() {
        return idGrenzelement;
    }

    /**
     * Legt den Wert der idGrenzelement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGrenzelement }
     *     
     */
    public void setIDGrenzelement(TCIDGrenzelement value) {
        this.idGrenzelement = value;
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
