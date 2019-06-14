import java.util.ArrayList;
import java.util.Random;

public class CopyingArrayLists {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(10);
        ArrayList<Integer> arr1 = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            arr.add(rundam());
            System.out.println(arr.get(i));
            arr1.add(arr.get(i));
        }

        arr.remove(arr.size()-1);
        arr.add(-7);
        System.out.println("First array is " + arr);
        System.out.println("Second array is " + arr1);
    }


    public static int rundam() {
        Random rnd = new Random();
        int m = rnd.nextInt(100) + 1;
        return m;
    }

}
