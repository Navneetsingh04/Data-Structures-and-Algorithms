/*
L.C: 264. Ugly Number II

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.
Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 

Constraints:

1 <= n <= 1690
*/
// Time Complexity : O(N)
// Space Complexity : O(N)
public class UglyNumberII {
    public static int nthUglyNumber(int n) {
        int uglyNumber[] = new int[n];
        uglyNumber[0] = 1;
        int i2 = 0,i3 = 0,i5 = 0;
        for(int i = 1;i<n;i++){
            int nextMultipleOf2 = uglyNumber[i2]*2;
            int nextMultipleOf3 = uglyNumber[i3]*3;
            int nextMultipleOf5 = uglyNumber[i5]*5;

            uglyNumber[i] = Math.min(nextMultipleOf2,Math.min(nextMultipleOf3,nextMultipleOf5));

            if(uglyNumber[i] == nextMultipleOf2){
                i2++;
            }
            if(uglyNumber[i] == nextMultipleOf3){
                i3++;
            }
            if(uglyNumber[i] == nextMultipleOf5){
                i5++;
            }
        }
        return uglyNumber[n-1];
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }
}
