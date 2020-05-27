package ebd.globalUtils.events.logger;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class ToLogDebugEvent extends NormalEvent {
        public String msg;

        /**
         * Constructs an Event
         *
         * @param source  ID from the module the event was sent by
         *
         * @param target ID from from the target module or "all" if more then one target should be reached.
         */
        public ToLogDebugEvent(String source, String target, String msg) {
            super(source, target);
            this.msg = msg;
        }
}
