//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDZN;
import plan_pro.modell.verweise._1_9_0.TCIDZNAnzeigefeld;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Akustisches Signal bei Bef�llung eines ZN-Anzeigefeldes mit einer Zugnummer Bei der Planung der ZN-Akustik sind herstellerspezifische Besonderheiten zu beachten. Akustiken im Anbiete-/Annahmefeld sind Standard und nicht gesondert zu planen. Das Objekt bzw. die Attributgruppe wird bei Anbiete/Annahme- sowie Voranzeigefeldern IMMER angelegt, um die Dauer der Akustik festzulegen. F�r die weiteren ZN-Anzeigefelder wird das Objekt nur dann angelegt, wenn das betreffene ZN Anzeigefeld mit einer Akustik ausgestatteet wird. DB-Regelwerk Das Planungsdatum ist im Regelwerk der DB AG nicht vorhanden. Es findet sich im Lastenheft sowie in den firmenspezifischen Projektierungsunterlagen, die dem LST-Fachplaner nicht zur Verf�gung stehen.
 * 
 * <p>Java-Klasse f�r CZN_Akustik complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_Akustik">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ZN_Akustik_Anzeigefeld" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}CZN_Akustik_Anzeigefeld" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="ID_ZN" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZN"/>
 *           &lt;element name="ID_ZN_Anzeigefeld" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZN_Anzeigefeld"/>
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
@XmlType(name = "CZN_Akustik", propOrder = {
    "znAkustikAnzeigefeld",
    "idzn",
    "idznAnzeigefeld"
})
public class CZNAkustik
    extends CBasisObjekt
{

    @XmlElement(name = "ZN_Akustik_Anzeigefeld")
    protected CZNAkustikAnzeigefeld znAkustikAnzeigefeld;
    @XmlElement(name = "ID_ZN")
    protected TCIDZN idzn;
    @XmlElement(name = "ID_ZN_Anzeigefeld")
    protected TCIDZNAnzeigefeld idznAnzeigefeld;

    /**
     * Ruft den Wert der znAkustikAnzeigefeld-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZNAkustikAnzeigefeld }
     *     
     */
    public CZNAkustikAnzeigefeld getZNAkustikAnzeigefeld() {
        return znAkustikAnzeigefeld;
    }

    /**
     * Legt den Wert der znAkustikAnzeigefeld-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZNAkustikAnzeigefeld }
     *     
     */
    public void setZNAkustikAnzeigefeld(CZNAkustikAnzeigefeld value) {
        this.znAkustikAnzeigefeld = value;
    }

    /**
     * Ruft den Wert der idzn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZN }
     *     
     */
    public TCIDZN getIDZN() {
        return idzn;
    }

    /**
     * Legt den Wert der idzn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZN }
     *     
     */
    public void setIDZN(TCIDZN value) {
        this.idzn = value;
    }

    /**
     * Ruft den Wert der idznAnzeigefeld-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZNAnzeigefeld }
     *     
     */
    public TCIDZNAnzeigefeld getIDZNAnzeigefeld() {
        return idznAnzeigefeld;
    }

    /**
     * Legt den Wert der idznAnzeigefeld-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZNAnzeigefeld }
     *     
     */
    public void setIDZNAnzeigefeld(TCIDZNAnzeigefeld value) {
        this.idznAnzeigefeld = value;
    }

}
