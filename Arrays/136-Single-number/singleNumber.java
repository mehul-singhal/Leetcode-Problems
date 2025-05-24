import java.util.*;
public class singleNumber {

    //Other solutions including using a hashmap and a brute force where you can use two loops.

    public static int findSingle(int[] arr){
        int n = arr.length, single = 0;
        for(int i = 0; i<n; i++){
            single ^= arr[i];
        }
        return single;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] arr = {2, 3, 5, 4, 5, 2, 4};
        int single = findSingle(arr);
        System.out.println("The single number is: " + single);
    }
}
