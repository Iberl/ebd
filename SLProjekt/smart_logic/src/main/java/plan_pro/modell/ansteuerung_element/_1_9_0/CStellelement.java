//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ansteuerung_element._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDAussenelementansteuerung;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Zusammenfassung der gemeinsamen Eigenschaften aller elektrisch bedienbaren Elemente der Au�enanlage sowie der B�-Schnittstelle. Folgende Elemente sind Stellelemente: BUE Schnittstelle, PZB Element, Schluesselsperre, Signal, W Kr Gsp Element. Die �bertragung von Information (Daten) und Energie ist in getrennten Verweisen modelliert. Erfolgt die �bertragung von Information und Energie gemeinsam, so sind beide Verweise mit dem gleichen Verweisziel anzugeben. DB-Regelwerk Die Zusammenfassung der Stellelemente dient der Vereinheitlichung der Modellierung und wird heute nicht explizit geplant.
 * 
 * <p>Java-Klasse f�r CStellelement complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CStellelement">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Energie" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Aussenelementansteuerung"/>
 *         &lt;element name="ID_Information" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Aussenelementansteuerung"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CStellelement", propOrder = {
    "idEnergie",
    "idInformation"
})
public class CStellelement
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Energie", required = true)
    protected TCIDAussenelementansteuerung idEnergie;
    @XmlElement(name = "ID_Information", required = true)
    protected TCIDAussenelementansteuerung idInformation;

    /**
     * Ruft den Wert der idEnergie-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public TCIDAussenelementansteuerung getIDEnergie() {
        return idEnergie;
    }

    /**
     * Legt den Wert der idEnergie-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public void setIDEnergie(TCIDAussenelementansteuerung value) {
        this.idEnergie = value;
    }

    /**
     * Ruft den Wert der idInformation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public TCIDAussenelementansteuerung getIDInformation() {
        return idInformation;
    }

    /**
     * Legt den Wert der idInformation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public void setIDInformation(TCIDAussenelementansteuerung value) {
        this.idInformation = value;
    }

}
