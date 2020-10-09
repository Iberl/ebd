//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.regelzeichnung._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDRegelzeichnung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Einer Regelzeichnung werden durch dieses Objekt weitere Parameter zugeordnet. F�r eine Regelzeichnung k�nnen beliebig viele Parameter entsprechend der konkreten Anwendung angegeben werden. 
 * 
 * <p>Java-Klasse f�r CRegelzeichnung_Parameter complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CRegelzeichnung_Parameter">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Regelzeichnung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Regelzeichnung"/>
 *         &lt;element name="Regelzeichnung_Parameter_Allg" type="{http://www.plan-pro.org/modell/Regelzeichnung/1.8.0}CRegelzeichnung_Parameter_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRegelzeichnung_Parameter", propOrder = {
    "idRegelzeichnung",
    "regelzeichnungParameterAllg"
})
public class CRegelzeichnungParameter
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Regelzeichnung", required = true)
    protected TCIDRegelzeichnung idRegelzeichnung;
    @XmlElement(name = "Regelzeichnung_Parameter_Allg", required = true)
    protected CRegelzeichnungParameterAllg regelzeichnungParameterAllg;

    /**
     * Ruft den Wert der idRegelzeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDRegelzeichnung }
     *     
     */
    public TCIDRegelzeichnung getIDRegelzeichnung() {
        return idRegelzeichnung;
    }

    /**
     * Legt den Wert der idRegelzeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDRegelzeichnung }
     *     
     */
    public void setIDRegelzeichnung(TCIDRegelzeichnung value) {
        this.idRegelzeichnung = value;
    }

    /**
     * Ruft den Wert der regelzeichnungParameterAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CRegelzeichnungParameterAllg }
     *     
     */
    public CRegelzeichnungParameterAllg getRegelzeichnungParameterAllg() {
        return regelzeichnungParameterAllg;
    }

    /**
     * Legt den Wert der regelzeichnungParameterAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CRegelzeichnungParameterAllg }
     *     
     */
    public void setRegelzeichnungParameterAllg(CRegelzeichnungParameterAllg value) {
        this.regelzeichnungParameterAllg = value;
    }

}
