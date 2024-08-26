/*
    *
   * *
  *   *
 *     *
* * * * *
*/
import java.util.Scanner;

public class HollowFullPyramid {
    public static void main(String[] args) {
        try(Scanner s = new Scanner(System.in)){
            System.out.print("Enyer the value of n: ");
            int n = s.nextInt();
            for(int i = 1;i<=n;i++){
                for(int j = 1;j <= n-i;j++){
                    System.out.print(" ");
                }
                for(int j = 1;j<=2*i-1;j++){
                    if(j == 1 || j == 2*i-1){
                        System.out.print("*");
                    }
                    else if(i == n && ((j&1) == 1)){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
