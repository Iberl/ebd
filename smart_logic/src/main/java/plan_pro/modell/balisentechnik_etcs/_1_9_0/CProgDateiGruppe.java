//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDGeraetProgrammiert;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Gruppe von Dateien, die zum Programmieren der Balise oder LEU ben�tigt werden.
 * 
 * <p>Java-Klasse f�r CProg_Datei_Gruppe complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CProg_Datei_Gruppe">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Geraet_Programmiert" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Geraet_Programmiert" maxOccurs="unbounded"/>
 *         &lt;element name="Prog_Datei_Einzel" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CProg_Datei_Einzel" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CProg_Datei_Gruppe", propOrder = {
    "idGeraetProgrammiert",
    "progDateiEinzel"
})
public class CProgDateiGruppe
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Geraet_Programmiert", required = true)
    protected List<TCIDGeraetProgrammiert> idGeraetProgrammiert;
    @XmlElement(name = "Prog_Datei_Einzel", required = true)
    protected List<CProgDateiEinzel> progDateiEinzel;

    /**
     * Gets the value of the idGeraetProgrammiert property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idGeraetProgrammiert property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDGeraetProgrammiert().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDGeraetProgrammiert }
     * 
     * 
     */
    public List<TCIDGeraetProgrammiert> getIDGeraetProgrammiert() {
        if (idGeraetProgrammiert == null) {
            idGeraetProgrammiert = new ArrayList<TCIDGeraetProgrammiert>();
        }
        return this.idGeraetProgrammiert;
    }

    /**
     * Gets the value of the progDateiEinzel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the progDateiEinzel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProgDateiEinzel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CProgDateiEinzel }
     * 
     * 
     */
    public List<CProgDateiEinzel> getProgDateiEinzel() {
        if (progDateiEinzel == null) {
            progDateiEinzel = new ArrayList<CProgDateiEinzel>();
        }
        return this.progDateiEinzel;
    }

}
