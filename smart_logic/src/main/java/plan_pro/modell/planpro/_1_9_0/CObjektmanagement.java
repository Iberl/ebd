//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CObjektmanagement complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CObjektmanagement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LST_Planung_Projekt" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CPlanung_Projekt" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CObjektmanagement", propOrder = {
    "lstPlanungProjekt"
})
public class CObjektmanagement {

    @XmlElement(name = "LST_Planung_Projekt", required = true)
    protected List<CPlanungProjekt> lstPlanungProjekt;

    /**
     * Gets the value of the lstPlanungProjekt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lstPlanungProjekt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLSTPlanungProjekt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CPlanungProjekt }
     * 
     * 
     */
    public List<CPlanungProjekt> getLSTPlanungProjekt() {
        if (lstPlanungProjekt == null) {
            lstPlanungProjekt = new ArrayList<CPlanungProjekt>();
        }
        return this.lstPlanungProjekt;
    }

}
