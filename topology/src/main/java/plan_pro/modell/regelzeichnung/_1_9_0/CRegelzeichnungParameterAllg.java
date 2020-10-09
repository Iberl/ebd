//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.regelzeichnung._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CRegelzeichnung_Parameter_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CRegelzeichnung_Parameter_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RZ_Parameter_Name" type="{http://www.plan-pro.org/modell/Regelzeichnung/1.9.0.2}TCRZ_Parameter_Name"/>
 *         &lt;element name="RZ_Parameter_Wert" type="{http://www.plan-pro.org/modell/Regelzeichnung/1.9.0.2}TCRZ_Parameter_Wert"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRegelzeichnung_Parameter_Allg", propOrder = {
    "rzParameterName",
    "rzParameterWert"
})
public class CRegelzeichnungParameterAllg {

    @XmlElement(name = "RZ_Parameter_Name", required = true)
    protected TCRZParameterName rzParameterName;
    @XmlElement(name = "RZ_Parameter_Wert", required = true)
    protected TCRZParameterWert rzParameterWert;

    /**
     * Ruft den Wert der rzParameterName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRZParameterName }
     *     
     */
    public TCRZParameterName getRZParameterName() {
        return rzParameterName;
    }

    /**
     * Legt den Wert der rzParameterName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRZParameterName }
     *     
     */
    public void setRZParameterName(TCRZParameterName value) {
        this.rzParameterName = value;
    }

    /**
     * Ruft den Wert der rzParameterWert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRZParameterWert }
     *     
     */
    public TCRZParameterWert getRZParameterWert() {
        return rzParameterWert;
    }

    /**
     * Legt den Wert der rzParameterWert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRZParameterWert }
     *     
     */
    public void setRZParameterWert(TCRZParameterWert value) {
        this.rzParameterWert = value;
    }

}
