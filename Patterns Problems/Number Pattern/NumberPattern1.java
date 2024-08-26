import java.util.Scanner;
public class NumberPattern1 {
    public static void printPattern(int n){
        for (int i = 1;i <= n;i++) {
            for (int j = 1;j <= n;j++) {
                int value = n;
                if (i>1 && i<n && j>1 && j<n) {
                    value -= 1;
                }
                if (i>2 && i<n-1 && j>2 && j<n-1) {
                    value -= 1;
                }
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the value of n: ");
            int n = s.nextInt();
            printPattern(n);
        }
    }
}
