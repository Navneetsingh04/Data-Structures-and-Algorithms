import java.util.Scanner;
public class GCD {
    public static int gcd(int n,int m){
        int maxi = Math.max(n, m);
        for(int i =maxi;i>=1;i--){
            if(n%i==0 && m%i == 0){
                return i;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int n = s.nextInt();
        System.out.print("Enter the Second number: ");
        int m = s.nextInt();
        int ans = gcd(n, m);
        System.out.println("GCD of "+n+" and "+m+" is "+ans);
        s.close();
    }
}
