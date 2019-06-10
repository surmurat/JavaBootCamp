public class Bathroom{

    private double length;
    private double width;
    private double squareFootage;
    private boolean storage;
    private boolean thermostat;
    private boolean heatedFloor;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public boolean isStorage() {
        return storage;
    }

    public void setStorage(boolean storage) {
        this.storage = storage;
    }

    public boolean isThermostat() {
        return thermostat;
    }

    public void setThermostat(boolean thermostat) {
        this.thermostat = thermostat;
    }

    public boolean isHeatedFloor() {
        return heatedFloor;
    }

    public void setHeatedFloor(boolean heatedFloor) {
        this.heatedFloor = heatedFloor;
    }
}
