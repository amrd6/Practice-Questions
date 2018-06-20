import java.util.HashMap;
import java.util.Iterator;

public final class FinalClassExample {
    private final String name;

    String getName() {
        return name;
    }

    int getId() {
        return id;
    }

    HashMap<Integer, String> getTestMap() {
        return (HashMap<Integer, String>) testMap.clone();
    }

    private final int id;
    private final HashMap<Integer, String> testMap;

    FinalClassExample(String name, int id, HashMap<Integer, String> hm){
        this.name = name;
        this.id = id;
        HashMap<Integer,String> testMap = new HashMap<Integer, String>();
        Iterator<Integer> it = hm.keySet().iterator();
        while(((Iterator) it).hasNext()){
            int key = it.next();
            testMap.put(key, hm.get(key));
        }
        this.testMap = testMap;
    }
}

