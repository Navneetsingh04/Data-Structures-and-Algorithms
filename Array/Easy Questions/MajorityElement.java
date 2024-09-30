/*
L.C: 169. Majority Element

Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n/2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 
Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
*/
public class  MajorityElement{
    // Approach 1: Brute Force
    // Time complexity: O(n^2)

    // public static int majorityElement(int arr[]){
    //     int n = arr.length;
    //     int count = 0;
    //     for(int i = 0;i<n;i++){
    //         for(int j = 0;j<n;j++){
    //             if(arr[j] == arr[i]){
    //                 count++;
    //             }
    //             if(count > n/2){
    //                 return arr[i];
    //             }
    //         }
    //     }
    //     return -1;
    // }
    
    // Approach 2: Hashing
    // time Complexity: O(nlogn)
    // Space Compexity: O(n)
    // public static int majorityElement(int arr[]){
    //     Map<Integer,Integer> map = new HashMap<>();
    //     for(int i = 0;i<arr.length;i++){
    //         map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
    //     }
    //     for(Map.Entry<Integer, Integer> en : map.entrySet()){
    //         if(en.getValue() > arr.length/2){
    //             return en.getKey();
    //         }   
    //     }
    //     return -1;
    // }

    // Approach 2: Moore's Voting Algorithm
    // Time Complexity: O(n)
    // Space Compexity: O(1)

    public static int majorityElement(int[] nums) {
        int count = 0;
        int majority = 0;
        for(int i : nums){
            if(count == 0){
                majority = i;
            }
            if(i == majority){
                count++;
            }
            else{
                count--;
            }
        }
        return majority;
    }
    public static void main(String[] args) {
        int arr[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }
}