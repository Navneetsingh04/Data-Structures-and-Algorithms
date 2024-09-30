/*
GFG: Array Leaders

Given an array arr of n positive integers, your task is to find all the leaders in the array. An element of the array is considered a leader if it is greater than all the elements on its right side or if it is equal to the maximum element on its right side. The rightmost element is always a leader.

Examples

Input: n = 6, arr[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.

Input: n = 5, arr[] = {10,4,2,4,1}
Output: 10 4 4 1
Explanation: Note that both of the 4s are in output, as to be a leader an equal element is also allowed on the right. side

Input: n = 4, arr[] = {5, 10, 20, 40} 
Output: 40
Explanation: When an array is sorted in increasing order, only the rightmost element is leader.

Input: n = 4, arr[] = {30, 10, 10, 5} 
Output: 30 10 10 5
Explanation: When an array is sorted in non-increasing order, all elements are leaders.

Constraints:
1 <= n <= 107
0 <= arr[i] <= 107 
*/

import java.util.ArrayList;
import java.util.Collections;
public class LeadersInArray {

    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    // public static ArrayList<Integer> leaders(int n, int arr[]){
    //     ArrayList<Integer> list = new ArrayList<>();
    //     for(int i = 0;i<n;i++){
    //         int j;
    //         for(j = i+1;j<n;j++){
    //             if(arr[j]>=arr[i]){
    //                 break;
    //             }
    //         }
    //         if(j == n){
    //             list.add(arr[i]);
    //         }
    //     }
    //     return list;
    // }

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public static ArrayList<Integer> leaders(int n, int arr[]){
        ArrayList<Integer> list = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;
        for(int i = n-1;i>=0;i--){
            if(arr[i]>maxi){
                list.add(arr[i]);
            }
            maxi = Math.max(maxi,arr[i]);
        }
        Collections.reverse(list);
        return list;
    }
    public static void main(String[] args) {
        int arr[] = {16,17,4,3,5,2};
        int n = arr.length;
        ArrayList<Integer> ans = leaders(n, arr);
        System.out.println(ans);
    }
}