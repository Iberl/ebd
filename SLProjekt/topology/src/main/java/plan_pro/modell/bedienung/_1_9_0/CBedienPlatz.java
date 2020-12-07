//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDAnhang;
import plan_pro.modell.verweise._1_9_0.TCIDBedienBezirk;
import plan_pro.modell.verweise._1_9_0.TCIDESTWZentraleinheit;
import plan_pro.modell.verweise._1_9_0.TCIDUnterbringung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * �rtliche Anordnung der Bedien- und Meldeeinrichtungen zur betrieblichen Nutzung eines elektronischen Stellwerks. Der Bedien_Platz kann sowohl an einem Bedien_Bezirk wie auch an einer ESTW_Zentraleinheit angeschaltet sein. Der Aufstellungsort muss aber nicht zwingend der Anschalteort sein. Der Bedien_Platz kann auch als abgesetzter Bedien_Platz an abweichenden Orten untergebracht sein. Z.B. wenn im Modulgeb�ude der ESTW_Zentraleinheit nicht ausreichend Platz ist und der Bedien_Platz im benachbartem alten Stellwerksgeb�ude untergebracht werden soll. Um dem Lieferanten die allgemeine Auspr�gung des Bedien_Platzes im PT 1 zu beschreiben, ist noch der Hinweis zu erbringen, ob es sich um einen Not-Bedien_Platz oder einen Standard-Bedien_Platz handelt. Da es verschiedne Kombinationen und mehere Instanzen von Bedien_Platz geben kann, hier noch mal Beispielhafte Varianten: ESTW_Zentraleinheit mit Anbindung an einen Bedien_Bezirk mit �rtlichem Notbedienplatz im Modulgeb�ude und Standardbedienpl�tzen in der Bedien_Zentrale (z.B. ESTW Orxhausen/Siemens) ESTW_Zentraleinheit mit abgesetzten Standardbedienpl�tzen und mit �rtlichem Notbedienplatz im Modulgeb�ude (z.B. ESTW Kreiensen/Bombardier) ESTW_Zentraleinheit mit Anbindung an einen Bedien_Bezirk mit abgesetztem Notbedienplatz im Altstellwerk und Standardbedienpl�tzen in der Bedien_Zentrale (z.B. ESTW Oldenburg Nord/Siemens) Aus diesem Zusammenhang entstehen vier Typen von Bedienpl�tzen. Standard-Bedienplatz-System (Standard_BPS) Standard-Bedienplatz-System abgesetzt (Standard_BPS_Abgesetzt) Not-Bedienplatz Not-BPS-System (Not_BPS) Not-Bedienplatz Not-BPS-System abgesetzt (Not_BPS_Abgesetzt) Im PT 1 BZ werden f�r den Bedienplatz die Aufstellung im Raum, die Ausstattung und Ausr�stung sowie die Versorgung mit elektrischer Energie und Daten geplant. Siehe Beispiel der BZ Hannover: Plan der Bedienebene: Media:Plan Bedieneben BZH.pdf, Schematischer Plan der Strom- und Datenversorgung am Bedienplatz: Media:Plan Stromversorgung BPL BZH.pdf. 
 * 
 * <p>Java-Klasse f�r CBedien_Platz complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Platz">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bedien_Platz_Allg" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}CBedien_Platz_Allg"/>
 *         &lt;element name="ID_Anhang_Moebelplan_Aufriss" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang" minOccurs="0"/>
 *         &lt;element name="ID_Anhang_Moebelplan_Grundriss" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang" minOccurs="0"/>
 *         &lt;element name="ID_Unterbringung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Unterbringung"/>
 *         &lt;choice>
 *           &lt;element name="ID_Bedien_Bezirk" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Bedien_Bezirk"/>
 *           &lt;element name="ID_ESTW_Zentraleinheit" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ESTW_Zentraleinheit"/>
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
@XmlType(name = "CBedien_Platz", propOrder = {
    "bedienPlatzAllg",
    "idAnhangMoebelplanAufriss",
    "idAnhangMoebelplanGrundriss",
    "idUnterbringung",
    "idBedienBezirk",
    "idestwZentraleinheit"
})
public class CBedienPlatz
    extends CBasisObjekt
{

    @XmlElement(name = "Bedien_Platz_Allg", required = true)
    protected CBedienPlatzAllg bedienPlatzAllg;
    @XmlElement(name = "ID_Anhang_Moebelplan_Aufriss")
    protected TCIDAnhang idAnhangMoebelplanAufriss;
    @XmlElement(name = "ID_Anhang_Moebelplan_Grundriss")
    protected TCIDAnhang idAnhangMoebelplanGrundriss;
    @XmlElement(name = "ID_Unterbringung", required = true)
    protected TCIDUnterbringung idUnterbringung;
    @XmlElement(name = "ID_Bedien_Bezirk")
    protected TCIDBedienBezirk idBedienBezirk;
    @XmlElement(name = "ID_ESTW_Zentraleinheit")
    protected TCIDESTWZentraleinheit idestwZentraleinheit;

    /**
     * Ruft den Wert der bedienPlatzAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedienPlatzAllg }
     *     
     */
    public CBedienPlatzAllg getBedienPlatzAllg() {
        return bedienPlatzAllg;
    }

    /**
     * Legt den Wert der bedienPlatzAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedienPlatzAllg }
     *     
     */
    public void setBedienPlatzAllg(CBedienPlatzAllg value) {
        this.bedienPlatzAllg = value;
    }

    /**
     * Ruft den Wert der idAnhangMoebelplanAufriss-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangMoebelplanAufriss() {
        return idAnhangMoebelplanAufriss;
    }

    /**
     * Legt den Wert der idAnhangMoebelplanAufriss-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangMoebelplanAufriss(TCIDAnhang value) {
        this.idAnhangMoebelplanAufriss = value;
    }

    /**
     * Ruft den Wert der idAnhangMoebelplanGrundriss-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangMoebelplanGrundriss() {
        return idAnhangMoebelplanGrundriss;
    }

    /**
     * Legt den Wert der idAnhangMoebelplanGrundriss-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangMoebelplanGrundriss(TCIDAnhang value) {
        this.idAnhangMoebelplanGrundriss = value;
    }

    /**
     * Ruft den Wert der idUnterbringung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDUnterbringung }
     *     
     */
    public TCIDUnterbringung getIDUnterbringung() {
        return idUnterbringung;
    }

    /**
     * Legt den Wert der idUnterbringung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDUnterbringung }
     *     
     */
    public void setIDUnterbringung(TCIDUnterbringung value) {
        this.idUnterbringung = value;
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

    /**
     * Ruft den Wert der idestwZentraleinheit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDESTWZentraleinheit }
     *     
     */
    public TCIDESTWZentraleinheit getIDESTWZentraleinheit() {
        return idestwZentraleinheit;
    }

    /**
     * Legt den Wert der idestwZentraleinheit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDESTWZentraleinheit }
     *     
     */
    public void setIDESTWZentraleinheit(TCIDESTWZentraleinheit value) {
        this.idestwZentraleinheit = value;
    }

}
