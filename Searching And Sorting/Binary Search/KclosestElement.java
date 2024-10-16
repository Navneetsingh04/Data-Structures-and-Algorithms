/*
L.C: 658. Find K Closest Elements

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104 
*/
// Time complexity : O(n-k)
// Space complexity: O(n)
import java.util.ArrayList;
public class KclosestElement {
    public static ArrayList<Integer> closestElement(int arr[],int k, int x){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int l = 0,h = n-1;
        while(h-l>=k){
        if(x-arr[l]>arr[h]-x){
            l++;
        }
        else{
            h--;
        }
    }
    for(int i = l;i<=h;i++){
        ans.add(arr[i]);
    }
    return ans;
}
public static void main(String[] args) {
    int arr[] = new int[]{12,16,22,30,35,39,42,45,48,50,53,55,56};
    int k = 4;
    int x = 35;
    ArrayList<Integer> result = closestElement(arr, k, x);
        System.out.println(result);
    }
}