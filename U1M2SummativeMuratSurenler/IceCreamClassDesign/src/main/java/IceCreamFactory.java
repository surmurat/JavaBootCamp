public class IceCreamFactory extends Center{

    private String typeOfMilk;

    public IceCreamFactory(String bulk, String flavor, String iceCreamCake, String cone, String typeOfMilk) {
        super(bulk, flavor, iceCreamCake, cone);
        this.typeOfMilk = typeOfMilk;
    }

    public String getTypeOfMilk() {
        return typeOfMilk;
    }

    public void setTypeOfMilk(String typeOfMilk) {
        this.typeOfMilk = typeOfMilk;
    }
}
