/*
1
2 * 2
3 * 3 * 3
4 * 4 * 4 * 4
5 * 5 * 5 * 5 * 5
4 * 4 * 4 * 4
3 * 3 * 3
2 * 2
1 
*/
import java.util.Scanner;
public class SandglassNumberPattern {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the value of n: ");
            int n = s.nextInt();
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=i;j++){
                    System.out.print(i);
                    if(j != i){
                        System.out.print(" * ");
                    }
                }   
                System.out.println();
            }
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=n-i;j++){
                    System.out.print(n-i);
                    if(j != n-i){
                        System.out.print(" * ");
                    }
                }
                System.out.println();
            }
        }
    }
}
