//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * Description of a physical interface with definition of the information to be exchanged in which direction.
 * 
 * <p>Java-Klasse für Interface complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Interface">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="command" type="{https://www.railml.org/schemas/3.1}InputOutput" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="message" type="{https://www.railml.org/schemas/3.1}InputOutput" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="initStatus" type="{https://www.railml.org/schemas/3.1}InitStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="invalidTolerationTime" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="switchoverTolerationTime" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Interface", propOrder = {
    "command",
    "message",
    "initStatus"
})
public class Interface
    extends EntityIL
{

    protected List<InputOutput> command;
    protected List<InputOutput> message;
    protected InitStatus initStatus;
    @XmlAttribute(name = "invalidTolerationTime")
    protected Duration invalidTolerationTime;
    @XmlAttribute(name = "switchoverTolerationTime")
    protected Duration switchoverTolerationTime;

    /**
     * Gets the value of the command property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the command property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommand().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputOutput }
     * 
     * 
     */
    public List<InputOutput> getCommand() {
        if (command == null) {
            command = new ArrayList<InputOutput>();
        }
        return this.command;
    }

    /**
     * Gets the value of the message property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the message property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputOutput }
     * 
     * 
     */
    public List<InputOutput> getMessage() {
        if (message == null) {
            message = new ArrayList<InputOutput>();
        }
        return this.message;
    }

    /**
     * Ruft den Wert der initStatus-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link InitStatus }
     *     
     */
    public InitStatus getInitStatus() {
        return initStatus;
    }

    /**
     * Legt den Wert der initStatus-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link InitStatus }
     *     
     */
    public void setInitStatus(InitStatus value) {
        this.initStatus = value;
    }

    /**
     * Ruft den Wert der invalidTolerationTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getInvalidTolerationTime() {
        return invalidTolerationTime;
    }

    /**
     * Legt den Wert der invalidTolerationTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setInvalidTolerationTime(Duration value) {
        this.invalidTolerationTime = value;
    }

    /**
     * Ruft den Wert der switchoverTolerationTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getSwitchoverTolerationTime() {
        return switchoverTolerationTime;
    }

    /**
     * Legt den Wert der switchoverTolerationTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setSwitchoverTolerationTime(Duration value) {
        this.switchoverTolerationTime = value;
    }

}
