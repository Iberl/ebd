package de.ibw.util;

import java.util.Collection;

public class ThreadedRepo<K, V> extends DefaultRepo<K, V> {

    private volatile DefaultRepo<K,V>  repo;

    public ThreadedRepo() {
        repo = new DefaultRepo<K, V>();

    }

    @Override
    public synchronized void update(K key, V mapValue) {
        repo.update(key, mapValue);
    }

    @Override
    public synchronized V getModel(K key) {
        return repo.getModel(key);
    }

    @Override
    public synchronized void removeKey(K key) {
        repo.removeKey(key);
    }

    @Override
    public synchronized Collection<V> getAll() {
        return repo.getAll();
    }
}
