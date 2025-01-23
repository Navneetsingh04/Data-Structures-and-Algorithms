/*
L.C: 120. Triangle

Given a triangle array, return the minimum path sum from top to bottom.
For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

Example 1:
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

Example 2:
Input: triangle = [[-10]]
Output: -10
 
Constraints:
1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104 
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static int solveUsingMem(int i,int j,int n,List<List<Integer>> triangle,int dp[][]){
        if(i == n-1) return triangle.get(i).get(j);
        if(dp[i][j] != -1) return dp[i][j];
        int down = triangle.get(i).get(j)+solveUsingMem(i+1,j,n,triangle,dp);
        int digonal = triangle.get(i).get(j)+solveUsingMem(i+1,j+1,n,triangle,dp);
        dp[i][j] = Math.min(down,digonal);
        return dp[i][j];
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int i[]: dp){
            Arrays.fill(i,-1);
        }
        // Initialize the last row of the dp array
        for(int j = 0;j<n;j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        for(int i = n-2;i>=0;i--){
            for(int j = i;j>=0;j--){
                int down = triangle.get(i).get(j)+dp[i+1][j];
                int digonal = triangle.get(i).get(j)+dp[i+1][j+1];
                dp[i][j] = Math.min(down,digonal);
            }
        }
        return dp[0][0];
        // return solveUsingMem(0,0,n,triangle,dp);
    }
    public static void main(String[] args) {
        List<List<Integer>> list =  new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        int ans = minimumTotal(list);
        System.out.println("The minimum path sum from top to bottom is: "+ans);
    }
}
