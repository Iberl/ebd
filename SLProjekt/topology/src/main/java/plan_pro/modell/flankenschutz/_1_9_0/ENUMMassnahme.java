//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.flankenschutz._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMMassnahme.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMMassnahme">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fernschutz"/>
 *     &lt;enumeration value="Verschluss"/>
 *     &lt;enumeration value="Verschluss_Fernschutz"/>
 *     &lt;enumeration value="Verzicht"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMMassnahme")
@XmlEnum
public enum ENUMMassnahme {

    @XmlEnumValue("Fernschutz")
    FERNSCHUTZ("Fernschutz"),
    @XmlEnumValue("Verschluss")
    VERSCHLUSS("Verschluss"),
    @XmlEnumValue("Verschluss_Fernschutz")
    VERSCHLUSS_FERNSCHUTZ("Verschluss_Fernschutz"),
    @XmlEnumValue("Verzicht")
    VERZICHT("Verzicht");
    private final String value;

    ENUMMassnahme(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMMassnahme fromValue(String v) {
        for (ENUMMassnahme c: ENUMMassnahme.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
