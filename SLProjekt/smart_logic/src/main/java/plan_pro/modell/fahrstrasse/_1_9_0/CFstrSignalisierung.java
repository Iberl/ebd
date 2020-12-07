//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDFstrZugRangier;
import plan_pro.modell.verweise._1_9_0.TCIDSignalSignalbegriff;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Je Fahrstra�e zu zeigende Signalisierung, die sich nicht eindeutig aus den Stellwerksfunktionen ergibt. Siehe auch Bildung der Signalbegriffe. DB-Regelwerk Signaltabelle 2, jedoch sind hier alle Signalisierungen angegeben.
 * 
 * <p>Java-Klasse f�r CFstr_Signalisierung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Signalisierung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Fstr_Zug_Rangier" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fstr_Zug_Rangier"/>
 *         &lt;element name="ID_Signal_Signalbegriff" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal_Signalbegriff"/>
 *         &lt;element name="ID_Signal_Signalbegriff_Ziel" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal_Signalbegriff" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_Signalisierung", propOrder = {
    "idFstrZugRangier",
    "idSignalSignalbegriff",
    "idSignalSignalbegriffZiel"
})
public class CFstrSignalisierung
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Fstr_Zug_Rangier", required = true)
    protected TCIDFstrZugRangier idFstrZugRangier;
    @XmlElement(name = "ID_Signal_Signalbegriff", required = true)
    protected TCIDSignalSignalbegriff idSignalSignalbegriff;
    @XmlElement(name = "ID_Signal_Signalbegriff_Ziel")
    protected TCIDSignalSignalbegriff idSignalSignalbegriffZiel;

    /**
     * Ruft den Wert der idFstrZugRangier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFstrZugRangier }
     *     
     */
    public TCIDFstrZugRangier getIDFstrZugRangier() {
        return idFstrZugRangier;
    }

    /**
     * Legt den Wert der idFstrZugRangier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFstrZugRangier }
     *     
     */
    public void setIDFstrZugRangier(TCIDFstrZugRangier value) {
        this.idFstrZugRangier = value;
    }

    /**
     * Ruft den Wert der idSignalSignalbegriff-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignalSignalbegriff }
     *     
     */
    public TCIDSignalSignalbegriff getIDSignalSignalbegriff() {
        return idSignalSignalbegriff;
    }

    /**
     * Legt den Wert der idSignalSignalbegriff-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignalSignalbegriff }
     *     
     */
    public void setIDSignalSignalbegriff(TCIDSignalSignalbegriff value) {
        this.idSignalSignalbegriff = value;
    }

    /**
     * Ruft den Wert der idSignalSignalbegriffZiel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignalSignalbegriff }
     *     
     */
    public TCIDSignalSignalbegriff getIDSignalSignalbegriffZiel() {
        return idSignalSignalbegriffZiel;
    }

    /**
     * Legt den Wert der idSignalSignalbegriffZiel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignalSignalbegriff }
     *     
     */
    public void setIDSignalSignalbegriffZiel(TCIDSignalSignalbegriff value) {
        this.idSignalSignalbegriffZiel = value;
    }

}
