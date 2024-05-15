public class containerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int lp = 0; 
        int rp = height.length-1;

        while(lp<rp){
            if((Math.min(height[lp], height[rp])*(rp-lp)) > max){
                max = Math.min(height[lp], height[rp])*(rp-lp);
            }
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
