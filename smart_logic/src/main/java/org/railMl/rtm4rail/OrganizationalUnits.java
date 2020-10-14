//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * This is the top level element for various company definitions regarding the railway services referred to in this file
 * 
 * <p>Java-Klasse für OrganizationalUnits complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OrganizationalUnits">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="infrastructureManager" type="{https://www.railml.org/schemas/3.1}InfrastructureManager" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vehicleManufacturer" type="{https://www.railml.org/schemas/3.1}VehicleManufacturer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vehicleOperator" type="{https://www.railml.org/schemas/3.1}VehicleOperator" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="customer" type="{https://www.railml.org/schemas/3.1}Customer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="railwayUndertaking" type="{https://www.railml.org/schemas/3.1}RailwayUndertaking" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="operationalUndertaking" type="{https://www.railml.org/schemas/3.1}OperationalUndertaking" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="concessionaire" type="{https://www.railml.org/schemas/3.1}Concessionaire" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="contractor" type="{https://www.railml.org/schemas/3.1}Contractor" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationalUnits", propOrder = {
    "infrastructureManager",
    "vehicleManufacturer",
    "vehicleOperator",
    "customer",
    "railwayUndertaking",
    "operationalUndertaking",
    "concessionaire",
    "contractor"
})
public class OrganizationalUnits {

    protected List<InfrastructureManager> infrastructureManager;
    protected List<VehicleManufacturer> vehicleManufacturer;
    protected List<VehicleOperator> vehicleOperator;
    protected List<Customer> customer;
    protected List<RailwayUndertaking> railwayUndertaking;
    protected List<OperationalUndertaking> operationalUndertaking;
    protected List<Concessionaire> concessionaire;
    protected List<Contractor> contractor;

    /**
     * Gets the value of the infrastructureManager property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infrastructureManager property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfrastructureManager().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfrastructureManager }
     * 
     * 
     */
    public List<InfrastructureManager> getInfrastructureManager() {
        if (infrastructureManager == null) {
            infrastructureManager = new ArrayList<InfrastructureManager>();
        }
        return this.infrastructureManager;
    }

    /**
     * Gets the value of the vehicleManufacturer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehicleManufacturer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehicleManufacturer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleManufacturer }
     * 
     * 
     */
    public List<VehicleManufacturer> getVehicleManufacturer() {
        if (vehicleManufacturer == null) {
            vehicleManufacturer = new ArrayList<VehicleManufacturer>();
        }
        return this.vehicleManufacturer;
    }

    /**
     * Gets the value of the vehicleOperator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehicleOperator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehicleOperator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleOperator }
     * 
     * 
     */
    public List<VehicleOperator> getVehicleOperator() {
        if (vehicleOperator == null) {
            vehicleOperator = new ArrayList<VehicleOperator>();
        }
        return this.vehicleOperator;
    }

    /**
     * Gets the value of the customer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Customer }
     * 
     * 
     */
    public List<Customer> getCustomer() {
        if (customer == null) {
            customer = new ArrayList<Customer>();
        }
        return this.customer;
    }

    /**
     * Gets the value of the railwayUndertaking property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the railwayUndertaking property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRailwayUndertaking().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RailwayUndertaking }
     * 
     * 
     */
    public List<RailwayUndertaking> getRailwayUndertaking() {
        if (railwayUndertaking == null) {
            railwayUndertaking = new ArrayList<RailwayUndertaking>();
        }
        return this.railwayUndertaking;
    }

    /**
     * Gets the value of the operationalUndertaking property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operationalUndertaking property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperationalUndertaking().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperationalUndertaking }
     * 
     * 
     */
    public List<OperationalUndertaking> getOperationalUndertaking() {
        if (operationalUndertaking == null) {
            operationalUndertaking = new ArrayList<OperationalUndertaking>();
        }
        return this.operationalUndertaking;
    }

    /**
     * Gets the value of the concessionaire property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the concessionaire property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConcessionaire().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Concessionaire }
     * 
     * 
     */
    public List<Concessionaire> getConcessionaire() {
        if (concessionaire == null) {
            concessionaire = new ArrayList<Concessionaire>();
        }
        return this.concessionaire;
    }

    /**
     * Gets the value of the contractor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contractor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContractor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Contractor }
     * 
     * 
     */
    public List<Contractor> getContractor() {
        if (contractor == null) {
            contractor = new ArrayList<Contractor>();
        }
        return this.contractor;
    }

}
