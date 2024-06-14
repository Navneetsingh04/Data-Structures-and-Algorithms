import java.util.Scanner;
public class Factorial {
    public static int fact(int n){
        if(n<0){
            return -1;
        }
        if(n<=1){
            return 1;
        }
        return n*fact(n-1);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = s.nextInt();
        System.out.println("Factorial of "+n+" is "+fact(n));
        s.close();

    }
}
