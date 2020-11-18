package ebd.baliseTelegramGenerator;

import ebd.messageLibrary.message.Telegram;

import java.util.HashMap;
import java.util.Map;

import static ebd.messageLibrary.util.ETCSVariables.M_VERSION_2_0;
import static ebd.messageLibrary.util.ETCSVariables.Q_MEDIA_BALISE;

public class BaliseTelegramCreator {

    protected static Map<String, Telegram[]> createTelegramsForBaliseGroup(int nid_c, int nid_bg, int n_total, int type) {
        Map<String, Telegram[]> telegramMap = new HashMap<>();

        // TODO [ ] Support multiple balises

        Telegram[][] telegrams = new Telegram[n_total][1];

        switch(type) {
            case 20:
                telegrams = createTelegram20(nid_c, nid_bg, n_total);
                break;
            case 21:
                telegrams = createTelegram21(nid_c, nid_bg, n_total);
                break;
            case 23:
                telegrams = createTelegram23(nid_c, nid_bg, n_total);
                break;
            case 24:
                telegrams = createTelegram24(nid_c, nid_bg, n_total);
                break;
            case 25:
                telegrams = createTelegram25(nid_c, nid_bg, n_total);
                break;
            default:
                // TODO Error: not supported type
                break;
        }

        for(int i = 1; i <= n_total; i++) {
            telegramMap.put(nid_c + "-" + nid_bg + "-" + i, telegrams[i - 1]);
        }

        return telegramMap;
    }


    private static Telegram[][] createTelegram20(int nid_c, int nid_bg, int n_total) {
        // TODO support type 20
        Telegram[][] telegrams = new Telegram[n_total][1];
        return telegrams;
    }

    private static Telegram[][] createTelegram21(int nid_c, int nid_bg, int n_total) {
        // TODO support type 21
        Telegram[][] telegrams = new Telegram[n_total][1];
        return telegrams;
    }

    private static Telegram[][] createTelegram23(int nid_c, int nid_bg, int n_total) {
        // TODO support type 23
        Telegram[][] telegrams = new Telegram[n_total][1];
        return telegrams;
    }

    private static Telegram[][] createTelegram24(int nid_c, int nid_bg, int n_total) {
        // TODO support type 24
        Telegram[][] telegrams = new Telegram[n_total][1];
        return telegrams;
    }

    private static Telegram[][] createTelegram25(int nid_c, int nid_bg, int n_total) {
        // TODO support type 25
        Telegram[][] telegrams = new Telegram[n_total][1];
        return telegrams;
    }

    private static Telegram createEmptyTelegram(int nid_c, int nid_bg, int n_pig, int n_total) {
        Telegram telegram = new Telegram();
        telegram.M_VERSION = M_VERSION_2_0;
        telegram.Q_MEDIA   = Q_MEDIA_BALISE;
        telegram.N_PIG     = n_pig;
        telegram.N_TOTAL   = n_total;
        telegram.NID_C     = nid_c;
        telegram.NID_BG    = nid_bg;
        return telegram;
    }

}
