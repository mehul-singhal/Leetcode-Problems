import java.util.*;
public class maximumSubarray {
    //The most optimal solution for this will be kadence algo
    //The idea is that at every element you see if it's worth keeping in an older subarray or is it better to stop the last 
    //subarray and start a new subarray from here.
    public static int maximumSumOptimal(int[] arr){
        int n = arr.length, currentSum = arr[0], maxSub = arr[0];
        for(int i =1; i<n; i++){
            currentSum = Math.max(currentSum+arr[i], arr[i]);
            maxSub = Math.max(currentSum, maxSub);
        }
        return maxSub;
    }

    public static void maxSubArrayWithPrint(int[] arr) {
        int n = arr.length;
        int currentSum = arr[0];
        int totalSum = arr[0];
        int start = 0, resEnd = 0, resStart = 0;
        for(int i = 1; i<n; i++){
            // currentSum = Math.max((arr[i]+currentSum),arr[i]);
            // totalSum = Math.max(currentSum, totalSum);
            if(currentSum+arr[i] > arr[i]){
                currentSum += arr[i];
            }
            else {
                start = i;
                currentSum = arr[i];
            }

            if(currentSum > totalSum){
                totalSum = currentSum;
                resStart = start; 
                resEnd = i;
            }
        }

        for(int i = resStart; i<=resEnd; i++){
            System.out.println(arr[i]);
        }   
    }
    
    public static void main(String[] args) {
    int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int maxSum = maximumSumOptimal(arr);
    System.out.println("Maximum Subarray Sum: " + maxSum);
    
    System.out.println("Maximum Subarray Elements:");
    maxSubArrayWithPrint(arr);
}
}
