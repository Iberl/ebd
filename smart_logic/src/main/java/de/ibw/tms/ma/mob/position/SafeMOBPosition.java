package de.ibw.tms.ma.mob.position;

import de.ibw.tms.ma.occupation.Occupation;
import de.ibw.tms.ma.occupation.VehicleOccupation;
import de.ibw.tms.ma.positioned.elements.train.MinSafeFrontEnd;
import de.ibw.tms.ma.positioned.elements.train.MinSafeRearEnd;
import de.ibw.tms.ma.positioned.elements.train.TrainPositionSpots;

import java.security.InvalidParameterException;

public class SafeMOBPosition extends MOBPositionClasses {
    public static final String CLASS_IDENTIFIER = "Safe_MOB_Position";

    private VehicleOccupation Occupation;

    public SafeMOBPosition(VehicleOccupation O) {
        super(CLASS_IDENTIFIER);
        this.Occupation = O;
    }



    @Override
    public void setBegin(TrainPositionSpots begin) {
        if(!begin.getName().equals(MinSafeRearEnd.CLASS_IDENTIFIER)) {
            throw new InvalidParameterException("Begin has to be of Type MinSafeRearEnd");
        }
        super.setBegin(begin);
    }

    @Override
    public void setEnd(TrainPositionSpots end) {
        if(!end.getName().equals(MinSafeFrontEnd.CLASS_IDENTIFIER)) {
            throw new InvalidParameterException("End has to be of Type MinSafeFrontEnd");
        }
        super.setEnd(end);
    }
}
