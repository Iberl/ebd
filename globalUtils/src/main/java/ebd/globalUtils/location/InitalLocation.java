package ebd.globalUtils.location;

/**
 * This is a special {@link Location} that is used as the first location after initialisation
 * of the train, when the actual position of the train is still unknown.
 */
public class InitalLocation extends Location {

    /**
     * This is a special {@link Location} that is used as the first location after initialisation
     * of the train, when the actual position of the train is still unknown.
     */
    public InitalLocation() {
        super("initLoc", null, null);
    }
}
