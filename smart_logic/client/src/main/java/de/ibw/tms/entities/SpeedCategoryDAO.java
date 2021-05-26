package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-26
 *
 *
 *
 */
@Entity(name = "SpeedCategory")
public class SpeedCategoryDAO {

    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Bestimmt spezifische Kategorie (Cant Deficiency)
     *
     * 0 := Cant Deficiency specific category
     * 1 := Other specific category, replaces the Cant Deficiency SSP
     * 2 := Other specific category, does not replace the Cant Deficiency SSP
     * 3 := Spare
     */
    public int q_diff;

    /**
     * Kategorie des Cant Deficiencies Geschwindigkeitsprofils
     *
     * 0 := Specific SSP applicable to Cant Deficiency 80 mm
     * 1 := Specific SSP applicable to Cant Deficiency 100 mm
     * 2 := Specific SSP applicable to Cant Deficiency 130 mm
     * 3 := Specific SSP applicable to Cant Deficiency 150 mm
     * 4 := Specific SSP applicable to Cant Deficiency 165 mm
     * 5 := Specific SSP applicable to Cant Deficiency 180 mm
     * 6 := Specific SSP applicable to Cant Deficiency 210 mm
     * 7 := Specific SSP applicable to Cant Deficiency 225 mm
     * 8 := Specific SSP applicable to Cant Deficiency 245 mm
     * 9 := Specific SSP applicable to Cant Deficiency 275 mm
     * 10 := Specific SSP applicable to Cant Deficiency 300 mm
     * 11 - 15 Spare
     *
     */
    public int nc_cddiff;
    /**
     * Andere spezifische Geschwindigkeitscategorien
     *
     * 0 Specific SSP applicable to Freight train braked in “P” position
     * 1 Specific SSP applicable to Freight train braked in “G” position
     * 2 Specific SSP applicable to Passenger train
     * 3-15 Spare
     */
    public int nc_diff;

    /**
     * Absolute Geschwindigkeit dieser Zug-Kategorie (Einheit 5 km/h)
     * 10 := 50 km/h
     *
     * 121-127 := Spare
     *
     */
    public int v_diff;


}



