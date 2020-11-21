//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.medien_und_trassen._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDAnschlussElement;
import plan_pro.modell.verweise._1_9_0.TCIDGEOKnoten;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Knoten des topologischen Knoten-Kanten-Modells zur Darstellung des Kabelgef��systems (Kabeltrasse) oder gleichartiger Medientrassen. Der Trasse_Knoten verweist auf einen GEO_Knoten. Die Anzahl der an den Trasse_Knoten anschlie�enden topologischen Kanten ist je nach Art des Trasse_Knoten unterschiedlich und muss mit der Anzahl der an den zugeh�rigen GEO Knoten anschlie�enden GEO_Kanten �bereinstimmen. 
 * 
 * <p>Java-Klasse f�r CTrasse_Knoten complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CTrasse_Knoten">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Anschluss_Element" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anschluss_Element" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_GEO_Knoten" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_GEO_Knoten"/>
 *         &lt;element name="Trasse_Knoten_Art" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}TCTrasse_Knoten_Art"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTrasse_Knoten", propOrder = {
    "idAnschlussElement",
    "idgeoKnoten",
    "trasseKnotenArt"
})
public class CTrasseKnoten
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Anschluss_Element")
    protected List<TCIDAnschlussElement> idAnschlussElement;
    @XmlElement(name = "ID_GEO_Knoten", required = true)
    protected TCIDGEOKnoten idgeoKnoten;
    @XmlElement(name = "Trasse_Knoten_Art", required = true)
    protected TCTrasseKnotenArt trasseKnotenArt;

    /**
     * Gets the value of the idAnschlussElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idAnschlussElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDAnschlussElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDAnschlussElement }
     * 
     * 
     */
    public List<TCIDAnschlussElement> getIDAnschlussElement() {
        if (idAnschlussElement == null) {
            idAnschlussElement = new ArrayList<TCIDAnschlussElement>();
        }
        return this.idAnschlussElement;
    }

    /**
     * Ruft den Wert der idgeoKnoten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGEOKnoten }
     *     
     */
    public TCIDGEOKnoten getIDGEOKnoten() {
        return idgeoKnoten;
    }

    /**
     * Legt den Wert der idgeoKnoten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGEOKnoten }
     *     
     */
    public void setIDGEOKnoten(TCIDGEOKnoten value) {
        this.idgeoKnoten = value;
    }

    /**
     * Ruft den Wert der trasseKnotenArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTrasseKnotenArt }
     *     
     */
    public TCTrasseKnotenArt getTrasseKnotenArt() {
        return trasseKnotenArt;
    }

    /**
     * Legt den Wert der trasseKnotenArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTrasseKnotenArt }
     *     
     */
    public void setTrasseKnotenArt(TCTrasseKnotenArt value) {
        this.trasseKnotenArt = value;
    }

}
