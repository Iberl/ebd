//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bahnsteig._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBahnsteig_Kante_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBahnsteig_Kante_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_Bahnsteig_Kante" type="{http://www.plan-pro.org/modell/Bahnsteig/1.8.0}TCBezeichnung_Bahnsteig_Kante"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBahnsteig_Kante_Bezeichnung", propOrder = {
    "bezeichnungBahnsteigKante"
})
public class CBahnsteigKanteBezeichnung {

    @XmlElement(name = "Bezeichnung_Bahnsteig_Kante", required = true)
    protected TCBezeichnungBahnsteigKante bezeichnungBahnsteigKante;

    /**
     * Ruft den Wert der bezeichnungBahnsteigKante-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungBahnsteigKante }
     *     
     */
    public TCBezeichnungBahnsteigKante getBezeichnungBahnsteigKante() {
        return bezeichnungBahnsteigKante;
    }

    /**
     * Legt den Wert der bezeichnungBahnsteigKante-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungBahnsteigKante }
     *     
     */
    public void setBezeichnungBahnsteigKante(TCBezeichnungBahnsteigKante value) {
        this.bezeichnungBahnsteigKante = value;
    }

}
