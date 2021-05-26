package de.ibw.smart.logic.intf;

import ebd.rbc_tms.message.Message;
import ebd.internal.Payload;

public interface TmsIntf {
    void setTmsServer(RbcModul TmsServer);
    Message handleMaRequest(Message msgFromRbc);
    Message handleRegister(Message msgFromRbc);
    Message handleLogin(Message msgFromRbc);
    void handleNoError(Message msgFromRbc);

    Message handlePositionReport(Message msgFromRbc);
}
