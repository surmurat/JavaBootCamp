public class Address {

    private String Street1;
    private String Street2;
    private String City;
    private String State;
    private String Zip;

    public Address(String street1, String street2, String city, String state, String zip) {
        Street1 = street1;
        Street2 = street2;
        City = city;
        State = state;
        Zip = zip;
    }

    public String getStreet1() {
        return Street1;
    }

    public void setStreet1(String street1) {
        Street1 = street1;
    }

    public String getStreet2() {
        return Street2;
    }

    public void setStreet2(String street2) {
        Street2 = street2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        Zip = zip;
    }
}

