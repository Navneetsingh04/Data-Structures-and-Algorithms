import java.util.Scanner;
public class Searching {
    public static boolean search(int arr[][],int rows,int col,int target){
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<col;j++){
                if(arr[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
    public static int maxelemnt(int arr[][],int rows,int col){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<col;j++){
                if(arr[i][j]>max){
                    max  = arr[i][j];
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arr[][] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int rows = arr.length;
        int col = arr[0].length;
        System.out.println("printing 2D Array");
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<col;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.print("Enter the target Element: ");
        int target = s.nextInt();
        boolean result = search(arr, rows, col, target);
        if(result){
            System.out.println("Element found");
        }
        else{
            System.out.println("Element not found");
        }
        System.out.print("The largest element in the 2D Array: ");
        System.out.print(maxelemnt(arr, rows, col));
        s.close();
    }
}
