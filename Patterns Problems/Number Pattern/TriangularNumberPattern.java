/*
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
*/
import java.util.Scanner;
public class TriangularNumberPattern{
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the value of n: ");
            int n = s.nextInt();
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=i;j++){
                    System.out.print(j+" ");
                }
                System.out.println();
            }
        }
    }
}
