/*
Count the Reversals

Given a string S consisting of only opening and closing curly brackets '{' and '}', find out the minimum number of reversals required to convert the string into a balanced expression.
A reversal means changing '{' to '}' or vice-versa.

Example 1:
Input:
S = "}{{}}{{{"
Output: 3
Explanation: One way to balance is:
"{{{}}{}}". There is no balanced sequence
that can be formed in lesser reversals.

Example 2:
Input: 
S = "{{}{{{}{{}}{{"
Output: -1
Explanation: There's no way we can balance
this sequence of braces.

Constraints:
1 ≤ |S| ≤ 105
 */

import java.util.Stack;

public class CountReversals {
    public static int countReversals(String str){
        if((str.length()&1)== 1){
            return -1;
        }
        int ans = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '{'){
                st.push(ch);
            }
            else{
                if(!st.isEmpty() && st.peek() == '}'){
                    st.pop();
                }
                else{
                    st.push(ch);
                }
            }
        }
        while(!st.isEmpty()){
            char a = st.peek();
            st.pop();
            char b = st.peek();
            st.pop();
            if(a == b){
                ans += 1;
            }
            else{
                ans += 2;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        String str = "}{{}}{{{";
        // String str = "{{}{{{}{{}}{{";
        int ans = countReversals(str);
        System.out.println("Total number of Reversal is "+ans);
    }
}
