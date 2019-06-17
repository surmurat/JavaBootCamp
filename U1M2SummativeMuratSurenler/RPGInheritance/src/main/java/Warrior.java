public class Warrior extends Character{

    private int shieldStrength;

    public Warrior(String name) {
        super(name, 75, 100, 100, 50, 10);
        this.shieldStrength = shieldStrength;
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    public void decreaseShieldStrength(){}



}
