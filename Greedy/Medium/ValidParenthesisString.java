/*
L.C: 678. Valid Parenthesis String

Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "(*)"
Output: true

Example 3:
Input: s = "(*))"
Output: true

Constraints:
1 <= s.length <= 100
s[i] is '(', ')' or '*'. 
*/
// Time Complexity : O(n)
// Space Complexity : O(1)
public class ValidParenthesisString {
    public static boolean validString(String s){
        int n = s.length();
        int min = 0,max = 0;
        for(int i = 0;i<n;i++){
            if(s.charAt(i) == '('){
                min++;
                max++;
            }
            else if(s.charAt(i) == ')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            if(min<0){
                min = 0;
            }
            if(max < 0){
                return false;
            }
        }
        return min==0;
    }
    public static void main(String[] args) {
        String s =
"(((((()*)(*)*))())())(()())())))((**)))))(()())(";
        System.out.println(validString(s));
    }
}
