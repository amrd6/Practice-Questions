public class RuntimePolyMorph {

    public static void main(String[] args) {
        Car c = new Audi();
        c.run();
    }

}

class Car{
    void run(){
        System.out.println("I am car");
    }
}

class Audi extends Car{
    void run(){
        System.out.println("I am audi");
    }
}