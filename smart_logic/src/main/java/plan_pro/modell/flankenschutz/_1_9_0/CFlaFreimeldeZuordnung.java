//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.flankenschutz._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDFMAAnlage;
import plan_pro.modell.verweise._1_9_0.TCIDFlaSchutz;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Zuordnung der freizupr�fenden Freimeldeabschnitte zur jeweiligen Flankenschutzma�nahme. DB-Regelwerk Flankenschutztabelle, Spalte 10 \"�berwachter Schutzraum\"
 * 
 * <p>Java-Klasse f�r CFla_Freimelde_Zuordnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFla_Freimelde_Zuordnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Fla_Raum_Freimeldung" type="{http://www.plan-pro.org/modell/Flankenschutz/1.9.0.2}TCFla_Raum_Freimeldung"/>
 *         &lt;element name="ID_Fla_Schutz" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fla_Schutz"/>
 *         &lt;element name="ID_FMA_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_FMA_Anlage"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFla_Freimelde_Zuordnung", propOrder = {
    "flaRaumFreimeldung",
    "idFlaSchutz",
    "idfmaAnlage"
})
public class CFlaFreimeldeZuordnung
    extends CBasisObjekt
{

    @XmlElement(name = "Fla_Raum_Freimeldung", required = true)
    protected TCFlaRaumFreimeldung flaRaumFreimeldung;
    @XmlElement(name = "ID_Fla_Schutz", required = true)
    protected TCIDFlaSchutz idFlaSchutz;
    @XmlElement(name = "ID_FMA_Anlage", required = true)
    protected TCIDFMAAnlage idfmaAnlage;

    /**
     * Ruft den Wert der flaRaumFreimeldung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFlaRaumFreimeldung }
     *     
     */
    public TCFlaRaumFreimeldung getFlaRaumFreimeldung() {
        return flaRaumFreimeldung;
    }

    /**
     * Legt den Wert der flaRaumFreimeldung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFlaRaumFreimeldung }
     *     
     */
    public void setFlaRaumFreimeldung(TCFlaRaumFreimeldung value) {
        this.flaRaumFreimeldung = value;
    }

    /**
     * Ruft den Wert der idFlaSchutz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFlaSchutz }
     *     
     */
    public TCIDFlaSchutz getIDFlaSchutz() {
        return idFlaSchutz;
    }

    /**
     * Legt den Wert der idFlaSchutz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFlaSchutz }
     *     
     */
    public void setIDFlaSchutz(TCIDFlaSchutz value) {
        this.idFlaSchutz = value;
    }

    /**
     * Ruft den Wert der idfmaAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFMAAnlage }
     *     
     */
    public TCIDFMAAnlage getIDFMAAnlage() {
        return idfmaAnlage;
    }

    /**
     * Legt den Wert der idfmaAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFMAAnlage }
     *     
     */
    public void setIDFMAAnlage(TCIDFMAAnlage value) {
        this.idfmaAnlage = value;
    }

}
