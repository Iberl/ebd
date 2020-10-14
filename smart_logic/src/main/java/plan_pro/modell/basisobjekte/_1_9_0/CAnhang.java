//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basisobjekte._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Erm�glicht die Aufnahme von Anhangsdokumenten in das Modell. Das Objekt Anhang erlaubt es, im PlanPro Datenmodell Informationen aus bestehenden Dateien vorzuhalten, die nicht durch ein eigenes Objekt im Modell abgebildet sind. Diese Informationen entsprechen den im bisherigen papiergebundenen Prozess beigef�gten Anlagen, eben den Anh�ngen. Die erlaubten Typen von Anh�ngen sind im Attribut �Anhang Art� definiert. Der Dateiname der Ursprungsdatei wird im Attribut �Dateiname� ohne die Endung abgelegt. Die erlaubte Endung wird im Attribut �Dateityp� definiert. Der eigentliche Inhalt der Ursprungsdatei wird im Attribut �Daten� als base64-codierte Bin�rdaten abgelegt. Ein Anhang wird im Datenmodell auf zwei Arten verwendet. Zum einen kann ein Anhang �ber das Objekt Bearbeitungsvermerk mit jedem Objekt oder Attribut verbunden werden. Dies ist in der Beschreibung des Objekts Bearbeitungsvermerk n�her erl�utert. Spezielle Anh�nge, die direkt in einem Objekt bei der Planung enthalten sein m�ssen, z.B. INA-Berechnung, werden direkt durch Attribute im jeweiligen Objekt definiert und so ohne den Umweg des Bearbeitungsvermerkes eingebunden.
 * 
 * <p>Java-Klasse f�r CAnhang complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CAnhang">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Anhang_Allg" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CAnhang_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CAnhang", propOrder = {
    "anhangAllg"
})
public class CAnhang
    extends CUrObjekt
{

    @XmlElement(name = "Anhang_Allg", required = true)
    protected CAnhangAllg anhangAllg;

    /**
     * Ruft den Wert der anhangAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CAnhangAllg }
     *     
     */
    public CAnhangAllg getAnhangAllg() {
        return anhangAllg;
    }

    /**
     * Legt den Wert der anhangAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CAnhangAllg }
     *     
     */
    public void setAnhangAllg(CAnhangAllg value) {
        this.anhangAllg = value;
    }

}
