package ebd.baliseTelegramGenerator;

import ebd.globalUtils.location.Location;
import ebd.messageLibrary.message.Telegram;
import ebd.messageLibrary.packet.trackpackets.Packet_5;
import ebd.messageLibrary.util.ETCSVariables;

import static ebd.messageLibrary.util.ETCSVariables.*;

public class BaliseGroup {

    int baliseGroupId;

    int version = M_VERSION;

    int country = NID_C;

    boolean linked = Q_LINK;

    private Balise[] balises = new Balise[8];
    private int numberOfBalises = 0;

    private Packet_5 linkingInformation;

    //TODO: Implement missing Packets!!!
    //private Packet_79 geographicPosition;


    // Constructors

    public BaliseGroup(int NID_BG, int M_VERSION, int NID_C, boolean Q_LINK, Packet_5 linkingInformation) {
        this.baliseGroupId = NID_BG;
        this.version = M_VERSION;
        this.country = NID_C;
        this.linked = Q_LINK;
        this.linkingInformation = linkingInformation;
    }

    /*
    public BaliseGroup(int baliseGroupId, int version, int country, boolean linked, Balise[] balises, Packet_5 linkingInformation, Packet_79 geographicPosition) {
        this.baliseGroupId = baliseGroupId;
        this.version = version;
        this.country = country;
        this.linked = linked;
        this.balises = balises;
        this.linkingInformation = linkingInformation;
        this.geographicPosition = geographicPosition;
    }*/


    // Methods

    public void add(Balise balise) {
        balises[numberOfBalises] = balise;
        numberOfBalises += 1;
    }

    public void add(Balise[] balises) {
        if (balises.length > getBalises().length - numberOfBalises) return;

        for (int i = 0; i < balises.length; i++) {
            add(balises[i]);
        }
    }

    public void removeAllBalises() {
        balises = new Balise[8];
        numberOfBalises = 0;
    }

    public Balise[] getBalises() { return balises; }

    public int getNumberOfBalises() { return numberOfBalises; }

    public Balise getBaliseAt(int baliseNumber) { return balises[baliseNumber]; }

    public Packet_5 getLinkingInformation() { return linkingInformation; }

    public Telegram generateTelegramFor(int baliseNumber) {
        Balise balise = balises[baliseNumber];
        Telegram telegram = new Telegram(Q_UPDOWN_UP_LINK, version, Q_MEDIA_BALISE, baliseNumber, balises.length, balise.M_DUP(), balise.M_COUNT(), country, baliseGroupId, linked);

        if (balise.hasPacket_0()) {
            telegram.PACKET_0 = balise.Packet_0();
        }

        telegram.packets.addAll(balise.getPackets());

        return telegram;
    }

}
