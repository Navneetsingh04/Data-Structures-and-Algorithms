/*
you are given two integer arrays val[] and wt[], which represent the values and weights associated with items, respectively. You are also given an integer capacity, which represents the knapsack capacity. Your task is to find the maximum sum of values of a subset of val[] such that the sum of the weights of the corresponding subset is less than or equal to capacity. You cannot break an item; you must either pick the entire item or leave it (0-1 property).

Example 1 

Input: capacity = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1] 
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3. 

Example 2
Input: capacity = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 6, 3] 
Output: 50
Explanation: Choose the second item (value 40, weight 4) and the fourth item (value 50, weight 3) for a total weight of 7, which exceeds the capacity. Instead, pick the last item (value 50, weight 3) for a total value of 50.
Constraints:
2 ≤ val.size() = wt.size() ≤ 103
1 ≤ capacity ≤ 103
1 ≤ val[i] ≤ 103
1 ≤ wt[i] ≤ 103
*/

import java.util.Arrays;

public class KnapsackProblem {
    public static int solve(int index,int capacity,int val[],int wt[],int dp[][]){
        if(index == 0){
            if(wt[0] <= capacity){
                return val[0];
            }
            else{
                return 0;
            }
        }
        if(dp[index][capacity] != -1){
            return dp[index][capacity];
        }
        int notTake = solve(index-1,capacity,val,wt,dp);
        int take = Integer.MIN_VALUE;
        if(wt[index] <= capacity){
            take = val[index]+solve(index-1,capacity-wt[index],val,wt,dp);
        }
        dp[index][capacity] = Math.max(take,notTake);
        return dp[index][capacity];
    }
    public static int solveUsingMemo(int capacity, int val[], int wt[]) {
        int n = val.length;
        int dp[][] = new int[n][capacity+1];
        for(int i[] : dp){
            Arrays.fill(i, -1);
        }
        return solve(n-1,capacity,val,wt,dp);
    }
    public static int solveUsingTab(int capacity,int val[],int wt[]){
        int n = val.length;
        int dp[][] = new int[n][capacity+1];
        for(int i = 0;i<=capacity;i++){
            if(wt[0] <= i){
                dp[0][i] = val[0];
            }
            else{
                dp[0][i] = 0;
            }
        }
        for(int i = 1;i<n;i++){
            for(int j = 0;j<=capacity;j++){
                int notTake = dp[i-1][j];
                int take = Integer.MIN_VALUE;

                if(wt[i] <= j){
                    take = val[i]+dp[i-1][j-wt[i]];
                }
                dp[i][j] = Math.max(notTake, take);
            }
        }
        return dp[n-1][capacity];
    }
    public static int knapSackSO(int capacity,int val[],int wt[]){
        int n = val.length;
        int dp[] = new int[capacity+1];
        for(int i = 0;i<n;i++){
            for(int j = capacity;j>=wt[i];j--){
                int notTake = dp[j];
                int take = val[i]+dp[j-wt[i]];
                dp[j] = Math.max(notTake, take);
            }
        }
        return dp[capacity];
    }
    public static void main(String[] args) {
        int val[] = {10,40,30,50};
        int wt[] = {5,4,6,3};
        int capacity = 5;
        System.out.println(solveUsingMemo(capacity, val, wt));
        System.out.println(solveUsingTab(capacity, val, wt));
        System.out.println(knapSackSO(capacity, val, wt));
    }
}
