/*
L.C: 1003. Check If Word Is Valid After Substitutions

Given a string s, determine if it is valid.
A string s is valid if, starting with an empty string t = "", you can transform t into s after performing the following operation any number of times:

Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright. Note that tleft and tright may be empty.
Return true if s is a valid string, otherwise, return false.

Example 1:

Input: s = "aabcbc"
Output: true
Explanation:
"" -> "abc" -> "aabcbc"
Thus, "aabcbc" is valid.
Example 2:

Input: s = "abcabcababcc"
Output: true
Explanation:
"" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
Thus, "abcabcababcc" is valid.
Example 3:

Input: s = "abccba"
Output: false
Explanation: It is impossible to get "abccba" using the operation.
 
Constraints:
1 <= s.length <= 2 * 104
s consists of letters 'a', 'b', and 'c'
*/

import java.util.Stack;

public class CheckWordIsValidAfterSubstitution {

    // 1st Approach : using recursion

    // public static boolean isValid(String str){
    //     if(str.length() == 0){
    //         return true;
    //     }
    //     int found = str.indexOf("abc");
    //     if(found != -1){
    //         String tleft = str.substring(0, found);
    //         String tright = str.substring(found+3,str.length());
    //         return isValid(tleft+tright);
    //     }
    //     return false;
    // }

    public static boolean isValid(String str){
        if(str.charAt(0) != 'a'){
            return false;
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == 'a'){
                st.push(ch);
            }
            else if(ch == 'b'){
                if(!st.isEmpty() && st.peek() == 'a'){
                    st.push('b');
                }
                else{
                    return false;
                }
            }
            else{
                // ch == 'c'
                if(!st.isEmpty() && st.peek() == 'b'){
                    st.pop();
                    if(!st.isEmpty() && st.peek() == 'a'){
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        return st.isEmpty()?true:false;
    }
    public static void main(String[] args) {
        // String str = "abcabcababcc";
        String str = "abccba";
        boolean ans = isValid(str);
        System.out.println(ans);
    }
}
