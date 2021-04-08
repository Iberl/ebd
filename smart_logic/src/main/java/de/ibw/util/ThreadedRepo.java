package de.ibw.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Ein Threadsicheres DefaultRepo
 * Ein Repository
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.5
 * @since 2021-04-06
 */
public class ThreadedRepo<K, V> extends DefaultRepo<K, V> {

    private volatile DefaultRepo<K,V>  repo;

    /**
     * Intialisiert dieses Reposiotory
     */
    public ThreadedRepo() {
        super();
        repo = new DefaultRepo<K, V>();

    }

    public ThreadedRepo(DefaultRepo<K, V> r) {
        super(r.repo);
        this.repo = r;
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

    @Override
    public synchronized ArrayList<K> getKeys() {
        return repo.getKeys();
    }

    @Override
    public boolean containsKey(K Key) {
        return repo.containsKey(Key);
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


    /**
     * Sortiert dieses Reposiotry nach den Keys der Hashmap
     */
    @Override
    public synchronized List<V> sortValues() {
        return repo.sortValues();
    }


    @Override
    /**
     * Klont den Inhalt dieses Repositories ( Nützlich um nur Kopien wiederzugeben, sodass die eigentlichen Inhalte
     * readonly bleiben )
     */
    public Object clone() throws CloneNotSupportedException {
         super.clone();
         DefaultRepo<K, V> cloned = (DefaultRepo<K, V>) repo.clone();
         return new ThreadedRepo<K, V>(cloned);


    }
}
