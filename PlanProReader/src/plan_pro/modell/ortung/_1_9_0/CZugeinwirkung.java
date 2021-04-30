//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ortung._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CPunktObjekt;
import plan_pro.modell.basistypen._1_9_0.CBezeichnungElement;
import plan_pro.modell.verweise._1_9_0.TCIDMarkanterPunkt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Technische Anlage, die durch die punktuelle Einwirkung eines Zuges einen Schaltvorgang ausl�sen kann. Bei B�SA werden Ein- und Ausschaltpunkte sowie Kontakte f�r die Wirksamkeitsschaltung in Abh�ngigkeit vom Hersteller auf verschiedene Art ausgebildet: Die Hersteller Scheidt\u0026amp;Bachmann sowie PintschBamag verwenden als Zugeinwirkung Fahrzeugsensoren in Form von 8-f�rmig verlegten Schleifen im Gleis. Einschaltpunkte und Kontakte f�r die Wirksamkeitsschaltung werden im Regelfall aus zwei Schleifen, Ausschaltpunkte aus einer Schleife gebildet. Nur im Ausnahmefall werden beim Hersteller PintschBamag Einschaltpunkte mit drei Schleifen errichtet. Der Hersteller Siemens AG verwendet dagegen Achsz�hlern vergleichbare sogenannte Doppelsensoren. F�r das Modell werden, unabh�ngig von der herstellerspezifischen Ausbildung, Ein-und Ausschaltpunkte sowie Kontakte der Wirksamkeitsschaltung grunds�tzlich als EINE Zugeinwirkung betrachtet. DB-Regelwerk Typspezifische Planungshinweise und Technische Mitteilungen; Planungsdaten: Sicherungstechnischer Lageplan, B�-Lageplan, Gleisfreimeldeplan. 
 * 
 * <p>Java-Klasse f�r CZugeinwirkung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZugeinwirkung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}CBezeichnung_Element"/>
 *         &lt;element name="ID_Bezugspunkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Markanter_Punkt"/>
 *         &lt;element name="Zugeinwirkung_Allg" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}CZugeinwirkung_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZugeinwirkung", propOrder = {
    "bezeichnung",
    "idBezugspunkt",
    "zugeinwirkungAllg"
})
public class CZugeinwirkung
    extends CPunktObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CBezeichnungElement bezeichnung;
    @XmlElement(name = "ID_Bezugspunkt", required = true)
    protected TCIDMarkanterPunkt idBezugspunkt;
    @XmlElement(name = "Zugeinwirkung_Allg", required = true)
    protected CZugeinwirkungAllg zugeinwirkungAllg;

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
     * Ruft den Wert der zugeinwirkungAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZugeinwirkungAllg }
     *     
     */
    public CZugeinwirkungAllg getZugeinwirkungAllg() {
        return zugeinwirkungAllg;
    }

    /**
     * Legt den Wert der zugeinwirkungAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZugeinwirkungAllg }
     *     
     */
    public void setZugeinwirkungAllg(CZugeinwirkungAllg value) {
        this.zugeinwirkungAllg = value;
    }

}
