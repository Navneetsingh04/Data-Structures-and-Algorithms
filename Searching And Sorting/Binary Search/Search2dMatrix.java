/*
74. Search a 2D Matrix
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */

// Time complexity : O(log(m * n)) 

public class Search2dMatrix {
    public static boolean search2dMatrix(int arr[][],int target){
        int row = arr.length;
        int col = arr[0].length;
        int n = row*col;
        int s = 0;
        int e = n-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            int rowIndex = mid/col;
            int colIndex = mid%col;
            int curNum = arr[rowIndex][colIndex];
            if(curNum == target){
                return true;
            }
            else if(curNum<target){
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        return false;
    }
    public static void main(String args[]){
        int arr[][] = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 25;
        boolean result = search2dMatrix(arr, target);
        if(result){
            System.out.println("Element found");
        }
        else{
            System.out.println("Element not found");
        }
    }
}
