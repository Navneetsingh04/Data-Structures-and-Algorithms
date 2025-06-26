import java.util.Arrays;
public class UpperTriangularMatrix  {
    public static void printMatrix(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(i>j){
                    System.out.print(0+" ");
                }
                else{
                    System.out.print(matrix[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        for(int i[] : matrix){
            System.out.println(Arrays.toString(i));
        }
        printMatrix(matrix);
    }
}