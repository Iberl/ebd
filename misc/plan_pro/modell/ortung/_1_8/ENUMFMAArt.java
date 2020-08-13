//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.ortung._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMFMA_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMFMA_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NF_Gleisstromkreis"/>
 *     &lt;enumeration value="TF_Gleisstromkreis"/>
 *     &lt;enumeration value="FTGS"/>
 *     &lt;enumeration value="Achszaehlanlage"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMFMA_Art")
@XmlEnum
public enum ENUMFMAArt {

    @XmlEnumValue("NF_Gleisstromkreis")
    NF_GLEISSTROMKREIS("NF_Gleisstromkreis"),
    @XmlEnumValue("TF_Gleisstromkreis")
    TF_GLEISSTROMKREIS("TF_Gleisstromkreis"),
    FTGS("FTGS"),
    @XmlEnumValue("Achszaehlanlage")
    ACHSZAEHLANLAGE("Achszaehlanlage");
    private final String value;

    ENUMFMAArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMFMAArt fromValue(String v) {
        for (ENUMFMAArt c: ENUMFMAArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
