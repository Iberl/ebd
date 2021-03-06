//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CPunktObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBUEAnlageOhneProxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Abbildung von Schrankenantrieben f�r Bahn�berg�nge.
 * 
 * <p>Java-Klasse f�r CSchrankenantrieb complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchrankenantrieb">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CSchrankenantrieb_Bezeichnung"/>
 *         &lt;element name="ID_BUE_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_BUE_Anlage_ohne_Proxy"/>
 *         &lt;element name="SA_Schrankenbaum" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CSA_Schrankenbaum"/>
 *         &lt;element name="Schrankenantrieb_Allg" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CSchrankenantrieb_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSchrankenantrieb", propOrder = {
    "bezeichnung",
    "idbueAnlage",
    "saSchrankenbaum",
    "schrankenantriebAllg"
})
public class CSchrankenantrieb
    extends CPunktObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CSchrankenantriebBezeichnung bezeichnung;
    @XmlElement(name = "ID_BUE_Anlage", required = true)
    protected TCIDBUEAnlageOhneProxy idbueAnlage;
    @XmlElement(name = "SA_Schrankenbaum", required = true)
    protected CSASchrankenbaum saSchrankenbaum;
    @XmlElement(name = "Schrankenantrieb_Allg", required = true)
    protected CSchrankenantriebAllg schrankenantriebAllg;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSchrankenantriebBezeichnung }
     *     
     */
    public CSchrankenantriebBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSchrankenantriebBezeichnung }
     *     
     */
    public void setBezeichnung(CSchrankenantriebBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idbueAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBUEAnlageOhneProxy }
     *     
     */
    public TCIDBUEAnlageOhneProxy getIDBUEAnlage() {
        return idbueAnlage;
    }

    /**
     * Legt den Wert der idbueAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBUEAnlageOhneProxy }
     *     
     */
    public void setIDBUEAnlage(TCIDBUEAnlageOhneProxy value) {
        this.idbueAnlage = value;
    }

    /**
     * Ruft den Wert der saSchrankenbaum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSASchrankenbaum }
     *     
     */
    public CSASchrankenbaum getSASchrankenbaum() {
        return saSchrankenbaum;
    }

    /**
     * Legt den Wert der saSchrankenbaum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSASchrankenbaum }
     *     
     */
    public void setSASchrankenbaum(CSASchrankenbaum value) {
        this.saSchrankenbaum = value;
    }

    /**
     * Ruft den Wert der schrankenantriebAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSchrankenantriebAllg }
     *     
     */
    public CSchrankenantriebAllg getSchrankenantriebAllg() {
        return schrankenantriebAllg;
    }

    /**
     * Legt den Wert der schrankenantriebAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSchrankenantriebAllg }
     *     
     */
    public void setSchrankenantriebAllg(CSchrankenantriebAllg value) {
        this.schrankenantriebAllg = value;
    }

}
