public class CompositionInJava {
    private superClass a ;
    CompositionInJava(superClass a){
        this.a = a;
    }
    public void doSomething(){
        a.doSomething();
    }

    public static void main(String[] args) {
        superClass a = new A();
        superClass b = new B();
        CompositionInJava c1 = new CompositionInJava(a);
        c1.doSomething();
        CompositionInJava c2 = new CompositionInJava(b);
        c2.doSomething();
    }
}

class superClass{
    public void doSomething(){
        System.out.println("I am super class");
    }
}

class A extends  superClass{
    public  void doSomething(){
        System.out.println("I am A");
    }
}

class B extends  superClass{
    public  void doSomething(){
        System.out.println("I am B");
    }
}

