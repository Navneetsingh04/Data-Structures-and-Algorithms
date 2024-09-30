import java.util.Scanner;
public class  RowiseSum {
    public static void sum(int arr[][],int rows,int col){
        int sum = 0;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<col;j++){
                sum += arr[i][j];
            }
            System.out.println("Sum of the elemnt is "+(i+1)+" Row "+sum);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arr[][] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int rows = arr.length;
        int col = arr[0].length;
        sum(arr, rows, col);
        s.close();
    }
}