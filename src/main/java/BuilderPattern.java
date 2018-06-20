public class BuilderPattern {
    public static void main(String[] args) {
        Computers c = new Computers.ComputerBuilder("type","ram").setOptional("optional").build();
        System.out.println(c.getOptional());
        System.out.println(c.getRam());
        System.out.println(c.getType());
    }
}

class Computers{
    public String getType() {
        return type;
    }

    public String getRam() {
        return ram;
    }

    public String getOptional() {
        return optional;
    }

    private String type;
    private String ram;
    private String optional;

    Computers(ComputerBuilder cb){
        this.type = cb.type;
        this.ram = cb.ram;
        this.optional = cb.optional;
    }

    public  static class ComputerBuilder{
        private String type;
        private String ram;
        private String optional;


        ComputerBuilder(String type, String ram){
            this.type = type;
            this.ram = ram;
        }

        ComputerBuilder setOptional(String option){
            this.optional = option;
            return this;
        }

        public Computers build(){
            return new Computers(this);
        }
    }
}
