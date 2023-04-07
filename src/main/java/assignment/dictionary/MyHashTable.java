package assignment.dictionary;

/*

 */

//
import java.util.*;
import java.io.*;
import java.util.Dictionary;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.BiFunction;

/**

 */
public class MyHashTable<K,V>
//        extends Dictionary<K,V>
//        implements Map<K,V>, Cloneable, java.io.Serializable {
{
    // Hash table
    private ArrayList<Entry<K, V>> table;

    // Hash table Size
    private int size;

    // Hash table load factor
    private float loadFactor;

    // number of entries in hash table
    private int count;

    // number of entries present to trigger rehash; threshold = size * loadFactor
    private int threshold;

    // Entry class holds key-value pairs
    class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // constructor
    public MyHashTable() {
        this.size = 101;    // may change to 11
        this.loadFactor = 0.75f;
        this.count = 0;
        threshold = (int)(size * loadFactor);
        table = new ArrayList<>(size);

        // fill arrayList with null
        for(int i = 0; i < size; i++) {
            table.add(i, null);
        }
//        System.out.println("Size: " + table.toArray().length);
//        for(int i = 0; i < size; i++) {
//            System.out.println(table.get(i));
//        }
    }

    public int hashFunction(K key) {
//        System.out.println(key.hashCode() + " % " + size + " = " + key.hashCode() % size);
        return Math.abs(key.hashCode() % size);
    }

    // WIP
    protected void rehash() {
        System.out.println("rehash started");
        int oldCap = table.toArray().length;
        ArrayList<Entry<K, V>> oldTable = table;    // save old table

        size = 2 * size;    // double size
        threshold = (int)(size * loadFactor);
        ArrayList<Entry<K, V>> newTable = new ArrayList<>(size);

//        for (int i = 0; i < oldCap; i++) {
//            while()
//        }

        System.out.println("rehash ended");
    }

    public V put(K key, V value) {
        // throws exception if key or value is empty
        if (key == null) {
            throw new NullPointerException("key is null");
        } else if (value == null) {
            throw new NullPointerException("value is null");
        }

        // if table is getting full, expand it
//        if(count >= threshold) {
//            rehash();
//        }
//        System.out.println(key);

        int hash = hashFunction(key);   // get hash index
        System.out.println("Put key=" + key + " in " + hash);
        Entry<K, V> newEntry = new Entry<K, V>(key, value); // create new entry
//        System.out.println(newEntry.key + " " + newEntry.value);
//        System.out.println("here");
        table.add(hash, newEntry);  // add entry at hash index
        count++;    // update counter

//        Iterator<Entry<K, V>> it = table.iterator();
//        System.out.println("--------");
//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }

        return null;
    }

    public V remove(K key) {return null;}

    public V get(K key) {return null;}

    public boolean containsKey(Object key) {return true;}

    public Set<K> keySet() {return null;}

    public Collection<V> values() {return null;}

    public boolean isEmpty() {return true;}

    public int size() {return 0;}

    public void clear() {}

}


