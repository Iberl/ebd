//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.weichen_und_gleissperren._1_8;

import modell.basisobjekte._1_8.CPunktObjekt;
import modell.verweise._1_8.TCIDRegelzeichnung;
import modell.verweise._1_8.TCIDWKrGspElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Einzelner Teil der Weichenanlage (z. B. Zungenpaar, Herzstueckspitze) oder konstruktiver Mittelpunkt einer Kreuzung in Form von 2 Kreuzungsseiten. Mit Hilfe der W_Kr_Gsp_Komponente als punktf�rmiges Objekt wird die Verkn�pfung mit dem Knoten im Topologischen Modell hergestellt. Als Zuordnungspunkte f�r die Topologie und die Topographie werden Weichenknoten definiert. Die Verortung der Weichenkomponente ist in f�r die typischen Anwendungsf�lle in der Modellierung Weichen dargestellt. Bei einfachen Weichen entspricht der Weichenknoten dem Weichenanfang. Bei EKW und DKW entspricht der Weichenknoten dem Anfang der entsprechenden Zungenpaare (auch hier einheitlich als Weichenanfang bezeichnet). Bei einer Kreuzung wird der Mittelpunkt der Kreuzung als Weichenknoten verwendet. Beide Kreuzungsseiten werden jeweils auf die beiden sich kreuzenden TOP-Kanten verortet. Der Mittelpunkt einer Kreuzung ist kein TOP-Knoten und kein GEO-Knoten. Bei Gleissperren wird die Lage des Entgleisungsschuhs verortet. �ber die Seitliche Lage im Punkt Objekt wird die Schiene bestimmt, an der der Entgleisungsschuh angebracht ist. Die seitliche Lage wird im Bezug auf die Richtung der TOP_Kante angegeben und stellt nicht die Entgleisungsrichtung dar! Wenn die Weichenkomponente mit einem nicht mechanisch mit der Weiche verbundenen (Weichen-)Signal (z. B. R�ckfallweichensignal, Weichenlagemelder) ausger�stet werden soll, erfolgt die Modellierung dieses Signals als ein gesondertes Objekt Signal. Auf dieses Signal wird von W Kr Anlage (wenn die Anlage ein Signal hat) bzw. W Kr Gsp Element (wenn mehrere Elemete vorhanden sind und diese unterschiedliche Signale haben) verwiesen. Der Weichelagemelder einer DKW wird von den beiden W_Kr_Gsp_Element gesteuert, aber in einem Signal angezeigt. Er wird deshalb nur als ein Signal in der Weichenanlage modelliert. Ein mit der Weichenkomponente mechanisch verbundenes Weichensignal wird gem�� Regelzeichnung errichtet, wenn das Attribut Weichensignal gesetzt ist. Es wird dann kein gesondertes Signal modelliert. Siehe auch Modellierung Weichen. Die im Glossar mit (E) gekennzeichneten Attribute Radius_L und Radius_R sollen nicht mehr bef�llt werden, da ein k�nftiger Entfall vorgesehen ist. 
 * 
 * <p>Java-Klasse f�r CW_Kr_Gsp_Komponente complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CW_Kr_Gsp_Komponente">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Regelzeichnung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Regelzeichnung" minOccurs="0"/>
 *         &lt;element name="ID_W_Kr_Gsp_Element" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_W_Kr_Gsp_Element"/>
 *         &lt;choice>
 *           &lt;element name="Entgleisungsschuh" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}CEntgleisungsschuh"/>
 *           &lt;element name="Kreuzung" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}CKreuzung"/>
 *           &lt;element name="Zungenpaar" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}CZungenpaar"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CW_Kr_Gsp_Komponente", propOrder = {
    "idRegelzeichnung",
    "idwKrGspElement",
    "entgleisungsschuh",
    "kreuzung",
    "zungenpaar"
})
public class CWKrGspKomponente
    extends CPunktObjekt
{

    @XmlElement(name = "ID_Regelzeichnung")
    protected TCIDRegelzeichnung idRegelzeichnung;
    @XmlElement(name = "ID_W_Kr_Gsp_Element", required = true)
    protected TCIDWKrGspElement idwKrGspElement;
    @XmlElement(name = "Entgleisungsschuh")
    protected CEntgleisungsschuh entgleisungsschuh;
    @XmlElement(name = "Kreuzung")
    protected CKreuzung kreuzung;
    @XmlElement(name = "Zungenpaar")
    protected CZungenpaar zungenpaar;

    /**
     * Ruft den Wert der idRegelzeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDRegelzeichnung }
     *     
     */
    public TCIDRegelzeichnung getIDRegelzeichnung() {
        return idRegelzeichnung;
    }

    /**
     * Legt den Wert der idRegelzeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDRegelzeichnung }
     *     
     */
    public void setIDRegelzeichnung(TCIDRegelzeichnung value) {
        this.idRegelzeichnung = value;
    }

    /**
     * Ruft den Wert der idwKrGspElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public TCIDWKrGspElement getIDWKrGspElement() {
        return idwKrGspElement;
    }

    /**
     * Legt den Wert der idwKrGspElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public void setIDWKrGspElement(TCIDWKrGspElement value) {
        this.idwKrGspElement = value;
    }

    /**
     * Ruft den Wert der entgleisungsschuh-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CEntgleisungsschuh }
     *     
     */
    public CEntgleisungsschuh getEntgleisungsschuh() {
        return entgleisungsschuh;
    }

    /**
     * Legt den Wert der entgleisungsschuh-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CEntgleisungsschuh }
     *     
     */
    public void setEntgleisungsschuh(CEntgleisungsschuh value) {
        this.entgleisungsschuh = value;
    }

    /**
     * Ruft den Wert der kreuzung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CKreuzung }
     *     
     */
    public CKreuzung getKreuzung() {
        return kreuzung;
    }

    /**
     * Legt den Wert der kreuzung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CKreuzung }
     *     
     */
    public void setKreuzung(CKreuzung value) {
        this.kreuzung = value;
    }

    /**
     * Ruft den Wert der zungenpaar-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZungenpaar }
     *     
     */
    public CZungenpaar getZungenpaar() {
        return zungenpaar;
    }

    /**
     * Legt den Wert der zungenpaar-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZungenpaar }
     *     
     */
    public void setZungenpaar(CZungenpaar value) {
        this.zungenpaar = value;
    }

}
