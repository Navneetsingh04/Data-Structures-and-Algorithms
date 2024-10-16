/*
* * * * *   * * * * *
* * * *       * * * *
* * *           * * *
* *               * *
*                   *
*                   *
* *               * *
* * *           * * *
* * * *       * * * *
* * * * *   * * * * * 
*/
import java.util.Scanner;
public class SplitButterflyPattern {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the value of n: ");
            int n = s.nextInt();
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=n-i+1;j++){
                    System.out.print("* ");
                }
                for(int j = 1;j<2*i;j++){
                    System.out.print("  ");
                }
                for(int j = 1;j<=n-i+1;j++){
                    System.out.print("* ");
                }
                System.out.println();
            }
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=i;j++){
                    System.out.print("* ");
                }
                for(int j = 1;j<=2*n-2*i+1;j++){
                    System.out.print("  ");
                }
                for(int j = 1;j<=i;j++){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }
}
