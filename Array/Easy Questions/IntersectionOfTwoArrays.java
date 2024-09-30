/*
L.C: 349. Intersection of Two Arrays

Given two integer arrays nums1 and nums2, return an array of their 
intersection. Each element in the result must be unique and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000  
*/


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    // Time Complexity: O(nlogn+mlogm)
    // space Complexity: O(min(n,m))

    // Appraoch 1: using sorting
    // public static int[] intersection(int[] nums1, int[] nums2) {
    //     Arrays.sort(nums1);
    //     Arrays.sort(nums2);
    //     int n = nums1.length;
    //     int m = nums2.length;
    //     int l = 0;
    //     int r = 0;
    //     List<Integer> list = new ArrayList<>();
    //     while(l<n && r<m){
    //         if(nums1[l] == nums2[r]){
    //             if(list.isEmpty() || list.get(list.size()-1) != nums1[l]){
    //                 list.add(nums1[l]);
    //             }
    //             l++;
    //             r++;
    //         }
    //         else if(nums1[l] < nums2[r]){
    //             l++;
    //         }
    //         else{
    //             r++;
    //         }   
    //     }
    //     int[] ans = new int[list.size()];
    //     for (int i = 0; i < list.size(); i++) {
    //         ans[i] = list.get(i);
    //     }
    //     return ans;
    // }

    // Appraoch 1: using Hashing

    // Time Complexity: O(n+m)
    // space Complexity: O(n+min(n,m))

    public static int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> set1 = new HashSet<>();
        for(int i: nums1){
            set1.add(i);
        }
        Set<Integer> ans = new HashSet<>();
        for(int i : nums2){
            if(set1.contains(i)){
                ans.add(i);
            }
        }
        int result[] = new int[ans.size()];
        int i = 0;
        for (int num : ans) {
            result[i++] = num;
        }
        return result;

    }
    public static void main(String[] args) {
        int nums1[] = {4,9,5};
        int nums2[] = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
