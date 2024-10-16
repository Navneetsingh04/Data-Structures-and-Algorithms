/*
GFG: 
Given a N x N matrix M. Write a program to find count of all the distinct elements common to all rows of the matrix. Print count of such elements.

Example 1:

Input: 
N = 4
M = {{2, 1, 4, 3},
    {1, 2, 3, 2},
    {3, 6, 2, 3},
    {5, 2, 5, 3}}
Output: 
2
Explaination: Only 2 and 3 are common in all rows. 
*/

// Time Complexity: O(n^2) 
// Space Complexity: O(n)
import java.util.HashMap;
import java.util.Map;

public class DistrinctElement {
    public static void distinctElement(int matrix[][],int n){
        Map<Integer,Integer> map = new HashMap<>();
        // insert element of first row in the map
        for(int i = 0;i<n;i++){
            map.put(matrix[0][i],1);
        }
        // Traverse the matrix from 2nd row
        for(int i = 1;i<n;i++){
            for(int j = 0;j<n;j++){
                // If the element is present in the map and is not duplicated in the current row
                if(map.get(matrix[i][j]) != null && map.get(matrix[i][j]) == i){
                    map.put(matrix[i][j],i+1);
                    // If we have reached the last row print the element
                    if(i == n-1){
                        System.out.print(matrix[i][j]+" ");
                    }
                }
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == n) {
                count++;  // Element is common across all rows
            }
        }
        System.out.println("\nTotal number of element is: "+count); 
    }
    public static void main(String[] args) {
        int matrix[][] = {
        {2, 1, 4, 3},
        {1, 2, 3, 2},  
        {3, 6, 2, 3},  
        {5, 2, 5, 3}
        };
        int n = matrix.length;
        distinctElement(matrix,n);
    }
}
