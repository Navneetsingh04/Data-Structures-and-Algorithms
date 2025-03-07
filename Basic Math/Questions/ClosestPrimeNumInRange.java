/*
L.C: 2523. Closest Prime Numbers in Range

Given two positive integers left and right, find the two integers num1 and num2 such that:

left <= num1 < num2 <= right .
Both num1 and num2 are prime numbers.
num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].

Example 1:
Input: left = 10, right = 19
Output: [11,13]
Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
Since 11 is smaller than 17, we return the first pair.

Example 2:
Input: left = 4, right = 6
Output: [-1,-1]
Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
 
Constraints:
1 <= left <= right <= 106
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestPrimeNumInRange {
    // Approach 1: using sieve of eratonsthenses
    // T.C: O(NlogN)
    public static List<Integer> sieveOfEratonsthenes(int right){
        int prime[] = new int[right+1];
        Arrays.fill(prime,1);
        for(int i = 2;i*i<=right;i++){
            if(prime[i] == 1){
                for(int j = 2*i;j<=right;j +=i){
                    prime[j] = 0;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i = 2;i<=right;i++){
            if(prime[i] == 1){
                primes.add(i);
            }
        }
        return primes;
    }
    public static int[] closestPrimes(int left, int right) {
        List<Integer> primes = sieveOfEratonsthenes(right);

        List<Integer> inRange = new ArrayList<>();
        for(int p : primes){
            if(p >= left && p <= right){
                inRange.add(p);
            }
        }
        if(inRange.size() < 2){
            return new int[]{-1,-1};
        }
        int minDiff = Integer.MAX_VALUE;
        int ans1 = -1,ans2 = -1;
        for(int i = 1;i<inRange.size();i++){
            int diff = inRange.get(i) - inRange.get(i-1);
            if(diff < minDiff){
                minDiff = diff;
                ans1 = inRange.get(i-1);
                ans2 = inRange.get(i);
            }
        }
        return new int[]{ans1,ans2};
    }

    // Approach 2: Using Sieve of Eratosthenes
    // T.C: O(N log log N)

    public static int[] closestPrimesII(int left,int right) {
        if (right<2) return new int[]{-1, -1};
        boolean[] isPrime = new boolean[right+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i*i<= right;i++){
            if(isPrime[i]) {
                for(int j = i*i;j<=right;j += i){
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i = Math.max(2, left);i <= right;i++){
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        if(primes.size() < 2){
            return new int[]{-1, -1};
        }
        int minDiff = Integer.MAX_VALUE;
        int ans1 = -1, ans2 = -1;
        for(int i = 1;i < primes.size();i++){
            int diff = primes.get(i) - primes.get(i - 1);
            if(diff <minDiff){
                minDiff = diff;
                ans1 = primes.get(i - 1);
                ans2 = primes.get(i);
            }
        }
        return new int[]{ans1, ans2};
    }
    public static void main(String[] args) {
        int left = 11;
        int right = 19;
        System.out.println(Arrays.toString(closestPrimes(left, right)));
        System.out.println(Arrays.toString(closestPrimesII(left, right)));
    }
}
