//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnsteig._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CPunktObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBahnsteigAnlage;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Zugangspunkt der Reisenden zum Bahnsteig. Es wird jeweils die Mitte der Linie angegeben, auf der der Zugangsweg auf den Bahnsteig st��t. F�r die Verwendung im Sicherungstechnischen Lageplan w�hrend der Bearbeitung wurde ein neues Symbol erschaffen. Dieses soll im endg�ltigen Lageplan nicht erscheinen. Der Zugang ist in der LST-Planung f�r die INA-Berechnung relevant. Hierbei wird der Punkt auf der Bahnsteigkante ben�tigt, an der der Zustrom der Reisenden erfolgt. Dieser Punkt wird im Datenmodell nicht abgespeichert, er kann aus Bahnsteig_Zugang hergeleitet werden. DB-Regelwerk Nennung des Zugangs im INA-Erhebungsbogen, Verortung erfolgt bisher nicht
 * 
 * <p>Java-Klasse f�r CBahnsteig_Zugang complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBahnsteig_Zugang">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bahnsteig_Zugang_Allg" type="{http://www.plan-pro.org/modell/Bahnsteig/1.9.0.2}CBahnsteig_Zugang_Allg"/>
 *         &lt;element name="ID_Bahnsteig_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Bahnsteig_Anlage"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBahnsteig_Zugang", propOrder = {
    "bahnsteigZugangAllg",
    "idBahnsteigAnlage"
})
public class CBahnsteigZugang
    extends CPunktObjekt
{

    @XmlElement(name = "Bahnsteig_Zugang_Allg", required = true)
    protected CBahnsteigZugangAllg bahnsteigZugangAllg;
    @XmlElement(name = "ID_Bahnsteig_Anlage", required = true)
    protected TCIDBahnsteigAnlage idBahnsteigAnlage;

    /**
     * Ruft den Wert der bahnsteigZugangAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBahnsteigZugangAllg }
     *     
     */
    public CBahnsteigZugangAllg getBahnsteigZugangAllg() {
        return bahnsteigZugangAllg;
    }

    /**
     * Legt den Wert der bahnsteigZugangAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBahnsteigZugangAllg }
     *     
     */
    public void setBahnsteigZugangAllg(CBahnsteigZugangAllg value) {
        this.bahnsteigZugangAllg = value;
    }

    /**
     * Ruft den Wert der idBahnsteigAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBahnsteigAnlage }
     *     
     */
    public TCIDBahnsteigAnlage getIDBahnsteigAnlage() {
        return idBahnsteigAnlage;
    }

    /**
     * Legt den Wert der idBahnsteigAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBahnsteigAnlage }
     *     
     */
    public void setIDBahnsteigAnlage(TCIDBahnsteigAnlage value) {
        this.idBahnsteigAnlage = value;
    }

}
