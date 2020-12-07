//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDFstrDWeg;
import plan_pro.modell.verweise._1_9_0.TCIDWKrGspElement;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Zuordnung von Weichen und Kreuzungen zum in Fstr DWeg geplanten Durchrutschweg. Eine Zuordnung von Weichen und Kreuzungen �ber den zugrunde liegenden Fstr Fahrweg ist nicht m�glich, da das Ende des Durchrutschweges in einer Weiche liegen kann, deren Sicherung explizit geplant werden muss. Au�erdem muss f�r Weichen im Durchrutschweg angegeben werden, ob sie verschlossen werden und ob sie Flankenschutz anfordern sollen. Eine Angabe der Lage der Weiche ist nicht notwendig, da sich diese �ber Fstr Fahrweg (Bereich Objekt) ergibt. Obwohl die Spalten�berschrift in der Durchrutschwegtabelle auch von Gleissperren spricht, werden Gleissperren nicht vorgesehen. DB-Regelwerk Durchrutschwegtabelle, Spalten 9 - 12: \"Weichen, Kreuzungen, Gleissperren\"
 * 
 * <p>Java-Klasse f�r CFstr_DWeg_W_Kr complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_DWeg_W_Kr">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Element_Verschluss" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCElement_Verschluss"/>
 *         &lt;element name="ID_Fstr_DWeg" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fstr_DWeg"/>
 *         &lt;element name="ID_W_Kr_Gsp_Element" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_W_Kr_Gsp_Element"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_DWeg_W_Kr", propOrder = {
    "elementVerschluss",
    "idFstrDWeg",
    "idwKrGspElement"
})
public class CFstrDWegWKr
    extends CBasisObjekt
{

    @XmlElement(name = "Element_Verschluss", required = true)
    protected TCElementVerschluss elementVerschluss;
    @XmlElement(name = "ID_Fstr_DWeg", required = true)
    protected TCIDFstrDWeg idFstrDWeg;
    @XmlElement(name = "ID_W_Kr_Gsp_Element", required = true)
    protected TCIDWKrGspElement idwKrGspElement;

    /**
     * Ruft den Wert der elementVerschluss-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCElementVerschluss }
     *     
     */
    public TCElementVerschluss getElementVerschluss() {
        return elementVerschluss;
    }

    /**
     * Legt den Wert der elementVerschluss-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCElementVerschluss }
     *     
     */
    public void setElementVerschluss(TCElementVerschluss value) {
        this.elementVerschluss = value;
    }

    /**
     * Ruft den Wert der idFstrDWeg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFstrDWeg }
     *     
     */
    public TCIDFstrDWeg getIDFstrDWeg() {
        return idFstrDWeg;
    }

    /**
     * Legt den Wert der idFstrDWeg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFstrDWeg }
     *     
     */
    public void setIDFstrDWeg(TCIDFstrDWeg value) {
        this.idFstrDWeg = value;
    }

    /**
     * Ruft den Wert der idwKrGspElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public TCIDWKrGspElement getIDWKrGspElement() {
        return idwKrGspElement;
    }

    /**
     * Legt den Wert der idwKrGspElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public void setIDWKrGspElement(TCIDWKrGspElement value) {
        this.idwKrGspElement = value;
    }

}
