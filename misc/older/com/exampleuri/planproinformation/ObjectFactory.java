//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package com.exampleuri.planproinformation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.exampleuri.planproinformation package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _WorkflowInformation_QNAME = new QName("http://www.exampleURI.com/PlanProInformation", "WorkflowInformation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.exampleuri.planproinformation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WorkflowInformation }
     * 
     */
    public WorkflowInformation createWorkflowInformation() {
        return new WorkflowInformation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.exampleURI.com/PlanProInformation", name = "WorkflowInformation")
    public JAXBElement<WorkflowInformation> createWorkflowInformation(WorkflowInformation value) {
        return new JAXBElement<WorkflowInformation>(_WorkflowInformation_QNAME, WorkflowInformation.class, null, value);
    }

}
