//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CLEU_Schaltkasten_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLEU_Schaltkasten_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nummer_Schaltkasten" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCNummer_Schaltkasten"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLEU_Schaltkasten_Bezeichnung", propOrder = {
    "nummerSchaltkasten"
})
public class CLEUSchaltkastenBezeichnung {

    @XmlElement(name = "Nummer_Schaltkasten", required = true)
    protected TCNummerSchaltkasten nummerSchaltkasten;

    /**
     * Ruft den Wert der nummerSchaltkasten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNummerSchaltkasten }
     *     
     */
    public TCNummerSchaltkasten getNummerSchaltkasten() {
        return nummerSchaltkasten;
    }

    /**
     * Legt den Wert der nummerSchaltkasten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNummerSchaltkasten }
     *     
     */
    public void setNummerSchaltkasten(TCNummerSchaltkasten value) {
        this.nummerSchaltkasten = value;
    }

}
