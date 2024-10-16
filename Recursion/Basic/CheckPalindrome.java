import java.util.Scanner;
public class CheckPalindrome {
    static int temp = 0;
    public static void reverse(int n){
        if(n==0){
            return;
        }
        int rem = n%10;
        temp =  temp*10+rem;
        reverse(n/10);
    }
    public static boolean checkPalindrome(int n){
        return n == temp;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = s.nextInt();
        reverse(n);
        boolean ans = checkPalindrome(n);
        if(ans){
            System.out.println(n+ " is a palindromic number");
        }
        else{
            System.out.println(n+" is not a palindromic number");
        }
        s.close();
    }
}
