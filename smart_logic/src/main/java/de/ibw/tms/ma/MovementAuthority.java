package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import de.ibw.history.data.ComposedRoute;
import de.ibw.smart.logic.exceptions.SmartLogicException;
import de.ibw.tms.etcs.ETCS_DISTANCE;
import de.ibw.tms.etcs.ETCS_SPEED;
import de.ibw.tms.etcs.NC_CDDIFF;
import de.ibw.tms.ma.flanking.FlankArea;
import de.ibw.tms.ma.mob.MovableObject;
import de.ibw.tms.ma.occupation.MAOccupation;
import ebd.internal.util.SpeedProfile;

import java.io.Serializable;
import java.util.List;

/**
 * Die MA ist eine Modellklasse für MovementAuthorities im ETCS-System.
 * Der Inhalt von MA-Objekten werden auch an das RBC &uuml;betrtragen
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.5
 * @since 2021-03-04
 */
public class MovementAuthority implements Serializable {
        @Expose
        public EoA endOfAuthority;
        @Expose
        public SvL superviesedLocation;
        @Expose
        public SSP speedProfile;
        private GradientProfile gradientProfile;
        private TrainMovement trainMovement;

        private List<MASection> sections;
        private AxleLoadSpeedProfile AxleLoadProfile;
        private ModeChangeProfile ModeChanges;
        private RouteSuitabilityData RS;
        private List<MAOccupation> maOccupationList;
        private FlankArea FlArea;

        private ComposedRoute RouteOfMa;
        private MovableObject MOB;

        /**
         * Default Constructor wird gebraucht und sollte vorhanden bleiben
         */
        public MovementAuthority() {
        }

        /**
         * @deprecated
         * @param endOfAuthority
         * @param superviesedLocation
         * @param speedProfile
         * @param gradientProfile
         * @param sections
         * @param axleLoadProfile
         * @param modeChanges
         * @param RS
         * @param maOccupationList
         * @param flArea
         */
        public MovementAuthority(EoA endOfAuthority, SvL superviesedLocation, SSP speedProfile,
                                 GradientProfile gradientProfile, List<MASection> sections,
                                 AxleLoadSpeedProfile axleLoadProfile, ModeChangeProfile modeChanges,
                                 RouteSuitabilityData RS, List<MAOccupation> maOccupationList, FlankArea flArea) {
                this.endOfAuthority = endOfAuthority;
                this.superviesedLocation = superviesedLocation;
                this.speedProfile = speedProfile;
                this.gradientProfile = gradientProfile;
                this.sections = sections;
                AxleLoadProfile = axleLoadProfile;
                ModeChanges = modeChanges;
                this.RS = RS;
                this.maOccupationList = maOccupationList;
                FlArea = flArea;
        }

        public ComposedRoute getRouteOfMa() {
                return RouteOfMa;
        }

        public void setRouteOfMa(ComposedRoute routeOfMa) {
                RouteOfMa = routeOfMa;
        }

        public EoA getEndOfAuthority() {
                return endOfAuthority;
        }

        public void setEndOfAuthority(EoA endOfAuthority) {
                this.endOfAuthority = endOfAuthority;
        }

        public SvL getSuperviesedLocation() {
                return superviesedLocation;
        }

        public void setSuperviesedLocation(SvL superviesedLocation) {
                this.superviesedLocation = superviesedLocation;
        }

        public SSP getSpeedProfile() {
                return speedProfile;
        }

        public MovableObject getMOB() {
                return MOB;
        }

        public void setMOB(MovableObject MOB) {
                this.MOB = MOB;
        }

        /**
         * set speedProfile with TMS SSP
         * @param speedProfile
         */
        public void setSpeedProfile(SSP speedProfile) {
                this.speedProfile = speedProfile;
        }

        /**
         * set speedProfile with RBC SSP
         * @param speedProfile
         */
        public void setSpeedProfile(SpeedProfile speedProfile) throws SmartLogicException {
                SSP ssp = speedProfile == null ? null : new SSP();
                if(ssp != null) {
                        List<SpeedProfile.Section> sections = speedProfile.sections;
                        if(sections == null || sections.isEmpty()) {
                                ssp = null;
                        } else {
                                for(SpeedProfile.Section S :sections) {
                                        if(S == null) throw new SmartLogicException("Section must not be null in sectionlist");
                                        boolean q_front = S.q_front;

                                        ETCS_SPEED v_Static = new ETCS_SPEED();
                                        ETCS_DISTANCE d_Static = new ETCS_DISTANCE();
                                        NC_CDDIFF nc_cddiff = new NC_CDDIFF();
                                        // categories
                                        v_Static.bSpeed = (byte) S.v_static;

                                        SpeedSegment tmsSegment = new SpeedSegment();
                                        tmsSegment.setCategories(S.categories);
                                        d_Static.sDistance = (short) S.d_static;
                                        tmsSegment.setV_STATIC(v_Static);

                                        //this.getRouteOfMa().createSubRoute()


                                }
                                ssp.setMovementAuthority(this);
                        }
                }


        }

        public GradientProfile getGradientProfile() {
                return gradientProfile;
        }

        public void setGradientProfile(GradientProfile gradientProfile) {

                this.gradientProfile = gradientProfile;
        }



        public TrainMovement getTrainMovement() {
                return trainMovement;
        }

        public void setTrainMovement(TrainMovement trainMovement) {
                this.trainMovement = trainMovement;
        }

        @Override
        public String toString() {
                return "MovementAuthority{" +
                        "endOfAuthority=" + endOfAuthority +
                        ", superviesedLocation=" + superviesedLocation +
                        ", speedProfile=" + speedProfile +
                        '}';
        }


}
