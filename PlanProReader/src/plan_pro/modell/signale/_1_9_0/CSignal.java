//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.signale._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CPunktObjekt;
import plan_pro.modell.basistypen._1_9_0.CBezeichnungElement;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Technische, punktf�rmig verortete Einrichtung der Eisenbahninfrastruktur, die als Teil der Au�enanlage einer Au�enelement-Ansteuerung mit statischen oder dynamischen Signalbildern Anweisungen zur Fahrweise oder andere Verhaltensvorschriften an den Triebfahrzeugf�hrer �bermittelt oder als Teil der Innenanlage einer Au�enelement-Ansteuerung mittels eines Bedienpunkts zur Behandlung von Fahrwegen als Start- oder Zielsignal dient. Steht ein Signal an einer Grenze zweier Bereiche, so ist es dem Bereich zuzuordnen, dem der vom Signal gedeckte Gleisabschnitt angeh�rt. Das Objekt Signal beinhaltet zentrale Eigenschaften, die bei Signalen der Au�enanlage in Signal-Befestigungen bzgl. der Konstruktion und in Signal-Rahmen bzgl. der zugeordneten Signalbegriffe erg�nzt werden. Je nach Ausf�hrung eines Signals der Au�enanlage k�nnen daf�r mehrere Signal-Befestigungen erforderlich sein (z.B. \u0027Fundament\u0027 und \u0027Signalanordnung\u0027), daf�r mehrere Signal-Rahmen erforderlich sein (z.B. \u0027Schirm\u0027, 2x\u0027Zusatzanzeiger\u0027 und \u0027Bezeichnungsschild\u0027) und / oder zeitgleich mehrere Signalbegriffe angezeigt werden, die zu diesem Zeitpunkt f�r ein Gleis - meist nur in einer Fahrtrichtung - an einem Punkt g�ltig sind und deren logische �berlagerung zur Handlungsanweisung f�r den Triebfahrzeugf�hrer wird. Signalbilder, die zwar einem gemeinsamen Punkt zugeordnet sind, aber keiner gemeinsamen logischen Interpretation bed�rfen, werden unterschiedlichen Signalen zugeordnet. Kann ein Signal mehrere Signalbilder anzeigen, so werden diese in Gruppen (analog zur Konstruktion) zusammengefasst, jede dieser Gruppen bildet einen Signal-Rahmen. Zur ausf�hrliche Beschreibung der Modellierung eines Signals s. Modellierung Signal. Besonderheiten zur Verortung von Signalen sind unter Punkt Objekt beschrieben. DB-Regelwerk 301, 819.02, Planungsdaten: Sicherungstechnischer Lageplan, statische Eigenschaften: Signaltabelle 1, dynamische Eigenschaften: Signaltabelle 2, vereinzelt sind einzelne Angaben auch anderen Fundorten zugeordnet, dies ist den jeweiligen Einzelbeitr�gen zu entnehmen. 
 * 
 * <p>Java-Klasse f�r CSignal complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}CBezeichnung_Element" minOccurs="0"/>
 *         &lt;element name="PZB_Schutzstrecke_Soll" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}TCPZB_Schutzstrecke_Soll" minOccurs="0"/>
 *         &lt;element name="Signal_Fstr" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}CSignal_Fstr" minOccurs="0"/>
 *         &lt;element name="Signal_Fstr_Aus_Inselgleis" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}CSignal_Fstr_Aus_Inselgleis" minOccurs="0"/>
 *         &lt;element name="Signal_Fstr_S" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}CSignal_Fstr_S" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Signal_Fiktiv" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}CSignal_Fiktiv"/>
 *           &lt;element name="Signal_Real" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}CSignal_Real"/>
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
@XmlType(name = "CSignal", propOrder = {
    "bezeichnung",
    "pzbSchutzstreckeSoll",
    "signalFstr",
    "signalFstrAusInselgleis",
    "signalFstrS",
    "signalFiktiv",
    "signalReal"
})
public class CSignal
    extends CPunktObjekt
{

    @XmlElement(name = "Bezeichnung")
    protected CBezeichnungElement bezeichnung;
    @XmlElement(name = "PZB_Schutzstrecke_Soll")
    protected TCPZBSchutzstreckeSoll pzbSchutzstreckeSoll;
    @XmlElement(name = "Signal_Fstr")
    protected CSignalFstr signalFstr;
    @XmlElement(name = "Signal_Fstr_Aus_Inselgleis")
    protected CSignalFstrAusInselgleis signalFstrAusInselgleis;
    @XmlElement(name = "Signal_Fstr_S")
    protected CSignalFstrS signalFstrS;
    @XmlElement(name = "Signal_Fiktiv")
    protected CSignalFiktiv signalFiktiv;
    @XmlElement(name = "Signal_Real")
    protected CSignalReal signalReal;

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
     * Ruft den Wert der pzbSchutzstreckeSoll-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPZBSchutzstreckeSoll }
     *     
     */
    public TCPZBSchutzstreckeSoll getPZBSchutzstreckeSoll() {
        return pzbSchutzstreckeSoll;
    }

    /**
     * Legt den Wert der pzbSchutzstreckeSoll-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPZBSchutzstreckeSoll }
     *     
     */
    public void setPZBSchutzstreckeSoll(TCPZBSchutzstreckeSoll value) {
        this.pzbSchutzstreckeSoll = value;
    }

    /**
     * Ruft den Wert der signalFstr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSignalFstr }
     *     
     */
    public CSignalFstr getSignalFstr() {
        return signalFstr;
    }

    /**
     * Legt den Wert der signalFstr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSignalFstr }
     *     
     */
    public void setSignalFstr(CSignalFstr value) {
        this.signalFstr = value;
    }

    /**
     * Ruft den Wert der signalFstrAusInselgleis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSignalFstrAusInselgleis }
     *     
     */
    public CSignalFstrAusInselgleis getSignalFstrAusInselgleis() {
        return signalFstrAusInselgleis;
    }

    /**
     * Legt den Wert der signalFstrAusInselgleis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSignalFstrAusInselgleis }
     *     
     */
    public void setSignalFstrAusInselgleis(CSignalFstrAusInselgleis value) {
        this.signalFstrAusInselgleis = value;
    }

    /**
     * Ruft den Wert der signalFstrS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSignalFstrS }
     *     
     */
    public CSignalFstrS getSignalFstrS() {
        return signalFstrS;
    }

    /**
     * Legt den Wert der signalFstrS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSignalFstrS }
     *     
     */
    public void setSignalFstrS(CSignalFstrS value) {
        this.signalFstrS = value;
    }

    /**
     * Ruft den Wert der signalFiktiv-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSignalFiktiv }
     *     
     */
    public CSignalFiktiv getSignalFiktiv() {
        return signalFiktiv;
    }

    /**
     * Legt den Wert der signalFiktiv-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSignalFiktiv }
     *     
     */
    public void setSignalFiktiv(CSignalFiktiv value) {
        this.signalFiktiv = value;
    }

    /**
     * Ruft den Wert der signalReal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSignalReal }
     *     
     */
    public CSignalReal getSignalReal() {
        return signalReal;
    }

    /**
     * Legt den Wert der signalReal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSignalReal }
     *     
     */
    public void setSignalReal(CSignalReal value) {
        this.signalReal = value;
    }

}
