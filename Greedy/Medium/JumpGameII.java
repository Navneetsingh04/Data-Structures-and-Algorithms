/*
L.C: 45. Jump Game II

You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] 
where:
0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2

Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1]. 
*/
// import java.util.Arrays;
public class JumpGameII {
    // 1st Approach: Using DP

    // public static int solve(int index,int jumps,int nums[],int n,int dp[][]){
    //     if(index >= n-1){
    //         return jumps;
    //     }
    //     if(dp[index][jumps] != -1){
    //         return dp[index][jumps];
    //     }
    //     int mini = Integer.MAX_VALUE;
    //     for(int i = 1;i<=nums[index];i++){
    //         if(index+i < n){
    //             mini = Math.min(mini,solve(index+i,jumps+1,nums,n,dp));
    //         }
    //     }
    //     return dp[index][jumps] = mini;
    // }
    // public static int jump(int nums[]){
    //     int n = nums.length;
    //     int dp[][] = new int[n][n];
    //     for(int i[] : dp){
    //         Arrays.fill(i,-1);
    //     }
    //     return solve(0,0,nums,n,dp);
    // }

    // 2nd Approach : Using Greedy
    public static int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int left = 0,right = 0;
        while(right < n-1){
            int maxi = 0;
            for(int i = left;i<=right;i++){
                maxi = Math.max(i+nums[i],maxi);
            }
            left = right+1;
            right = maxi;
            jumps++;
        }
        return jumps;
    }
    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
