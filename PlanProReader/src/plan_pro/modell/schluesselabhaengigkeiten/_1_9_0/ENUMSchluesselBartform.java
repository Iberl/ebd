//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.schluesselabhaengigkeiten._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMSchluessel_Bartform.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMSchluessel_Bartform">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="a"/>
 *     &lt;enumeration value="b"/>
 *     &lt;enumeration value="c"/>
 *     &lt;enumeration value="d"/>
 *     &lt;enumeration value="e"/>
 *     &lt;enumeration value="f"/>
 *     &lt;enumeration value="g"/>
 *     &lt;enumeration value="h"/>
 *     &lt;enumeration value="i"/>
 *     &lt;enumeration value="k"/>
 *     &lt;enumeration value="l"/>
 *     &lt;enumeration value="m"/>
 *     &lt;enumeration value="n"/>
 *     &lt;enumeration value="o"/>
 *     &lt;enumeration value="p"/>
 *     &lt;enumeration value="q"/>
 *     &lt;enumeration value="r"/>
 *     &lt;enumeration value="s"/>
 *     &lt;enumeration value="t"/>
 *     &lt;enumeration value="u"/>
 *     &lt;enumeration value="v"/>
 *     &lt;enumeration value="w"/>
 *     &lt;enumeration value="x"/>
 *     &lt;enumeration value="z"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMSchluessel_Bartform")
@XmlEnum
public enum ENUMSchluesselBartform {

    @XmlEnumValue("a")
    A("a"),
    @XmlEnumValue("b")
    B("b"),
    @XmlEnumValue("c")
    C("c"),
    @XmlEnumValue("d")
    D("d"),
    @XmlEnumValue("e")
    E("e"),
    @XmlEnumValue("f")
    F("f"),
    @XmlEnumValue("g")
    G("g"),
    @XmlEnumValue("h")
    H("h"),
    @XmlEnumValue("i")
    I("i"),
    @XmlEnumValue("k")
    K("k"),
    @XmlEnumValue("l")
    L("l"),
    @XmlEnumValue("m")
    M("m"),
    @XmlEnumValue("n")
    N("n"),
    @XmlEnumValue("o")
    O("o"),
    @XmlEnumValue("p")
    P("p"),
    @XmlEnumValue("q")
    Q("q"),
    @XmlEnumValue("r")
    R("r"),
    @XmlEnumValue("s")
    S("s"),
    @XmlEnumValue("t")
    T("t"),
    @XmlEnumValue("u")
    U("u"),
    @XmlEnumValue("v")
    V("v"),
    @XmlEnumValue("w")
    W("w"),
    @XmlEnumValue("x")
    X("x"),
    @XmlEnumValue("z")
    Z("z");
    private final String value;

    ENUMSchluesselBartform(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMSchluesselBartform fromValue(String v) {
        for (ENUMSchluesselBartform c: ENUMSchluesselBartform.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
