//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import javax.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.railMl package. 
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
    private final static QName _Rollingstock_QNAME = new QName("https://www.railml.org/schemas/3.1", "Rollingstock");
    private final static QName _Rights_QNAME = new QName("http://purl.org/dc/elements/1.1/", "rights");
    private final static QName _Publisher_QNAME = new QName("http://purl.org/dc/elements/1.1/", "publisher");
    private final static QName _Date_QNAME = new QName("http://purl.org/dc/elements/1.1/", "date");
    private final static QName _Coverage_QNAME = new QName("http://purl.org/dc/elements/1.1/", "coverage");
    private final static QName _Identifier_QNAME = new QName("http://purl.org/dc/elements/1.1/", "identifier");
    private final static QName _Creator_QNAME = new QName("http://purl.org/dc/elements/1.1/", "creator");
    private final static QName _Timetable_QNAME = new QName("https://www.railml.org/schemas/3.1", "Timetable");
    private final static QName _RailML_QNAME = new QName("https://www.railml.org/schemas/3.1", "railML");
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.railMl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Timetable }
     * 
     */
    public Timetable createTimetable() {
        return new Timetable();
    }

    /**
     * Create an instance of {@link RailML }
     * 
     */
    public RailML createRailML() {
        return new RailML();
    }

    /**
     * Create an instance of {@link Rollingstock }
     * 
     */
    public Rollingstock createRollingstock() {
        return new Rollingstock();
    }

    /**
     * Create an instance of {@link RouteEntry }
     * 
     */
    public RouteEntry createRouteEntry() {
        return new RouteEntry();
    }

    /**
     * Create an instance of {@link DetectorTypes }
     * 
     */
    public DetectorTypes createDetectorTypes() {
        return new DetectorTypes();
    }

    /**
     * Create an instance of {@link RouteReleaseGroupRear }
     * 
     */
    public RouteReleaseGroupRear createRouteReleaseGroupRear() {
        return new RouteReleaseGroupRear();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link GradientCurve }
     * 
     */
    public GradientCurve createGradientCurve() {
        return new GradientCurve();
    }

    /**
     * Create an instance of {@link StoppingPlace }
     * 
     */
    public StoppingPlace createStoppingPlace() {
        return new StoppingPlace();
    }

    /**
     * Create an instance of {@link RTMOrderedCollection }
     * 
     */
    public RTMOrderedCollection createRTMOrderedCollection() {
        return new RTMOrderedCollection();
    }

    /**
     * Create an instance of {@link LockAndState }
     * 
     */
    public LockAndState createLockAndState() {
        return new LockAndState();
    }

    /**
     * Create an instance of {@link TrackAssetConnectedToIL }
     * 
     */
    public TrackAssetConnectedToIL createTrackAssetConnectedToIL() {
        return new TrackAssetConnectedToIL();
    }

    /**
     * Create an instance of {@link SignalPlan }
     * 
     */
    public SignalPlan createSignalPlan() {
        return new SignalPlan();
    }

    /**
     * Create an instance of {@link TrackGauge }
     * 
     */
    public TrackGauge createTrackGauge() {
        return new TrackGauge();
    }

    /**
     * Create an instance of {@link ElectrificationSystem }
     * 
     */
    public ElectrificationSystem createElectrificationSystem() {
        return new ElectrificationSystem();
    }

    /**
     * Create an instance of {@link LevelCrossingTypeList }
     * 
     */
    public LevelCrossingTypeList createLevelCrossingTypeList() {
        return new LevelCrossingTypeList();
    }

    /**
     * Create an instance of {@link GenericDetector }
     * 
     */
    public GenericDetector createGenericDetector() {
        return new GenericDetector();
    }

    /**
     * Create an instance of {@link SignalTrainMovement }
     * 
     */
    public SignalTrainMovement createSignalTrainMovement() {
        return new SignalTrainMovement();
    }

    /**
     * Create an instance of {@link TimeStamp }
     * 
     */
    public TimeStamp createTimeStamp() {
        return new TimeStamp();
    }

    /**
     * Create an instance of {@link ActivationCondition }
     * 
     */
    public ActivationCondition createActivationCondition() {
        return new ActivationCondition();
    }

    /**
     * Create an instance of {@link Line }
     * 
     */
    public Line createLine() {
        return new Line();
    }

    /**
     * Create an instance of {@link Interlocking }
     * 
     */
    public Interlocking createInterlocking() {
        return new Interlocking();
    }

    /**
     * Create an instance of {@link DerailersIL }
     * 
     */
    public DerailersIL createDerailersIL() {
        return new DerailersIL();
    }

    /**
     * Create an instance of {@link RouteReleaseGroupsRear }
     * 
     */
    public RouteReleaseGroupsRear createRouteReleaseGroupsRear() {
        return new RouteReleaseGroupsRear();
    }

    /**
     * Create an instance of {@link FunctionalInfrastructure }
     * 
     */
    public FunctionalInfrastructure createFunctionalInfrastructure() {
        return new FunctionalInfrastructure();
    }

    /**
     * Create an instance of {@link SignalBoxes }
     * 
     */
    public SignalBoxes createSignalBoxes() {
        return new SignalBoxes();
    }

    /**
     * Create an instance of {@link DerailersIS }
     * 
     */
    public DerailersIS createDerailersIS() {
        return new DerailersIS();
    }

    /**
     * Create an instance of {@link Visualization }
     * 
     */
    public Visualization createVisualization() {
        return new Visualization();
    }

    /**
     * Create an instance of {@link ElementProjectionSymbol }
     * 
     */
    public ElementProjectionSymbol createElementProjectionSymbol() {
        return new ElementProjectionSymbol();
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
     * Create an instance of {@link SignalMilepost }
     * 
     */
    public SignalMilepost createSignalMilepost() {
        return new SignalMilepost();
    }

    /**
     * Create an instance of {@link SpeedProfileLoad }
     * 
     */
    public SpeedProfileLoad createSpeedProfileLoad() {
        return new SpeedProfileLoad();
    }

    /**
     * Create an instance of {@link PowerSuppliesIL }
     * 
     */
    public PowerSuppliesIL createPowerSuppliesIL() {
        return new PowerSuppliesIL();
    }

    /**
     * Create an instance of {@link WeightLimits }
     * 
     */
    public WeightLimits createWeightLimits() {
        return new WeightLimits();
    }

    /**
     * Create an instance of {@link SwitchRelatedDelay }
     * 
     */
    public SwitchRelatedDelay createSwitchRelatedDelay() {
        return new SwitchRelatedDelay();
    }

    /**
     * Create an instance of {@link Length }
     * 
     */
    public Length createLength() {
        return new Length();
    }

    /**
     * Create an instance of {@link LockAndGivenState }
     * 
     */
    public LockAndGivenState createLockAndGivenState() {
        return new LockAndGivenState();
    }

    /**
     * Create an instance of {@link PointTypeCoordinate }
     * 
     */
    public PointTypeCoordinate createPointTypeCoordinate() {
        return new PointTypeCoordinate();
    }

    /**
     * Create an instance of {@link Interface }
     * 
     */
    public Interface createInterface() {
        return new Interface();
    }

    /**
     * Create an instance of {@link SignalSpeed }
     * 
     */
    public SignalSpeed createSignalSpeed() {
        return new SignalSpeed();
    }

    /**
     * Create an instance of {@link GenericTypes }
     * 
     */
    public GenericTypes createGenericTypes() {
        return new GenericTypes();
    }

    /**
     * Create an instance of {@link LineTrafficCode }
     * 
     */
    public LineTrafficCode createLineTrafficCode() {
        return new LineTrafficCode();
    }

    /**
     * Create an instance of {@link TElementBitmaskAny }
     * 
     */
    public TElementBitmaskAny createTElementBitmaskAny() {
        return new TElementBitmaskAny();
    }

    /**
     * Create an instance of {@link NetElements }
     * 
     */
    public NetElements createNetElements() {
        return new NetElements();
    }

    /**
     * Create an instance of {@link StoppingPlaces }
     * 
     */
    public StoppingPlaces createStoppingPlaces() {
        return new StoppingPlaces();
    }

    /**
     * Create an instance of {@link TrainDetectionElements }
     * 
     */
    public TrainDetectionElements createTrainDetectionElements() {
        return new TrainDetectionElements();
    }

    /**
     * Create an instance of {@link CalendarTimePeriod }
     * 
     */
    public CalendarTimePeriod createCalendarTimePeriod() {
        return new CalendarTimePeriod();
    }

    /**
     * Create an instance of {@link GeometryPoint }
     * 
     */
    public GeometryPoint createGeometryPoint() {
        return new GeometryPoint();
    }

    /**
     * Create an instance of {@link ControlledSignalBox }
     * 
     */
    public ControlledSignalBox createControlledSignalBox() {
        return new ControlledSignalBox();
    }

    /**
     * Create an instance of {@link PermissionZone }
     * 
     */
    public PermissionZone createPermissionZone() {
        return new PermissionZone();
    }

    /**
     * Create an instance of {@link DetectorInState }
     * 
     */
    public DetectorInState createDetectorInState() {
        return new DetectorInState();
    }

    /**
     * Create an instance of {@link HorizontalCurves }
     * 
     */
    public HorizontalCurves createHorizontalCurves() {
        return new HorizontalCurves();
    }

    /**
     * Create an instance of {@link External }
     * 
     */
    public External createExternal() {
        return new External();
    }

    /**
     * Create an instance of {@link LevelCrossingInState }
     * 
     */
    public LevelCrossingInState createLevelCrossingInState() {
        return new LevelCrossingInState();
    }

    /**
     * Create an instance of {@link LoadingGauges }
     * 
     */
    public LoadingGauges createLoadingGauges() {
        return new LoadingGauges();
    }

    /**
     * Create an instance of {@link Electrifications }
     * 
     */
    public Electrifications createElectrifications() {
        return new Electrifications();
    }

    /**
     * Create an instance of {@link TrackBed }
     * 
     */
    public TrackBed createTrackBed() {
        return new TrackBed();
    }

    /**
     * Create an instance of {@link ScreenPositioningSystems }
     * 
     */
    public ScreenPositioningSystems createScreenPositioningSystems() {
        return new ScreenPositioningSystems();
    }

    /**
     * Create an instance of {@link GenericDetectors }
     * 
     */
    public GenericDetectors createGenericDetectors() {
        return new GenericDetectors();
    }

    /**
     * Create an instance of {@link SignalRadio }
     * 
     */
    public SignalRadio createSignalRadio() {
        return new SignalRadio();
    }

    /**
     * Create an instance of {@link RouteRelation }
     * 
     */
    public RouteRelation createRouteRelation() {
        return new RouteRelation();
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
     * Create an instance of {@link MovableCrossing }
     * 
     */
    public MovableCrossing createMovableCrossing() {
        return new MovableCrossing();
    }

    /**
     * Create an instance of {@link DerailerInPosition }
     * 
     */
    public DerailerInPosition createDerailerInPosition() {
        return new DerailerInPosition();
    }

    /**
     * Create an instance of {@link InfrastructureStates }
     * 
     */
    public InfrastructureStates createInfrastructureStates() {
        return new InfrastructureStates();
    }

    /**
     * Create an instance of {@link RTMUnorderedCollection }
     * 
     */
    public RTMUnorderedCollection createRTMUnorderedCollection() {
        return new RTMUnorderedCollection();
    }

    /**
     * Create an instance of {@link EntityILref }
     * 
     */
    public EntityILref createEntityILref() {
        return new EntityILref();
    }

    /**
     * Create an instance of {@link SwitchCrossingBranch }
     * 
     */
    public SwitchCrossingBranch createSwitchCrossingBranch() {
        return new SwitchCrossingBranch();
    }

    /**
     * Create an instance of {@link BufferStop }
     * 
     */
    public BufferStop createBufferStop() {
        return new BufferStop();
    }

    /**
     * Create an instance of {@link Controllers }
     * 
     */
    public Controllers createControllers() {
        return new Controllers();
    }

    /**
     * Create an instance of {@link SignalCatenary }
     * 
     */
    public SignalCatenary createSignalCatenary() {
        return new SignalCatenary();
    }

    /**
     * Create an instance of {@link PantographSpacing }
     * 
     */
    public PantographSpacing createPantographSpacing() {
        return new PantographSpacing();
    }

    /**
     * Create an instance of {@link LineTypeCoordinate }
     * 
     */
    public LineTypeCoordinate createLineTypeCoordinate() {
        return new LineTypeCoordinate();
    }

    /**
     * Create an instance of {@link CrossedElement }
     * 
     */
    public CrossedElement createCrossedElement() {
        return new CrossedElement();
    }

    /**
     * Create an instance of {@link EnergyCatenary }
     * 
     */
    public EnergyCatenary createEnergyCatenary() {
        return new EnergyCatenary();
    }

    /**
     * Create an instance of {@link LocalOperationAreas }
     * 
     */
    public LocalOperationAreas createLocalOperationAreas() {
        return new LocalOperationAreas();
    }

    /**
     * Create an instance of {@link ShuntingZones }
     * 
     */
    public ShuntingZones createShuntingZones() {
        return new ShuntingZones();
    }

    /**
     * Create an instance of {@link TElementWithIDandCode }
     * 
     */
    public TElementWithIDandCode createTElementWithIDandCode() {
        return new TElementWithIDandCode();
    }

    /**
     * Create an instance of {@link Platforms }
     * 
     */
    public Platforms createPlatforms() {
        return new Platforms();
    }

    /**
     * Create an instance of {@link Designator }
     * 
     */
    public Designator createDesignator() {
        return new Designator();
    }

    /**
     * Create an instance of {@link OpOperation }
     * 
     */
    public OpOperation createOpOperation() {
        return new OpOperation();
    }

    /**
     * Create an instance of {@link Routes }
     * 
     */
    public Routes createRoutes() {
        return new Routes();
    }

    /**
     * Create an instance of {@link ElementProjection }
     * 
     */
    public ElementProjection createElementProjection() {
        return new ElementProjection();
    }

    /**
     * Create an instance of {@link SignalVehicleEquipment }
     * 
     */
    public SignalVehicleEquipment createSignalVehicleEquipment() {
        return new SignalVehicleEquipment();
    }

    /**
     * Create an instance of {@link TrackBeds }
     * 
     */
    public TrackBeds createTrackBeds() {
        return new TrackBeds();
    }

    /**
     * Create an instance of {@link RTMLinearPositioningSystem }
     * 
     */
    public RTMLinearPositioningSystem createRTMLinearPositioningSystem() {
        return new RTMLinearPositioningSystem();
    }

    /**
     * Create an instance of {@link NetElement }
     * 
     */
    public NetElement createNetElement() {
        return new NetElement();
    }

    /**
     * Create an instance of {@link CrossingAndGivenPosition }
     * 
     */
    public CrossingAndGivenPosition createCrossingAndGivenPosition() {
        return new CrossingAndGivenPosition();
    }

    /**
     * Create an instance of {@link TrainMovement }
     * 
     */
    public TrainMovement createTrainMovement() {
        return new TrainMovement();
    }

    /**
     * Create an instance of {@link GenericTimePeriod }
     * 
     */
    public GenericTimePeriod createGenericTimePeriod() {
        return new GenericTimePeriod();
    }

    /**
     * Create an instance of {@link SignalDelayTime }
     * 
     */
    public SignalDelayTime createSignalDelayTime() {
        return new SignalDelayTime();
    }

    /**
     * Create an instance of {@link LineCombinedTransportCode }
     * 
     */
    public LineCombinedTransportCode createLineCombinedTransportCode() {
        return new LineCombinedTransportCode();
    }

    /**
     * Create an instance of {@link Tracks }
     * 
     */
    public Tracks createTracks() {
        return new Tracks();
    }

    /**
     * Create an instance of {@link LevelCrossingAndState }
     * 
     */
    public LevelCrossingAndState createLevelCrossingAndState() {
        return new LevelCrossingAndState();
    }

    /**
     * Create an instance of {@link RTMLevelNetwork }
     * 
     */
    public RTMLevelNetwork createRTMLevelNetwork() {
        return new RTMLevelNetwork();
    }

    /**
     * Create an instance of {@link SignalDanger }
     * 
     */
    public SignalDanger createSignalDanger() {
        return new SignalDanger();
    }

    /**
     * Create an instance of {@link Geometry }
     * 
     */
    public Geometry createGeometry() {
        return new Geometry();
    }

    /**
     * Create an instance of {@link SpeedProfiles }
     * 
     */
    public SpeedProfiles createSpeedProfiles() {
        return new SpeedProfiles();
    }

    /**
     * Create an instance of {@link UnderCrossing }
     * 
     */
    public UnderCrossing createUnderCrossing() {
        return new UnderCrossing();
    }

    /**
     * Create an instance of {@link SwitchAndGivenPosition }
     * 
     */
    public SwitchAndGivenPosition createSwitchAndGivenPosition() {
        return new SwitchAndGivenPosition();
    }

    /**
     * Create an instance of {@link ContactWire }
     * 
     */
    public ContactWire createContactWire() {
        return new ContactWire();
    }

    /**
     * Create an instance of {@link SwitchesIL }
     * 
     */
    public SwitchesIL createSwitchesIL() {
        return new SwitchesIL();
    }

    /**
     * Create an instance of {@link SwitchesIS }
     * 
     */
    public SwitchesIS createSwitchesIS() {
        return new SwitchesIS();
    }

    /**
     * Create an instance of {@link GenericIM }
     * 
     */
    public GenericIM createGenericIM() {
        return new GenericIM();
    }

    /**
     * Create an instance of {@link RTMNonLinearNetElement }
     * 
     */
    public RTMNonLinearNetElement createRTMNonLinearNetElement() {
        return new RTMNonLinearNetElement();
    }

    /**
     * Create an instance of {@link ServiceSections }
     * 
     */
    public ServiceSections createServiceSections() {
        return new ServiceSections();
    }

    /**
     * Create an instance of {@link DerailerIL }
     * 
     */
    public DerailerIL createDerailerIL() {
        return new DerailerIL();
    }

    /**
     * Create an instance of {@link ElectrificationSection }
     * 
     */
    public ElectrificationSection createElectrificationSection() {
        return new ElectrificationSection();
    }

    /**
     * Create an instance of {@link AspectRelatedLevelCrossingDelay }
     * 
     */
    public AspectRelatedLevelCrossingDelay createAspectRelatedLevelCrossingDelay() {
        return new AspectRelatedLevelCrossingDelay();
    }

    /**
     * Create an instance of {@link DerailerIS }
     * 
     */
    public DerailerIS createDerailerIS() {
        return new DerailerIS();
    }

    /**
     * Create an instance of {@link BufferStops }
     * 
     */
    public BufferStops createBufferStops() {
        return new BufferStops();
    }

    /**
     * Create an instance of {@link RouteActivationSection }
     * 
     */
    public RouteActivationSection createRouteActivationSection() {
        return new RouteActivationSection();
    }

    /**
     * Create an instance of {@link TrainDetectionElement }
     * 
     */
    public TrainDetectionElement createTrainDetectionElement() {
        return new TrainDetectionElement();
    }

    /**
     * Create an instance of {@link LoadingGauge }
     * 
     */
    public LoadingGauge createLoadingGauge() {
        return new LoadingGauge();
    }

    /**
     * Create an instance of {@link GenericOperatingPeriodDescription }
     * 
     */
    public GenericOperatingPeriodDescription createGenericOperatingPeriodDescription() {
        return new GenericOperatingPeriodDescription();
    }

    /**
     * Create an instance of {@link TvdSections }
     * 
     */
    public TvdSections createTvdSections() {
        return new TvdSections();
    }

    /**
     * Create an instance of {@link SignalConstruction }
     * 
     */
    public SignalConstruction createSignalConstruction() {
        return new SignalConstruction();
    }

    /**
     * Create an instance of {@link Topology }
     * 
     */
    public Topology createTopology() {
        return new Topology();
    }

    /**
     * Create an instance of {@link Crossing }
     * 
     */
    public Crossing createCrossing() {
        return new Crossing();
    }

    /**
     * Create an instance of {@link RTMRelation }
     * 
     */
    public RTMRelation createRTMRelation() {
        return new RTMRelation();
    }

    /**
     * Create an instance of {@link DetectorAndState }
     * 
     */
    public DetectorAndState createDetectorAndState() {
        return new DetectorAndState();
    }

    /**
     * Create an instance of {@link LinearProjection }
     * 
     */
    public LinearProjection createLinearProjection() {
        return new LinearProjection();
    }

    /**
     * Create an instance of {@link RTMLinearAnchorPoint }
     * 
     */
    public RTMLinearAnchorPoint createRTMLinearAnchorPoint() {
        return new RTMLinearAnchorPoint();
    }

    /**
     * Create an instance of {@link SwitchIL }
     * 
     */
    public SwitchIL createSwitchIL() {
        return new SwitchIL();
    }

    /**
     * Create an instance of {@link GeometricPositioningSystems }
     * 
     */
    public GeometricPositioningSystems createGeometricPositioningSystems() {
        return new GeometricPositioningSystems();
    }

    /**
     * Create an instance of {@link SwitchIS }
     * 
     */
    public SwitchIS createSwitchIS() {
        return new SwitchIS();
    }

    /**
     * Create an instance of {@link WorkZones }
     * 
     */
    public WorkZones createWorkZones() {
        return new WorkZones();
    }

    /**
     * Create an instance of {@link HorizontalCurve }
     * 
     */
    public HorizontalCurve createHorizontalCurve() {
        return new HorizontalCurve();
    }

    /**
     * Create an instance of {@link PeriodRule }
     * 
     */
    public PeriodRule createPeriodRule() {
        return new PeriodRule();
    }

    /**
     * Create an instance of {@link KeyLocksIS }
     * 
     */
    public KeyLocksIS createKeyLocksIS() {
        return new KeyLocksIS();
    }

    /**
     * Create an instance of {@link SectionAndVacancy }
     * 
     */
    public SectionAndVacancy createSectionAndVacancy() {
        return new SectionAndVacancy();
    }

    /**
     * Create an instance of {@link PublicHolidayPeriodRule }
     * 
     */
    public PublicHolidayPeriodRule createPublicHolidayPeriodRule() {
        return new PublicHolidayPeriodRule();
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
     * Create an instance of {@link KeyLocksIL }
     * 
     */
    public KeyLocksIL createKeyLocksIL() {
        return new KeyLocksIL();
    }

    /**
     * Create an instance of {@link RTMAreaLocation }
     * 
     */
    public RTMAreaLocation createRTMAreaLocation() {
        return new RTMAreaLocation();
    }

    /**
     * Create an instance of {@link LevelCrossingProtection }
     * 
     */
    public LevelCrossingProtection createLevelCrossingProtection() {
        return new LevelCrossingProtection();
    }

    /**
     * Create an instance of {@link RTMNetElement }
     * 
     */
    public RTMNetElement createRTMNetElement() {
        return new RTMNetElement();
    }

    /**
     * Create an instance of {@link RouteReleaseGroupAhead }
     * 
     */
    public RouteReleaseGroupAhead createRouteReleaseGroupAhead() {
        return new RouteReleaseGroupAhead();
    }

    /**
     * Create an instance of {@link ElementState }
     * 
     */
    public ElementState createElementState() {
        return new ElementState();
    }

    /**
     * Create an instance of {@link OrganizationalUnits }
     * 
     */
    public OrganizationalUnits createOrganizationalUnits() {
        return new OrganizationalUnits();
    }

    /**
     * Create an instance of {@link Interfaces }
     * 
     */
    public Interfaces createInterfaces() {
        return new Interfaces();
    }

    /**
     * Create an instance of {@link ConflictingRoutes }
     * 
     */
    public ConflictingRoutes createConflictingRoutes() {
        return new ConflictingRoutes();
    }

    /**
     * Create an instance of {@link ShuntingZone }
     * 
     */
    public ShuntingZone createShuntingZone() {
        return new ShuntingZone();
    }

    /**
     * Create an instance of {@link SignalAndGivenAspect }
     * 
     */
    public SignalAndGivenAspect createSignalAndGivenAspect() {
        return new SignalAndGivenAspect();
    }

    /**
     * Create an instance of {@link OpenEnd }
     * 
     */
    public OpenEnd createOpenEnd() {
        return new OpenEnd();
    }

    /**
     * Create an instance of {@link PositioningSystems }
     * 
     */
    public PositioningSystems createPositioningSystems() {
        return new PositioningSystems();
    }

    /**
     * Create an instance of {@link Track }
     * 
     */
    public Track createTrack() {
        return new Track();
    }

    /**
     * Create an instance of {@link Networks }
     * 
     */
    public Networks createNetworks() {
        return new Networks();
    }

    /**
     * Create an instance of {@link Configuration }
     * 
     */
    public Configuration createConfiguration() {
        return new Configuration();
    }

    /**
     * Create an instance of {@link KeyLockIS }
     * 
     */
    public KeyLockIS createKeyLockIS() {
        return new KeyLockIS();
    }

    /**
     * Create an instance of {@link LocationNetwork }
     * 
     */
    public LocationNetwork createLocationNetwork() {
        return new LocationNetwork();
    }

    /**
     * Create an instance of {@link Overlap }
     * 
     */
    public Overlap createOverlap() {
        return new Overlap();
    }

    /**
     * Create an instance of {@link ScreenPositioningSystem }
     * 
     */
    public ScreenPositioningSystem createScreenPositioningSystem() {
        return new ScreenPositioningSystem();
    }

    /**
     * Create an instance of {@link AreaProjection }
     * 
     */
    public AreaProjection createAreaProjection() {
        return new AreaProjection();
    }

    /**
     * Create an instance of {@link GenericAspect }
     * 
     */
    public GenericAspect createGenericAspect() {
        return new GenericAspect();
    }

    /**
     * Create an instance of {@link RestrictedAreas }
     * 
     */
    public RestrictedAreas createRestrictedAreas() {
        return new RestrictedAreas();
    }

    /**
     * Create an instance of {@link DateWithBitmask }
     * 
     */
    public DateWithBitmask createDateWithBitmask() {
        return new DateWithBitmask();
    }

    /**
     * Create an instance of {@link KeyLockIL }
     * 
     */
    public KeyLockIL createKeyLockIL() {
        return new KeyLockIL();
    }

    /**
     * Create an instance of {@link SystemAssetConnectedToIL }
     * 
     */
    public SystemAssetConnectedToIL createSystemAssetConnectedToIL() {
        return new SystemAssetConnectedToIL();
    }

    /**
     * Create an instance of {@link TimePeriodRuleSituation }
     * 
     */
    public TimePeriodRuleSituation createTimePeriodRuleSituation() {
        return new TimePeriodRuleSituation();
    }

    /**
     * Create an instance of {@link CalendarTimePeriodWithBitmask }
     * 
     */
    public CalendarTimePeriodWithBitmask createCalendarTimePeriodWithBitmask() {
        return new CalendarTimePeriodWithBitmask();
    }

    /**
     * Create an instance of {@link LevelCrossingAndGivenState }
     * 
     */
    public LevelCrossingAndGivenState createLevelCrossingAndGivenState() {
        return new LevelCrossingAndGivenState();
    }

    /**
     * Create an instance of {@link RTMGeometricPositioningSystem }
     * 
     */
    public RTMGeometricPositioningSystem createRTMGeometricPositioningSystem() {
        return new RTMGeometricPositioningSystem();
    }

    /**
     * Create an instance of {@link LocalOperationArea }
     * 
     */
    public LocalOperationArea createLocalOperationArea() {
        return new LocalOperationArea();
    }

    /**
     * Create an instance of {@link PartialRoutes }
     * 
     */
    public PartialRoutes createPartialRoutes() {
        return new PartialRoutes();
    }

    /**
     * Create an instance of {@link SwitchPositionRestriction }
     * 
     */
    public SwitchPositionRestriction createSwitchPositionRestriction() {
        return new SwitchPositionRestriction();
    }

    /**
     * Create an instance of {@link WeightLimit }
     * 
     */
    public WeightLimit createWeightLimit() {
        return new WeightLimit();
    }

    /**
     * Create an instance of {@link Crossings }
     * 
     */
    public Crossings createCrossings() {
        return new Crossings();
    }

    /**
     * Create an instance of {@link SectionAndGivenVacancy }
     * 
     */
    public SectionAndGivenVacancy createSectionAndGivenVacancy() {
        return new SectionAndGivenVacancy();
    }

    /**
     * Create an instance of {@link Keys }
     * 
     */
    public Keys createKeys() {
        return new Keys();
    }

    /**
     * Create an instance of {@link RTMNamedResource }
     * 
     */
    public RTMNamedResource createRTMNamedResource() {
        return new RTMNamedResource();
    }

    /**
     * Create an instance of {@link PermissionZones }
     * 
     */
    public PermissionZones createPermissionZones() {
        return new PermissionZones();
    }

    /**
     * Create an instance of {@link OpOperations }
     * 
     */
    public OpOperations createOpOperations() {
        return new OpOperations();
    }

    /**
     * Create an instance of {@link Key }
     * 
     */
    public Key createKey() {
        return new Key();
    }

    /**
     * Create an instance of {@link DestinationPoints }
     * 
     */
    public DestinationPoints createDestinationPoints() {
        return new DestinationPoints();
    }

    /**
     * Create an instance of {@link Overlaps }
     * 
     */
    public Overlaps createOverlaps() {
        return new Overlaps();
    }

    /**
     * Create an instance of {@link SignalEtcs }
     * 
     */
    public SignalEtcs createSignalEtcs() {
        return new SignalEtcs();
    }

    /**
     * Create an instance of {@link Metadata }
     * 
     */
    public Metadata createMetadata() {
        return new Metadata();
    }

    /**
     * Create an instance of {@link SignalAnnouncement }
     * 
     */
    public SignalAnnouncement createSignalAnnouncement() {
        return new SignalAnnouncement();
    }

    /**
     * Create an instance of {@link RouteReleaseGroupsAhead }
     * 
     */
    public RouteReleaseGroupsAhead createRouteReleaseGroupsAhead() {
        return new RouteReleaseGroupsAhead();
    }

    /**
     * Create an instance of {@link RTMValidity }
     * 
     */
    public RTMValidity createRTMValidity() {
        return new RTMValidity();
    }

    /**
     * Create an instance of {@link SpotProjection }
     * 
     */
    public SpotProjection createSpotProjection() {
        return new SpotProjection();
    }

    /**
     * Create an instance of {@link Infrastructure }
     * 
     */
    public Infrastructure createInfrastructure() {
        return new Infrastructure();
    }

    /**
     * Create an instance of {@link SignalsIL }
     * 
     */
    public SignalsIL createSignalsIL() {
        return new SignalsIL();
    }

    /**
     * Create an instance of {@link NetRelations }
     * 
     */
    public NetRelations createNetRelations() {
        return new NetRelations();
    }

    /**
     * Create an instance of {@link RouteRelations }
     * 
     */
    public RouteRelations createRouteRelations() {
        return new RouteRelations();
    }

    /**
     * Create an instance of {@link VehicleOperator }
     * 
     */
    public VehicleOperator createVehicleOperator() {
        return new VehicleOperator();
    }

    /**
     * Create an instance of {@link RestrictionAreas }
     * 
     */
    public RestrictionAreas createRestrictionAreas() {
        return new RestrictionAreas();
    }

    /**
     * Create an instance of {@link SignalsIS }
     * 
     */
    public SignalsIS createSignalsIS() {
        return new SignalsIS();
    }

    /**
     * Create an instance of {@link EnergyPantograph }
     * 
     */
    public EnergyPantograph createEnergyPantograph() {
        return new EnergyPantograph();
    }

    /**
     * Create an instance of {@link OverCrossings }
     * 
     */
    public OverCrossings createOverCrossings() {
        return new OverCrossings();
    }

    /**
     * Create an instance of {@link DangerPoint }
     * 
     */
    public DangerPoint createDangerPoint() {
        return new DangerPoint();
    }

    /**
     * Create an instance of {@link PhysicalFacilities }
     * 
     */
    public PhysicalFacilities createPhysicalFacilities() {
        return new PhysicalFacilities();
    }

    /**
     * Create an instance of {@link RTMCompositionNetElement }
     * 
     */
    public RTMCompositionNetElement createRTMCompositionNetElement() {
        return new RTMCompositionNetElement();
    }

    /**
     * Create an instance of {@link SignalBox }
     * 
     */
    public SignalBox createSignalBox() {
        return new SignalBox();
    }

    /**
     * Create an instance of {@link TrainRadios }
     * 
     */
    public TrainRadios createTrainRadios() {
        return new TrainRadios();
    }

    /**
     * Create an instance of {@link RTMAssociatedNetElement }
     * 
     */
    public RTMAssociatedNetElement createRTMAssociatedNetElement() {
        return new RTMAssociatedNetElement();
    }

    /**
     * Create an instance of {@link Name }
     * 
     */
    public Name createName() {
        return new Name();
    }

    /**
     * Create an instance of {@link SignalStopPost }
     * 
     */
    public SignalStopPost createSignalStopPost() {
        return new SignalStopPost();
    }

    /**
     * Create an instance of {@link Contractor }
     * 
     */
    public Contractor createContractor() {
        return new Contractor();
    }

    /**
     * Create an instance of {@link SignalInformation }
     * 
     */
    public SignalInformation createSignalInformation() {
        return new SignalInformation();
    }

    /**
     * Create an instance of {@link RTMAssociatedPositioningSystem }
     * 
     */
    public RTMAssociatedPositioningSystem createRTMAssociatedPositioningSystem() {
        return new RTMAssociatedPositioningSystem();
    }

    /**
     * Create an instance of {@link Borders }
     * 
     */
    public Borders createBorders() {
        return new Borders();
    }

    /**
     * Create an instance of {@link Route }
     * 
     */
    public Route createRoute() {
        return new Route();
    }

    /**
     * Create an instance of {@link ServiceSection }
     * 
     */
    public ServiceSection createServiceSection() {
        return new ServiceSection();
    }

    /**
     * Create an instance of {@link RTMLinearNetElement }
     * 
     */
    public RTMLinearNetElement createRTMLinearNetElement() {
        return new RTMLinearNetElement();
    }

    /**
     * Create an instance of {@link StatesBaseElement }
     * 
     */
    public StatesBaseElement createStatesBaseElement() {
        return new StatesBaseElement();
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
     * Create an instance of {@link ConflictReason }
     * 
     */
    public ConflictReason createConflictReason() {
        return new ConflictReason();
    }

    /**
     * Create an instance of {@link Border }
     * 
     */
    public Border createBorder() {
        return new Border();
    }

    /**
     * Create an instance of {@link RTMNetworkResource }
     * 
     */
    public RTMNetworkResource createRTMNetworkResource() {
        return new RTMNetworkResource();
    }

    /**
     * Create an instance of {@link DerailerAndPosition }
     * 
     */
    public DerailerAndPosition createDerailerAndPosition() {
        return new DerailerAndPosition();
    }

    /**
     * Create an instance of {@link Lines }
     * 
     */
    public Lines createLines() {
        return new Lines();
    }

    /**
     * Create an instance of {@link AspectRelation }
     * 
     */
    public AspectRelation createAspectRelation() {
        return new AspectRelation();
    }

    /**
     * Create an instance of {@link TvdSection }
     * 
     */
    public TvdSection createTvdSection() {
        return new TvdSection();
    }

    /**
     * Create an instance of {@link OpEquipment }
     * 
     */
    public OpEquipment createOpEquipment() {
        return new OpEquipment();
    }

    /**
     * Create an instance of {@link ConflictingRoute }
     * 
     */
    public ConflictingRoute createConflictingRoute() {
        return new ConflictingRoute();
    }

    /**
     * Create an instance of {@link RestrictionArea }
     * 
     */
    public RestrictionArea createRestrictionArea() {
        return new RestrictionArea();
    }

    /**
     * Create an instance of {@link TrackAsset }
     * 
     */
    public TrackAsset createTrackAsset() {
        return new TrackAsset();
    }

    /**
     * Create an instance of {@link SwitchAndPosition }
     * 
     */
    public SwitchAndPosition createSwitchAndPosition() {
        return new SwitchAndPosition();
    }

    /**
     * Create an instance of {@link LinePerformance }
     * 
     */
    public LinePerformance createLinePerformance() {
        return new LinePerformance();
    }

    /**
     * Create an instance of {@link Speeds }
     * 
     */
    public Speeds createSpeeds() {
        return new Speeds();
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
     * Create an instance of {@link NetRelation }
     * 
     */
    public NetRelation createNetRelation() {
        return new NetRelation();
    }

    /**
     * Create an instance of {@link ProjectionCoordinate }
     * 
     */
    public ProjectionCoordinate createProjectionCoordinate() {
        return new ProjectionCoordinate();
    }

    /**
     * Create an instance of {@link TrainProtectionElement }
     * 
     */
    public TrainProtectionElement createTrainProtectionElement() {
        return new TrainProtectionElement();
    }

    /**
     * Create an instance of {@link EntityIL }
     * 
     */
    public EntityIL createEntityIL() {
        return new EntityIL();
    }

    /**
     * Create an instance of {@link LineLayout }
     * 
     */
    public LineLayout createLineLayout() {
        return new LineLayout();
    }

    /**
     * Create an instance of {@link Itineraries }
     * 
     */
    public Itineraries createItineraries() {
        return new Itineraries();
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
     * Create an instance of {@link CombinedRoute }
     * 
     */
    public CombinedRoute createCombinedRoute() {
        return new CombinedRoute();
    }

    /**
     * Create an instance of {@link OverlapReleaseTimer }
     * 
     */
    public OverlapReleaseTimer createOverlapReleaseTimer() {
        return new OverlapReleaseTimer();
    }

    /**
     * Create an instance of {@link LevelCrossingsIS }
     * 
     */
    public LevelCrossingsIS createLevelCrossingsIS() {
        return new LevelCrossingsIS();
    }

    /**
     * Create an instance of {@link InterlockingInterface }
     * 
     */
    public InterlockingInterface createInterlockingInterface() {
        return new InterlockingInterface();
    }

    /**
     * Create an instance of {@link Platform }
     * 
     */
    public Platform createPlatform() {
        return new Platform();
    }

    /**
     * Create an instance of {@link LevelCrossingsIL }
     * 
     */
    public LevelCrossingsIL createLevelCrossingsIL() {
        return new LevelCrossingsIL();
    }

    /**
     * Create an instance of {@link ElementGroupingTypes }
     * 
     */
    public ElementGroupingTypes createElementGroupingTypes() {
        return new ElementGroupingTypes();
    }

    /**
     * Create an instance of {@link SignalWithAspect }
     * 
     */
    public SignalWithAspect createSignalWithAspect() {
        return new SignalWithAspect();
    }

    /**
     * Create an instance of {@link TrackGauges }
     * 
     */
    public TrackGauges createTrackGauges() {
        return new TrackGauges();
    }

    /**
     * Create an instance of {@link LinearPositioningSystems }
     * 
     */
    public LinearPositioningSystems createLinearPositioningSystems() {
        return new LinearPositioningSystems();
    }

    /**
     * Create an instance of {@link MaxTrainCurrent }
     * 
     */
    public MaxTrainCurrent createMaxTrainCurrent() {
        return new MaxTrainCurrent();
    }

    /**
     * Create an instance of {@link Network }
     * 
     */
    public Network createNetwork() {
        return new Network();
    }

    /**
     * Create an instance of {@link KeyLockInState }
     * 
     */
    public KeyLockInState createKeyLockInState() {
        return new KeyLockInState();
    }

    /**
     * Create an instance of {@link DangerPoints }
     * 
     */
    public DangerPoints createDangerPoints() {
        return new DangerPoints();
    }

    /**
     * Create an instance of {@link SpeedProfileBraking }
     * 
     */
    public SpeedProfileBraking createSpeedProfileBraking() {
        return new SpeedProfileBraking();
    }

    /**
     * Create an instance of {@link InputOutput }
     * 
     */
    public InputOutput createInputOutput() {
        return new InputOutput();
    }

    /**
     * Create an instance of {@link PowerSupplyIL }
     * 
     */
    public PowerSupplyIL createPowerSupplyIL() {
        return new PowerSupplyIL();
    }

    /**
     * Create an instance of {@link InfrastructureState }
     * 
     */
    public InfrastructureState createInfrastructureState() {
        return new InfrastructureState();
    }

    /**
     * Create an instance of {@link SignalLevelCrossing }
     * 
     */
    public SignalLevelCrossing createSignalLevelCrossing() {
        return new SignalLevelCrossing();
    }

    /**
     * Create an instance of {@link CrossingAndPosition }
     * 
     */
    public CrossingAndPosition createCrossingAndPosition() {
        return new CrossingAndPosition();
    }

    /**
     * Create an instance of {@link RTMPositioningNetElement }
     * 
     */
    public RTMPositioningNetElement createRTMPositioningNetElement() {
        return new RTMPositioningNetElement();
    }

    /**
     * Create an instance of {@link OperationalPoints }
     * 
     */
    public OperationalPoints createOperationalPoints() {
        return new OperationalPoints();
    }

    /**
     * Create an instance of {@link UnderCrossings }
     * 
     */
    public UnderCrossings createUnderCrossings() {
        return new UnderCrossings();
    }

    /**
     * Create an instance of {@link ClockTimePeriod }
     * 
     */
    public ClockTimePeriod createClockTimePeriod() {
        return new ClockTimePeriod();
    }

    /**
     * Create an instance of {@link LevelCrossingIS }
     * 
     */
    public LevelCrossingIS createLevelCrossingIS() {
        return new LevelCrossingIS();
    }

    /**
     * Create an instance of {@link InfrastructureManager }
     * 
     */
    public InfrastructureManager createInfrastructureManager() {
        return new InfrastructureManager();
    }

    /**
     * Create an instance of {@link Balise }
     * 
     */
    public Balise createBalise() {
        return new Balise();
    }

    /**
     * Create an instance of {@link TrainRadio }
     * 
     */
    public TrainRadio createTrainRadio() {
        return new TrainRadio();
    }

    /**
     * Create an instance of {@link ElementGroup }
     * 
     */
    public ElementGroup createElementGroup() {
        return new ElementGroup();
    }

    /**
     * Create an instance of {@link CombinedRoutes }
     * 
     */
    public CombinedRoutes createCombinedRoutes() {
        return new CombinedRoutes();
    }

    /**
     * Create an instance of {@link RailwayUndertaking }
     * 
     */
    public RailwayUndertaking createRailwayUndertaking() {
        return new RailwayUndertaking();
    }

    /**
     * Create an instance of {@link LevelCrossingIL }
     * 
     */
    public LevelCrossingIL createLevelCrossingIL() {
        return new LevelCrossingIL();
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
     * Create an instance of {@link SignalAndAspect }
     * 
     */
    public SignalAndAspect createSignalAndAspect() {
        return new SignalAndAspect();
    }

    /**
     * Create an instance of {@link Controller }
     * 
     */
    public Controller createController() {
        return new Controller();
    }

    /**
     * Create an instance of {@link DetectorAndGivenState }
     * 
     */
    public DetectorAndGivenState createDetectorAndGivenState() {
        return new DetectorAndGivenState();
    }

    /**
     * Create an instance of {@link GmlLocations }
     * 
     */
    public GmlLocations createGmlLocations() {
        return new GmlLocations();
    }

    /**
     * Create an instance of {@link InitStatus }
     * 
     */
    public InitStatus createInitStatus() {
        return new InitStatus();
    }

    /**
     * Create an instance of {@link GradientCurves }
     * 
     */
    public GradientCurves createGradientCurves() {
        return new GradientCurves();
    }

    /**
     * Create an instance of {@link MovableCrossings }
     * 
     */
    public MovableCrossings createMovableCrossings() {
        return new MovableCrossings();
    }

    /**
     * Create an instance of {@link OperationalPoint }
     * 
     */
    public OperationalPoint createOperationalPoint() {
        return new OperationalPoint();
    }

    /**
     * Create an instance of {@link SpeedSection }
     * 
     */
    public SpeedSection createSpeedSection() {
        return new SpeedSection();
    }

    /**
     * Create an instance of {@link EnergyRollingstock }
     * 
     */
    public EnergyRollingstock createEnergyRollingstock() {
        return new EnergyRollingstock();
    }

    /**
     * Create an instance of {@link SignalIL }
     * 
     */
    public SignalIL createSignalIL() {
        return new SignalIL();
    }

    /**
     * Create an instance of {@link ControlledAssets }
     * 
     */
    public ControlledAssets createControlledAssets() {
        return new ControlledAssets();
    }

    /**
     * Create an instance of {@link AssetsForIL }
     * 
     */
    public AssetsForIL createAssetsForIL() {
        return new AssetsForIL();
    }

    /**
     * Create an instance of {@link OverlapRelease }
     * 
     */
    public OverlapRelease createOverlapRelease() {
        return new OverlapRelease();
    }

    /**
     * Create an instance of {@link WorkZone }
     * 
     */
    public WorkZone createWorkZone() {
        return new WorkZone();
    }

    /**
     * Create an instance of {@link RouteExit }
     * 
     */
    public RouteExit createRouteExit() {
        return new RouteExit();
    }

    /**
     * Create an instance of {@link LevelCrossingDeactivator }
     * 
     */
    public LevelCrossingDeactivator createLevelCrossingDeactivator() {
        return new LevelCrossingDeactivator();
    }

    /**
     * Create an instance of {@link GeometryPoints }
     * 
     */
    public GeometryPoints createGeometryPoints() {
        return new GeometryPoints();
    }

    /**
     * Create an instance of {@link TElementWithIDandDesignator }
     * 
     */
    public TElementWithIDandDesignator createTElementWithIDandDesignator() {
        return new TElementWithIDandDesignator();
    }

    /**
     * Create an instance of {@link SignalIS }
     * 
     */
    public SignalIS createSignalIS() {
        return new SignalIS();
    }

    /**
     * Create an instance of {@link RTMNetEntity }
     * 
     */
    public RTMNetEntity createRTMNetEntity() {
        return new RTMNetEntity();
    }

    /**
     * Create an instance of {@link TrainProtectionElements }
     * 
     */
    public TrainProtectionElements createTrainProtectionElements() {
        return new TrainProtectionElements();
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
     * Create an instance of {@link OverCrossing }
     * 
     */
    public OverCrossing createOverCrossing() {
        return new OverCrossing();
    }

    /**
     * Create an instance of {@link ATPdevices }
     * 
     */
    public ATPdevices createATPdevices() {
        return new ATPdevices();
    }

    /**
     * Create an instance of {@link DerailerAndGivenPosition }
     * 
     */
    public DerailerAndGivenPosition createDerailerAndGivenPosition() {
        return new DerailerAndGivenPosition();
    }

    /**
     * Create an instance of {@link ApproachStartingDetector }
     * 
     */
    public ApproachStartingDetector createApproachStartingDetector() {
        return new ApproachStartingDetector();
    }

    /**
     * Create an instance of {@link Balises }
     * 
     */
    public Balises createBalises() {
        return new Balises();
    }

    /**
     * Create an instance of {@link GenericIMs }
     * 
     */
    public GenericIMs createGenericIMs() {
        return new GenericIMs();
    }

    /**
     * Create an instance of {@link RTMLinearLocation }
     * 
     */
    public RTMLinearLocation createRTMLinearLocation() {
        return new RTMLinearLocation();
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
     * Create an instance of {@link PhaseSeparationSection }
     * 
     */
    public PhaseSeparationSection createPhaseSeparationSection() {
        return new PhaseSeparationSection();
    }

    /**
     * Create an instance of {@link SpeedProfileTrainType }
     * 
     */
    public SpeedProfileTrainType createSpeedProfileTrainType() {
        return new SpeedProfileTrainType();
    }

    /**
     * Create an instance of {@link GenericResetStrategy }
     * 
     */
    public GenericResetStrategy createGenericResetStrategy() {
        return new GenericResetStrategy();
    }

    /**
     * Create an instance of {@link InfrastructureVisualizations }
     * 
     */
    public InfrastructureVisualizations createInfrastructureVisualizations() {
        return new InfrastructureVisualizations();
    }

    /**
     * Create an instance of {@link SystemSeparationSection }
     * 
     */
    public SystemSeparationSection createSystemSeparationSection() {
        return new SystemSeparationSection();
    }

    /**
     * Create an instance of {@link SwitchInPosition }
     * 
     */
    public SwitchInPosition createSwitchInPosition() {
        return new SwitchInPosition();
    }

    /**
     * Create an instance of {@link GenericRouteType }
     * 
     */
    public GenericRouteType createGenericRouteType() {
        return new GenericRouteType();
    }

    /**
     * Create an instance of {@link CrossingInPosition }
     * 
     */
    public CrossingInPosition createCrossingInPosition() {
        return new CrossingInPosition();
    }

    /**
     * Create an instance of {@link ElemBasedPeriodRule }
     * 
     */
    public ElemBasedPeriodRule createElemBasedPeriodRule() {
        return new ElemBasedPeriodRule();
    }

    /**
     * Create an instance of {@link SpeedProfileTilting }
     * 
     */
    public SpeedProfileTilting createSpeedProfileTilting() {
        return new SpeedProfileTilting();
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
     * Create an instance of {@link DirectPositionType }
     * 
     */
    public DirectPositionType createDirectPositionType() {
        return new DirectPositionType();
    }

    /**
     * Create an instance of {@link DirectPositionListType }
     * 
     */
    public DirectPositionListType createDirectPositionListType() {
        return new DirectPositionListType();
    }

    /**
     * Create an instance of {@link LineStringType }
     * 
     */
    public LineStringType createLineStringType() {
        return new LineStringType();
    }

    /**
     * Create an instance of {@link ReferenceType }
     * 
     */
    public ReferenceType createReferenceType() {
        return new ReferenceType();
    }

    /**
     * Create an instance of {@link StringOrRefType }
     * 
     */
    public StringOrRefType createStringOrRefType() {
        return new StringOrRefType();
    }

    /**
     * Create an instance of {@link PointType }
     * 
     */
    public PointType createPointType() {
        return new PointType();
    }

    /**
     * Create an instance of {@link CodeType }
     * 
     */
    public CodeType createCodeType() {
        return new CodeType();
    }

    /**
     * Create an instance of {@link CodeWithAuthorityType }
     * 
     */
    public CodeWithAuthorityType createCodeWithAuthorityType() {
        return new CodeWithAuthorityType();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Rollingstock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://www.railml.org/schemas/3.1", name = "Rollingstock")
    public JAXBElement<Rollingstock> createRollingstock(Rollingstock value) {
        return new JAXBElement<Rollingstock>(_Rollingstock_QNAME, Rollingstock.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Timetable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://www.railml.org/schemas/3.1", name = "Timetable")
    public JAXBElement<Timetable> createTimetable(Timetable value) {
        return new JAXBElement<Timetable>(_Timetable_QNAME, Timetable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RailML }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://www.railml.org/schemas/3.1", name = "railML")
    public JAXBElement<RailML> createRailML(RailML value) {
        return new JAXBElement<RailML>(_RailML_QNAME, RailML.class, null, value);
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
