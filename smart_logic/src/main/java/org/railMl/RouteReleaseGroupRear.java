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
 * Ordered set of TVD sections in rear of the train.
 * Partial route, i.e. a set of TVD sections in rear of the train that is released as a group if given safety conditions are fulfilled. Partial route release can be delayed to improve safety. Route release groups can be associated with several routes.
 * Release can be retarded by a given delay.
 * If a route that has one single route release group then the route is released as a whole. In this case, there is no need to explicitly define the TVD sections that are part of this release group.
 * 
 * <p>Java-Klasse für RouteReleaseGroupRear complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RouteReleaseGroupRear">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}PartialRoute">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RouteReleaseGroupRear")
public class RouteReleaseGroupRear
    extends PartialRoute
{


}
