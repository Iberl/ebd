//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDUeberhoehung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * �berh�hungsverlauf zwischen zwei �berh�hungspunkten.
 * 
 * <p>Java-Klasse f�r CUeberhoehungslinie complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CUeberhoehungslinie">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Ueberhoehung_A" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Ueberhoehung"/>
 *         &lt;element name="ID_Ueberhoehung_B" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Ueberhoehung"/>
 *         &lt;element name="Ueberhoehungslinie_Allg" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}CUeberhoehungslinie_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CUeberhoehungslinie", propOrder = {
    "idUeberhoehungA",
    "idUeberhoehungB",
    "ueberhoehungslinieAllg"
})
public class CUeberhoehungslinie
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Ueberhoehung_A", required = true)
    protected TCIDUeberhoehung idUeberhoehungA;
    @XmlElement(name = "ID_Ueberhoehung_B", required = true)
    protected TCIDUeberhoehung idUeberhoehungB;
    @XmlElement(name = "Ueberhoehungslinie_Allg", required = true)
    protected CUeberhoehungslinieAllg ueberhoehungslinieAllg;

    /**
     * Ruft den Wert der idUeberhoehungA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDUeberhoehung }
     *     
     */
    public TCIDUeberhoehung getIDUeberhoehungA() {
        return idUeberhoehungA;
    }

    /**
     * Legt den Wert der idUeberhoehungA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDUeberhoehung }
     *     
     */
    public void setIDUeberhoehungA(TCIDUeberhoehung value) {
        this.idUeberhoehungA = value;
    }

    /**
     * Ruft den Wert der idUeberhoehungB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDUeberhoehung }
     *     
     */
    public TCIDUeberhoehung getIDUeberhoehungB() {
        return idUeberhoehungB;
    }

    /**
     * Legt den Wert der idUeberhoehungB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDUeberhoehung }
     *     
     */
    public void setIDUeberhoehungB(TCIDUeberhoehung value) {
        this.idUeberhoehungB = value;
    }

    /**
     * Ruft den Wert der ueberhoehungslinieAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CUeberhoehungslinieAllg }
     *     
     */
    public CUeberhoehungslinieAllg getUeberhoehungslinieAllg() {
        return ueberhoehungslinieAllg;
    }

    /**
     * Legt den Wert der ueberhoehungslinieAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CUeberhoehungslinieAllg }
     *     
     */
    public void setUeberhoehungslinieAllg(CUeberhoehungslinieAllg value) {
        this.ueberhoehungslinieAllg = value;
    }

}
