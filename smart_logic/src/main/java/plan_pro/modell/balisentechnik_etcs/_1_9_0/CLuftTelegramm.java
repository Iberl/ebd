//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.basistypen._1_9_0.CEigenschaftenDatei;
import plan_pro.modell.verweise._1_9_0.TCIDAnhang;
import plan_pro.modell.verweise._1_9_0.TCIDBaliseOhneProxy;
import plan_pro.modell.verweise._1_9_0.TCIDBinaerdateiOhneProxy;
import plan_pro.modell.verweise._1_9_0.TCIDFachtelegramm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Zuordnung des Telegramms (Binaerdatei) zur Balise, von der das Telegramm an das Fahrzeug �bertragen wird. Das Telegramm kann dabei in der Balise gespeichert sein oder von der LEU an die Balise gesendet werden.
 * 
 * <p>Java-Klasse f�r CLuft_Telegramm complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLuft_Telegramm">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Eigenschaften_Binaerdatei" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}CEigenschaften_Datei"/>
 *         &lt;element name="Eigenschaften_Binaerdatei_Hilfe" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}CEigenschaften_Datei" minOccurs="0"/>
 *         &lt;element name="ID_Anhang_EA_Doku" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang"/>
 *         &lt;element name="ID_Balise_Uebertragung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Balise_ohne_Proxy"/>
 *         &lt;element name="ID_Binaerdatei" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Binaerdatei_ohne_Proxy"/>
 *         &lt;element name="ID_Binaerdatei_Hilfe" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Binaerdatei_ohne_Proxy" minOccurs="0"/>
 *         &lt;element name="ID_Fachtelegramm" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fachtelegramm"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLuft_Telegramm", propOrder = {
    "eigenschaftenBinaerdatei",
    "eigenschaftenBinaerdateiHilfe",
    "idAnhangEADoku",
    "idBaliseUebertragung",
    "idBinaerdatei",
    "idBinaerdateiHilfe",
    "idFachtelegramm"
})
public class CLuftTelegramm
    extends CBasisObjekt
{

    @XmlElement(name = "Eigenschaften_Binaerdatei", required = true)
    protected CEigenschaftenDatei eigenschaftenBinaerdatei;
    @XmlElement(name = "Eigenschaften_Binaerdatei_Hilfe")
    protected CEigenschaftenDatei eigenschaftenBinaerdateiHilfe;
    @XmlElement(name = "ID_Anhang_EA_Doku", required = true)
    protected TCIDAnhang idAnhangEADoku;
    @XmlElement(name = "ID_Balise_Uebertragung", required = true)
    protected TCIDBaliseOhneProxy idBaliseUebertragung;
    @XmlElement(name = "ID_Binaerdatei", required = true)
    protected TCIDBinaerdateiOhneProxy idBinaerdatei;
    @XmlElement(name = "ID_Binaerdatei_Hilfe")
    protected TCIDBinaerdateiOhneProxy idBinaerdateiHilfe;
    @XmlElement(name = "ID_Fachtelegramm", required = true)
    protected TCIDFachtelegramm idFachtelegramm;

    /**
     * Ruft den Wert der eigenschaftenBinaerdatei-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CEigenschaftenDatei }
     *     
     */
    public CEigenschaftenDatei getEigenschaftenBinaerdatei() {
        return eigenschaftenBinaerdatei;
    }

    /**
     * Legt den Wert der eigenschaftenBinaerdatei-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CEigenschaftenDatei }
     *     
     */
    public void setEigenschaftenBinaerdatei(CEigenschaftenDatei value) {
        this.eigenschaftenBinaerdatei = value;
    }

    /**
     * Ruft den Wert der eigenschaftenBinaerdateiHilfe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CEigenschaftenDatei }
     *     
     */
    public CEigenschaftenDatei getEigenschaftenBinaerdateiHilfe() {
        return eigenschaftenBinaerdateiHilfe;
    }

    /**
     * Legt den Wert der eigenschaftenBinaerdateiHilfe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CEigenschaftenDatei }
     *     
     */
    public void setEigenschaftenBinaerdateiHilfe(CEigenschaftenDatei value) {
        this.eigenschaftenBinaerdateiHilfe = value;
    }

    /**
     * Ruft den Wert der idAnhangEADoku-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangEADoku() {
        return idAnhangEADoku;
    }

    /**
     * Legt den Wert der idAnhangEADoku-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangEADoku(TCIDAnhang value) {
        this.idAnhangEADoku = value;
    }

    /**
     * Ruft den Wert der idBaliseUebertragung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBaliseOhneProxy }
     *     
     */
    public TCIDBaliseOhneProxy getIDBaliseUebertragung() {
        return idBaliseUebertragung;
    }

    /**
     * Legt den Wert der idBaliseUebertragung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBaliseOhneProxy }
     *     
     */
    public void setIDBaliseUebertragung(TCIDBaliseOhneProxy value) {
        this.idBaliseUebertragung = value;
    }

    /**
     * Ruft den Wert der idBinaerdatei-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBinaerdateiOhneProxy }
     *     
     */
    public TCIDBinaerdateiOhneProxy getIDBinaerdatei() {
        return idBinaerdatei;
    }

    /**
     * Legt den Wert der idBinaerdatei-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBinaerdateiOhneProxy }
     *     
     */
    public void setIDBinaerdatei(TCIDBinaerdateiOhneProxy value) {
        this.idBinaerdatei = value;
    }

    /**
     * Ruft den Wert der idBinaerdateiHilfe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBinaerdateiOhneProxy }
     *     
     */
    public TCIDBinaerdateiOhneProxy getIDBinaerdateiHilfe() {
        return idBinaerdateiHilfe;
    }

    /**
     * Legt den Wert der idBinaerdateiHilfe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBinaerdateiOhneProxy }
     *     
     */
    public void setIDBinaerdateiHilfe(TCIDBinaerdateiOhneProxy value) {
        this.idBinaerdateiHilfe = value;
    }

    /**
     * Ruft den Wert der idFachtelegramm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFachtelegramm }
     *     
     */
    public TCIDFachtelegramm getIDFachtelegramm() {
        return idFachtelegramm;
    }

    /**
     * Legt den Wert der idFachtelegramm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFachtelegramm }
     *     
     */
    public void setIDFachtelegramm(TCIDFachtelegramm value) {
        this.idFachtelegramm = value;
    }

}
