//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CPunktObjekt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * �rtlicher H�henunterschied beider Schienen eines Gleises in Querrichtung. Die �berh�hung ist eine Querneigung eines Gleises in einem Bogen an einem Punkt im Gleis. Durch die seitliche Lage (als Attribut des Punkt_Objektes - links oder rechts) wird die h�here Seite der beiden Schienen beschrieben. Ein H�henpunkt, der unmittelbar auf einem Anfang oder Ende eines Weichenschenkels liegt (TOP_Kante, mit Anschluss_A oder Anschluss_B als Links oder Rechts) ist auf die TOP_Kante der Spitze dieser Weiche zu verorten.
 * 
 * <p>Java-Klasse f�r CUeberhoehung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CUeberhoehung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Ueberhoehung_Allg" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}CUeberhoehung_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CUeberhoehung", propOrder = {
    "ueberhoehungAllg"
})
public class CUeberhoehung
    extends CPunktObjekt
{

    @XmlElement(name = "Ueberhoehung_Allg", required = true)
    protected CUeberhoehungAllg ueberhoehungAllg;

    /**
     * Ruft den Wert der ueberhoehungAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CUeberhoehungAllg }
     *     
     */
    public CUeberhoehungAllg getUeberhoehungAllg() {
        return ueberhoehungAllg;
    }

    /**
     * Legt den Wert der ueberhoehungAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CUeberhoehungAllg }
     *     
     */
    public void setUeberhoehungAllg(CUeberhoehungAllg value) {
        this.ueberhoehungAllg = value;
    }

}
