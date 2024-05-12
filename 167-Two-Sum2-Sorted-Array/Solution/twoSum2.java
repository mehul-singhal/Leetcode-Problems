import java.util.*;
public class twoSum2 {

    public int[] twoSumBasic(int[] numbers, int target) {
        Map<Integer, Integer> hold = new HashMap<Integer, Integer>();
        for(int i = 0; i<numbers.length; i++){
            int comp = target - numbers[i];
            if(hold.containsKey(comp) && hold.get(comp) != i){
                return new int[] {hold.get(comp)+1,i+1};
            }
            hold.put(numbers[i],i);
        }
        return null;
    }

    public int[] twoSumTwoPointer(int[] numbers, int target) {
//         Intuition

// The key insight behind the two-pointer approach is to leverage the fact that the input array is already sorted in non-decreasing order. By starting with two pointers, one at the beginning (index 1) and one at the end (index numbers.length), we can efficiently find the two numbers that add up to the target.
// The intuition is that if the sum of the numbers at the current left and right pointers is less than the target, we need to increase the sum, so we move the left pointer to the right. Conversely, if the sum is greater than the target, we need to decrease the sum, so we move the right pointer to the left. We continue this process until we find the two numbers that add up to the target.

// Approach

// Initialize two pointers, left and right, to the first and last indices of the numbers array, respectively.

// While left is less than right:

// Calculate the sum of the numbers at the left and right indices.
// If the sum is equal to the target, return [left + 1, right + 1] (since the problem statement asks for 1-indexed indices).
// If the sum is less than the target, increment the left pointer to increase the sum.
// If the sum is greater than the target, decrement the right pointer to decrease the sum.
// If no solution is found, return an empty array.

// Complexity

// Time complexity:O(n)
// Space complexity:O(1)
        int lp = 0; 
        int rp = numbers.length-1;

        while(lp<rp){
            int answer = numbers[lp]+numbers[rp];
            if(answer == target){
                return new int[] {lp+1, rp+1};
            }
            if(answer<target){
                lp++;
            }
            if(answer>target){
                rp--;
            }
        }
        return null; 
    }

    public static void main(String[] args) {
        twoSum2 obj = new twoSum2();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = obj.twoSumBasic(numbers, target);
        if (result!= null) {
            System.out.println("Two sum basic: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum found");
        }
    
        result = obj.twoSumTwoPointer(numbers, target);
        if (result!= null) {
            System.out.println("Two sum two pointer: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum found");
        }
    }
}
