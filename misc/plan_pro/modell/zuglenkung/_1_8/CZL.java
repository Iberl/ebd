//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zuglenkung._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDESTWZentraleinheit;
import modell.verweise._1_8.TCIDZN;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Anlage zur automatischen Einstellung von Fahrstra�en aufgrund von Zuglaufinformationen. Die Zuglenkung ist eine Anlage, die der Unterst�tzung des Betriebsablaufes dient. Aufgabe der Zuglenkung ist es, auf der Basis von Zuglaufinformationen und zugbezogenen Vorgaben f�r die Benutzung von Strecken- und Bahnhofsgleisen ohne unmittelbare Mitwirkung des Bedieners Stellkommandos an das zust�ndige Stellwerk auszugeben, ihre Ausf�hrung zu �berwachen und sich aus Meldungen des Stellwerkes ergebenden Handlungsbedarf an den Bediener weiterzugeben. Zuglaufinformationen erh�lt die Zuglenkung von der Zuglaufverfolgung (ZLV), die vorgesehene Benutzung der Strecken- und Bahnhofsgleise sowie Wartebedingungen einschlie�lich besonderer Bedingungen f�r die Regelung der Reihenfolge der Z�ge aus einem sogenannten Lenkplan, der in Form einer Gleisbenutzungstabelle (GBT) darstellbar ist. Alle Signale und Fahrstra�en, die mit der Zuglenkung behandelt werden, werden in dem Objekt Zuglenkung_Element aufgenommen und bekommen dort zus�tzliche Eigenschaften f�r die Nutzung in der ZL. Angaben zur Verwendung der Signale und zugeh�rigen Gleisabschnitte f�r die Lenkplanerstellung erfolgen in der Gleisbenutzungstabelle. DB-Regelwerk 819.0732 Gleisbenutzungstabelle Weitere Angaben finden sich im Lastenheft, das dem LST-Fachplaner nicht zur Verf�gung steht.
 * 
 * <p>Java-Klasse f�r CZL complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZL">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_ESTW_Zentraleinheit" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_ESTW_Zentraleinheit" minOccurs="0"/>
 *         &lt;element name="ID_ZN" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_ZN" minOccurs="0"/>
 *         &lt;element name="ZL_Allg" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}CZL_Allg"/>
 *         &lt;element name="ZL_ZN" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}CZL_ZN"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZL", propOrder = {
    "idestwZentraleinheit",
    "idzn",
    "zlAllg",
    "zlzn"
})
public class CZL
    extends CBasisObjekt
{

    @XmlElement(name = "ID_ESTW_Zentraleinheit")
    protected TCIDESTWZentraleinheit idestwZentraleinheit;
    @XmlElement(name = "ID_ZN")
    protected TCIDZN idzn;
    @XmlElement(name = "ZL_Allg", required = true)
    protected CZLAllg zlAllg;
    @XmlElement(name = "ZL_ZN", required = true)
    protected CZLZN zlzn;

    /**
     * Ruft den Wert der idestwZentraleinheit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDESTWZentraleinheit }
     *     
     */
    public TCIDESTWZentraleinheit getIDESTWZentraleinheit() {
        return idestwZentraleinheit;
    }

    /**
     * Legt den Wert der idestwZentraleinheit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDESTWZentraleinheit }
     *     
     */
    public void setIDESTWZentraleinheit(TCIDESTWZentraleinheit value) {
        this.idestwZentraleinheit = value;
    }

    /**
     * Ruft den Wert der idzn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZN }
     *     
     */
    public TCIDZN getIDZN() {
        return idzn;
    }

    /**
     * Legt den Wert der idzn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZN }
     *     
     */
    public void setIDZN(TCIDZN value) {
        this.idzn = value;
    }

    /**
     * Ruft den Wert der zlAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZLAllg }
     *     
     */
    public CZLAllg getZLAllg() {
        return zlAllg;
    }

    /**
     * Legt den Wert der zlAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZLAllg }
     *     
     */
    public void setZLAllg(CZLAllg value) {
        this.zlAllg = value;
    }

    /**
     * Ruft den Wert der zlzn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZLZN }
     *     
     */
    public CZLZN getZLZN() {
        return zlzn;
    }

    /**
     * Legt den Wert der zlzn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZLZN }
     *     
     */
    public void setZLZN(CZLZN value) {
        this.zlzn = value;
    }

}
