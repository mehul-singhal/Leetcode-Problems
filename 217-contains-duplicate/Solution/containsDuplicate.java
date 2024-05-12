import java.util.*;

public class containsDuplicate {
    public boolean containsDuplicateSolution(int[] nums) {
        //Sort the array
        Arrays.sort(nums);
        int n = nums.length;
        //Start the interation from index 1 
        //and keep checking if the index and just before index are same, if yes return true; 
        for(int i = 1 ;i<n ;i++){
            if(nums[i] == nums[i-1]){
                return true;
            }                
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        containsDuplicate cd = new containsDuplicate();
        System.out.println(cd.containsDuplicateSolution(nums));
    }
}
