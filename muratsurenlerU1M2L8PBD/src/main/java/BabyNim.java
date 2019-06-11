import java.util.Scanner;

public class BabyNim {
    public static void main(String[] args) {

        Scanner myScan = new Scanner(System.in);

        // create the sample to choose from
        System.out.println("A: 3\tB: 3\tC: 3");

        // create variables that store each int
        int a  = 3;
        int b = 3;
        int c = 3;

        // create a while-loop that ask the questions while all ints are greater than 0
        while (a > 0 || b > 0 || c > 0){
            //choose a pile to start your count subtraction
            System.out.print(" Choose a pile: ");
            String pileChosen = myScan.nextLine();
            // create Switch statement for each pile

            switch (pileChosen){
                case "a":
                case "A":
                    System.out.print("How many to remove from pile A: ");
                    //the problem was below
                    int toRemove = Integer.parseInt(myScan.nextLine());
                    a -= toRemove;
                    System.out.println("\n");
                    System.out.format("A: %d\tB: %d\tC: %d",a, b, c);
                    System.out.println("\n");
                    break;
                case "b":
                case "B":
                    System.out.print("How many to remove from pile B: ");
                    toRemove = Integer.parseInt(myScan.nextLine());
                    b-= toRemove;
                    System.out.println("\n");
                    System.out.format("A: %d\tB: %d\tC: %d", a,b,c);
                    System.out.println("\n");
                    break;

                case "c":
                case "C":
                    System.out.print("How many to remove from pile C: ");
                    toRemove = Integer.parseInt(myScan.nextLine());
                    c -= toRemove;
                    System.out.println("\n");
                    System.out.format("A: %d\tB: %d\tC: %d", a,b,c);
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("Choose the correct letter ");
                    break;
            }
        }
        //print a message after all the tiles have emptied out

        System.out.println("All piles are empty. Good job!");
    }
}
