/* 
Find the first repeating element in an array of integers

Given an array of integers arr[], The task is to find the index of first repeating element in it i.e. the element that occurs more than once and whose index of the first occurrence is the smallest. 

Examples: 

Input:
n = 7
arr[] = {1, 5, 3, 4, 3, 5, 6}
Output: 2
Explanation: 
5 is appearing twice and 
its first appearence is at index 2 
which is less than 3 whose first 
occuring index is 3.

Input:
n = 4
arr[] = {1, 2, 3, 4}
Output: -1
Explanation: 
All elements appear only once so 
answer is -1.
*/

// 1st Approach
// Time complexity : O(n^2)
// space complexity : O(1)

// public class FirstRepeatingElement {
//     public static int firstRepeatingElement(int arr[]){
//         int n = arr.length;
//         for(int i = 0;i<n;i++){
//             for(int j = i+1;j<n;j++){
//                 if(arr[i]==arr[j]){
//                     return i+1;
//                 }
//             }
//         }
//         return -1;
//     }
import java.util.HashMap;
public class FirstRepeatingElement {
    public static int firstRepeatingElement(int arr[]){
        int firstRepeatingindex = Integer.MAX_VALUE;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int n = arr.length;
        for(int i = 0;i<n;i++){
            if(hashMap.containsKey(arr[i])){
                firstRepeatingindex = Math.min(firstRepeatingindex,hashMap.get(arr[i]));
            }
            else{
                hashMap.put(arr[i],i+1);
            }
        }
        return firstRepeatingindex == Integer.MAX_VALUE?-1:firstRepeatingindex;
        }
    public static void main(String[] args) {
        int arr[] = new int[]{1,47, 3, 4, 3, 5, 6};
        // int arr[] = new int[]{1,2,3,3,2,4,6};
        // int arr[] = new int[] {1, 2, 3, 4};
        System.out.println(firstRepeatingElement(arr));
    }
}
