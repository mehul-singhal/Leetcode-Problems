import java.util.*;
public class topKFrequentElements {

    public static int[]  topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length; i++){
            // Get the count for the
            // element if already present in the
            // Map or get the default value which is 0.
            maps.put(nums[i], maps.getOrDefault(nums[i],0)+1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(maps.entrySet());

        // Sort the list
        Collections.sort(
            list,
            new Comparator<Map.Entry<Integer, Integer> >() {
                public int compare(
                    Map.Entry<Integer, Integer> o1,
                    Map.Entry<Integer, Integer> o2)
                {
                    if (o1.getValue() == o2.getValue())
                        return o2.getKey() - o1.getKey();
                    else
                        return o2.getValue()
                            - o1.getValue();
                }
            });

        int[] arry = new int[k];
        for(int i = 0; i<k; i++){
            arry[i] = list.get(i).getKey();
        }

        return arry;
    }
    

    public static  int[] topKFrequentBetter(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
       for (int i : nums)
           map.merge(i, 1, Integer::sum);//For Getting Frequency
       List<Integer> list = new ArrayList<>(map.keySet());
       list.sort((a, b) -> map.get(b) - map.get(a)); //Sort by Frequency in descending order   
       int res[] = new int[k];
       for (int i = 0; i < k; ++i)
           res[i] = list.get(i);
       return res;
   }

   public int[] topKFrequentSmarter(int[] nums, int k) {
    Map<Integer,Integer>map=new HashMap<>();
    for(int i:nums)
    {
        if(map.containsKey(i))
        {
            map.put(i,map.get(i)+1);
        }
        else{
            map.put(i,1);
        }
    }
    List<Integer>list=new ArrayList<>(map.keySet());
    list.sort((a, b) -> map.get(b) - map.get(a));
    int res[] = new int[k];
    for (int i = 0; i < k; ++i)
        res[i] = list.get(i);
    return res;
}

    public static void main(String[] args) {
        int[] temp  = {1,1,1,2,2,3};
        int k = 2;
        int[] answer = topKFrequent(temp, k);
        for(int x : answer){
            System.out.println(x);
        }
    }
}
