/*
L.C: 119. Pascal's Triangle II

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 

Constraints:

0 <= rowIndex <= 33
*/
import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
     public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        long ans = 1;
        list.add((int)ans);
        for(int i = 1;i<=rowIndex;i++){
            ans = ans*(rowIndex-i+1);
            ans /= i;
            list.add((int)ans);
        }
        return list;
    }
    public static void main(String[] args) {
        int  n = 6;
        List<Integer> ans = getRow(n);
        System.out.println(ans);
    }
}
