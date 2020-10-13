//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für tOpOperationalType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tOpOperationalType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="depot"/>
 *     &lt;enumeration value="block"/>
 *     &lt;enumeration value="siding"/>
 *     &lt;enumeration value="borderPoint"/>
 *     &lt;enumeration value="crossover"/>
 *     &lt;enumeration value="junction"/>
 *     &lt;enumeration value="station"/>
 *     &lt;enumeration value="stoppingPoint"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tOpOperationalType")
@XmlEnum
public enum TOpOperationalType {


    /**
     * an operational point where railway vehicles can start and end
     * 
     */
    @XmlEnumValue("depot")
    DEPOT("depot"),

    /**
     * on operational point where the spacing of trains is monitored; can be a block signal (mainly unstaffed and automated) or a block post (mainly staffed)
     * 
     */
    @XmlEnumValue("block")
    BLOCK("block"),

    /**
     * an operational point to collect and deliver of cargo wagons to build trains, but not for train operation
     * 
     */
    @XmlEnumValue("siding")
    SIDING("siding"),

    /**
     * operational point is a border point (e.g. at national border)
     * 
     */
    @XmlEnumValue("borderPoint")
    BORDER_POINT("borderPoint"),

    /**
     * a connection between two tracks of a double-track line
     * 
     */
    @XmlEnumValue("crossover")
    CROSSOVER("crossover"),

    /**
     * joining/splitting of two lines
     * 
     */
    @XmlEnumValue("junction")
    JUNCTION("junction"),

    /**
     * a usual station for beginning, ending, overtaking of trains with passing tracks, etc.
     * 
     */
    @XmlEnumValue("station")
    STATION("station"),

    /**
     * an operational point without signals, switches, additional tracks where trains start, stop or end e. g. for passenger exchange
     * 
     */
    @XmlEnumValue("stoppingPoint")
    STOPPING_POINT("stoppingPoint");
    private final String value;

    TOpOperationalType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TOpOperationalType fromValue(String v) {
        for (TOpOperationalType c: TOpOperationalType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
