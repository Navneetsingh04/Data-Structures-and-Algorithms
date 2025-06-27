import java.util.Scanner;
public class  DiagnolaSum{
    public static int sum(int arr[][],int rows,int col){
        int sum = 0;
        if(rows != col){
            System.out.println("Matrix should be Square Matrix");
        }
        else{
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<col;j++){
                if(i==j){
                sum += arr[i][j];
                }
            }
        }
    }
    return sum;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arr[][] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{3,2,8,9}};
        int rows = arr.length;
        int col = arr[0].length;
        int result = sum(arr, rows, col);
        System.out.println("Sum of Diagonal is "+result);
        s.close();
    }
}
