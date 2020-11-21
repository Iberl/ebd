//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.weichen_und_gleissperren._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDAnhang;
import plan_pro.modell.verweise._1_9_0.TCIDSignal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Bauliche Gesamtheit des Objektes Weiche oder Kreuzung einschlie�lich der f�r seine Funktion unmittelbar und in der N�he vorhandenen Stell-, Steuer- und �berwachungseinrichtungen. Typische Grundformen der Weichenanlagen sind: einfache Weiche (EW), einfache Kreuzungsweiche (EKW), doppelte Kreuzungsweiche (DKW), starre Kreuzung (KR) und Flachkreuzungen mit doppelten Herzst�cken und beweglichen Spitzen (KR). Grundlage der Bezeichnungen ist die Ril 800.0120 in Verbindung mit den zugeh�rigen Anlagen. Weichenanlagen werden unterteilt in die einzelnen Elemente (Weichenelement). Die Elemente besitzen eine oder mehrere Komponenten (Weichenkomponente). Diese Objekte beschreiben in Verbindung mit Regelzeichnungen weitere Eigenschaften (z.B. Antriebe und Endlagenpr�fer) der Weichenanlage. Siehe auch Modellierung Weichen. DB-Regelwerk Ril 800.0120 
 * 
 * <p>Java-Klasse f�r CW_Kr_Anlage complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CW_Kr_Anlage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Anhang_DWS" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang" minOccurs="0"/>
 *         &lt;element name="ID_Signal" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal" minOccurs="0"/>
 *         &lt;element name="W_Kr_Anlage_Allg" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}CW_Kr_Anlage_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CW_Kr_Anlage", propOrder = {
    "idAnhangDWS",
    "idSignal",
    "wKrAnlageAllg"
})
public class CWKrAnlage
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Anhang_DWS")
    protected TCIDAnhang idAnhangDWS;
    @XmlElement(name = "ID_Signal")
    protected TCIDSignal idSignal;
    @XmlElement(name = "W_Kr_Anlage_Allg", required = true)
    protected CWKrAnlageAllg wKrAnlageAllg;

    /**
     * Ruft den Wert der idAnhangDWS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangDWS() {
        return idAnhangDWS;
    }

    /**
     * Legt den Wert der idAnhangDWS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangDWS(TCIDAnhang value) {
        this.idAnhangDWS = value;
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

    /**
     * Ruft den Wert der wKrAnlageAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CWKrAnlageAllg }
     *     
     */
    public CWKrAnlageAllg getWKrAnlageAllg() {
        return wKrAnlageAllg;
    }

    /**
     * Legt den Wert der wKrAnlageAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CWKrAnlageAllg }
     *     
     */
    public void setWKrAnlageAllg(CWKrAnlageAllg value) {
        this.wKrAnlageAllg = value;
    }

}
