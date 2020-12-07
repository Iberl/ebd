//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.block._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMBlock_Bauform.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBlock_Bauform">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AB64"/>
 *     &lt;enumeration value="AB70"/>
 *     &lt;enumeration value="elektronischer_Block_EBL2000"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="ESTW_Zentralblock"/>
 *     &lt;enumeration value="ESTW_Zentralblock_mit_Sb_Abschluss_MCL84"/>
 *     &lt;enumeration value="ESTW_Zentralblock_mit_Sb_Abschluss_SBL60"/>
 *     &lt;enumeration value="ESTW_Zentralblock_mit_Sb_Abschluss_SBS59"/>
 *     &lt;enumeration value="Zentralblock_ZSB2000"/>
 *     &lt;enumeration value="ESTW_Zentralblock_mit_Sb_Abschluss_SBS60"/>
 *     &lt;enumeration value="Felderblock"/>
 *     &lt;enumeration value="firmenneutrale_Blockschnittstelle"/>
 *     &lt;enumeration value="DB_Block"/>
 *     &lt;enumeration value="Zentralblock_ZBS65"/>
 *     &lt;enumeration value="Zentralblock_ZBS600"/>
 *     &lt;enumeration value="Selbstblock_SBL60"/>
 *     &lt;enumeration value="Selbstblock_SBS59"/>
 *     &lt;enumeration value="Selbstblock_SBS60"/>
 *     &lt;enumeration value="Relaisblock_RBII60"/>
 *     &lt;enumeration value="Relaisblock_RBIISp64b"/>
 *     &lt;enumeration value="Relaisblock_RBIIISp68"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBlock_Bauform")
@XmlEnum
public enum ENUMBlockBauform {

    @XmlEnumValue("AB64")
    AB_64("AB64"),
    @XmlEnumValue("AB70")
    AB_70("AB70"),
    @XmlEnumValue("elektronischer_Block_EBL2000")
    ELEKTRONISCHER_BLOCK_EBL_2000("elektronischer_Block_EBL2000"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("ESTW_Zentralblock")
    ESTW_ZENTRALBLOCK("ESTW_Zentralblock"),
    @XmlEnumValue("ESTW_Zentralblock_mit_Sb_Abschluss_MCL84")
    ESTW_ZENTRALBLOCK_MIT_SB_ABSCHLUSS_MCL_84("ESTW_Zentralblock_mit_Sb_Abschluss_MCL84"),
    @XmlEnumValue("ESTW_Zentralblock_mit_Sb_Abschluss_SBL60")
    ESTW_ZENTRALBLOCK_MIT_SB_ABSCHLUSS_SBL_60("ESTW_Zentralblock_mit_Sb_Abschluss_SBL60"),
    @XmlEnumValue("ESTW_Zentralblock_mit_Sb_Abschluss_SBS59")
    ESTW_ZENTRALBLOCK_MIT_SB_ABSCHLUSS_SBS_59("ESTW_Zentralblock_mit_Sb_Abschluss_SBS59"),
    @XmlEnumValue("Zentralblock_ZSB2000")
    ZENTRALBLOCK_ZSB_2000("Zentralblock_ZSB2000"),
    @XmlEnumValue("ESTW_Zentralblock_mit_Sb_Abschluss_SBS60")
    ESTW_ZENTRALBLOCK_MIT_SB_ABSCHLUSS_SBS_60("ESTW_Zentralblock_mit_Sb_Abschluss_SBS60"),
    @XmlEnumValue("Felderblock")
    FELDERBLOCK("Felderblock"),
    @XmlEnumValue("firmenneutrale_Blockschnittstelle")
    FIRMENNEUTRALE_BLOCKSCHNITTSTELLE("firmenneutrale_Blockschnittstelle"),
    @XmlEnumValue("DB_Block")
    DB_BLOCK("DB_Block"),
    @XmlEnumValue("Zentralblock_ZBS65")
    ZENTRALBLOCK_ZBS_65("Zentralblock_ZBS65"),
    @XmlEnumValue("Zentralblock_ZBS600")
    ZENTRALBLOCK_ZBS_600("Zentralblock_ZBS600"),
    @XmlEnumValue("Selbstblock_SBL60")
    SELBSTBLOCK_SBL_60("Selbstblock_SBL60"),
    @XmlEnumValue("Selbstblock_SBS59")
    SELBSTBLOCK_SBS_59("Selbstblock_SBS59"),
    @XmlEnumValue("Selbstblock_SBS60")
    SELBSTBLOCK_SBS_60("Selbstblock_SBS60"),
    @XmlEnumValue("Relaisblock_RBII60")
    RELAISBLOCK_RBII_60("Relaisblock_RBII60"),
    @XmlEnumValue("Relaisblock_RBIISp64b")
    RELAISBLOCK_RBII_SP_64_B("Relaisblock_RBIISp64b"),
    @XmlEnumValue("Relaisblock_RBIIISp68")
    RELAISBLOCK_RBIII_SP_68("Relaisblock_RBIIISp68");
    private final String value;

    ENUMBlockBauform(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBlockBauform fromValue(String v) {
        for (ENUMBlockBauform c: ENUMBlockBauform.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
