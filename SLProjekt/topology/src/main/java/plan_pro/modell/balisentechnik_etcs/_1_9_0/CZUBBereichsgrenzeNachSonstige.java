//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZUB_Bereichsgrenze_Nach_Sonstige complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZUB_Bereichsgrenze_Nach_Sonstige">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_ZUB" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCBezeichnung_ZUB"/>
 *         &lt;element name="Laenge_Ausfuehrungsbereich" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCLaenge_Ausfuehrungsbereich"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZUB_Bereichsgrenze_Nach_Sonstige", propOrder = {
    "bezeichnungZUB",
    "laengeAusfuehrungsbereich"
})
public class CZUBBereichsgrenzeNachSonstige {

    @XmlElement(name = "Bezeichnung_ZUB", required = true)
    protected TCBezeichnungZUB bezeichnungZUB;
    @XmlElement(name = "Laenge_Ausfuehrungsbereich", required = true)
    protected TCLaengeAusfuehrungsbereich laengeAusfuehrungsbereich;

    /**
     * Ruft den Wert der bezeichnungZUB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungZUB }
     *     
     */
    public TCBezeichnungZUB getBezeichnungZUB() {
        return bezeichnungZUB;
    }

    /**
     * Legt den Wert der bezeichnungZUB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungZUB }
     *     
     */
    public void setBezeichnungZUB(TCBezeichnungZUB value) {
        this.bezeichnungZUB = value;
    }

    /**
     * Ruft den Wert der laengeAusfuehrungsbereich-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLaengeAusfuehrungsbereich }
     *     
     */
    public TCLaengeAusfuehrungsbereich getLaengeAusfuehrungsbereich() {
        return laengeAusfuehrungsbereich;
    }

    /**
     * Legt den Wert der laengeAusfuehrungsbereich-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLaengeAusfuehrungsbereich }
     *     
     */
    public void setLaengeAusfuehrungsbereich(TCLaengeAusfuehrungsbereich value) {
        this.laengeAusfuehrungsbereich = value;
    }

}
