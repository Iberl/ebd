package de.ibw.tms;

import ch.qos.logback.core.util.COWArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.security.InvalidParameterException;
import java.util.*;
import java.util.List;

/**
* Color of ETCS Trains index of list is etcs number
* @author iberl@verkehr.tu-darmstadt.de
* @version 1.1
* @since 2021-05-21
*/
@ConfigurationProperties("traincolor")
public class ColorProperties {



    private final Map<String, String> map = new HashMap<>();

    public ColorProperties() {

    }

    public Map<String, String> getMap() {
        return map;
    }


    public Color getColorForEtcsString(String etcsId) throws InvalidParameterException {
        String colorStr = map.get("train" + etcsId);
        if(colorStr == null) throw new InvalidParameterException("ETCS ID " + etcsId + " no color found.");
        return new Color(
                Integer.valueOf(colorStr.substring(0, 2), 16),
                Integer.valueOf(colorStr.substring(2, 4), 16),
                Integer.valueOf(colorStr.substring(4, 6), 16));

    }

}
