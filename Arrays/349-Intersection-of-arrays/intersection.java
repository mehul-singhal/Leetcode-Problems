import java.util.*;
public class intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(i<n1 && j<n2){
            if(nums1[i] == nums2[j]){
                if(ans.size() == 0 || ans.get(ans.size() - 1) != nums1[i]){
                    ans.add(nums1[i]);
                }
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j])i++;
            else if(nums1[i]>nums2[j])j++;
        }
        int[] result = new int[ans.size()];
        for(int x = 0; x<ans.size(); x++){
            result[x] = ans.get(x);
        }
        return result;
    }

    public int[] intersectionUsingSet(int[] nums1, int[] nums2) {
        HashSet<Integer> first = new HashSet<Integer>();
        HashSet<Integer> resultSet = new HashSet<Integer>();
        int n = nums1.length, m = nums2.length;
        for(int x: nums1){
            first.add(x);
        }
        for(int y: nums2){
            if(first.contains(y)){
                resultSet.add(y);
            }
        }
        int[] result = new int[resultSet.size()];
        int count = 0;
        for(int z: resultSet){
            result[count++] = z;
        }
        return result;
    }

    public int[] intersectionBest(int[] nums1, int[] nums2) {
        int[] counter = new int[1001];
        for(int num : nums1)
        {
            counter[num] = 1;
        }
        int count=0;
        for(int num : nums2)
        {
            if(counter[num] == 1)
            {
                counter[num] = 2;
                count++;
            }
        }
        int[] res = new int[count];
        int ind=0;
        for(int i : nums2)
        {
            if(counter[i] == 2)
            {
                res[ind++] = i;
                counter[i] = 1;
            }
        }
        return res;
        
    }

    public static void main(String args[]){
        intersection obj = new intersection();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = obj.intersection(nums1, nums2);
        
        System.out.println("Intersection of two arrays:");
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
