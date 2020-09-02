//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bahnuebergang._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Objekt zur Definition der logischen Bedienfunktionen, die �ber Taster auf den B� einwirken. Es dient der Zuordnung der ausgew�hlten Bedienfunktionen zum B� bzw. zu den Ein-/Ausschaltungen des zugeh�rigen Gleises. Die Zuordnung zur physischen Unterbringung erfolgt �ber den Verweis auf Bedien Anzeige Element. DB-Regelwerk 819.1204 8 TM 2012 - 001 I.NVT 3 
 * 
 * <p>Java-Klasse f�r CBUE_Bedien_Anzeige_Element complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Bedien_Anzeige_Element">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="BUE_Bedien_Anz_Element_Allg" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_Bedien_Anz_Element_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Bedien_Anzeige_Element", propOrder = {
    "bueBedienAnzElementAllg"
})
public class CBUEBedienAnzeigeElement
    extends CBasisObjekt
{

    @XmlElement(name = "BUE_Bedien_Anz_Element_Allg", required = true)
    protected CBUEBedienAnzElementAllg bueBedienAnzElementAllg;

    /**
     * Ruft den Wert der bueBedienAnzElementAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBUEBedienAnzElementAllg }
     *     
     */
    public CBUEBedienAnzElementAllg getBUEBedienAnzElementAllg() {
        return bueBedienAnzElementAllg;
    }

    /**
     * Legt den Wert der bueBedienAnzElementAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBUEBedienAnzElementAllg }
     *     
     */
    public void setBUEBedienAnzElementAllg(CBUEBedienAnzElementAllg value) {
        this.bueBedienAnzElementAllg = value;
    }

}
