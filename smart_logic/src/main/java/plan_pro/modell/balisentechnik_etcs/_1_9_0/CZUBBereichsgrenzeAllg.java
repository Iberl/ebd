//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDElementGrenze;
import plan_pro.modell.verweise._1_9_0.TCIDRBC;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CZUB_Bereichsgrenze_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZUB_Bereichsgrenze_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Element_Grenze" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Element_Grenze"/>
 *         &lt;element name="ID_RBC_Vor_Grenze" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_RBC" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="System_Vor_Grenze" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCSystem_Vor_Grenze" maxOccurs="unbounded"/>
 *           &lt;element name="System_Vor_Grenze_Besonders" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCSystem_Vor_Grenze_Besonders" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZUB_Bereichsgrenze_Allg", propOrder = {
    "idElementGrenze",
    "idrbcVorGrenze",
    "systemVorGrenze",
    "systemVorGrenzeBesonders"
})
public class CZUBBereichsgrenzeAllg {

    @XmlElement(name = "ID_Element_Grenze", required = true)
    protected TCIDElementGrenze idElementGrenze;
    @XmlElement(name = "ID_RBC_Vor_Grenze")
    protected TCIDRBC idrbcVorGrenze;
    @XmlElement(name = "System_Vor_Grenze")
    protected List<TCSystemVorGrenze> systemVorGrenze;
    @XmlElement(name = "System_Vor_Grenze_Besonders")
    protected List<TCSystemVorGrenzeBesonders> systemVorGrenzeBesonders;

    /**
     * Ruft den Wert der idElementGrenze-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDElementGrenze }
     *     
     */
    public TCIDElementGrenze getIDElementGrenze() {
        return idElementGrenze;
    }

    /**
     * Legt den Wert der idElementGrenze-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDElementGrenze }
     *     
     */
    public void setIDElementGrenze(TCIDElementGrenze value) {
        this.idElementGrenze = value;
    }

    /**
     * Ruft den Wert der idrbcVorGrenze-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDRBC }
     *     
     */
    public TCIDRBC getIDRBCVorGrenze() {
        return idrbcVorGrenze;
    }

    /**
     * Legt den Wert der idrbcVorGrenze-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDRBC }
     *     
     */
    public void setIDRBCVorGrenze(TCIDRBC value) {
        this.idrbcVorGrenze = value;
    }

    /**
     * Gets the value of the systemVorGrenze property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the systemVorGrenze property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSystemVorGrenze().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCSystemVorGrenze }
     * 
     * 
     */
    public List<TCSystemVorGrenze> getSystemVorGrenze() {
        if (systemVorGrenze == null) {
            systemVorGrenze = new ArrayList<TCSystemVorGrenze>();
        }
        return this.systemVorGrenze;
    }

    /**
     * Gets the value of the systemVorGrenzeBesonders property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the systemVorGrenzeBesonders property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSystemVorGrenzeBesonders().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCSystemVorGrenzeBesonders }
     * 
     * 
     */
    public List<TCSystemVorGrenzeBesonders> getSystemVorGrenzeBesonders() {
        if (systemVorGrenzeBesonders == null) {
            systemVorGrenzeBesonders = new ArrayList<TCSystemVorGrenzeBesonders>();
        }
        return this.systemVorGrenzeBesonders;
    }

}
