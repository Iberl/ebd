//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.gleis._1_8;

import modell.basisobjekte._1_8.CBereichObjekt;
import modell.basistypen._1_8.CBezeichnungElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Einzeln schaltbarer Abschnitt einer Fahrleitungsanlage, der mit Fahrstrom versorgt wird. Das Objekt wird vom Grundsatz dem �bersichtsplan mit Schaltanweisung (Ebs�) des elektrotechnischen Dienstes entnommen. Zur Beschreibung von Fahrleitungsschaltgruppen in der ESTW-Logik zum Zwecke der Merkhinweiseingabe f�r Befahrbarkeitssperren sind die betroffenen Gleisabschnitte zu beachten. Die Grenzen einer Schaltgruppe m�ssen nicht mit den Grenzen der Gleisabschnitte �bereinstimmen. Wenn ein angeschnittener Gleisabschnitt vorhanden ist, wird dieser in der Befahrbarkeitssperre ber�cksichtigt. Die Schaltgruppen k�nnen sich dann auch �berlagern. In der Regel sollten �berlagerungen von Schaltgruppen vermieden werden, indem ein Gleisabschnitt nur einer Schaltgruppe zugeordnet wird. Zwischen Bereichen verschiedener Schaltgruppen k�nnen aus vorgenanntem Grund auch L�cken sein. F�r Schaltgruppen, die verschiedenen Fahrstromsystemen zugeordnet werden k�nnen (Systemwechselstellen), ist f�r jedes Fahrstromsystem je eine Instanz mit gleichem Elementnamen und gleichen Bereichsgrenzen anzulegen. Die Zuordnung der Schaltgruppen zu den Gleisabschnitten erfolgt �ber die topologischen Kanten als ein Bereichsobjekt.
 * 
 * <p>Java-Klasse f�r CGleis_Schaltgruppe complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGleis_Schaltgruppe">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/BasisTypen/1.8.0}CBezeichnung_Element"/>
 *         &lt;element name="Fahrstrom" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}TCFahrstrom"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGleis_Schaltgruppe", propOrder = {
    "bezeichnung",
    "fahrstrom"
})
public class CGleisSchaltgruppe
    extends CBereichObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CBezeichnungElement bezeichnung;
    @XmlElement(name = "Fahrstrom", required = true)
    protected TCFahrstrom fahrstrom;

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
     * Ruft den Wert der fahrstrom-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFahrstrom }
     *     
     */
    public TCFahrstrom getFahrstrom() {
        return fahrstrom;
    }

    /**
     * Legt den Wert der fahrstrom-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFahrstrom }
     *     
     */
    public void setFahrstrom(TCFahrstrom value) {
        this.fahrstrom = value;
    }

}
