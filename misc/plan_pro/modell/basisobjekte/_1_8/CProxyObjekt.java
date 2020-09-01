//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.basisobjekte._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Hilfsobjekt zur S�ttigung von Verweisen an der �u�eren Grenze des Betrachtungsbereichs einer Einzelplanung. Die Validierung einer XML-Datei ist nur gesamthaft m�glich. Somit m�ssen Planungs- und Betrachtungsbereich gleicherma�en valide sein. An der �u�eren Grenze des Betrachtungsbereichs sind jedoch u. U. nicht mehr alle Zielobjekte von Verweisen vorhanden, da der Betrachtungsbereich nicht beliebig ausgeweitet werden kann und soll. Unter der Ma�gabe einer validen XML besteht jedoch ein Zwang zur S�ttigung von Verweisen. Das Proxy_Objekt schafft diesbez�glich eine L�sung f�r alle Objekte des LST-Datenmodells. In den Bestandsdaten der LST-Datenbank d�rfen keine Proxyobjekte vorhanden sein. 
 * 
 * <p>Java-Klasse f�r CProxy_Objekt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CProxy_Objekt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Name_LST_Objekt" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}TCName_LST_Objekt"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CProxy_Objekt", propOrder = {
    "nameLSTObjekt"
})
public class CProxyObjekt
    extends CUrObjekt
{

    @XmlElement(name = "Name_LST_Objekt", required = true)
    protected TCNameLSTObjekt nameLSTObjekt;

    /**
     * Ruft den Wert der nameLSTObjekt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNameLSTObjekt }
     *     
     */
    public TCNameLSTObjekt getNameLSTObjekt() {
        return nameLSTObjekt;
    }

    /**
     * Legt den Wert der nameLSTObjekt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNameLSTObjekt }
     *     
     */
    public void setNameLSTObjekt(TCNameLSTObjekt value) {
        this.nameLSTObjekt = value;
    }

}
