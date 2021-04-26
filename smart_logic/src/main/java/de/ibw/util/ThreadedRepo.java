package de.ibw.util;

import java.util.*;
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



    /**
     * Intialisiert dieses Reposiotory
     */
    public ThreadedRepo() {
        super();


    }

    public ThreadedRepo(DefaultRepo<K, V> r) {
        super(r.repo);

    }

    /**
     * Gibt zu einem Key einen Wert in die HashMap zu.
     * Wenn der Key schon existiert, wird dieser &Uuml;berschrieben
     * @param key K - Ein Key-Object
     * @param mapValue V - Das Value-Object
     */
    @Override
    public synchronized void update(K key, V mapValue) {
        if(mapValue == null) return;
        this.repo.compute(key, (k,v)-> mapValue);
    }

    @Override
    public synchronized ArrayList<K> getKeys() {
        return new ArrayList<K>(this.repo.keySet());
    }

    @Override
    public synchronized boolean containsKey(K Key) {
        return repo.containsKey(Key);
    }

    /**
     * Holt zum key den Wert
     * @param key K - Ein Key-Object
     * @return V - Das Value-Object
     */
    @Override
    public synchronized V getModel(K key) {
        if(key == null) return null;
        return this.repo.get(key);
    }

    /**
     * Enfernt Value mit dem Key beides wird entfernt
     * @param key K - Ein Key-Object
     */
    @Override
    public synchronized void removeKey(K key) {
        this.repo.remove(key);
    }

    /**
     * Gibt alle Values dieses Repositories ohne Keys wider
     * @return Collection - Alle Werte
     */
    @Override
    public synchronized Collection<V> getAll() {
        return this.repo.values();
    }

    public synchronized void setInitial(ConcurrentHashMap<K,V> initRepo) {
        this.repo = initRepo;
    }

    /**
     * Sortiert dieses Reposiotry nach den Keys der Hashmap
     */
    @Override
    public synchronized List<V> sortValues() {
        SortedSet<K> keys = new TreeSet<K>(repo.keySet());
        ArrayList<V> result = new ArrayList<>();
        for (K key : keys) {
            result.add(repo.get(key));
            // do something
        }
        return result;
    }


    @Override
    /**
     * Klont den Inhalt dieses Repositories ( Nützlich um nur Kopien wiederzugeben, sodass die eigentlichen Inhalte
     * readonly bleiben )
     */
    public Object clone() throws CloneNotSupportedException {
         super.clone();
         ThreadedRepo<K,V> clone = new ThreadedRepo<>();
         clone.setInitial(this.repo);;

         return clone;


    }
}
