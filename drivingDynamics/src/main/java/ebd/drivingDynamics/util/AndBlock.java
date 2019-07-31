package ebd.drivingDynamics.util;

import java.util.List;

public class AndBlock extends ConditionBlock {

    private List<Condition> conditions;

    @Override
    public boolean eval() {
        return false;
    }
}
