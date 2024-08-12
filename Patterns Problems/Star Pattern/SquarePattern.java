/*
* * * * *
* * * * *
* * * * *
* * * * *
* * * * *
*/
import java.util.Scanner;
public class SquarePattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = s.nextInt();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        s.close();
    }
}
