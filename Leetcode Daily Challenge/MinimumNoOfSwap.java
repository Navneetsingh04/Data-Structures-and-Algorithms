/*
L.C: 1963. Minimum Number of Swaps to Make the String Balanced

You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.

A string is called balanced if and only if:

It is the empty string, or
It can be written as AB, where both A and B are balanced strings, or
It can be written as [C], where C is a balanced string.
You may swap the brackets at any two indices any number of times.

Return the minimum number of swaps to make s balanced.

 

Example 1:

Input: s = "][]["
Output: 1
Explanation: You can make the string balanced by swapping index 0 with index 3.
The resulting string is "[[]]".
Example 2:

Input: s = "]]][[["
Output: 2
Explanation: You can do the following to make the string balanced:
- Swap index 0 with index 4. s = "[]][][".
- Swap index 1 with index 5. s = "[[][]]".
The resulting string is "[[][]]".
Example 3:

Input: s = "[]"
Output: 0
Explanation: The string is already balanced.
 

Constraints:

n == s.length
2 <= n <= 106
n is even.
s[i] is either '[' or ']'.
The number of opening brackets '[' equals n / 2, and the number of closing brackets ']' equals n / 2. 
*/

public class MinimumNoOfSwap {
    // Approach 1: Stack
    // public int minSwaps(String s) {
    //     Stack<Character> st = new Stack<>();
    //     int count = 0;
    //     for(int i = 0;i<s.length();i++){
    //         char ch = s.charAt(i);
    
    //         if(ch == '['){
    //             st.push(ch);
    //         }
    //         else if(!st.isEmpty()){
    //             st.pop();
    //         }
    //         else{
    //             count++;
    //         }
    //     }
    //     return (count+1)/2;
    // }
    // Approach 2: Counting 
    public int minSwaps(String s) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ']'){
               count++;
               max = Math.max(count,max);
            }
            else{
                count--;
            }
        }
        return (max+1)/2;
    }
    public static void main(String[] args) {
        MinimumNoOfSwap obj = new MinimumNoOfSwap();
        String s = "]]][[[";
        System.out.println(obj.minSwaps(s));
    }
}
