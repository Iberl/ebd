//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBUEAnlageOhneProxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Gerfahrraumfreimeldeanlage. Folgende Rahmenbedingungen sind f�r den Einsatz einer GFR zu beachten: max. H�he der Bodenwellen des B�: 15 cm; max. Neigung des B�: 2�.
 * 
 * <p>Java-Klasse f�r CGFR_Anlage complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGFR_Anlage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="GFR_Anlage_Allg" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CGFR_Anlage_Allg"/>
 *         &lt;element name="ID_BUE_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_BUE_Anlage_ohne_Proxy"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGFR_Anlage", propOrder = {
    "gfrAnlageAllg",
    "idbueAnlage"
})
public class CGFRAnlage
    extends CBasisObjekt
{

    @XmlElement(name = "GFR_Anlage_Allg", required = true)
    protected CGFRAnlageAllg gfrAnlageAllg;
    @XmlElement(name = "ID_BUE_Anlage", required = true)
    protected TCIDBUEAnlageOhneProxy idbueAnlage;

    /**
     * Ruft den Wert der gfrAnlageAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CGFRAnlageAllg }
     *     
     */
    public CGFRAnlageAllg getGFRAnlageAllg() {
        return gfrAnlageAllg;
    }

    /**
     * Legt den Wert der gfrAnlageAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CGFRAnlageAllg }
     *     
     */
    public void setGFRAnlageAllg(CGFRAnlageAllg value) {
        this.gfrAnlageAllg = value;
    }

    /**
     * Ruft den Wert der idbueAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBUEAnlageOhneProxy }
     *     
     */
    public TCIDBUEAnlageOhneProxy getIDBUEAnlage() {
        return idbueAnlage;
    }

    /**
     * Legt den Wert der idbueAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBUEAnlageOhneProxy }
     *     
     */
    public void setIDBUEAnlage(TCIDBUEAnlageOhneProxy value) {
        this.idbueAnlage = value;
    }

}
