//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.signale._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.signalbegriffe_struktur._1_6_0.TCSignalbegriffID;
import plan_pro.modell.verweise._1_9_0.TCIDSignalRahmen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Stellt eine Information optisch dar, die das Signal dem Triebfahrzeugf�hrer �bermitteln soll. Signalbegriffe werden im Signalbuch (Ril 301) durch eine Kurzbezeichnung (z. B. \"Zs 1\") und / oder durch eine Langbezeichnung (z. B. \"Ersatzsignal\") beschrieben. Diese und weitere feste Eigenschaften wie der Wertevorrat der anzeigbaren Symbole eines Signalbegriffs sind im Objekt Signalbegriff definiert, das mittels des Attributes Signalbegriff ID eingebunden wird. Anschaltdauer, Beleuchtung und Schaltbarkeit sind nicht fest, sondern w�hlbar an den Signalbegriff nach Signalbuch gekoppelt und so Eigenschaft des Objekts Signal_Signalbegriff. Ein Signal_Signalbegriff befindet sich immer in einem Signal Rahmen. Ausf�hrliche Beschreibung s. Modellierung Signal DB-Regelwerk Ril 301, Planungsdaten: Sicherungstechnischer Lageplan, statische Eigenschaften: Signaltabelle 1, dynamische Eigenschaften: Signaltabelle 2. 
 * 
 * <p>Java-Klasse f�r CSignal_Signalbegriff complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_Signalbegriff">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Signal_Rahmen" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal_Rahmen"/>
 *         &lt;element name="Signal_Signalbegriff_Allg" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}CSignal_Signalbegriff_Allg" minOccurs="0"/>
 *         &lt;element name="Signalbegriff_ID" type="{http://www.plan-pro.org/modell/Signalbegriffe_Struktur/1.6.0.1}TCSignalbegriff_ID"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_Signalbegriff", propOrder = {
    "idSignalRahmen",
    "signalSignalbegriffAllg",
    "signalbegriffID"
})
public class CSignalSignalbegriff
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Signal_Rahmen", required = true)
    protected TCIDSignalRahmen idSignalRahmen;
    @XmlElement(name = "Signal_Signalbegriff_Allg")
    protected CSignalSignalbegriffAllg signalSignalbegriffAllg;
    @XmlElement(name = "Signalbegriff_ID", required = true)
    protected TCSignalbegriffID signalbegriffID;

    /**
     * Ruft den Wert der idSignalRahmen-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignalRahmen }
     *     
     */
    public TCIDSignalRahmen getIDSignalRahmen() {
        return idSignalRahmen;
    }

    /**
     * Legt den Wert der idSignalRahmen-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignalRahmen }
     *     
     */
    public void setIDSignalRahmen(TCIDSignalRahmen value) {
        this.idSignalRahmen = value;
    }

    /**
     * Ruft den Wert der signalSignalbegriffAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSignalSignalbegriffAllg }
     *     
     */
    public CSignalSignalbegriffAllg getSignalSignalbegriffAllg() {
        return signalSignalbegriffAllg;
    }

    /**
     * Legt den Wert der signalSignalbegriffAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSignalSignalbegriffAllg }
     *     
     */
    public void setSignalSignalbegriffAllg(CSignalSignalbegriffAllg value) {
        this.signalSignalbegriffAllg = value;
    }

    /**
     * Ruft den Wert der signalbegriffID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSignalbegriffID }
     *     
     */
    public TCSignalbegriffID getSignalbegriffID() {
        return signalbegriffID;
    }

    /**
     * Legt den Wert der signalbegriffID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSignalbegriffID }
     *     
     */
    public void setSignalbegriffID(TCSignalbegriffID value) {
        this.signalbegriffID = value;
    }

}
