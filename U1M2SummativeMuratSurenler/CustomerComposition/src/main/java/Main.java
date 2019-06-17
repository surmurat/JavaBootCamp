public class Main {
    public static void main(String[] args) {


        Address shipAddress = new Address("Heller", "Newark", "Union city", "NJ","11112");
        Address billAddress = new Address("Jefferson", "Bridgewater", "Union", "Nj","22222");
        Customer customer1 = new Customer("James", "James", "jame@james.com", 97340549, shipAddress, billAddress,true);
        billAddress.getCity();
    }

}

