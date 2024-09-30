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
        // to stroe ans ans signs
        Stack<Integer> st = new Stack<>();
        int sign = 1;
        int ans = 0;
        int n = s.length();
        // Itrating each charcater of string s
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int number = 0;
                // building number till we encounter a nonDigit
                while(i< n && Character.isDigit(s.charAt(i))){
                    number = number*10+s.charAt(i)-'0';
                    i++;
                }
                // upadting ans with current sign and number
                ans += sign*number;
                // take pointer to the end of number
                i--;
            }
            else if(ch == '+'){
                sign = 1;
            }
            else if(ch == '-'){
                sign = -1;
            }
            else if(ch == '('){
                // push ans and sign on the stack before the parenthesis
                st.push(ans);
                st.push(sign);
                // Reseting ans and sign for the expression inside the parenthesis
                ans = 0;
                sign = 1;
            }
            else if(ch == ')'){
                ans = st.pop()*ans+st.pop();
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }
}
