//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.nahbedienbereich._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDNBElement;
import plan_pro.modell.verweise._1_9_0.TCIDNBZone;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Zuordnung der ESTW-Elemente (Signale, Weichen, Gleissperren, Schl�sselsperren) zur NB_Zone, in der sie sich befinden. F�r diese Elemente sind in Abh�ngigkeit der vorgesehenen NB Art Eigenschaften zur Stellbarkeit und R�ckgabevoraussetzung festzulegen. DB-Regelwerk Die Angaben finden sich in der Nahbedienungstabelle, Spalten 5, 8 und 9.
 * 
 * <p>Java-Klasse f�r CNB_Zone_Element complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CNB_Zone_Element">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_NB_Element" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_NB_Element"/>
 *         &lt;element name="ID_NB_Zone" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_NB_Zone"/>
 *         &lt;element name="NB_Zone_Element_Allg" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}CNB_Zone_Element_Allg" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CNB_Zone_Element", propOrder = {
    "idnbElement",
    "idnbZone",
    "nbZoneElementAllg"
})
public class CNBZoneElement
    extends CBasisObjekt
{

    @XmlElement(name = "ID_NB_Element", required = true)
    protected TCIDNBElement idnbElement;
    @XmlElement(name = "ID_NB_Zone", required = true)
    protected TCIDNBZone idnbZone;
    @XmlElement(name = "NB_Zone_Element_Allg")
    protected CNBZoneElementAllg nbZoneElementAllg;

    /**
     * Ruft den Wert der idnbElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDNBElement }
     *     
     */
    public TCIDNBElement getIDNBElement() {
        return idnbElement;
    }

    /**
     * Legt den Wert der idnbElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDNBElement }
     *     
     */
    public void setIDNBElement(TCIDNBElement value) {
        this.idnbElement = value;
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
     * Ruft den Wert der nbZoneElementAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CNBZoneElementAllg }
     *     
     */
    public CNBZoneElementAllg getNBZoneElementAllg() {
        return nbZoneElementAllg;
    }

    /**
     * Legt den Wert der nbZoneElementAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CNBZoneElementAllg }
     *     
     */
    public void setNBZoneElementAllg(CNBZoneElementAllg value) {
        this.nbZoneElementAllg = value;
    }

}
