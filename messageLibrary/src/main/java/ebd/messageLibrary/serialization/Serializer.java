package ebd.messageLibrary.serialization;

import ebd.messageLibrary.message.Message;
import ebd.messageLibrary.message.RadioLoopMessage;
import ebd.messageLibrary.message.Telegram;
import ebd.messageLibrary.packet.Packet;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.BinaryCodedDecimal;
import ebd.messageLibrary.util.BitUtil;
import ebd.messageLibrary.util.Pair;
import ebd.messageLibrary.util.exception.*;
import ebd.messageLibrary.util.userData.UserData;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Class for handling the serialization of Packets
 *
 * @author Christopher Bernjus
 * @version 2.0
 */
public abstract class Serializer {

    public static boolean debug = false;


    // -------------
    // Serialization
    // -------------

    /**
     * Converts an instance to a bit stream and returns it in a new BitStreamWriter
     *
     * @param object
     *         The object to serialize
     *
     * @return Returns a new {@link BitStreamWriter} with the converted bit stream data
     *
     * @throws NotSerializableException
     * @throws FieldTypeNotSupportedException
     * @throws MissingInformationException
     * @throws ClassMalformedException
     *
     * @author Christopher Bernjus
     */
    public static BitStreamWriter serialize(Object object)
            throws NotSerializableException, FieldTypeNotSupportedException, MissingInformationException, ClassMalformedException {

        // Check If Object Is Serializable
        if(object == null || !isSerializable(object.getClass())) throw new NotSerializableException();

        BitStreamWriter writer;

        List<Field> orderedFields = getFieldsInOrder(object);

        Map<String, Object> fieldValues = getFieldValues(object, orderedFields);

        List<Field> fieldsToSerialize = getFieldsToSerialize(orderedFields, fieldValues);

        writer = serialize(object, fieldsToSerialize, fieldValues);

        return writer;
    }


    /**
     * Arranges the fields of the given object in correct order and returns them as a list
     *
     * @param object
     *         The object holding fields
     *
     * @return Sorted list of fields
     *
     * @author Christopher Bernjus
     */
    private static List<Field> getFieldsInOrder(Object object) throws ClassMalformedException {

        Field[] fieldsarr = object.getClass().getFields();

        List<Pair> fields = Arrays.stream(object.getClass().getFields()).map(field -> {
            int orderIndex = field.getAnnotation(OrderIndex.class).value();
            return new Pair(orderIndex, field);
        }).collect(Collectors.toList());

        if(!fields.stream().map(Pair::getKey).allMatch(new HashSet<>()::add)) {
            throw new ClassMalformedException("Multiple Fields with same @OrderIndex value");
        }

        return fields.stream()
                     .sorted(Comparator.comparingInt(o -> (int) o.getKey()))
                     .map(pair -> (Field) pair.getValue())
                     .collect(Collectors.toList());
    }


    /**
     * Extracts the values of given fields from an object
     *
     * @param object
     *         The object holding the values
     * @param fields
     *         List of fields to get values for
     *
     * @return Mapping from the field name to the field value
     *
     * @throws MissingInformationException
     *
     * @author Christopher Bernjus
     */
    private static Map<String, Object> getFieldValues(Object object, List<Field> fields) throws MissingInformationException {

        Map<String, Object> values = new HashMap<>();

        for(Field field : fields) {

            // Try to access the fields value
            Object value;
            try {
                value = field.get(object);

                if(value == null) {
                    if(field.getAnnotation(OptionalPacket.class) != null) {
                        continue;
                    } else {
                        throw new MissingInformationException(field.getName() + " is set to null");
                    }
                }

                values.put(field.getName(), value);

            } catch(IllegalAccessException e) {
                if(debug) {
                    System.err.println("Unable to read value of field " + field.getName() + ": " + e.getLocalizedMessage());
                }
                e.printStackTrace();
            }

        }

        return values;
    }


    /**
     * Determines which fields should be serialized
     *
     * @param fields
     *         Ordered list of fields to examine
     * @param values
     *         Mapping of field names to field values
     *
     * @return List of fields which should be serialized
     *
     * @author Christopher Bernjus
     */
    private static List<Field> getFieldsToSerialize(List<Field> fields, Map<String, Object> values) {

        // List of fields to be serialized
        List<Field> fieldsToSerialize = new ArrayList<>();

        // Map with previous values for condition checking
        Map<String, Object> previousValues = new HashMap<>();

        // Remove all fields which should not be serialized
        fields.removeIf(field -> {
            Object value = values.get(field.getName());
            return value == null || !isSerializable(value.getClass());
        });

        // Iterate over all remaining fields
        for(Field field : fields) {

            // Get annotations
            Annotation[] annotations = field.getAnnotations();

            // Check if all conditions are statisfied and the field should be serialized
            if(!allConditionsStatisfied(annotations, previousValues)) {
                if(debug) System.err.println(field.getName() + " was skipped");
                continue;
            }

            // Remember the field's value
            previousValues.put(field.getName(), values.get(field.getName()));

            // Add the field to list
            fieldsToSerialize.add(field);

        }

        return fieldsToSerialize;
    }


    /**
     * Converts an instance to a bit stream using a given BitStreamWriter
     *
     * @param object
     *         The object reference
     * @param fieldsToSerialize
     *         A list with field which should be serialized
     * @param values
     *         A list holding all relevant values for fields
     *
     * @return The BitStreamWriter for output of ebd.messageLibrary.serialization
     *
     * @throws NotSerializableException
     * @throws FieldTypeNotSupportedException
     * @throws MissingInformationException
     * @throws ClassMalformedException
     *
     * @author Christopher Bernjus
     */
    private static BitStreamWriter serialize(Object object, List<Field> fieldsToSerialize, Map<String, Object> values)
            throws NotSerializableException, FieldTypeNotSupportedException, MissingInformationException, ClassMalformedException {

        int length = 0;
        int lengthBitLength = 13;
        int lengthIndex = -1;

        boolean isMessage = Message.class.isAssignableFrom(object.getClass());
        boolean isTelegram = Telegram.class.isAssignableFrom(object.getClass());
        boolean isPacket = Packet.class.isAssignableFrom(object.getClass());

        BitStreamWriter writer = new BitStreamWriter();

        for(Field field : fieldsToSerialize) {

            String fieldName = field.getName();

            if(Objects.equals(fieldName, "L_MESSAGE") || Objects.equals(fieldName, "L_PACKET")) {
                lengthIndex = writer.position();
                if(field.isAnnotationPresent(BitLength.class)) {
                    lengthBitLength = field.getAnnotation(BitLength.class).value();
                }
            }

            Object value = values.get(fieldName);

            // Serialize Bit
            if(value instanceof Boolean) {

                if(!field.isAnnotationPresent(BitLength.class)) {
                    throw new ClassMalformedException("BitLength annotation missing");
                }
                int fieldLength = field.getAnnotation(BitLength.class).value();

                // Increase Length
                length += fieldLength;

                // Write Bit Value
                writer.writeBit((Boolean) value);
            }

            // Serialize Integer
            else if(value instanceof Integer) {

                if(!field.isAnnotationPresent(BitLength.class)) {
                    throw new ClassMalformedException("BitLength annotation missing");
                }
                int fieldLength = field.getAnnotation(BitLength.class).value();

                // Increase Length
                length += fieldLength;

                // Write Integer Value
                writer.writeInt((int) value, (fieldLength >= 0) ? fieldLength : Integer.SIZE, isSigned(field.getAnnotations()));
            }

            // Serialize Long
            else if(value instanceof Long) {

                if(!field.isAnnotationPresent(BitLength.class)) {
                    throw new ClassMalformedException("BitLength annotation missing");
                }
                int fieldLength = field.getAnnotation(BitLength.class).value();

                // Increase Length
                length += fieldLength;

                // Write Long Value
                writer.writeLong((long) value, (fieldLength >= 0) ? fieldLength : Long.SIZE, isSigned(field.getAnnotations()));

            // User Data
            } else if(UserData.class.isAssignableFrom(value.getClass())) {

                BitStreamWriter subwriter = serialize(value);

                if(subwriter.size() > 0) {
                    length += subwriter.size();

                    writer.writeBits(subwriter.data(), subwriter.size());
                }

            // Binary Coded Decimal
            } else if(value instanceof BinaryCodedDecimal) {

                BinaryCodedDecimal bcd = (BinaryCodedDecimal) value;

                // Increase Length
                length += bcd.getBitlength();

                // Write BCD Value
                writer.writeLong(bcd.getNumber(), bcd.getBitlength(), false);

            // Serialize List
            } else if(List.class.isAssignableFrom(value.getClass())) {

                if(!isMessage && !isTelegram) {
                    int sizeBitLength = 5;

                    if(field.isAnnotationPresent(ListSize.class)) {
                        sizeBitLength = field.getAnnotation(ListSize.class).value();
                    }

                    length += sizeBitLength;

                    // Empty List
                    if(((List) value).size() <= 0) {
                        // Write N_ITER = 0
                        writer.writeInt(0, sizeBitLength);
                        continue;
                    }

                    // Write N_ITER Value
                    writer.writeInt(((List<?>) value).size(), sizeBitLength);
                }

                if(((List) value).size() <= 0) continue;

                // Serialize List Elements
                for(Object item : (List<?>) value) {

                    BitStreamWriter subwriter = serialize(item);

                    if(subwriter.size() > 0) {
                        length += subwriter.size();

                        writer.writeBits(subwriter.data(), subwriter.size());
                    }

                }

            // Serialize Nested Class
            } else if(value.getClass().getDeclaringClass() == object.getClass() ||
                      value.getClass().getDeclaringClass() == object.getClass().getSuperclass() ||
                      value.getClass().getDeclaringClass() == object.getClass().getEnclosingClass()) {

                BitStreamWriter subwriter = serialize(value);

                if(subwriter.size() > 0) {
                    length += subwriter.size();

                    writer.writeBits(subwriter.data(), subwriter.size());
                }

            } else {
                // Field Type Is Not Supported
                throw new FieldTypeNotSupportedException("Unsupported field type: " + value.getClass().getTypeName());
            }

        }

        // Only For Messages
        if(isMessage) {
            // Add Padding
            writer.writeInt(0, BitUtil.trailBits(length));
            // Modify Length Unit
            length = BitUtil.byteCount(length);
        }

        if(isMessage || isPacket) {
            // Write Length Information
            if(lengthIndex >= 0) {
                writer.seek(lengthIndex);
                writer.writeInt(length, lengthBitLength);
                writer.seek(writer.size());
            } else {
                throw new ClassMalformedException("No L_MESSAGE or L_PACKET field was found in class " + object.getClass().getSimpleName());
            }
        }

        return writer;
    }



    // ---------------
    // Deserialization
    // ---------------

    /**
     * Creates an instance of an {@link Message} from a given buffer
     *
     * @param reader
     *         the bit stream to read from
     * @param trainToTrack
     *         indicates whether the bit stream contains a track or train message/packet
     * @param <T>
     *         the Class Type of the returned instance
     *
     * @return The Class interpretation of the given bit stream
     *
     * @throws NotDeserializableException
     * @throws ClassNotSupportedException
     * @throws ValueNotSupportedException
     * @throws BitLengthOutOfBoundsException
     * @throws ClassMalformedException
     *
     * @author Christopher Bernjus
     */
    public static <T> T deserializeMessage(BitStreamReader reader, boolean trainToTrack)
            throws NotDeserializableException, ClassNotSupportedException, ValueNotSupportedException, BitLengthOutOfBoundsException,
                   ClassMalformedException {
        // Get ID From Message
        int id = reader.readInt(8, false);

        // Find Class For Message ID
        Class<?> clazz;
        // TrainToTrack Message Class
        if(trainToTrack) {
            try {
                clazz = Class.forName("ebd.messageLibrary.message.trainmessages.Message_" + id);
            } catch(ClassNotFoundException e) {
                throw new ClassNotSupportedException("Could not find the train message class with ID: \"" + id + "\"");
            }

            // TrackToTrain Message Class
        } else {
            try {
                clazz = Class.forName("ebd.messageLibrary.message.trackmessages.Message_" + id);
            } catch(ClassNotFoundException e) {
                throw new ClassNotSupportedException("Could not find the track message class with ID: \"" + id + "\"");
            }
        }

        // Deserialize Message
        return (T) deserialize(reader, clazz, trainToTrack);
    }


    /**
     * Creates an instance of an {@link Packet} from a given buffer
     *
     * @param reader
     *         the bit stream to read from
     * @param trainToTrack
     *         indicates whether the bit stream contains a track or train message/packet
     * @param <T>
     *         the Class Type of the returned instance
     *
     * @return The Class interpretation of the given bit stream
     *
     * @throws NotDeserializableException
     * @throws ClassNotSupportedException
     * @throws ValueNotSupportedException
     * @throws BitLengthOutOfBoundsException
     * @throws ClassMalformedException
     *
     * @author Christopher Bernjus
     */
    public static <T> T deserializePacket(BitStreamReader reader, boolean trainToTrack)
            throws NotDeserializableException, ClassNotSupportedException, ValueNotSupportedException, BitLengthOutOfBoundsException,
                   ClassMalformedException {
        // Get ID From Packet
        int id = reader.readInt(8, false);

        // Find Class For Packet ID
        Class<?> clazz;
        // Bidirectional Packet Class
        if(id == 255) {
            try {
                clazz = Class.forName("ebd.messageLibrary.packet.Packet_255");
            } catch(ClassNotFoundException e) {
                throw new ClassNotSupportedException("Could not find the Packet_255 class");
            }

        } else {
            // TrainToTrack Packet Class
            if(trainToTrack) {
                try {
                    clazz = Class.forName("ebd.messageLibrary.packet.trainpackets.Packet_" + id);
                } catch(ClassNotFoundException e1) {
                    throw new ClassNotSupportedException("Could not find the train packet class with ID: \"" + id + "\"");
                }

                // TrackToTrain Packet Class
            } else {
                try {
                    clazz = Class.forName("ebd.messageLibrary.packet.trackpackets.Packet_" + id);
                } catch(ClassNotFoundException e1) {
                    throw new ClassNotSupportedException("Could not find the track packet class with ID: \"" + id + "\"");
                }
            }
        }

        // Deserialize Packet
        return (T) deserialize(reader, clazz, trainToTrack);
    }


    /**
     * Creates an instance of an {@link Telegram} from a given buffer
     *
     * @param reader
     *         the bit stream to read from
     * @param <T>
     *         the Class Type of the returned instance
     *
     * @return The Class interpretation of the given bit stream
     *
     * @throws NotDeserializableException
     * @throws ClassNotSupportedException
     * @throws ValueNotSupportedException
     * @throws BitLengthOutOfBoundsException
     * @throws ClassMalformedException
     *
     * @author Christopher Bernjus
     */
    public static <T> T deserializeTelegram(BitStreamReader reader)
            throws NotDeserializableException, ClassNotSupportedException, ValueNotSupportedException, BitLengthOutOfBoundsException,
                   ClassMalformedException {
        // Deserialize Telegram
        return (T) deserialize(reader, Telegram.class, false);
    }


    /**
     * Creates an instance of an {@link RadioLoopMessage} from a given buffer
     *
     * @param reader
     *         the bit stream to read from
     * @param <T>
     *         the Class Type of the returned instance
     *
     * @return The Class interpretation of the given bit stream
     *
     * @throws NotDeserializableException
     * @throws ClassNotSupportedException
     * @throws ValueNotSupportedException
     * @throws BitLengthOutOfBoundsException
     * @throws ClassMalformedException
     *
     * @author Christopher Bernjus
     */
    public static <T> T deserializeRadioLoopMessage(BitStreamReader reader)
            throws NotDeserializableException, ClassNotSupportedException, ValueNotSupportedException, BitLengthOutOfBoundsException,
                   ClassMalformedException {
        // Deserialize RadioLoopMessage
        return (T) deserialize(reader, RadioLoopMessage.class, false);
    }


    /**
     * Creates an instance of an {@link UserData} Object
     *
     * @param reader
     *         the bit stream to read from
     * @param trainToTrack
     *         indicates whether the bit stream contains a track or train message/packet
     * @param <T>
     *         the Class Type of the returned instance
     *
     * @return The Class interpretation of the given bit stream
     *
     * @throws NotDeserializableException
     * @throws ClassNotSupportedException
     * @throws ValueNotSupportedException
     * @throws BitLengthOutOfBoundsException
     * @throws ClassMalformedException
     *
     * @author Christopher Bernjus
     */
    private static <T> T deserializeUserData(BitStreamReader reader, boolean trainToTrack)
            throws NotDeserializableException, ClassNotSupportedException, ValueNotSupportedException, BitLengthOutOfBoundsException,
                   ClassMalformedException {

        // Get Previous Variable: NID_XUSER
        reader.seek(reader.position() - 9);
        int NID_XUSER = reader.readInt(9, false);

        // Find Class For NID_XUSER
        Class<?> clazz;

        try {
            clazz = Class.forName("ebd.messageLibrary.util.userData.UserData_" + NID_XUSER);
        } catch(ClassNotFoundException e) {
            throw new ClassNotSupportedException("Could not find the Class UserData_" + NID_XUSER);
        }

        // Deserialize User Data
        return (T) deserialize(reader, clazz, trainToTrack);
    }


    /**
     * Creates an instance of an given Class Type from a given buffer
     *
     * @param reader
     *         the bit stream to read from
     * @param type
     *         the Class Type for the returned instance
     * @param <T>
     *         the Class Type of the returned instance
     * @param trainToTrack
     *         indicates in which direction the message/packet is sent
     *
     * @return The Class interpretation of the given bit stream
     *
     * @throws BitLengthOutOfBoundsException
     * @throws ClassMalformedException
     * @throws ClassNotSupportedException
     * @throws ValueNotSupportedException
     *
     * @author Christopher Bernjus
     */
    private static <T> T deserialize(BitStreamReader reader, Class<T> type, boolean trainToTrack)
            throws NotDeserializableException, ClassNotSupportedException, ValueNotSupportedException, BitLengthOutOfBoundsException,
                   ClassMalformedException {
        // Get The Default Constructor With No Parameters
        Constructor<?> constructor;
        try {
            constructor = type.getConstructor();
        } catch(NoSuchMethodException e) {
            throw new NotDeserializableException("The class type " + type + " doesn't support a default Constructor.");
        }

        // Create An Instance Of The Class
        Object instance;
        try {
            instance = constructor.newInstance();
        } catch(NullPointerException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new NotDeserializableException("Cannot create an instance of given type: " + type);
        }

        // Get Number Of Fields
        int numberOfFields = type.getFields().length;
        for(Field field : type.getFields()) {
            if(field.isAnnotationPresent(OrderIndex.class)) {
                int orderIndex = field.getAnnotation(OrderIndex.class).value();
                numberOfFields = Math.max(numberOfFields, orderIndex + 1);
            } else {
                throw new ClassMalformedException("No @OrderIndex information was specified for class " + type.getSimpleName());
            }
        }

        // Create Order Of Fields To Deserialize
        Field[] fieldsInOrder = new Field[numberOfFields];
        for(Field field : type.getFields()) {
            if(field.isAnnotationPresent(NotToBeDeserialized.class)) continue;
            int index = field.getAnnotation(OrderIndex.class).value();

            fieldsInOrder[index] = field;
        }

        // Extract Message Byte Length / Packet Bit Length
        int length = 0;
        if(Message.class.isAssignableFrom(type)) {
            length = reader.peekInt(10, false) * 8;
        } else if(TrainPacket.class.isAssignableFrom(type)) {
            length = reader.peekInt(13, false);
        } else if(TrackPacket.class.isAssignableFrom(type)) {
            reader.seek(reader.position() + 2);
            length = reader.peekInt(13, false);
            reader.seek(reader.position() - 2);
        }

        // Actual Bitlength
        int bitLength = 0;

        // Maps Field Name to Deserialized Field
        Map<String, Object> deserializedFields = new HashMap<>();

        // Deserialize Fields In Order
        for(Field field : fieldsInOrder) {

            if(field == null) continue;

            // Get Annotations From Field Declaration
            Annotation[] annotations = field.getAnnotations();

            // Check Whether The Field Should Be Serialized
            if(!allConditionsStatisfied(annotations, deserializedFields)) {
                if(debug) System.out.println(field + "wasnt deserialized");
                continue;
            }

            // Deserialize field
            try {
                // Set Field Accessible For Deserializer
                field.setAccessible(true);

                // Get Field Value
                Object value = field.get(instance);

                // Deserialize Bit
                if(value instanceof Boolean) {
                    // Read Bit Value
                    value = reader.readBit();
                    bitLength += 1;

                // Deserialize Integer
                } else if(value instanceof Integer) {
                    int len = bitLength(annotations);
                    bitLength += len;
                    if(len > 32) {
                        // Invalid BitLength Value
                        throw new BitLengthOutOfBoundsException("Invalid bit length (" + len + ") for field " + type.getSimpleName() + "." + field.getName());
                    }
                    // No BitLength Was Set
                    if(len < 0) len = 32;

                    // Read (Signed) Integer Value
                    if(isSigned(annotations)) {
                        value = reader.readInt(len, true);
                    } else {
                        value = reader.readInt(len, false);
                    }

                // Deserialize Long
                } else if(value instanceof Long) {
                    int len = bitLength(annotations);
                    bitLength += len;
                    if(len > 64) {
                        // Invalid BitLength Value
                        throw new BitLengthOutOfBoundsException("Invalid bit length (" + len + ") for field " + type.getSimpleName() + "." + field.getName());
                    }
                    // No BitLength Was Set
                    if(len < 0) len = 64;

                    // Read (Signed) Long Value
                    if(isSigned(annotations)) {
                        value = reader.readLong(len, true);
                    } else {
                        value = reader.readLong(len, false);
                    }

                // Deserialize Message Packet List
                } else if(List.class.isAssignableFrom(field.getType()) && Message.class.isAssignableFrom(type)) {
                    Class<?> itemType = itemType(annotations);
                    if(itemType == null) {
                        throw new ClassMalformedException("No @ItemType information was specified for field " + type.getSimpleName() + "." + field.getName());
                    }

                    List<Packet> list = new ArrayList<>();

                    while(length - bitLength >= 8 && reader.size() - reader.position() >= 8) {
                        list.add(deserializePacket(reader, trainToTrack));
                    }

                    int padding;
                    try {
                        padding = reader.readInt(reader.size() - reader.position(), false);
                    } catch(IndexOutOfBoundsException e) {
                        throw new NotDeserializableException("Insufficient padding bits");
                    }

                    if(padding != 0 || reader.position() < reader.size()) {
                        throw new NotDeserializableException("Incorrect value specified by L_MESSAGE");
                    }

                    value = list;

                // Deserialize Telegram/RadioLoop Packet List
                } else if(List.class.isAssignableFrom(field.getType()) &&
                          (Telegram.class.isAssignableFrom(type) || RadioLoopMessage.class.isAssignableFrom(type))) {
                    Class<?> itemType = itemType(annotations);
                    if(itemType == null) {
                        // No ItemType For List Was Set
                        throw new ClassMalformedException("No @ItemType information was specified for field " + type.getSimpleName() + "." + field.getName());
                    }

                    int packetID = reader.peekInt(8, false);
                    bitLength += 8;

                    List<Packet> list = new ArrayList<>();

                    while(packetID != 255) {
                        list.add(deserializePacket(reader, trainToTrack));

                        packetID = reader.peekInt(8, false);
                    }

                    value = list;

                // Deserialize List Of Other Type
                } else if(List.class.isAssignableFrom(field.getType())) {
                    Class<?> itemType = itemType(annotations);
                    if(itemType == null) {
                        // No ItemType For List Was Set
                        throw new ClassMalformedException("No @ItemType information was specified for field " + type.getSimpleName() + "." + field.getName());
                    }

                    int sizeBitlength = 5;
                    if(field.isAnnotationPresent(ListSize.class)) {
                        sizeBitlength = field.getAnnotation(ListSize.class).value();
                    }
                    bitLength += sizeBitlength;

                    // Read N_ITER Value
                    int size = reader.readInt(sizeBitlength, false);
                    List<Object> list = new ArrayList<>();

                    if(Modifier.isAbstract(itemType.getModifiers())) {
                        // ItemType Is Abstract
                        for(int i = 0; i < size; i++) {
                            list.add(deserializePacket(reader, trainToTrack));
                        }
                    } else {
                        // ItemType Is A Concrete Class
                        for(int i = 0; i < size; i++) {
                            list.add(deserialize(reader, itemType, trainToTrack));
                        }
                    }

                    value = list;

                // Deserialize Element
                } else if(isSerializable(field.getType())) {
                    if(field.isAnnotationPresent(OptionalPacket.class)) {
                        // Field Is An Instance Of An Optional Packet
                        if(!Packet.class.isAssignableFrom(field.getType())) {
                            throw new ValueNotSupportedException("The field " + type.getSimpleName() + "." + field.getName() + " must be a packet");
                        }

                        if(reader.size() - reader.position() >= 8) {

                            int packetID   = reader.peekInt(8, false);
                            int expectedID = -1;

                            try {
                                expectedID = ((Packet) field.getType().getConstructor().newInstance()).NID_PACKET;

                            } catch(InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                                e.printStackTrace();
                            }

                            if(expectedID == packetID) value = deserializePacket(reader, trainToTrack);
                        }

                    } else if(Packet.class.isAssignableFrom(field.getType())) {
                        // Field Is An Instance Of A Packet
                        value = deserializePacket(reader, trainToTrack);

                    } else if(UserData.class.isAssignableFrom(field.getType())) {
                        // Field Is An Instance Of A User Data Object
                        value = deserializeUserData(reader, trainToTrack);
                        if(value.getClass().isAnnotationPresent(BitLength.class)) {
                            bitLength += value.getClass().getAnnotation(BitLength.class).value();
                        } else {
                            throw new ClassMalformedException("No @ItemType information was specified for user data " + value.getClass().getSimpleName());
                        }

                    } else if(BinaryCodedDecimal.class.isAssignableFrom(field.getType())) {
                        // Field Is An Instance Of A Binary Coded Decimal
                        int numberOfDigits = field.getAnnotation(NumberOfDigits.class).value();
                        value = new BinaryCodedDecimal(reader.readLong(numberOfDigits * 4, false), numberOfDigits);
                        bitLength += ((BinaryCodedDecimal) value).getBitlength();

                    } else {
                        // Field Is An Instance Of Another class
                        value = deserialize(reader, field.getType(), trainToTrack);
                    }

                } else {
                    // Value Is Not Supported
                    throw new ValueNotSupportedException("The field " + type.getSimpleName() + "." + field.getName() + " does not match any supported type");
                }

                // Print Value Information In Debug Mode
                if(debug && value != null) {
                    if(debug) System.out.print("Value: " + value + " \t - Length: ");
                    int len = bitLength(annotations);
                    if(len >= 0 && debug) System.out.print(len);
                    if(debug) System.out.println();
                }

                // Set Value Of Field
                field.set(instance, value);

                // Mark Field As Deserialized
                deserializedFields.put(field.getName(), value);

            } catch(IllegalArgumentException | IllegalAccessException e) {
                if(debug) {
                    System.err.println("Unable to read value of field " + field.getName() + ": " + e.getLocalizedMessage());
                }
                e.printStackTrace();
            }

        }

        return (T) instance;
    }


    // Utility Functions

    /**
     * @param type
     *         The class to inspect
     *
     * @return A class is serializeable by default. Returns false if the given class is marked as NotToBeSerialized
     *
     * @author Christopher Bernjus
     */
    public static boolean isSerializable(Class<?> type) {
        if(type == null) return false;
        NotToBeSerialized annotation = type.getAnnotation(NotToBeSerialized.class);
        return annotation == null || !annotation.value();
    }


    /**
     * @param annotations
     *         The list of field annotations to inspect
     *
     * @return Whether a value has a Signed annotation
     *
     * @author Christopher Bernjus
     */
    public static boolean isSigned(Annotation[] annotations) {
        return Arrays.stream(annotations).anyMatch(annotation -> annotation instanceof Signed);
    }


    /**
     * @param annotations
     *         The list of field annotations to inspect
     *
     * @return Value of BitLength() annotation or -1 if none is specified
     *
     * @author Christopher Bernjus
     */
    public static int bitLength(Annotation[] annotations) {
        return Arrays.stream(annotations)
                     .filter(annotation -> annotation instanceof BitLength)
                     .mapToInt(annotation -> ((BitLength) annotation).value())
                     .findFirst()
                     .orElse(-1);
    }


    /**
     * @param annotations
     *         The list of annotations of the field to inspect
     *
     * @return The specified item type of a serializable list field
     *
     * @author Christopher Bernjus
     */
    public static Class<?> itemType(Annotation[] annotations) {
        return Arrays.stream(annotations)
                     .filter(annotation -> annotation instanceof ItemType)
                     .map(a -> ((ItemType) a).value())
                     .findFirst()
                     .orElse(null);
    }


    /**
     * @param annotations
     *         The list of field annotations to inspect
     * @param serializedFields
     *         The map of all previously serialized fields and their values
     *
     * @return Whether all conditions are statisfied
     *
     * @author Christopher Bernjus
     */
    public static boolean allConditionsStatisfied(Annotation[] annotations, Map<String, Object> serializedFields) {
        return Arrays.stream(annotations).allMatch(annotation -> conditionIsStatisfied(annotation, serializedFields));
    }


    /**
     * @param condition
     *         The condition annotation to check
     * @param serializedFields
     *         The map of all previously serialized fields and their values
     *
     * @return Whether the condition is statisfied or the {@code annotation} wasn't a condition
     *
     * @author Christopher Bernjus
     */
    public static boolean conditionIsStatisfied(Annotation condition, Map<String, Object> serializedFields) {

        if(condition instanceof NotToBeSerialized) return false;

        if(condition instanceof DependsOn) {
            String fieldName = ((DependsOn) condition).value();

            // check dependency
            return serializedFields.containsKey(fieldName);
        }

        if(condition instanceof IfTrue) {
            String fieldName = ((IfTrue) condition).value();

            // check dependency
            if(!serializedFields.containsKey(fieldName)) return false;

            // check type and value
            Object value = serializedFields.get(fieldName);
            if(!(value instanceof Boolean)) return false;
            return (Boolean) value;
        }

        if(condition instanceof IfFalse) {
            String fieldName = ((IfFalse) condition).value();

            // check dependency
            if(!serializedFields.containsKey(fieldName)) return false;

            // check type and value
            Object value = serializedFields.get(fieldName);
            if(!(value instanceof Boolean)) return false;
            return !((Boolean) value).booleanValue();
        }

        if(condition instanceof IfEqual) {
            String fieldName = ((IfEqual) condition).field();
            int refValue = ((IfEqual) condition).value();

            // check dependency
            if(!serializedFields.containsKey(fieldName)) return false;

            // check type and value
            Object value = serializedFields.get(fieldName);
            if(!(value instanceof Integer)) return false;
            return ((Integer) value) == refValue;
        }

        if(condition instanceof IfNotEqual) {
            String fieldName = ((IfNotEqual) condition).field();
            int refValue = ((IfNotEqual) condition).value();

            // check dependency
            if(!serializedFields.containsKey(fieldName)) return false;

            // check type and value
            Object value = serializedFields.get(fieldName);
            if(!(value instanceof Integer)) return false;
            return ((Integer) value) != refValue;
        }

        if(condition instanceof IfOneOf) {
            String fieldName = ((IfOneOf) condition).field();
            int[] refValues = ((IfOneOf) condition).values();

            // check dependency
            if(!serializedFields.containsKey(fieldName)) return false;

            // check type and value
            Object value = serializedFields.get(fieldName);
            if(!(value instanceof Integer)) return false;
            boolean match = false;
            for(int refValue : refValues) {
                if(((Integer) value) != refValue) continue;
                match = true;
                break;
            }
            return match;
        }

        return true;

    }

}
