/*
* * * * *
 * * * *
  * * *
   * *
    *
    *
   * *
  * * *
 * * * *
* * * * *
 */


import java.util.Scanner;
public class DiamondWithHollowCenter {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter value of n: ");
            int n = s.nextInt();
            for(int i = 0;i<n;i++){
                for(int j = 0;j<i;j++){
                    System.out.print(" ");
                }
                for(int j = 0;j<n-i;j++){
                    System.out.print("* ");
                }
                System.out.println();
            }
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n-i-1;j++){
                    System.out.print(" ");
                }
                for(int j = 0;j<i+1;j++){
                    System.out.print("* ");
                }
                System.out.println();
            }   }
    }
}
