package ebd.baliseTelegramGenerator;

import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_0;

import java.util.ArrayList;
import java.util.List;

public class Balise {

    private int baliseNumber;

    private int numberOfBalises = 8;

    private int duplicate;

    private int messageNumber;

    private Packet_0 packet_0 = null;

    private List<TrackPacket> packets = new ArrayList<TrackPacket>();

    // Balise Group

    private boolean direction; // msl crc variable


    // methods

    public int M_DUP() { return duplicate; }

    public int M_COUNT() { return messageNumber; }

    public boolean hasPacket_0() { return packet_0 != null; }

    public Packet_0 Packet_0() { return packet_0; }

    public List<TrackPacket> getPackets() { return packets; }

}
