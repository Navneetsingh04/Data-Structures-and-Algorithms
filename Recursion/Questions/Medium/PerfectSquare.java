/*
L.C: 279. Perfect Squares

Given an integer n, return the least number of perfect square numbers that sum to n.
A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 
Constraints:
1 <= n <= 104
*/

// Time Complexity : O(n^n)
// space complexity : O(n)
public class PerfectSquare {
    public static int numsSquareHelper(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int i = 1;
        double end = Math.sqrt(n);
        while(i <= end){
            int perfectSquare = i*i;
            int numberOfPerfectSquare = 1+numsSquareHelper(n-perfectSquare);
            if (numberOfPerfectSquare < ans){
                ans = numberOfPerfectSquare;
            }
            i++;
        }
        return ans;
    }
    public static int numsSquare(int n){
       return numsSquareHelper(n)-1;
    }
    public static void main(String[] args) {
        int n = 12;
        System.out.println(numsSquare(n));
    }
}
