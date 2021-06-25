//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.schluesselabhaengigkeiten._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.basistypen._1_9_0.CBezeichnungElement;
import plan_pro.modell.verweise._1_9_0.TCIDStellelement;
import plan_pro.modell.verweise._1_9_0.TCIDUnterbringung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Elektromechanisches Bauelement, das die Anwesenheit eines Schl�ssels pr�ft, ihn festh�lt und eine Abh�ngigkeit zur Stellwerkslogik besitzt. Schl�sselsperren dienen der Festhaltung bzw. Freigabe von Schl�sseln, mit denen in der Regel weitere Elemente bedienbar gemacht werden. In Einzelf�llen dienen Schl�sselsperren nur als Schl�sselschalter. Die Darstellung im Lageplan erfolgt am Ort der Bedienung (z. B. Stellwerk, sonstiges Geb�ude), der durch die Unterbringung beschrieben wird. Eine Darstellung am oder auf dem Gleis erfolgt nicht! DB-Regelwerk Darstellung durch Zeichnung im Lageplan nach 819.9002 2.
 * 
 * <p>Java-Klasse f�r CSchluesselsperre complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchluesselsperre">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bedienung_Art" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}TCBedienung_Art"/>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}CBezeichnung_Element"/>
 *         &lt;element name="ID_Stellelement" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Stellelement"/>
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
@XmlType(name = "CSchluesselsperre", propOrder = {
    "bedienungArt",
    "bezeichnung",
    "idStellelement",
    "idUnterbringung"
})
public class CSchluesselsperre
    extends CBasisObjekt
{

    @XmlElement(name = "Bedienung_Art", required = true)
    protected TCBedienungArt bedienungArt;
    @XmlElement(name = "Bezeichnung", required = true)
    protected CBezeichnungElement bezeichnung;
    @XmlElement(name = "ID_Stellelement", required = true)
    protected TCIDStellelement idStellelement;
    @XmlElement(name = "ID_Unterbringung", required = true)
    protected TCIDUnterbringung idUnterbringung;

    /**
     * Ruft den Wert der bedienungArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBedienungArt }
     *     
     */
    public TCBedienungArt getBedienungArt() {
        return bedienungArt;
    }

    /**
     * Legt den Wert der bedienungArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBedienungArt }
     *     
     */
    public void setBedienungArt(TCBedienungArt value) {
        this.bedienungArt = value;
    }

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBezeichnungElement }
     *     
     */
    public CBezeichnungElement getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBezeichnungElement }
     *     
     */
    public void setBezeichnung(CBezeichnungElement value) {
        this.bezeichnung = value;
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
