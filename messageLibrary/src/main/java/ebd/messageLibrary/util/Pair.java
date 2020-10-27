package ebd.messageLibrary.util;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class Modelling A Generic Key-Value Pair
 *
 * @param <K>
 *            {@link Pair#key}
 * @param <V>
 *            {@link Pair#value}
 *
 * @author Christopher Bernjus
 */
public class Pair<K, V> implements Serializable {

    /** Generic Key */
    private K key;

    /** Generic Value */
    private V value;


    // Constructors

    /**
     * Constructs A Generic Key-Value Pair
     *
     * @param key
     *            {@link Pair#key}
     * @param value
     *            {@link Pair#value}
     * @author Christopher Bernjus
     */
    public Pair(K key, V value) {
        super();
        this.key = key;
        this.value = value;
    }


    // Getters and Setters

    /**
     * @return The Key Of The Pair
     * @author Christopher Bernjus
     */
    public K getKey() {
        return key;
    }

    /**
     * @return The Value Of The Pair
     * @author Christopher Bernjus
     */
    public V getValue() {
        return value;
    }


    // Other Functions

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return key.equals(pair.key) &&
                value.equals(pair.value);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
