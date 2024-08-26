/*
1
2 3
3 4 5
4 5 6 7
5 6 7 8 9 
*/
import java.util.Scanner;
public class NumberIncreaseByRow{
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the value of n: ");
            int n = s.nextInt();
            for(int i = 1;i<=n;i++){
                int value = i;
                for(int j = 1;j<=i;j++){
                    System.out.print(value+" ");
                    value += 1;
                }
                System.out.println();
            }
        }
    }
}
