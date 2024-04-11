/*
* * * * *
* * * *
* * *
* *
*
*/
import java.util.Scanner;
public class InvertedHalfPyramid {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = s.nextInt();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n-i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        s.close();
    }
}
