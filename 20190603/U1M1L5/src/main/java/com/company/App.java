package com.company;

public class App {

    public static int subtract(int a, int b) {

        return (a - b);
    }

    public static int subtractOrZero(int a, int b) {

        int result = a - b;

        if (result < 0) {
            return 0;
        } else {
            return result;
        }

    }

    public static int max(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

    public static int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }

    public static boolean isLarger(int first, int second){
        if(first > second){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args) {

        int s;
        s = subtract(5, 3);
        System.out.println(s);


        int z;
        z = subtractOrZero(6, 5);
        System.out.println(z);

        int m;
        m = max(2, 3, 1);
        System.out.println(m);

        int mn;
        mn = min(5,6,7);
        System.out.println(mn);

        boolean is;
        is = isLarger(5, 7);
        System.out.println(is);



    }

}
