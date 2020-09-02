//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.planpro._1_8;

import modell.basisobjekte._1_8.CAnhang;
import modell.basisobjekte._1_8.CUrObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Konkreter Zustand der LST-Anlage. Bei der Verwendung des LST-Zustands wird unterschieden in: LST Zustand Information: f�r (Bestands-)Ausk�nfte; Kombination aus LST Zustand Start und LST Zustand Ziel innerhalb einer Planung Einzel zur Abbildung der durch eine Planung verursachten �nderung des Zustands der LST-Anlage. Es erfolgt eine alphabetische Auflistung der Objektinstanzen in der Attributgruppe \�Container\�.
 * 
 * <p>Java-Klasse f�r CLST_Zustand complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLST_Zustand">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Anhang_LST_Zustand" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CAnhang" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Container" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CContainer"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLST_Zustand", propOrder = {
    "anhangLSTZustand",
    "container"
})
public class CLSTZustand
    extends CUrObjekt
{

    @XmlElement(name = "Anhang_LST_Zustand")
    protected List<CAnhang> anhangLSTZustand;
    @XmlElement(name = "Container", required = true)
    protected CContainer container;

    /**
     * Gets the value of the anhangLSTZustand property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anhangLSTZustand property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnhangLSTZustand().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAnhang }
     * 
     * 
     */
    public List<CAnhang> getAnhangLSTZustand() {
        if (anhangLSTZustand == null) {
            anhangLSTZustand = new ArrayList<CAnhang>();
        }
        return this.anhangLSTZustand;
    }

    /**
     * Ruft den Wert der container-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CContainer }
     *     
     */
    public CContainer getContainer() {
        return container;
    }

    /**
     * Legt den Wert der container-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CContainer }
     *     
     */
    public void setContainer(CContainer value) {
        this.container = value;
    }

}
