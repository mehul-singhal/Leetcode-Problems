import java.util.*;
public class missingNumber {
    public static int findMissingBasic(int[] arr){
        Arrays.sort(arr);
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != i) return i;
        }
        return arr.length+1;
    }

    public static int findMissingBetter(int[] arr){
        //The idea here is that I have a sequence of numbers from zero in which a number is missing
        //So I can find the summation of all the sequence and then subtract summation of the given sequence from it
        int n = arr.length, n1 = n*(n+1)/2, n2 = 0;
        for(int x: arr){
            n2 += x;
        }
        return n1-n2;
    }

    public static int findMissingBest(int[] arr){
       //The idea is the same here but rather than using the summation property we are using xor operator
       //property used -> a^a = 0 & 0^a = a
       int n = arr.length, xor1 = 0, xor2 = 0;
       for(int i = 0; i<n; i++){
            xor1 ^= i;
            xor2 ^= arr[i];
       }
       xor1 ^= n; 
       return xor1 ^ xor2; 
    }

    public static void main(String[] args) {
        // Test array
    int[] arr = {0, 1, 2, 4};
    // Find missing number using basic method
    int missingBasic = findMissingBasic(arr);
    System.out.println("Missing number (Basic): " + missingBasic);
    // Find missing number using better method
    int missingBetter = findMissingBetter(arr);
    System.out.println("Missing number (Better): " + missingBetter);
    // Find missing number using best method
    int missingBest = findMissingBest(arr);
    System.out.println("Missing number (Best): " + missingBest);
    }
}
