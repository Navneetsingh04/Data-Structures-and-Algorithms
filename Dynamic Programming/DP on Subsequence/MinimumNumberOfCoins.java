import java.util.Arrays;

public class MinimumNumberOfCoins {
     public static int solve(int index,int num[],int x,int dp[][]){
        if(index == 0){
            if(x%num[index] == 0){
                return x/num[index];
            }
            else{
                return Integer.MAX_VALUE;
            }
        }
        if(dp[index][x] != -1){
            return dp[index][x];
        }
        int notTake = solve(index-1,num,x,dp);
        int take = Integer.MAX_VALUE;
        if(num[index] <= x){ 
            int ans = solve(index,num,x-num[index],dp);
            if(ans != Integer.MAX_VALUE){
                take = 1+ans;
            }
        }
        return dp[index][x] = Math.min(take,notTake);
    }
    public static int solveUsingMemo(int num[], int x) {
        int n = num.length;
        int dp[][] = new int[n][x+1];
        for(int i[] :  dp){
            Arrays.fill(i,-1);
        }
        int ans = solve(n-1,num,x,dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public static int minimumElements(int num[], int x) {
        int n = num.length;
        int dp[][] = new int[n][x+1];
        for(int i = 0;i<=x;i++){
            if(i%num[0] == 0){
                dp[0][i] = i/num[0];
            }
            else{
                dp[0][i] = Integer.MAX_VALUE;
            }
        }
        for(int i = 1;i<n;i++){
            for(int j = 0;j<=x;j++){
                int notTake = dp[i-1][j];
                int take = Integer.MAX_VALUE;
                if(num[i] <= j){ 
                    int ans = dp[i][j-num[i]];
                    if(ans != Integer.MAX_VALUE){
                        take = 1+ans;
                }
            }
            dp[i][j] = Math.min(take,notTake);
        }
    }
    int ans = dp[n-1][x];
    return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int x = 7;
        System.out.println(solveUsingMemo(arr, x));
        System.out.println(minimumElements(arr, x));
    }
}
