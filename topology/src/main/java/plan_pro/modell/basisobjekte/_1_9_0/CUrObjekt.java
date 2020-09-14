//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basisobjekte._1_9_0;

import plan_pro.modell.planpro._1_9_0.*;

import javax.xml.bind.annotation.*;


/**
 * Allen Objekten zugrundeliegender Objekttyp, durch die jede Instanz eines Objektes einen eindeutigen Identifikator in Form einer GUID erh�lt.
 * 
 * <p>Java-Klasse f�r CUr_Objekt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CUr_Objekt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Identitaet" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCIdentitaet"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CUr_Objekt", propOrder = {
    "identitaet"
})
@XmlSeeAlso({
    CAnhang.class,
    CBearbeitungsvermerk.class,
    CProxyObjekt.class,
    CPlanProSchnittstelle.class,
    CPlanungProjekt.class,
    CAkteur.class,
    CAusgabeFachdaten.class,
    COrganisation.class,
    CPlanungGruppe.class,
    CPlanungEinzel.class,
    CAkteurZuordnung.class,
    CLSTZustand.class,
    CBasisObjekt.class
})
public abstract class CUrObjekt {

    @XmlElement(name = "Identitaet", required = true)
    protected TCIdentitaet identitaet;

    /**
     * Ruft den Wert der identitaet-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIdentitaet }
     *     
     */
    public TCIdentitaet getIdentitaet() {
        return identitaet;
    }

    /**
     * Legt den Wert der identitaet-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIdentitaet }
     *     
     */
    public void setIdentitaet(TCIdentitaet value) {
        this.identitaet = value;
    }

}
