//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CPolygone_Betrachtungsbereich complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPolygone_Betrachtungsbereich">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Koordinatensystem_BB" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCKoordinatensystem_BB"/>
 *         &lt;element name="Polygonzug_Betrachtungsbereich" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCPolygonzug_Betrachtungsbereich" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPolygone_Betrachtungsbereich", propOrder = {
    "koordinatensystemBB",
    "polygonzugBetrachtungsbereich"
})
public class CPolygoneBetrachtungsbereich {

    @XmlElement(name = "Koordinatensystem_BB", required = true)
    protected TCKoordinatensystemBB koordinatensystemBB;
    @XmlElement(name = "Polygonzug_Betrachtungsbereich", required = true)
    protected List<TCPolygonzugBetrachtungsbereich> polygonzugBetrachtungsbereich;

    /**
     * Ruft den Wert der koordinatensystemBB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKoordinatensystemBB }
     *     
     */
    public TCKoordinatensystemBB getKoordinatensystemBB() {
        return koordinatensystemBB;
    }

    /**
     * Legt den Wert der koordinatensystemBB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKoordinatensystemBB }
     *     
     */
    public void setKoordinatensystemBB(TCKoordinatensystemBB value) {
        this.koordinatensystemBB = value;
    }

    /**
     * Gets the value of the polygonzugBetrachtungsbereich property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the polygonzugBetrachtungsbereich property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPolygonzugBetrachtungsbereich().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCPolygonzugBetrachtungsbereich }
     * 
     * 
     */
    public List<TCPolygonzugBetrachtungsbereich> getPolygonzugBetrachtungsbereich() {
        if (polygonzugBetrachtungsbereich == null) {
            polygonzugBetrachtungsbereich = new ArrayList<TCPolygonzugBetrachtungsbereich>();
        }
        return this.polygonzugBetrachtungsbereich;
    }

}
