// main class we need to see and make

class Computer {

    private  String cpu;
    private  int ram;

    private  int storage;
    private  boolean graphicsCard;
    private  boolean bluetooth;

    public Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.bluetooth = builder.bluetooth;
    }

}

// now we create the builder function
public class Builder {

    // instantiation of the same variables
    private  String cpu;
    private  int ram;

    // Optional (default values)
    private int storage = 256;
    private boolean graphicsCard = false;
    private boolean bluetooth = false;



    public Builder cpu(String cpu){
        this.cpu = cpu;
        return this;
    }

    public Builder ram(int ram){
        this.ram = ram;
        return this;
    }

    public Builder storage(int storage) {
        this.storage = storage;
        return this;
    }

    public Builder graphicsCard(boolean value) {
        this.graphicsCard = value;
        return this;
    }

    public Builder bluetooth(boolean value) {
        this.bluetooth = value;
        return this;
    }

    public Computer build(){
        return new Computer(this);
    }

}
