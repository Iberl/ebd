package ebd.tmsDummy;

import ebd.rbc_tms.util.exception.MissingInformationException;
import ebd.tmsDummy.util.exception.InvalidSequenceException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws MissingInformationException, IOException, InvalidSequenceException {
        Szenario szenario = new Szenario();
        szenario.run(args);
    }

}
