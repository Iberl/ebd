//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basistypen._1_9_0.CBasisAttribut;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java-Klasse f�r TCTBV_Tunnelbereich_Laenge complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TCTBV_Tunnelbereich_Laenge">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}CBasisAttribut">
 *       &lt;sequence>
 *         &lt;element name="Wert" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TTBV_Tunnelbereich_Laenge"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCTBV_Tunnelbereich_Laenge", propOrder = {
    "wert"
})
public class TCTBVTunnelbereichLaenge
    extends CBasisAttribut
{

    @XmlElement(name = "Wert", required = true, nillable = true)
    protected BigDecimal wert;

    /**
     * Ruft den Wert der wert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWert() {
        return wert;
    }

    /**
     * Legt den Wert der wert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWert(BigDecimal value) {
        this.wert = value;
    }

}
