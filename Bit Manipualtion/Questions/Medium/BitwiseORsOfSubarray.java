/*
L.C: 898. Bitwise ORs of Subarrays

Given an integer array arr, return the number of distinct bitwise ORs of all the non-empty subarrays of arr.

The bitwise OR of a subarray is the bitwise OR of each integer in the subarray. The bitwise OR of a subarray of one integer is that integer.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: arr = [0]
Output: 1
Explanation: There is only one possible result: 0.

Example 2:
Input: arr = [1,1,2]
Output: 3
Explanation: The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
These yield the results 1, 1, 2, 1, 3, 3.
There are 3 unique values, so the answer is 3.

Example 3:
Input: arr = [1,2,4]
Output: 6
Explanation: The possible results are 1, 2, 3, 4, 6, and 7.
 
Constraints:
1 <= arr.length <= 5 * 104
0 <= arr[i] <= 109 
*/

// Time complexity: O(n * log(max_element))
// Space complexity: O(k)

import java.util.HashSet;
import java.util.Set;

public class BitwiseORsOfSubarray {
    public static int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for(int num : arr){
            Set<Integer> curr = new HashSet<>();
            curr.add(num);

            for(int val : prev){
                curr.add(val | num);
            }
            prev = curr;
            set.addAll(curr);
        }
        return set.size();
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4};
        System.out.println(subarrayBitwiseORs(arr));
    }
}
