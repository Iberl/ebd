//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CETCS_Kante_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CETCS_Kante_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_ETCS_Kante" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCBezeichnung_ETCS_Kante"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CETCS_Kante_Bezeichnung", propOrder = {
    "bezeichnungETCSKante"
})
public class CETCSKanteBezeichnung {

    @XmlElement(name = "Bezeichnung_ETCS_Kante", required = true)
    protected TCBezeichnungETCSKante bezeichnungETCSKante;

    /**
     * Ruft den Wert der bezeichnungETCSKante-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungETCSKante }
     *     
     */
    public TCBezeichnungETCSKante getBezeichnungETCSKante() {
        return bezeichnungETCSKante;
    }

    /**
     * Legt den Wert der bezeichnungETCSKante-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungETCSKante }
     *     
     */
    public void setBezeichnungETCSKante(TCBezeichnungETCSKante value) {
        this.bezeichnungETCSKante = value;
    }

}
