//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBedienBezirk;
import plan_pro.modell.verweise._1_9_0.TCIDOertlichkeitProxy;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Zuordnung einer Oertlichkeit zum Bedien Bezirk, aus dem sie bedient wird. Dabei werden in diesem Zuordnungsobjekt die vorhandenen Angaben aus dem Objekt �rtlichkeit der jeweiligen Betriebsstelle um weitere Angaben wie beispielsweise die ESTW-Kennzahl oder den Betriebsstellenbezeichner (Streckenziel) planerisch angereichert. Gem�� Richtlinie 819.0603 m�ssen die ESTW-Kennzahlen und Betriebsstellenbezeichner im Steuerbezirk und an seinen Grenzen eindeutig (einmalig) sein. Diese Regel kann nicht �ber das Modell abgebildet werden, sondern muss in der Plausibilit�ts- und Zul�ssigkeitspr�fung (PlaZ) abgefangen werden. Siehe Beispiel Media:Lupen HBS1.pdf \"Bf Braunschweig Hbf (HBS) 30\": Betriebsstellenbezeichner ==\u0026gt; \"Bf Braunschweig Hbf\", Oertlichkeit ==\u0026gt; \"HBS\", Kennzahl ==\u0026gt; \"30\". DB-Regelwerk 819.0603 
 * 
 * <p>Java-Klasse f�r CBedien_Oertlichkeit complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Oertlichkeit">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bedien_Oertlichkeit_Kennzahlen" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}CBedien_Oertlichkeit_Kennzahlen"/>
 *         &lt;element name="ID_Bedien_Bezirk" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Bedien_Bezirk"/>
 *         &lt;element name="ID_Oertlichkeit" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Oertlichkeit_Proxy"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Oertlichkeit", propOrder = {
    "bedienOertlichkeitKennzahlen",
    "idBedienBezirk",
    "idOertlichkeit"
})
public class CBedienOertlichkeit
    extends CBasisObjekt
{

    @XmlElement(name = "Bedien_Oertlichkeit_Kennzahlen", required = true)
    protected CBedienOertlichkeitKennzahlen bedienOertlichkeitKennzahlen;
    @XmlElement(name = "ID_Bedien_Bezirk", required = true)
    protected TCIDBedienBezirk idBedienBezirk;
    @XmlElement(name = "ID_Oertlichkeit", required = true)
    protected TCIDOertlichkeitProxy idOertlichkeit;

    /**
     * Ruft den Wert der bedienOertlichkeitKennzahlen-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedienOertlichkeitKennzahlen }
     *     
     */
    public CBedienOertlichkeitKennzahlen getBedienOertlichkeitKennzahlen() {
        return bedienOertlichkeitKennzahlen;
    }

    /**
     * Legt den Wert der bedienOertlichkeitKennzahlen-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedienOertlichkeitKennzahlen }
     *     
     */
    public void setBedienOertlichkeitKennzahlen(CBedienOertlichkeitKennzahlen value) {
        this.bedienOertlichkeitKennzahlen = value;
    }

    /**
     * Ruft den Wert der idBedienBezirk-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBedienBezirk }
     *     
     */
    public TCIDBedienBezirk getIDBedienBezirk() {
        return idBedienBezirk;
    }

    /**
     * Legt den Wert der idBedienBezirk-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBedienBezirk }
     *     
     */
    public void setIDBedienBezirk(TCIDBedienBezirk value) {
        this.idBedienBezirk = value;
    }

    /**
     * Ruft den Wert der idOertlichkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public TCIDOertlichkeitProxy getIDOertlichkeit() {
        return idOertlichkeit;
    }

    /**
     * Legt den Wert der idOertlichkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public void setIDOertlichkeit(TCIDOertlichkeitProxy value) {
        this.idOertlichkeit = value;
    }

}
