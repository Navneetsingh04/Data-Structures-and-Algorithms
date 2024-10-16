/*
Sum of minimum and maximum elements of all subarrays of size k.

Given an array of both positive and negative integers, the task is to compute sum of minimum and maximum elements of all sub-array of size k.
Examples: 

Input : arr[] = {2, 5, -1, 7, -3, -1, -2}  
K = 4
Output : 18
Explanation : Subarrays of size 4 are : 
     {2, 5, -1, 7},   min + max = -1 + 7 = 6
     {5, -1, 7, -3},  min + max = -3 + 7 = 4      
     {-1, 7, -3, -1}, min + max = -3 + 7 = 4
     {7, -3, -1, -2}, min + max = -3 + 7 = 4   
     
     Missing sub arrays - 
     
     {2, -1, 7, -3}
     {2, 7, -3, -1}
     {2, -3, -1, -2}
     {5, 7, -3, -1}
     {5, -3, -1, -2}
     and few more -- why these were not considered??
     Considering missing arrays result coming as 27
     
     Sum of all min & max = 6 + 4 + 4 + 4 = 18 
*/
import java.util.Deque;
import java.util.ArrayDeque;
public class SumMaxMinElementInSubArray {
    public int sumOfMinMaxInSubarryOfSizeK(int[] nums, int k) {
        int n = nums.length; 
        int ans = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        Deque<Integer> dq2 = new ArrayDeque<>();
        
        // Initialize the deque for the first window
        for(int i = 0; i < k; i++){
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }
            while(!dq2.isEmpty() && nums[i] <= nums[dq2.peekLast()]){
                dq2.pollLast();
            }
            dq.addLast(i);
            dq2.addLast(i);
        }
        // Process the elements in the first window
        ans += nums[dq.peekFirst()]+nums[dq2.peekFirst()];

        // Process the remaining elements
        for(int i = k;i<n;i++){
            // Remove elements which is out of current window
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            if(!dq2.isEmpty() && dq2.peekFirst() <= i-k){
                dq2.pollFirst();
            }

            // Maintain the decreasing order in the deque
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }
            while(!dq2.isEmpty() && nums[i] <= nums[dq2.peekLast()]){
                dq2.pollLast();
            }
            dq.addLast(i);
            dq2.addLast(i);
            // Store the max of the last window
            ans += nums[dq.peekFirst()]+nums[dq2.peekFirst()];
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {2, 5, -1, 7, -3, -1, -2};
        int k = 4;
        SumMaxMinElementInSubArray obj = new SumMaxMinElementInSubArray();
        int ans = obj.sumOfMinMaxInSubarryOfSizeK(arr,k);
        System.out.println(ans);

    }
}
