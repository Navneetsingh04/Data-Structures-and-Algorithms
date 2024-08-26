/*
******************1******************
*****************2*2*****************
****************3*3*3****************
***************4*4*4*4***************
**************5*5*5*5*5**************
*************6*6*6*6*6*6*************
************7*7*7*7*7*7*7************
***********8*8*8*8*8*8*8*8***********
**********9*9*9*9*9*9*9*9*9**********
*/
import java.util.Scanner;
public class DiamondStarNumberPattern {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the value on n: ");
            int n = s.nextInt();
            if(n>9){
                System.out.println("Enter the value of less than 9: ");
                n = s.nextInt();
            }
            for(int i = 1;i<=n;i++){
                // Printing Staring stars
                for(int j = 1;j<=n*2-i-1;j++){
                    System.out.print("*");
                }
                // printing numbver sequence with star
                for(int j = 1;j<=i;j++){
                    System.out.print(i);
                    if(j<i){
                        System.out.print("*");
                    }
                }
                // Printing ending stars
                for(int j = 1;j<=n*2-i-1;j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}