import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class validAnagram {
    
    //Solution takes too much time and space as it is using 2 maps and is traversing 2 strings and then putting data in the maps
    //After all of this the comparison happens. 
    //This is too slow
    public static boolean isAnagramBasic(String s, String t) {
        if (s.length() != t.length())
        {
             return false;
        }
        else{
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
            } else {
                map1.put(s.charAt(i), 1);
            }

            if (map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
            } else {
                map2.put(t.charAt(i), 1);
            }
        }

        if (map1.equals(map2)) {
            return true;
        }
        else{
            return false;
        }
        }

    }

    //Very smart solution. 
    //Converted strings to array and then sorted the array and compared them, takes very less space in comparison to the first one.
    public static boolean isAnagramBetter(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    //This is the better version fo the basic solution, in this we are only using a single map which reduces the space
    //We traverse both the arrays in the first one we put the values of the character as and when they appear
    //For the second one we are subtracting these values
    //if strings are anagram then the map will have 0 values.
    public static boolean isAnagramBasicAdv(String s, String t) {
        Map<Character, Integer> counter = new HashMap<>();
        for(char x: s.toCharArray()){
            counter.put(x, counter.getOrDefault(x,0)+1);
        }
        for(char x: t.toCharArray()){
            counter.put(x, counter.getOrDefault(x,0)-1);
        }
 
        for(int val : counter.values()){
            if(val != 0){
                return false;
            }
        }
 
         return true;
     }

     //This is the best solution for the problem
     //Just like the last solution we are using the same concept of first filling up the ds and then removing values while traversing the 2nd string
     //This is better as we are using an array and we are not performing any heavy operations.
     public static boolean isAnagramBest(String s, String t) {
        int[] count = new int[26];
         
         // Count the frequency of characters in string s
         for (char x : s.toCharArray()) {
             count[x - 'a']++;
         }
         
         // Decrement the frequency of characters in string t
         for (char x : t.toCharArray()) {
             count[x - 'a']--;
         }
         
         // Check if any character has non-zero frequency
         for (int val : count) {
             if (val != 0) {
                 return false;
             }
         }
         
         return true;
     }


    public static void main(String[] args) {
        String s = "rat";
        String t = "tar";
        System.out.println(isAnagramBasic(s, t));
        System.out.println(isAnagramBasicAdv(s, t));
        System.out.println(isAnagramBetter(s, t));
        System.out.println(isAnagramBest(s, t));
    }
}
