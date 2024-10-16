/*
Frog Jump

There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.
 
Constraints:
1 <= T <= 10
1 <= N <= 100000.
1 <= HEIGHTS[i] <= 1000 .
*/
import java.util.Arrays;
public class FrogJump {
    public static int solveUsingMem(int index,int height[],int dp[]){
        if(index == 0) return 0;
        if(dp[index] != -1) return dp[index];
        int left = solveUsingMem(index-1,height,dp)+Math.abs(height[index] - height[index-1]);
        int right = Integer.MAX_VALUE;
        if(index > 1){
            right = solveUsingMem(index-2,height,dp)+Math.abs(height[index] - height[index-2]);
        }
        dp[index] =  Math.min(left,right);
        return dp[index];
    }
    public static int solveUsingTab(int n,int height[]){
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i = 1;i<n;i++){
            int fs = dp[i-1]+Math.abs(height[i]-height[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1){
                ss = dp[i-2]+Math.abs(height[i]-height[i-2]);
            }
            dp[i] = Math.min(fs,ss);
        }
        return dp[n-1];
    }
    public static int solveUsingSO(int n,int height[]){
        int prev = 0;
        int prev2 = 0;
        for(int i = 1;i<n;i++){
            int fs = prev+Math.abs(height[i]-height[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1){
                ss = prev2+Math.abs(height[i]-height[i-2]);
            }
            int curr = Math.min(fs,ss);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public static int frogJump(int n,int height[]){
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        int index = n-1;
        int ans = solveUsingMem(index,height,dp);
        return ans;
    }
    public static void main(String[] args) {
        int height[] = {30,10,60,10,60,50};
        int n = height.length;
        // int ans = frogJump(n, height);
        // int ans = solveUsingTab(n, height);
        int ans = solveUsingSO(n, height);

        System.out.println("Minimum Energy required to reach the end is: "+ans);
    }
}
