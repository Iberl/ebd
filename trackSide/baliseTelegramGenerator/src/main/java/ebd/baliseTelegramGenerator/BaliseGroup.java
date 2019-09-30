package ebd.baliseTelegramGenerator;

import ebd.globalUtils.location.Location;
import ebd.messageLibrary.message.Telegram;
import ebd.messageLibrary.packet.trackpackets.Packet_5;
import ebd.messageLibrary.packet.trackpackets.Packet_79;
import org.jetbrains.annotations.Nullable;

import static ebd.messageLibrary.util.ETCSVariables.*;

public class BaliseGroup {

    // x Holds the Information contained in a Balise Group
    // x Manages single Balises in BG
    // x Adding
    // x Removing
    // x Duplicates
    // x Reference
    // x Linking Information
    // x Telegram Generation

    private boolean Q_UPDOWN = Q_UPDOWN_UP_LINK;

    private int version = M_VERSION;

    private boolean Q_MEDIA = Q_MEDIA_BALISE;

    private Balise[] balises = new Balise[8];

    private int N_TOTAL = 0;

    private int country = NID_C;

    private int NID_BG;

    private boolean linked = Q_LINK;

    private Location location;

    // private int distanceBetweenBalises = 10;


    @Nullable
    private Packet_5 linkingInformation;

    private int linkingInformationBalise = 1;

    @Nullable
    private Packet_79 geographicPosition;

    private int geographicPositionBalise = 1;


    // Constructors

    public BaliseGroup(int M_VERSION, int NID_C, int NID_BG, int NID_LRBG, double D_LRBG, boolean Q_LINK, @Nullable Packet_5 linkingInformation) {
        this.version = M_VERSION;
        this.country = NID_C;
        this.NID_BG = NID_BG;
        this.linked = Q_LINK;
        this.location = new Location(String.valueOf(NID_BG), String.valueOf(NID_LRBG), D_LRBG);
        this.linkingInformation = linkingInformation;
    }


    // Getter and Setter

    public boolean getQ_UPDOWN() { return Q_UPDOWN; }

    public int getM_VERSION() { return version; }

    public void setM_VERSION(int M_VERSION) { this.version = M_VERSION; }

    public boolean getQ_MEDIA() { return Q_MEDIA; }

    public int getN_TOTAL() { return N_TOTAL; }

    public int getNID_C() { return country; }

    public void setNID_C(int NID_C) { this.country = NID_C; }

    public int getNID_BG() { return NID_BG; }

    public boolean getQ_LINK() { return linked; }

    public void setQ_LINK(boolean Q_LINK) { this.linked = Q_LINK; }

    public Location getLocation() { return location; }

    public void setLocation(Location location) { this.location = location; }

    /*public int getDistanceBetweenBalises() { return distanceBetweenBalises; }

    public void setDistanceBetweenBalises(int distance) { this.distanceBetweenBalises = distance; }*/


    // Manage Balises

    public Balise[] getBalises() { return balises; }

    public Balise getBaliseAt(int N_PIG) { return balises[N_PIG]; }

    public boolean setBaliseAt(int N_PIG, Balise balise) throws IndexOutOfBoundsException {
        if(balises.length > getBalises().length - N_TOTAL) return false;

        switch(balise.getM_DUP()) {
            case M_DUP_NEXT_BALISE: if(!balises[N_PIG + 1].setM_DUP(M_DUP_PREV_BALISE)) return false;
            case M_DUP_PREV_BALISE: if(!balises[N_PIG - 1].setM_DUP(M_DUP_NEXT_BALISE)) return false;
            case M_DUP_NO_DUPLICATE: return balises[N_PIG + 1].setM_DUP(M_DUP_PREV_BALISE) & balises[N_PIG - 1].setM_DUP(M_DUP_NEXT_BALISE);
        }
        balises[N_PIG] = balise;
        return true;
    }

    public void add(Balise balise) throws IndexOutOfBoundsException {
        balises[N_TOTAL] = balise;
        N_TOTAL += 1;
    }

    public boolean add(Balise[] balises) throws IndexOutOfBoundsException {
        if(balises.length > getBalises().length - N_TOTAL) return false;

        for(int i = 0; i < balises.length; i++) {
            add(balises[i]);
        }
        return true;
    }

    public boolean duplicateLast() {
        if(N_TOTAL >= 8) return false;

        Balise src = balises[N_TOTAL - 1];
        // TODO
        if(!src.setM_DUP(M_DUP_NEXT_BALISE)) return false;
        Balise dup = new Balise(M_DUP_PREV_BALISE,src.M_MCOUNT, src.packet_0);
        dup.packets = src.packets;

        balises[N_TOTAL] = dup;
        N_TOTAL += 1;
        return true;
    }

    public void removeAllBalises() {
        balises = new Balise[8];
        N_TOTAL = 0;
    }


    // Manage Packages

    public Packet_5 getLinkingInformation() { return linkingInformation; }

    public int getLinkingInformationBalise() { return linkingInformationBalise; }

    public boolean setLinkingInformation(int N_PIG, Packet_5 packet_5) {
        if(N_PIG < 0 || N_PIG >= 8) return false;

        linkingInformationBalise = N_PIG;
        linkingInformation = packet_5;
        return true;
    }

    public Packet_79 getGeographicPosition() { return geographicPosition; }

    public int getGeographicPositionBalise() { return geographicPositionBalise; }

    public boolean setGeographicPosition(int N_PIG, Packet_79 packet_79) {
        if(N_PIG < 0 || N_PIG >= 8) return false;

        geographicPositionBalise = N_PIG;
        geographicPosition = packet_79;
        return true;
    }

    // Methods

    //public Packet_5 getLinkingInformation() { return linkingInformation; }

    public Telegram generateTelegramFor(int N_PIG) {

        Balise balise = balises[N_PIG];
        Telegram telegram = new Telegram(Q_UPDOWN, version, Q_MEDIA, N_PIG, N_TOTAL, balise.getM_DUP(), balise.M_MCOUNT, country, NID_BG, linked);

        if (balise.packet_0 != null) {
            telegram.PACKET_0 = balise.packet_0;
        }

        telegram.packets.addAll(balise.packets);

        if(linked && linkingInformationBalise == N_PIG) telegram.packets.add(linkingInformation);
        if(geographicPositionBalise == N_PIG) telegram.packets.add(geographicPosition);

        return telegram;
    }

}
