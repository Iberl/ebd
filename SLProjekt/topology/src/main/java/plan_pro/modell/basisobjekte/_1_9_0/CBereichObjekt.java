//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basisobjekte._1_9_0;

import plan_pro.modell.ansteuerung_element._1_9_0.CStellBereich;
import plan_pro.modell.bahnsteig._1_9_0.CBahnsteigDach;
import plan_pro.modell.bahnsteig._1_9_0.CBahnsteigKante;
import plan_pro.modell.bahnuebergang._1_9_0.CBUEGleisbezogenerGefahrraum;
import plan_pro.modell.balisentechnik_etcs._1_9_0.CZUBStreckeneigenschaft;
import plan_pro.modell.fahrstrasse._1_9_0.CFstrFahrweg;
import plan_pro.modell.geodaten._1_9_0.CGeschwindigkeitsprofil;
import plan_pro.modell.geodaten._1_9_0.CStrecke;
import plan_pro.modell.geodaten._1_9_0.CTechnischerBereich;
import plan_pro.modell.gleis._1_9_0.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Objekt, das einen Bereich �ber eine oder mehrere Gleiskanten ganz oder teilweise umfasst. Ein Bereich Objekt repr�sentiert einen Bereich der Topologie, der sowohl zusammenh�ngend als auch nicht zusammenh�ngend sein kann. Ein Bereich Objekt wird �ber ein oder mehrere Teilbereiche (Bereich_Objekt_Teilbereich) beschrieben, die jeweils einen Abschnitt auf einer topologischen Kante darstellen. Ein Teilbereich definiert sich �ber die Referenz auf eine TOP Kante sowie den Abstand der beiden Teilbereichsgrenzen A und B zum Anfang der TOP Kante. Das Bereich Objekt kann in drei Arten eingeteilt werden: unverzweigt (z. B. Bahnsteig Kante, Fstr Fahrweg, BUE Gleisbezogener Gefahrraum) verzweigt (z. B. Gleis Schaltgruppe) verteilt (z. B. Gleis Baubereich) Unverzweigte und verzweigte Bereichsobjekte sind immer zusammenh�ngend. Verteilte Bereichsobjekte k�nnen in ihren Teilen verzweigt oder unverzweigt sein; hier gibt es keine Notwendigkeit der Unterscheidung. Zus�tzlich kann ein Bereich Objekt gerichtet sein. Dies wird durch die Ausrichtung der Teilbereiche in Bezug auf die jeweilige TOP Kante erreicht. Die Konsistenz der Richtung des Bereich Objekt wird nicht durch das Modell sichergestellt. Die Teilbereiche m�ssen �berschneidungsfrei definiert sein. Es ist m�glich Teilbereiche der L�nge 0 anzugeben. Ist es f�r ein Objekt notwendig, direkt auf eine Bereichsgrenze zu verweisen, dann muss dieses Problem im jeweiligen Arbeitspaket gel�st werden, in dem in diesem Arbeitspaket ein eigenes Punktobjekt erzeugt wird. Der Teilbereich endet dann unmittelbar vor dem TOP_Knoten. Speziell bei Weichenanf�ngen auf die Weichenspitze gesehen endet der Teilbereich am TOP Anschluss A = Spitze oder TOP Anschluss B = Spitze. Die Weiche selbst ist nicht Bestandteil des Bereichsobjektes. In den Bereichsobjekten sind Objekte zusammengefasst, die eine Quer- und/oder L�ngsausdehnung haben k�nnen.
 * 
 * <p>Java-Klasse f�r CBereich_Objekt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBereich_Objekt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bereich_Objekt_Teilbereich" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBereich_Objekt_Teilbereich" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBereich_Objekt", propOrder = {
    "bereichObjektTeilbereich"
})
@XmlSeeAlso({
    CStellBereich.class,
    CBahnsteigKante.class,
    CBahnsteigDach.class,
    CBUEGleisbezogenerGefahrraum.class,
    CZUBStreckeneigenschaft.class,
    CFstrFahrweg.class,
    CGeschwindigkeitsprofil.class,
    CStrecke.class,
    CTechnischerBereich.class,
    CGleisBaubereich.class,
    CGleisSchaltgruppe.class,
    CGleisFahrbahn.class,
    CGleisBezeichnung.class,
    CGleisLichtraum.class,
    CGleisAbschnitt.class,
    CGleisArt.class
})
public abstract class CBereichObjekt
    extends CBasisObjekt
{

    @XmlElement(name = "Bereich_Objekt_Teilbereich", required = true)
    protected List<CBereichObjektTeilbereich> bereichObjektTeilbereich;

    /**
     * Gets the value of the bereichObjektTeilbereich property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bereichObjektTeilbereich property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBereichObjektTeilbereich().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBereichObjektTeilbereich }
     * 
     * 
     */
    public List<CBereichObjektTeilbereich> getBereichObjektTeilbereich() {
        if (bereichObjektTeilbereich == null) {
            bereichObjektTeilbereich = new ArrayList<CBereichObjektTeilbereich>();
        }
        return this.bereichObjektTeilbereich;
    }

}
