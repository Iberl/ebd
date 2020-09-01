//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.signale._1_8;

import modell.verweise._1_8.TCIDSchaltmittelZuordnung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSignal_Fstr_S complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_Fstr_S">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Gegengleis" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCGegengleis" minOccurs="0"/>
 *         &lt;element name="ID_Anrueckverschluss" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Schaltmittel_Zuordnung" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_Fstr_S", propOrder = {
    "gegengleis",
    "idAnrueckverschluss"
})
public class CSignalFstrS {

    @XmlElement(name = "Gegengleis")
    protected TCGegengleis gegengleis;
    @XmlElement(name = "ID_Anrueckverschluss")
    protected TCIDSchaltmittelZuordnung idAnrueckverschluss;

    /**
     * Ruft den Wert der gegengleis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGegengleis }
     *     
     */
    public TCGegengleis getGegengleis() {
        return gegengleis;
    }

    /**
     * Legt den Wert der gegengleis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGegengleis }
     *     
     */
    public void setGegengleis(TCGegengleis value) {
        this.gegengleis = value;
    }

    /**
     * Ruft den Wert der idAnrueckverschluss-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSchaltmittelZuordnung }
     *     
     */
    public TCIDSchaltmittelZuordnung getIDAnrueckverschluss() {
        return idAnrueckverschluss;
    }

    /**
     * Legt den Wert der idAnrueckverschluss-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSchaltmittelZuordnung }
     *     
     */
    public void setIDAnrueckverschluss(TCIDSchaltmittelZuordnung value) {
        this.idAnrueckverschluss = value;
    }

}
