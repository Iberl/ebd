//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDUnterbringung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Bei DSTW: Standort, von dem die Bedienung der DSTW erfolgt. Von einem Bedienstandort k�nnen mehrere Technikstandorte bedient werden.
 * 
 * <p>Java-Klasse f�r CBedien_Standort complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Standort">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}CBedien_Standort_Bezeichnung"/>
 *         &lt;element name="BSO_IP_Adressblock" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}CBSO_IP_Adressblock" minOccurs="0"/>
 *         &lt;element name="ID_Unterbringung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Unterbringung"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Standort", propOrder = {
    "bezeichnung",
    "bsoipAdressblock",
    "idUnterbringung"
})
public class CBedienStandort
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CBedienStandortBezeichnung bezeichnung;
    @XmlElement(name = "BSO_IP_Adressblock")
    protected CBSOIPAdressblock bsoipAdressblock;
    @XmlElement(name = "ID_Unterbringung", required = true)
    protected TCIDUnterbringung idUnterbringung;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedienStandortBezeichnung }
     *     
     */
    public CBedienStandortBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedienStandortBezeichnung }
     *     
     */
    public void setBezeichnung(CBedienStandortBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der bsoipAdressblock-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBSOIPAdressblock }
     *     
     */
    public CBSOIPAdressblock getBSOIPAdressblock() {
        return bsoipAdressblock;
    }

    /**
     * Legt den Wert der bsoipAdressblock-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBSOIPAdressblock }
     *     
     */
    public void setBSOIPAdressblock(CBSOIPAdressblock value) {
        this.bsoipAdressblock = value;
    }

    /**
     * Ruft den Wert der idUnterbringung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDUnterbringung }
     *     
     */
    public TCIDUnterbringung getIDUnterbringung() {
        return idUnterbringung;
    }

    /**
     * Legt den Wert der idUnterbringung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDUnterbringung }
     *     
     */
    public void setIDUnterbringung(TCIDUnterbringung value) {
        this.idUnterbringung = value;
    }

}
