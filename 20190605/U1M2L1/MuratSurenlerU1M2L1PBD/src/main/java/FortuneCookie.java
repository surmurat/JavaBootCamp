import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {

        Random r = new Random();

        int fortune, n1, n2, n3, n4, n5, n6;

        fortune = 1 + r.nextInt(6);

        if (fortune == 1) {
            System.out.println("Fortune cookie says: \"You will find happiness with a new love.\"");
        } else if (fortune == 2) {
            System.out.println("Fortune cookie says: \"The fortune you seek is in another cookie.\"");
        } else if (fortune == 3) {
            System.out.println("Fortune cookie says: \"If you look back, you'll soon be going that way.\"");
        } else if (fortune == 4) {
            System.out.println("Fortune cookie says: \"We don't know the future, but here's a cookie.\"");
        } else if (fortune == 5) {
            System.out.println("Fortune cookie says: \"Never forget a friend. Especially if he owes you.\"");
        } else if (fortune == 6) {
            System.out.println("Fortune cookie says: \"Some fortune cookies contain no fortune.\"");
        } else {
            System.out.println("nope");
        }

        n1 = 1 + r.nextInt(54);
        n2 = 2 + r.nextInt(54);
        n3 = 3 + r.nextInt(54);
        n4 = 4 + r.nextInt(54);
        n5 = 5 + r.nextInt(54);
        n6 = 6 + r.nextInt(54);

        System.out.println( "\t" + n1 + " - " + n2 + " - " + n3 + " - " + n4 + " - " + n5 + " - " + n6 );

    }

}

