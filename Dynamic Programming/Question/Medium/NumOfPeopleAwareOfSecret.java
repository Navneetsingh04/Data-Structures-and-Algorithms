/*
L.C: 2327. Number of People Aware of a Secret

On day 1, one person discovers a secret.

You are given an integer delay, which means that each person will share the secret with a new person every day, starting from delay days after discovering the secret. You are also given an integer forget, which means that each person will forget the secret forget days after discovering it. A person cannot share the secret on the same day they forgot it, or on any day afterwards.

Given an integer n, return the number of people who know the secret at the end of day n. Since the answer may be very large, return it modulo 109 + 7.

Example 1:
Input: n = 6, delay = 2, forget = 4
Output: 5
Explanation:
Day 1: Suppose the first person is named A. (1 person)
Day 2: A is the only person who knows the secret. (1 person)
Day 3: A shares the secret with a new person, B. (2 people)
Day 4: A shares the secret with a new person, C. (3 people)
Day 5: A forgets the secret, and B shares the secret with a new person, D. (3 people)
Day 6: B shares the secret with E, and C shares the secret with F. (5 people)

Example 2:
Input: n = 4, delay = 1, forget = 3
Output: 6
Explanation:
Day 1: The first person is named A. (1 person)
Day 2: A shares the secret with B. (2 people)
Day 3: A and B share the secret with 2 new people, C and D. (4 people)
Day 4: A forgets the secret. B, C, and D share the secret with 3 new people. (6 people)
 
Constraints:
2 <= n <= 1000
1 <= delay < forget <= n 
*/

import java.util.Arrays;

public class NumOfPeopleAwareOfSecret{
    final static int mod = (int) 1e9+7;

    // 1st Approach : Memonization
    // Time Complexity: O(n * (n - forget)) 

    private static int solve(int day, int delay, int forget,int dp[]){
        if(day == 1) return 1;
        if(dp[day] != -1){
            return dp[day];
        }
        int ans = 0;
        for(int i = day-forget+1; i <= day-delay; i++){
            if(i > 0){
                ans = (ans + solve(i,delay,forget,dp))%mod;
            }
        }
        return dp[day] = ans;
    }
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int total = 0;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        for(int day = n-forget+1; day <= n;day++){
            if(day > 0){
                total = (total + solve(day,delay,forget,dp))%mod;
            }
        }
        return total;
    }

    // 2nd Approach : Tabulation
    // Time Complexity: O(n * (n - forget)) 

    public static int peopleAwareOfSecretTab(int n, int delay, int forget) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[1] = 1;
        for(int day = 2;day <= n;day++){
            int total = 0;
            for(int i = day-forget+1; i <= day-delay; i++){
                if(i > 0){
                    total = (total + dp[i])%mod;
                }
            }
            dp[day] = total;
        }
        int ans = 0;
        for(int day = n-forget+1; day <= n;day++){
            if(day > 0){
                ans = (ans + dp[day])%mod;
            }
        }
        return ans;
    }

    // 3rd Approach : Tabulation + sliding window
    // Time Complexity: O(n * forget) 

    public static int peopleAwareOfSecretOp(int n, int delay, int forget) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[1] = 1;
        int total = 0;
        for(int day = 2;day <= n;day++){
            if(day-delay > 0){
                total = (total + dp[day-delay])%mod;
            }
            if(day - forget > 0){
                total = (total - dp[day-forget] + mod)%mod;
            }
            dp[day] = total;
        }
        int ans = 0;
        for(int day = n-forget+1; day <= n;day++){
            if(day > 0){
                ans = (ans + dp[day])%mod;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 6, dealy = 2, forgot = 4;
        System.out.println(peopleAwareOfSecret(n, dealy, forgot));
        System.out.println(peopleAwareOfSecretTab(n, dealy, forgot));
        System.out.println(peopleAwareOfSecretOp(n, dealy, forgot));
    }
}