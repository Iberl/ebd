//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zuglenkung._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDZLFstr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Zuordnung von ZL-DLP-Abschnitten zur ZL-Fahrstra�e. DB-Regelwerk TM 2011-024 I.NVT 3 
 * 
 * <p>Java-Klasse f�r CZL_DLP_Fstr complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZL_DLP_Fstr">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_ZL_Fstr" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZL_Fstr"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZL_DLP_Fstr", propOrder = {
    "idzlFstr"
})
public class CZLDLPFstr
    extends CBasisObjekt
{

    @XmlElement(name = "ID_ZL_Fstr", required = true)
    protected TCIDZLFstr idzlFstr;

    /**
     * Ruft den Wert der idzlFstr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZLFstr }
     *     
     */
    public TCIDZLFstr getIDZLFstr() {
        return idzlFstr;
    }

    /**
     * Legt den Wert der idzlFstr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZLFstr }
     *     
     */
    public void setIDZLFstr(TCIDZLFstr value) {
        this.idzlFstr = value;
    }

}
