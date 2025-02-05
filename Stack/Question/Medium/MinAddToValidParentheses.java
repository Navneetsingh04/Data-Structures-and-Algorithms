/*
L.C: 921. Minimum Add to Make Parentheses Valid

A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

Example 1:
Input: s = "())"
Output: 1

Example 2:
Input: s = "((("
Output: 3
 
Constraints:
1 <= s.length <= 1000
s[i] is either '(' or ')'. 
*/

import java.util.Stack;
public class MinAddToValidParentheses {
    public static int minAddToValid(String str){
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '('){
                ans++;
                st.push(ch);
            }
            else{
                if(!st.isEmpty()){
                    ans--;
                    st.pop();
                }
                else{
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "(())))";
        System.out.println("Minimum Add to Valid Parentheses is: "+minAddToValid(str));
    }
}
