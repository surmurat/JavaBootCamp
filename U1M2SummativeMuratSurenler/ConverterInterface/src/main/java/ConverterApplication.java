public class ConverterApplication {





    public static void main(String[] args) {
        ConverterSwitch mySwitch = new ConverterSwitch();

        System.out.println(mySwitch.convertDay(5));
        System.out.println(mySwitch.convertMonth(5));

        ConverterIf myIf = new ConverterIf();

        System.out.println(myIf.convertDay(3));
        System.out.println(myIf.convertMonth(3));




    }
}
