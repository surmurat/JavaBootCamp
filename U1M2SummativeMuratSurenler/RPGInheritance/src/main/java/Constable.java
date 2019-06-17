public class Constable extends Character {

    private String jurisdiction;

    public String getJurisdiction() {
        return jurisdiction;
    }

    public Constable(String name, String jurisdiction) {
        super(name, 60, 100, 60, 20, 5);
        this.jurisdiction = jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public void arrest(){}


}
