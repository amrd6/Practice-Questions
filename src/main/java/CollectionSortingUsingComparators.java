import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CollectionSortingUsingComparators {
    public static void main(String[] args) {
        employee e1 = new employee(1,"ayushi", 30);
        employee e2 = new employee(1,"oldayushi", 40);

        employee[] empList = {e1, e2};
        System.out.println(empList[0].toString());
        System.out.println(empList[1].toString());
        Arrays.sort(empList);
        System.out.println();
        System.out.println(empList[0].toString());
        System.out.println(empList[1].toString());

        Arrays.sort(empList, employee.NameComparator);
        ArrayList<employee> elist = new ArrayList<employee>();
        elist.add(e1);
        elist.add(e2);
        elist.sort(employee.NameComparator);
        System.out.println();
        System.out.println(elist.get(0).toString());
        System.out.println(elist.get(1).toString());
    }


}


class employee implements Comparable<employee>{
    int id;
    int age;
    String name;

    employee(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public int compareTo(employee o) {
        return o.age - this.age;
    }

    public String toString(){
        return name;
    }

    public static Comparator<employee> AgeComparator = new Comparator<employee>() {
        public int compare(employee o1, employee o2) {
            return o2.age - o1.age;
        }
    };

    public static Comparator<employee> NameComparator = new Comparator<employee>() {
        public int compare(employee o1, employee o2) {
            return o1.name.compareTo(o2.name);
        }
    };
}