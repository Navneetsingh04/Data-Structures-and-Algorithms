/*
    1
   121
  12321
 1234321
123454321
*/
import java.util.Scanner;
public class PalindromicNumberPyramid {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter value of n: ");
            int n = s.nextInt();
            for(int i = 1;i<=n;i++){
                // Printing staring Space
                for(int space = 1;space<=n-i;space++){
                    System.out.print(" ");
                }
                // printing first half of pyramid
                for(int j = 1;j<=i;j++){
                    System.out.print(j);
                }
                // printing second half of pyramid
                for(int j = i-1;j>=1;j--){
                    System.out.print(j);
                }
                System.out.println();
            }
        }
    }
}
