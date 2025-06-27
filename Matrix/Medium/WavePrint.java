/*
Problem statement
Given a matrix mat[][], print it in Wave Form. 
Input: mat[][] ={{1, 2, 3, 4}
                {5, 6, 7, 8}
                {9, 10, 11,12}
                {13, 14, 15, 16}
                {17, 18, 19, 20}}
Output: 1 5 9 13 17 18 14 10 6 2 3 7 11 15 19 20 16 12 8 4 
Explanation: Output is printed in wave form. 

Input: mat[][] = {{1, 9, 4, 10}
                 {3, 6, 90, 11}
                 {2, 30, 85, 72}
                 {6, 31, 99, 15}} 
Output: 1 3 2 6 31 30 6 9 4 90 85 99 15 72 11 10
 */
public class WavePrint {
    public static void wavePrint(int matrix[][]){
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0;i<col;i++){
            if((i&1)==0){
                for(int j = 0;j<row;j++){
                    System.out.print(matrix[j][i]+" ");
                }
            }
            else{
                for(int j = row-1;j>=0;j--){
                    System.out.print(matrix[j][i]+" ");
                }
            }
        }
    }
    public static void main(String args[]){
        int matrix[][] = new int[][]{
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11,12},
        {13, 14, 15, 16},
        {17, 18, 19, 20}};
        System.out.print("printing matrix in Wave form: ");
        wavePrint(matrix);

    }
}
