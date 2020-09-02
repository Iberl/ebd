//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.geodaten._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDGEOArt;
import modell.verweise._1_8.TCIDGEOKnoten;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Kante des topografischen Knoten-Kanten-Modells. Die GEO_Kante ist vom GEO_Knoten A zum GEO_Knoten B gerichtet (GEO Richtungswinkel) und muss immer an zwei GEO_Knoten enden. Die L�nge einer GEO_Kante zwischen den GEO_Knoten A und B entspricht der realen Gleisl�nge zwischen diesen Knoten und wird im Attribut GEO Laenge gespeichert. Mit Bezug auf die Regeln zu den Gleisnetzdaten (GND) ist die L�nge einer GEO_Kante stets kleiner 10 km. Eine GEO_Kante besitzt eine geometrische Form, die durch GEO Form beschrieben wird. GEO_Kanten werden f�r die Abbildung der Gleislinie und der Kilometrierungslinie verwendet. Eine Unterscheidung dieser Anwendung erfolgt durch den Verweis ID GEO Art. Der GEO_Radius (GEO Radius A und GEO Radius B) ist negativ, wenn die GEO_Kante vom GEO_Knoten_A in einem Linksbogen f�hrt und ist positiv, wenn diese in einen Rechtsbogen f�hrt. Die beiden Radien sind jeweils der Radius an der A- bzw. B-Seite der GEO_Kante. Bei einem Kreisbogen wird nur der GEO Radius A angegeben. F�r eine Gerade wird dieser Radius mit 0.000 definiert. Ein Algorithmus zur Darstellung eines Punktes auf einem �bergangsbogen kann der folgenden Literaturquelle entnommen werden: Media:Literatur Uebergangsbogen.pdf. 
 * 
 * <p>Java-Klasse f�r CGEO_Kante complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGEO_Kante">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="GEO_Kante_Allg" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CGEO_Kante_Allg"/>
 *         &lt;element name="ID_GEO_Art" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_GEO_Art"/>
 *         &lt;element name="ID_GEO_Knoten_A" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_GEO_Knoten"/>
 *         &lt;element name="ID_GEO_Knoten_B" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_GEO_Knoten"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGEO_Kante", propOrder = {
    "geoKanteAllg",
    "idgeoArt",
    "idgeoKnotenA",
    "idgeoKnotenB"
})
public class CGEOKante
    extends CBasisObjekt
{

    @XmlElement(name = "GEO_Kante_Allg", required = true)
    protected CGEOKanteAllg geoKanteAllg;
    @XmlElement(name = "ID_GEO_Art", required = true)
    protected TCIDGEOArt idgeoArt;
    @XmlElement(name = "ID_GEO_Knoten_A", required = true)
    protected TCIDGEOKnoten idgeoKnotenA;
    @XmlElement(name = "ID_GEO_Knoten_B", required = true)
    protected TCIDGEOKnoten idgeoKnotenB;

    /**
     * Ruft den Wert der geoKanteAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CGEOKanteAllg }
     *     
     */
    public CGEOKanteAllg getGEOKanteAllg() {
        return geoKanteAllg;
    }

    /**
     * Legt den Wert der geoKanteAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CGEOKanteAllg }
     *     
     */
    public void setGEOKanteAllg(CGEOKanteAllg value) {
        this.geoKanteAllg = value;
    }

    /**
     * Ruft den Wert der idgeoArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGEOArt }
     *     
     */
    public TCIDGEOArt getIDGEOArt() {
        return idgeoArt;
    }

    /**
     * Legt den Wert der idgeoArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGEOArt }
     *     
     */
    public void setIDGEOArt(TCIDGEOArt value) {
        this.idgeoArt = value;
    }

    /**
     * Ruft den Wert der idgeoKnotenA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGEOKnoten }
     *     
     */
    public TCIDGEOKnoten getIDGEOKnotenA() {
        return idgeoKnotenA;
    }

    /**
     * Legt den Wert der idgeoKnotenA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGEOKnoten }
     *     
     */
    public void setIDGEOKnotenA(TCIDGEOKnoten value) {
        this.idgeoKnotenA = value;
    }

    /**
     * Ruft den Wert der idgeoKnotenB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGEOKnoten }
     *     
     */
    public TCIDGEOKnoten getIDGEOKnotenB() {
        return idgeoKnotenB;
    }

    /**
     * Legt den Wert der idgeoKnotenB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGEOKnoten }
     *     
     */
    public void setIDGEOKnotenB(TCIDGEOKnoten value) {
        this.idgeoKnotenB = value;
    }

}
