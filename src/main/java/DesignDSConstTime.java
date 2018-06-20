import java.util.HashMap;

/*
Design a data structure that supports insert, delete, search and getRandom in constant time
Design a data structure that supports following operations in Θ(1) time.

insert(x): Inserts an item x to the data structure if not already present.

remove(x): Removes an item x from the data structure if present.

search(x): Searches an item x in the data structure.

getRandom(): Returns a random element from current set of elements
 */
public class DesignDSConstTime<K,V> {

    class Entry{
        K key;
        V value;
        Entry next;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }
//
//    private V getForNullKey() {
//        if (size == 0) {
//            return null;
//        }
//        for (Entry e = table[0]; e != null; e = e.next) {
//            if (e.key == null)
//                return e.value;
//        }
//        return null;
//    }


}
