/*
L.C: 224. Basic Calculator

Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().


Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 

Constraints:

1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer. 
*/

import java.util.Stack;
public class BasicCalculator {
    public static int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        int sign = 1;
        int ans = 0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                // create number
                num = (num*10) + ch-'0';
            }
            else if(ch == '+'){
                ans += num*sign;
                num = 0;
                sign = 1;
            }
            else if(ch == '-'){
                ans += num*sign;
                num = 0;
                sign = -1;
            }
            else if(ch == '('){
                st.push(ans);
                st.push(sign);
                // reset the ans and sign for the expresion in brackets
                ans = 0;
                sign = 1;
            }
            else if(ch == ')'){
                // find the ans of brackets
                ans += num*sign;   
                num = 0;
                int prevSign = st.pop();
                int prevAns = st.pop();
                
                ans = prevAns + prevSign*ans;
            }
        }
        ans += (num*sign);
        return ans;
    }
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }
}
