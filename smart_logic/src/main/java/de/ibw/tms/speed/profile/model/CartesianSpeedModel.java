package de.ibw.tms.speed.profile.model;

import de.ibw.tms.ma.SSP;

public class CartesianSpeedModel {
    private SSP StaticSpeedProfile;

    public SSP getStaticSpeedProfile() {
        return StaticSpeedProfile;
    }

    public void setStaticSpeedProfile(SSP staticSpeedProfile) {
        StaticSpeedProfile = staticSpeedProfile;


    }
}
