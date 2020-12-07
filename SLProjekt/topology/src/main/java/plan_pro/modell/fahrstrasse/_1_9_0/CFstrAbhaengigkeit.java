//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBedienAnzeigeElement;
import plan_pro.modell.verweise._1_9_0.TCIDFstrFahrweg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Zuordnung aller f�r einen Fstr Fahrweg zu sichernden und nicht durch die Topologie auffindbaren Objekte. Nicht durch die Topologie findbar sind insbesondere: Schluesselsperre, Zustimmungsschalter/-taster. Spezialfall: F�r eine Rangierstra�e kann richtungsabh�ngig geplant werden, dass eine Schl�sselsperre im Zielgleis nicht �berwacht wird. In dem (sehr seltenen) Fall m�ssen f�r eine Zug- und eine Rangierstra�e mit identischem Fahrweg zwei Instanzen Fstr Fahrweg angelegt werden. DB-Regelwerk Schl�sselsperre: Zugstra�entabelle, Spalte 5: \"Ssp in der Fahrstra�e verschlossen und �berwacht\"; Rangierstra�entabelle, Spalte 15: \"Ssp in der Rangierstra�e verschlossen und �berwacht\". Zustimmungsschalter/-taster: Bemerkung/Fu�note. 
 * 
 * <p>Java-Klasse f�r CFstr_Abhaengigkeit complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Abhaengigkeit">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Fstr_Fahrweg" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fstr_Fahrweg"/>
 *         &lt;choice>
 *           &lt;element name="Fstr_Abhaengigkeit_Ssp" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}CFstr_Abhaengigkeit_Ssp"/>
 *           &lt;element name="ID_Bedien_Anzeige_Element" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Bedien_Anzeige_Element"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_Abhaengigkeit", propOrder = {
    "idFstrFahrweg",
    "fstrAbhaengigkeitSsp",
    "idBedienAnzeigeElement"
})
public class CFstrAbhaengigkeit
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Fstr_Fahrweg", required = true)
    protected TCIDFstrFahrweg idFstrFahrweg;
    @XmlElement(name = "Fstr_Abhaengigkeit_Ssp")
    protected CFstrAbhaengigkeitSsp fstrAbhaengigkeitSsp;
    @XmlElement(name = "ID_Bedien_Anzeige_Element")
    protected TCIDBedienAnzeigeElement idBedienAnzeigeElement;

    /**
     * Ruft den Wert der idFstrFahrweg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFstrFahrweg }
     *     
     */
    public TCIDFstrFahrweg getIDFstrFahrweg() {
        return idFstrFahrweg;
    }

    /**
     * Legt den Wert der idFstrFahrweg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFstrFahrweg }
     *     
     */
    public void setIDFstrFahrweg(TCIDFstrFahrweg value) {
        this.idFstrFahrweg = value;
    }

    /**
     * Ruft den Wert der fstrAbhaengigkeitSsp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFstrAbhaengigkeitSsp }
     *     
     */
    public CFstrAbhaengigkeitSsp getFstrAbhaengigkeitSsp() {
        return fstrAbhaengigkeitSsp;
    }

    /**
     * Legt den Wert der fstrAbhaengigkeitSsp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFstrAbhaengigkeitSsp }
     *     
     */
    public void setFstrAbhaengigkeitSsp(CFstrAbhaengigkeitSsp value) {
        this.fstrAbhaengigkeitSsp = value;
    }

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

}
