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
    private ArrayList<ArrayList<Entry<K, V>>> table;

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

        // fill arrayList with an ArrayList
        for(int i = 0; i < size; i++) {
            table.add(i, new ArrayList<Entry<K, V>>());
        }
    }

    public int hashFunction(K key) {

       String string_key =  ((String)key);
       int sum = 0;

       for(int i = 0;i < string_key.length(); i++ )
       {
           sum += ((int)string_key.charAt(i));
       }

       return sum %size;

       /* ArrayList<ArrayList<Entry<K, V>>> arr =table;
        int hash = key.hashCode();

        int arr_index = Integer.parseInt(key) % size; */
        /*
    * //get the values from the array (words)
    * //extract the values from the array
    * //create an index to store the value in by taking its modulus
    *
    * */
    }

    // WIP
//    protected void rehash() {
//        System.out.println("rehash started");
//        int oldCap = table.toArray().length;
//        ArrayList<Entry<K, V>> oldTable = table;    // save old table
//
//        size = 2 * size;    // double size
//        threshold = (int)(size * loadFactor);
//        ArrayList<Entry<K, V>> newTable = new ArrayList<>(size);
//
//        for (int i = 0; i < oldCap; i++) {
//            while()
//        }
//
//        System.out.println("rehash ended");
//    }

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
        Entry<K, V> newEntry = new Entry<K, V>(key, value); // create new entry
        table.get(hash).add(newEntry);  // add entry at hash index
        count++;    // update counter

        // TEST PRINT for hash table
//        for(int i = 0; i < table.toArray().length; i++) {
//            System.out.print(i + ":\t");
//            for(int j = 0; j < table.get(i).toArray().length; j++) {
//                System.out.print(table.get(i).get(j).key + "\t");
//            }
//            System.out.println("");
//        }

//        Iterator<Entry<K, V>> it = table.iterator();
//        System.out.println("--------");
//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }

        return null;
    }

    public V remove(K key) {return null;}

    public V get(K key) {
        //Find the correct bucket that contains the key
        int index = hashFunction(key);
        ArrayList<Entry<K, V>> bucket = table.get(index);

        //Search the bucket for the key
        for(Entry<K, V> item : bucket) {
            if(item.key.equals(key)) {
                return item.value;
            }
        }
        //If the item was not found in the expected bucket:
        return null;
    }

    public boolean containsKey(Object key) {
        //If get returns null, item doesnt exist
        if(get((K)key) == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public Set<K> keySet() {return null;}

    public Collection<V> values() {return null;}

    public boolean isEmpty() {return true;}

    public int size() {return 0;}

    public void clear() {}

}


