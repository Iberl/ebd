//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBereichObjekt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Bereich mit einheitlicher Ausr�stung von Zugbeeinflussungssystem(en) oder Kennzeichnung eines besonderen Bereichs (z. B. gro�es Metallteil), der im Rahmen einer Balisen-Planung zu ber�cksichtigen ist.\nSofern in einem Bereich richtungsbezogen unterschiedliche Zugbeeinflussungssysteme genutzt werden (Grenzbereich), sind daf�r richtungsbezogene Bereichsobjekte anzulegen.\nHinweis f�r Planungswerkzeuge: Die Definition des Bereichsobjekts ZUB_Streckeneigenschaft richtet sich nach dem Punktobjekt ZUB_Bereichsgrenze.
 * 
 * <p>Java-Klasse f�r CZUB_Streckeneigenschaft complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZUB_Streckeneigenschaft">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CZUB_Streckeneigenschaft_Bezeichnung" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Metallteil" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCMetallteil"/>
 *           &lt;element name="Oberstrombegrenzung_Gueterzug" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCOberstrombegrenzung_Gueterzug"/>
 *           &lt;element name="Oberstrombegrenzung_Reisezug" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCOberstrombegrenzung_Reisezug"/>
 *           &lt;element name="Verbot_Anhalten" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCVerbot_Anhalten"/>
 *           &lt;element name="Verbot_Regenerative_Bremse" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCVerbot_Regenerative_Bremse"/>
 *           &lt;element name="Verbot_WB_Art" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCVerbot_WB_Art"/>
 *           &lt;element name="ZUB_SE_Ausruestung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CZUB_SE_Ausruestung"/>
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
@XmlType(name = "CZUB_Streckeneigenschaft", propOrder = {
    "bezeichnung",
    "metallteil",
    "oberstrombegrenzungGueterzug",
    "oberstrombegrenzungReisezug",
    "verbotAnhalten",
    "verbotRegenerativeBremse",
    "verbotWBArt",
    "zubseAusruestung"
})
public class CZUBStreckeneigenschaft
    extends CBereichObjekt
{

    @XmlElement(name = "Bezeichnung")
    protected CZUBStreckeneigenschaftBezeichnung bezeichnung;
    @XmlElement(name = "Metallteil")
    protected TCMetallteil metallteil;
    @XmlElement(name = "Oberstrombegrenzung_Gueterzug")
    protected TCOberstrombegrenzungGueterzug oberstrombegrenzungGueterzug;
    @XmlElement(name = "Oberstrombegrenzung_Reisezug")
    protected TCOberstrombegrenzungReisezug oberstrombegrenzungReisezug;
    @XmlElement(name = "Verbot_Anhalten")
    protected TCVerbotAnhalten verbotAnhalten;
    @XmlElement(name = "Verbot_Regenerative_Bremse")
    protected TCVerbotRegenerativeBremse verbotRegenerativeBremse;
    @XmlElement(name = "Verbot_WB_Art")
    protected TCVerbotWBArt verbotWBArt;
    @XmlElement(name = "ZUB_SE_Ausruestung")
    protected CZUBSEAusruestung zubseAusruestung;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZUBStreckeneigenschaftBezeichnung }
     *     
     */
    public CZUBStreckeneigenschaftBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZUBStreckeneigenschaftBezeichnung }
     *     
     */
    public void setBezeichnung(CZUBStreckeneigenschaftBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der metallteil-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMetallteil }
     *     
     */
    public TCMetallteil getMetallteil() {
        return metallteil;
    }

    /**
     * Legt den Wert der metallteil-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMetallteil }
     *     
     */
    public void setMetallteil(TCMetallteil value) {
        this.metallteil = value;
    }

    /**
     * Ruft den Wert der oberstrombegrenzungGueterzug-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCOberstrombegrenzungGueterzug }
     *     
     */
    public TCOberstrombegrenzungGueterzug getOberstrombegrenzungGueterzug() {
        return oberstrombegrenzungGueterzug;
    }

    /**
     * Legt den Wert der oberstrombegrenzungGueterzug-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOberstrombegrenzungGueterzug }
     *     
     */
    public void setOberstrombegrenzungGueterzug(TCOberstrombegrenzungGueterzug value) {
        this.oberstrombegrenzungGueterzug = value;
    }

    /**
     * Ruft den Wert der oberstrombegrenzungReisezug-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCOberstrombegrenzungReisezug }
     *     
     */
    public TCOberstrombegrenzungReisezug getOberstrombegrenzungReisezug() {
        return oberstrombegrenzungReisezug;
    }

    /**
     * Legt den Wert der oberstrombegrenzungReisezug-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOberstrombegrenzungReisezug }
     *     
     */
    public void setOberstrombegrenzungReisezug(TCOberstrombegrenzungReisezug value) {
        this.oberstrombegrenzungReisezug = value;
    }

    /**
     * Ruft den Wert der verbotAnhalten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVerbotAnhalten }
     *     
     */
    public TCVerbotAnhalten getVerbotAnhalten() {
        return verbotAnhalten;
    }

    /**
     * Legt den Wert der verbotAnhalten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVerbotAnhalten }
     *     
     */
    public void setVerbotAnhalten(TCVerbotAnhalten value) {
        this.verbotAnhalten = value;
    }

    /**
     * Ruft den Wert der verbotRegenerativeBremse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVerbotRegenerativeBremse }
     *     
     */
    public TCVerbotRegenerativeBremse getVerbotRegenerativeBremse() {
        return verbotRegenerativeBremse;
    }

    /**
     * Legt den Wert der verbotRegenerativeBremse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVerbotRegenerativeBremse }
     *     
     */
    public void setVerbotRegenerativeBremse(TCVerbotRegenerativeBremse value) {
        this.verbotRegenerativeBremse = value;
    }

    /**
     * Ruft den Wert der verbotWBArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVerbotWBArt }
     *     
     */
    public TCVerbotWBArt getVerbotWBArt() {
        return verbotWBArt;
    }

    /**
     * Legt den Wert der verbotWBArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVerbotWBArt }
     *     
     */
    public void setVerbotWBArt(TCVerbotWBArt value) {
        this.verbotWBArt = value;
    }

    /**
     * Ruft den Wert der zubseAusruestung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZUBSEAusruestung }
     *     
     */
    public CZUBSEAusruestung getZUBSEAusruestung() {
        return zubseAusruestung;
    }

    /**
     * Legt den Wert der zubseAusruestung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZUBSEAusruestung }
     *     
     */
    public void setZUBSEAusruestung(CZUBSEAusruestung value) {
        this.zubseAusruestung = value;
    }

}
