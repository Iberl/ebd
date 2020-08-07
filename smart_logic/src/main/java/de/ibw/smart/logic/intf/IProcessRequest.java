package de.ibw.smart.logic.intf;

/**
 * Inzwischen nicht mehr verwendet deswegen nicht weiter dokumentiert.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-07
 */
public interface IProcessRequest<Request, Response> {
    Response processRequest(Request Req);
}
