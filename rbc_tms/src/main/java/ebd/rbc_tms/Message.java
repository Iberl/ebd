package ebd.rbc_tms;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ebd.rbc_tms.util.ClassAnalysis;
import ebd.rbc_tms.util.exception.MissingInformationException;

import java.util.Objects;
import java.util.UUID;

/**
 * Superclass For All Messages In RBC-TMS Communications
 *
 * @param <Payload> Payload Class Used By Message Type
 *
 * @author Christopher Bernjus
 */
public abstract class Message<Payload extends ebd.rbc_tms.Payload> {

    /** Subclass for Holding Header Information */
    public static class Header {

        /** Message Type */
        public int type;

        /** Unique Identifier Of A Message Instance */
        public UUID uuid;

        /** Hash Value Of  */
        private int hash;

        /** ID Of The TMS-Sided Communication Partners */
        public String tms_id;

        /** ID Of The RBC-Sided Communication Partners */
        public String rbc_id;

        /** Timestamp Of Message Creation */
        private long timestamp = System.currentTimeMillis();


        // Constructor

        /**
         * Constructs An Instance Of {@link Header}
         *
         * @param type {@link Header#type}
         * @param uuid {@link Header#uuid}
         * @param tms_id {@link Header#tms_id}
         * @param rbc_id {@link Header#rbc_id}
         *
         * @author Christopher Bernjus
         */
        private Header(int type, UUID uuid, String tms_id, String rbc_id) {
            this.type = type;
            this.uuid = uuid;
            this.tms_id = tms_id;
            this.rbc_id = rbc_id;
        }


        // Functions

        @Override
        public String toString() {
            return "Header{" + "type=" + type + ", uuid=" + uuid + ", hash=" + hash + ", tms_id='" + tms_id + '\'' + ", rbc_id='" + rbc_id + '\'' +
                   ", timestamp=" + timestamp + '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Header header = (Header) o;
            return type == header.type && hash == header.hash && timestamp == header.timestamp && Objects.equals(uuid, header.uuid) &&
                   Objects.equals(tms_id, header.tms_id) && Objects.equals(rbc_id, header.rbc_id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, uuid, hash, tms_id, rbc_id, timestamp);
        }


        // Getter

        /**
         * @return Value Of {@link Header#hash}
         */
        public int getHash() {
            return hash;
        }

        /**
         * @return Value Of {@link Header#timestamp}
         */
        public long getTimestamp() {
            return timestamp;
        }

    }


    // Fields

    /** {@link Header} */
    private Header header;

    /** {@link Payload} */
    private Payload payload;


    // Constructors

    /**
     * Constructs A {@link Message} With A Random UUID
     *
     * @param type {@link Header#type}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload}
     *
     * @author Christopher Bernjus
     */
    public Message(int type, String tms_id, String rbc_id, Payload payload) {
        this(type, UUID.randomUUID(), tms_id, rbc_id, payload);
    }

    /**
     * Constructs A {@link Message} With A Specific UUID
     *
     * @param type {@link Header#type}
     * @param uuid {@link Header#uuid}
     * @param tms_id {@link Header#tms_id}
     * @param rbc_id {@link Header#rbc_id}
     * @param payload {@link Payload}
     *
     * @author Christopher Bernjus
     */
    public Message(int type, UUID uuid, String tms_id, String rbc_id, Payload payload) {
        this.header = new Header(type, uuid, tms_id, rbc_id);
        setPayload(payload);
    }


    // JSON

    /**
     * @return JSON String Representation Of Message
     *
     * @throws MissingInformationException When A Variable Has An Invalid Value
     *
     * @author Christopher Bernjus
     */
    public String parseToJson() throws MissingInformationException {

        // Check For Correct Values
        // Only Accordingly Annotated Fields Aan Hold The Null Value
        // Lists Must Have A Minimum Of 1 Element
        ClassAnalysis.checkValues(this);

        // Serialize Message
        return new Gson().toJson(this);
    }

    /**
     * @param jsonString JSON String To Be Deserialized
     *
     * @return Message Java Object Interpretation Of JSON String
     * @throws ClassNotFoundException When The Given JSON String Contains An Unsupported Message Type
     *
     * @author Christopher Bernjus
     */
    public static Message<ebd.rbc_tms.Payload> generateFrom(String jsonString) throws ClassNotFoundException {
        Gson gson = new Gson();

        // Read Message Type From JSON String
        JsonObject obj = JsonParser.parseString(jsonString).getAsJsonObject();
        int type = obj.get("header").getAsJsonObject().get("type").getAsInt();

        // Find Class For Message Type
        Class<?> clazz;
        try {
            clazz = Class.forName("ebd.rbc_tms.message.Message_" + (type >= 0 && type < 10 ? "0" : "") + type);
        } catch(ClassNotFoundException e) {
            throw new ClassNotFoundException("Could not find the message class for type: \"" + type + "\"");
        }

        // Deserialize JSON String
        return (Message<ebd.rbc_tms.Payload>) gson.fromJson(jsonString, clazz);
    }


    // Functions

    @Override
    public String toString() {
        return "Message{" + "header=" + header.toString() + ", payload=" + payload.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Message<?> message = (Message<?>) o;
        return Objects.equals(header, message.header) && Objects.equals(payload, message.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, payload);
    }


    // Getter

    /**
     * @return {@link Header} Object
     */
    public Header getHeader() {
        return header;
    }

    /**
     * @return {@link Payload} Object
     */
    public Payload getPayload() {
        return payload;
    }


    // Setter

    /**
     * Updates the Timestamp in Header
     *
     * @author Christopher Bernjus
     */
    public void updateTimestamp() {
        this.header.timestamp = System.currentTimeMillis();
    }

    /**
     * Set A New {@link Payload} Object <br>
     * And Updates the Timestamp
     * @param payload {@link Payload}
     *
     * @author Christopher Bernjus
     */
    public void setPayload(Payload payload) {
        this.payload = payload;
        this.header.hash = payload.hashCode();
        updateTimestamp();
    }

}
