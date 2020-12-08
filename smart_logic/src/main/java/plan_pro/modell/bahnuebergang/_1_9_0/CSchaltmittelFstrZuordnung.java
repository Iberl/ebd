//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBUEWSFstrZuordnung;
import plan_pro.modell.verweise._1_9_0.TCIDSchaltmittelZuordnung;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Verkn�pft bei einem Bahn�bergang mit der Funktions�berwachung F� die m�glichen Fahrstra�en mit den Elementen f�r die Wirksamschaltung.
 * 
 * <p>Java-Klasse f�r CSchaltmittel_Fstr_Zuordnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchaltmittel_Fstr_Zuordnung">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_BUE_WS_Fstr_Zuordnung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_BUE_WS_Fstr_Zuordnung"/>
 *         &lt;element name="ID_Schaltmittel_Zuordnung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Schaltmittel_Zuordnung"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSchaltmittel_Fstr_Zuordnung", propOrder = {
    "idbuewsFstrZuordnung",
    "idSchaltmittelZuordnung"
})
public class CSchaltmittelFstrZuordnung
    extends CBasisObjekt
{

    @XmlElement(name = "ID_BUE_WS_Fstr_Zuordnung", required = true)
    protected TCIDBUEWSFstrZuordnung idbuewsFstrZuordnung;
    @XmlElement(name = "ID_Schaltmittel_Zuordnung", required = true)
    protected TCIDSchaltmittelZuordnung idSchaltmittelZuordnung;

    /**
     * Ruft den Wert der idbuewsFstrZuordnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBUEWSFstrZuordnung }
     *     
     */
    public TCIDBUEWSFstrZuordnung getIDBUEWSFstrZuordnung() {
        return idbuewsFstrZuordnung;
    }

    /**
     * Legt den Wert der idbuewsFstrZuordnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBUEWSFstrZuordnung }
     *     
     */
    public void setIDBUEWSFstrZuordnung(TCIDBUEWSFstrZuordnung value) {
        this.idbuewsFstrZuordnung = value;
    }

    /**
     * Ruft den Wert der idSchaltmittelZuordnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSchaltmittelZuordnung }
     *     
     */
    public TCIDSchaltmittelZuordnung getIDSchaltmittelZuordnung() {
        return idSchaltmittelZuordnung;
    }

    /**
     * Legt den Wert der idSchaltmittelZuordnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSchaltmittelZuordnung }
     *     
     */
    public void setIDSchaltmittelZuordnung(TCIDSchaltmittelZuordnung value) {
        this.idSchaltmittelZuordnung = value;
    }

}
