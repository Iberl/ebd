package ebd.messageLibrary.serialization;

import ebd.messageLibrary.message.Telegram;
import ebd.messageLibrary.packet.Packet;
import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.messageLibrary.util.exception.*;
import ebd.messageLibrary.util.Pair;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Class for handling the serialization of Packets
 *
 * @version 2.0
 * @author Christopher Bernjus, Mario Welzig
 */
public abstract class Serializer {

	public static boolean debug = false;

	/**
	 * Converts an instance to a bit stream and returns it in a new BitStreamWriter
	 *
	 * @param object
	 *            The object to serialize
	 *
	 * @return Returns a new {@link BitStreamWriter} with the converted bit stream data
	 *
	 * @throws MissingInformationException
	 * @throws FieldTypeNotSupportedException
	 *
	 * @author Christopher Bernjus
	 */
	public static BitStreamWriter serialize(Object object) throws FieldTypeNotSupportedException, MissingInformationException {
		BitStreamWriter writer = new BitStreamWriter();
		serialize(object, writer);
		return writer;
	}

	/**
	 * Converts an instance to a bit stream using a given BitStreamWriter
	 *
	 * @param object
	 *            The object to serialize
	 * @param writer
	 *            The BitStreamWriter for output of ebd.messageLibrary.serialization
	 *
	 * @throws MissingInformationException
	 * @throws FieldTypeNotSupportedException
	 *
	 * @author Christopher Bernjus
	 */
	public static void serialize(Object object, BitStreamWriter writer) throws MissingInformationException, FieldTypeNotSupportedException {

		// check if object is serialisable
		if(object == null || !isSerializable(object.getClass())) return;

		int numberOfFields = object.getClass().getFields().length;

		// list of fields to be serialized
		Pair<Object, Integer>[] valuesToSerialize = new Pair[numberOfFields];

		// map of all fields which will be serialized
		Map<String, Object> serializedValues = new HashMap<>();

		int length = 0;
		int lengthIndex = -1;

		// iterate over every field in class
		for(Field field : object.getClass().getFields()) {

			// get annotations for field
			Annotation[] annotations = field.getAnnotations();

			// check conditions
			if(!allConditionsStatisfied(annotations, serializedValues)) {
				if(debug) System.err.println(field.getName() + " was skipped");
				continue;
			}

			int index = field.getAnnotation(OrderIndex.class).value();

			try {
				// make pair accessible for serializer
				field.setAccessible(true);

				if(field.getName() == "L_PACKET") {
					lengthIndex = index;
					length += 13;
					continue;
				}

				Object value = field.get(object);
				// TODO: Check if the value was set
				/*if(!valueIsSet(value)) {
					if(field.getAnnotation(CanBeNull.class) != null) continue;
					else {
						throw new MissingInformationException("Missing Information for \"" + field.getName() + "\"");
					}
				}*/
				if(value == null && field.getAnnotation(CanBeNull.class) != null) continue;

				// add pair to map of serialized fields used for checking conditions
				serializedValues.put(field.getName(), value);

				// increment ebd.messageLibrary.packet bit length by field length
				int fieldLength = bitLength(annotations);
				length += fieldLength;

				if(debug) System.out.println(field.getName() + ": " + value + " \t - Index: " + index + " \t - Length:" + fieldLength);

				// add field to array of fields to be serialized
				valuesToSerialize[index] = new Pair<>(value, fieldLength);

			}
			catch (IllegalArgumentException | IllegalAccessException e) {
				if(debug) System.err.println("Unable to read value of field " + field.getName() + ": " + e.getLocalizedMessage());
				e.printStackTrace();
			}
		}

		if(lengthIndex > -1) valuesToSerialize[lengthIndex] = new Pair(length, 13);

		// serialize values
		for(Pair<Object, Integer> pair : valuesToSerialize) {

			if(pair == null) continue;

			Object value       = pair.getKey();
			int    fieldLength = pair.getValue();

			if(value instanceof Boolean) {
				writer.writeBit((Boolean) value);
			}
			else if(value instanceof Integer) {
				writer.writeInt((int) value, (fieldLength >= 0) ? fieldLength : Integer.SIZE);
			}
			else if(value instanceof Long) {
				writer.writeLong((long) value, (fieldLength >= 0) ? fieldLength : Long.SIZE);
			}
			// serialize list
			else if(List.class.isAssignableFrom(value.getClass())) {
				if(((List) value).size() <= 0) {
					writer.writeInt(0, 5);
					continue;
				}

				// write N_ITER value
				writer.writeInt(((List<?>) value).size(), 5);
				for(Object item : (List<?>) value) {
					serialize(item, writer);
				}
			}
			// serialize subclass
			else if(isSerializable(value.getClass())) {
				serialize(value, writer);
			}

			else {
				throw new FieldTypeNotSupportedException("Unsupported field type: " + value.getClass().getTypeName());
			}
		}

	}

	/**
	 * Creates an instance of an Packet from a given buffer
	 *
	 * @param reader
	 *              the bit stream to read from
	 * @param trainToTrack
	 *              indicates whether the bit stream contains a track or train message/packet
	 * @param <T>
	 *              the Class Type of the returned instance
	 *
	 * @return The Class interpretation of the given bit stream
	 *
	 * @throws BitLengthOutOfBoundsException
	 * @throws ClassNotSupportedException
	 * @throws MissingInformationException
	 * @throws ValueNotSupportedException
	 *
	 * @author Christopher Bernjus
	 */
	public static <T> T deserializePacket(BitStreamReader reader, boolean trainToTrack) throws BitLengthOutOfBoundsException, MissingInformationException, ClassNotSupportedException, ValueNotSupportedException {
		// Get ID from Packet or Message
		int id = reader.readInt(8, false);

		// Find Class for Packet ID
		Class<?> clazz = null;
		if(id == 255) {
			try {
				clazz = Class.forName("ebd.messageLibrary.packet.Packet_255");
			} catch (ClassNotFoundException e) {
				throw new ClassNotSupportedException("Could not find the Packet_255 class");
			}
		} else {
			if(trainToTrack) {
				try {
					clazz = Class.forName("ebd.messageLibrary.packet.trainpackets.Packet_" + id);
				} catch (ClassNotFoundException e1) {
					throw new ClassNotSupportedException("Could not find the train message/packet class with ID: \"" + id + "\"");
				}
			} else {
				try {
					clazz = Class.forName("ebd.messageLibrary.packet.trackpackets.Packet_" + id);
				} catch (ClassNotFoundException e1) {
					throw new ClassNotSupportedException("Could not find the track message/packet class with ID: \"" + id + "\"");
				}
			}
		}

		return (T) deserialize(reader, clazz, trainToTrack);
	}

	/**
	 * Creates an instance of an Message from a given buffer
	 *
	 * @param reader
	 *              the bit stream to read from
	 * @param trainToTrack
	 *              indicates whether the bit stream contains a track or train message/packet
	 * @param <T>
	 *              the Class Type of the returned instance
	 *
	 * @return The Class interpretation of the given bit stream
	 *
	 * @throws BitLengthOutOfBoundsException
	 * @throws ClassNotSupportedException
	 * @throws MissingInformationException
	 * @throws ValueNotSupportedException
	 *
	 * @author Christopher Bernjus
	 */
	public static <T> T deserializeMessage(BitStreamReader reader, boolean trainToTrack) throws BitLengthOutOfBoundsException, MissingInformationException, ClassNotSupportedException, ValueNotSupportedException {
		// Get ID from Message
		int id = reader.readInt(8, false);

		// Find Class for Message ID
		Class<?> clazz = null;
		if(trainToTrack) {
			try {
				clazz = Class.forName("ebd.messageLibrary.message.trainmessages.Message_" + id);
			} catch (ClassNotFoundException e) {
				throw new ClassNotSupportedException("Could not find the train message class with ID: \"" + id + "\"");
			}
		} else {
			try {
				clazz = Class.forName("ebd.messageLibrary.message.trackmessages.Message_" + id);
			} catch (ClassNotFoundException e) {
				throw new ClassNotSupportedException("Could not find the track message class with ID: \"" + id + "\"");
			}
		}

		return (T) deserialize(reader, clazz, trainToTrack);
	}

	/**
	 * Creates an instance of an Telegram from a given buffer
	 *
	 * @param reader
	 *              the bit stream to read from
	 * @param <T>
	 *              the Class Type of the returned instance
	 *
	 * @return The Class interpretation of the given bit stream
	 *
	 * @throws BitLengthOutOfBoundsException
	 * @throws ClassNotSupportedException
	 * @throws MissingInformationException
	 * @throws ValueNotSupportedException
	 *
	 * @author Christopher Bernjus
	 */
	public static <T> T deserializeTelegram(BitStreamReader reader) throws BitLengthOutOfBoundsException, MissingInformationException, ClassNotSupportedException, ValueNotSupportedException {
		return (T) deserialize(reader, Telegram.class, false);
	}

	/**
	 * Creates an instance of an given Class Type from a given buffer
	 *
	 * @param reader
	 *              the bit stream to read from
	 * @param type
	 *              the Class Type for the returned instance
	 * @param <T>
	 *              the Class Type of the returned instance
	 * @param trainToTrack
	 *              indicates in which direction the message/packet is sent
	 *
	 * @return The Class interpretation of the given bit stream
	 *
	 * @throws BitLengthOutOfBoundsException
	 * @throws ClassNotSupportedException
	 * @throws MissingInformationException
	 * @throws ValueNotSupportedException
	 *
	 */
	private static <T> T deserialize(BitStreamReader reader, Class<T> type, boolean trainToTrack) throws BitLengthOutOfBoundsException, MissingInformationException, ClassNotSupportedException, ValueNotSupportedException {
		// Get the default Constructor with no parameters
		Constructor<?> constructor = null;
		try {
			constructor = type.getConstructor();
		} catch (NoSuchMethodException e) {
			if(debug) System.err.println("The class type " + type + " doesn't support a default Constructor.");
			e.printStackTrace();
		}

		// Create an instance of the class
		Object instance = null;
		try {
			instance = constructor.newInstance();
		} catch (NullPointerException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			if(debug) System.err.println("Cannot create an instance of given type: " + type);
			e.printStackTrace();
		}

		// create Order of Fields to Deserialize
		int numberOfFields = type.getFields().length;

		Field[] fieldsInOrder = new Field[numberOfFields];


		// Following Code: Simple but uses a sometimes too big array
		for(Field field : type.getFields()) {
			if(field.getAnnotation(NotToBeDeserialized.class) != null) continue;
			int index = field.getAnnotation(OrderIndex.class).value();

			fieldsInOrder[index] = field;

		}

		// Map of deserializedFields
		Map<String, Object> deserializedFields = new HashMap<>();

		// Deserialize Fields in Order
		for(Field field : fieldsInOrder) {

			if(field == null) continue;
			Annotation[] fieldAnnotations = field.getAnnotations();

			// Check whether the field should be serialized
			Annotation[] annotations = field.getAnnotations();
			if(!allConditionsStatisfied(annotations, deserializedFields)) {
				if(debug) System.out.println(field + "wasnt deserialized");
				continue;
			}

			// Deserialize field
			try {
				field.setAccessible(true);

				Object value = field.get(instance);

				if(value instanceof Boolean) {
					value = reader.readBit();

				} else if(value instanceof Integer) {
					int len = bitLength(field.getAnnotations());
					if(len > 32) {
						throw new BitLengthOutOfBoundsException("Invalid bit length (" + len + ") for field " + type.getSimpleName() + "." + field.getName());
					}
					if(len < 0) len = 32;

					value = reader.readInt(len, false);

				} else if(value instanceof Long) {
					int len = bitLength(field.getAnnotations());
					if(len > 64) {
						throw new BitLengthOutOfBoundsException("Invalid bit length (" + len + ") for field " + type.getSimpleName() + "." + field.getName());
					}
					if(len < 0) len = 64;

					value = reader.readLong(len, false);

				} else if(List.class.isAssignableFrom(field.getType())) {
					Class<?> itemType = itemType(fieldAnnotations);
					if(itemType == null) {
						// no item Type specified
						throw new MissingInformationException("No @ItemType information was specified for field " + type.getSimpleName() + "." + field.getName());
					}
					int size = reader.readInt(5, false);
					List<Object> list = new ArrayList<>(size);

					if(Modifier.isAbstract(itemType.getModifiers())) {
						for(int i = 0; i < size; i++) {
							list.add(deserializePacket(reader, trainToTrack));
						}
					} else {
						for(int i = 0; i < size; i++) {
							list.add(deserialize(reader, itemType, trainToTrack));
						}
					}

					value = list;

				} else if(isSerializable(field.getType())) {
					if(Packet.class.isAssignableFrom(field.getType())) {
						value = deserializePacket(reader, trainToTrack);
					} else {
						value = deserialize(reader, field.getType(), trainToTrack);
					}

				} else {
					throw new ValueNotSupportedException("The field " + type.getSimpleName() + "." + field.getName() + " does not match any supported type");
				}

				if(debug && value != null) {
					if(debug) System.out.print("Value: " + value + " \t - Length: ");
					BitLength bitLengthAnnotation = field.getAnnotation(BitLength.class);
					if(bitLengthAnnotation != null && debug) System.out.print(bitLengthAnnotation.value());
					if(debug) System.out.println();
				}

				// Set Value of Field
				field.set(instance, value);

				// Mark Field as deserialized
				deserializedFields.put(field.getName(), value);


			} catch (IllegalArgumentException | IllegalAccessException e) {
				if(debug) System.err.println("Unable to read value of field " + field.getName() + ": " + e.getLocalizedMessage());
				e.printStackTrace();
			}


		}

		return (T) instance;
	}

	/**
	 * @param type
	 *            The class to inspect
	 * @return A class is serializeable by default. Returns false if the given class is marked as NotToBeSerialized
	 * @author Christopher Bernjus
	 */
	public static boolean isSerializable(Class<?> type) {
		NotToBeSerialized annotation = type.getAnnotation(NotToBeSerialized.class);
		return annotation == null || !annotation.value();
	}

	/**
	 * @param annotations
	 *            The list of field annotations to inspect
	 * @return Whether a value has a Signed annotation
	 * @author Christopher Bernjus
	 */
	public static boolean isSigned(Annotation[] annotations) {
		return Arrays.stream(annotations).anyMatch(annotation -> annotation instanceof Signed);
	}

	/**
	 * @param annotations
	 *            The list of field annotations to inspect
	 * @return Value of BitLength() annotation or -1 if none is specified
	 * @author Christopher Bernjus
	 */
	public static int bitLength(Annotation[] annotations) {
		return Arrays.stream(annotations).filter(annotation -> annotation instanceof BitLength).mapToInt(annotation -> ((BitLength) annotation).value()).findFirst().orElse(-1);
	}

	/**
	 * @param annotations
	 *            The list of annotations of the field to inspect
	 * @return The specified item type of a serializable list field
	 * @author Mario Welzig
	 */
	public static Class<?> itemType(Annotation[] annotations) {
		return Arrays.stream(annotations).filter(annotation -> annotation instanceof ItemType).map(a -> ((ItemType) a).value()).findFirst().orElse(null);
	}

	/**
	 * @param value
	 *            The value to inspect
	 * @return Whether the object was set to an value not _NOVALUE
	 * @author Christopher Bernjus
	 */
	//TODO: Maybe implement checking in an other way
	//Check against the default value for variable not type
	public static boolean valueIsSet(Object value) {
		if(value instanceof Boolean && (boolean) value != ETCSVariables.BOOLEAN_NOVALUE) return true;
		if(value instanceof Integer && (int) value != ETCSVariables.INTEGER_NOVALUE) return true;
		//TODO: The only long value could be -255;
		return value instanceof Long && (long) value != ETCSVariables.INTEGER_NOVALUE;
	}

	/**
	 * @param annotations
	 *            The list of field annotations to inspect
	 * @param serializedFields
	 *            The map of all previously serialized fields and their values
	 * @return Whether all conditions are statisfied
	 * @author Christopher Bernjus
	 */
	public static boolean allConditionsStatisfied(Annotation[] annotations, Map<String, Object> serializedFields) {
		return Arrays.stream(annotations).allMatch(annotation -> conditionIsStatisfied(annotation, serializedFields));
	}

	/**
	 * @param condition
	 *            The condition annotation to check
	 * @param serializedFields
	 *            The map of all previously serialized fields and their values
	 * @return Whether the condition is statisfied or the {@code annotation} wasn't a condition
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
			return ((Boolean) value).booleanValue();
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
			int    refValue  = ((IfEqual) condition).value();

			// check dependency
			if(!serializedFields.containsKey(fieldName)) return false;

			// check type and value
			Object value = serializedFields.get(fieldName);
			if(!(value instanceof Integer)) return false;
			return ((Integer) value) == refValue;
		}

		if(condition instanceof IfNotEqual) {
			String fieldName = ((IfNotEqual) condition).field();
			int    refValue  = ((IfNotEqual) condition).value();

			// check dependency
			if(!serializedFields.containsKey(fieldName)) return false;

			// check type and value
			Object value = serializedFields.get(fieldName);
			if(!(value instanceof Integer)) return false;
			return ((Integer) value) != refValue;
		}

		if(condition instanceof IfOneOf) {
			String fieldName = ((IfOneOf) condition).field();
			int[]  refValues = ((IfOneOf) condition).values();

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
