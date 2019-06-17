public class iceCreamShop extends Center{

    private int numberOfScoop;
    private String cookies;
    private String sprinkler;
    private String typeOfFruit;

    public iceCreamShop(String bulk, String flavor, String iceCreamCake, String cone, int numberOfScoop, String cookies, String sprinkler, String typeOfFruit) {
        super(bulk, flavor, iceCreamCake, cone);
        this.numberOfScoop = numberOfScoop;
        this.cookies = cookies;
        this.sprinkler = sprinkler;
        this.typeOfFruit = typeOfFruit;
    }

    public int getNumberOfScoop() {
        return numberOfScoop;
    }

    public void setNumberOfScoop(int numberOfScoop) {
        this.numberOfScoop = numberOfScoop;
    }

    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    public String getSprinkler() {
        return sprinkler;
    }

    public void setSprinkler(String sprinkler) {
        this.sprinkler = sprinkler;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public void setTypeOfFruit(String typeOfFruit) {
        this.typeOfFruit = typeOfFruit;
    }
}
