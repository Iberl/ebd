package de.ibw.util;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultRepo<K, V> {

    private ConcurrentHashMap<K, V> repo = new ConcurrentHashMap<K, V>();

    public void update(K key, V mapValue) {
        this.repo.put(key, mapValue);
    }

    public V getModel(K key) {
        return this.repo.get(key);
    }
    public void removeKey(K key) {
        this.repo.remove(key);
    }
    public Collection<V> getAll() {
        return this.repo.values();
    }
    public boolean containsKey(K Key) {
        return this.repo.containsKey(Key);
    }
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
