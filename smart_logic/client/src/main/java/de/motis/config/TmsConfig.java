package de.motis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TmsConfig {


    @Value("${ipToSmartLogic4TMS}")
    private String ipToSmartLogic4TMS;

    @Value("${portOfSmartLogic4TMS}")
    private String portOfSmartLogic4TMS;

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
