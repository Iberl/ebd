//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.schluesselabhaengigkeiten._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDSonderanlage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSchloss_Sonderanlage complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchloss_Sonderanlage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Beschreibung_Sonderanlage" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}TCBeschreibung_Sonderanlage"/>
 *           &lt;element name="ID_Sonderanlage" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Sonderanlage"/>
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
@XmlType(name = "CSchloss_Sonderanlage", propOrder = {
    "beschreibungSonderanlage",
    "idSonderanlage"
})
public class CSchlossSonderanlage {

    @XmlElement(name = "Beschreibung_Sonderanlage")
    protected TCBeschreibungSonderanlage beschreibungSonderanlage;
    @XmlElement(name = "ID_Sonderanlage")
    protected TCIDSonderanlage idSonderanlage;

    /**
     * Ruft den Wert der beschreibungSonderanlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBeschreibungSonderanlage }
     *     
     */
    public TCBeschreibungSonderanlage getBeschreibungSonderanlage() {
        return beschreibungSonderanlage;
    }

    /**
     * Legt den Wert der beschreibungSonderanlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBeschreibungSonderanlage }
     *     
     */
    public void setBeschreibungSonderanlage(TCBeschreibungSonderanlage value) {
        this.beschreibungSonderanlage = value;
    }

    /**
     * Ruft den Wert der idSonderanlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSonderanlage }
     *     
     */
    public TCIDSonderanlage getIDSonderanlage() {
        return idSonderanlage;
    }

    /**
     * Legt den Wert der idSonderanlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSonderanlage }
     *     
     */
    public void setIDSonderanlage(TCIDSonderanlage value) {
        this.idSonderanlage = value;
    }

}
