package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import de.ibw.history.data.ComposedRoute;
import de.ibw.smart.logic.exceptions.SmartLogicException;
import de.ibw.tms.etcs.ETCS_DISTANCE;
import de.ibw.tms.etcs.ETCS_SPEED;
import de.ibw.tms.etcs.NC_CDDIFF;
import de.ibw.tms.ma.flanking.FlankArea;
import de.ibw.tms.ma.occupation.MAOccupation;
import ebd.rbc_tms.util.SpeedProfile;

import java.io.Serializable;
import java.util.List;

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


        public MovementAuthority() {
        }

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
                                        boolean q_front = S.q_front;
                                        if(S == null) throw new SmartLogicException("Section must not be null in sectionlist");
                                        ETCS_SPEED v_Static = new ETCS_SPEED();
                                        ETCS_DISTANCE d_Static = new ETCS_DISTANCE();
                                        NC_CDDIFF nc_cddiff = new NC_CDDIFF();
                                        // categories
                                        v_Static.bSpeed = (byte) S.v_static;

                                        SpeedSegment tmsSegment = new SpeedSegment();
                                        tmsSegment.setCategories(S.categories);
                                        d_Static.sDistance = (short) S.d_static;
                                        S.

                                }
                                ssp.setMovementAuthority(this);
                        }
                }


        }

        public GradientProfile getGradientProfile() {
                return gradientProfile;
        }

        public void setGradientProfile(GradientProfile gradientProfile) {
                // nicht auskommentieren am Donnerstag
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
