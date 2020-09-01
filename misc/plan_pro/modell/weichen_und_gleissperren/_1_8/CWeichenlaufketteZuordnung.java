//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.weichen_und_gleissperren._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDSignal;
import modell.verweise._1_8.TCIDWeichenlaufkette;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Logisches Objekt f�r die Zuordnung zwischen Weichenlaufketten und Signalen. Das Objekt ist in der Realit�t des Stellwerkes nicht vorhanden. Die Weichenlaufkette_Zuordnung hat keine Attributgruppe \"..._Allgemeine_Merkmale\".
 * 
 * <p>Java-Klasse f�r CWeichenlaufkette_Zuordnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CWeichenlaufkette_Zuordnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Signal" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Signal"/>
 *         &lt;element name="ID_Weichenlaufkette" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Weichenlaufkette"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CWeichenlaufkette_Zuordnung", propOrder = {
    "idSignal",
    "idWeichenlaufkette"
})
public class CWeichenlaufketteZuordnung
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Signal", required = true)
    protected TCIDSignal idSignal;
    @XmlElement(name = "ID_Weichenlaufkette", required = true)
    protected TCIDWeichenlaufkette idWeichenlaufkette;

    /**
     * Ruft den Wert der idSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignal }
     *     
     */
    public TCIDSignal getIDSignal() {
        return idSignal;
    }

    /**
     * Legt den Wert der idSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignal }
     *     
     */
    public void setIDSignal(TCIDSignal value) {
        this.idSignal = value;
    }

    /**
     * Ruft den Wert der idWeichenlaufkette-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDWeichenlaufkette }
     *     
     */
    public TCIDWeichenlaufkette getIDWeichenlaufkette() {
        return idWeichenlaufkette;
    }

    /**
     * Legt den Wert der idWeichenlaufkette-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDWeichenlaufkette }
     *     
     */
    public void setIDWeichenlaufkette(TCIDWeichenlaufkette value) {
        this.idWeichenlaufkette = value;
    }

}
