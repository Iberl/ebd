//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnsteig._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBereichObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDBahnsteigKanteOhneProxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Bahnsteigkanten-bezogene Abbildung der Bahnsteig-�berdachung. Die Angabe ist im INA-Erhebungsbogen erforderlich.
 * 
 * <p>Java-Klasse f�r CBahnsteig_Dach complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBahnsteig_Dach">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Bahnsteig_Kante" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Bahnsteig_Kante_ohne_Proxy"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBahnsteig_Dach", propOrder = {
    "idBahnsteigKante"
})
public class CBahnsteigDach
    extends CBereichObjekt
{

    @XmlElement(name = "ID_Bahnsteig_Kante", required = true)
    protected TCIDBahnsteigKanteOhneProxy idBahnsteigKante;

    /**
     * Ruft den Wert der idBahnsteigKante-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBahnsteigKanteOhneProxy }
     *     
     */
    public TCIDBahnsteigKanteOhneProxy getIDBahnsteigKante() {
        return idBahnsteigKante;
    }

    /**
     * Legt den Wert der idBahnsteigKante-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBahnsteigKanteOhneProxy }
     *     
     */
    public void setIDBahnsteigKante(TCIDBahnsteigKanteOhneProxy value) {
        this.idBahnsteigKante = value;
    }

}
