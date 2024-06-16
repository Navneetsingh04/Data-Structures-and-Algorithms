import java.util.Scanner;
public class printNto1 {
    public static int print(int n){
        if(n==1){
            return 1;
        }
        System.out.print(n+" ");
        return print(n-1);
    }
    public static void printrev(int n){
        if(n==0){
            return;
        }
        printrev(n-1);
        System.out.print(n+" ");
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = s.nextInt();
        System.out.println();
        System.out.print(print(n));
        System.out.println();
        printrev(n);
        s.close();
    }
}
