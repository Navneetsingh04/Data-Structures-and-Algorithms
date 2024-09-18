
import java.util.Scanner;
public class Transpose{
    public static void transpose(int arr[][],int rows,int col){
        if(rows != col){
            System.out.println("Matrix should be a Square Matrix");
        }
        else{
        for(int i = 0;i<rows;i++){
            for(int j = i;j<col;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        System.out.println("Printing the transpose of the Matrix");
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<col;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arr[][] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{3,2,8,9}};
        int rows = arr.length;
        int col = arr[0].length;
        System.out.println("Printing the transpose ");
        transpose(arr, rows, col);
        s.close();
    }
}