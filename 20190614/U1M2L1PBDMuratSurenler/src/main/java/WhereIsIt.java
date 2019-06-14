import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class WhereIsIt {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 10; i++ ){
            numbers.add(ran());
        }
        System.out.println("Array List: "+ numbers);
        Scanner scan = new Scanner(System.in);
        System.out.print("Value to find: ");
        int num = Integer.parseInt(scan.nextLine());
        System.out.println("\n");

        if(numbers.contains(num)){
            int x = numbers.lastIndexOf(num);
            System.out.format("%d is in slot %d", num, x);
        }else
            System.out.format("%d is not in the ArrayList", num);

    }
    public static Integer ran(){
        Random ran = new Random();
        Integer x = ran.nextInt(50) + 1;
        return x;
    }
    }

