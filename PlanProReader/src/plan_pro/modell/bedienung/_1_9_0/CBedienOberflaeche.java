//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBedienBezirk;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Topologisches Abbild der f�r die Bedienung und Anzeige eines ESTW relevanten sicherungstechnischen Anlagen. Dies wird in Form von Meldebildern mit unterschiedlicher Informationstiefe dargestellt. Dar�ber hinaus gibt es weitere zum Bedienplatzsystem geh�rende Meldebilder. Folgende Meldebildtypen stehen an einem Bedienplatzsystem (BPS) zur Verf�gung: Bereichs�bersicht (Ber�), Bereichs�bergreifende Ber�, Lupe, Gleisbenutzungstabelle (GBT), Kommunikationsanzeige (KA), KA-Bild 1 (PSI-Spiegel), KA-Bild 2 (ESTW-St�rungsmeldungen), Betriebsstatus (Rechnerst�rungen), Sammelmelderbild (SM-Bild), Dokumentation (Doku), Integrierte Bedienerf�hrung. An anderen Bedienplatzsystemen k�nnen andere Meldebildtypen m�glich sein. Die Eigenschaften eines Bildes sind unter dem Objekt Bedien Oberflaeche Bild zusammengefasst. Mehrere Bilder verweisen auf das Objekt Bedien_Oberflaeche. Die M�glichkeiten der Aufschaltung der jeweiligen Bedienoberfl�chen auf den Bedienpl�tzen sind implizite Stellwerksfunktion. Die dazu notwendigen Berechtigungen sind Betriebsdaten der Instandhaltung. Diese Parameter werden im PT I nicht geplant und im Datenmodell nicht abgebildet. Sondern von der �rtlichen Instandhaltung in die Systeme eingegeben. Die Bildbezeichnung des jeweiligen Oberfl�chenbildes nach der signifikanten (also der bedeutenstenten) Betriebsstelle entsprechend Richtlinie 819.0603 in der Form \"(Bildart)_(Ril 100 Abk)\" wird �ber die Attribute Oberflaeche Bildart und ID Oertlichkeit gebildet. 
 * 
 * <p>Java-Klasse f�r CBedien_Oberflaeche complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Oberflaeche">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bedien_Oberflaeche_Anhaenge" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}CBedien_Oberflaeche_Anhaenge"/>
 *         &lt;element name="ID_Bedien_Bezirk" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Bedien_Bezirk"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Oberflaeche", propOrder = {
    "bedienOberflaecheAnhaenge",
    "idBedienBezirk"
})
public class CBedienOberflaeche
    extends CBasisObjekt
{

    @XmlElement(name = "Bedien_Oberflaeche_Anhaenge", required = true)
    protected CBedienOberflaecheAnhaenge bedienOberflaecheAnhaenge;
    @XmlElement(name = "ID_Bedien_Bezirk", required = true)
    protected TCIDBedienBezirk idBedienBezirk;

    /**
     * Ruft den Wert der bedienOberflaecheAnhaenge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedienOberflaecheAnhaenge }
     *     
     */
    public CBedienOberflaecheAnhaenge getBedienOberflaecheAnhaenge() {
        return bedienOberflaecheAnhaenge;
    }

    /**
     * Legt den Wert der bedienOberflaecheAnhaenge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedienOberflaecheAnhaenge }
     *     
     */
    public void setBedienOberflaecheAnhaenge(CBedienOberflaecheAnhaenge value) {
        this.bedienOberflaecheAnhaenge = value;
    }

    /**
     * Ruft den Wert der idBedienBezirk-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBedienBezirk }
     *     
     */
    public TCIDBedienBezirk getIDBedienBezirk() {
        return idBedienBezirk;
    }

    /**
     * Legt den Wert der idBedienBezirk-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBedienBezirk }
     *     
     */
    public void setIDBedienBezirk(TCIDBedienBezirk value) {
        this.idBedienBezirk = value;
    }

}
