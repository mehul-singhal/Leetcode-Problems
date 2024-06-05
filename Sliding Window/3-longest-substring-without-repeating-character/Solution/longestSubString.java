import java.util.*;
public class longestSubString {
    public int lengthOfLongestSubstring(String s) { 
        //This piece of commented code doesn't take into consideration the cases where the duplicates are not adjacent
        //For the "dvdf" example this code will skip v and directly look at a new string and form df resulting in wrong answer
        // int currentCount = 1;
        // char[] charA = s.toCharArray();
        // String temp = String.valueOf(charA[0]);
        // for(int i = 1; i<charA.length; i++){
        //     if(!temp.contains(String.valueOf(charA[i]))){
        //         temp = temp + String.valueOf(charA[i]);
        //         currentCount++;
        //         if(longestCount < currentCount){
        //             longestCount = currentCount;
        //         }
        //     }
        //     else{
        //         currentCount = 1;
        //         temp = String.valueOf(charA[i]);
        //     }
        // }
        // return longestCount;

        // Handle edge case where the input string is empty
        if (s.length() == 0) return 0;
        
        // Initialize variables
        int longestCount = 0; // To keep track of the length of the longest substring found
        int left = 0; // Left pointer of the sliding window
        Set<Character> charSet = new HashSet<>(); // Set to store unique characters in the current window
        
        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            // If the character at the right pointer is already in the set,
            // move the left pointer to the right until the character is removed from the set
            while (charSet.contains(s.charAt(right))) {
                // Remove the character at the left pointer from the set
                charSet.remove(s.charAt(left));
                // Move the left pointer to the right
                left++;
            }
            
            // Add the character at the right pointer to the set
            charSet.add(s.charAt(right));
            // Update the length of the longest substring found
            // The length of the current window is (right - left + 1)
            longestCount = Math.max(longestCount, right - left + 1);
        }
        
        // Return the length of the longest substring without repeating characters
        return longestCount;
    }

    public int longestSubStringUsingMap(String s){
        int len = s.length();
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        //This solution uses a map to store the characters of the string and remove the character on the basis of occurence
        //When you remove one character from the left you move it ahead
        //Right pointer keeps moving with normal iteration
        for(int right = 0; right< len; right++){
            if(!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left){
                charMap.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, right-left+1);
            }
            else{
                left = charMap.get(s.charAt(right)) + 1;
                charMap.put(s.charAt(right), right);
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringArray(String s) {
        // Get the length of the input string
        int n = s.length();
        // Initialize the maximum length of substring found
        int maxLength = 0;
        // Array to store the last index of each character (ASCII 128 characters)
        int[] charIndex = new int[128];
        // Fill the array with -1 to indicate characters not seen yet
        Arrays.fill(charIndex, -1);
        // Left pointer of the sliding window
        int left = 0;
        
        // Iterate through the string with the right pointer
        for (int right = 0; right < n; right++) {
            // If the character at the right pointer has been seen and is within the current window
            if (charIndex[s.charAt(right)] >= left) {
                // Move the left pointer to the right of the last occurrence of the current character
                left = charIndex[s.charAt(right)] + 1;
            }
            // Update the last seen index of the current character
            charIndex[s.charAt(right)] = right;
            // Update the maximum length of the substring found
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        // Return the length of the longest substring without repeating characters
        return maxLength;
    }
    
    

    public static void main(String[] args) {
        String s = "dvdf";
        longestSubString a = new longestSubString();
        System.out.println(a.lengthOfLongestSubstring(s));
        System.out.println(a.longestSubStringUsingMap(s));
        System.out.println(a.lengthOfLongestSubstringArray(s));
    }
}


