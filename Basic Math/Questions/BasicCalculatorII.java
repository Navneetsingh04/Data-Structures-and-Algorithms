/*
227. Basic Calculator II

Given a string s which represents an expression, evaluate this expression and return its value. 
The integer division should truncate toward zero.
You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 
Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
*/
public class BasicCalculatorII {
    public static int basicCalculator(String s) {
        int n = s.length();
        int value = 0;
        char operation = '+';
        int lastValue = 0;
        int ans = 0;

        for(int i = 0;i<n;i++){
            char currChar = s.charAt(i);
            if(Character.isDigit(currChar)){
                value = value*10+(currChar -'0');
            }
            if(!Character.isDigit(currChar) && currChar != ' ' || i == n-1){

                switch(operation){
                    case '+':
                        ans += lastValue; 
                        lastValue = value; 
                        break;
                    case '-':
                        ans += lastValue; 
                        lastValue = -value; 
                        break;
                    case '*':
                        lastValue *= value; 
                        break;
                    case '/':
                        lastValue /= value;
                        break;
                }
                operation = currChar;
                value = 0;
            }
        }
        ans += lastValue;
        return ans;
    }
    public static void main(String[] args) {
        String s = " 3+5 / 2 ";
        System.out.println(basicCalculator(s));
    }
}
