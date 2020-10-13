//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import javax.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.railMl.rtm4rail package. 
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

    private final static QName _Contributor_QNAME = new QName("http://purl.org/dc/elements/1.1/", "contributor");
    private final static QName _Rights_QNAME = new QName("http://purl.org/dc/elements/1.1/", "rights");
    private final static QName _Publisher_QNAME = new QName("http://purl.org/dc/elements/1.1/", "publisher");
    private final static QName _Date_QNAME = new QName("http://purl.org/dc/elements/1.1/", "date");
    private final static QName _Coverage_QNAME = new QName("http://purl.org/dc/elements/1.1/", "coverage");
    private final static QName _Identifier_QNAME = new QName("http://purl.org/dc/elements/1.1/", "identifier");
    private final static QName _Creator_QNAME = new QName("http://purl.org/dc/elements/1.1/", "creator");
    private final static QName _Subject_QNAME = new QName("http://purl.org/dc/elements/1.1/", "subject");
    private final static QName _Format_QNAME = new QName("http://purl.org/dc/elements/1.1/", "format");
    private final static QName _Description_QNAME = new QName("http://purl.org/dc/elements/1.1/", "description");
    private final static QName _Language_QNAME = new QName("http://purl.org/dc/elements/1.1/", "language");
    private final static QName _Source_QNAME = new QName("http://purl.org/dc/elements/1.1/", "source");
    private final static QName _Title_QNAME = new QName("http://purl.org/dc/elements/1.1/", "title");
    private final static QName _Type_QNAME = new QName("http://purl.org/dc/elements/1.1/", "type");
    private final static QName _Any_QNAME = new QName("http://purl.org/dc/elements/1.1/", "any");
    private final static QName _Relation_QNAME = new QName("http://purl.org/dc/elements/1.1/", "relation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.railMl.rtm4rail
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link RTMOrderedCollection }
     * 
     */
    public RTMOrderedCollection createRTMOrderedCollection() {
        return new RTMOrderedCollection();
    }

    /**
     * Create an instance of {@link ScreenPositioningSystem }
     * 
     */
    public ScreenPositioningSystem createScreenPositioningSystem() {
        return new ScreenPositioningSystem();
    }

    /**
     * Create an instance of {@link LinearPositioningSystems }
     * 
     */
    public LinearPositioningSystems createLinearPositioningSystems() {
        return new LinearPositioningSystems();
    }

    /**
     * Create an instance of {@link ElectrificationSystem }
     * 
     */
    public ElectrificationSystem createElectrificationSystem() {
        return new ElectrificationSystem();
    }

    /**
     * Create an instance of {@link DateWithBitmask }
     * 
     */
    public DateWithBitmask createDateWithBitmask() {
        return new DateWithBitmask();
    }

    /**
     * Create an instance of {@link TElementWithIDandCode }
     * 
     */
    public TElementWithIDandCode createTElementWithIDandCode() {
        return new TElementWithIDandCode();
    }

    /**
     * Create an instance of {@link SpeedProfileBraking }
     * 
     */
    public SpeedProfileBraking createSpeedProfileBraking() {
        return new SpeedProfileBraking();
    }

    /**
     * Create an instance of {@link TimePeriodRuleSituation }
     * 
     */
    public TimePeriodRuleSituation createTimePeriodRuleSituation() {
        return new TimePeriodRuleSituation();
    }

    /**
     * Create an instance of {@link Designator }
     * 
     */
    public Designator createDesignator() {
        return new Designator();
    }

    /**
     * Create an instance of {@link CalendarTimePeriodWithBitmask }
     * 
     */
    public CalendarTimePeriodWithBitmask createCalendarTimePeriodWithBitmask() {
        return new CalendarTimePeriodWithBitmask();
    }

    /**
     * Create an instance of {@link RTMGeometricPositioningSystem }
     * 
     */
    public RTMGeometricPositioningSystem createRTMGeometricPositioningSystem() {
        return new RTMGeometricPositioningSystem();
    }

    /**
     * Create an instance of {@link TimeStamp }
     * 
     */
    public TimeStamp createTimeStamp() {
        return new TimeStamp();
    }

    /**
     * Create an instance of {@link RTMPositioningNetElement }
     * 
     */
    public RTMPositioningNetElement createRTMPositioningNetElement() {
        return new RTMPositioningNetElement();
    }

    /**
     * Create an instance of {@link RTMNamedResource }
     * 
     */
    public RTMNamedResource createRTMNamedResource() {
        return new RTMNamedResource();
    }

    /**
     * Create an instance of {@link RTMLinearPositioningSystem }
     * 
     */
    public RTMLinearPositioningSystem createRTMLinearPositioningSystem() {
        return new RTMLinearPositioningSystem();
    }

    /**
     * Create an instance of {@link ClockTimePeriod }
     * 
     */
    public ClockTimePeriod createClockTimePeriod() {
        return new ClockTimePeriod();
    }

    /**
     * Create an instance of {@link GenericTimePeriod }
     * 
     */
    public GenericTimePeriod createGenericTimePeriod() {
        return new GenericTimePeriod();
    }

    /**
     * Create an instance of {@link InfrastructureManager }
     * 
     */
    public InfrastructureManager createInfrastructureManager() {
        return new InfrastructureManager();
    }

    /**
     * Create an instance of {@link Metadata }
     * 
     */
    public Metadata createMetadata() {
        return new Metadata();
    }

    /**
     * Create an instance of {@link RTMGeometricCoordinate }
     * 
     */
    public RTMGeometricCoordinate createRTMGeometricCoordinate() {
        return new RTMGeometricCoordinate();
    }

    /**
     * Create an instance of {@link TElementTimeStamp }
     * 
     */
    public TElementTimeStamp createTElementTimeStamp() {
        return new TElementTimeStamp();
    }

    /**
     * Create an instance of {@link SpeedProfileLoad }
     * 
     */
    public SpeedProfileLoad createSpeedProfileLoad() {
        return new SpeedProfileLoad();
    }

    /**
     * Create an instance of {@link RTMValidity }
     * 
     */
    public RTMValidity createRTMValidity() {
        return new RTMValidity();
    }

    /**
     * Create an instance of {@link RailwayUndertaking }
     * 
     */
    public RailwayUndertaking createRailwayUndertaking() {
        return new RailwayUndertaking();
    }

    /**
     * Create an instance of {@link OperationalUndertaking }
     * 
     */
    public OperationalUndertaking createOperationalUndertaking() {
        return new OperationalUndertaking();
    }

    /**
     * Create an instance of {@link RTMIntrinsicCoordinate }
     * 
     */
    public RTMIntrinsicCoordinate createRTMIntrinsicCoordinate() {
        return new RTMIntrinsicCoordinate();
    }

    /**
     * Create an instance of {@link RTMLevelNetwork }
     * 
     */
    public RTMLevelNetwork createRTMLevelNetwork() {
        return new RTMLevelNetwork();
    }

    /**
     * Create an instance of {@link VehicleOperator }
     * 
     */
    public VehicleOperator createVehicleOperator() {
        return new VehicleOperator();
    }

    /**
     * Create an instance of {@link SpeedProfiles }
     * 
     */
    public SpeedProfiles createSpeedProfiles() {
        return new SpeedProfiles();
    }

    /**
     * Create an instance of {@link RTMCompositionNetElement }
     * 
     */
    public RTMCompositionNetElement createRTMCompositionNetElement() {
        return new RTMCompositionNetElement();
    }

    /**
     * Create an instance of {@link RTMAssociatedNetElement }
     * 
     */
    public RTMAssociatedNetElement createRTMAssociatedNetElement() {
        return new RTMAssociatedNetElement();
    }

    /**
     * Create an instance of {@link TElementBitmaskAny }
     * 
     */
    public TElementBitmaskAny createTElementBitmaskAny() {
        return new TElementBitmaskAny();
    }

    /**
     * Create an instance of {@link RTMNonLinearNetElement }
     * 
     */
    public RTMNonLinearNetElement createRTMNonLinearNetElement() {
        return new RTMNonLinearNetElement();
    }

    /**
     * Create an instance of {@link Name }
     * 
     */
    public Name createName() {
        return new Name();
    }

    /**
     * Create an instance of {@link Contractor }
     * 
     */
    public Contractor createContractor() {
        return new Contractor();
    }

    /**
     * Create an instance of {@link RTMAssociatedPositioningSystem }
     * 
     */
    public RTMAssociatedPositioningSystem createRTMAssociatedPositioningSystem() {
        return new RTMAssociatedPositioningSystem();
    }

    /**
     * Create an instance of {@link CalendarTimePeriod }
     * 
     */
    public CalendarTimePeriod createCalendarTimePeriod() {
        return new CalendarTimePeriod();
    }

    /**
     * Create an instance of {@link RTMNetEntity }
     * 
     */
    public RTMNetEntity createRTMNetEntity() {
        return new RTMNetEntity();
    }

    /**
     * Create an instance of {@link RTMLinearNetElement }
     * 
     */
    public RTMLinearNetElement createRTMLinearNetElement() {
        return new RTMLinearNetElement();
    }

    /**
     * Create an instance of {@link GenericOperatingPeriodDescription }
     * 
     */
    public GenericOperatingPeriodDescription createGenericOperatingPeriodDescription() {
        return new GenericOperatingPeriodDescription();
    }

    /**
     * Create an instance of {@link Period }
     * 
     */
    public Period createPeriod() {
        return new Period();
    }

    /**
     * Create an instance of {@link Concessionaire }
     * 
     */
    public Concessionaire createConcessionaire() {
        return new Concessionaire();
    }

    /**
     * Create an instance of {@link RTMRelation }
     * 
     */
    public RTMRelation createRTMRelation() {
        return new RTMRelation();
    }

    /**
     * Create an instance of {@link RTMLinearAnchorPoint }
     * 
     */
    public RTMLinearAnchorPoint createRTMLinearAnchorPoint() {
        return new RTMLinearAnchorPoint();
    }

    /**
     * Create an instance of {@link Common }
     * 
     */
    public Common createCommon() {
        return new Common();
    }

    /**
     * Create an instance of {@link RTMLocatedNetEntity }
     * 
     */
    public RTMLocatedNetEntity createRTMLocatedNetEntity() {
        return new RTMLocatedNetEntity();
    }

    /**
     * Create an instance of {@link External }
     * 
     */
    public External createExternal() {
        return new External();
    }

    /**
     * Create an instance of {@link GeometricPositioningSystems }
     * 
     */
    public GeometricPositioningSystems createGeometricPositioningSystems() {
        return new GeometricPositioningSystems();
    }

    /**
     * Create an instance of {@link RTMNetworkResource }
     * 
     */
    public RTMNetworkResource createRTMNetworkResource() {
        return new RTMNetworkResource();
    }

    /**
     * Create an instance of {@link PeriodRule }
     * 
     */
    public PeriodRule createPeriodRule() {
        return new PeriodRule();
    }

    /**
     * Create an instance of {@link ScreenPositioningSystems }
     * 
     */
    public ScreenPositioningSystems createScreenPositioningSystems() {
        return new ScreenPositioningSystems();
    }

    /**
     * Create an instance of {@link PublicHolidayPeriodRule }
     * 
     */
    public PublicHolidayPeriodRule createPublicHolidayPeriodRule() {
        return new PublicHolidayPeriodRule();
    }

    /**
     * Create an instance of {@link RTMLinearLocation }
     * 
     */
    public RTMLinearLocation createRTMLinearLocation() {
        return new RTMLinearLocation();
    }

    /**
     * Create an instance of {@link ElectrificationSystems }
     * 
     */
    public ElectrificationSystems createElectrificationSystems() {
        return new ElectrificationSystems();
    }

    /**
     * Create an instance of {@link RTMSpotLocation }
     * 
     */
    public RTMSpotLocation createRTMSpotLocation() {
        return new RTMSpotLocation();
    }

    /**
     * Create an instance of {@link RTMPositioningSystem }
     * 
     */
    public RTMPositioningSystem createRTMPositioningSystem() {
        return new RTMPositioningSystem();
    }

    /**
     * Create an instance of {@link OperatingDay }
     * 
     */
    public OperatingDay createOperatingDay() {
        return new OperatingDay();
    }

    /**
     * Create an instance of {@link RTMPositioningSystemCoordinate }
     * 
     */
    public RTMPositioningSystemCoordinate createRTMPositioningSystemCoordinate() {
        return new RTMPositioningSystemCoordinate();
    }

    /**
     * Create an instance of {@link RTMLinearCoordinate }
     * 
     */
    public RTMLinearCoordinate createRTMLinearCoordinate() {
        return new RTMLinearCoordinate();
    }

    /**
     * Create an instance of {@link VehicleManufacturer }
     * 
     */
    public VehicleManufacturer createVehicleManufacturer() {
        return new VehicleManufacturer();
    }

    /**
     * Create an instance of {@link SpeedProfileTrainType }
     * 
     */
    public SpeedProfileTrainType createSpeedProfileTrainType() {
        return new SpeedProfileTrainType();
    }

    /**
     * Create an instance of {@link TElementWithIDref }
     * 
     */
    public TElementWithIDref createTElementWithIDref() {
        return new TElementWithIDref();
    }

    /**
     * Create an instance of {@link SpeedProfile }
     * 
     */
    public SpeedProfile createSpeedProfile() {
        return new SpeedProfile();
    }

    /**
     * Create an instance of {@link RTMAreaLocation }
     * 
     */
    public RTMAreaLocation createRTMAreaLocation() {
        return new RTMAreaLocation();
    }

    /**
     * Create an instance of {@link RTMNetElement }
     * 
     */
    public RTMNetElement createRTMNetElement() {
        return new RTMNetElement();
    }

    /**
     * Create an instance of {@link RTMUnorderedCollection }
     * 
     */
    public RTMUnorderedCollection createRTMUnorderedCollection() {
        return new RTMUnorderedCollection();
    }

    /**
     * Create an instance of {@link OrganizationalUnits }
     * 
     */
    public OrganizationalUnits createOrganizationalUnits() {
        return new OrganizationalUnits();
    }

    /**
     * Create an instance of {@link ElemBasedPeriodRule }
     * 
     */
    public ElemBasedPeriodRule createElemBasedPeriodRule() {
        return new ElemBasedPeriodRule();
    }

    /**
     * Create an instance of {@link TElementBitmaskWeek }
     * 
     */
    public TElementBitmaskWeek createTElementBitmaskWeek() {
        return new TElementBitmaskWeek();
    }

    /**
     * Create an instance of {@link ShiftablePeriodRule }
     * 
     */
    public ShiftablePeriodRule createShiftablePeriodRule() {
        return new ShiftablePeriodRule();
    }

    /**
     * Create an instance of {@link SpeedProfileTilting }
     * 
     */
    public SpeedProfileTilting createSpeedProfileTilting() {
        return new SpeedProfileTilting();
    }

    /**
     * Create an instance of {@link PositioningSystems }
     * 
     */
    public PositioningSystems createPositioningSystems() {
        return new PositioningSystems();
    }

    /**
     * Create an instance of {@link SimpleLiteral }
     * 
     */
    public SimpleLiteral createSimpleLiteral() {
        return new SimpleLiteral();
    }

    /**
     * Create an instance of {@link ElementContainer }
     * 
     */
    public ElementContainer createElementContainer() {
        return new ElementContainer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "contributor", substitutionHeadNamespace = "http://purl.org/dc/elements/1.1/", substitutionHeadName = "any")
    public JAXBElement<SimpleLiteral> createContributor(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Contributor_QNAME, SimpleLiteral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "rights", substitutionHeadNamespace = "http://purl.org/dc/elements/1.1/", substitutionHeadName = "any")
    public JAXBElement<SimpleLiteral> createRights(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Rights_QNAME, SimpleLiteral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "publisher", substitutionHeadNamespace = "http://purl.org/dc/elements/1.1/", substitutionHeadName = "any")
    public JAXBElement<SimpleLiteral> createPublisher(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Publisher_QNAME, SimpleLiteral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "date", substitutionHeadNamespace = "http://purl.org/dc/elements/1.1/", substitutionHeadName = "any")
    public JAXBElement<SimpleLiteral> createDate(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Date_QNAME, SimpleLiteral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "coverage", substitutionHeadNamespace = "http://purl.org/dc/elements/1.1/", substitutionHeadName = "any")
    public JAXBElement<SimpleLiteral> createCoverage(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Coverage_QNAME, SimpleLiteral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "identifier", substitutionHeadNamespace = "http://purl.org/dc/elements/1.1/", substitutionHeadName = "any")
    public JAXBElement<SimpleLiteral> createIdentifier(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Identifier_QNAME, SimpleLiteral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "creator", substitutionHeadNamespace = "http://purl.org/dc/elements/1.1/", substitutionHeadName = "any")
    public JAXBElement<SimpleLiteral> createCreator(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Creator_QNAME, SimpleLiteral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "subject", substitutionHeadNamespace = "http://purl.org/dc/elements/1.1/", substitutionHeadName = "any")
    public JAXBElement<SimpleLiteral> createSubject(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Subject_QNAME, SimpleLiteral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "format", substitutionHeadNamespace = "http://purl.org/dc/elements/1.1/", substitutionHeadName = "any")
    public JAXBElement<SimpleLiteral> createFormat(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Format_QNAME, SimpleLiteral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "description", substitutionHeadNamespace = "http://purl.org/dc/elements/1.1/", substitutionHeadName = "any")
    public JAXBElement<SimpleLiteral> createDescription(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Description_QNAME, SimpleLiteral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "language", substitutionHeadNamespace = "http://purl.org/dc/elements/1.1/", substitutionHeadName = "any")
    public JAXBElement<SimpleLiteral> createLanguage(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Language_QNAME, SimpleLiteral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "source", substitutionHeadNamespace = "http://purl.org/dc/elements/1.1/", substitutionHeadName = "any")
    public JAXBElement<SimpleLiteral> createSource(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Source_QNAME, SimpleLiteral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "title", substitutionHeadNamespace = "http://purl.org/dc/elements/1.1/", substitutionHeadName = "any")
    public JAXBElement<SimpleLiteral> createTitle(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Title_QNAME, SimpleLiteral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "type", substitutionHeadNamespace = "http://purl.org/dc/elements/1.1/", substitutionHeadName = "any")
    public JAXBElement<SimpleLiteral> createType(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Type_QNAME, SimpleLiteral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "any")
    public JAXBElement<SimpleLiteral> createAny(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Any_QNAME, SimpleLiteral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleLiteral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "relation", substitutionHeadNamespace = "http://purl.org/dc/elements/1.1/", substitutionHeadName = "any")
    public JAXBElement<SimpleLiteral> createRelation(SimpleLiteral value) {
        return new JAXBElement<SimpleLiteral>(_Relation_QNAME, SimpleLiteral.class, null, value);
    }

}
