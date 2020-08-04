package de.ibw.tms.trackplan.viewmodel;

import java.security.InvalidParameterException;

public class ZoomModel {

    private static ZoomModel zoomInstance = new ZoomModel();
    public static ZoomModel getInstance() {
        return zoomInstance;
    }

    //TODO Caution: temporary change of zoomlevel (Carolin)
    private double dZoomX = 0.4;
    private double dZoomY = 0.4;
    private String sInfo = "";


    public double getdZoomX() {
        return dZoomX;
    }

    public void setdZoomX(double dZoomX) throws InvalidParameterException {
        if(dZoomX > 0)
            this.dZoomX = dZoomX;
        else throw new InvalidParameterException("Zoom can not be negative");
    }

    public double getdZoomY() {
        return dZoomY;
    }

    public void setdZoomY(double dZoomY) {
        if(dZoomY > 0)
            this.dZoomY = dZoomY;
        else throw new InvalidParameterException("Zoom can not be negative");
    }

    public String getsInfo() {
        return sInfo;
    }

    public void setsInfo(String sInfo) {
        this.sInfo = sInfo;
    }
}
