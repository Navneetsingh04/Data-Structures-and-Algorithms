/*
A
B C
C D E
D E F G
E F G H I
*/
import java.util.Scanner;
public class PyramidOfConsecutiveLetters {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the value of n: ");
            int n = s.nextInt();
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=i;j++){
                    char ch = (char)('A'+i+j-2);
                    System.out.print(ch+" ");
                }
                System.out.println();
            }
        }
    }
}