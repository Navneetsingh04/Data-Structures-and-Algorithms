/*
1 
2 1 
3 2 1
4 3 2 1
5 4 3 2 1 
*/
import java.util.Scanner;
public class ReverseTriangularNumberPattern {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the value of n: ");
            int n = s.nextInt();
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=i;j++){
                    System.out.print(i-j+1+" ");
                }
                System.out.println();
            }
        }
    }
}
