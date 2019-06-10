import java.util.Arrays;

public class ArrayFunReverseIt {




    public static void reverse(int[] arr){
        int[] B =new int[arr.length];

        for(int i=0; i<arr.length; i++){
            B[arr.length - 1 -i]=arr[i];
        }

        for(int i=0; i<arr.length; i++){
            arr[i]=B[i];
        }
    }



    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));



    }
}
