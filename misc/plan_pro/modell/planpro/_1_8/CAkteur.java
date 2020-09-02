//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.planpro._1_8;

import modell.basisobjekte._1_8.CUrObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Am PlanPro-Planungsprozess beteiligtes System oder Rolle. Bisher wird in PlanPro lediglich der Name des Akteurs erfasst. Einschr�nkungen hinsichtlich der zul�ssigen Rolle des Akteurs sind durch entsprechende Attributbezeichnungen und -beschreibungen ersichtlich. DB-Regelwerk Schriftfeldeintrag gem�� Ril 819.0103.
 * 
 * 
 * <p>Java-Klasse f�r CAkteur complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CAkteur">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Akteuer_Allgemeine_Merkmale" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CAkteuer_Allgemeine_Merkmale"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CAkteur", propOrder = {
    "akteuerAllgemeineMerkmale"
})
public class CAkteur
    extends CUrObjekt
{

    @XmlElement(name = "Akteuer_Allgemeine_Merkmale", required = true)
    protected CAkteuerAllgemeineMerkmale akteuerAllgemeineMerkmale;

    /**
     * Ruft den Wert der akteuerAllgemeineMerkmale-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CAkteuerAllgemeineMerkmale }
     *     
     */
    public CAkteuerAllgemeineMerkmale getAkteuerAllgemeineMerkmale() {
        return akteuerAllgemeineMerkmale;
    }

    /**
     * Legt den Wert der akteuerAllgemeineMerkmale-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CAkteuerAllgemeineMerkmale }
     *     
     */
    public void setAkteuerAllgemeineMerkmale(CAkteuerAllgemeineMerkmale value) {
        this.akteuerAllgemeineMerkmale = value;
    }

}
