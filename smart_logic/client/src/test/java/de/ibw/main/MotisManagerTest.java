package de.ibw.main;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class MotisManagerTest {

    @Test
    void sendMotisFiles() {
        try {
            MotisManager.sendMotisFiles();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}