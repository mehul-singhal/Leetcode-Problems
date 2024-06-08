public class moveZeroes {
    public void moveZeroesBest(int[] nums) {
        int count = 0;
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[count];
                nums[count] = temp;
                count++;
            }
        }
    }

    public static void main(String[] args) {
        moveZeroes mz = new moveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("Original array: " + java.util.Arrays.toString(nums));
        mz.moveZeroesBest(nums);
        System.out.println("Array after moving zeroes: " + java.util.Arrays.toString(nums));
    }
}
