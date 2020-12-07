package de.ibw.util;

import java.util.Collection;

/**
 * Ein Threadsicheres DefaultRepo
 * Ein Repository
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.3
 * @since 2020-08-12
 */
public class ThreadedRepo<K, V> extends DefaultRepo<K, V> {

    private volatile DefaultRepo<K,V>  repo;

    /**
     * Intialisiert dieses Reposiotory
     */
    public ThreadedRepo() {
        repo = new DefaultRepo<K, V>();

    }
    /**
     * Gibt zu einem Key einen Wert in die HashMap zu.
     * Wenn der Key schon existiert, wird dieser &Uuml;berschrieben
     * @param key K - Ein Key-Object
     * @param mapValue V - Das Value-Object
     */
    @Override
    public synchronized void update(K key, V mapValue) {
        repo.update(key, mapValue);
    }

    /**
     * Holt zum key den Wert
     * @param key K - Ein Key-Object
     * @return V - Das Value-Object
     */
    @Override
    public synchronized V getModel(K key) {
        return repo.getModel(key);
    }

    /**
     * Enfernt Value mit dem Key beides wird entfernt
     * @param key K - Ein Key-Object
     */
    @Override
    public synchronized void removeKey(K key) {
        repo.removeKey(key);
    }

    /**
     * Gibt alle Values dieses Repositories ohne Keys wider
     * @return Collection - Alle Werte
     */
    @Override
    public synchronized Collection<V> getAll() {
        return repo.getAll();
    }
}