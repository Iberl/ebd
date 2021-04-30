//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Beschreibung der Bedingungen, die zur Auswahl eines Fachtelegramms erf�llt sein m�ssen.
 * 
 * <p>Java-Klasse f�r CFT_Anschaltbedingung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFT_Anschaltbedingung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Bedingung_Besondere" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CBedingung_Besondere"/>
 *           &lt;element name="Bedingung_PZB" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CBedingung_PZB"/>
 *           &lt;element name="Bedingung_Signal" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CBedingung_Signal"/>
 *           &lt;element name="Bedingung_Sonstige" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CBedingung_Sonstige"/>
 *           &lt;element name="Bedingung_Weiche" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CBedingung_Weiche"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFT_Anschaltbedingung", propOrder = {
    "bedingungBesondere",
    "bedingungPZB",
    "bedingungSignal",
    "bedingungSonstige",
    "bedingungWeiche"
})
public class CFTAnschaltbedingung
    extends CBasisObjekt
{

    @XmlElement(name = "Bedingung_Besondere")
    protected CBedingungBesondere bedingungBesondere;
    @XmlElement(name = "Bedingung_PZB")
    protected CBedingungPZB bedingungPZB;
    @XmlElement(name = "Bedingung_Signal")
    protected CBedingungSignal bedingungSignal;
    @XmlElement(name = "Bedingung_Sonstige")
    protected CBedingungSonstige bedingungSonstige;
    @XmlElement(name = "Bedingung_Weiche")
    protected CBedingungWeiche bedingungWeiche;

    /**
     * Ruft den Wert der bedingungBesondere-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedingungBesondere }
     *     
     */
    public CBedingungBesondere getBedingungBesondere() {
        return bedingungBesondere;
    }

    /**
     * Legt den Wert der bedingungBesondere-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedingungBesondere }
     *     
     */
    public void setBedingungBesondere(CBedingungBesondere value) {
        this.bedingungBesondere = value;
    }

    /**
     * Ruft den Wert der bedingungPZB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedingungPZB }
     *     
     */
    public CBedingungPZB getBedingungPZB() {
        return bedingungPZB;
    }

    /**
     * Legt den Wert der bedingungPZB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedingungPZB }
     *     
     */
    public void setBedingungPZB(CBedingungPZB value) {
        this.bedingungPZB = value;
    }

    /**
     * Ruft den Wert der bedingungSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedingungSignal }
     *     
     */
    public CBedingungSignal getBedingungSignal() {
        return bedingungSignal;
    }

    /**
     * Legt den Wert der bedingungSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedingungSignal }
     *     
     */
    public void setBedingungSignal(CBedingungSignal value) {
        this.bedingungSignal = value;
    }

    /**
     * Ruft den Wert der bedingungSonstige-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedingungSonstige }
     *     
     */
    public CBedingungSonstige getBedingungSonstige() {
        return bedingungSonstige;
    }

    /**
     * Legt den Wert der bedingungSonstige-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedingungSonstige }
     *     
     */
    public void setBedingungSonstige(CBedingungSonstige value) {
        this.bedingungSonstige = value;
    }

    /**
     * Ruft den Wert der bedingungWeiche-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedingungWeiche }
     *     
     */
    public CBedingungWeiche getBedingungWeiche() {
        return bedingungWeiche;
    }

    /**
     * Legt den Wert der bedingungWeiche-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedingungWeiche }
     *     
     */
    public void setBedingungWeiche(CBedingungWeiche value) {
        this.bedingungWeiche = value;
    }

}
