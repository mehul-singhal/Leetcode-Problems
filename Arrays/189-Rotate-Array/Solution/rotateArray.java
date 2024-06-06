public class rotateArray {
    public void rotateBest(int[] nums, int k) {
        k %= nums.length;
        //This is the reversal Algorithm
        //This if for left rotation
        reverseArray(nums, 0, nums.length-1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, nums.length-1);
        //For right rotation
        //First reverse the complete array
        //Then reverse the array from 0 to k-1
        //Then reverse the array from 0 to n-1
    }

    public void reverseArray(int[] x, int start, int end){
        int temp = 0;
        while(start<end){
            temp = x[end];
            x[end] = x[start];
            x[start] = temp;
            start++;
            end--;
        }
    }

    public void rotateWithExtraSpace(int[] nums, int k) {
        k = k%nums.length;

        if(k == 0){
            return;
        }

        int[] temp = new int[k];
        for(int i = 0; i<k; i++){
            temp[i] = nums[nums.length-k+i];
        }
        for(int i = nums.length-1-k; i>=0;i--){
            nums[i+k] = nums[i];
        }
        for(int i = 0; i<k; i++){
            nums[i] = temp[i];
        }

    }

    public static void main(String[] args) {
        rotateArray rr = new rotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println("Original array: ");
        for(int num : nums){
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Using rotateBest function
        System.out.println("Rotated array using rotateBest function: ");
        rr.rotateBest(nums, k);
        for(int num : nums){
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Reset the array
        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        
        // Using rotateWithExtraSpace function
        System.out.println("Rotated array using rotateWithExtraSpace function: ");
        rr.rotateWithExtraSpace(nums, k);
        for(int num : nums){
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
