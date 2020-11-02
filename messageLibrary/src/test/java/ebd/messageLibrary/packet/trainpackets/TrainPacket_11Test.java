package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacketTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TrainPacket_11Test extends TrainPacketTestBase {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("default", new Packet_11(), "[11:8][96:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("NC_CDTRAIN: Min", new Packet_11(0, 0, 0, 0, 0, 0, 0, 0), "[11:8][96:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("NC_CDTRAIN: Max", new Packet_11(15, 0, 0, 0, 0, 0, 0, 0), "[11:8][96:13][15:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("NC_TRAIN: Min", new Packet_11(0, 0, 0, 0, 0, 0, 0, 0), "[11:8][96:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("NC_TRAIN: Max", new Packet_11(0, 32767, 0, 0, 0, 0, 0, 0), "[11:8][96:13][0:4][32767:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("L_TRAIN: Min", new Packet_11(0, 0, 0, 0, 0, 0, 0, 0), "[11:8][96:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("L_TRAIN: Max", new Packet_11(0, 0, 4095, 0, 0, 0, 0, 0), "[11:8][96:13][0:4][0:15][4095:12][0:7][0:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("V_MAXTRAIN: Min", new Packet_11(0, 0, 0, 0, 0, 0, 0, 0), "[11:8][96:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("V_MAXTRAIN: Max", new Packet_11(0, 0, 0, 127, 0, 0, 0, 0), "[11:8][96:13][0:4][0:15][0:12][127:7][0:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("M_LOADINGGAUGE: Min", new Packet_11(0, 0, 0, 0, 0, 0, 0, 0), "[11:8][96:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("M_LOADINGGAUGE: Max", new Packet_11(0, 0, 0, 0, 255, 0, 0, 0), "[11:8][96:13][0:4][0:15][0:12][0:7][255:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("M_AXLELOADCAT: Min", new Packet_11(0, 0, 0, 0, 0, 0, 0, 0), "[11:8][96:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("M_AXLELOADCAT: Max", new Packet_11(0, 0, 0, 0, 0, 127, 0, 0), "[11:8][96:13][0:4][0:15][0:12][0:7][0:8][127:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("M_AIRTIGHT: Min", new Packet_11(0, 0, 0, 0, 0, 0, 0, 0), "[11:8][96:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("M_AIRTIGHT: Max", new Packet_11(0, 0, 0, 0, 0, 0, 3, 0), "[11:8][96:13][0:4][0:15][0:12][0:7][0:8][0:7][3:2][0:10][0:5][0:5]"),
                Arguments.of("N_AXLE: Min", new Packet_11(0, 0, 0, 0, 0, 0, 0, 0), "[11:8][96:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("N_AXLE: Max", new Packet_11(0, 0, 0, 0, 0, 0, 0, 1023), "[11:8][96:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][1023:10][0:5][0:5]"),
                
                Arguments.of("tracktionSystems: Empty", new Packet_11(0, 0, 0, 0, 0, 0, 0, 0), "[11:8][96:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("tracktionSystems: 1 Element", fill(new Packet_11(), new Packet_11.Packet_11_TractionSystem(), 1, new Packet_11.Packet_11_NationalSystem(), 0), "[11:8][100:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][1:5]{[0:4]*1}[0:5]"),
                Arguments.of("tracktionSystems: M_VOLTAGE: Min", fill(new Packet_11(), new Packet_11.Packet_11_TractionSystem(0, 0), 1, new Packet_11.Packet_11_NationalSystem(0), 0), "[11:8][100:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][1:5]{[0:4]*1}[0:5]"),
                Arguments.of("tracktionSystems: M_VOLTAGE: Max", fill(new Packet_11(), new Packet_11.Packet_11_TractionSystem(15, 0), 1, new Packet_11.Packet_11_NationalSystem(0), 0), "[11:8][110:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][1:5]{[15:4][0:10]*1}[0:5]"),
                Arguments.of("tracktionSystems: NID_CTRACTION: Min", fill(new Packet_11(), new Packet_11.Packet_11_TractionSystem(1, 0), 1, new Packet_11.Packet_11_NationalSystem(0), 0), "[11:8][110:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][1:5]{[1:4][0:10]*1}[0:5]"),
                Arguments.of("tracktionSystems: NID_CTRACTION: Max", fill(new Packet_11(), new Packet_11.Packet_11_TractionSystem(2, 1023), 1, new Packet_11.Packet_11_NationalSystem(0), 0), "[11:8][110:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][1:5]{[2:4][1023:10]*1}[0:5]"),
                Arguments.of("tracktionSystems: 1+ Element", fill(new Packet_11(), new Packet_11.Packet_11_TractionSystem(0, 0), 2, new Packet_11.Packet_11_NationalSystem(0), 0), "[11:8][104:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][2:5]{[0:4]*2}[0:5]"),
                Arguments.of("tracktionSystems: Max Element", fill(new Packet_11(), new Packet_11.Packet_11_TractionSystem(1, 0), 31, new Packet_11.Packet_11_NationalSystem(0), 0), "[11:8][530:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][31:5]{[1:4][0:10]*31}[0:5]"),
                
                Arguments.of("nationalSystemIDs: Empty", new Packet_11(), "[11:8][96:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][0:5]"),
                Arguments.of("nationalSystemIDs: 1 Element", fill(new Packet_11(), new Packet_11.Packet_11_TractionSystem(0, 0), 0, new Packet_11.Packet_11_NationalSystem(0), 1), "[11:8][104:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][1:5]{[0:8]*1}"),
                Arguments.of("nationalSystemIDs: NID_NTC: Min", fill(new Packet_11(), new Packet_11.Packet_11_TractionSystem(0, 0), 0, new Packet_11.Packet_11_NationalSystem(0), 1), "[11:8][104:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][1:5]{[0:8]*1}"),
                Arguments.of("nationalSystemIDs: NID_NTC: Max", fill(new Packet_11(), new Packet_11.Packet_11_TractionSystem(0, 0), 0, new Packet_11.Packet_11_NationalSystem(255), 1), "[11:8][104:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][1:5]{[255:8]*1}"),
                Arguments.of("nationalSystemIDs: 1+ Elements", fill(new Packet_11(), new Packet_11.Packet_11_TractionSystem(0, 0), 0, new Packet_11.Packet_11_NationalSystem(0), 2), "[11:8][112:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][2:5]{[0:8]*2}"),
                Arguments.of("nationalSystemIDs: Max Elements", fill(new Packet_11(), new Packet_11.Packet_11_TractionSystem(0, 0), 0, new Packet_11.Packet_11_NationalSystem(0), 31), "[11:8][344:13][0:4][0:15][0:12][0:7][0:8][0:7][0:2][0:10][0:5][31:5]{[0:8]*31}"),

                Arguments.of("all", fill(new Packet_11(7, 7813, 213, 63, 162, 92, 2, 437), new Packet_11.Packet_11_TractionSystem(6, 672), 1, new Packet_11.Packet_11_NationalSystem(216), 1), "[11:8][118:13][7:4][7813:15][213:12][63:7][162:8][92:7][2:2][437:10][1:5]{[6:4][672:10]*1}[1:5]{[216:8]*1}")
        );
    }

    public static Stream<Arguments> errors() {
        return Stream.of(
                Arguments.of("NC_CDTRAIN: Overflow", new Packet_11(16, 0, 0, 0, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("NC_TRAIN: Overflow", new Packet_11(0, 32768, 0, 0, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("L_TRAIN: Overflow", new Packet_11(0, 0, 4096, 0, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("V_MAXTRAIN: Overflow", new Packet_11(0, 0, 0, 128, 0, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("M_LOADINGGAUGE: Overflow", new Packet_11(0, 0, 0, 0, 256, 0, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("M_AXLELOADCAT: Overflow", new Packet_11(0, 0, 0, 0, 0, 128, 0, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("M_AIRTIGHT: Overflow", new Packet_11(0, 0, 0, 0, 0, 0, 4, 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("N_AXLE: Overflow", new Packet_11(0, 0, 0, 0, 0, 0, 0, 1024), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("tracktionSystems: M_VOLTAGE: Overflow", fill(new Packet_11(), new Packet_11.Packet_11_TractionSystem(16, 0), 1, new Packet_11.Packet_11_NationalSystem(0), 0), new IllegalArgumentException("Invalid value for given bit length")),
                Arguments.of("tracktionSystems: NID_CTRACTION: Overflow", fill(new Packet_11(), new Packet_11.Packet_11_TractionSystem(2, 1024), 1, new Packet_11.Packet_11_NationalSystem(0), 0), new IllegalArgumentException("Invalid value for given bit length")),

                Arguments.of("nationalSystemIDs: NID_NTC: Overflow", fill(new Packet_11(), new Packet_11.Packet_11_TractionSystem(0, 0), 0, new Packet_11.Packet_11_NationalSystem(256), 1), new IllegalArgumentException("Invalid value for given bit length"))
        );
    }


    public static Packet_11 fill(Packet_11 packet_11, Packet_11.Packet_11_TractionSystem tractionSystem, int ts_count, Packet_11.Packet_11_NationalSystem nationalSystem, int ns_count) {
        assert(ts_count < 32 && ns_count < 32);
        for(int i = 0; i < ts_count; i++) {
            packet_11.tractionSystems.add(tractionSystem);
        }
        for(int i = 0; i < ns_count; i++) {
            packet_11.nationalSystemIDs.add(nationalSystem);
        }
        return packet_11;
    }

}