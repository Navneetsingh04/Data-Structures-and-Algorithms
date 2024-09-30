
import java.util.ArrayList;

/*
GFG: Union of Two Sorted Arrays

Given two sorted arrays of size n and m respectively, find their union. The Union of two arrays can be defined as the common and distinct elements in the two arrays. Return the elements in sorted order.

Example 1:

Input: 
n = 5, arr1[] = {1, 2, 3, 4, 5}  
m = 5, arr2 [] = {1, 2, 3, 6, 7}
Output: 
1 2 3 4 5 6 7
Explanation: 
Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
Example 2:

Input: 
n = 5, arr1[] = {2, 2, 3, 4, 5}  
m = 5, arr2[] = {1, 1, 2, 3, 4}
Output: 
1 2 3 4 5
Explanation: 
Distinct elements including both the arrays are: 1 2 3 4 5.
Example 3:

Input:
n = 5, arr1[] = {1, 1, 1, 1, 1}
m = 5, arr2[] = {2, 2, 2, 2, 2}
Output: 
1 2
Explanation: 
Distinct elements including both the arrays are: 1 2.
Expected Time Complexity: O(n+m).
Expected Auxiliary Space: O(n+m).
Constraints:
1 <= n, m <= 105
-109 <= arr1[i], arr2[i] <= 109
*/
public class UnionOfTwoSortedArray {
    public static ArrayList<Integer> findUnoion(int arr1[],int arr2[],int n,int m){
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0,j = 0;
        while(i<n && j<m){
            if(arr1[i] < arr2[j]){
                if(list.isEmpty() || list.get(list.size()-1) != arr1[i]){
                    list.add(arr1[i]);
                }
                i++;
            }
            else{
                if(list.isEmpty() || list.get(list.size()-1) != arr2[i]){
                    list.add(arr2[j]);
                }
                j++;
            }
        }
        while(i<n){
            if(list.isEmpty() || list.get(list.size()-1) != arr1[i]){
                list.add(arr1[i]);
            }
            i++;
        }
        while(j<m){
            if(list.isEmpty() || list.get(list.size()-1) != arr2[j]){
                list.add(arr2[j]);
            }
            j++;
        }
        return list;

    }
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5};
        int arr2[] = {1,2,3,6,7};
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<Integer> ans = findUnoion(arr1, arr2, n, m);
        System.out.println(ans);

    }
}
