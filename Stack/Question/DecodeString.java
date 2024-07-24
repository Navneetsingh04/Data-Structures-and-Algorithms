/*
L.C: 394. Decode String

Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
   
Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
 */

import java.util.Stack;
public class DecodeString {
    public static String decodeString(String s){
        Stack<String> st = new Stack<>();
        int index = 0;
 
        while (index < s.length()) {
            char ch = s.charAt(index);
             
            if (Character.isDigit(ch)) {
                // Build the full number
                StringBuilder num = new StringBuilder();
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                     num.append(s.charAt(index));
                     index++;
                }
                st.push(num.toString());
            } 
            else if (ch == '[') {
                 st.push("[");
                 index++;
             }
            else if (ch == ']') {
                // Extract the string to be repeated
                StringBuilder stringToRepeat = new StringBuilder();
                while (!st.isEmpty() && !st.peek().equals("[")) {
                    stringToRepeat.insert(0, st.pop());
                }
                // Pop the '[' from the stack
                st.pop();
                 
                // Extract the number of times to repeat
                int repeatTimes = Integer.parseInt(st.pop());
                 
                // Create the repeated string
                StringBuilder currentDecodeString = new StringBuilder();
                for (int i = 0; i < repeatTimes; i++) {
                    currentDecodeString.append(stringToRepeat);
                }
                 
                // Push the repeated string back onto the stack
                st.push(currentDecodeString.toString());
                index++;
            } 
            else {
                // Push the character as a string onto the stack
                st.push(Character.toString(ch));
                index++;
            }
        }
 
        // Build the final result from the stack
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.insert(0, st.pop());
        }
 
        return result.toString();
    }
 
    public static void main(String[] args) {
        String str = "2[abc]3[cd]ef";
        System.out.println("Decoded String: "+decodeString(str)); 
    }
}
 