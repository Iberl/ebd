//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zugnummernmeldeanlage._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDESTWZentraleinheit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Abbildung der Parameter f�r die Anbindung einer ZN an die BZ. Der Verweis auf ID ESTW Zentraleinheit beschreibt den Ort der r�umlichen Unterbringung der Koppelunterstation. Bei der Bearbeitung im Planungstool kann es notwendig sein, bereits bei Bearbeitung im Dialogfeld ZN-ZBS den Verweis auf die ESTW_Zentraleinheit zu bef�llen. DB-Regelwerk 819.0731 6 (16) Die Darstellung der Angaben erfolgt im ZLV-Bus-�bersichtsplan nach 819.0731 A01 
 * 
 * <p>Java-Klasse f�r CZN_ZBS complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_ZBS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_ESTW_Zentraleinheit" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_ESTW_Zentraleinheit" minOccurs="0"/>
 *         &lt;element name="ZN_ZBS_Allg" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZN_ZBS_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZN_ZBS", propOrder = {
    "idestwZentraleinheit",
    "znzbsAllg"
})
public class CZNZBS
    extends CBasisObjekt
{

    @XmlElement(name = "ID_ESTW_Zentraleinheit")
    protected TCIDESTWZentraleinheit idestwZentraleinheit;
    @XmlElement(name = "ZN_ZBS_Allg", required = true)
    protected CZNZBSAllg znzbsAllg;

    /**
     * Ruft den Wert der idestwZentraleinheit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDESTWZentraleinheit }
     *     
     */
    public TCIDESTWZentraleinheit getIDESTWZentraleinheit() {
        return idestwZentraleinheit;
    }

    /**
     * Legt den Wert der idestwZentraleinheit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDESTWZentraleinheit }
     *     
     */
    public void setIDESTWZentraleinheit(TCIDESTWZentraleinheit value) {
        this.idestwZentraleinheit = value;
    }

    /**
     * Ruft den Wert der znzbsAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZNZBSAllg }
     *     
     */
    public CZNZBSAllg getZNZBSAllg() {
        return znzbsAllg;
    }

    /**
     * Legt den Wert der znzbsAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZNZBSAllg }
     *     
     */
    public void setZNZBSAllg(CZNZBSAllg value) {
        this.znzbsAllg = value;
    }

}
