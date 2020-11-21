package de.ibw.util;
/**
 * Diese Klasse verwaltet Positionen als Double
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.3
 * @since 2020-08-12
 */
public class DoubleCoord implements ICoord<Double> {

    private Double x;
    private Double y;

    /**
     * Holt X-coord
     * @return double
     */

    @Override
    public Double getX() {
        return x;
    }

    /**
     * Setzt X-coordinate
     * @param x double
     */
    @Override
    public void setX(Double x) {
        this.x = x;
    }

    /**
     * Holt Y-coord
     * @return double
     */

    @Override
    public Double getY() {
        return y;
    }

    /**
     * Setzt Y-coordinate
     * @param y double
     */

    @Override
    public void setY(Double y) {
        this.y = y;
    }
}
