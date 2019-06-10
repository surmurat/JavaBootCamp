public class Processor{


    private String brand;
    private double clockSpeed;
    private String type;
    private int numberOfCore;
    private int cache;
    private double baseFrequency;


    public Processor(double clockSpeed,String type,int numberOfCore,int cache,double baseFrequency,String brand){

        this.brand=brand;
        this.clockSpeed=clockSpeed;
        this.type=type;
        this.numberOfCore=numberOfCore;
        this.cache=cache;
        this.baseFrequency=baseFrequency;


    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfCore() {
        return numberOfCore;
    }

    public void setNumberOfCore(int numberOfCore) {
        this.numberOfCore = numberOfCore;
    }

    public int getCache() {
        return cache;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }

    public double getBaseFrequency() {
        return baseFrequency;
    }

    public void setBaseFrequency(double baseFrequency) {
        this.baseFrequency = baseFrequency;
    }
}
