import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams {

    //This question is a superset of valid anagram question
    //To prove if 2 strings are valid anagrams either you can convert strings into array and then sort and match them or
    //You can make two hashmaps are equalize them (This is a slower and much more memory intensive  way)

    //Here we combined both these ways we first converted the strings to array and sort them and added the sorted string as key in the map while the value
    //was the actual string
    //Now if there is another valid anagram string for this string in the array it'll match the sorted string and we'll add that string to the 
    //list which we made in the value.

    public static List<List<String>> groupAnagram(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
       for(String s: strs){
           char[] temp = s.toCharArray();
           Arrays.sort(temp);
           String sortedString = new String(temp);
           if(map.containsKey(sortedString)){
               map.get(sortedString).add(s);
               map.put(sortedString, map.get(sortedString));
           }
           else{
               List<String> start = new ArrayList<String>();
               start.add(s);
               map.put(sortedString, start);
           }
       }

        List<List<String>> listValues = List.copyOf(map.values());
        return listValues;
    }

    public static void main(String args[]){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagram(strs));
    }
}
