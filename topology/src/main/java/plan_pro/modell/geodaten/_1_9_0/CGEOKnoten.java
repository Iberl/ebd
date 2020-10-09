//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Knoten des topografischen Knoten-Kanten-Modells. Die Anzahl der anschlie�enden topografischen Kanten (Gleislinie oder Kilometrierungslinie) ist je nach Art des GEO Knoten bzw. Art des zugeh�rigen TOP Knoten unterschiedlich: F�r die Gleislinie gilt: Eine GEO-Kante: Der GEO_Knoten ist gleichzeitig auch ein TOP Knoten, an dem die Topografie und Topologie endet (z. B. Gleisende, Betrachtungsende oder Digitalisierungsende). Zwei GEO-Kanten: Der GEO_Knoten verweist nicht auf einen TOP Knoten: �nderung der Geometrie des Gleises oder Vermessungspunkt. Drei GEO-Kanten: Der GEO_Knoten ist gleichzeitig auch ein Knoten, an dem eine Verzweigung der Gleis- oder Kilometrierungslinie vorhanden ist. �ber einen Verweis von GEO Punkt zu GEO_Knoten werden die realen Koordinaten (ggf. auch von mehreren Koordinatensystemen) dieses Knotens zugeordnet. Weitere F�lle mit 0..1 anschlie�enden GEO-Kanten treten an GEO_Knoten auf, an deren Stelle sich auch ein TOP Knoten der Art Verbindungsknoten befindet (siehe Beschreibung Verbindungsknoten). 
 * 
 * <p>Java-Klasse f�r CGEO_Knoten complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGEO_Knoten">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="GEO_PAD" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCGEO_PAD" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGEO_Knoten", propOrder = {
    "geopad"
})
public class CGEOKnoten
    extends CBasisObjekt
{

    @XmlElement(name = "GEO_PAD")
    protected TCGEOPAD geopad;

    /**
     * Ruft den Wert der geopad-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGEOPAD }
     *     
     */
    public TCGEOPAD getGEOPAD() {
        return geopad;
    }

    /**
     * Legt den Wert der geopad-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGEOPAD }
     *     
     */
    public void setGEOPAD(TCGEOPAD value) {
        this.geopad = value;
    }

}
