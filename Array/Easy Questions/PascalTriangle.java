/*
L.C: 118. Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]

Constraints:
1 <= numRows <= 30 
*/
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
     public static List<Integer> generateRow(int row){
        int ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 1;i<row;i++){
            ans = ans*(row-i);
            ans /= i;
            list.add(ans);
        }
        return list;
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1;i<=numRows;i++){
            List<Integer> temp = generateRow(i);
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> ans = generate(numRows);
        System.out.println(ans);
    }
}
