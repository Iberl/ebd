//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDGleisAbschnitt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Darstellung der Anr�ckmeldung Auf der Bedienoberfl�che wird bei in den Steuerbereich einfahrenden Z�gen die Zugnummer oder, wenn diese nicht vorhanden ist, der vom anr�ckenden Zug belegte Gleisabschnitt angezeigt. Die Anr�ckmeldung wird aus der ZL generiert. Es wird festgelegt, in der N�he welchen Gleisabschnittes auf der Bedienoberfl�che die Zugnummer bzw. der Gleisabschnitt angezeigt werden soll. Der Gleisabschnitt kann au�erhalb des Planungsbereiches liegen. Es muss nicht der direkte Nachbarabschnitt sein, denn z.B. bei Strecken mit hoher Geschwindigkeit wird als Anr�ckabschnitt auch ein weiter entfernter Gleisabschnitt des Nachbarstellwerks genommen. DB-Regelwerk 819.0603 A2, Tabelle 3, Seite 208 
 * 
 * <p>Java-Klasse f�r CBedien_Anrueckabschnitt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Anrueckabschnitt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Gleis_Abschnitt_Position" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Gleis_Abschnitt"/>
 *         &lt;choice>
 *           &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}CBedien_Anrueckabschnitt_Bezeichnung"/>
 *           &lt;element name="ID_Gleis_Abschnitt_Darstellen" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Gleis_Abschnitt"/>
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
@XmlType(name = "CBedien_Anrueckabschnitt", propOrder = {
    "idGleisAbschnittPosition",
    "bezeichnung",
    "idGleisAbschnittDarstellen"
})
public class CBedienAnrueckabschnitt
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Gleis_Abschnitt_Position", required = true)
    protected TCIDGleisAbschnitt idGleisAbschnittPosition;
    @XmlElement(name = "Bezeichnung")
    protected CBedienAnrueckabschnittBezeichnung bezeichnung;
    @XmlElement(name = "ID_Gleis_Abschnitt_Darstellen")
    protected TCIDGleisAbschnitt idGleisAbschnittDarstellen;

    /**
     * Ruft den Wert der idGleisAbschnittPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGleisAbschnitt }
     *     
     */
    public TCIDGleisAbschnitt getIDGleisAbschnittPosition() {
        return idGleisAbschnittPosition;
    }

    /**
     * Legt den Wert der idGleisAbschnittPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGleisAbschnitt }
     *     
     */
    public void setIDGleisAbschnittPosition(TCIDGleisAbschnitt value) {
        this.idGleisAbschnittPosition = value;
    }

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedienAnrueckabschnittBezeichnung }
     *     
     */
    public CBedienAnrueckabschnittBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedienAnrueckabschnittBezeichnung }
     *     
     */
    public void setBezeichnung(CBedienAnrueckabschnittBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idGleisAbschnittDarstellen-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGleisAbschnitt }
     *     
     */
    public TCIDGleisAbschnitt getIDGleisAbschnittDarstellen() {
        return idGleisAbschnittDarstellen;
    }

    /**
     * Legt den Wert der idGleisAbschnittDarstellen-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGleisAbschnitt }
     *     
     */
    public void setIDGleisAbschnittDarstellen(TCIDGleisAbschnitt value) {
        this.idGleisAbschnittDarstellen = value;
    }

}
