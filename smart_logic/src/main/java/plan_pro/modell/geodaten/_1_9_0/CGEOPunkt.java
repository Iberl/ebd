//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDGEOKnoten;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Topographischer Punkt im Koordinatensystem zur eindeutige Zuordnung im realen Gel�nde. Alle Objekte, die einen entsprechenden Bezug erfordern, werden �ber andere Objekte (z.B Verortung an der Topologie) oder auch direkt auf dieses Objekt abgebildet.
 * 
 * <p>Java-Klasse f�r CGEO_Punkt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGEO_Punkt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="GEO_Punkt_Allg" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}CGEO_Punkt_Allg"/>
 *         &lt;element name="ID_GEO_Knoten" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_GEO_Knoten" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGEO_Punkt", propOrder = {
    "geoPunktAllg",
    "idgeoKnoten"
})
public class CGEOPunkt
    extends CBasisObjekt
{

    @XmlElement(name = "GEO_Punkt_Allg", required = true)
    protected CGEOPunktAllg geoPunktAllg;
    @XmlElement(name = "ID_GEO_Knoten")
    protected TCIDGEOKnoten idgeoKnoten;

    /**
     * Ruft den Wert der geoPunktAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CGEOPunktAllg }
     *     
     */
    public CGEOPunktAllg getGEOPunktAllg() {
        return geoPunktAllg;
    }

    /**
     * Legt den Wert der geoPunktAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CGEOPunktAllg }
     *     
     */
    public void setGEOPunktAllg(CGEOPunktAllg value) {
        this.geoPunktAllg = value;
    }

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

}
