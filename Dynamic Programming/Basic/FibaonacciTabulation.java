import java.util.Scanner;
public class FibaonacciTabulation {
    public static int solve(int n){
        // Step 1: creating dp array 
        int dp[] = new int[n+1];
        // step 2: analyse base Case and fill the dp array
        dp[0] = 0;
        if(n == 0){
            return dp[0];
        }
        dp[1] = 1;
        // Step 3: fill the reaming dp Array
        // size = n+1 index -> 0 => n+1 index 0 and 1 are already filled left array n = 2 to n;
        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static int fib(int n){
        int ans = solve(n);
        return ans;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = s.nextInt();
        System.out.println(fib(n));
        s.close(); 
    }
}