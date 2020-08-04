package de.ibw.smart.logic.intf;

public interface IProcessRequest<Request, Response> {
    Response processRequest(Request Req);
}
