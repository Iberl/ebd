//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDSchluesselsperre;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFstr_Abhaengigkeit_Ssp complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Abhaengigkeit_Ssp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Aufloesung_Ssp_Zielgeis" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCAufloesung_Ssp_Zielgeis" minOccurs="0"/>
 *         &lt;element name="ID_Schluesselsperre" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Schluesselsperre"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_Abhaengigkeit_Ssp", propOrder = {
    "aufloesungSspZielgeis",
    "idSchluesselsperre"
})
public class CFstrAbhaengigkeitSsp {

    @XmlElement(name = "Aufloesung_Ssp_Zielgeis")
    protected TCAufloesungSspZielgeis aufloesungSspZielgeis;
    @XmlElement(name = "ID_Schluesselsperre", required = true)
    protected TCIDSchluesselsperre idSchluesselsperre;

    /**
     * Ruft den Wert der aufloesungSspZielgeis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAufloesungSspZielgeis }
     *     
     */
    public TCAufloesungSspZielgeis getAufloesungSspZielgeis() {
        return aufloesungSspZielgeis;
    }

    /**
     * Legt den Wert der aufloesungSspZielgeis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAufloesungSspZielgeis }
     *     
     */
    public void setAufloesungSspZielgeis(TCAufloesungSspZielgeis value) {
        this.aufloesungSspZielgeis = value;
    }

    /**
     * Ruft den Wert der idSchluesselsperre-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSchluesselsperre }
     *     
     */
    public TCIDSchluesselsperre getIDSchluesselsperre() {
        return idSchluesselsperre;
    }

    /**
     * Legt den Wert der idSchluesselsperre-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSchluesselsperre }
     *     
     */
    public void setIDSchluesselsperre(TCIDSchluesselsperre value) {
        this.idSchluesselsperre = value;
    }

}
