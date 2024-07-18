/*
L.C: 402. Remove K Digits

Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 
Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
 */
import java.util.Stack;
public class RemoveKDigits {
    public static String removeKDigit(String num,int k){
        if(num.length() == k){
            return "0";
        }
        Stack<Character> st = new Stack<>();
        for(char digit : num.toCharArray()){
            while(k>0 && !st.isEmpty() && st.peek()>digit){
                st.pop();
                k--;
            }
            st.push(digit);
        }
        // Removing any remaining digits if k>0
        while(k>0){
            st.pop();
            k--;
        }
        // Building  the result String
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.peek());
            st.pop();
        }
        ans.reverse();
        // removing leading zeros
        while(ans.length() > 0 && ans.charAt(0) == '0'){
            ans.deleteCharAt(0);
        }
        return ans.length() == 0?"0":ans.toString();
    }
    public static void main(String[] args) {
        // String num = "1432219";
        String num = "2561305";
        int k = 4;
        System.out.println("Smallest Digit after removing "+k+" Digit: "+removeKDigit(num, k));
    }
}
