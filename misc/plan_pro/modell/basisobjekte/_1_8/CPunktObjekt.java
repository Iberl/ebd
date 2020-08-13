//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.basisobjekte._1_8;

import modell.bahnsteig._1_8.CBahnsteigZugang;
import modell.bahnuebergang._1_8.CBUEAnlage;
import modell.fahrstrasse._1_8.CSonstigerPunkt;
import modell.geodaten._1_8.CHoehenpunkt;
import modell.geodaten._1_8.CTechnischerPunkt;
import modell.geodaten._1_8.CUeberhoehung;
import modell.gleis._1_8.CGleisAbschluss;
import modell.nahbedienbereich._1_8.CNBZoneGrenze;
import modell.ortung._1_8.CFMAElement;
import modell.ortung._1_8.CFMAKomponente;
import modell.ortung._1_8.CZugeinwirkung;
import modell.pzb._1_8.CPZBElement;
import modell.signale._1_8.CSignal;
import modell.signale._1_8.CSignalBefestigung;
import modell.weichen_und_gleissperren._1_8.CWKrGspKomponente;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Objekt der Au�enanlage, das bezogen auf seine Funktion keine Ausdehnung entlang der Gleise aufweist. Punktf�rmige Objekte sind diejenigen real vorhandenen Objekte, die mindestens einer TOP Kante mit je genau einem Punkt zugeordnet werden k�nnen. Durch die Verwendung der TOP Kante und des Abstands zum Knoten A der TOP Kante kann die physische Lage eines punktf�rmigen Objektes eindeutig beschrieben werden. Beispiele f�r punktf�rmige Objekte sind Signal, Signal Befestigung und W Kr Gsp Komponente. Durch die m�gliche Mehrfacheinbindung der Attributgruppe Punkt Objekt TOP Kante ist es m�glich, Punktobjekte mehreren TOP-Kanten zuzuordnen, z.B: Grenzzeichen (Zuordnung zu zwei TOP_Kanten), Signal zwischen Weichenanfang und Herzst�ckspitze (Zuordnung zu zwei TOP_Kanten), Kreuzung als Kreuzungseite - Weichenkomponente (Zuordnung zu zwei sich schneidende oder am gleichen TOP-Knoten endende TOP-Kanten), Weichensignal (Zuordnung zu zwei (W), drei (EKW) oder vier (DKW) TOP_Kanten). Die Verortung des Punktobjekts erfolgt �ber die Angabe einer TOP Kante und des Abstands zum Knoten A der Kante. Zus�tzlich kann f�r ein Punkt_Objekt eine Strecke und ein Streckenkilometer angegeben werden. Diese km-Angabe ist dabei nur nachrichtlich zu verstehen. 
 * 
 * <p>Java-Klasse f�r CPunkt_Objekt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPunkt_Objekt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Punkt_Objekt_Strecke" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CPunkt_Objekt_Strecke" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Punkt_Objekt_TOP_Kante" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CPunkt_Objekt_TOP_Kante" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPunkt_Objekt", propOrder = {
    "punktObjektStrecke",
    "punktObjektTOPKante"
})
@XmlSeeAlso({
    CBahnsteigZugang.class,
    CBUEAnlage.class,
    CSonstigerPunkt.class,
    CHoehenpunkt.class,
    CTechnischerPunkt.class,
    CUeberhoehung.class,
    CGleisAbschluss.class,
    CNBZoneGrenze.class,
    CZugeinwirkung.class,
    CFMAKomponente.class,
    CFMAElement.class,
    CWKrGspKomponente.class,
    CSignal.class,
    CSignalBefestigung.class,
    CPZBElement.class
})
public abstract class CPunktObjekt
    extends CBasisObjekt
{

    @XmlElement(name = "Punkt_Objekt_Strecke")
    protected List<CPunktObjektStrecke> punktObjektStrecke;
    @XmlElement(name = "Punkt_Objekt_TOP_Kante", required = true)
    protected List<CPunktObjektTOPKante> punktObjektTOPKante;

    /**
     * Gets the value of the punktObjektStrecke property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the punktObjektStrecke property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPunktObjektStrecke().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CPunktObjektStrecke }
     * 
     * 
     */
    public List<CPunktObjektStrecke> getPunktObjektStrecke() {
        if (punktObjektStrecke == null) {
            punktObjektStrecke = new ArrayList<CPunktObjektStrecke>();
        }
        return this.punktObjektStrecke;
    }

    /**
     * Gets the value of the punktObjektTOPKante property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the punktObjektTOPKante property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPunktObjektTOPKante().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CPunktObjektTOPKante }
     * 
     * 
     */
    public List<CPunktObjektTOPKante> getPunktObjektTOPKante() {
        if (punktObjektTOPKante == null) {
            punktObjektTOPKante = new ArrayList<CPunktObjektTOPKante>();
        }
        return this.punktObjektTOPKante;
    }

}
