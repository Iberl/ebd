package de.ibw.tms.ma.physical;

import de.ibw.tms.ma.Chainage;
import org.junit.jupiter.api.Test;

import java.nio.channels.Channel;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DoubleSlipTest {

    DoubleSlip DSNull = new DoubleSlip(null);
    DoubleSlip DSB =  new DoubleSlip(new Chainage(0));
    DoubleSlip DSC = new DoubleSlip(new Chainage(1000));


    @Test
    void updatePositionedRelation() {
        Integer I = new Random().nextInt();
        if(I< 0) {
            I = I * -1;
        }
        DoubleSlip DsRandom = new DoubleSlip(new Chainage(I));
        //DsRandom.

    }

    @Test
    void setOutputRelation() {
    }

    @Test
    void getViewName() {
    }
}