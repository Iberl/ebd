//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.nahbedienbereich._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.basistypen._1_9_0.CBezeichnungElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Nahbedienbereich. Teilbereich innerhalb eines ESTW-Stellbereichs, f�r den zeitweise die Zust�ndigkeit vom Fahrdienstleiter an einen �rtlichen Bediener zur Durchf�hrung von Rangierbewegungen abgegeben werden kann. Die Kommunikation zwischen Fahrdienstleiter und Bediener erfolgt �ber entsprechende Bedieneinrichtung(en). Mit Abgabe der Nahbedienung hat der Fahrdienstleiter auf diesen Bereich keinen Zugriff; die Verantwortung liegt beim �rtlichen Bediener. Mit R�ckgabe der Nahbedienung geht die Verantwortung vom Bediener wieder an den Fahrdienstleiter. F�r die R�ckgabe der Nahbedienung k�nnen bestimmte Voraussetzungen erforderlich sein. F�r die Abgabe bzw. R�ckgabe der Nahbedienung werden in der Literatur auch die Begriffe \"Einschalten\" und \"Ausschalten\" verwendet. Der Nahbedienbereich muss vom �brigen Stellwerksbereich durch Flankenschutzma�nahmen abgegrenzt werden. Jeder Nahbedienbereich hat immer mindestens eine NB Zone. Bei einem Nahbedienbereich mit der Funktionalit�t eines abgesetzten \"Rangierstellwerkes\" (NB-R) k�nnen Weichen mit elektrischem Antrieb umgestellt und innerhalb des NB Fahrten mit Rangierstra�en durchgef�hrt werden. DB-Regelwerk F�r die Planung von Nahbedienbereichen exisitert bei der DB AG kein Regelwerk.
 * 
 * <p>Java-Klasse f�r CNB complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CNB">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}CBezeichnung_Element"/>
 *         &lt;element name="NB_Allg" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}CNB_Allg"/>
 *         &lt;element name="NB_Funktionalitaet_NB_R" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}CNB_Funktionalitaet_NB_R" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CNB", propOrder = {
    "bezeichnung",
    "nbAllg",
    "nbFunktionalitaetNBR"
})
public class CNB
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CBezeichnungElement bezeichnung;
    @XmlElement(name = "NB_Allg", required = true)
    protected CNBAllg nbAllg;
    @XmlElement(name = "NB_Funktionalitaet_NB_R")
    protected CNBFunktionalitaetNBR nbFunktionalitaetNBR;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBezeichnungElement }
     *     
     */
    public CBezeichnungElement getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBezeichnungElement }
     *     
     */
    public void setBezeichnung(CBezeichnungElement value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der nbAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CNBAllg }
     *     
     */
    public CNBAllg getNBAllg() {
        return nbAllg;
    }

    /**
     * Legt den Wert der nbAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CNBAllg }
     *     
     */
    public void setNBAllg(CNBAllg value) {
        this.nbAllg = value;
    }

    /**
     * Ruft den Wert der nbFunktionalitaetNBR-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CNBFunktionalitaetNBR }
     *     
     */
    public CNBFunktionalitaetNBR getNBFunktionalitaetNBR() {
        return nbFunktionalitaetNBR;
    }

    /**
     * Legt den Wert der nbFunktionalitaetNBR-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CNBFunktionalitaetNBR }
     *     
     */
    public void setNBFunktionalitaetNBR(CNBFunktionalitaetNBR value) {
        this.nbFunktionalitaetNBR = value;
    }

}
