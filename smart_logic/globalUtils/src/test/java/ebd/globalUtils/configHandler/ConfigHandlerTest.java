package ebd.globalUtils.configHandler;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConfigHandlerTest {

    @Test
    void getInstance() {

        ConfigHandler configHandler = ConfigHandler.getInstance();
        assertNotNull(configHandler);

    }

    @Test
    void checkLoadedValues() throws IOException, IllegalAccessException {

        ConfigHandler configHandler = ConfigHandler.getInstance();
        for (Field field : configHandler.getClass().getFields()){
            System.out.println("Name: " + field.getName() + " Value: " + field.get(configHandler));
        }
    }
}