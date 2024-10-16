import java.util.Scanner;
public class JaggedArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = s.nextInt();
        int Jaggedarr[][] = new int[rows][];
        for(int i = 0;i<rows;i++){
            System.out.print("Enter the number of element in "+(i+1)+" row : ");
            int col = s.nextInt();
            Jaggedarr[i] = new int[col];
            for(int j = 0;j<col;j++){
                System.out.print("Enter values: ");
                Jaggedarr[i][j] = s.nextInt();
            }
        }
        for(int i = 0;i<Jaggedarr.length;i++){
            for(int j = 0;j<Jaggedarr[i].length;j++){
                System.out.print(Jaggedarr[i][j]+" ");
            }
            System.out.println();
        }
        s.close();
    }
}
