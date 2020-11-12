package ebd.tmsDummy.command;

import com.google.gson.Gson;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.tmsDummy.NextCommandEvent;
import ebd.globalUtils.events.tmsDummy.SendMessageToRBCEvent;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.rbc_tms.message.Message_21;
import ebd.rbc_tms.payload.Payload_21;
import ebd.rbc_tms.util.MA;
import ebd.rbc_tms.util.ModeProfile;
import ebd.tmsDummy.util.exception.InvalidSequenceException;
import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

import static ebd.globalUtils.fileHandler.FileHandler.readConfigurationFile;
import static ebd.tmsDummy.util.Utils.log;

public class SendCommand implements ebd.tmsDummy.command.ICommand {

    public  String dirPath = "scenario/ma/";
    private String filepath;

    MA ma;

    public SendCommand(String filename) throws IOException, InvalidSequenceException {
        filepath = dirPath + filename;
        // read file and validate
        BufferedReader reader = new BufferedReader(readConfigurationFile(filepath));
        ma = new Gson().fromJson(reader, MA.class);
        if(ma == null) throw new InvalidSequenceException("Ma could not be read" + filepath);
        if(ma.modeProfile != null && ma.modeProfile.modes != null) {
            for(ModeProfile.Mode mode : ma.modeProfile.modes) {
                if(mode == null) throw new InvalidSequenceException("Invalid mode in " + filepath);
                if(mode.m_mamode == ETCSVariables.M_MAMODE_SHUNTING) {
                    throw new InvalidSequenceException("The MA in " + filepath + " contains EoM information. (Use EndCommand)");
                }
            }
        }
    }

    public void visit(String trainId) {
        ConfigHandler configHandler = Objects.requireNonNull(ConfigHandler.getInstance());
        Payload_21    payload_21    = new Payload_21(Integer.parseInt(trainId), ma);
        Message_21    message_21    = new Message_21(configHandler.tmsId, configHandler.rbcId, payload_21);
        EventBus.getDefault().post(new SendMessageToRBCEvent("tms", message_21));
        log(trainId + ": Sent ma from file (" + filepath + ")");
        EventBus.getDefault().post(new NextCommandEvent(trainId));
    }

}
