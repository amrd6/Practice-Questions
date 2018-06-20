import java.util.HashMap;
import java.util.Iterator;

final class immutableClass {
    final private String name;
    final  private int id;
    final HashMap<String, String > hp;
    immutableClass(String name, int id, HashMap<String, String > hpx){
        this.name = name;
        this.id = id;
        Iterator<String> it = hpx.keySet().iterator();
        this.hp = new HashMap<String, String>();
        while(it.hasNext()){
            String key = it.next();
            hp.put(key, hpx.get(key));
        }
    }

     String getName() {
        return this.name;
    }

     int getId() {
        return this.id;
    }

     HashMap<String, String> getMap(){
        return hp;
    }
}

class testImmutable {
    public static void main(String[] args) {
        int id = 1;
        String name = "ayushi";

        HashMap<String, String> hp = new HashMap<String, String>();
        hp.put("1","ayushi");
        immutableClass a = new immutableClass(name,id,hp);
        System.out.println(a.getId() + " " + a.getName() + " " + a.getMap());
        id = 2;
        name = "ayishii";
        hp.put("2","ayushi1");
        System.out.println(a.getId() + " " + a.getName() + " " + a.getMap());


    }
}