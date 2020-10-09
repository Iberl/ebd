//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.basisobjekte._1_8;

import modell.verweise._1_8.TCIDAnhang;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBasis_Objekt_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBasis_Objekt_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Objektzustand_Besonders" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}TCObjektzustand_Besonders" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Datum_Regelwerk" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}TCDatum_Regelwerk"/>
 *           &lt;element name="ID_Anhang_Regelwerk_Besonders" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Anhang"/>
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
@XmlType(name = "CBasis_Objekt_Allg", propOrder = {
    "objektzustandBesonders",
    "datumRegelwerk",
    "idAnhangRegelwerkBesonders"
})
public class CBasisObjektAllg {

    @XmlElement(name = "Objektzustand_Besonders")
    protected TCObjektzustandBesonders objektzustandBesonders;
    @XmlElement(name = "Datum_Regelwerk")
    protected TCDatumRegelwerk datumRegelwerk;
    @XmlElement(name = "ID_Anhang_Regelwerk_Besonders")
    protected TCIDAnhang idAnhangRegelwerkBesonders;

    /**
     * Ruft den Wert der objektzustandBesonders-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCObjektzustandBesonders }
     *     
     */
    public TCObjektzustandBesonders getObjektzustandBesonders() {
        return objektzustandBesonders;
    }

    /**
     * Legt den Wert der objektzustandBesonders-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCObjektzustandBesonders }
     *     
     */
    public void setObjektzustandBesonders(TCObjektzustandBesonders value) {
        this.objektzustandBesonders = value;
    }

    /**
     * Ruft den Wert der datumRegelwerk-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDatumRegelwerk }
     *     
     */
    public TCDatumRegelwerk getDatumRegelwerk() {
        return datumRegelwerk;
    }

    /**
     * Legt den Wert der datumRegelwerk-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDatumRegelwerk }
     *     
     */
    public void setDatumRegelwerk(TCDatumRegelwerk value) {
        this.datumRegelwerk = value;
    }

    /**
     * Ruft den Wert der idAnhangRegelwerkBesonders-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangRegelwerkBesonders() {
        return idAnhangRegelwerkBesonders;
    }

    /**
     * Legt den Wert der idAnhangRegelwerkBesonders-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangRegelwerkBesonders(TCIDAnhang value) {
        this.idAnhangRegelwerkBesonders = value;
    }

}
