public class Center {

    private String bulk;
    private String flavor;
    private String iceCreamCake;
    private String cone;

    public Center(String bulk, String flavor, String iceCreamCake, String cone) {
        this.bulk = bulk;
        this.flavor = flavor;
        this.iceCreamCake = iceCreamCake;
        this.cone = cone;
    }

    public String getBulk() {
        return bulk;
    }

    public void setBulk(String bulk) {
        this.bulk = bulk;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getIceCreamCake() {
        return iceCreamCake;
    }

    public void setIceCreamCake(String iceCreamCake) {
        this.iceCreamCake = iceCreamCake;
    }

    public String getCone() {
        return cone;
    }

    public void setCone(String cone) {
        this.cone = cone;
    }
}
