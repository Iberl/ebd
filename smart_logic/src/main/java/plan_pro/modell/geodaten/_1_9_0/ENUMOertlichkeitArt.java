//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMOertlichkeit_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMOertlichkeit_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Abzw"/>
 *     &lt;enumeration value="Abzw Anst"/>
 *     &lt;enumeration value="Abzw Awanst"/>
 *     &lt;enumeration value="Anst Bk"/>
 *     &lt;enumeration value="Awanst Bk"/>
 *     &lt;enumeration value="Bf Abzw"/>
 *     &lt;enumeration value="Bft Abzw"/>
 *     &lt;enumeration value="BSO"/>
 *     &lt;enumeration value="Gp"/>
 *     &lt;enumeration value="Hp Abzw"/>
 *     &lt;enumeration value="Hp Abzw Anst"/>
 *     &lt;enumeration value="Hp Abzw Awanst"/>
 *     &lt;enumeration value="Hp Anst"/>
 *     &lt;enumeration value="Hp Anst Bk"/>
 *     &lt;enumeration value="Hp Awanst"/>
 *     &lt;enumeration value="Hp Awanst Bk"/>
 *     &lt;enumeration value="Hp Bft"/>
 *     &lt;enumeration value="Hp Bk"/>
 *     &lt;enumeration value="Hp Dkst"/>
 *     &lt;enumeration value="Hp �st"/>
 *     &lt;enumeration value="Hp �st Anst"/>
 *     &lt;enumeration value="Hp �st Awanst"/>
 *     &lt;enumeration value="LGr"/>
 *     &lt;enumeration value="NE-Abzw"/>
 *     &lt;enumeration value="NE-Anst"/>
 *     &lt;enumeration value="NE-Awanst"/>
 *     &lt;enumeration value="NE-Bf"/>
 *     &lt;enumeration value="NE-Bft"/>
 *     &lt;enumeration value="NE-Bft Abzw"/>
 *     &lt;enumeration value="NE-Bk"/>
 *     &lt;enumeration value="NE-Gp"/>
 *     &lt;enumeration value="NE-Hp"/>
 *     &lt;enumeration value="NE-Hp Abzw"/>
 *     &lt;enumeration value="NE-Hp Anst"/>
 *     &lt;enumeration value="NE-Hp Awanst"/>
 *     &lt;enumeration value="NE-Hp Bk"/>
 *     &lt;enumeration value="NE-LGr"/>
 *     &lt;enumeration value="NE-RBGr"/>
 *     &lt;enumeration value="NE-�st"/>
 *     &lt;enumeration value="PDGr"/>
 *     &lt;enumeration value="RBGr"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="�st"/>
 *     &lt;enumeration value="�st Anst"/>
 *     &lt;enumeration value="�st Awanst"/>
 *     &lt;enumeration value="vp-Abzw"/>
 *     &lt;enumeration value="vp-Anst"/>
 *     &lt;enumeration value="vp-Awanst"/>
 *     &lt;enumeration value="vp-Bf"/>
 *     &lt;enumeration value="vp-Bft"/>
 *     &lt;enumeration value="vp-Bk"/>
 *     &lt;enumeration value="vp-Hp"/>
 *     &lt;enumeration value="vp-Hp Abzw"/>
 *     &lt;enumeration value="vp-Hp Anst"/>
 *     &lt;enumeration value="vp-Hp Anst Bk"/>
 *     &lt;enumeration value="vp-Hp Awanst"/>
 *     &lt;enumeration value="vp-LGr"/>
 *     &lt;enumeration value="vp-RBGr"/>
 *     &lt;enumeration value="Anst"/>
 *     &lt;enumeration value="Awanst"/>
 *     &lt;enumeration value="Bf"/>
 *     &lt;enumeration value="Bft"/>
 *     &lt;enumeration value="Bk"/>
 *     &lt;enumeration value="BZ"/>
 *     &lt;enumeration value="Dkst"/>
 *     &lt;enumeration value="Hp"/>
 *     &lt;enumeration value="Sbk"/>
 *     &lt;enumeration value="Strw"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMOertlichkeit_Art")
@XmlEnum
public enum ENUMOertlichkeitArt {

    @XmlEnumValue("Abzw")
    ABZW("Abzw"),
    @XmlEnumValue("Abzw Anst")
    ABZW_ANST("Abzw Anst"),
    @XmlEnumValue("Abzw Awanst")
    ABZW_AWANST("Abzw Awanst"),
    @XmlEnumValue("Anst Bk")
    ANST_BK("Anst Bk"),
    @XmlEnumValue("Awanst Bk")
    AWANST_BK("Awanst Bk"),
    @XmlEnumValue("Bf Abzw")
    BF_ABZW("Bf Abzw"),
    @XmlEnumValue("Bft Abzw")
    BFT_ABZW("Bft Abzw"),
    BSO("BSO"),
    @XmlEnumValue("Gp")
    GP("Gp"),
    @XmlEnumValue("Hp Abzw")
    HP_ABZW("Hp Abzw"),
    @XmlEnumValue("Hp Abzw Anst")
    HP_ABZW_ANST("Hp Abzw Anst"),
    @XmlEnumValue("Hp Abzw Awanst")
    HP_ABZW_AWANST("Hp Abzw Awanst"),
    @XmlEnumValue("Hp Anst")
    HP_ANST("Hp Anst"),
    @XmlEnumValue("Hp Anst Bk")
    HP_ANST_BK("Hp Anst Bk"),
    @XmlEnumValue("Hp Awanst")
    HP_AWANST("Hp Awanst"),
    @XmlEnumValue("Hp Awanst Bk")
    HP_AWANST_BK("Hp Awanst Bk"),
    @XmlEnumValue("Hp Bft")
    HP_BFT("Hp Bft"),
    @XmlEnumValue("Hp Bk")
    HP_BK("Hp Bk"),
    @XmlEnumValue("Hp Dkst")
    HP_DKST("Hp Dkst"),
    @XmlEnumValue("Hp Uest")
    HP_UEST("Hp Uest"),
    @XmlEnumValue("Hp Uest Anst")
    HP_UEST_ANST("Hp Uest Anst"),
    @XmlEnumValue("Hp Uest Awanst")
    HP_UEST_AWANST("Hp Uest Awanst"),
    @XmlEnumValue("LGr")
    L_GR("LGr"),
    @XmlEnumValue("NE-Abzw")
    NE_ABZW("NE-Abzw"),
    @XmlEnumValue("NE-Anst")
    NE_ANST("NE-Anst"),
    @XmlEnumValue("NE-Awanst")
    NE_AWANST("NE-Awanst"),
    @XmlEnumValue("NE-Bf")
    NE_BF("NE-Bf"),
    @XmlEnumValue("NE-Bft")
    NE_BFT("NE-Bft"),
    @XmlEnumValue("NE-Bft Abzw")
    NE_BFT_ABZW("NE-Bft Abzw"),
    @XmlEnumValue("NE-Bk")
    NE_BK("NE-Bk"),
    @XmlEnumValue("NE-Gp")
    NE_GP("NE-Gp"),
    @XmlEnumValue("NE-Hp")
    NE_HP("NE-Hp"),
    @XmlEnumValue("NE-Hp Abzw")
    NE_HP_ABZW("NE-Hp Abzw"),
    @XmlEnumValue("NE-Hp Anst")
    NE_HP_ANST("NE-Hp Anst"),
    @XmlEnumValue("NE-Hp Awanst")
    NE_HP_AWANST("NE-Hp Awanst"),
    @XmlEnumValue("NE-Hp Bk")
    NE_HP_BK("NE-Hp Bk"),
    @XmlEnumValue("NE-LGr")
    NE_L_GR("NE-LGr"),
    @XmlEnumValue("NE-RBGr")
    NE_RB_GR("NE-RBGr"),
    @XmlEnumValue("NE-Uest")
    NE_UEST("NE-Uest"),
    @XmlEnumValue("PDGr")
    PD_GR("PDGr"),
    @XmlEnumValue("RBGr")
    RB_GR("RBGr"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Uest")
    UEST("Uest"),
    @XmlEnumValue("Uest Anst")
    UEST_ANST("Uest Anst"),
    @XmlEnumValue("Uest Awanst")
    UEST_AWANST("Uest Awanst"),
    @XmlEnumValue("vp-Abzw")
    VP_ABZW("vp-Abzw"),
    @XmlEnumValue("vp-Anst")
    VP_ANST("vp-Anst"),
    @XmlEnumValue("vp-Awanst")
    VP_AWANST("vp-Awanst"),
    @XmlEnumValue("vp-Bf")
    VP_BF("vp-Bf"),
    @XmlEnumValue("vp-Bft")
    VP_BFT("vp-Bft"),
    @XmlEnumValue("vp-Bk")
    VP_BK("vp-Bk"),
    @XmlEnumValue("vp-Hp")
    VP_HP("vp-Hp"),
    @XmlEnumValue("vp-Hp Abzw")
    VP_HP_ABZW("vp-Hp Abzw"),
    @XmlEnumValue("vp-Hp Anst")
    VP_HP_ANST("vp-Hp Anst"),
    @XmlEnumValue("vp-Hp Anst Bk")
    VP_HP_ANST_BK("vp-Hp Anst Bk"),
    @XmlEnumValue("vp-Hp Awanst")
    VP_HP_AWANST("vp-Hp Awanst"),
    @XmlEnumValue("vp-LGr")
    VP_L_GR("vp-LGr"),
    @XmlEnumValue("vp-RBGr")
    VP_RB_GR("vp-RBGr"),
    @XmlEnumValue("Anst")
    ANST("Anst"),
    @XmlEnumValue("Awanst")
    AWANST("Awanst"),
    @XmlEnumValue("Bf")
    BF("Bf"),
    @XmlEnumValue("Bft")
    BFT("Bft"),
    @XmlEnumValue("Bk")
    BK("Bk"),
    BZ("BZ"),
    @XmlEnumValue("Dkst")
    DKST("Dkst"),
    @XmlEnumValue("Hp")
    HP("Hp"),
    @XmlEnumValue("Sbk")
    SBK("Sbk"),
    @XmlEnumValue("Strw")
    STRW("Strw");
    private final String value;

    ENUMOertlichkeitArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMOertlichkeitArt fromValue(String v) {
        for (ENUMOertlichkeitArt c: ENUMOertlichkeitArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
