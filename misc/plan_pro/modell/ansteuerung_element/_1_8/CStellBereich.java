//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.ansteuerung_element._1_8;

import modell.basisobjekte._1_8.CBereichObjekt;
import modell.verweise._1_8.TCIDAussenelementansteuerung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Aussenelementansteuerung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Aussenelementansteuerung"/>
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
