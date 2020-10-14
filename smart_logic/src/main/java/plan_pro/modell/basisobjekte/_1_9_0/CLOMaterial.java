//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basisobjekte._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CLO_Material complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLO_Material">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LO_Ausgabestand" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCLO_Ausgabestand"/>
 *         &lt;element name="LO_Datum_Herstellung" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCLO_Datum_Herstellung"/>
 *         &lt;element name="LO_DB_Freigabe" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCLO_DB_Freigabe"/>
 *         &lt;element name="LO_EMA_Nr" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCLO_EMA_Nr"/>
 *         &lt;element name="LO_Firmensachnummer" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCLO_Firmensachnummer"/>
 *         &lt;element name="LO_Seriennummer" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCLO_Seriennummer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLO_Material", propOrder = {
    "loAusgabestand",
    "loDatumHerstellung",
    "lodbFreigabe",
    "loemaNr",
    "loFirmensachnummer",
    "loSeriennummer"
})
public class CLOMaterial {

    @XmlElement(name = "LO_Ausgabestand", required = true)
    protected TCLOAusgabestand loAusgabestand;
    @XmlElement(name = "LO_Datum_Herstellung", required = true)
    protected TCLODatumHerstellung loDatumHerstellung;
    @XmlElement(name = "LO_DB_Freigabe", required = true)
    protected TCLODBFreigabe lodbFreigabe;
    @XmlElement(name = "LO_EMA_Nr", required = true)
    protected TCLOEMANr loemaNr;
    @XmlElement(name = "LO_Firmensachnummer", required = true)
    protected TCLOFirmensachnummer loFirmensachnummer;
    @XmlElement(name = "LO_Seriennummer", required = true)
    protected TCLOSeriennummer loSeriennummer;

    /**
     * Ruft den Wert der loAusgabestand-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLOAusgabestand }
     *     
     */
    public TCLOAusgabestand getLOAusgabestand() {
        return loAusgabestand;
    }

    /**
     * Legt den Wert der loAusgabestand-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLOAusgabestand }
     *     
     */
    public void setLOAusgabestand(TCLOAusgabestand value) {
        this.loAusgabestand = value;
    }

    /**
     * Ruft den Wert der loDatumHerstellung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLODatumHerstellung }
     *     
     */
    public TCLODatumHerstellung getLODatumHerstellung() {
        return loDatumHerstellung;
    }

    /**
     * Legt den Wert der loDatumHerstellung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLODatumHerstellung }
     *     
     */
    public void setLODatumHerstellung(TCLODatumHerstellung value) {
        this.loDatumHerstellung = value;
    }

    /**
     * Ruft den Wert der lodbFreigabe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLODBFreigabe }
     *     
     */
    public TCLODBFreigabe getLODBFreigabe() {
        return lodbFreigabe;
    }

    /**
     * Legt den Wert der lodbFreigabe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLODBFreigabe }
     *     
     */
    public void setLODBFreigabe(TCLODBFreigabe value) {
        this.lodbFreigabe = value;
    }

    /**
     * Ruft den Wert der loemaNr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLOEMANr }
     *     
     */
    public TCLOEMANr getLOEMANr() {
        return loemaNr;
    }

    /**
     * Legt den Wert der loemaNr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLOEMANr }
     *     
     */
    public void setLOEMANr(TCLOEMANr value) {
        this.loemaNr = value;
    }

    /**
     * Ruft den Wert der loFirmensachnummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLOFirmensachnummer }
     *     
     */
    public TCLOFirmensachnummer getLOFirmensachnummer() {
        return loFirmensachnummer;
    }

    /**
     * Legt den Wert der loFirmensachnummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLOFirmensachnummer }
     *     
     */
    public void setLOFirmensachnummer(TCLOFirmensachnummer value) {
        this.loFirmensachnummer = value;
    }

    /**
     * Ruft den Wert der loSeriennummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLOSeriennummer }
     *     
     */
    public TCLOSeriennummer getLOSeriennummer() {
        return loSeriennummer;
    }

    /**
     * Legt den Wert der loSeriennummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLOSeriennummer }
     *     
     */
    public void setLOSeriennummer(TCLOSeriennummer value) {
        this.loSeriennummer = value;
    }

}
