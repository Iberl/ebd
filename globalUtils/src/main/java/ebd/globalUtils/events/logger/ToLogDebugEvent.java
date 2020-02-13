package ebd.globalUtils.events.logger;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class ToLogDebugEvent extends NormalEvent {
        public String msg;

        /**
         * Constructs an Event
         *
         * @param source  ID from the module the event was sent by
         *                TODO: Define Format for IDs
         * @param targets ID from all modules the event is adressed to
         */
        public ToLogDebugEvent(String source, List<String> targets, String msg) {
            super(source, targets);
            this.msg = msg;
        }
}
