//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bahnuebergang._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDStellelement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Schnittstelle zwischen dem Planer des ESTW und dem Planer der technischen Sicherung des Bahn�bergangs. Im ESTW wird eine technische Schnittstelle f�r Hp-Abh�ngigkeiten zwischen ESTW und B� und/oder Fern�berwachung (F�) durch den �zF vorgesehen. Bau-B�, die �ber eine Schl�sselsperre gesichert werden, sowie nichttechnisch gesicherte B� erhalten keine BUE_Schnittstelle. DB-Regelwerk Die betreffenden Angaben finden sich im \"Datenblatt f�r die Abh�ngigkeiten B� - Stw\".
 * 
 * <p>Java-Klasse f�r CBUE_Schnittstelle complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Schnittstelle">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="BUE_Abhaengigkeit_Fue" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_Abhaengigkeit_Fue" minOccurs="0"/>
 *         &lt;element name="BUE_Abhaengigkeit_Hp" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_Abhaengigkeit_Hp" minOccurs="0"/>
 *         &lt;element name="BUE_Schnittstelle_Allg" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_Schnittstelle_Allg"/>
 *         &lt;element name="ID_Stellelement" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Stellelement"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Schnittstelle", propOrder = {
    "bueAbhaengigkeitFue",
    "bueAbhaengigkeitHp",
    "bueSchnittstelleAllg",
    "idStellelement"
})
public class CBUESchnittstelle
    extends CBasisObjekt
{

    @XmlElement(name = "BUE_Abhaengigkeit_Fue")
    protected CBUEAbhaengigkeitFue bueAbhaengigkeitFue;
    @XmlElement(name = "BUE_Abhaengigkeit_Hp")
    protected CBUEAbhaengigkeitHp bueAbhaengigkeitHp;
    @XmlElement(name = "BUE_Schnittstelle_Allg", required = true)
    protected CBUESchnittstelleAllg bueSchnittstelleAllg;
    @XmlElement(name = "ID_Stellelement", required = true)
    protected TCIDStellelement idStellelement;

    /**
     * Ruft den Wert der bueAbhaengigkeitFue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBUEAbhaengigkeitFue }
     *     
     */
    public CBUEAbhaengigkeitFue getBUEAbhaengigkeitFue() {
        return bueAbhaengigkeitFue;
    }

    /**
     * Legt den Wert der bueAbhaengigkeitFue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBUEAbhaengigkeitFue }
     *     
     */
    public void setBUEAbhaengigkeitFue(CBUEAbhaengigkeitFue value) {
        this.bueAbhaengigkeitFue = value;
    }

    /**
     * Ruft den Wert der bueAbhaengigkeitHp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBUEAbhaengigkeitHp }
     *     
     */
    public CBUEAbhaengigkeitHp getBUEAbhaengigkeitHp() {
        return bueAbhaengigkeitHp;
    }

    /**
     * Legt den Wert der bueAbhaengigkeitHp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBUEAbhaengigkeitHp }
     *     
     */
    public void setBUEAbhaengigkeitHp(CBUEAbhaengigkeitHp value) {
        this.bueAbhaengigkeitHp = value;
    }

    /**
     * Ruft den Wert der bueSchnittstelleAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBUESchnittstelleAllg }
     *     
     */
    public CBUESchnittstelleAllg getBUESchnittstelleAllg() {
        return bueSchnittstelleAllg;
    }

    /**
     * Legt den Wert der bueSchnittstelleAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBUESchnittstelleAllg }
     *     
     */
    public void setBUESchnittstelleAllg(CBUESchnittstelleAllg value) {
        this.bueSchnittstelleAllg = value;
    }

    /**
     * Ruft den Wert der idStellelement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDStellelement }
     *     
     */
    public TCIDStellelement getIDStellelement() {
        return idStellelement;
    }

    /**
     * Legt den Wert der idStellelement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDStellelement }
     *     
     */
    public void setIDStellelement(TCIDStellelement value) {
        this.idStellelement = value;
    }

}
