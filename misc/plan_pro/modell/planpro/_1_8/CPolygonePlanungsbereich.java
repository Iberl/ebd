//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.planpro._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CPolygone_Planungsbereich complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPolygone_Planungsbereich">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Koordinatensystem_PB" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCKoordinatensystem_PB"/>
 *         &lt;element name="Polygonzug_Planungsbereich" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCPolygonzug_Planungsbereich" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPolygone_Planungsbereich", propOrder = {
    "koordinatensystemPB",
    "polygonzugPlanungsbereich"
})
public class CPolygonePlanungsbereich {

    @XmlElement(name = "Koordinatensystem_PB", required = true)
    protected TCKoordinatensystemPB koordinatensystemPB;
    @XmlElement(name = "Polygonzug_Planungsbereich", required = true)
    protected List<TCPolygonzugPlanungsbereich> polygonzugPlanungsbereich;

    /**
     * Ruft den Wert der koordinatensystemPB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKoordinatensystemPB }
     *     
     */
    public TCKoordinatensystemPB getKoordinatensystemPB() {
        return koordinatensystemPB;
    }

    /**
     * Legt den Wert der koordinatensystemPB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKoordinatensystemPB }
     *     
     */
    public void setKoordinatensystemPB(TCKoordinatensystemPB value) {
        this.koordinatensystemPB = value;
    }

    /**
     * Gets the value of the polygonzugPlanungsbereich property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the polygonzugPlanungsbereich property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPolygonzugPlanungsbereich().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCPolygonzugPlanungsbereich }
     * 
     * 
     */
    public List<TCPolygonzugPlanungsbereich> getPolygonzugPlanungsbereich() {
        if (polygonzugPlanungsbereich == null) {
            polygonzugPlanungsbereich = new ArrayList<TCPolygonzugPlanungsbereich>();
        }
        return this.polygonzugPlanungsbereich;
    }

}