abstract class InterfaceAndAbstractClass {
    public static void main(String[] args) {
        System.out.println("hello");
        InterfaceAndAbstractClass i = new InterfaceAndAbstractClass() {
            @Override
            void needImplementation() {
                System.out.println("I am in main of abstract class");
            }
        };
        i.needImplementation();
    }
    InterfaceAndAbstractClass() {
        System.out.println("I am constructor");
    }
    void run(){
        System.out.println("non-abstract method");
    }

    abstract void needImplementation();
}

interface s {
    void run();
    String a(String s);
}

class useAbstractClass extends InterfaceAndAbstractClass{

    void needImplementation() {
        System.out.println("Thank you for implementing me");
    }
}

class userInterface implements s{

    public void run() {
        System.out.println("I am runing");
    }

    public String a(String s) {
        return "yayee";
    }
}

class mainCLass{
    public static void main(String[] args) {
        InterfaceAndAbstractClass ab = new InterfaceAndAbstractClass() {
            @Override
            void needImplementation() {
                System.out.println("I am one instance of abstract class");
            }
        };

        ab.needImplementation();

        useAbstractClass a = new useAbstractClass();
        a.run();
        a.needImplementation();
        userInterface b = new userInterface();
        b.run();
        System.out.println(b.a(""));
    }
}

class Base {
    static void display() {
        System.out.println("Static or class method from Base");
    }

    public void print() {
        System.out.println("Non-static or instance method from Base");
    }
}
    class Derived extends Base {

     static void display() {
            System.out.println("Static or class method from Derived");
        }

        public void print() {
            System.out.println("Non-static or instance method from Derived");
        }
    }
    class test {
            public static void main(String args[])
            {
                Base obj1= new Derived();
                obj1.display();
                obj1.print();
            }
        }