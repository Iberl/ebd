package de.ibw.rtm.intf;

import org.railMl.rtm4rail.TElementWithIDref;
import org.railMl.rtm4rail.TNavigability;

import java.math.BigInteger;

public interface IRTMRelation {
    TElementWithIDref getElementA();

    void setElementA(TElementWithIDref value);

    TElementWithIDref getElementB();

    void setElementB(TElementWithIDref value);

    TNavigability getNavigability();

    void setNavigability(TNavigability value);

    BigInteger getPositionOnA();

    void setPositionOnA(BigInteger value);

    BigInteger getPositionOnB();

    void setPositionOnB(BigInteger value);
}
