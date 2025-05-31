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
}
