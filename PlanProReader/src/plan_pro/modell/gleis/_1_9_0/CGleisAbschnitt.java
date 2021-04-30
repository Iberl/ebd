//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.gleis._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBereichObjekt;
import plan_pro.modell.basistypen._1_9_0.CBezeichnungElement;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Abschnitt eines Gleises, welcher als kleinste Einheit betrieblich und technisch verwendet wird. Der Gleisabschnitt wird im Allgemeinen durch zwei Enden begrenzt. Wenn in diesem Gleisabschnitt Weichen, Kreuzungen oder Kreuzungsweichen enthalten sind, entstehen weitere Enden. Diese werden in der Regel nur dann definiert, wenn technische Anlagen zur Gleisfreimeldung vorhanden sind. Der Begriff Weichenabschnitt wird wegen Mehrdeutigkeit im Modell nicht verwendet. Ein Gleisabschnitt kann mittels technischer Anlagen (abgebildet im Objekt FMA Anlage) auf Freisein �berwacht werden. Der Gleisabschnitt als Bereich_Objekt muss an seinen Grenzen genau mit dem Punkt_Objekt FMA Element �bereinstimmen. Rundungsfehler bei der Berechnung sind zu beachten! 
 * 
 * <p>Java-Klasse f�r CGleis_Abschnitt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGleis_Abschnitt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}CBezeichnung_Element"/>
 *         &lt;element name="Geschwindigkeit" type="{http://www.plan-pro.org/modell/Gleis/1.9.0.2}TCGeschwindigkeit" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGleis_Abschnitt", propOrder = {
    "bezeichnung",
    "geschwindigkeit"
})
public class CGleisAbschnitt
    extends CBereichObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CBezeichnungElement bezeichnung;
    @XmlElement(name = "Geschwindigkeit")
    protected TCGeschwindigkeit geschwindigkeit;

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
     * Ruft den Wert der geschwindigkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGeschwindigkeit }
     *     
     */
    public TCGeschwindigkeit getGeschwindigkeit() {
        return geschwindigkeit;
    }

    /**
     * Legt den Wert der geschwindigkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGeschwindigkeit }
     *     
     */
    public void setGeschwindigkeit(TCGeschwindigkeit value) {
        this.geschwindigkeit = value;
    }

}
