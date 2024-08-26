import java.util.Scanner;
/*
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25
*/
public class PrintToN {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the value of n: ");
            int n = s.nextInt();
            int count = 1;
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=n;j++){
                    System.out.print(count+" ");
                    count++;
                }
                System.out.println();
            }
        }
    }
}
