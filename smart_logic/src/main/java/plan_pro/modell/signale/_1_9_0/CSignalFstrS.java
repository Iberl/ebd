//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.signale._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDSchaltmittelZuordnung;
import plan_pro.modell.verweise._1_9_0.TCIDZweitesHaltfallkriterium;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CSignal_Fstr_S complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_Fstr_S">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Gegengleis" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}TCGegengleis" minOccurs="0"/>
 *         &lt;element name="ID_Anrueckverschluss" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Schaltmittel_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_Zweites_Haltfallkriterium" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Zweites_Haltfallkriterium" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_Fstr_S", propOrder = {
    "gegengleis",
    "idAnrueckverschluss",
    "idZweitesHaltfallkriterium"
})
public class CSignalFstrS {

    @XmlElement(name = "Gegengleis")
    protected TCGegengleis gegengleis;
    @XmlElement(name = "ID_Anrueckverschluss")
    protected List<TCIDSchaltmittelZuordnung> idAnrueckverschluss;
    @XmlElement(name = "ID_Zweites_Haltfallkriterium")
    protected TCIDZweitesHaltfallkriterium idZweitesHaltfallkriterium;

    /**
     * Ruft den Wert der gegengleis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGegengleis }
     *     
     */
    public TCGegengleis getGegengleis() {
        return gegengleis;
    }

    /**
     * Legt den Wert der gegengleis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGegengleis }
     *     
     */
    public void setGegengleis(TCGegengleis value) {
        this.gegengleis = value;
    }

    /**
     * Gets the value of the idAnrueckverschluss property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idAnrueckverschluss property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDAnrueckverschluss().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDSchaltmittelZuordnung }
     * 
     * 
     */
    public List<TCIDSchaltmittelZuordnung> getIDAnrueckverschluss() {
        if (idAnrueckverschluss == null) {
            idAnrueckverschluss = new ArrayList<TCIDSchaltmittelZuordnung>();
        }
        return this.idAnrueckverschluss;
    }

    /**
     * Ruft den Wert der idZweitesHaltfallkriterium-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZweitesHaltfallkriterium }
     *     
     */
    public TCIDZweitesHaltfallkriterium getIDZweitesHaltfallkriterium() {
        return idZweitesHaltfallkriterium;
    }

    /**
     * Legt den Wert der idZweitesHaltfallkriterium-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZweitesHaltfallkriterium }
     *     
     */
    public void setIDZweitesHaltfallkriterium(TCIDZweitesHaltfallkriterium value) {
        this.idZweitesHaltfallkriterium = value;
    }

}
