import java.util.Scanner;
public class MatrixMultiplication {
    public static int[][] multiply(int[][] matrix1,int[][] matrix2,int row1,int col1,int row2,int col2){
        int result[][] = new int[row1][col2];
        if(row1 != col2){
            System.out.println("Matrix multiplicatio is not possible");
        }
        for(int i = 0;i<row1;i++){
            for(int j = 0;j<col2;j++){
                for(int k = 0;k<row2;k++){
                    result[i][j] += matrix1[i][k]*matrix2[k][j];
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of rows for the matrix1: ");
        int row1 = s.nextInt();
        System.out.print("Enter the number of columns for the matrix1: ");
        int column1 = s.nextInt();
        int[][] matrix1 = new int[row1][column1];
        System.out.println("Enter the elements in the first matrix: ");
        for(int i = 0;i<row1;i++){
            for(int j = 0;j<column1;j++){
                matrix1[i][j] = s.nextInt();
            }
        }

        System.out.print("Enter the number of rows for matrix2: ");
        int row2 = s.nextInt();
        System.out.print("Enter the number of columns for the matrix2: ");
        int column2 = s.nextInt();
        int[][] matrix2 = new int[row2][column2];
        System.out.println("Enter the elements in the second matrix: ");
        for(int i = 0;i<row2;i++){
            for(int j = 0;j<column2;j++){
                matrix2[i][j] = s.nextInt();
            }
        }
        int result[][] = multiply(matrix1, matrix2, row1, column1, row2, column2);
        
        System.out.println("Matrix after multiplication: ");
        for(int i = 0;i<result.length;i++){
            for(int j = 0;j<result[i].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
        s.close();
    }
}
