//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDZLVBus;
import plan_pro.modell.verweise._1_9_0.TCIDZNUnterstation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Zuordnung von ZLV-Bussen zur ZN Unterstation und Angabe durchzureichender Telegramme. Logisches Objekt, falls eine ZN Unterstation an mehrere ZLV-Busse angebunden wird. DB-Regelwerk 819.0731 5 (4) ff Die Darstellung der Angaben erfolgt im ZLV-Bus-�bersichtsplan nach 819.0731 A01 
 * 
 * <p>Java-Klasse f�r CZLV_Bus_US_Zuordnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZLV_Bus_US_Zuordnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_ZLV_Bus" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZLV_Bus"/>
 *         &lt;element name="ID_ZN_Unterstation" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZN_Unterstation"/>
 *         &lt;element name="ZLV_Bus_US_Zuordnung_Telegramm" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}CZLV_Bus_US_Zuordnung_Telegramm" minOccurs="0"/>
 *         &lt;element name="ZLV_Bus_Zuordnung_Allg" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}CZLV_Bus_Zuordnung_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZLV_Bus_US_Zuordnung", propOrder = {
    "idzlvBus",
    "idznUnterstation",
    "zlvBusUSZuordnungTelegramm",
    "zlvBusZuordnungAllg"
})
public class CZLVBusUSZuordnung
    extends CBasisObjekt
{

    @XmlElement(name = "ID_ZLV_Bus", required = true)
    protected TCIDZLVBus idzlvBus;
    @XmlElement(name = "ID_ZN_Unterstation", required = true)
    protected TCIDZNUnterstation idznUnterstation;
    @XmlElement(name = "ZLV_Bus_US_Zuordnung_Telegramm")
    protected CZLVBusUSZuordnungTelegramm zlvBusUSZuordnungTelegramm;
    @XmlElement(name = "ZLV_Bus_Zuordnung_Allg", required = true)
    protected CZLVBusZuordnungAllg zlvBusZuordnungAllg;

    /**
     * Ruft den Wert der idzlvBus-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZLVBus }
     *     
     */
    public TCIDZLVBus getIDZLVBus() {
        return idzlvBus;
    }

    /**
     * Legt den Wert der idzlvBus-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZLVBus }
     *     
     */
    public void setIDZLVBus(TCIDZLVBus value) {
        this.idzlvBus = value;
    }

    /**
     * Ruft den Wert der idznUnterstation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZNUnterstation }
     *     
     */
    public TCIDZNUnterstation getIDZNUnterstation() {
        return idznUnterstation;
    }

    /**
     * Legt den Wert der idznUnterstation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZNUnterstation }
     *     
     */
    public void setIDZNUnterstation(TCIDZNUnterstation value) {
        this.idznUnterstation = value;
    }

    /**
     * Ruft den Wert der zlvBusUSZuordnungTelegramm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZLVBusUSZuordnungTelegramm }
     *     
     */
    public CZLVBusUSZuordnungTelegramm getZLVBusUSZuordnungTelegramm() {
        return zlvBusUSZuordnungTelegramm;
    }

    /**
     * Legt den Wert der zlvBusUSZuordnungTelegramm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZLVBusUSZuordnungTelegramm }
     *     
     */
    public void setZLVBusUSZuordnungTelegramm(CZLVBusUSZuordnungTelegramm value) {
        this.zlvBusUSZuordnungTelegramm = value;
    }

    /**
     * Ruft den Wert der zlvBusZuordnungAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZLVBusZuordnungAllg }
     *     
     */
    public CZLVBusZuordnungAllg getZLVBusZuordnungAllg() {
        return zlvBusZuordnungAllg;
    }

    /**
     * Legt den Wert der zlvBusZuordnungAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZLVBusZuordnungAllg }
     *     
     */
    public void setZLVBusZuordnungAllg(CZLVBusZuordnungAllg value) {
        this.zlvBusZuordnungAllg = value;
    }

}
