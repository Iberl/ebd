//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDDatenpunktOhneProxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Bauelement zur �bertragung von Telegrammen an ETCS-Fahrzeugeinrichtungen. Gesteuerte Balisen sind anhand des Verweises LEU_Ausgang.ID_Balise auf diese Balise zu erkennen.
 * 
 * <p>Java-Klasse f�r CBalise complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBalise">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Balise_Allg" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CBalise_Allg"/>
 *         &lt;element name="ID_Datenpunkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Datenpunkt_ohne_Proxy"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBalise", propOrder = {
    "baliseAllg",
    "idDatenpunkt"
})
public class CBalise
    extends CBasisObjekt
{

    @XmlElement(name = "Balise_Allg", required = true)
    protected CBaliseAllg baliseAllg;
    @XmlElement(name = "ID_Datenpunkt", required = true)
    protected TCIDDatenpunktOhneProxy idDatenpunkt;

    /**
     * Ruft den Wert der baliseAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBaliseAllg }
     *     
     */
    public CBaliseAllg getBaliseAllg() {
        return baliseAllg;
    }

    /**
     * Legt den Wert der baliseAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBaliseAllg }
     *     
     */
    public void setBaliseAllg(CBaliseAllg value) {
        this.baliseAllg = value;
    }

    /**
     * Ruft den Wert der idDatenpunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDDatenpunktOhneProxy }
     *     
     */
    public TCIDDatenpunktOhneProxy getIDDatenpunkt() {
        return idDatenpunkt;
    }

    /**
     * Legt den Wert der idDatenpunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDDatenpunktOhneProxy }
     *     
     */
    public void setIDDatenpunkt(TCIDDatenpunktOhneProxy value) {
        this.idDatenpunkt = value;
    }

}
