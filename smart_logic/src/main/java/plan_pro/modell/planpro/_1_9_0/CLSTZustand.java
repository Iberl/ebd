//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CAnhang;
import plan_pro.modell.basisobjekte._1_9_0.CUrObjekt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Konkreter Zustand der LST-Anlage.\nBei der Verwendung des LST-Zustands wird unterschieden in:\n* Einzelner LST_Zustand: f�r Bestandsdaten oder einzelne Zust�nde der Gleislage (Geodaten);\n* Kombination von LST_Zustand_Start und LST_Zustand_Ziel innerhalb einer Planung_Einzel zur Abbildung der durch eine Planung verursachten �nderung des Zustands der Gleislage bzw. LST-Anlage.\nEs erfolgt eine alphabetische Auflistung der Objektinstanzen in der Attributgruppe �Container�.\n\nDB Regelwerk\nBisher keine Abbildung, da Neuerung mit PlanPro.
 * 
 * <p>Java-Klasse f�r CLST_Zustand complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLST_Zustand">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Anhang_LST_Zustand" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CAnhang" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Container" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CContainer"/>
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
