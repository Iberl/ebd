package de.ibw.tms.ui.route.model;

import de.ibw.tms.intf.TmsMessage;

public interface IsmartlocicSender {
    void sendMessageTosmartLogic(TmsMessage requestMessage);
}
