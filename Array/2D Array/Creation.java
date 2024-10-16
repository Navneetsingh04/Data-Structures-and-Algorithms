import java.util.Scanner;
public class Creation {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of rows and Columns: ");
        int rows = s.nextInt();
        int col = s.nextInt();
        int arr[][] = new int[rows][col];
        System.out.println("Enter the element in the 2D Array");
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<col;j++){
                System.out.print("Enter the element in "+(i+1)+" row and "+(j+1)+" Column: ");
                arr[i][j] = s.nextInt();
            }
        }
        System.out.println("Printing the Array rowise: ");
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<col;j++){
            System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Printing the Array ColumnWise: ");
        for(int i = 0;i<col;i++){
            for(int j = 0;j<rows;j++){
            System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }
        s.close();
    }
}
