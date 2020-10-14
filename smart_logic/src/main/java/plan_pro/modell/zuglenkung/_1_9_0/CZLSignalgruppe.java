//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zuglenkung._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDZL;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Gruppe von Signalen (Haupt-, Sperrsignale), die von der Zug- bzw. Rangierlenkung f�r die Vorzugregelung ben�tigt wird. DB-Regelwerk 819.0732 A06 Im PT1 erfolgt die Angabe in einer gesonderten Tabelle, f�r die es im Regelwerk z. Zt. keine Vorgabe gibt.
 * 
 * <p>Java-Klasse f�r CZL_Signalgruppe complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZL_Signalgruppe">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_ZL" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZL"/>
 *         &lt;element name="ZL_Signalgruppe_Allg" type="{http://www.plan-pro.org/modell/Zuglenkung/1.9.0.2}CZL_Signalgruppe_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZL_Signalgruppe", propOrder = {
    "idzl",
    "zlSignalgruppeAllg"
})
public class CZLSignalgruppe
    extends CBasisObjekt
{

    @XmlElement(name = "ID_ZL", required = true)
    protected TCIDZL idzl;
    @XmlElement(name = "ZL_Signalgruppe_Allg", required = true)
    protected CZLSignalgruppeAllg zlSignalgruppeAllg;

    /**
     * Ruft den Wert der idzl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZL }
     *     
     */
    public TCIDZL getIDZL() {
        return idzl;
    }

    /**
     * Legt den Wert der idzl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZL }
     *     
     */
    public void setIDZL(TCIDZL value) {
        this.idzl = value;
    }

    /**
     * Ruft den Wert der zlSignalgruppeAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZLSignalgruppeAllg }
     *     
     */
    public CZLSignalgruppeAllg getZLSignalgruppeAllg() {
        return zlSignalgruppeAllg;
    }

    /**
     * Legt den Wert der zlSignalgruppeAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZLSignalgruppeAllg }
     *     
     */
    public void setZLSignalgruppeAllg(CZLSignalgruppeAllg value) {
        this.zlSignalgruppeAllg = value;
    }

}
