package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-25
 *
 * Bestandteil des Neigungsprofil in der Datenbank der Strecke, die der Zug anfahren soll.
 * Der Gradient ist eine Neigung des Profils
 */
@Entity(name = "Gradient")
public class GradientDAO {


    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Inkrimentale !!!!!!! Distanz vom Start des gesamten Profilbandes zur naechsten Abweichung von diesem Gradienten
     */
    public int d_gradient;

    /**
     * Gibt an ob der Gradient abwaerts oder aufwaerts verlaeuft
     * false := abwaerts
     * true := aufwaerts
     */
    public boolean q_gdir;

    /**
     * Gradient in permil (Prozent / 10 =: Promille)
     * 125 / 1000 = 12,5 % oder 125 Promil
     */
    public int g_a;


}
