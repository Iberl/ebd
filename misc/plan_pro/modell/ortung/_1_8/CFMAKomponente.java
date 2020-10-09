//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.ortung._1_8;

import modell.basisobjekte._1_8.CPunktObjekt;
import modell.basistypen._1_8.CBezeichnungElement;
import modell.verweise._1_8.TCIDMarkanterPunkt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Freimeldeabschnittsgrenze (Isoliersto�, elektrischer Sto�, Achsz�hlpunkt). Die FMA_Komponente wird dem Punkt im Gleis zugeordnet, bis zu dem die Erkennung einer Belegung gem�� Anwendungsrichtlinien als gesichert gilt. Die zu den zugeh�rigen Gleisabschnitten geh�renden Bereichsobjekte Gleis Abschnitt m�ssen deshalb exakt an diesem Punktobjekt enden. Zur Ermittlung der seitlichen Lage einer FMA_Komponente siehe Modellierung Gleisfreimeldung. Eine FMA_Komponente kann nur an einer Seite mindestens einen Freimeldeabschnitt oder beidseitig jeweils mindestens einen Freimeldeabschnitt begrenzen. Bei �berlappenden Freimeldeabschnittsgrenzen (z.B. am �bergang von FTGS- zu Achsz�hl- Gleisfreimeldeanlagen) ist jede Freimeldeabschnittsgrenze f�r sich als FMA_Komponente zu erfassen. Direkt auf H�he, rechts und/oder links der Freimeldeabschnittsgrenze k�nnen sich technische Anlagen f�r die Gleisfreimeldung befinden, siehe dazu FMA Element. Das Befahren einer FMA_Komponente kann auch weitere Schaltvorg�nge ausl�sen, siehe dazu Schaltmittel Zuordnung. DB-Regelwerk Typspezifische Planungshinweise und Technische Mitteilungen; Planungsdaten: Sicherungstechnischer Lageplan, B�-Lageplan; Achsz�hl�bersichtsplan; Freimeldetabelle; Achsz�hltabelle. 
 * 
 * <p>Java-Klasse f�r CFMA_Komponente complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFMA_Komponente">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/BasisTypen/1.8.0}CBezeichnung_Element" minOccurs="0"/>
 *         &lt;element name="ID_Bezugspunkt" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Markanter_Punkt" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="FMA_Komponente_Achszaehlpunkt" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}CFMA_Komponente_Achszaehlpunkt"/>
 *           &lt;element name="FMA_Komponente_Art" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}TCFMA_Komponente_Art"/>
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
@XmlType(name = "CFMA_Komponente", propOrder = {
    "bezeichnung",
    "idBezugspunkt",
    "fmaKomponenteAchszaehlpunkt",
    "fmaKomponenteArt"
})
public class CFMAKomponente
    extends CPunktObjekt
{

    @XmlElement(name = "Bezeichnung")
    protected CBezeichnungElement bezeichnung;
    @XmlElement(name = "ID_Bezugspunkt")
    protected TCIDMarkanterPunkt idBezugspunkt;
    @XmlElement(name = "FMA_Komponente_Achszaehlpunkt")
    protected CFMAKomponenteAchszaehlpunkt fmaKomponenteAchszaehlpunkt;
    @XmlElement(name = "FMA_Komponente_Art")
    protected TCFMAKomponenteArt fmaKomponenteArt;

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
     * Ruft den Wert der idBezugspunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDMarkanterPunkt }
     *     
     */
    public TCIDMarkanterPunkt getIDBezugspunkt() {
        return idBezugspunkt;
    }

    /**
     * Legt den Wert der idBezugspunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDMarkanterPunkt }
     *     
     */
    public void setIDBezugspunkt(TCIDMarkanterPunkt value) {
        this.idBezugspunkt = value;
    }

    /**
     * Ruft den Wert der fmaKomponenteAchszaehlpunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFMAKomponenteAchszaehlpunkt }
     *     
     */
    public CFMAKomponenteAchszaehlpunkt getFMAKomponenteAchszaehlpunkt() {
        return fmaKomponenteAchszaehlpunkt;
    }

    /**
     * Legt den Wert der fmaKomponenteAchszaehlpunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFMAKomponenteAchszaehlpunkt }
     *     
     */
    public void setFMAKomponenteAchszaehlpunkt(CFMAKomponenteAchszaehlpunkt value) {
        this.fmaKomponenteAchszaehlpunkt = value;
    }

    /**
     * Ruft den Wert der fmaKomponenteArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMAKomponenteArt }
     *     
     */
    public TCFMAKomponenteArt getFMAKomponenteArt() {
        return fmaKomponenteArt;
    }

    /**
     * Legt den Wert der fmaKomponenteArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMAKomponenteArt }
     *     
     */
    public void setFMAKomponenteArt(TCFMAKomponenteArt value) {
        this.fmaKomponenteArt = value;
    }

}
