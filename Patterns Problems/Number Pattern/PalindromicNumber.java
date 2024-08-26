/*
    1
   232
  34543
 4567654
567898765
*/
import java.util.Scanner;
public class PalindromicNumber {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter value of n: ");
            int n = s.nextInt();
            for(int i = 1;i<=n;i++){
                // Printing staring Space
                for(int j = 1;j<=n-i;j++){
                    System.out.print(" ");
                }
                // printing first half of pyramid
                for(int j = 1;j<=i;j++){
                    System.out.print(i+j-1);
                }
                // printing second half of pyramid
                int start = i+i-2;
                for(int j = 1;j<i;j++){
                    System.out.print(start);
                    start--;
                }
                System.out.println();
            }
        }
    }
}
