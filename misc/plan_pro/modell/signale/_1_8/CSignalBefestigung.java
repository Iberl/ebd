//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.signale._1_8;

import modell.basisobjekte._1_8.CPunktObjekt;
import modell.verweise._1_8.TCIDRegelzeichnung;
import modell.verweise._1_8.TCIDSignalBefestigung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Konstruktionselement, das der baulichen Aufnahme eines oder mehrerer Signalrahmen dient. Die konkreten konstruktiven Merkmale sind in einer (oder im Bedarfsfall mehreren) Regelzeichnung(en) enthalten, auf die jeweils ein GUID-Verweis zeigt. Bei Sonderkonstruktionen wird die Regelzeichnung durch die zugeh�rigen Zulassungsdokumente ersetzt. Diese sind als Anhang mittels eines Bearbeitungsvermerks beizuf�gen. Signalbefestigungen k�nnen auch weitere Signalbefestigungen aufnehmen (z.B. tr�gt ein Signalausleger eine Arbeitsb�hne). Einer Signalbefestigung ist mindestens ein Objekt Signal Rahmen oder Signal Befestigung zugeordnet. Ausf�hrliche Beschreibung s. Modellierung Signal. DB-Regelwerk Regelzeichnungen 
 * 
 * <p>Java-Klasse f�r CSignal_Befestigung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_Befestigung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Regelzeichnung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Regelzeichnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_Signal_Befestigung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Signal_Befestigung" minOccurs="0"/>
 *         &lt;element name="Signal_Befestigung_Allg" type="{http://www.plan-pro.org/modell/Signale/1.8.0}CSignal_Befestigung_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_Befestigung", propOrder = {
    "idRegelzeichnung",
    "idSignalBefestigung",
    "signalBefestigungAllg"
})
public class CSignalBefestigung
    extends CPunktObjekt
{

    @XmlElement(name = "ID_Regelzeichnung")
    protected List<TCIDRegelzeichnung> idRegelzeichnung;
    @XmlElement(name = "ID_Signal_Befestigung")
    protected TCIDSignalBefestigung idSignalBefestigung;
    @XmlElement(name = "Signal_Befestigung_Allg", required = true)
    protected CSignalBefestigungAllg signalBefestigungAllg;

    /**
     * Gets the value of the idRegelzeichnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idRegelzeichnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDRegelzeichnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDRegelzeichnung }
     * 
     * 
     */
    public List<TCIDRegelzeichnung> getIDRegelzeichnung() {
        if (idRegelzeichnung == null) {
            idRegelzeichnung = new ArrayList<TCIDRegelzeichnung>();
        }
        return this.idRegelzeichnung;
    }

    /**
     * Ruft den Wert der idSignalBefestigung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignalBefestigung }
     *     
     */
    public TCIDSignalBefestigung getIDSignalBefestigung() {
        return idSignalBefestigung;
    }

    /**
     * Legt den Wert der idSignalBefestigung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignalBefestigung }
     *     
     */
    public void setIDSignalBefestigung(TCIDSignalBefestigung value) {
        this.idSignalBefestigung = value;
    }

    /**
     * Ruft den Wert der signalBefestigungAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSignalBefestigungAllg }
     *     
     */
    public CSignalBefestigungAllg getSignalBefestigungAllg() {
        return signalBefestigungAllg;
    }

    /**
     * Legt den Wert der signalBefestigungAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSignalBefestigungAllg }
     *     
     */
    public void setSignalBefestigungAllg(CSignalBefestigungAllg value) {
        this.signalBefestigungAllg = value;
    }

}
