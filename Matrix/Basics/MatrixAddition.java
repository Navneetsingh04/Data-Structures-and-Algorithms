import java.util.Scanner;
public class MatrixAddition {
    public static void inputMatrix(int[][] matrix, Scanner scanner) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Enter element at position (" + (i + 1) + "," + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
    public static void addMatrices(int[][] matrix1, int[][] matrix2, int[][] resultMatrix) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
    }
    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of rows for the matrices: ");
        int rows = s.nextInt();
        System.out.print("Enter the number of columns for the matrices: ");
        int columns = s.nextInt();
        int[][] matrix1 = new int[rows][columns];
        int[][] matrix2 = new int[rows][columns];
        int[][] sumMatrix = new int[rows][columns];
        System.out.println("Enter elements for the first matrix:");
        inputMatrix(matrix1, s);
        System.out.println("Enter elements for the second matrix:");
        inputMatrix(matrix2, s);
        addMatrices(matrix1, matrix2, sumMatrix);
        System.out.println("Resultant Matrix (Sum of the matrices):");
        displayMatrix(sumMatrix);

        s.close();
    }
}
