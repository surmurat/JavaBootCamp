public class Memory{

    private String brand;
    private String type;
    private String formFactor;
    private int speed;
    private int capacity;

    public Memory(String brand,String type,String formFactor,int speed,int capacity){
        this.brand=brand;
        this.type=type;
        this.formFactor=formFactor;
        this.speed=speed;
        this.capacity=capacity;

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
