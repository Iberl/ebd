package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.flanking.FlankArea;
import de.ibw.tms.ma.occupation.MAOccupation;

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

        public void setSpeedProfile(SSP speedProfile) {
                this.speedProfile = speedProfile;
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
