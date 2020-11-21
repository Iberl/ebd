//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBUEAnlage;
import plan_pro.modell.verweise._1_9_0.TCIDBUEEinschaltung;
import plan_pro.modell.verweise._1_9_0.TCIDSignal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Objekt zur Zuordnung von Signalen, die ausschlie�lich im Zusammenhang mit einem Bahn�bergang (B�) angeordnet werden. Dazu geh�ren zum Beispiel Pfeiftafeln, Lf-Signale mit und ohne Zusatz \"B�\" oder �berwachungssignale f�r B�, Merktafeln oder Merkpf�hle u.a. Die Anwendung von Pfeiftafeln und Lf-Signalen erfolgt zumeist bei nichttechnisch gesicherten B�; die Anwendung der �berwachungssignale bei Bahn�berg�ngen der Funktions�berwachung \"�S\". F�r die vorgenannten F�lle ist der Verweis auf BUE Anlage zu bef�llen. Wird zum Beispiel ein Merkpfahl zur Kennzeichnung eines Einschaltpunktes (Anwendung in besonderen Planungsf�llen) vorgesehen, ist der Verweis auf BUE Einschaltung zu bef�llen. F�r die Bezeichnung von B�-spezifischen Signalen, insbesondere �berwachungssignale, sind Ausf�hrungen auf der Seite Bezeichnung Signal vorhanden. DB-Regelwerk Formblatt zur Ermittlung der Sichtfl�chen f�r nichttechnisch gesicherte B� 819.1204 9 f�r �S SPU 24 f�r Merktafel /-pfahl B�-Kabellage- und -�bersichtsplan 
 * 
 * <p>Java-Klasse f�r CBUE_Spezifisches_Signal complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Spezifisches_Signal">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Signal" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal"/>
 *         &lt;choice>
 *           &lt;element name="ID_BUE_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_BUE_Anlage"/>
 *           &lt;element name="ID_BUE_Einschaltung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_BUE_Einschaltung"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Spezifisches_Signal", propOrder = {
    "idSignal",
    "idbueAnlage",
    "idbueEinschaltung"
})
public class CBUESpezifischesSignal
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Signal", required = true)
    protected TCIDSignal idSignal;
    @XmlElement(name = "ID_BUE_Anlage")
    protected TCIDBUEAnlage idbueAnlage;
    @XmlElement(name = "ID_BUE_Einschaltung")
    protected TCIDBUEEinschaltung idbueEinschaltung;

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
     * Ruft den Wert der idbueAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBUEAnlage }
     *     
     */
    public TCIDBUEAnlage getIDBUEAnlage() {
        return idbueAnlage;
    }

    /**
     * Legt den Wert der idbueAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBUEAnlage }
     *     
     */
    public void setIDBUEAnlage(TCIDBUEAnlage value) {
        this.idbueAnlage = value;
    }

    /**
     * Ruft den Wert der idbueEinschaltung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBUEEinschaltung }
     *     
     */
    public TCIDBUEEinschaltung getIDBUEEinschaltung() {
        return idbueEinschaltung;
    }

    /**
     * Legt den Wert der idbueEinschaltung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBUEEinschaltung }
     *     
     */
    public void setIDBUEEinschaltung(TCIDBUEEinschaltung value) {
        this.idbueEinschaltung = value;
    }

}
