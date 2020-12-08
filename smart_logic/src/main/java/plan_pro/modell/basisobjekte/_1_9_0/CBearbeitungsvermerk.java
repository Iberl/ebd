//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basisobjekte._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDAnhang;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


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
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bearbeitungsvermerk_Allg" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBearbeitungsvermerk_Allg"/>
 *         &lt;element name="ID_Anhang" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang" maxOccurs="unbounded" minOccurs="0"/>
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
    protected List<TCIDAnhang> idAnhang;

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
     * Gets the value of the idAnhang property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idAnhang property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDAnhang().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDAnhang }
     * 
     * 
     */
    public List<TCIDAnhang> getIDAnhang() {
        if (idAnhang == null) {
            idAnhang = new ArrayList<TCIDAnhang>();
        }
        return this.idAnhang;
    }

}
