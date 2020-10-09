package de.ibw.smart.logic.intf;

import ebd.rbc_tms.Message;
import ebd.rbc_tms.Payload;

public interface TmsIntf {
    void setTmsServer(RbcModul TmsServer);
    Message handleMaRequest(Message<Payload> msgFromRbc);
    Message handleRegister(Message<Payload> msgFromRbc);
    Message handleLogin(Message<Payload> msgFromRbc);
    void handleNoError(Message<Payload> msgFromRbc);

    Message handlePositionReport(Message<Payload> msgFromRbc);
}
