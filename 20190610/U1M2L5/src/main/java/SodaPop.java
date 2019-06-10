public class SodaPop{

    private String name;
    private int quantity;
    private String[] flavors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String[] getFlavors() {
        return flavors;
    }

    public void setFlavors(String[] flavors) {
        this.flavors = flavors;
    }
    public void info(){
        String nameQuantity = "The name of this Soda is " + getName() +" the quantity available is " + quantity + "chips.";
        System.out.println(nameQuantity);
        for(String element: getFlavors()){
            System.out.format("The Soda is available in this flavor: %s", element);
        }

    }
}
