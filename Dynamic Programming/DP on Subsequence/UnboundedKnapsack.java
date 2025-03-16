import java.util.Arrays;

public class UnboundedKnapsack {

    // Appraoch 1: Brute Force
    // T.C: O(2^n)
    // S.C: O(w)

    public static int solve(int index,int w,int weight[],int value[]){
        if(index == 0){
            return (w/weight[0])*value[0];
        }
        int notTake = 0+solve(index-1, w, weight, value);
        int take = 0;
        if(weight[index] <= w){
            take = value[index]+solve(index,w-weight[index],weight,value);
        }
        return Math.max(take,notTake);
    }
    public static int unboundedKnapsack(int weight[],int value[],int bagWeight){
        int n = weight.length;
        return solve(n-1,bagWeight, weight, value);
    }

    // Appraoch 2: Memonization
    // T.C: O(n*w)
    // S.C: O(w)

    public static int solveI(int index,int w,int weight[],int value[],int dp[][]){
        if(index == 0){
            return (w/weight[0])*value[0];
        }
        if(dp[index][w] != -1){
            return dp[index][w];
        }
        int notTake = 0+solveI(index-1, w, weight, value,dp); 
        int take = 0;
        if(weight[index] <= w){
            take = value[index]+solveI(index,w-weight[index],weight,value,dp);
        }
        return Math.max(take,notTake);
    }
    public static int unboundedKnapsackI(int weight[],int value[],int bagWeight){
        int n = weight.length;
        int dp[][] = new int[n+1][bagWeight+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return solveI(n-1,bagWeight, weight, value,dp);
    }

    // Approach 3: Tabulation

    public static int unboundedKnapsackII(int weight[], int value[], int bagWeight) {
        int n = weight.length;
        int dp[][] = new int[n][bagWeight + 1];
        for (int w = 0; w <= bagWeight; w++) {
            dp[0][w] = (w / weight[0]) * value[0]; 
        }
        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= bagWeight; w++) {
                int notTake = dp[i - 1][w]; 
                int take = 0;
                if (weight[i] <= w) { 
                    take = value[i] + dp[i][w - weight[i]];
                }
                dp[i][w] = Math.max(take, notTake); 
            }
        }
        return dp[n - 1][bagWeight]; 
    }
    
    public static void main(String[] args) {
        int weight[] = {2,4,6};
        int value[] = {5,11,13};
        int bagWeight = 10;
        System.out.println(unboundedKnapsack(weight, value, bagWeight));
        System.out.println(unboundedKnapsackI(weight, value, bagWeight));
        System.out.println(unboundedKnapsackII(weight, value, bagWeight));
    }
}
