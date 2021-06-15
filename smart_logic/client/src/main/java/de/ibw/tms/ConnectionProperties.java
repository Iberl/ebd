package de.ibw.tms;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.awt.*;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

/**
* Connection Properties (Retry Zeit)
* @author iberl@verkehr.tu-darmstadt.de
* @version 1.1
* @since 2021-05-21
*/
@ConfigurationProperties("connection")
public class ConnectionProperties {



    private int retry_time = 7;

    public ConnectionProperties() {

    }

    public int getRetry_time() {
        return retry_time;
    }

    public void setRetry_time(int retry_time) {
        this.retry_time = retry_time;
    }
}
