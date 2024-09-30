/*
L.C: 50. Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104 
*/
public class XpowerN {
    // Time complexity : O(logn)
    public static double binaryExp(double x,long n){
        if(n == 0) return 1;
        if(n<0){
            return 1/binaryExp(x,-n);
        }
        if((n&1) == 1){
            return x*binaryExp(x*x,(n-1)/2);
        }
        else{
            return binaryExp(x*x,n/2);
        }
    }
    public static double myPow(double x, int n) {
        return binaryExp(x,(long)n);
    }
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
        
    }
}
