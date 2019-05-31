import java.util.Random;

public class RandomClass {

    public static void main(String[] args) {
        Random random = new Random();

        for(int i = 0; i < 10; i++){
            int rollValue = random.nextInt(4) +1;
            System.out.println(rollValue);
        }
    }
}
