package de.ibw.smart.logic.intf;

import de.ibw.tms.ma.RbcMA;

@Deprecated
public class SendMaEbdImpl {

    private static SendMaClient MaClient = new SendMaClient();
    private static RbcMA MovementAuthority = null;

    public static void main(String[] args) {
        
        if (args.length == 2) {
            MaClient.sIp = args[0];
            MaClient.iPort = Integer.getInteger(args[1]);

        }
        EbdAuthorities.generateEbdMa();
        MovementAuthority = EbdAuthorities.EbdMa;
        try {
            MaClient.worker(MovementAuthority);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
