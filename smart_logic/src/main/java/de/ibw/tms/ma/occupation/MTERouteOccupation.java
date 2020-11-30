package de.ibw.tms.ma.occupation;

import de.ibw.history.data.ComposedRoute;
import de.ibw.tms.ma.physical.MoveableTrackElement;

public class MTERouteOccupation extends Occupation {
    public static final String CLASS_IDENTIFIER = "MTE_Route_Occupation";

    private ComposedRoute composedRoute;
    private MoveableTrackElement element;


    public MTERouteOccupation(ComposedRoute CR, MoveableTrackElement MTE) {
        super(CLASS_IDENTIFIER);
        this.composedRoute = CR;
        this.element = MTE;

    }

    public MoveableTrackElement getElement() {
        return element;
    }
}
