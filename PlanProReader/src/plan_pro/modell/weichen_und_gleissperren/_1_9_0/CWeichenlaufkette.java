//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.weichen_und_gleissperren._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.basistypen._1_9_0.CBezeichnungElement;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Logisches Objekt von mehreren durch Antriebe stellbaren Fahrwegelementen (Weichen, Gleissperren, sonstigen stellbaren Elementen), deren Umlauf automatisch bei einer entsprechenden Anforderung (z.B. Fahrstra�e) erfolgt. Diese stellbaren Elemente k�nnen nur dann automatisch gestellt werden, wenn sie auch einer Weichenlaufkette (WLK) zugeordnet sind. Jedes stellbare Element wird genau einer WLK zugeordnet. Durch Sperren der WLK kann dieser automatische Umlauf verhindert werden. Innerhalb von Weichenlaufketten sind dabei folgende Elemente zul�ssig: Weichen, Gleissperren und Sonderelemente, die automatisch umlaufen sollen. F�r die Bedienung von Ersatzauftr�gen des Typs 2 (EE2, VE2, LE2) an Hauptsignalen m�ssen eine oder mehrere Weichenlaufketten gesperrt werden. Zur Reduzierung betrieblicher Behinderungen werden oftmals mehrere Weichenlaufketten in einer Betriebsstelle eingerichtet. DB-Regelwerk Die Bezeichnung der Weichenlaufkette wird gem�� Ril 819.0603 in der Form LKn (n = laufende Nummer) gebildet und in der Attributgruppe Bezeichnung abgebildet.
 * 
 * <p>Java-Klasse f�r CWeichenlaufkette complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CWeichenlaufkette">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}CBezeichnung_Element"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CWeichenlaufkette", propOrder = {
    "bezeichnung"
})
public class CWeichenlaufkette
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CBezeichnungElement bezeichnung;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBezeichnungElement }
     *     
     */
    public CBezeichnungElement getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBezeichnungElement }
     *     
     */
    public void setBezeichnung(CBezeichnungElement value) {
        this.bezeichnung = value;
    }

}
