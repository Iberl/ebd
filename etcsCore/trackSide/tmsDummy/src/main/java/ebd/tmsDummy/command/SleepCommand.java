package ebd.tmsDummy.command;

import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.events.tmsDummy.NextCommandEvent;
import org.greenrobot.eventbus.EventBus;

import static ebd.tmsDummy.util.Utils.log;

public class SleepCommand implements ebd.tmsDummy.command.ICommand {

    private Integer seconds;

    public SleepCommand(int seconds) {
        this.seconds = seconds;
    }

    public void visit(String trainId) {
        if(seconds % 5 != 0) log(trainId + ": Sleeping " + seconds);
        for(; seconds > 0; seconds--) {
            if(seconds % 5 == 0) log(trainId + ": Sleeping " + seconds);
            try {
                AppTime.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        EventBus.getDefault().post(new NextCommandEvent(trainId));
    }
}
