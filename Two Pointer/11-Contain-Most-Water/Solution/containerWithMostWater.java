public class containerWithMostWater {
    public int maxArea(int[] height) {
        //This is classic two pointer question
        //The thought process is basically
        //To find a pair of values which multiplied by the distance b/w them is maximum
        int max = 0;
        //Starting the left side pointer
        int lp = 0;
        //Starting the right side pointer 
        int rp = height.length-1;

        //Traversing to meet the pointers in the middle
        while(lp<rp){
            //Checking which among left and right pointer value is less
            //Multiplying the min value with the distance b/w these two values
            //Now checking if the new value in each iteration is more than the already set max value.
            if((Math.min(height[lp], height[rp])*(rp-lp)) > max){
                max = Math.min(height[lp], height[rp])*(rp-lp);
            }
            //The pointer with less value moves to the next one.
            if(height[lp]<height[rp]){
                lp++;
            }else{
                rp--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        containerWithMostWater c = new containerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(c.maxArea(height));
    }
}
