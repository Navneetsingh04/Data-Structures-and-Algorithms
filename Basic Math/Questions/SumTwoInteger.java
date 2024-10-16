/*
L.C: 371. Sum of Two Integers

Given two integers a and b, return the sum of the two integers without using the operators + and -.

Example 1:
Input: a = 1, b = 2
Output: 3

Example 2:
Input: a = 2, b = 3
Output: 5

Constraints:

-1000 <= a, b <= 1000
*/
public class SumTwoInteger {
    public static int getSum(int a, int b) {
        while(b != 0){
            int carry = (a&b)<<1;
            a = a^b;  // sum wthiout carry
            b = carry;
        }
        return a;
    }
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println(getSum(a, b));
    }
}
