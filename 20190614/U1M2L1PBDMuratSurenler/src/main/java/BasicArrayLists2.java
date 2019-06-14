import java.util.ArrayList;
import java.util.Random;

public class BasicArrayLists2 {

    public static void main(String[] args) {

        ArrayList<Integer> myArr = new ArrayList<Integer>();
        for(int i=1; i<=10; i++){
            myArr.add(getNumbers());

        }System.out.println("ArrayList: "+ myArr);
    }
    public static int getNumbers(){
        Random r = new Random();
        int x = 1+r.nextInt(100);
        return x;
    }
}
