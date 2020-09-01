//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.basisobjekte._1_8;

import modell.verweise._1_8.TCIDAnhang;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Anhang in Form von Datei oder Text zu einem Objekt oder Attribut. Jeder zugelassene Projektbeteiligte kann zu einem Objekt oder Attribut einen Bearbeitungsvermerk anf�gen, sofern er die entsprechend notwendige Berechtigung besitzt. Dies gilt f�r fachliche wie organisatorische Objekte und Attribute. F�r ENUM-Attribute ist bei Auswahl des Werts \"sonstige\" zwingend ein Bearbeitungsvermerk anzuf�gen. Eine Dokumentenbeigabe ist dabei optional. Zu einem Objekt oder Attribut k�nnen mehrere Bearbeitungsvermerke erstellt werden. Der Bearbeitungsvermerk enth�lt vorl�ufig eine GUID zur Identifikation des Bearbeiters sowie eine GUID f�r die Signatur. Im Attribut �Bearbeitungsvermerk Rolle� kann die fachliche Rolle des Bearbeiters abgelegt werden. Kommentare des Bearbeiters werden als Freitext im Attribut �Kommentar� hinterlegt. Der Bearbeitungsvermerk kann einen Anhang aufnehmen. Um mehrere Anh�nge zu einem Objekt zuzuordnen, m�ssen mehrere Bearbeitungsvermerke erstellt werden.
 * 
 * <p>Java-Klasse f�r CBearbeitungsvermerk complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBearbeitungsvermerk">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bearbeitungsvermerk_Allg" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBearbeitungsvermerk_Allg"/>
 *         &lt;element name="ID_Anhang" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Anhang" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBearbeitungsvermerk", propOrder = {
    "bearbeitungsvermerkAllg",
    "idAnhang"
})
public class CBearbeitungsvermerk
    extends CUrObjekt
{

    @XmlElement(name = "Bearbeitungsvermerk_Allg", required = true)
    protected CBearbeitungsvermerkAllg bearbeitungsvermerkAllg;
    @XmlElement(name = "ID_Anhang")
    protected TCIDAnhang idAnhang;

    /**
     * Ruft den Wert der bearbeitungsvermerkAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBearbeitungsvermerkAllg }
     *     
     */
    public CBearbeitungsvermerkAllg getBearbeitungsvermerkAllg() {
        return bearbeitungsvermerkAllg;
    }

    /**
     * Legt den Wert der bearbeitungsvermerkAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBearbeitungsvermerkAllg }
     *     
     */
    public void setBearbeitungsvermerkAllg(CBearbeitungsvermerkAllg value) {
        this.bearbeitungsvermerkAllg = value;
    }

    /**
     * Ruft den Wert der idAnhang-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhang() {
        return idAnhang;
    }

    /**
     * Legt den Wert der idAnhang-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhang(TCIDAnhang value) {
        this.idAnhang = value;
    }

}
