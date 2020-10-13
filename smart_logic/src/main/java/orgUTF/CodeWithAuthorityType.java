//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * gml:CodeWithAuthorityType requires that the codeSpace attribute is provided in an instance.
 * 
 * <p>Java-Klasse für CodeWithAuthorityType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CodeWithAuthorityType">
 *   &lt;simpleContent>
 *     &lt;restriction base="&lt;https://www.railml.org/schemas/3.1/gml>CodeType">
 *       &lt;attribute name="codeSpace" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodeWithAuthorityType", namespace = "https://www.railml.org/schemas/3.1/gml")
public class CodeWithAuthorityType
    extends CodeType
{


}
