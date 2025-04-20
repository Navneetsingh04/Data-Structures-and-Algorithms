/*
Minimum Multiplications to reach End
Given start, end and an array arr of n numbers. At each step, start is multiplied with any number in the array and then mod operation with 100000 is done to get the new start.

Your task is to find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1.

Example 1:

Input:
arr[] = {2, 5, 7}
start = 3, end = 30
Output:
2
Explanation:
Step 1: 3*2 = 6 % 100000 = 6 
Step 2: 6*5 = 30 % 100000 = 30
Example 2:

Input:
arr[] = {3, 4, 65}
start = 7, end = 66175
Output:
4
Explanation:
Step 1: 7*3 = 21 % 100000 = 21 
Step 2: 21*3 = 63 % 100000 = 63 
Step 3: 63*65 = 4095 % 100000 = 4095 
Step 4: 4095*65 = 266175 % 100000 = 66175
Your Task:
You don't need to print or input anything. Complete the function minimumMultiplications() which takes an integer array arr, an integer start and an integer end as the input parameters and returns an integer, denoting the minumum steps to reach in which end can be achieved starting from start.

Constraints:

1 <= n <= 104
1 <= arr[i] <= 104
1 <= start, end < 105
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinMultiplicationToReachEnd {
    public static int minimumMultiplications(int[] arr, int start, int end) {
        final int mod  = 100000;
        if (start == end) return 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,0});
    
        int dist[] = new int[100000];
        Arrays.fill(dist,(int)1e9);
        dist[start] = 0;
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int node = curr[0];
            int steps = curr[1];
            
            for(int i : arr){
                int num = (i*node)%mod;
                if(steps+1 < dist[num]){
                    dist[num] = steps+1;
                    if(num == end){
                        return steps+1;
                    }
                    q.add(new int[]{num,steps+1});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {2, 5, 7};
        int start = 3, end = 75;
        System.out.println(minimumMultiplications(arr, start, end)); 
    }
}
