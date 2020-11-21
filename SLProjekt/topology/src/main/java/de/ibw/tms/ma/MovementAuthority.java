package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class MovementAuthority implements Serializable {
        @Expose
        public EoA endOfAuthority;
        @Expose
        public SvL superviesedLocation;
        @Expose
        public SSP speedProfile;
        private GradientProfile gradientProfile;
        private TrainMovement trainMovement;

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
