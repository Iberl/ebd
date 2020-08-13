//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.nahbedienbereich._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDNB;
import modell.verweise._1_8.TCIDNBZone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Nahbedienbereichszone. Jeder Nahbedienbereich hat mindestens eine Zone; es sind auch mehrere Zonen m�glich. Die Zonen k�nnen voneinander unabh�ngig nebeneinander liegen, sich �berlappen oder eine Zone kann eine kleinere \"Teilmenge\" einer gr��eren Zone sein. Als spezieller Fall ist auch die Vereinigung von zwei nebeneinander liegenden Zonen m�glich. F�r jede Zone werden eigene Grenzen zum angrenzenden Bereich (ESTW, NB, Ortstellbereich) festgelegt. DB-Regelwerk F�r die Planung von Nahbedienzonen exisitert bei der DB AG kein Regelwerk. Die Angabe findet sich in der Nahbedienungstabelle, Spalte 1.
 * 
 * <p>Java-Klasse f�r CNB_Zone complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CNB_Zone">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_NB" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_NB"/>
 *         &lt;element name="ID_NB_Zone" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_NB_Zone" minOccurs="0"/>
 *         &lt;element name="NB_Zone_Allg" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}CNB_Zone_Allg"/>
 *         &lt;element name="NB_Zone_Reihenfolgezwang" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}CNB_Zone_Reihenfolgezwang"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CNB_Zone", propOrder = {
    "idnb",
    "idnbZone",
    "nbZoneAllg",
    "nbZoneReihenfolgezwang"
})
public class CNBZone
    extends CBasisObjekt
{

    @XmlElement(name = "ID_NB", required = true)
    protected TCIDNB idnb;
    @XmlElement(name = "ID_NB_Zone")
    protected TCIDNBZone idnbZone;
    @XmlElement(name = "NB_Zone_Allg", required = true)
    protected CNBZoneAllg nbZoneAllg;
    @XmlElement(name = "NB_Zone_Reihenfolgezwang", required = true)
    protected CNBZoneReihenfolgezwang nbZoneReihenfolgezwang;

    /**
     * Ruft den Wert der idnb-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDNB }
     *     
     */
    public TCIDNB getIDNB() {
        return idnb;
    }

    /**
     * Legt den Wert der idnb-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDNB }
     *     
     */
    public void setIDNB(TCIDNB value) {
        this.idnb = value;
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
     * Ruft den Wert der nbZoneAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CNBZoneAllg }
     *     
     */
    public CNBZoneAllg getNBZoneAllg() {
        return nbZoneAllg;
    }

    /**
     * Legt den Wert der nbZoneAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CNBZoneAllg }
     *     
     */
    public void setNBZoneAllg(CNBZoneAllg value) {
        this.nbZoneAllg = value;
    }

    /**
     * Ruft den Wert der nbZoneReihenfolgezwang-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CNBZoneReihenfolgezwang }
     *     
     */
    public CNBZoneReihenfolgezwang getNBZoneReihenfolgezwang() {
        return nbZoneReihenfolgezwang;
    }

    /**
     * Legt den Wert der nbZoneReihenfolgezwang-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CNBZoneReihenfolgezwang }
     *     
     */
    public void setNBZoneReihenfolgezwang(CNBZoneReihenfolgezwang value) {
        this.nbZoneReihenfolgezwang = value;
    }

}
