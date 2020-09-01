//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.ortung._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDAussenelementansteuerung;
import modell.verweise._1_8.TCIDGleisAbschnitt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Technische Anlage, die einen Gleisabschnitt auf Freisein von Schienenfahrzeugen �berwacht; entspricht im gew�hnlichen Sprachgebrauch dem Freimeldeabschnitt. Eine FMA_Anlage wird alleinstehend zur Fahrwegfreipr�fung bzw. zur Freipr�fung des Flankenschutzraumes genutzt sowie in Auswertung der Reihenfolge von Belegung und Wieder-Frei-Werden zur Erfassung einer Fahrt und damit zur Aufl�sung von Teilfahrstra�en. Auch andere Schaltvorg�nge k�nnen durch eine FMA_Anlage ausgel�st werden. Die FMA_Anlage hat mindestens eine Au�enanlage (z. B. Drosselspule, Achsz�hlpunkt) und beansprucht Anteile an einer Gleisfreimelde-Innenanlage (z. B. Motorrelaisgruppe, Achsz�hlrechner). DB-Regelwerk Typspezifische Planungshinweise und Technische Mitteilungen; Planungsdaten: Sicherungstechnischer Lageplan, B�-Lageplan; Gleisfreimeldepl�ne (Achsz�hl�bersichtsplan, Gleisisolierplan); Freimeldetabelle. 
 * 
 * <p>Java-Klasse f�r CFMA_Anlage complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFMA_Anlage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}CFMA_Anlage_Bezeichnung"/>
 *         &lt;element name="FMA_Anlage_Allg" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}CFMA_Anlage_Allg"/>
 *         &lt;element name="FMA_Anlage_Elektr_Merkmale" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}CFMA_Anlage_Elektr_Merkmale" minOccurs="0"/>
 *         &lt;element name="FMA_Anlage_Kaskade" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}CFMA_Anlage_Kaskade" minOccurs="0"/>
 *         &lt;element name="FMA_Anlage_Uebertragung_FMinfo" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}CFMA_Anlage_Uebertragung_FMinfo" minOccurs="0"/>
 *         &lt;element name="ID_Gleis_Abschnitt" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Gleis_Abschnitt"/>
 *         &lt;element name="ID_Gleisfreimelde_Innenanlage" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Aussenelementansteuerung"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFMA_Anlage", propOrder = {
    "bezeichnung",
    "fmaAnlageAllg",
    "fmaAnlageElektrMerkmale",
    "fmaAnlageKaskade",
    "fmaAnlageUebertragungFMinfo",
    "idGleisAbschnitt",
    "idGleisfreimeldeInnenanlage"
})
public class CFMAAnlage
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CFMAAnlageBezeichnung bezeichnung;
    @XmlElement(name = "FMA_Anlage_Allg", required = true)
    protected CFMAAnlageAllg fmaAnlageAllg;
    @XmlElement(name = "FMA_Anlage_Elektr_Merkmale")
    protected CFMAAnlageElektrMerkmale fmaAnlageElektrMerkmale;
    @XmlElement(name = "FMA_Anlage_Kaskade")
    protected CFMAAnlageKaskade fmaAnlageKaskade;
    @XmlElement(name = "FMA_Anlage_Uebertragung_FMinfo")
    protected CFMAAnlageUebertragungFMinfo fmaAnlageUebertragungFMinfo;
    @XmlElement(name = "ID_Gleis_Abschnitt", required = true)
    protected TCIDGleisAbschnitt idGleisAbschnitt;
    @XmlElement(name = "ID_Gleisfreimelde_Innenanlage", required = true)
    protected TCIDAussenelementansteuerung idGleisfreimeldeInnenanlage;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFMAAnlageBezeichnung }
     *     
     */
    public CFMAAnlageBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFMAAnlageBezeichnung }
     *     
     */
    public void setBezeichnung(CFMAAnlageBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der fmaAnlageAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFMAAnlageAllg }
     *     
     */
    public CFMAAnlageAllg getFMAAnlageAllg() {
        return fmaAnlageAllg;
    }

    /**
     * Legt den Wert der fmaAnlageAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFMAAnlageAllg }
     *     
     */
    public void setFMAAnlageAllg(CFMAAnlageAllg value) {
        this.fmaAnlageAllg = value;
    }

    /**
     * Ruft den Wert der fmaAnlageElektrMerkmale-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFMAAnlageElektrMerkmale }
     *     
     */
    public CFMAAnlageElektrMerkmale getFMAAnlageElektrMerkmale() {
        return fmaAnlageElektrMerkmale;
    }

    /**
     * Legt den Wert der fmaAnlageElektrMerkmale-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFMAAnlageElektrMerkmale }
     *     
     */
    public void setFMAAnlageElektrMerkmale(CFMAAnlageElektrMerkmale value) {
        this.fmaAnlageElektrMerkmale = value;
    }

    /**
     * Ruft den Wert der fmaAnlageKaskade-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFMAAnlageKaskade }
     *     
     */
    public CFMAAnlageKaskade getFMAAnlageKaskade() {
        return fmaAnlageKaskade;
    }

    /**
     * Legt den Wert der fmaAnlageKaskade-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFMAAnlageKaskade }
     *     
     */
    public void setFMAAnlageKaskade(CFMAAnlageKaskade value) {
        this.fmaAnlageKaskade = value;
    }

    /**
     * Ruft den Wert der fmaAnlageUebertragungFMinfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFMAAnlageUebertragungFMinfo }
     *     
     */
    public CFMAAnlageUebertragungFMinfo getFMAAnlageUebertragungFMinfo() {
        return fmaAnlageUebertragungFMinfo;
    }

    /**
     * Legt den Wert der fmaAnlageUebertragungFMinfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFMAAnlageUebertragungFMinfo }
     *     
     */
    public void setFMAAnlageUebertragungFMinfo(CFMAAnlageUebertragungFMinfo value) {
        this.fmaAnlageUebertragungFMinfo = value;
    }

    /**
     * Ruft den Wert der idGleisAbschnitt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGleisAbschnitt }
     *     
     */
    public TCIDGleisAbschnitt getIDGleisAbschnitt() {
        return idGleisAbschnitt;
    }

    /**
     * Legt den Wert der idGleisAbschnitt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGleisAbschnitt }
     *     
     */
    public void setIDGleisAbschnitt(TCIDGleisAbschnitt value) {
        this.idGleisAbschnitt = value;
    }

    /**
     * Ruft den Wert der idGleisfreimeldeInnenanlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public TCIDAussenelementansteuerung getIDGleisfreimeldeInnenanlage() {
        return idGleisfreimeldeInnenanlage;
    }

    /**
     * Legt den Wert der idGleisfreimeldeInnenanlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public void setIDGleisfreimeldeInnenanlage(TCIDAussenelementansteuerung value) {
        this.idGleisfreimeldeInnenanlage = value;
    }

}
