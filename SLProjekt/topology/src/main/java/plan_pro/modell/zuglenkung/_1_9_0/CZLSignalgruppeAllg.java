//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zuglenkung._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZL_Signalgruppe_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZL_Signalgruppe_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Signalgruppe_Bezeichner" type="{http://www.plan-pro.org/modell/Zuglenkung/1.9.0.2}TCSignalgruppe_Bezeichner" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZL_Signalgruppe_Allg", propOrder = {
    "signalgruppeBezeichner"
})
public class CZLSignalgruppeAllg {

    @XmlElement(name = "Signalgruppe_Bezeichner")
    protected TCSignalgruppeBezeichner signalgruppeBezeichner;

    /**
     * Ruft den Wert der signalgruppeBezeichner-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSignalgruppeBezeichner }
     *     
     */
    public TCSignalgruppeBezeichner getSignalgruppeBezeichner() {
        return signalgruppeBezeichner;
    }

    /**
     * Legt den Wert der signalgruppeBezeichner-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSignalgruppeBezeichner }
     *     
     */
    public void setSignalgruppeBezeichner(TCSignalgruppeBezeichner value) {
        this.signalgruppeBezeichner = value;
    }

}
