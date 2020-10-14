//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ortung._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDAnforderung;
import plan_pro.modell.verweise._1_9_0.TCIDSchalter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Zuordnungsobjekt f�r die punktuelle Ausl�sung von Schaltvorg�ngen. Beispiel: B�SA, Rangier- und Ablaufanlagen. Schaltmittel sind oftmals separate Zugeinwirkungen (z. B. Radsensoren), es k�nnen aber auch Freimeldeabschnitte (FMA_Anlagen) oder Achsz�hlpunkte (FMA_Komponenten) f�r den Zweck eines Schaltmittels mitverwendet werden (Doppelausnutzung). Ein Schaltmittel wiederum kann f�r unterschiedliche Funktionen vorgesehen sein. Das Zuordnungsobjekt Schaltmittel erfasst jeweils eine konkrete Anforderung (Verweis, der auf das anfordernde Objekt gerichtet ist, z.B. Bahn�bergang EIN, Bahn�bergang AUS, Fahrstra�e verschlie�en und ordnet diese Funktion dann einer konkreten Anlage (Zugeinwirkung, Freimeldeabschnitt oder Achsz�hlpunkt) sowie eine Beschriftung dieser Anlage im sicherungstechnischen Lageplan zu. Die Funktion \"Fahrstra�e verschlie�en (ID_Anforderung = Fstr_Fahrweg)\" ist vorgesehen f�r den Anr�ckverschluss von Zugstra�en. Weitere Anwendungen sind aktuell nicht im Modell verankert. Der Verweis auf die Anforderung ist nicht erforderlich, wenn sich die Zuordnung eindeutig aus der Topologie ergibt (Beispiel: separates Schaltmittel f�r die Funktion \"Zweites Haltfallkriterium\"). In diesem Fall wird nur der Verweis auf die Anlage sowie die Beschriftung im Lageplan angegeben. DB-Regelwerk Typspezifische Planungshinweise und Technische Mitteilungen; Planungsdaten: Sicherungstechnischer Lageplan, B�-Lageplan, Gleisfreimeldeplan. 
 * 
 * <p>Java-Klasse f�r CSchaltmittel_Zuordnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchaltmittel_Zuordnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Anforderung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anforderung" minOccurs="0"/>
 *         &lt;element name="ID_Schalter" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Schalter"/>
 *         &lt;element name="Schaltmittel_Funktion" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCSchaltmittel_Funktion"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSchaltmittel_Zuordnung", propOrder = {
    "idAnforderung",
    "idSchalter",
    "schaltmittelFunktion"
})
public class CSchaltmittelZuordnung
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Anforderung")
    protected TCIDAnforderung idAnforderung;
    @XmlElement(name = "ID_Schalter", required = true)
    protected TCIDSchalter idSchalter;
    @XmlElement(name = "Schaltmittel_Funktion", required = true)
    protected TCSchaltmittelFunktion schaltmittelFunktion;

    /**
     * Ruft den Wert der idAnforderung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnforderung }
     *     
     */
    public TCIDAnforderung getIDAnforderung() {
        return idAnforderung;
    }

    /**
     * Legt den Wert der idAnforderung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnforderung }
     *     
     */
    public void setIDAnforderung(TCIDAnforderung value) {
        this.idAnforderung = value;
    }

    /**
     * Ruft den Wert der idSchalter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSchalter }
     *     
     */
    public TCIDSchalter getIDSchalter() {
        return idSchalter;
    }

    /**
     * Legt den Wert der idSchalter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSchalter }
     *     
     */
    public void setIDSchalter(TCIDSchalter value) {
        this.idSchalter = value;
    }

    /**
     * Ruft den Wert der schaltmittelFunktion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSchaltmittelFunktion }
     *     
     */
    public TCSchaltmittelFunktion getSchaltmittelFunktion() {
        return schaltmittelFunktion;
    }

    /**
     * Legt den Wert der schaltmittelFunktion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSchaltmittelFunktion }
     *     
     */
    public void setSchaltmittelFunktion(TCSchaltmittelFunktion value) {
        this.schaltmittelFunktion = value;
    }

}
