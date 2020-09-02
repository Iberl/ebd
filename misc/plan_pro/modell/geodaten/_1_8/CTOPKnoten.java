//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.geodaten._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDGEOKnoten;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_GEO_Knoten" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_GEO_Knoten"/>
 *         &lt;element name="TOP_Knoten_Allg" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CTOP_Knoten_Allg" minOccurs="0"/>
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
    "topKnotenAllg"
})
public class CTOPKnoten
    extends CBasisObjekt
{

    @XmlElement(name = "ID_GEO_Knoten", required = true)
    protected TCIDGEOKnoten idgeoKnoten;
    @XmlElement(name = "TOP_Knoten_Allg")
    protected CTOPKnotenAllg topKnotenAllg;

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
     * Ruft den Wert der topKnotenAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CTOPKnotenAllg }
     *     
     */
    public CTOPKnotenAllg getTOPKnotenAllg() {
        return topKnotenAllg;
    }

    /**
     * Legt den Wert der topKnotenAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CTOPKnotenAllg }
     *     
     */
    public void setTOPKnotenAllg(CTOPKnotenAllg value) {
        this.topKnotenAllg = value;
    }

}
