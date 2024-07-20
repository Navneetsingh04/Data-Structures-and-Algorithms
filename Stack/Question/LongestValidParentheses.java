/*
L.C: 32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring

Example 1:
Input: s = "(()"
Output: 2
Explanation:The longest valid parentheses substring is "()"

Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:
Input: s = ""
Output: 0
*/

import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s){
        Stack<Integer> st = new Stack<>();
        // Initialize the stack with -1 to handle the base case for valid substr
        st.push(-1);
        int maxLen = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }
            else{
                st.pop();
                // If the stack is empty after popping, push the current index onto the stack
                // This handles the case where we have more closing brackets than opening ones
                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    int len = i-st.peek();
                    maxLen = Math.max(len,maxLen
                    );
                }
            }
        }
        return maxLen;
    }
    public static void main(String args[]){
        // String str = "(()";
        // // String str = ")()())";
        // // String str = "";
        String str = "((((((()()()))))";
        System.out.println("Largest Valis Parentheses: "+longestValidParentheses(str));
    }
}
