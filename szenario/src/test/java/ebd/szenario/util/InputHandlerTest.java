package ebd.szenario.util;

import ebd.szenario.util.handler.InputHandler;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    @Test
    public void mainTest(){
        InputHandler inputHandler = new InputHandler();
        inputHandler.join();
    }

}