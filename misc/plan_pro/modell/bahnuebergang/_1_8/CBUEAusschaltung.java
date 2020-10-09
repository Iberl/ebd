//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bahnuebergang._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDBUEGleisbezogenerGefahrraum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Logisches Objekt, das alle Informationen zur Ausschaltung eines Bahn�bergangs enth�lt. �ber den Verweis auf BUE Gleisbezogener Gefahrraum findet eine Verortung am zugeh�rigen Gleis statt, f�r das der Ausschaltkontakt angeordnet wird. Der Ausschaltkontakt selbst ist �ber das Objekt Schaltmittel Zuordnung abgebildet. F�r die BUE_Ausschaltung ist, in Fahrtrichtung Ausschaltkontakt weg vom B� gesehen, die R�CKGELEGENE Grenze von BUE Gleisbezogener Gefahrraum f�r die Verortung ma�gebend. Die Gefahrraum-Grenze liegt damit in Fahrtrichtung VOR dem Ausschaltkontakt. DB-Regelwerk 815.0032 4 (3) Die Planung der Ausschaltung erfolgt entsprechend der Projektierungshinweise der konkreten B�-Technik. Seitens der Ril 815 gibt es dazu keine konkreten Vorgaben. 
 * 
 * <p>Java-Klasse f�r CBUE_Ausschaltung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Ausschaltung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_BUE_Gleisbez_Gefahrraum" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_BUE_Gleisbezogener_Gefahrraum"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Ausschaltung", propOrder = {
    "idbueGleisbezGefahrraum"
})
public class CBUEAusschaltung
    extends CBasisObjekt
{

    @XmlElement(name = "ID_BUE_Gleisbez_Gefahrraum", required = true)
    protected TCIDBUEGleisbezogenerGefahrraum idbueGleisbezGefahrraum;

    /**
     * Ruft den Wert der idbueGleisbezGefahrraum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBUEGleisbezogenerGefahrraum }
     *     
     */
    public TCIDBUEGleisbezogenerGefahrraum getIDBUEGleisbezGefahrraum() {
        return idbueGleisbezGefahrraum;
    }

    /**
     * Legt den Wert der idbueGleisbezGefahrraum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBUEGleisbezogenerGefahrraum }
     *     
     */
    public void setIDBUEGleisbezGefahrraum(TCIDBUEGleisbezogenerGefahrraum value) {
        this.idbueGleisbezGefahrraum = value;
    }

}
