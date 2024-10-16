import java.util.Scanner;
public class FibaonacciSpaceOptimise {
    public static int solve(int n){
        int prev = 0;
        if(n == 0){
            return 0;
        }
        int curr = 1;
        if(n == 1){
            return 1;
        }
        int ans = 0;
        for(int i = 2;i<=n;i++){
            ans = curr+prev;
            prev = curr;
            curr = ans;
        }
        return ans;
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
