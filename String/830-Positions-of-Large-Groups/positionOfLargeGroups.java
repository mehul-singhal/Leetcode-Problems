import java.util.*;
public class positionOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        char[] brokenString = s.toCharArray();
        int count = 1, sIndex = 0, n = brokenString.length;
        for(int i = 1; i<n; i++){
            if(brokenString[i] == brokenString[i-1]){
                count++;
            }
            else{
            if(count >= 3){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(sIndex);
                temp.add(i-1);
                result.add(temp);
            } 
              count = 1;
              sIndex = i;
            }
        }
        if(count >= 3){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(sIndex);
                temp.add(n-1);
                result.add(temp);
        } 
        return result;
    }

    public List<List<Integer>> largeGroupPositionsClean(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int n = s.length(), start = 0;
        for(int i = 1; i<=n ; i++){
            if(i == n || s.charAt(i) != s.charAt(i-1)){
                if(i-start >= 3){
                    result.add(Arrays.asList(start, i-1));
                }
                start = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        positionOfLargeGroups solution = new positionOfLargeGroups();
        // Test case 1:
        String s1 = "abbxxxxzzy";
        System.out.println("Test case 1:");
        System.out.println("Input: " + s1);
        System.out.println("Output (largeGroupPositions): " + solution.largeGroupPositions(s1));
        System.out.println("Output (largeGroupPositionsClean): " + solution.largeGroupPositionsClean(s1));
        // Test case 2:
        String s2 = "abc";
        System.out.println("\nTest case 2:");
        System.out.println("Input: " + s2);
        System.out.println("Output (largeGroupPositions): " + solution.largeGroupPositions(s2));
        System.out.println("Output (largeGroupPositionsClean): " + solution.largeGroupPositionsClean(s2));
        // Test case 3:
        String s3 = "aaaa";
        System.out.println("\nTest case 3:");
        System.out.println("Input: " + s3);
        System.out.println("Output (largeGroupPositions): " + solution.largeGroupPositions(s3));
        System.out.println("Output (largeGroupPositionsClean): " + solution.largeGroupPositionsClean(s3));
    }
}
