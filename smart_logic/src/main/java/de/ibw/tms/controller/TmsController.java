package de.ibw.tms.controller;

/**
 * Noch nicht implementiert
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class TmsController {

    private static TmsController instance;

    public static TmsController getInstance() {
        if(instance == null) {
            instance = new TmsController();
        }
        return instance;
    }

}
