package de.ibw.tms.speed.profile.model;

import de.ibw.tms.ma.SSP;
/**
 * Model eines Speed Profils
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class CartesianSpeedModel {
    private SSP StaticSpeedProfile;

    /**
     * Gibt Speed Profil wider
     * @return SSP - Statisches Geschwindigkeitsprofil
     */
    public SSP getStaticSpeedProfile() {
        return StaticSpeedProfile;
    }

    /**
     * Setzt ein neues Statisches Geschwindigkeitsprofil
     * @param staticSpeedProfile - SSP - Profil
     */
    public void setStaticSpeedProfile(SSP staticSpeedProfile) {
        StaticSpeedProfile = staticSpeedProfile;


    }
}
