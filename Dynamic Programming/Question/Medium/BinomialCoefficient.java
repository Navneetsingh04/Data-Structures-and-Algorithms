import java.util.Arrays;

public class BinomialCoefficient {
    // Approach 1: Recursion
    // T.C: O(2^n)
    // S.C: O(n)

    public static int binomialCoefficient(int n, int k) {
        if(k>n){
            return 0;
        }
        if(k == 0 || k == n){
            return 1;
        }
        return binomialCoefficient(n -1,k-1) + binomialCoefficient(n-1,k);
    }
    // Approach 2: memoization
    // T.C: O(n*k)
    // S.C: O(n*k)+O(n+k)

    public static int nck(int n,int k,int dp[][]){
        if(k>n){
            return 0;
        }
        if(k == 0 || k == n){
            return 1;
        }
        if(dp[n][k] != -1){
            return dp[n][k];
        }
        return dp[n][k] = nck(n-1,k-1,dp) + nck(n-1,k,dp);
    }
    public static int binomialCoefficientI(int n,int k){
        int dp[][] = new int[n+1][k+1];
        for(int i[]: dp){
            Arrays.fill(i,-1);
        }
        return nck(n,k,dp);
    }

    // Approach 3: Tabulation
    // T.C: O(n*k)
    // S.C: O(n*k)

    public static int binomialCoefficientII(int n,int k){
        int dp[][] = new int[n+1][k+1];
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=Math.min(i,k);j++){
                if(j == 0 || j == i){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }
    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(binomialCoefficient(n, k));
        System.out.println(binomialCoefficientI(n, k));
    }
}
