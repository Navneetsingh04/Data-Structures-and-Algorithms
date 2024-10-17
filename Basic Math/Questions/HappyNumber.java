/*
L.C: 202. Happy Number

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:
Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 02 = 1

Example 2:
Input: n = 2
Output: false
 
Constraints:

1 <= n <= 231 - 1
*/

public class HappyNumber {
    // approach 1: Using hashSet
    // public static boolean isHappy(int n) {
    //     Set<Integer> set = new HashSet<>();
    //     while(true){
    //         int sum = 0;
    //         while(n != 0){
    //             sum += Math.pow(n%10,2);
    //             n = n/10;
    //         }
    //         if(sum == 1) return true;
    //         n = sum;
    //         if(set.contains(n)){
    //             return false;
    //         }
    //         set.add(n);
    //     }
    // }

    // Approach 2: Using Two Pointer
    // Time Complexity : O(logn)
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while(slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return slow == 1;
    }
    public static int getNext(int n){
        int sum = 0;
        while(n > 0){
            int digit = n%10;
            sum += digit*digit;
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }
}
