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
 * <p>Java-Klasse f�r CPlanung_E_Handlung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPlanung_E_Handlung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Planung_E_Abnahme" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CAkteur_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Planung_E_Erstellung" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CAkteur_Zuordnung" maxOccurs="unbounded"/>
 *         &lt;element name="Planung_E_Freigabe" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CAkteur_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Planung_E_Genehmigung" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CAkteur_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Planung_E_Gleichstellung" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CAkteur_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Planung_E_Pruefung" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CAkteur_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Planung_E_Qualitaetspruefung" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CAkteur_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Planung_E_Sonstige" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CAkteur_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Planung_E_Uebernahme" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CAkteur_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPlanung_E_Handlung", propOrder = {
    "planungEAbnahme",
    "planungEErstellung",
    "planungEFreigabe",
    "planungEGenehmigung",
    "planungEGleichstellung",
    "planungEPruefung",
    "planungEQualitaetspruefung",
    "planungESonstige",
    "planungEUebernahme"
})
public class CPlanungEHandlung {

    @XmlElement(name = "Planung_E_Abnahme")
    protected List<CAkteurZuordnung> planungEAbnahme;
    @XmlElement(name = "Planung_E_Erstellung", required = true)
    protected List<CAkteurZuordnung> planungEErstellung;
    @XmlElement(name = "Planung_E_Freigabe")
    protected List<CAkteurZuordnung> planungEFreigabe;
    @XmlElement(name = "Planung_E_Genehmigung")
    protected List<CAkteurZuordnung> planungEGenehmigung;
    @XmlElement(name = "Planung_E_Gleichstellung")
    protected List<CAkteurZuordnung> planungEGleichstellung;
    @XmlElement(name = "Planung_E_Pruefung")
    protected List<CAkteurZuordnung> planungEPruefung;
    @XmlElement(name = "Planung_E_Qualitaetspruefung")
    protected List<CAkteurZuordnung> planungEQualitaetspruefung;
    @XmlElement(name = "Planung_E_Sonstige")
    protected List<CAkteurZuordnung> planungESonstige;
    @XmlElement(name = "Planung_E_Uebernahme")
    protected List<CAkteurZuordnung> planungEUebernahme;

    /**
     * Gets the value of the planungEAbnahme property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planungEAbnahme property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanungEAbnahme().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAkteurZuordnung }
     * 
     * 
     */
    public List<CAkteurZuordnung> getPlanungEAbnahme() {
        if (planungEAbnahme == null) {
            planungEAbnahme = new ArrayList<CAkteurZuordnung>();
        }
        return this.planungEAbnahme;
    }

    /**
     * Gets the value of the planungEErstellung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planungEErstellung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanungEErstellung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAkteurZuordnung }
     * 
     * 
     */
    public List<CAkteurZuordnung> getPlanungEErstellung() {
        if (planungEErstellung == null) {
            planungEErstellung = new ArrayList<CAkteurZuordnung>();
        }
        return this.planungEErstellung;
    }

    /**
     * Gets the value of the planungEFreigabe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planungEFreigabe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanungEFreigabe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAkteurZuordnung }
     * 
     * 
     */
    public List<CAkteurZuordnung> getPlanungEFreigabe() {
        if (planungEFreigabe == null) {
            planungEFreigabe = new ArrayList<CAkteurZuordnung>();
        }
        return this.planungEFreigabe;
    }

    /**
     * Gets the value of the planungEGenehmigung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planungEGenehmigung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanungEGenehmigung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAkteurZuordnung }
     * 
     * 
     */
    public List<CAkteurZuordnung> getPlanungEGenehmigung() {
        if (planungEGenehmigung == null) {
            planungEGenehmigung = new ArrayList<CAkteurZuordnung>();
        }
        return this.planungEGenehmigung;
    }

    /**
     * Gets the value of the planungEGleichstellung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planungEGleichstellung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanungEGleichstellung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAkteurZuordnung }
     * 
     * 
     */
    public List<CAkteurZuordnung> getPlanungEGleichstellung() {
        if (planungEGleichstellung == null) {
            planungEGleichstellung = new ArrayList<CAkteurZuordnung>();
        }
        return this.planungEGleichstellung;
    }

    /**
     * Gets the value of the planungEPruefung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planungEPruefung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanungEPruefung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAkteurZuordnung }
     * 
     * 
     */
    public List<CAkteurZuordnung> getPlanungEPruefung() {
        if (planungEPruefung == null) {
            planungEPruefung = new ArrayList<CAkteurZuordnung>();
        }
        return this.planungEPruefung;
    }

    /**
     * Gets the value of the planungEQualitaetspruefung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planungEQualitaetspruefung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanungEQualitaetspruefung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAkteurZuordnung }
     * 
     * 
     */
    public List<CAkteurZuordnung> getPlanungEQualitaetspruefung() {
        if (planungEQualitaetspruefung == null) {
            planungEQualitaetspruefung = new ArrayList<CAkteurZuordnung>();
        }
        return this.planungEQualitaetspruefung;
    }

    /**
     * Gets the value of the planungESonstige property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planungESonstige property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanungESonstige().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAkteurZuordnung }
     * 
     * 
     */
    public List<CAkteurZuordnung> getPlanungESonstige() {
        if (planungESonstige == null) {
            planungESonstige = new ArrayList<CAkteurZuordnung>();
        }
        return this.planungESonstige;
    }

    /**
     * Gets the value of the planungEUebernahme property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planungEUebernahme property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanungEUebernahme().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAkteurZuordnung }
     * 
     * 
     */
    public List<CAkteurZuordnung> getPlanungEUebernahme() {
        if (planungEUebernahme == null) {
            planungEUebernahme = new ArrayList<CAkteurZuordnung>();
        }
        return this.planungEUebernahme;
    }

}
