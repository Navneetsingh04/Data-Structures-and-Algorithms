/*
L.C: 258. Add Digits

Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.
Example 2:

Input: num = 0
Output: 0
 

Constraints:

0 <= num <= 231 - 1 
*/
public class AddDigit {
    // Approach 1: 
    // Time Complexity: O(log10(num))

    // public static int addDigit(int num){
    //     while(num/10 != 0){
    //         int ans = 0;
    //         while(num>0){
    //             ans += num%10;
    //             num /= 10;
    //         }
    //         if(ans/10 == 0){
    //             return ans;
    //         }
    //         else{
    //             num = ans;
    //         }
    //     }
    //     return num;
    // }
    // Approach 1: Using Digital Root
    // Time Complexity: O(1)
    // space Complexity: O(1)

    public static int addDigit(int num){
        if(num == 0) return 0;
        return (num-1)%9+1;
    }
    public static void main(String[] args) {
        int n = 38;
        System.out.println(addDigit(n));
    }
}
