//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.signale._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDSignalGleisbezechnung;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CSignal_Fstr_Aus_Inselgleis complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_Fstr_Aus_Inselgleis">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_RaFahrt_Gleichzeitig_Verbot" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal_Gleisbezechnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_ZgFahrt_Gleichzeitig_Verbot" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal_Gleisbezechnung" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_Fstr_Aus_Inselgleis", propOrder = {
    "idRaFahrtGleichzeitigVerbot",
    "idZgFahrtGleichzeitigVerbot"
})
public class CSignalFstrAusInselgleis {

    @XmlElement(name = "ID_RaFahrt_Gleichzeitig_Verbot")
    protected List<TCIDSignalGleisbezechnung> idRaFahrtGleichzeitigVerbot;
    @XmlElement(name = "ID_ZgFahrt_Gleichzeitig_Verbot")
    protected List<TCIDSignalGleisbezechnung> idZgFahrtGleichzeitigVerbot;

    /**
     * Gets the value of the idRaFahrtGleichzeitigVerbot property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idRaFahrtGleichzeitigVerbot property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDRaFahrtGleichzeitigVerbot().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDSignalGleisbezechnung }
     * 
     * 
     */
    public List<TCIDSignalGleisbezechnung> getIDRaFahrtGleichzeitigVerbot() {
        if (idRaFahrtGleichzeitigVerbot == null) {
            idRaFahrtGleichzeitigVerbot = new ArrayList<TCIDSignalGleisbezechnung>();
        }
        return this.idRaFahrtGleichzeitigVerbot;
    }

    /**
     * Gets the value of the idZgFahrtGleichzeitigVerbot property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idZgFahrtGleichzeitigVerbot property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDZgFahrtGleichzeitigVerbot().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDSignalGleisbezechnung }
     * 
     * 
     */
    public List<TCIDSignalGleisbezechnung> getIDZgFahrtGleichzeitigVerbot() {
        if (idZgFahrtGleichzeitigVerbot == null) {
            idZgFahrtGleichzeitigVerbot = new ArrayList<TCIDSignalGleisbezechnung>();
        }
        return this.idZgFahrtGleichzeitigVerbot;
    }

}
