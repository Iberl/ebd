//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.nahbedienbereich._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBedienAnzeigeElement;
import plan_pro.modell.verweise._1_9_0.TCIDNBZone;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Zuordnung von Bedienfunktionen zur Bedieneinrichtung einer oder mehrerer NB_Zonen, �ber die Fahrdienstleiter und �rtlichen Bediener miteinander kommunizieren. Falls sich bedienbare Elemente innerhalb der NB_Zone befinden, sind diese durch eine entsprechende Bedieneinrichtung (um)stellbar, sofern eine (Um-)Stellbarkeit vorgesehen wurde. Der Umfang h�ngt von der gew�hlten NB Art ab. Weiterhin sind in der Bedieneinrichtung Elemente f�r die Kommunikation zwischen Fahrdienstleiter und Bediener untergebracht. In diesem Objekt wird die Logik der Bedieneinrichtung abgebildet. Falls eine Bedieneinrichtung Elemente aus mindestens zwei verschiedenen NB_Zonen enth�lt, ist eine Zuordnung der Bedieneinrichtung zu den betreffenden NB_Zonen erforderlich. Der Verweis auf Bedien Anzeige Element f�hrt zur Zuordnung der physischen Unterbringung. DB-Regelwerk F�r die Planung exisitert bei der DB AG kein Regelwerk. Die Angaben finden sich meist im Erl�uterungsbericht zum PT1.
 * 
 * <p>Java-Klasse f�r CNB_Bedien_Anzeige_Element complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CNB_Bedien_Anzeige_Element">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Bedien_Anzeige_Element" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Bedien_Anzeige_Element"/>
 *         &lt;element name="ID_NB_Zone" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_NB_Zone"/>
 *         &lt;element name="NB_Bedien_Anzeige_Funktionen" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}CNB_Bedien_Anzeige_Funktionen"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CNB_Bedien_Anzeige_Element", propOrder = {
    "idBedienAnzeigeElement",
    "idnbZone",
    "nbBedienAnzeigeFunktionen"
})
public class CNBBedienAnzeigeElement
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Bedien_Anzeige_Element", required = true)
    protected TCIDBedienAnzeigeElement idBedienAnzeigeElement;
    @XmlElement(name = "ID_NB_Zone", required = true)
    protected TCIDNBZone idnbZone;
    @XmlElement(name = "NB_Bedien_Anzeige_Funktionen", required = true)
    protected CNBBedienAnzeigeFunktionen nbBedienAnzeigeFunktionen;

    /**
     * Ruft den Wert der idBedienAnzeigeElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBedienAnzeigeElement }
     *     
     */
    public TCIDBedienAnzeigeElement getIDBedienAnzeigeElement() {
        return idBedienAnzeigeElement;
    }

    /**
     * Legt den Wert der idBedienAnzeigeElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBedienAnzeigeElement }
     *     
     */
    public void setIDBedienAnzeigeElement(TCIDBedienAnzeigeElement value) {
        this.idBedienAnzeigeElement = value;
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
     * Ruft den Wert der nbBedienAnzeigeFunktionen-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CNBBedienAnzeigeFunktionen }
     *     
     */
    public CNBBedienAnzeigeFunktionen getNBBedienAnzeigeFunktionen() {
        return nbBedienAnzeigeFunktionen;
    }

    /**
     * Legt den Wert der nbBedienAnzeigeFunktionen-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CNBBedienAnzeigeFunktionen }
     *     
     */
    public void setNBBedienAnzeigeFunktionen(CNBBedienAnzeigeFunktionen value) {
        this.nbBedienAnzeigeFunktionen = value;
    }

}
