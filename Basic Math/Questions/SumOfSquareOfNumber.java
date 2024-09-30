/*
L.C: 633. Sum of Square Numbers

Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:

Input: c = 3
Output: false
 

Constraints:

0 <= c <= 231 - 1
*/
public class SumOfSquareOfNumber {
    // Time Comlexity : O(sqrtC)
    public static boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long)Math.sqrt(c);
        while(left <= right){
            long sq = left*left + right*right;
            if(sq == c){
                return true;
            } 
            else if(sq > c){
                right--;
            }
            else{
                left++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 41;
        System.out.println(judgeSquareSum(n));
    }
}
