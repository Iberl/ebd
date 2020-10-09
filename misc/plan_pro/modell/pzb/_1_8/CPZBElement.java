//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.pzb._1_8;

import modell.basisobjekte._1_8.CPunktObjekt;
import modell.verweise._1_8.TCIDPZBElementZuordnung;
import modell.verweise._1_8.TCIDStellelement;
import modell.verweise._1_8.TCIDUnterbringung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * (Bau)Art, Umfang und Funktionen der punktf�rmigen Zugbeeinflussung. Unter dem PZB_Element werden sowohl einzelne Gleismagneten als auch die Geschwindigkeits�berwachungseinrichtungen (G� - in der Literatur auch als Geschwindigkeitspr�feinrichtungen - GPE bezeichnet) sowie dazugeh�rige Eigenschaften und Parameter zusammenfassend dargestellt. DB-Regelwerk 819.1310 8 f�r Gleismagnete 819.1310 9 f�r G� In der Gleismagenttabelle finden sich die Angaben in den Zeilen 16 und 17 sowie 33 bis 35 f�r G� und 29 bis 32 f�r Gleismagnete.
 * 
 * <p>Java-Klasse f�r CPZB_Element complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPZB_Element">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_PZB_Element_Zuordnung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_PZB_Element_Zuordnung"/>
 *         &lt;element name="PZB_Art" type="{http://www.plan-pro.org/modell/PZB/1.8.0}TCPZB_Art"/>
 *         &lt;element name="PZB_Element_GM" type="{http://www.plan-pro.org/modell/PZB/1.8.0}CPZB_Element_GM" minOccurs="0"/>
 *         &lt;element name="PZB_Element_GUE" type="{http://www.plan-pro.org/modell/PZB/1.8.0}CPZB_Element_GUE" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="ID_Stellelement" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Stellelement" minOccurs="0"/>
 *           &lt;element name="ID_Unterbringung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Unterbringung" minOccurs="0"/>
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
@XmlType(name = "CPZB_Element", propOrder = {
    "idpzbElementZuordnung",
    "pzbArt",
    "pzbElementGM",
    "pzbElementGUE",
    "idStellelement",
    "idUnterbringung"
})
public class CPZBElement
    extends CPunktObjekt
{

    @XmlElement(name = "ID_PZB_Element_Zuordnung", required = true)
    protected TCIDPZBElementZuordnung idpzbElementZuordnung;
    @XmlElement(name = "PZB_Art", required = true)
    protected TCPZBArt pzbArt;
    @XmlElement(name = "PZB_Element_GM")
    protected CPZBElementGM pzbElementGM;
    @XmlElement(name = "PZB_Element_GUE")
    protected CPZBElementGUE pzbElementGUE;
    @XmlElement(name = "ID_Stellelement")
    protected TCIDStellelement idStellelement;
    @XmlElement(name = "ID_Unterbringung")
    protected TCIDUnterbringung idUnterbringung;

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
     * Ruft den Wert der pzbArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPZBArt }
     *     
     */
    public TCPZBArt getPZBArt() {
        return pzbArt;
    }

    /**
     * Legt den Wert der pzbArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPZBArt }
     *     
     */
    public void setPZBArt(TCPZBArt value) {
        this.pzbArt = value;
    }

    /**
     * Ruft den Wert der pzbElementGM-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPZBElementGM }
     *     
     */
    public CPZBElementGM getPZBElementGM() {
        return pzbElementGM;
    }

    /**
     * Legt den Wert der pzbElementGM-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPZBElementGM }
     *     
     */
    public void setPZBElementGM(CPZBElementGM value) {
        this.pzbElementGM = value;
    }

    /**
     * Ruft den Wert der pzbElementGUE-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPZBElementGUE }
     *     
     */
    public CPZBElementGUE getPZBElementGUE() {
        return pzbElementGUE;
    }

    /**
     * Legt den Wert der pzbElementGUE-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPZBElementGUE }
     *     
     */
    public void setPZBElementGUE(CPZBElementGUE value) {
        this.pzbElementGUE = value;
    }

    /**
     * Ruft den Wert der idStellelement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDStellelement }
     *     
     */
    public TCIDStellelement getIDStellelement() {
        return idStellelement;
    }

    /**
     * Legt den Wert der idStellelement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDStellelement }
     *     
     */
    public void setIDStellelement(TCIDStellelement value) {
        this.idStellelement = value;
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

}
