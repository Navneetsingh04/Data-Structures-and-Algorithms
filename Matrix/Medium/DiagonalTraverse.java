/*
L.C: 98. Diagonal Traverse

Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

Example 1:
Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]

Example 2:

Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]
 
Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 10^4
1 <= m * n <= 10^4
-10^5 <= mat[i][j] <= 10^5
*/

// Time Complexity: O(n*m)
// Space Complexity: O(n*m)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraverse {

    // 1st approach: 
    // Time Complexity: O(n*m)
    // Space Complexity: O(n*m)

    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int ans[] = new int[n*m];

        Map<Integer,List<Integer>> map = new HashMap<>();
    
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                int num = mat[i][j];
                map.putIfAbsent(i+j, new ArrayList<>());
                map.get(i+j).add(num);
            }
        }

       int index = 0;
       boolean flip = true;
        for (int key = 0;key < m+n-1;key++){
            List<Integer> list = map.get(key);
            if(flip){ 
                Collections.reverse(list);
            }
            flip = !flip;
            for(int num : list){
                ans[index++] = num;
            }
        }
        return ans;
    }

    // 2nd approach: 
    // Time Complexity: O(n*m)
    // Space Complexity: O(1)

    public static int[] findDiagonalOrderI(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int ans[] = new int[n*m];

        int row = 0, col = 0;
        boolean up = true; // true = moving up-right, false = moving down-left

        for(int i = 0;i<n*m;i++){
            ans[i] = mat[row][col];    // store current element

            if(up){ // moving up-right
                if(col == n-1){ // reached last column → move down
                    row++;
                    up = !up;
                }
                else if(row == 0){  // reached first row → move right
                    col++;
                    up = !up;
                }
                else{   // normal up-right movement
                    row--;
                    col++;
                }
            } 
            else{   // moving down-left
                if(row == m-1){  // reached last row → move right
                    col++;
                    up = !up;
                }
                else if(col == 0){   // reached first column → move down
                    row++;
                    up = !up;
                }
                else{    // normal down-left movement
                    row++;
                    col--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
        System.out.println(Arrays.toString(findDiagonalOrderI(mat)));
    }
}
