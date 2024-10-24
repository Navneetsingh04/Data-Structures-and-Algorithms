/*
GFG: Next Happy Number

For a given non-negative integer N, find the next smallest Happy Number. A number is called Happy if it leads to 1 after a sequence of steps. Wherein at each step the number is replaced by the sum of squares of its digits that is, if we start with Happy Number and keep replacing it with sum of squares of its digits, we reach 1 at some point.
 
Example 1:

Input:
N = 8
Output:
10
Explanation:
Next happy number after 8 is 10 since
1*1 + 0*0 = 1
Example 2:

Input:
N = 10
Output
13
Explanation:
After 10, 13 is the smallest happy number because
1*1 + 3*3 = 10, so we replace 13 by 10 and 1*1 + 0*0 = 1.
Your Task:
You don't need to read input or print anything. Your task is to complete the function nextHappy() which takes an integer N as input parameters and returns an integer, next Happy number after N.
 
Constraints:
1<=N<=105
*/
// Time complexity: O(nlog(n))
// Space complexity: O(log(n)) 

// import java.util.HashSet;
// import java.util.Set;

public class NextHappyNumber {
    // Appraoch 1: Using hashSet
    // Time complexity: O(nlog(n))
    // Space complexity: O(log(n))
    
    // public static boolean isHappy(int n){
    //     Set<Integer> set = new HashSet<>();
    //     int sum = 0;
    //     while(true){
    //         while(n != 0){
    //             sum += Math.pow(n%10, n);
    //             n = n/10;
    //         }
    //         if(sum == 1) return true;
    //         if(set.contains(sum)) return false;
    //         set.add(sum);
    //         n = sum;
    //     }
    // }
    // public static int nextHappyNumber(int n){
    //     n++;
    //     while(true){
    //         if(isHappy(n)){
    //             return n;
    //         }
    //         n++;
    //     }
    // }

    // Approach 2:
    // Time complexity: O(nlog(n))
    // Space complexity: O(1) 
    
    public static boolean isHappy(int n){
        while(n != 1 && n != 7 && n >9){
            int sum = 0;
            while(n>0){
                sum += Math.pow(n%10,2);
                n = n/10;
            }
            n = sum;
        }
        return (n == 1 || n == 7);
    }
    public static int nextHappyNumber(int n){
        n++;
        while(!isHappy(n)){
            n++;
        }
        return n;
    }
    public static void main(String[] args) {
        int n = 8;
        System.out.println(nextHappyNumber(n));
    }
}
