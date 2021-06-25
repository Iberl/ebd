//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBedienOberflaeche;
import plan_pro.modell.verweise._1_9_0.TCIDOertlichkeitProxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Zusammenfassung der Eigenschaften, die sich jeweils nur auf ein Bild der Bedienoberfl�che beziehen. Eigenschaften, die alle Bilder betreffen, sind unter Bedien Oberflaeche eingebunden. 
 * 
 * <p>Java-Klasse f�r CBedien_Oberflaeche_Bild complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Oberflaeche_Bild">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bedien_Oberflaeche_Bild_Allg" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}CBedien_Oberflaeche_Bild_Allg"/>
 *         &lt;element name="ID_Bedien_Oberflaeche" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Bedien_Oberflaeche"/>
 *         &lt;element name="ID_Oertlichkeit" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Oertlichkeit_Proxy"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Oberflaeche_Bild", propOrder = {
    "bedienOberflaecheBildAllg",
    "idBedienOberflaeche",
    "idOertlichkeit"
})
public class CBedienOberflaecheBild
    extends CBasisObjekt
{

    @XmlElement(name = "Bedien_Oberflaeche_Bild_Allg", required = true)
    protected CBedienOberflaecheBildAllg bedienOberflaecheBildAllg;
    @XmlElement(name = "ID_Bedien_Oberflaeche", required = true)
    protected TCIDBedienOberflaeche idBedienOberflaeche;
    @XmlElement(name = "ID_Oertlichkeit", required = true)
    protected TCIDOertlichkeitProxy idOertlichkeit;

    /**
     * Ruft den Wert der bedienOberflaecheBildAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedienOberflaecheBildAllg }
     *     
     */
    public CBedienOberflaecheBildAllg getBedienOberflaecheBildAllg() {
        return bedienOberflaecheBildAllg;
    }

    /**
     * Legt den Wert der bedienOberflaecheBildAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedienOberflaecheBildAllg }
     *     
     */
    public void setBedienOberflaecheBildAllg(CBedienOberflaecheBildAllg value) {
        this.bedienOberflaecheBildAllg = value;
    }

    /**
     * Ruft den Wert der idBedienOberflaeche-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBedienOberflaeche }
     *     
     */
    public TCIDBedienOberflaeche getIDBedienOberflaeche() {
        return idBedienOberflaeche;
    }

    /**
     * Legt den Wert der idBedienOberflaeche-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBedienOberflaeche }
     *     
     */
    public void setIDBedienOberflaeche(TCIDBedienOberflaeche value) {
        this.idBedienOberflaeche = value;
    }

    /**
     * Ruft den Wert der idOertlichkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public TCIDOertlichkeitProxy getIDOertlichkeit() {
        return idOertlichkeit;
    }

    /**
     * Legt den Wert der idOertlichkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public void setIDOertlichkeit(TCIDOertlichkeitProxy value) {
        this.idOertlichkeit = value;
    }

}
