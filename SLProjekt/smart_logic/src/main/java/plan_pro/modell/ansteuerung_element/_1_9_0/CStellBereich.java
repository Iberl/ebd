//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ansteuerung_element._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBereichObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDAussenelementansteuerung;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Bereich_Objekt, mit dem ein Stellbereich beschrieben wird. Ein Stellbereich wird immer von einer AEA (Top) gesteuert. Grenzen des Stellbereichs sind Haupt-, Sperr- oder virtuelle Signale oder Gleisabschl�sse. Jedes Hauptgleis muss einem Stellbereich zugeordnet sein.
 * 
 * <p>Java-Klasse f�r CStell_Bereich complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CStell_Bereich">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Aussenelementansteuerung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Aussenelementansteuerung"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CStell_Bereich", propOrder = {
    "idAussenelementansteuerung"
})
public class CStellBereich
    extends CBereichObjekt
{

    @XmlElement(name = "ID_Aussenelementansteuerung", required = true)
    protected TCIDAussenelementansteuerung idAussenelementansteuerung;

    /**
     * Ruft den Wert der idAussenelementansteuerung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public TCIDAussenelementansteuerung getIDAussenelementansteuerung() {
        return idAussenelementansteuerung;
    }

    /**
     * Legt den Wert der idAussenelementansteuerung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public void setIDAussenelementansteuerung(TCIDAussenelementansteuerung value) {
        this.idAussenelementansteuerung = value;
    }

}
