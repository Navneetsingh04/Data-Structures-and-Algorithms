/*
E 
D E
C D E
B C D E 
A B C D E
*/
import java.util.Scanner;
public class InvertedTriangularAlphabetPattern {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the value of n: ");
            int n = s.nextInt();
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=i;j++){
                    char ch = (char)('A'+n-i+j-1);
                    System.out.print(ch+" ");
                }
                System.out.println();
            }
        }
    }
}
