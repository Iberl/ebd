//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.ortung._1_8;

import modell.basisobjekte._1_8.CPunktObjekt;
import modell.verweise._1_8.TCIDFMAAnlage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Erg�nzung einer FMA Komponente bei Gleisstromkreisen um die Bauelemente zur Ein- und Ausspeisung. FMA_Elemente werden rechts und/oder links der FMA_Komponente direkt den angrenzenden FMA_Anlagen zugewiesen. Das Objekt ist bei Achsz�hlpunkten nicht erforderlich. DB-Regelwerk Typspezifische Planungshinweise und Technische Mitteilungen; Planungsdaten: Sicherungstechnischer Lageplan, B�-Lageplan, Gleisisolierplan, Freimeldetabelle. 
 * 
 * <p>Java-Klasse f�r CFMA_Element complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFMA_Element">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="FMA_Element_Allg" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}CFMA_Element_Allg"/>
 *         &lt;element name="FMA_Element_Anschluss" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}CFMA_Element_Anschluss" minOccurs="0"/>
 *         &lt;element name="ID_FMA_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_FMA_Anlage"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFMA_Element", propOrder = {
    "fmaElementAllg",
    "fmaElementAnschluss",
    "idfmaAnlage"
})
public class CFMAElement
    extends CPunktObjekt
{

    @XmlElement(name = "FMA_Element_Allg", required = true)
    protected CFMAElementAllg fmaElementAllg;
    @XmlElement(name = "FMA_Element_Anschluss")
    protected CFMAElementAnschluss fmaElementAnschluss;
    @XmlElement(name = "ID_FMA_Anlage", required = true)
    protected TCIDFMAAnlage idfmaAnlage;

    /**
     * Ruft den Wert der fmaElementAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFMAElementAllg }
     *     
     */
    public CFMAElementAllg getFMAElementAllg() {
        return fmaElementAllg;
    }

    /**
     * Legt den Wert der fmaElementAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFMAElementAllg }
     *     
     */
    public void setFMAElementAllg(CFMAElementAllg value) {
        this.fmaElementAllg = value;
    }

    /**
     * Ruft den Wert der fmaElementAnschluss-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFMAElementAnschluss }
     *     
     */
    public CFMAElementAnschluss getFMAElementAnschluss() {
        return fmaElementAnschluss;
    }

    /**
     * Legt den Wert der fmaElementAnschluss-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFMAElementAnschluss }
     *     
     */
    public void setFMAElementAnschluss(CFMAElementAnschluss value) {
        this.fmaElementAnschluss = value;
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
