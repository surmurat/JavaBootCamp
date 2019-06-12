import java.util.HashSet;

public class PrintSet {
    public static void main(String[] args) {


        HashSet<Integer> h = new HashSet<Integer>();

        h.add(5);
        h.add(1);
        h.add(2);
        h.add(1);
        h.add(4);
        h.add(1);
        h.add(5);

        for(Integer Hset : h){
            System.out.println("Map Values " + Hset);
        }

    }
}
