/*
GFG: Count the number of subarrays having a given XOR
Last Updated : 25 Oct, 2022
Given an array of integers arr[] and a number m, count the number of subarrays having XOR of their elements as m.
Examples: 

Input : arr[] = {4, 2, 2, 6, 4}, m = 6
Output : 4
Explanation : The subarrays having XOR of their elements as 6 are {4, 2},{4, 2, 2, 6, 4}, {2, 2, 6},and {6}

Input : arr[] = {5, 6, 7, 8, 9}, m = 5
Output : 2
Explanation : The subarrays having XOR of their elements as 5 are {5} and {5, 6, 7, 8, 9} 
*/

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSubarrayHavingXOR {
    // Time Complexity: O(n^2)
    // space Complexity: O(1)
    // public static int countXOR(int arr[],int k){
    //     int n = arr.length;
    //     int count = 0;
    //     for(int i = 0;i<n;i++){
    //         int xor = 0;
    //         for(int j = i;j<n;j++){
    //             xor ^= arr[j];
    //             if(xor == k) count++;
    //         }
    //     }
    //     return count;
    // }
    public static int countXOR(int arr[],int k){
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int xor = 0;
        int count = 0;
        for(int i = 0;i<n;i++){
           xor ^= arr[i];
           if(map.containsKey(xor^k)){
                count += map.get(xor^k);
           }
           if(!map.containsKey(xor)){
                map.put(xor,0);
           }
           map.put(xor,map.get(xor)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(countXOR(arr, k));
    }
}
