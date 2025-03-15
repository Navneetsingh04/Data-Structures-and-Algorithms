/*
L.C: 69. Sqrt(x)
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 
Constraints:

0 <= x <= 231 - 1
 */
// Time complexity: O(logn)
public class Sqrt {
    public static long sqrt(int n){
        int s = 0;
        int e = n;
        long ans = -1;
        while(s<=e){
            long  mid = s+(e-s)/2;
            if(mid*mid == n){
                return mid;
            }
            else if(mid*mid<n){
                ans = mid;
                s = (int)mid+1;
            }
            else{
                e = (int)mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 68;
        long ans = sqrt(n);
        System.out.println("squra root of "+n+" is "+ans);
    }
}
