/*
204. Count Primes

Given an integer n, return the number of prime numbers that are strictly less than n.
Example 1:
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0

Constraints:

0 <= n <= 5 * 106 
*/
import java.util.Arrays;
public class CountPrimes {
    public static int countPrimes(int n) {
        int count = 0;
        int prime[] = new int[n+1];
        Arrays.fill(prime,1);
        for(int i = 2;i*i<n;i++){
            if(prime[i] == 1){
                for(int j = i*i;j<n;j+=i){
                    prime[j] = 0;
                }
            }
        }
        for(int i = 2;i<n;i++){
            if(prime[i] == 1){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 20;
        System.out.println(countPrimes(n));
    }
}
