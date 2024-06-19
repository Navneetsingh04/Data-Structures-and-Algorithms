import java.util.Scanner;
public class SumOfDigit {
    public static int sum(int n){
        if(n==0){
            return 0;
        }
        return n%10+sum(n/10);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = s.nextInt();
        System.out.println("Sum of digit is "+sum(n));
        s.close();
    }
}
