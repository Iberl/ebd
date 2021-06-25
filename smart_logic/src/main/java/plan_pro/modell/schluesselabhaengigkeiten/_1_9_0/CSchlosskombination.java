//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.schluesselabhaengigkeiten._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDUnterbringung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Mechanische Einrichtung zur Freigabe mehrerer (abh�ngiger) Schl�ssel durch einen (Haupt-) Schl�ssel. Der Hauptschl�ssel wird so lange festgehalten, wie mindestens ein Riegel der abh�ngigen Schl�sser ausgefahren ist. In der Regel besteht die Grundstellung darin, dass der Hauptschl�ssel entfernt und die abh�ngigen Schl�ssel eingeschlossen sind. DB-Regelwerk Darstellung durch Zeichnung im Lageplan. Eine aktuelle Ril dazu existiert nicht, es werden alte Zeichnungsstandards verwendet.
 * 
 * <p>Java-Klasse f�r CSchlosskombination complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchlosskombination">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}CSchlosskombination_Bezeichnung"/>
 *         &lt;element name="ID_Unterbringung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Unterbringung"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSchlosskombination", propOrder = {
    "bezeichnung",
    "idUnterbringung"
})
public class CSchlosskombination
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CSchlosskombinationBezeichnung bezeichnung;
    @XmlElement(name = "ID_Unterbringung", required = true)
    protected TCIDUnterbringung idUnterbringung;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSchlosskombinationBezeichnung }
     *     
     */
    public CSchlosskombinationBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSchlosskombinationBezeichnung }
     *     
     */
    public void setBezeichnung(CSchlosskombinationBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idUnterbringung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDUnterbringung }
     *     
     */
    public TCIDUnterbringung getIDUnterbringung() {
        return idUnterbringung;
    }

    /**
     * Legt den Wert der idUnterbringung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDUnterbringung }
     *     
     */
    public void setIDUnterbringung(TCIDUnterbringung value) {
        this.idUnterbringung = value;
    }

}
