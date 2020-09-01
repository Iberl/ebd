//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.regelzeichnung._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Regelzeichnungen werden verwendet, um einheitliche Bauausf�hrungen f�r bestimmte Objekte sicherzustellen. Die f�r die LST-Anwendungen im Datenmodell ben�tigten Regelzeichnungen werden in einer Regelzeichnungstabelle aufgelistet. Regelzeichnungen k�nnen neben dem Bild eine beliebige Anzahl von Parametern haben, die die Bausausf�hrung f�r einen konkreten Anwendungsfall genauer spezifizieren. Die G�ltigkeit der Parameter f�r eine konkrete Anwendung in einer Regelzeichnung kann nur mit dem Pr�f- und Testtool bestimmt werden.
 * 
 * <p>Java-Klasse f�r CRegelzeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CRegelzeichnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Regelzeichnung_Allg" type="{http://www.plan-pro.org/modell/Regelzeichnung/1.8.0}CRegelzeichnung_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRegelzeichnung", propOrder = {
    "regelzeichnungAllg"
})
public class CRegelzeichnung
    extends CBasisObjekt
{

    @XmlElement(name = "Regelzeichnung_Allg", required = true)
    protected CRegelzeichnungAllg regelzeichnungAllg;

    /**
     * Ruft den Wert der regelzeichnungAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CRegelzeichnungAllg }
     *     
     */
    public CRegelzeichnungAllg getRegelzeichnungAllg() {
        return regelzeichnungAllg;
    }

    /**
     * Legt den Wert der regelzeichnungAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CRegelzeichnungAllg }
     *     
     */
    public void setRegelzeichnungAllg(CRegelzeichnungAllg value) {
        this.regelzeichnungAllg = value;
    }

}
