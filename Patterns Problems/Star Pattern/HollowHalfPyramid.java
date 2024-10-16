/*
*
* *
*   *
*     *
* * * * *
*/
import java.util.Scanner;
public class HollowHalfPyramid {
    public static void main(String[] args) {
        try(Scanner s = new Scanner(System.in)){
            System.out.print("Enyer the value of n: ");
            int n = s.nextInt();
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=i;j++){
                    if(j == 1 || j == i|| i == n){
                        System.out.print("* ");
                    }
                    else{
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
        }
    }
}
