//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.pzb._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDPZBElementZuordnung;
import plan_pro.modell.verweise._1_9_0.TCIDSignal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Das Objekt dient der Zuordnung der Signale (Vorsignal, Vorsignalwiederholer, H-Tafel) zum ma�gebenden Gleismagneten (GM) 2000 Hz des Hauptsignals. Die Unterscheidung zwischen den verschiedenen Signalen wird �ber die GUID des Signals hergestellt. Der angegebene Abstand bezieht sich beim Vorsignal auf den Abstand des GM 1000 Hz, bei Vorsignalwiederholer und H-Tafel auf den Abstand des Signals zum ma�gebenden GM 2000 Hz des Hauptsignals. Es werden in der Regel bis zu vier H-Tafeln pro Hauptsignal geplant. DB-Regelwerk Gleismagnettabelle, Zeilen 19 sowie 21 bis 25 
 * 
 * <p>Java-Klasse f�r CPZB_Zuordnung_Signal complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPZB_Zuordnung_Signal">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_PZB_Element_Zuordnung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_PZB_Element_Zuordnung"/>
 *         &lt;element name="ID_Signal" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPZB_Zuordnung_Signal", propOrder = {
    "idpzbElementZuordnung",
    "idSignal"
})
public class CPZBZuordnungSignal
    extends CBasisObjekt
{

    @XmlElement(name = "ID_PZB_Element_Zuordnung", required = true)
    protected TCIDPZBElementZuordnung idpzbElementZuordnung;
    @XmlElement(name = "ID_Signal", required = true)
    protected TCIDSignal idSignal;

    /**
     * Ruft den Wert der idpzbElementZuordnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDPZBElementZuordnung }
     *     
     */
    public TCIDPZBElementZuordnung getIDPZBElementZuordnung() {
        return idpzbElementZuordnung;
    }

    /**
     * Legt den Wert der idpzbElementZuordnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDPZBElementZuordnung }
     *     
     */
    public void setIDPZBElementZuordnung(TCIDPZBElementZuordnung value) {
        this.idpzbElementZuordnung = value;
    }

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

}
