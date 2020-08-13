//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.flankenschutz._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDFlaSchutz;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Darstellung der technischen Ma�nahmen, um Flankenschutz zu gew�hrleisten. DB-Regelwerk 819.0505 
 * 
 * <p>Java-Klasse f�r CFla_Schutz complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFla_Schutz">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Fla_Schutz_Anforderer" type="{http://www.plan-pro.org/modell/Flankenschutz/1.8.0}CFla_Schutz_Anforderer"/>
 *         &lt;element name="ID_Fla_Weitergabe_EKW" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Fla_Schutz" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Fla_Schutz_Signal" type="{http://www.plan-pro.org/modell/Flankenschutz/1.8.0}CFla_Schutz_Signal"/>
 *           &lt;element name="Fla_Schutz_W_Gsp" type="{http://www.plan-pro.org/modell/Flankenschutz/1.8.0}CFla_Schutz_W_Gsp"/>
 *           &lt;element name="Fla_Schutz_Weitergabe" type="{http://www.plan-pro.org/modell/Flankenschutz/1.8.0}CFla_Schutz_Weitergabe"/>
 *           &lt;element name="Fla_Verzicht" type="{http://www.plan-pro.org/modell/Flankenschutz/1.8.0}TCFla_Verzicht"/>
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
@XmlType(name = "CFla_Schutz", propOrder = {
    "flaSchutzAnforderer",
    "idFlaWeitergabeEKW",
    "flaSchutzSignal",
    "flaSchutzWGsp",
    "flaSchutzWeitergabe",
    "flaVerzicht"
})
public class CFlaSchutz
    extends CBasisObjekt
{

    @XmlElement(name = "Fla_Schutz_Anforderer", required = true)
    protected CFlaSchutzAnforderer flaSchutzAnforderer;
    @XmlElement(name = "ID_Fla_Weitergabe_EKW")
    protected TCIDFlaSchutz idFlaWeitergabeEKW;
    @XmlElement(name = "Fla_Schutz_Signal")
    protected CFlaSchutzSignal flaSchutzSignal;
    @XmlElement(name = "Fla_Schutz_W_Gsp")
    protected CFlaSchutzWGsp flaSchutzWGsp;
    @XmlElement(name = "Fla_Schutz_Weitergabe")
    protected CFlaSchutzWeitergabe flaSchutzWeitergabe;
    @XmlElement(name = "Fla_Verzicht")
    protected TCFlaVerzicht flaVerzicht;

    /**
     * Ruft den Wert der flaSchutzAnforderer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFlaSchutzAnforderer }
     *     
     */
    public CFlaSchutzAnforderer getFlaSchutzAnforderer() {
        return flaSchutzAnforderer;
    }

    /**
     * Legt den Wert der flaSchutzAnforderer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFlaSchutzAnforderer }
     *     
     */
    public void setFlaSchutzAnforderer(CFlaSchutzAnforderer value) {
        this.flaSchutzAnforderer = value;
    }

    /**
     * Ruft den Wert der idFlaWeitergabeEKW-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFlaSchutz }
     *     
     */
    public TCIDFlaSchutz getIDFlaWeitergabeEKW() {
        return idFlaWeitergabeEKW;
    }

    /**
     * Legt den Wert der idFlaWeitergabeEKW-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFlaSchutz }
     *     
     */
    public void setIDFlaWeitergabeEKW(TCIDFlaSchutz value) {
        this.idFlaWeitergabeEKW = value;
    }

    /**
     * Ruft den Wert der flaSchutzSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFlaSchutzSignal }
     *     
     */
    public CFlaSchutzSignal getFlaSchutzSignal() {
        return flaSchutzSignal;
    }

    /**
     * Legt den Wert der flaSchutzSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFlaSchutzSignal }
     *     
     */
    public void setFlaSchutzSignal(CFlaSchutzSignal value) {
        this.flaSchutzSignal = value;
    }

    /**
     * Ruft den Wert der flaSchutzWGsp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFlaSchutzWGsp }
     *     
     */
    public CFlaSchutzWGsp getFlaSchutzWGsp() {
        return flaSchutzWGsp;
    }

    /**
     * Legt den Wert der flaSchutzWGsp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFlaSchutzWGsp }
     *     
     */
    public void setFlaSchutzWGsp(CFlaSchutzWGsp value) {
        this.flaSchutzWGsp = value;
    }

    /**
     * Ruft den Wert der flaSchutzWeitergabe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFlaSchutzWeitergabe }
     *     
     */
    public CFlaSchutzWeitergabe getFlaSchutzWeitergabe() {
        return flaSchutzWeitergabe;
    }

    /**
     * Legt den Wert der flaSchutzWeitergabe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFlaSchutzWeitergabe }
     *     
     */
    public void setFlaSchutzWeitergabe(CFlaSchutzWeitergabe value) {
        this.flaSchutzWeitergabe = value;
    }

    /**
     * Ruft den Wert der flaVerzicht-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFlaVerzicht }
     *     
     */
    public TCFlaVerzicht getFlaVerzicht() {
        return flaVerzicht;
    }

    /**
     * Legt den Wert der flaVerzicht-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFlaVerzicht }
     *     
     */
    public void setFlaVerzicht(TCFlaVerzicht value) {
        this.flaVerzicht = value;
    }

}
