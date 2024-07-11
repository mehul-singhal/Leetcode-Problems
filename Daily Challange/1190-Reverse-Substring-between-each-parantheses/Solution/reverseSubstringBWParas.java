public class reverseSubstringBWParas {
    
    int i = 0;  // Index to keep track of the current position in the character array

    public String reverseSubstring(String s){
        char[] arr = s.toCharArray();  // Convert the input string to a character array
        return helper(arr);  // Start the helper method
    }

    public String helper(char[] s){
        StringBuilder sb = new StringBuilder();  // Initialize a StringBuilder to build the result string

        while (i < s.length) {  // Iterate over the character array
            if (s[i] == ')') {  // If a closing parenthesis is encountered
                i++;  // Move past the closing parenthesis
                return sb.reverse().toString();  // Return the reversed string built so far
            } else if (s[i] == '(') {  // If an opening parenthesis is encountered
                i++;  // Move past the opening parenthesis
                String st = helper(s);  // Recursively process the nested substring
                sb.append(st);  // Append the result of the recursive call to the StringBuilder
            } else {  // If a regular character is encountered
                sb.append(s[i]);  // Append the character to the StringBuilder
                i++;  // Move to the next character
            }
        }

        return sb.toString();  // Return the final result string
    }

    public static void main(String[] args) {
        reverseSubstringBWParas obj = new reverseSubstringBWParas();
        String s = "(ed(et(oc))el)";  // Example input string
        System.out.println(obj.reverseSubstring(s));  // Call the method and print the result
    }
}

//Recurssion Tree for the funcn

// reverseSubstring("(ed(et(oc))el)")
// |
// +-- helper("(ed(et(oc))el)")
//     |
//     +-- helper("ed(et(oc))el")  // sb = "ed"
//         |
//         +-- helper("et(oc))el")  // sb = "et"
//             |
//             +-- helper("oc))el")  // sb = "oc"
//                 |
//                 +-- returns "co"  // reverse of "oc"
//             |
//             +-- returns "ocet"  // "et" + "co" = "etco", reversed to "ocet"
//         |
//         +-- returns "tecode"  // "ed" + "ocet" = "edocet", reversed to "tecode"
//     |
//     +-- returns "leetcode"  // "tecode" + "el" = "tecodeel", reversed to "leetcode"