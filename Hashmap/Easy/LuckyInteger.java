/*
L.C: 1394. Find Lucky Integer in an Array

Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.

Return the largest lucky integer in the array. If there is no lucky integer return -1.

Example 1:

Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.

Example 2:

Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.

Example 3:
Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.
 
Constraints:

1 <= arr.length <= 500
1 <= arr[i] <= 500
*/

import java.util.HashMap;
import java.util.Map;

public class LuckyInteger {
    // Approach: Using hashmap
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int findLucky(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int luckyInt = -1;

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getKey().equals(e.getValue())){
                luckyInt = e.getKey();
            }
        }
        return luckyInt;
    }

    // Approach: Using frequency array
    // Time Complexity: O(n)
    // Space Complexity: O(1) 
    public int findLuckyI(int[] arr) {
        int freq[] = new int[501];

        for(int i : arr){
            freq[i]++;
        }

        for(int i = 500;i>=1;i--){
            if(freq[i] == i) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,3,3};
        System.out.println(findLucky(arr));
    }
}
