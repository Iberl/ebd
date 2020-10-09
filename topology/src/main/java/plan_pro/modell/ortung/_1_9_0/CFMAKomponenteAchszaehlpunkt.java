//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ortung._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDAussenelementansteuerung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFMA_Komponente_Achszaehlpunkt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFMA_Komponente_Achszaehlpunkt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FMA_Komponente_Schienenprofil" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCFMA_Komponente_Schienenprofil" minOccurs="0"/>
 *         &lt;element name="FMA_Komponente_Stromversorgung" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCFMA_Komponente_Stromversorgung"/>
 *         &lt;element name="FMA_Komponente_Typ" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCFMA_Komponente_Typ" minOccurs="0"/>
 *         &lt;element name="ID_Energie" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Aussenelementansteuerung"/>
 *         &lt;element name="ID_Information" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Aussenelementansteuerung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFMA_Komponente_Achszaehlpunkt", propOrder = {
    "fmaKomponenteSchienenprofil",
    "fmaKomponenteStromversorgung",
    "fmaKomponenteTyp",
    "idEnergie",
    "idInformation"
})
public class CFMAKomponenteAchszaehlpunkt {

    @XmlElement(name = "FMA_Komponente_Schienenprofil")
    protected TCFMAKomponenteSchienenprofil fmaKomponenteSchienenprofil;
    @XmlElement(name = "FMA_Komponente_Stromversorgung", required = true)
    protected TCFMAKomponenteStromversorgung fmaKomponenteStromversorgung;
    @XmlElement(name = "FMA_Komponente_Typ")
    protected TCFMAKomponenteTyp fmaKomponenteTyp;
    @XmlElement(name = "ID_Energie", required = true)
    protected TCIDAussenelementansteuerung idEnergie;
    @XmlElement(name = "ID_Information", required = true)
    protected TCIDAussenelementansteuerung idInformation;

    /**
     * Ruft den Wert der fmaKomponenteSchienenprofil-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMAKomponenteSchienenprofil }
     *     
     */
    public TCFMAKomponenteSchienenprofil getFMAKomponenteSchienenprofil() {
        return fmaKomponenteSchienenprofil;
    }

    /**
     * Legt den Wert der fmaKomponenteSchienenprofil-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMAKomponenteSchienenprofil }
     *     
     */
    public void setFMAKomponenteSchienenprofil(TCFMAKomponenteSchienenprofil value) {
        this.fmaKomponenteSchienenprofil = value;
    }

    /**
     * Ruft den Wert der fmaKomponenteStromversorgung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMAKomponenteStromversorgung }
     *     
     */
    public TCFMAKomponenteStromversorgung getFMAKomponenteStromversorgung() {
        return fmaKomponenteStromversorgung;
    }

    /**
     * Legt den Wert der fmaKomponenteStromversorgung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMAKomponenteStromversorgung }
     *     
     */
    public void setFMAKomponenteStromversorgung(TCFMAKomponenteStromversorgung value) {
        this.fmaKomponenteStromversorgung = value;
    }

    /**
     * Ruft den Wert der fmaKomponenteTyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFMAKomponenteTyp }
     *     
     */
    public TCFMAKomponenteTyp getFMAKomponenteTyp() {
        return fmaKomponenteTyp;
    }

    /**
     * Legt den Wert der fmaKomponenteTyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFMAKomponenteTyp }
     *     
     */
    public void setFMAKomponenteTyp(TCFMAKomponenteTyp value) {
        this.fmaKomponenteTyp = value;
    }

    /**
     * Ruft den Wert der idEnergie-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public TCIDAussenelementansteuerung getIDEnergie() {
        return idEnergie;
    }

    /**
     * Legt den Wert der idEnergie-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public void setIDEnergie(TCIDAussenelementansteuerung value) {
        this.idEnergie = value;
    }

    /**
     * Ruft den Wert der idInformation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public TCIDAussenelementansteuerung getIDInformation() {
        return idInformation;
    }

    /**
     * Legt den Wert der idInformation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public void setIDInformation(TCIDAussenelementansteuerung value) {
        this.idInformation = value;
    }

}
