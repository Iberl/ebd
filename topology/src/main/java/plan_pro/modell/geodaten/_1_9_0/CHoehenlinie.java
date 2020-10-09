//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDHoehenpunkt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * H�henverlauf zwischen zwei H�henpunkten.
 * 
 * <p>Java-Klasse f�r CHoehenlinie complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CHoehenlinie">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Hoehenlinie_Allg" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}CHoehenlinie_Allg"/>
 *         &lt;element name="ID_Hoehenpunkt_A" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Hoehenpunkt"/>
 *         &lt;element name="ID_Hoehenpunkt_B" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Hoehenpunkt"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHoehenlinie", propOrder = {
    "hoehenlinieAllg",
    "idHoehenpunktA",
    "idHoehenpunktB"
})
public class CHoehenlinie
    extends CBasisObjekt
{

    @XmlElement(name = "Hoehenlinie_Allg", required = true)
    protected CHoehenlinieAllg hoehenlinieAllg;
    @XmlElement(name = "ID_Hoehenpunkt_A", required = true)
    protected TCIDHoehenpunkt idHoehenpunktA;
    @XmlElement(name = "ID_Hoehenpunkt_B", required = true)
    protected TCIDHoehenpunkt idHoehenpunktB;

    /**
     * Ruft den Wert der hoehenlinieAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CHoehenlinieAllg }
     *     
     */
    public CHoehenlinieAllg getHoehenlinieAllg() {
        return hoehenlinieAllg;
    }

    /**
     * Legt den Wert der hoehenlinieAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CHoehenlinieAllg }
     *     
     */
    public void setHoehenlinieAllg(CHoehenlinieAllg value) {
        this.hoehenlinieAllg = value;
    }

    /**
     * Ruft den Wert der idHoehenpunktA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDHoehenpunkt }
     *     
     */
    public TCIDHoehenpunkt getIDHoehenpunktA() {
        return idHoehenpunktA;
    }

    /**
     * Legt den Wert der idHoehenpunktA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDHoehenpunkt }
     *     
     */
    public void setIDHoehenpunktA(TCIDHoehenpunkt value) {
        this.idHoehenpunktA = value;
    }

    /**
     * Ruft den Wert der idHoehenpunktB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDHoehenpunkt }
     *     
     */
    public TCIDHoehenpunkt getIDHoehenpunktB() {
        return idHoehenpunktB;
    }

    /**
     * Legt den Wert der idHoehenpunktB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDHoehenpunkt }
     *     
     */
    public void setIDHoehenpunktB(TCIDHoehenpunkt value) {
        this.idHoehenpunktB = value;
    }

}
