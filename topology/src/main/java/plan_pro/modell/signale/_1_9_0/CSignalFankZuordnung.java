//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.signale._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDSignalFank;
import plan_pro.modell.verweise._1_9_0.TCIDSignalStart;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Abbildung des Fahrtank�nders (Wei�es Dreieck) sowie Zuordnung der Startsignale, f�r die eine Fahrtank�ndigung erfolgen soll. Ein physischer Fahrtank�nder (Anzeiger) wird als Signal abgebildet, wobei hierbei nur die Attributgruppen Bezeichnung sowie Signal_Real zu nutzen sind (nicht: Signal_Real_Aktiv, da kein Anschluss mittels ID_Stellelement an ein Stellwerk). Erfolgt die Fahrtank�ndigung ausschlie�lich auf mobilen Endger�ten, so entf�llt das Anlegen des Signals f�r den Fahrtank�nder. 
 * 
 * <p>Java-Klasse f�r CSignal_Fank_Zuordnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_Fank_Zuordnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Signal_Fank" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal_Fank" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_Signal_Start" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal_Start" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_Fank_Zuordnung", propOrder = {
    "idSignalFank",
    "idSignalStart"
})
public class CSignalFankZuordnung
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Signal_Fank")
    protected List<TCIDSignalFank> idSignalFank;
    @XmlElement(name = "ID_Signal_Start", required = true)
    protected List<TCIDSignalStart> idSignalStart;

    /**
     * Gets the value of the idSignalFank property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idSignalFank property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDSignalFank().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDSignalFank }
     * 
     * 
     */
    public List<TCIDSignalFank> getIDSignalFank() {
        if (idSignalFank == null) {
            idSignalFank = new ArrayList<TCIDSignalFank>();
        }
        return this.idSignalFank;
    }

    /**
     * Gets the value of the idSignalStart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idSignalStart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDSignalStart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDSignalStart }
     * 
     * 
     */
    public List<TCIDSignalStart> getIDSignalStart() {
        if (idSignalStart == null) {
            idSignalStart = new ArrayList<TCIDSignalStart>();
        }
        return this.idSignalStart;
    }

}
