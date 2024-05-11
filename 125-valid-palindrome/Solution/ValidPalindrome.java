import java.util.*;
public class ValidPalindrome {

    public boolean isPalindromeBrute(String s) {
        String x = s.toLowerCase();
        //Removing all characters from a string except alphabets
        // for(int i = 0; i<x.length(); i++){
        //     if(
        //         x.charAt(i) < 'A' || x.charAt(i) > 'Z' && 
        //         x.charAt(i) < 'a' || x.charAt(i) > 'z' &&
        //     )
        //     {
        //         x = x.substring(0,i) + x.substring(i+1);
        //         i++;
        //     }
        // }
        //Removing all characters from string except alphanumeric digits
        x = x.replaceAll("[^a-zA-Z0-9]","");
        x = x.replaceAll("\\s","");
        String y = "";
        char a;
        for(int i = 0; i<x.length(); i++){
            a = x.charAt(i);
            y = a+y;
        }
        return x.equals(y);     
    }

    public boolean isPalindromeBasicTwoPointer(String s) {
        //Left Pointer Index
        int l = 0;
        //Rigth Pointer Index 
        int r = s.length()-1;

        //Iterating from left to right until pointers meet in the middle
        while(l<r){
            //Take char at left pointer and make it lower case
            char lc = Character.toLowerCase(s.charAt(l));
            //Take char at right pointer and make it lower case
            char rc = Character.toLowerCase(s.charAt(r));
            //Check if left character is a special character    
            if(!Character.isLetterOrDigit(lc)){
                //Skip the left char if it is a special character
                l++;
            }//Check if right character is a special character
            else if(!Character.isLetterOrDigit(rc)){
                //Skip the right character if it is a speical character 
                r--;
            }
            else{
                //if lc and rc are not special character check is they are equal or not, if they are not equal then it means string is 
                //not palindrome
                if(lc != rc) return false;
                //Move to next char from left side
                l++;
                //Move to next char from left sidee
                r--;
            }
        }
        //If the while loop has been completed then it mean the string is a palindrome
        return true;
    }

    public boolean isPalindromeBest(String s) {
        //Make a character array of the size of string
        char[] phrase = new char[s.length()];
        //Set an index 
        int index = 0; 
        //Iterate over the characters after converting the string to char array
        for(char c: s.toCharArray()){
          //Check if character is lowercase alphabet
          if(c > 96 && c<123){
              //Add the character to the character array and increase the index afterwards.
              phrase[index++] = c;
              continue;
          }
          //check if character is uppercase alphabet
          if(c > 64 && c < 91){
              //Add the char to the char array and increase the index afterwards, make the char lowercase by adding 32
              phrase[index++] = (char) (c+32);
              continue;
          }
          //check if character is a number
          if (c > 47 && c < 58) {
              //Add the character to the character array and increase the index afterwards.
              phrase[index++] = c;
              continue;
          }
        }
        //setting k as the index for the last value in the array
        int k = index-1;
        //Iterating over the array till the midpoint while decreasing the k;
        for(int i = 0; i<index/2; i++){
          //Check if the characters match each other or not
          if(phrase[i] != phrase[k--]){
              //If even a single character doesn't match we return false;
              return false;
          }
        }
        //If false was never returned that means the string must be a palindrome.
        return true;
      }

      public static void main(String[] args) {
        //Create an object of the class
        ValidPalindrome palindrome = new ValidPalindrome();
        //Test cases
        System.out.println(palindrome.isPalindromeBrute("A man, a plan, a canal: Panama"));
        System.out.println(palindrome.isPalindromeBasicTwoPointer("A man, a plan, a canal: Panama"));
        System.out.println(palindrome.isPalindromeBest("A man, a plan, a canal: Panama"));
      }

}
