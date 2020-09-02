//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bedienung._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDBedienZentrale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Bedienung von mehreren ESTW-Zentraleinheiten. Das Objekt Bedien_Bezirk erm�glicht den Anschluss mehrerer ESTW-Zentraleinheiten an einen Bedien_Bezirk z. B. in einer Bedien_Zentrale. F�r einen Bedien_Bezirk gibt es zwei Modellierungen / Auspr�gungen. 1.) Reell in einer Bedien_Zentrale, Regio-BZ oder sonstigem Technikstandort errichteter Bedien_Bezirk mit angeschalteten ESTW_Zentraleinheiten (mindestens einer) ==\u0026gt; zentraler Bedien_Bezirk 2.) Geplante, auf die Streckeninfrastruktur bezogene, logische Zusammenfassung von betrieblich und geographisch zusammenh�ngenden Strecken. ==\u0026gt; virtueller Bedien_Bezirk Beispiele: Siehe auch Anlage Media:Bedien Bezirk Typ.pdf 1.) Zentraler Bedien_Bezirk Das Konzept der zentralen Betriebsf�hrung sieht vor, die Bedienung hochwertiger Strecken von ESTW, durch Bedien_Zentralen (Betriebszentralen) zu b�ndeln. Besonderheit dabei ist, dass in den Bedien_Zentralen selbst keine ESTW_Zentraleinheiten aus Verf�gbarkeitsgr�nden aufgebaut werden d�rfen. Das hei�t, in den Betriebszentralen sind keine ESTW_Zentraleinheiten sondern nur Bedien_Pl�tze und Bedien_Bezirke errichtet. Diese Bedien_Bezirke, die die Bedienung hochwertiger Strecken b�ndeln, sind �zentrale Bedien_Bezirke�. Die Einschr�nkung, ESTW_Zentraleinheiten nicht im selben Geb�ude wie ESTW_Bedien_Bezirke aufzubauen, gilt nicht f�r eine Regio-BZ oder sonstige Technikstandorte. Auch im Regionalnetz werden ESTW_Zentraleinheiten errichtet. Bisher sind diese �rtlich besetzt. Unter anderem ist geplant bzw. in Realisierung, die Geb�ude in denen bereits eine Regio-ESTW_Zentraleinheit errichtet ist, eine weitere Regio-ESTW_Zentraleinheit einzubauen. Um auch hier Redundanzen und Synergien nutzen zu k�nnen, ist geplant auch hier einen Bedien_Bezirk �ber die ESTW_Zentraleinheiten zu installieren. Der entscheidende Unterschied zur Bedienzentrale ist hier, dass Bedien_Bezirk und ESTW_Zentraleinheit in einem Geb�ude untergebracht sind. Da Strecken sowohl das Regionalnetz und das Fern- und Ballungsnetz durchlaufen k�nnen, m�ssen die Kennzahlenplanungen ebenfalls Netzart�bergreifend sein. Siehe auch Attribut �Kennzahl�. 2.) Virtueller Bedienbezirk Als Zweites ist die Option des virtuellen Bedien_Bezirks zu modellieren. Da ein Bedien_Bezirk ja nicht von Heute auf Morgen in ESTW-Technik da steht, m�ssen �bergangsregelungen geschaffen werden. Auch wenn Stellwerke in einem Bedien_Bezirk (noch) nicht in ESTW-Technik realisiert sind oder die Zuordnung zum Regionalnetz oder Fern- und Ballungsnetz noch offen ist gilt: Die Stw sind einem Bedien_Bezirk zuzuordnen um jegliche sp�tere Realisierungsform zu erm�glichen und so auch die Kennzahlenvergabe sicher zu gestalten. Siehe auch Attribut �Kennzahl�. Am Beispiel der Bedien_Bezirke 08 und 11 in der BZ Hannover sieht man, dass auch Stellwerke, die (noch) nicht an einen Bedien_Bezirk angebunden sind, eine Zuordnung erfahren m�ssen. Alle Stellwerke (HORX, HK, Sarstedt und Barnten) liegen in einem betrieblich zusammenh�ngenden Bezirk. N�mlich auf den Nord-S�d Strecken von Hannover Richtung G�ttingen. Die Stellwerke HK, Sarstedt und Barnten sogar auf derselben Strecke 1732. Aktuell sind die Stellwerke Sarstedt und Barnten noch nicht an einen Bedien_Bezirk angebunden. In den Planungen und betrieblichen Vorgaben des Regionalbereichs aber f�r eine Zuordnung zum Bedien_Bezirk 11 vorgesehen. Daher muss schon jetzt der Bedienbezirk den Stw zugeordnet werden k�nnen, auch wenn sie ggf. trotz ESTW-Aufbau, �rtlich besetzt werden. Durch die Darstellung in dem Verweis �zentral� oder �virtuell� l�sst sich die aktuelle und geplante Anbindung darstellen. Im Verst�ndnis der Betriebszentralen entspricht das Objekt Bedien_Bezirk dem Steuerbezirk. Das Objekt kann im LST-Datenmodell jedoch auch als virtueller Bedien_Bezirk vorkommen. Jeder ESTW-Zentraleinheit wird auch ein Bedien_Bezirk zugeordnet. In der Regel der, der in der Kennzahlenplanung vorgesehen ist. Also auch dann, wenn physisch kein Bedienbezirk (Steuerbezirk) oder eine vergleichbare Einheit vorhanden ist (z. B. Regionale Bedienzentrale mit nur einer ESTW-Zentraleinheit), aber bestimmte Eigenschaften mehrerer gemeinsam gesteuerter ESTW-Zentraleinheiten �bergreifend geplant werden m�ssen (z.B. Richtungssinn und Kennzahlen). Gem�� Richtlinie 819.0603 m�ssen Kennzahlen und Betriebsstellenbezeichner im Steuerbezirk und an seinen Grenzen eindeutig (einmalig) sein. Diese Regel kann nicht �ber das Modell abgebildet werden, sondern muss in der Plausibilit�ts- und Zul�ssigkeitspr�fung (PlaZ) abgefangen werden. Die Vorgabe f�r den Richtungssinn bezieht sich immer auf einen kompletten Steuerbezirk. Sie ist jedoch als Eigenschaft der Bedienoberfl�che modelliert. Gegebenenfalls m�ssen hier Zul�ssigkeitspr�fungen ablaufen. Im Bedienbezirk werden au�erdem die Angaben f�r die Datenkommunikation mit den zugeordneten ESTW-Zentraleinheiten geplant. Die Werte A, B und C werden nach Ril 819.0705A01 von der DB Netz festgelegt. Der Ansprechpartner findet sich in der Ril. Alle weiteren Werte lassen sich anhand dieser Unterlage bestimmen. Siehe Anlage Media:ipadr namensv ib1.pdf DB-Regelwerk 819.0603 819.0705A01 
 * 
 * <p>Java-Klasse f�r CBedien_Bezirk complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Bezirk">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bedien_Bezirk_Adressformel" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Bezirk_Adressformel"/>
 *         &lt;element name="Bedien_Bezirk_Allg" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Bezirk_Allg"/>
 *         &lt;element name="Bedien_Bezirk_Anhaenge" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Bezirk_Anhaenge"/>
 *         &lt;element name="ID_Bedien_Zentrale" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Bedien_Zentrale"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Bezirk", propOrder = {
    "bedienBezirkAdressformel",
    "bedienBezirkAllg",
    "bedienBezirkAnhaenge",
    "idBedienZentrale"
})
public class CBedienBezirk
    extends CBasisObjekt
{

    @XmlElement(name = "Bedien_Bezirk_Adressformel", required = true)
    protected CBedienBezirkAdressformel bedienBezirkAdressformel;
    @XmlElement(name = "Bedien_Bezirk_Allg", required = true)
    protected CBedienBezirkAllg bedienBezirkAllg;
    @XmlElement(name = "Bedien_Bezirk_Anhaenge", required = true)
    protected CBedienBezirkAnhaenge bedienBezirkAnhaenge;
    @XmlElement(name = "ID_Bedien_Zentrale", required = true)
    protected TCIDBedienZentrale idBedienZentrale;

    /**
     * Ruft den Wert der bedienBezirkAdressformel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedienBezirkAdressformel }
     *     
     */
    public CBedienBezirkAdressformel getBedienBezirkAdressformel() {
        return bedienBezirkAdressformel;
    }

    /**
     * Legt den Wert der bedienBezirkAdressformel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedienBezirkAdressformel }
     *     
     */
    public void setBedienBezirkAdressformel(CBedienBezirkAdressformel value) {
        this.bedienBezirkAdressformel = value;
    }

    /**
     * Ruft den Wert der bedienBezirkAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedienBezirkAllg }
     *     
     */
    public CBedienBezirkAllg getBedienBezirkAllg() {
        return bedienBezirkAllg;
    }

    /**
     * Legt den Wert der bedienBezirkAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedienBezirkAllg }
     *     
     */
    public void setBedienBezirkAllg(CBedienBezirkAllg value) {
        this.bedienBezirkAllg = value;
    }

    /**
     * Ruft den Wert der bedienBezirkAnhaenge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedienBezirkAnhaenge }
     *     
     */
    public CBedienBezirkAnhaenge getBedienBezirkAnhaenge() {
        return bedienBezirkAnhaenge;
    }

    /**
     * Legt den Wert der bedienBezirkAnhaenge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedienBezirkAnhaenge }
     *     
     */
    public void setBedienBezirkAnhaenge(CBedienBezirkAnhaenge value) {
        this.bedienBezirkAnhaenge = value;
    }

    /**
     * Ruft den Wert der idBedienZentrale-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBedienZentrale }
     *     
     */
    public TCIDBedienZentrale getIDBedienZentrale() {
        return idBedienZentrale;
    }

    /**
     * Legt den Wert der idBedienZentrale-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBedienZentrale }
     *     
     */
    public void setIDBedienZentrale(TCIDBedienZentrale value) {
        this.idBedienZentrale = value;
    }

}
