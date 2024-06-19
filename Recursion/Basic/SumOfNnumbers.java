import java.util.Scanner;
public class SumOfNnumbers {
    public static int sum(int n){
        if(n<0){
            return n;
        }
        if(n==0){
            return 0;
        }
        return n+sum(n-1);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = s.nextInt();
        System.out.println("Sum of "+n+" is "+sum(n));
        s.close();
    }
}
