package de.motis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-28
 *
 *  Diese Klasse verwaltet die Verbindungdaten zum Server. Der Server befindet sich in der smartLogic und wartet auf
 *  Anfragen
 */
@Component
@ConfigurationProperties("tms.config")
public class TmsConfig {



    private String ipToSmartLogic4TMS;


    private String portOfSmartLogic4TMS;

    public TmsConfig() {
    }

    public String getIpToSmartLogic4TMS() {
        return ipToSmartLogic4TMS;
    }

    public void setIpToSmartLogic4TMS(String ipToSmartLogic4TMS) {
        this.ipToSmartLogic4TMS = ipToSmartLogic4TMS;
    }

    public String getPortOfSmartLogic4TMS() {
        return portOfSmartLogic4TMS;
    }

    public void setPortOfSmartLogic4TMS(String portOfSmartLogic4TMS) {
        this.portOfSmartLogic4TMS = portOfSmartLogic4TMS;
    }


}
