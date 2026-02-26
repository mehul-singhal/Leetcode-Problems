import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class groupAnagrams1 {

//  Approaches

// (Also explained in the code)

// Approach 1

// The function getSignature creates a unique signature for each string by counting the occurrences of each character. 
//  This signature helps identify anagrams as they have the same character frequencies.

// The groupAnagrams function uses an unordered map (groups) to group strings with the same signature (anagrams) together. 
//It iterates through each string, calculates its signature, and adds the string to the corresponding group in the map.

// The result vector stores the final grouped anagrams. It is initially empty and gets populated by iterating through 
//the groups map. Each entry in the map corresponds to a unique signature, and the associated vector contains strings that are anagrams.

// Complexity

// Time complexity:
// O(n∗k)O(n*k)O(n∗k)
// (K is the length of the longest string)

// Space complexity:
// O(n∗k)O(n*k)O(n∗k)
// (K is the length of the longest string)
    
    public static String getSignature(String s){
        int[] count = new int[26];
        for(char c: s.toCharArray()){
            count[c - 'a']++;
        }
        //This is creating a signature which is going to be same for all the anagrams.
        StringBuilder sb =  new StringBuilder();
        for(int i = 0; i<26;i++){
            sb.append((char) ('a'+i)).append(count[i]);
        }
        //This will create string like a1t1e1 and this will be the signature of the string
        return sb.toString();
    }

    public static List<List<String>> groupAnagram(String[] strs){
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();
        for(String s: strs){    
            groups.computeIfAbsent(getSignature(s), k -> new ArrayList<>()).add(s);
        }
        result.addAll(groups.values());
        return result;
    }
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagram(strs));
    }    
}
