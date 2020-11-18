package ebd.tmsDummy;

import ebd.tmsDummy.command.*;
import ebd.tmsDummy.util.exception.InvalidSequenceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

import static ebd.globalUtils.fileHandler.FileHandler.readConfigurationFile;
import static ebd.tmsDummy.util.Utils.log;

public class Parser {

    public static  String                       dirPath = "scenario/";
    private static String                       filepath;
    private static Map<String, Queue<ICommand>> sequences;

    public static Map<String, Queue<ICommand>> parse(String filename) throws InvalidSequenceException, IOException {
        Parser.filepath = dirPath + filename;

        BufferedReader reader = new BufferedReader(readConfigurationFile(filepath));
        String[]       lines  = reader.lines().toArray(String[]::new);

        sequences = new HashMap<>();

        for(int i = 0; i < lines.length; i++) {
            String   line       = lines[i];
            if(line.isEmpty() || line.isBlank() || line.contains("#")) continue;
            String[] substrings = line.split("\\s+");
            try {
                Integer.parseInt(substrings[0]);
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException("The first command parameter must be an integer");
            }
            String trainId = substrings[0];
            switch(substrings[1]) {
                case "send":
                    if(substrings.length != 3) throw new IllegalArgumentException("Illegal number of command parameters in line " + (i + 1));
                    addCommand(trainId, new SendCommand(substrings[2]));
                    break;
                case "sleep":
                    if(substrings.length != 3) throw new IllegalArgumentException("Illegal number of command parameters in line " + (i + 1));
                    addCommand(trainId, new SleepCommand(Integer.parseInt(substrings[2])));
                    break;
                case "wait":
                    if(substrings.length != 2) throw new IllegalArgumentException("Illegal number of command parameters in line " + (i + 1));
                    addCommand(trainId, new WaitCommand());
                    break;
                case "end":
                    if(substrings.length != 3) throw new IllegalArgumentException("Illegal number of command parameters in line " + (i + 1));
                    addCommand(trainId, new EndCommand(trainId, substrings[2]));
                    break;
            }
        }


        for(String trainId : sequences.keySet()) {
            log("Read seqence for train " + trainId);
        }
        validate(sequences);
        log("Sequences validated");

        return sequences;
    }

    private static void addCommand(String trainId, ICommand command) {
        Queue<ICommand> queue = new LinkedList<>();
        if(sequences.containsKey(trainId)) queue = sequences.get(trainId);
        queue.add(command);
        sequences.put(trainId, queue);
    }

    private static boolean validate(Map<String, Queue<ICommand>> sequences) throws InvalidSequenceException {
        if(sequences == null || sequences.isEmpty()) throw new InvalidSequenceException("No sequence specified in file (" + filepath + ")");
        for(String trainId : sequences.keySet()) {
            if(!validate(trainId, sequences.get(trainId))) return false;
        }
        return true;
    }

    private static boolean validate(String trainId, Queue<ICommand> sequence) throws InvalidSequenceException {
        if(sequence == null || sequence.isEmpty()) {
            throw new InvalidSequenceException("The command for train " + trainId + " sequence is empty");
        }
        ICommand[] commandArr = (ICommand[]) sequence.toArray(new ICommand[] {});
        for(Iterator<ICommand> iterator = sequence.iterator(); iterator.hasNext(); ) {
            ICommand command = iterator.next();
            if(iterator.hasNext() && command instanceof EndCommand) {
                throw new InvalidSequenceException("The sequence for train " + trainId + " has commands after an end command");
            }
        }
        return true;
    }

}
