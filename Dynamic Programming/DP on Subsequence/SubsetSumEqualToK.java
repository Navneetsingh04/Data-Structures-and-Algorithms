/*
Subset Sum Equal To K

You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.

Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.

For Example :
If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true. 

Constraints:
1 <= T <= 5
1 <= N <= 10^3
0 <= ARR[i] <= 10^9
0 <= K <= 10^3
*/
import java.util.Arrays;

public class SubsetSumEqualToK {
    public static boolean solveUsingMem(int index,int target,int arr[],int dp[][]){
        if(target == 0) return true;
        if(index == 0) return (arr[0] == target);
        if(dp[index][target] != -1){
            return dp[index][target] == 1;
        }
        boolean notTake =solveUsingMem(index-1,target,arr,dp);
        boolean take = false;
        if(arr[index] <= target){
            take = solveUsingMem(index-1,target-arr[index],arr,dp);
        }   
        dp[index][target] = notTake || take ? 1:0;
        return dp[index][target] == 1;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int dp[][] = new int[n][k+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return solveUsingMem(n-1,k,arr,dp);
    }
    public static boolean solveUsingTab(int n, int k, int arr[]){
        boolean dp[][] = new boolean[n][k+1];
        for(int i = 0;i<n;i++){
            dp[i][0] = true;
        }
        if(arr[0] <= k){
            dp[0][arr[0]] = true;
        }
        for(int index = 1;index<n;index++){
            for(int target =1;target<=k;target++){
                boolean notTake = dp[index-1][target];
                boolean take = false;
                if(arr[index] <= target){
                    take = dp[index-1][target-arr[index]];
                }
                dp[index][target] = notTake || take;
            }
        }
        return dp[n-1][k];
    }
    public static boolean spaceOptmization(int n, int k, int arr[]){
        boolean prev[] = new boolean[k+1];
         // Initialize the base case where the target is 0
        prev[0] = true;

        // Initialize the base case where only the first element is considered
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }
        for(int index = 1;index<n;index++){
            boolean curr[] = new boolean[k+1];
            curr[0] = true;   // Base case: target = 0 is always achievable
            for(int target =1;target<=k;target++){
                boolean notTake = prev[target];
                boolean take = false;
                if(arr[index] <= target){
                    take = prev[target-arr[index]];
                }
                curr[target] = notTake || take;
            }
            prev = curr;
        }
        return prev[k];
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int n = arr.length;
        int k = 4;
        System.out.println(subsetSumToK(n, k, arr));
        System.out.println(solveUsingTab(n, k, arr));
        System.out.println(spaceOptmization(n, k, arr));
    }
}
