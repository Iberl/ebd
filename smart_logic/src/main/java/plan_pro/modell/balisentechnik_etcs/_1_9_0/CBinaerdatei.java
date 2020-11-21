//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Bin�rdatei mit betriebssystemnahen Metadaten (z. B. Dateiname, Dateityp).
 * 
 * <p>Java-Klasse f�r CBinaerdatei complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBinaerdatei">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Binaerdatei_Allg" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CBinaerdatei_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBinaerdatei", propOrder = {
    "binaerdateiAllg"
})
public class CBinaerdatei
    extends CBasisObjekt
{

    @XmlElement(name = "Binaerdatei_Allg", required = true)
    protected CBinaerdateiAllg binaerdateiAllg;

    /**
     * Ruft den Wert der binaerdateiAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBinaerdateiAllg }
     *     
     */
    public CBinaerdateiAllg getBinaerdateiAllg() {
        return binaerdateiAllg;
    }

    /**
     * Legt den Wert der binaerdateiAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBinaerdateiAllg }
     *     
     */
    public void setBinaerdateiAllg(CBinaerdateiAllg value) {
        this.binaerdateiAllg = value;
    }

}
