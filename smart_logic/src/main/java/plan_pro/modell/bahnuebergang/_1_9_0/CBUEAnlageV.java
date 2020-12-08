//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBUEAnlageOhneProxy;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Angaben zu gleis- und stra�enseitigen Mindest- und H�chstgeschwindigkeiten f�r die Einschaltstreckenberechnung.
 * 
 * <p>Java-Klasse f�r CBUE_Anlage_V complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Anlage_V">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="BUE_Anlage_V_Allg" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CBUE_Anlage_V_Allg"/>
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
@XmlType(name = "CBUE_Anlage_V", propOrder = {
    "bueAnlageVAllg",
    "idbueAnlage"
})
public class CBUEAnlageV
    extends CBasisObjekt
{

    @XmlElement(name = "BUE_Anlage_V_Allg", required = true)
    protected CBUEAnlageVAllg bueAnlageVAllg;
    @XmlElement(name = "ID_BUE_Anlage", required = true)
    protected TCIDBUEAnlageOhneProxy idbueAnlage;

    /**
     * Ruft den Wert der bueAnlageVAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBUEAnlageVAllg }
     *     
     */
    public CBUEAnlageVAllg getBUEAnlageVAllg() {
        return bueAnlageVAllg;
    }

    /**
     * Legt den Wert der bueAnlageVAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBUEAnlageVAllg }
     *     
     */
    public void setBUEAnlageVAllg(CBUEAnlageVAllg value) {
        this.bueAnlageVAllg = value;
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
