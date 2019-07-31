package ebd.drivingDynamics.util;

import java.util.List;

public class OrBlock extends ConditionBlock {

    private List<AndBlock> andBlocks;

    public OrBlock(){
    }
    
    @Override
    public boolean eval() {
        return false;
    }
}
