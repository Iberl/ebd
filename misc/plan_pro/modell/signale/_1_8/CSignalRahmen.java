//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.signale._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDSignal;
import modell.verweise._1_8.TCIDSignalBefestigung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Fiktive Signale haben keinen Signalrahmen, da sie keinen Signalbegriff zeigen k�nnen. Ein oder mehrere Signalrahmen bilden ein Signal. Die Gruppierung von Signalbegriffen innerhalb eines Signals zu Signalrahmen wird anhand der konstruktiven Gestaltung vorgenommen, z.B. werden alle Signalbegriffe des Hauptsignalschirms oder alle Signalbegriffe eines Zusatzanzeigers jeweils zu einem Signalrahmen zusammengefasst. Kann die Anzahl oder Art der Signalbegriffe eines Signalrahmens in Abh�ngigkeit vom betrieblichen Zustand ge�ndert werden, so wird dieser als schaltbar bezeichnet, andernfalls als fest. Im LST-Datenmodell ist diese Eigenschaft als Attribut zu den Signalbegriffen definiert; ein Signalrahmen ist danach genau dann schaltbar, wenn mindestens eines der enthaltenen Signalbegriffe schaltbar ist. Typische schaltbare Signalrahmen sind der Signalschirm eines Mehrabschnittssignals, das Lichtsignal eines Zusatzanzeigers und das Form- oder Lichtsignal eines Weichensignals. Typische feste Signalrahmen sind das Mastschild eines Hauptsignals, das Formsignal eines Zusatzanzeigers und die Haltetafel. �ber den Signalrahmen erfolgt, sofern dies geplant ist, die Zuordnung von Signalbegriffen eines nachgeordneten Signals zu einem anderen Signal ohne Bezug zur Fahrstra�e, siehe dazu ID Signal Nachordnung Ausf�hrliche Beschreibung s. Modellierung Signal. DB-Regelwerk Planungsdaten: im bisherigen PT1 ohne eindeutige Darstellung. In der Regel aus den Angaben in der Signaltabelle 1 zu erkennen. 
 * 
 * <p>Java-Klasse f�r CSignal_Rahmen complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_Rahmen">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Signal" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Signal"/>
 *         &lt;element name="ID_Signal_Befestigung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Signal_Befestigung"/>
 *         &lt;element name="ID_Signal_Nachordnung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Signal" minOccurs="0"/>
 *         &lt;element name="Rahmen_Art" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCRahmen_Art"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_Rahmen", propOrder = {
    "idSignal",
    "idSignalBefestigung",
    "idSignalNachordnung",
    "rahmenArt"
})
public class CSignalRahmen
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Signal", required = true)
    protected TCIDSignal idSignal;
    @XmlElement(name = "ID_Signal_Befestigung", required = true)
    protected TCIDSignalBefestigung idSignalBefestigung;
    @XmlElement(name = "ID_Signal_Nachordnung")
    protected TCIDSignal idSignalNachordnung;
    @XmlElement(name = "Rahmen_Art", required = true)
    protected TCRahmenArt rahmenArt;

    /**
     * Ruft den Wert der idSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignal }
     *     
     */
    public TCIDSignal getIDSignal() {
        return idSignal;
    }

    /**
     * Legt den Wert der idSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignal }
     *     
     */
    public void setIDSignal(TCIDSignal value) {
        this.idSignal = value;
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
     * Ruft den Wert der idSignalNachordnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignal }
     *     
     */
    public TCIDSignal getIDSignalNachordnung() {
        return idSignalNachordnung;
    }

    /**
     * Legt den Wert der idSignalNachordnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignal }
     *     
     */
    public void setIDSignalNachordnung(TCIDSignal value) {
        this.idSignalNachordnung = value;
    }

    /**
     * Ruft den Wert der rahmenArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRahmenArt }
     *     
     */
    public TCRahmenArt getRahmenArt() {
        return rahmenArt;
    }

    /**
     * Legt den Wert der rahmenArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRahmenArt }
     *     
     */
    public void setRahmenArt(TCRahmenArt value) {
        this.rahmenArt = value;
    }

}
