import java.util.*;

public class twoSum {
    public int[] twoSum1(int[] nums, int target){
        int n = nums.length;
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<n;i++){
            map.put(nums[i],i);
        }

        for(int i = 0;i<n;i++){
            if(map.get(target - nums[i]) != null && map.get(target - nums[i]) != i){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
        }

        return res; 
    }

    public int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> hold = new HashMap<Integer, Integer>();
        for(int i  = 0; i<nums.length; i++){
            if(hold.containsKey(target - nums[i]) && hold.get(target-nums[i]) != i){
                return new int[] {hold.get(target-nums[i]),i};
        }
        hold.put(nums[i],i);
        }
        return null;
    }

    public int[] twoSum3(int[] nums, int target){
        //This is on2 solution don't use this
        //just a glorified brute force
        for(int i = 1;i<nums.length;i++){
            for(int j = i; j<nums.length;j++){
                if(nums[i] + nums[j-1] == target){
                    return new int[] {j,j-1};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        twoSum ts = new twoSum();
        int[] res = ts.twoSum1(nums, target);
        int[] res1 = ts.twoSum2(nums, target);
        int[] res2 = ts.twoSum3(nums, target);
        for(int i = 0; i<res.length;i++){
            System.out.println(res[i]);
        }
        for(int i = 0;i<res1.length; i++){
            System.out.println(res1[i]);
        }
        for(int i = 0;i<res2.length; i++){
            System.out.println(res2[i]);
        }
    }
}
