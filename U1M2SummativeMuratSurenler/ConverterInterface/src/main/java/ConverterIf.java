

public class ConverterIf implements Converter{


    public String convertMonth(int monthNumber){

        String months;

        if(monthNumber == 1){
            months ="January";
        }else if (monthNumber ==2){
            months= "February";
        }else if (monthNumber == 3){
            months=  "March";
        }else if (monthNumber == 4){
            months=  "April";
        }else if (monthNumber == 5){
            months=  "May";
        }else if (monthNumber == 6){
            months=  "Jun";
        }else if (monthNumber == 7){
            months=  "July";
        }else if (monthNumber == 8){
            months=  "August";
        }else if (monthNumber == 9){
            months=  "September";
        }else if (monthNumber == 10){
            months=  "October";
        }else if (monthNumber == 11){
            months=  "November";
        }else if (monthNumber == 12){
            months=  "December";
        }else{
            months=  "You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.";
        }
        return months;
    }

    public String convertDay(int dayNumber){

        String days;

        if(dayNumber == 1){
            days = "Monday";
        }else if (dayNumber ==2){
            days =  "Tuesday";
        }else if (dayNumber == 3){
            days =  "Wednesday";
        }else if (dayNumber == 4){
            days =  "Thursday";
        }else if (dayNumber == 5){
            days =  "Friday";
        }else if (dayNumber == 6){
            days =  "Saturday";
        }else if (dayNumber == 7){
            days =  "Sunday";
        }else{
            days =  "You have entered an invalid number. You must enter a number between 1 and 7. Goodbye.";
        }
        return days;


    }
}
