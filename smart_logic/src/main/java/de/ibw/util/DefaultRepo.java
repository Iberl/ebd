package de.ibw.util;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Ein Repository gebaut aus einer Hashmap
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.3
 * @since 2020-08-12
 */
public class DefaultRepo<K, V> {

    private ConcurrentHashMap<K, V> repo = new ConcurrentHashMap<K, V>();

    /**
     * Gibt zu einem Key einen Wert in die HashMap zu.
     * Wenn der Key schon existiert, wird dieser &Uuml;berschrieben
     * @param key K - Ein Key-Object
     * @param mapValue V - Das Value-Object
     */
    public void update(K key, V mapValue) {
        this.repo.put(key, mapValue);
    }

    /**
     * Holt zum key den Wert
     * @param key K - Ein Key-Object
     * @return V - Das Value-Object
     */
    public V getModel(K key) {
        if(key == null) return null;
        return this.repo.get(key);
    }

    public ArrayList<K> getKeys() {
        return new ArrayList<K>(this.repo.keySet());
    }

    /**
     * Enfernt Value mit dem Key beides wird entfernt
     * @param key K - Ein Key-Object
     */
    public void removeKey(K key) {
        this.repo.remove(key);
    }

    /**
     * Gibt alle Values dieses Repositories ohne Keys wider
     * @return Collection - Alle Werte
     */
    public Collection<V> getAll() {
        return this.repo.values();
    }

    /**
     * Sucht ob Key schon in diesem Repository existiert.
     * @param Key K - gesuchter key
     * @return boolean - ist Key gefunden
     */
    public boolean containsKey(K Key) {
        return this.repo.containsKey(Key);
    }

    /**
     * Sortiert diese Repository nach deren Keys und gibt eine Sortierte Liste der Values wider.
     * Diese Liste wurde aber nach den Keys sortiert
     * @return List - Sortierte Values
     */
    public List<V> sortValues() {
        SortedSet<K> keys = new TreeSet<K>(repo.keySet());
        ArrayList<V> result = new ArrayList<>();
        for (K key : keys) {
            result.add(repo.get(key));
            // do something
        }
        return result;
    }
}
