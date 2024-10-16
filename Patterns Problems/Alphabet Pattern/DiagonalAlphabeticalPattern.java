/*
A B C D E
B C D E F
C D E F G
D E F G H
E F G H I 
*/
import java.util.Scanner;
public class DiagonalAlphabeticalPattern {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the value of n: ");
            int n = s.nextInt();
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=n;j++){
                    char ch = (char)('A'+i+j-2);
                    System.out.print(ch+" ");
                }
                System.out.println();
            }
        }
    }
}
