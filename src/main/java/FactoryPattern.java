public class FactoryPattern {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("pc");
        Computer server = ComputerFactory.getComputer("server");

        System.out.println(pc.getType());
        System.out.println(server.getType());

        Computer pc1 = ComputerFactory.getComputer(new pcFactory("pc1"));
        Computer server2 = ComputerFactory.getComputer(new serverFactory("server1"));

        System.out.println(pc1.getType());
        System.out.println(server2.getType());
    }
}

abstract class  Computer{
    abstract String getType();
    @Override
    public java.lang.String toString() {
        return getType();
    }
}

class PC extends Computer {
    private String type;
    public PC(String type){
        this.type = type;
    }

    @Override
    String getType() {
        return this.type;
    }
}

class Server extends Computer {
    String type;
    public Server(String type){
        this.type = type;
    }
    @Override
    String getType() {
        return this.type;
    }
}

class ComputerFactory {
    static Computer getComputer(String type){
        if(type.equalsIgnoreCase("pc")){
            return new PC(type);
        }else if(type.equalsIgnoreCase("server")){
            return new Server(type);
        }
        return null;
    }

    static Computer getComputer(abstractComputerFactory acf){
        return acf.getComputer();
    }
}

abstract class abstractComputerFactory{
    abstract public Computer getComputer();
}

class pcFactory extends abstractComputerFactory {
private String type;
pcFactory(String type){
    this.type = type;
}
    @Override
    public Computer getComputer() {
        return new PC(type);
    }
}

class serverFactory extends abstractComputerFactory{
    private String type;
    serverFactory(String type){
        this.type = type;
    }
    @Override
    public Computer getComputer() {
        return new Server(type);
    }
}
