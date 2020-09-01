package de.ibw.tms.trackplan.viewmodel;

import java.security.InvalidParameterException;
/**
 * Dieses Model verwaltet den Zoom innerhalb der Streckenansicht.
 *
 *
 * @author Carolin
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.3
 * @since 2020-08-12
 */
public class ZoomModel {

    private static ZoomModel zoomInstance = new ZoomModel();

    /**
     * Singleton gibt aktuelles Zoom Model wider
     * @return ZoomModel
     */
    public static ZoomModel getInstance() {
        return zoomInstance;
    }

    //TODO Caution: temporary change of zoomlevel (Carolin)
    private double dZoomX = 0.4;
    private double dZoomY = 0.4;
    private String sInfo = "";

    /**
     * Gibt den Zoomfaktor in x-Richtung wider
     * @return double - X-Zoom
     */
    public double getdZoomX() {
        return dZoomX;
    }

    /**
     * setzt den Zoom in x-Richtung
     * @param dZoomX double - neuer x-Zoom
     * @throws InvalidParameterException - falls negativ
     */
    public void setdZoomX(double dZoomX) throws InvalidParameterException {
        if(dZoomX > 0)
            this.dZoomX = dZoomX;
        else throw new InvalidParameterException("Zoom can not be negative");
    }
    /**
     * Gibt den Zoomfaktor in y-Richtung wider
     * @return double - Y-Zoom
     */
    public double getdZoomY() {
        return dZoomY;
    }
    /**
     * setzt den Zoom in Y-Richtung
     * @param dZoomY double - neuer y-Zoom
     * @throws InvalidParameterException - falls negativ
     */
    public void setdZoomY(double dZoomY) {
        if(dZoomY > 0)
            this.dZoomY = dZoomY;
        else throw new InvalidParameterException("Zoom can not be negative");
    }

    /**
     * Status Nachricht, falls Nutzerfehler enstanden
     * @return String - Nachricht
     */
    public String getsInfo() {
        return sInfo;
    }

    /**
     * Setzt Nachricht bei Fehler
     * @param sInfo {@link String} Fehlernachrict
     */
    public void setsInfo(String sInfo) {
        this.sInfo = sInfo;
    }
}
