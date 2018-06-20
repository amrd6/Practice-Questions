import java.util.HashMap;

public class testFinalClass{
    public static void main(String[] args) {
        int id = 10;
        String name = "ayushi";
        HashMap<Integer,String> hm = new HashMap<Integer, String>();
        hm.put(1,"ayushi");
        hm.put(2,"anupam");
        FinalClassExample f = new FinalClassExample(name,id,hm);
        System.out.println(f.getId());
        System.out.println(f.getId()==id);
        System.out.println(f.getName());
        System.out.println(f.getName()==name);
        System.out.println(f.getTestMap());
        System.out.println(f.getTestMap()==hm);
    }
}
