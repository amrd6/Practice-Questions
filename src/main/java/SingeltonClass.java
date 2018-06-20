import java.io.Serializable;
import java.lang.reflect.Constructor;
//Good option but not thread safe
class LazySingeltonClass {
    private static LazySingeltonClass instance = null;
    private LazySingeltonClass(){}

    public static LazySingeltonClass getInstance(){
        if(instance==null){
            instance = new LazySingeltonClass();
        }
        return instance;
    }
}


//eager initialization: Not Good
class egarSingeltonClass {
    private static egarSingeltonClass instance = new egarSingeltonClass();

    private egarSingeltonClass(){};

    public static egarSingeltonClass getInstance(){
        return instance;
    }
}

//Eager initialization with static block along with exception handling
class StaticBlockSingeltonClass {
    private static StaticBlockSingeltonClass instance = null;

    static {
        try {
            instance = new StaticBlockSingeltonClass();
        } catch(Exception e) {

        }
    }
    private StaticBlockSingeltonClass(){};

    public static StaticBlockSingeltonClass getInstance(){
        return instance;
    }
}

//slow but thread safe
class ThreadSafeSingelton{
    private static ThreadSafeSingelton instance = null;
    private ThreadSafeSingelton(){}

    public synchronized static ThreadSafeSingelton getInstance(){
        if(instance==null){
            instance = new ThreadSafeSingelton();
        }
        return instance;
    }
}

//double checked locking Thread safe
class DoubleLockSingelton {
    private static DoubleLockSingelton instance = null;
    private DoubleLockSingelton(){}

    public static DoubleLockSingelton getInstance(){
        if(instance==null){
            synchronized (DoubleLockSingelton.class) {
                if (instance == null) {
                    instance = new DoubleLockSingelton();
                }
            }
        }
        return instance;
    }
}


//Bill Pugh Singleton: doesnt require synchronization.
//inner class is loaded in memory only when getInstance is called
class BillPugh{
    private  static BillPugh instance;
    private BillPugh(){}

    private static class innerclass {
        private static final BillPugh instance = new BillPugh();
    }

    public static BillPugh getInstance(){
        return innerclass.instance;
    }
}

//Reflection to destroy Singleton
class usingReflection{
    public static void main(String[] args) {
        egarSingeltonClass e1 = egarSingeltonClass.getInstance();
        egarSingeltonClass e2 = null;
        try {
            Constructor[] constructors = egarSingeltonClass.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                e2 = (egarSingeltonClass) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
    }
}

class SerializedSingleton implements Serializable {
    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton(){}

    private static class SingletonHelper{
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance(){
        return SingletonHelper.instance;
    }
}
