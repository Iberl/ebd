package ebd.messageLibrary.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Containing Functions For String Operations
 *
 * @author Christopher Bernjus
 */
public class StringUtil {

    /**
     * Converts A UTF-8 String To An ISO-8859-1 Byte List
     *
     * @param s
     *            A UTF-8 Formatted String
     *
     * @return The ISO-8859-1 Formatted Byte List
     *
     * @author Christopher Bernjus
     */
    public static List<Byte> toISO88591_List(String s) {
        byte[] bytes = s.getBytes(StandardCharsets.ISO_8859_1);
        List<Byte> list = new ArrayList<>();
        for(byte b: bytes) list.add(b);
        return list;
    }

    /**
     * Converts A UTF-8 Character To An ISO-8859-1 Byte
     *
     * @param c
     *            A UTF-8 Formatted Character
     *
     * @return The ISO-8859-1 Formatted Byte
     *
     * @author Christopher Bernjus
     */
    public static Byte toISO88591_Byte(char c) {
        byte[] bytes = Character.toString(c).getBytes(StandardCharsets.ISO_8859_1);
        return bytes[0];
    }

    /**
     * Converts An ISO-8859-1 Byte List To A UTF-8 String
     *
     * @param bytes
     *            A ISO-8859-1 Formatted Byte List
     *
     * @return The UTF-8 Formatted String
     *
     * @author Christopher Bernjus
     */
    public static String toISO88591_String(List<Byte> bytes) {

        byte[] bytearr = new byte[bytes.size()];
        int i = 0;
        for(byte b: bytes) {
            bytearr[i] = b;
            i++;
        }

        Charset charset = Charset.forName(StandardCharsets.UTF_8.name());
        return charset.decode(ByteBuffer.wrap(bytearr)).toString();
    }

    /**
     * Converts An ISO-8859-1 Byte To A UTF-8 Character
     *
     * @param b
     *            A ISO-8859-1 Formatted Byte
     *
     * @return The UTF-8 Formatted Character
     *
     * @author Christopher Bernjus
     */
    public static char toISO88591_Char(Byte b) {
        Charset charset = Charset.forName(StandardCharsets.UTF_8.name());
        return charset.decode(ByteBuffer.wrap(new byte[]{b})).charAt(0);
    }

}