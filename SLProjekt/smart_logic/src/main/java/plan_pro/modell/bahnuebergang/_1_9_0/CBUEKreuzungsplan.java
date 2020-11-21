//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDAnhangOhneProxy;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Verortungspunkte des f�r die B�-Planung verwendeten bautechnischen B�-Kreuzungsplans. Sofern der Anhang nicht als GeoTiff vorliegt, sind mindestens 2 Verortungspunkte anzugeben.
 * 
 * <p>Java-Klasse f�r CBUE_Kreuzungsplan complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Kreuzungsplan">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="BUE_Kreuzungsplan_Koordinaten" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CBUE_Kreuzungsplan_Koordinaten" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_Anhang_Kreuzungsplan" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang_ohne_Proxy"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Kreuzungsplan", propOrder = {
    "bueKreuzungsplanKoordinaten",
    "idAnhangKreuzungsplan"
})
public class CBUEKreuzungsplan
    extends CBasisObjekt
{

    @XmlElement(name = "BUE_Kreuzungsplan_Koordinaten")
    protected List<CBUEKreuzungsplanKoordinaten> bueKreuzungsplanKoordinaten;
    @XmlElement(name = "ID_Anhang_Kreuzungsplan", required = true)
    protected TCIDAnhangOhneProxy idAnhangKreuzungsplan;

    /**
     * Gets the value of the bueKreuzungsplanKoordinaten property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bueKreuzungsplanKoordinaten property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBUEKreuzungsplanKoordinaten().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBUEKreuzungsplanKoordinaten }
     * 
     * 
     */
    public List<CBUEKreuzungsplanKoordinaten> getBUEKreuzungsplanKoordinaten() {
        if (bueKreuzungsplanKoordinaten == null) {
            bueKreuzungsplanKoordinaten = new ArrayList<CBUEKreuzungsplanKoordinaten>();
        }
        return this.bueKreuzungsplanKoordinaten;
    }

    /**
     * Ruft den Wert der idAnhangKreuzungsplan-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhangOhneProxy }
     *     
     */
    public TCIDAnhangOhneProxy getIDAnhangKreuzungsplan() {
        return idAnhangKreuzungsplan;
    }

    /**
     * Legt den Wert der idAnhangKreuzungsplan-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhangOhneProxy }
     *     
     */
    public void setIDAnhangKreuzungsplan(TCIDAnhangOhneProxy value) {
        this.idAnhangKreuzungsplan = value;
    }

}
