//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zuglenkung._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDSignal;
import plan_pro.modell.verweise._1_9_0.TCIDZLSignalgruppe;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Zuordnung von Signalen zur ZL Signalgruppe. DB-Regelwerk 819.0732 A06 Im PT1 erfolgt die Angabe in einer gesonderten Tabelle, f�r die es im Regelwerk z. Zt. keine Vorgabe gibt.
 * 
 * <p>Java-Klasse f�r CZL_Signalgruppe_Zuordnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZL_Signalgruppe_Zuordnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Signal" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal"/>
 *         &lt;element name="ID_ZL_Signalgruppe" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZL_Signalgruppe"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZL_Signalgruppe_Zuordnung", propOrder = {
    "idSignal",
    "idzlSignalgruppe"
})
public class CZLSignalgruppeZuordnung
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Signal", required = true)
    protected TCIDSignal idSignal;
    @XmlElement(name = "ID_ZL_Signalgruppe", required = true)
    protected TCIDZLSignalgruppe idzlSignalgruppe;

    /**
     * Ruft den Wert der idSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignal }
     *     
     */
    public TCIDSignal getIDSignal() {
        return idSignal;
    }

    /**
     * Legt den Wert der idSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignal }
     *     
     */
    public void setIDSignal(TCIDSignal value) {
        this.idSignal = value;
    }

    /**
     * Ruft den Wert der idzlSignalgruppe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZLSignalgruppe }
     *     
     */
    public TCIDZLSignalgruppe getIDZLSignalgruppe() {
        return idzlSignalgruppe;
    }

    /**
     * Legt den Wert der idzlSignalgruppe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZLSignalgruppe }
     *     
     */
    public void setIDZLSignalgruppe(TCIDZLSignalgruppe value) {
        this.idzlSignalgruppe = value;
    }

}
