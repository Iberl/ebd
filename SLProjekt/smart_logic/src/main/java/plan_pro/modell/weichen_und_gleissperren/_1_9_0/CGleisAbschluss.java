//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.weichen_und_gleissperren._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CPunktObjekt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * St�ndig vorhandenes Ende eines betrieblich nutzbaren Gleises (z. B. Prellbock oder Schwellenkreuz). Der Gleisabschluss ist ein Punkt Objekt. Die TOP Kante kann hinter dem Gleisabschluss bis zum baulichen Ende des Gleises weitergef�hrt sein. Er wird auf den Punkt verortet, der die Grenze der m�glichen Fahrzeugbewegung darstellt. Da das bauliche Ende konstruktiv hinter diesem Punkt liegt, f�llt der Gleisabschluss in der Regel nicht mit einem TOP Knoten zusammen. Der Gleisabschluss ist vom klappbaren Prellbock (und anderen beweglichen Elementen) zu unterscheiden. Diese besonderen beweglichen Fahrwegelemente sind als Gleissperre mit einem erg�nzenden Bearbeitungsvermerk zu planen. Der Gleisabschluss ist in der Regel auch Grenze eines Gleisabschnittes. Die Wirkrichtung entspricht der Richtung der m�glichen Fahrzeugbewegung auf den Gleisabschluss. Der Gleisabschluss ist mittig angeordnet wodurch der seitliche Abschand immer 0.000 sein muss. 
 * 
 * <p>Java-Klasse f�r CGleis_Abschluss complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGleis_Abschluss">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Gleis_Abschluss_Art" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCGleis_Abschluss_Art"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGleis_Abschluss", propOrder = {
    "gleisAbschlussArt"
})
public class CGleisAbschluss
    extends CPunktObjekt
{

    @XmlElement(name = "Gleis_Abschluss_Art", required = true)
    protected TCGleisAbschlussArt gleisAbschlussArt;

    /**
     * Ruft den Wert der gleisAbschlussArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGleisAbschlussArt }
     *     
     */
    public TCGleisAbschlussArt getGleisAbschlussArt() {
        return gleisAbschlussArt;
    }

    /**
     * Legt den Wert der gleisAbschlussArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGleisAbschlussArt }
     *     
     */
    public void setGleisAbschlussArt(TCGleisAbschlussArt value) {
        this.gleisAbschlussArt = value;
    }

}
