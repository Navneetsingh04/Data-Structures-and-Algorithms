import java.util.Scanner;
public class LCM {
    public static int lcm(int n,int m){
        int maximum = Math.max(n, m);
        while(true){
            if(maximum%n == 0 && maximum%m == 0) {
                break;
            }
            maximum++;
        }
        return maximum;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int n = s.nextInt();
        System.out.print("Enter the second number: ");
        int m = s.nextInt();
        int result = lcm(n, m);
        System.out.println("LCM of "+n+" and "+m+" is "+result);
        s.close();
    }
}
