//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Zuglaufverfolgungsbus. Verbindung zwischen den ZN-Unterstationen zum Transport der Zugnummernmeldetelegramme. ZLV-Busse k�nnen BZ-�bergreifend geplant werden. In diesem Fall gelten f�r die Vergabe der ZLV Bus Nr besondere Bedingungen. DB-Regelwerk 819.0731 8 (2) Die Darstellung der Angaben erfolgt im ZLV-Bus-�bersichtsplan nach 819.0731 A01 
 * 
 * <p>Java-Klasse f�r CZLV_Bus complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZLV_Bus">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ZLV_Bus_Allg" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}CZLV_Bus_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZLV_Bus", propOrder = {
    "zlvBusAllg"
})
public class CZLVBus
    extends CBasisObjekt
{

    @XmlElement(name = "ZLV_Bus_Allg", required = true)
    protected CZLVBusAllg zlvBusAllg;

    /**
     * Ruft den Wert der zlvBusAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZLVBusAllg }
     *     
     */
    public CZLVBusAllg getZLVBusAllg() {
        return zlvBusAllg;
    }

    /**
     * Legt den Wert der zlvBusAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZLVBusAllg }
     *     
     */
    public void setZLVBusAllg(CZLVBusAllg value) {
        this.zlvBusAllg = value;
    }

}
