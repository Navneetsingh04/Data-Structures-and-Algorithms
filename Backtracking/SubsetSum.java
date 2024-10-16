/*
GFG: Subset Sums

Given a list arr of n integers, return sums of all subsets in it. Output sums can be printed in any order.
Examples:

Input: n = 2, arr[] = {2, 3}
Output: 0 2 3 5
Explanation: When no elements is taken then Sum = 0. When only 2 is taken then Sum = 2. When only 3 is taken then Sum = 3. When element 2 and 3 are taken then Sum = 2+3 = 5.
Example 2:

Input: n = 3, arr = {1, 2, 1}
Output: 0 1 1 2 2 3 3 4

Expected Time Complexity: O(2n)
Expected Auxiliary Space: O(2n)

Constraints:
1 <= n <= 15
0 <= arr[i] <= 104 
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {
    public static void subsets(int index,int sum,int n,List<Integer> arr,List<Integer> ans){
        if(index == n){
            ans.add(sum);
            return;
        }
        subsets(index+1, sum+arr.get(index), n, arr, ans);
        subsets(index+1, sum, n, arr, ans);
    }
    public static List<Integer> subsetSum(List<Integer> arr,int n){
        List<Integer> ans = new ArrayList<>();
        subsets(0, 0, n, arr, ans);
        Collections.sort(ans);
        return  ans;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        int n = arr.size();
        List<Integer> ans = subsetSum(arr, n);
        System.out.println(ans);

    }
}

