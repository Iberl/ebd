//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zuglenkung._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDGleisAbschnitt;
import plan_pro.modell.verweise._1_9_0.TCIDZLDLPFstr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Sammlung der Gleisabschnitte, die in ZL DLP Fstr eingebunden werden und f�r die eine Pr�fung auf Deadlock erfolgen muss. DB-Regelwerk TM 2011-024 I.NVT 3 
 * 
 * <p>Java-Klasse f�r CZL_DLP_Abschnitt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZL_DLP_Abschnitt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Gleis_Abschnitt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Gleis_Abschnitt"/>
 *         &lt;element name="ID_ZL_DLP_Fstr" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZL_DLP_Fstr"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZL_DLP_Abschnitt", propOrder = {
    "idGleisAbschnitt",
    "idzldlpFstr"
})
public class CZLDLPAbschnitt
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Gleis_Abschnitt", required = true)
    protected TCIDGleisAbschnitt idGleisAbschnitt;
    @XmlElement(name = "ID_ZL_DLP_Fstr", required = true)
    protected TCIDZLDLPFstr idzldlpFstr;

    /**
     * Ruft den Wert der idGleisAbschnitt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGleisAbschnitt }
     *     
     */
    public TCIDGleisAbschnitt getIDGleisAbschnitt() {
        return idGleisAbschnitt;
    }

    /**
     * Legt den Wert der idGleisAbschnitt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGleisAbschnitt }
     *     
     */
    public void setIDGleisAbschnitt(TCIDGleisAbschnitt value) {
        this.idGleisAbschnitt = value;
    }

    /**
     * Ruft den Wert der idzldlpFstr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZLDLPFstr }
     *     
     */
    public TCIDZLDLPFstr getIDZLDLPFstr() {
        return idzldlpFstr;
    }

    /**
     * Legt den Wert der idzldlpFstr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZLDLPFstr }
     *     
     */
    public void setIDZLDLPFstr(TCIDZLDLPFstr value) {
        this.idzldlpFstr = value;
    }

}
