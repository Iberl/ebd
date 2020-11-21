package de.ibw.tms.ma.physical;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.net.elements.PositionedRelation;
import de.ibw.tms.plan.elements.BranchingSwitch;

import java.util.concurrent.TimeUnit;

public class Point_RemoteOperated extends Point {
    private PointState state;
    private PointOperationMode operationMode;
    private BranchingSwitch.SwitchStatus status;
    private Sollage sollagePosition;
    private PositionedRelation RightPosition = null;
    private PositionedRelation LeftPosition = null;



    public PositionedRelation getRightPosition() {
        return RightPosition;
    }

    public void setRightPosition(PositionedRelation rightPosition) {
        RightPosition = rightPosition;
    }

    public PositionedRelation getLeftPosition() {
        return LeftPosition;
    }

    public void setLeftPosition(PositionedRelation leftPosition) {
        LeftPosition = leftPosition;
    }

    public Point_RemoteOperated(Chainage C, PositionedRelation OutputRelation) {
        super(OutputRelation);
        //this.setChainageBeginn(C);
        //this.setChainageEnd(C);
        this.state = PointState.WAIT_ON_COMMAND;
        this.operationMode = PointOperationMode.NORMAL;
        this.status = BranchingSwitch.SwitchStatus.RIGHT;
        this.sollagePosition = Sollage.RIGHT;
    }




    public void swing(Sollage sollagePosition) {
        if(this.sollagePosition == sollagePosition) return;
        else {
            this.status = BranchingSwitch.SwitchStatus.BUSY;
            try {
                TimeUnit.SECONDS.sleep(this.getOperationTime());
            } catch (InterruptedException e) {
                this.status = BranchingSwitch.SwitchStatus.RIGHT;
                this.setTurnoutNeighbour(this.getRightPosition());
            }
            this.sollagePosition = sollagePosition;
            if(Sollage.RIGHT == this.sollagePosition) {
                this.status = BranchingSwitch.SwitchStatus.RIGHT;
                this.setTurnoutNeighbour(this.getRightPosition());
            } else {
                this.status = BranchingSwitch.SwitchStatus.LEFT;
                this.setTurnoutNeighbour(this.getLeftPosition());
            }

        }
    }
    public void lock() {
        //TODO
        System.out.println("Sperre implemntieren");
    }

    public void unlock() {
        //TODO
        System.out.println("Sperre aufheben implementieren");
    }


    public PointState getState() {
        return state;
    }

    public PointOperationMode getOperationMode() {
        return operationMode;
    }

    public BranchingSwitch.SwitchStatus getCrossoverStatus() {
        return status;
    }

    public void setState(PointState state) {
        this.state = state;
    }

    public void setOperationMode(PointOperationMode operationMode) {
        this.operationMode = operationMode;
    }

    public void setStatus(BranchingSwitch.SwitchStatus status) {
        this.status = status;
    }

    public Sollage getSollagePosition() {
        return sollagePosition;
    }

    public void setSollagePosition(Sollage sollagePosition) {
        this.sollagePosition = sollagePosition;
    }
}

