//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.fahrstrasse._1_8;

import modell.basisobjekte._1_8.CPunktObjekt;
import modell.verweise._1_8.TCIDBeginnBereich;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Nicht durch ein anderes Punkt Objekt festgelegter Markanter Punkt. Das Objekt Sonstiger_Punkt wird durch den LST-Planer angelegt, wenn kein bereits existierendes Punkt Objekt f�r die Beschreibung des Markanten Punktes zur Verf�gung steht. Insbesondere handelt es sich dabei um: Beginn eines Bahnsteigs, Kante eines Gefahrraums am B�, Zugschluss bzw. -spitze, Beginn des zu deckenden Bereichs einer Deckungsstelle (z. B. bewegliche Br�cke), sonstige Punkte (z. B. Merkpfahl, Laternenmast). DB-Regelwerk Siehe Markanter Punkt.
 * 
 * <p>Java-Klasse f�r CSonstiger_Punkt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSonstiger_Punkt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Beginn_Bereich" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Beginn_Bereich" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSonstiger_Punkt", propOrder = {
    "idBeginnBereich"
})
public class CSonstigerPunkt
    extends CPunktObjekt
{

    @XmlElement(name = "ID_Beginn_Bereich")
    protected TCIDBeginnBereich idBeginnBereich;

    /**
     * Ruft den Wert der idBeginnBereich-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBeginnBereich }
     *     
     */
    public TCIDBeginnBereich getIDBeginnBereich() {
        return idBeginnBereich;
    }

    /**
     * Legt den Wert der idBeginnBereich-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBeginnBereich }
     *     
     */
    public void setIDBeginnBereich(TCIDBeginnBereich value) {
        this.idBeginnBereich = value;
    }

}
