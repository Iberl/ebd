//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.planpro._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CPlanung_P_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPlanung_P_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_Planung_Projekt" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCBezeichnung_Planung_Projekt"/>
 *         &lt;element name="Datum_Abschluss_Projekt" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCDatum_Abschluss_Projekt" minOccurs="0"/>
 *         &lt;element name="Projekt_Nummer" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCProjekt_Nummer" minOccurs="0"/>
 *         &lt;element name="Projektleiter" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CAkteur" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPlanung_P_Allg", propOrder = {
    "bezeichnungPlanungProjekt",
    "datumAbschlussProjekt",
    "projektNummer",
    "projektleiter"
})
public class CPlanungPAllg {

    @XmlElement(name = "Bezeichnung_Planung_Projekt", required = true)
    protected TCBezeichnungPlanungProjekt bezeichnungPlanungProjekt;
    @XmlElement(name = "Datum_Abschluss_Projekt")
    protected TCDatumAbschlussProjekt datumAbschlussProjekt;
    @XmlElement(name = "Projekt_Nummer")
    protected TCProjektNummer projektNummer;
    @XmlElement(name = "Projektleiter")
    protected CAkteur projektleiter;

    /**
     * Ruft den Wert der bezeichnungPlanungProjekt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungPlanungProjekt }
     *     
     */
    public TCBezeichnungPlanungProjekt getBezeichnungPlanungProjekt() {
        return bezeichnungPlanungProjekt;
    }

    /**
     * Legt den Wert der bezeichnungPlanungProjekt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungPlanungProjekt }
     *     
     */
    public void setBezeichnungPlanungProjekt(TCBezeichnungPlanungProjekt value) {
        this.bezeichnungPlanungProjekt = value;
    }

    /**
     * Ruft den Wert der datumAbschlussProjekt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDatumAbschlussProjekt }
     *     
     */
    public TCDatumAbschlussProjekt getDatumAbschlussProjekt() {
        return datumAbschlussProjekt;
    }

    /**
     * Legt den Wert der datumAbschlussProjekt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDatumAbschlussProjekt }
     *     
     */
    public void setDatumAbschlussProjekt(TCDatumAbschlussProjekt value) {
        this.datumAbschlussProjekt = value;
    }

    /**
     * Ruft den Wert der projektNummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCProjektNummer }
     *     
     */
    public TCProjektNummer getProjektNummer() {
        return projektNummer;
    }

    /**
     * Legt den Wert der projektNummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCProjektNummer }
     *     
     */
    public void setProjektNummer(TCProjektNummer value) {
        this.projektNummer = value;
    }

    /**
     * Ruft den Wert der projektleiter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CAkteur }
     *     
     */
    public CAkteur getProjektleiter() {
        return projektleiter;
    }

    /**
     * Legt den Wert der projektleiter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CAkteur }
     *     
     */
    public void setProjektleiter(CAkteur value) {
        this.projektleiter = value;
    }

}
