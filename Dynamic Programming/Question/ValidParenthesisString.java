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

// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
public class ValidParenthesisString {
    public static boolean func(String s,int index,int count,Boolean dp[][]){
        if(count < 0) return false;
        if(index == s.length()){
            return (count == 0);
        }
        if(dp[index][count] != null){
            return dp[index][count];
        }
        boolean result;
        if(s.charAt(index) == '('){
            result =  func(s,index+1,count + 1,dp);
        }
        else if(s.charAt(index) == ')'){
            result =  func(s,index+1,count - 1,dp);
        }
        else{
            result =  func(s,index+1,count+1,dp) || func(s,index+1,count-1,dp) || func(s,index+1,count,dp);
        }
        dp[index][count] = result;
            return result;
        }
        public static  boolean checkValidString(String s) {
            int n = s.length();
            Boolean dp[][] = new Boolean[n][2*n];
            return func(s,0,0,dp);
        }
    public static void main(String[] args) {
        String s = "(((((()*)(*)*))())())(()())())))((**)))))(()())()";
        System.out.println(checkValidString(s));
    }
}
