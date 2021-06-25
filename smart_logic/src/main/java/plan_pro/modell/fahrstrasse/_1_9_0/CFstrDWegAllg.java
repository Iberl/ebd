//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFstr_DWeg_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_DWeg_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Laenge_Soll" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCLaenge_Soll"/>
 *         &lt;element name="Massgebende_Neigung" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCMassgebende_Neigung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_DWeg_Allg", propOrder = {
    "laengeSoll",
    "massgebendeNeigung"
})
public class CFstrDWegAllg {

    @XmlElement(name = "Laenge_Soll", required = true)
    protected TCLaengeSoll laengeSoll;
    @XmlElement(name = "Massgebende_Neigung", required = true)
    protected TCMassgebendeNeigung massgebendeNeigung;

    /**
     * Ruft den Wert der laengeSoll-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLaengeSoll }
     *     
     */
    public TCLaengeSoll getLaengeSoll() {
        return laengeSoll;
    }

    /**
     * Legt den Wert der laengeSoll-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLaengeSoll }
     *     
     */
    public void setLaengeSoll(TCLaengeSoll value) {
        this.laengeSoll = value;
    }

    /**
     * Ruft den Wert der massgebendeNeigung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMassgebendeNeigung }
     *     
     */
    public TCMassgebendeNeigung getMassgebendeNeigung() {
        return massgebendeNeigung;
    }

    /**
     * Legt den Wert der massgebendeNeigung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMassgebendeNeigung }
     *     
     */
    public void setMassgebendeNeigung(TCMassgebendeNeigung value) {
        this.massgebendeNeigung = value;
    }

}
