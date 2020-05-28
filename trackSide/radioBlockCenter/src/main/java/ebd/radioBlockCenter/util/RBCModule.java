package ebd.radioBlockCenter.util;

import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.logger.ToLogDebugEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import org.greenrobot.eventbus.EventBus;

public abstract class RBCModule {

    private EventBus _localBus;

    private int _rbcID;
    private String _rbcIDString;
    private String _moduleID;

    public RBCModule(EventBus _localBus, int _rbcID, String _moduleID) {
        this._localBus = _localBus;
        this._rbcID = _rbcID;
        this._rbcIDString = String.valueOf(_rbcID);
        this._moduleID = _moduleID;
    }

    private void log(String msg) {
        _localBus.post(new ToLogEvent(_moduleID, "log", msg));
    }

    private void log(Exception e) {
        _localBus.post(new ExceptionEvent(_moduleID, "log", new NotCausedByAEvent(), e));
    }

    private void logDebug(String msg) {
        _localBus.post(new ToLogDebugEvent(_moduleID, "log", msg));
    }

}
