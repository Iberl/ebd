//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDGEOKnoten;
import plan_pro.modell.verweise._1_9_0.TCIDStrecke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Topologischer Punkt auf der zugeh�rigen Streckenlinie mit dem Wert der Streckenkilometrierung in Meterschreibweise. Der Streckenpunkt kann auf einen GEO Knoten verweisen, der �ber einen (oder mehrere) GEO_Punkte geografisch referenziert wird. Ohne diesen Verweis wird der Streckenpunkt nur auf eine Strecke mit Streckenkilometer referenziert. Die GEO Knoten sind �ber GEO_Kanten untereinander verbunden und beschreiben in ihrer Gesamtheit eine Streckenlinie. Jede Strecke hat mindestens zwei Streckenpunkte als Anfang und Ende der Strecke. Der GEO Knoten am Anfang bzw. am Ende einer Streckenlinie hat nur eine GEO Kante, ansonsten sind es zwei. An einem Kilometersprung werden zwei Streckenpunkte (ggf. mit identischen GEO-Koordinaten) gebildet. Die L�nge der verbindende GEO_Kante (- oder +) beinhaltet den Wert des Kilometersprunges. Eine �berl�nge ist negativ, eine Fehll�nge ist positiv.
 * 
 * <p>Java-Klasse f�r CStrecke_Punkt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CStrecke_Punkt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_GEO_Knoten" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_GEO_Knoten" minOccurs="0"/>
 *         &lt;element name="ID_Strecke" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Strecke"/>
 *         &lt;element name="Strecke_Meter" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCStrecke_Meter"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CStrecke_Punkt", propOrder = {
    "idgeoKnoten",
    "idStrecke",
    "streckeMeter"
})
public class CStreckePunkt
    extends CBasisObjekt
{

    @XmlElement(name = "ID_GEO_Knoten")
    protected TCIDGEOKnoten idgeoKnoten;
    @XmlElement(name = "ID_Strecke", required = true)
    protected TCIDStrecke idStrecke;
    @XmlElement(name = "Strecke_Meter", required = true)
    protected TCStreckeMeter streckeMeter;

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
     * Ruft den Wert der idStrecke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDStrecke }
     *     
     */
    public TCIDStrecke getIDStrecke() {
        return idStrecke;
    }

    /**
     * Legt den Wert der idStrecke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDStrecke }
     *     
     */
    public void setIDStrecke(TCIDStrecke value) {
        this.idStrecke = value;
    }

    /**
     * Ruft den Wert der streckeMeter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCStreckeMeter }
     *     
     */
    public TCStreckeMeter getStreckeMeter() {
        return streckeMeter;
    }

    /**
     * Legt den Wert der streckeMeter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCStreckeMeter }
     *     
     */
    public void setStreckeMeter(TCStreckeMeter value) {
        this.streckeMeter = value;
    }

}
