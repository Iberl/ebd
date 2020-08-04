package de.ibw.tms.controller;

public class TmsController {

    private static TmsController instance;

    public static TmsController getInstance() {
        if(instance == null) {
            instance = new TmsController();
        }
        return instance;
    }

}
