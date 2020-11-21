//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDGEOKnoten;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Knoten des topologischen Knoten-Kanten-Modells. Der TOP_Knoten verweist auf einen GEO_Knoten. Die Anzahl der an den TOP_Knoten anschlie�enden topologischen Kanten ist je nach Art des TOP_Knoten unterschiedlich und muss mit der Anzahl der an den zugeh�rigen GEO Knoten anschlie�enden GEO_Kanten �bereinstimmen: eine TOP-Kante: Gleisende, Digitalisierungsende, Betrachtungsende; drei TOP-Kanten: verzweigendes Fahrwegelement (siehe Modellierung Weichen). Weitere F�lle mit 0..2 anschlie�enden TOP-Kanten treten am Verbindungsknoten auf (siehe entsprechende Beschreibung). (E) Das die Attributgruppe Art Besonders zum Entfall vorgesehen ist, wird nach der Version 1.8.0 auch die Attributgruppe TOP_Knoten_Allg aufgel�st. 
 * 
 * <p>Java-Klasse f�r CTOP_Knoten complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CTOP_Knoten">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_GEO_Knoten" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_GEO_Knoten"/>
 *         &lt;element name="Knotenname" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCKnotenname" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTOP_Knoten", propOrder = {
    "idgeoKnoten",
    "knotenname"
})
public class CTOPKnoten
    extends CBasisObjekt
{

    @XmlElement(name = "ID_GEO_Knoten", required = true)
    protected TCIDGEOKnoten idgeoKnoten;
    @XmlElement(name = "Knotenname")
    protected TCKnotenname knotenname;

    /**
     * Ruft den Wert der idgeoKnoten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGEOKnoten }
     *     
     */
    public TCIDGEOKnoten getIDGEOKnoten() {
        return idgeoKnoten;
    }

    /**
     * Legt den Wert der idgeoKnoten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGEOKnoten }
     *     
     */
    public void setIDGEOKnoten(TCIDGEOKnoten value) {
        this.idgeoKnoten = value;
    }

    /**
     * Ruft den Wert der knotenname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKnotenname }
     *     
     */
    public TCKnotenname getKnotenname() {
        return knotenname;
    }

    /**
     * Legt den Wert der knotenname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKnotenname }
     *     
     */
    public void setKnotenname(TCKnotenname value) {
        this.knotenname = value;
    }

}
