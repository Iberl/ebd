//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektTOPKante;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CKnoten_Auf_TOP_Kante complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CKnoten_Auf_TOP_Kante">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ETCS_Knoten_Art_Sonstige" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCETCS_Knoten_Art_Sonstige"/>
 *         &lt;element name="Punkt_Objekt_TOP_Kante" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CPunkt_Objekt_TOP_Kante" maxOccurs="2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CKnoten_Auf_TOP_Kante", propOrder = {
    "etcsKnotenArtSonstige",
    "punktObjektTOPKante"
})
public class CKnotenAufTOPKante {

    @XmlElement(name = "ETCS_Knoten_Art_Sonstige", required = true)
    protected TCETCSKnotenArtSonstige etcsKnotenArtSonstige;
    @XmlElement(name = "Punkt_Objekt_TOP_Kante", required = true)
    protected List<CPunktObjektTOPKante> punktObjektTOPKante;

    /**
     * Ruft den Wert der etcsKnotenArtSonstige-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCETCSKnotenArtSonstige }
     *     
     */
    public TCETCSKnotenArtSonstige getETCSKnotenArtSonstige() {
        return etcsKnotenArtSonstige;
    }

    /**
     * Legt den Wert der etcsKnotenArtSonstige-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCETCSKnotenArtSonstige }
     *     
     */
    public void setETCSKnotenArtSonstige(TCETCSKnotenArtSonstige value) {
        this.etcsKnotenArtSonstige = value;
    }

    /**
     * Gets the value of the punktObjektTOPKante property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the punktObjektTOPKante property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPunktObjektTOPKante().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CPunktObjektTOPKante }
     * 
     * 
     */
    public List<CPunktObjektTOPKante> getPunktObjektTOPKante() {
        if (punktObjektTOPKante == null) {
            punktObjektTOPKante = new ArrayList<CPunktObjektTOPKante>();
        }
        return this.punktObjektTOPKante;
    }

}
