//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CPunktObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * �rtliche H�he des Bezugspunkts gem�� des H�hensystems. Liegt der H�henpunkt innerhalb des zugeh�rigen Gleises, wird dieser mit einem Seitlichen Abstand im Punkt_Objekt von 0.000 angegeben und gibt die H�he des Gleises in Meter gem�� H�hensystem an. Wird eine seitlicher Abstand ungleich 0.000 angegeben, so handelt es sich um einen sonstigen H�henpunkt, der nicht die H�henlage des Gleises angibt. Ein H�henpunkt, der unmittelbar auf einem Anfang oder Ende eines Weichenschenkels liegt (TOP_Kante, mit Anschluss_A oder Anschluss_B als Links oder Rechts) ist auf die TOP_Kante der Spitze dieser Weiche zu verorten.
 * 
 * <p>Java-Klasse f�r CHoehenpunkt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CHoehenpunkt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Hoehenpunkt_Allg" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}CHoehenpunkt_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHoehenpunkt", propOrder = {
    "hoehenpunktAllg"
})
public class CHoehenpunkt
    extends CPunktObjekt
{

    @XmlElement(name = "Hoehenpunkt_Allg", required = true)
    protected CHoehenpunktAllg hoehenpunktAllg;

    /**
     * Ruft den Wert der hoehenpunktAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CHoehenpunktAllg }
     *     
     */
    public CHoehenpunktAllg getHoehenpunktAllg() {
        return hoehenpunktAllg;
    }

    /**
     * Legt den Wert der hoehenpunktAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CHoehenpunktAllg }
     *     
     */
    public void setHoehenpunktAllg(CHoehenpunktAllg value) {
        this.hoehenpunktAllg = value;
    }

}
