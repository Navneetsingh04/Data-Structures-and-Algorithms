import java.util.Scanner;
public class GCD {
    // Brute force

    // public static int gcd(int n,int m){
    //     int mini = Math.min(n, m);
    //     for(int i = mini;i>=1;i--){
    //         if(n%i==0 && m%i == 0){
    //             return i;
    //         }
    //     }
    //     return 1;
    // }

    // optimal solution
    public static int gcd(int n,int m){
        while(n > 0 &&  m >0){
            if(n>m){
                n = n%m;
            }
            else{
                m = m%n;
            }
            if(m==0){
                return n;
            }
        }
        return m;
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
