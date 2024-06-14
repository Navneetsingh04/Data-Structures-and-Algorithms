import java.util.Scanner;
public class fibonacciNumber {
    public static int fibo(int n){
        if(n<=1){
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = s.nextInt();
        // for(int i = 0;i<n;i++){
        //     System.out.println(fibo(i));
        // }
        System.out.println(fibo(n));
        s.close();
    }
}
