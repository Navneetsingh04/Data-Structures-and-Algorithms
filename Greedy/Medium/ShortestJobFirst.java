/*
L.C: Shortest Job first

The shortest job first (SJF) or shortest job next, is a scheduling policy that selects the waiting process with the smallest execution time to execute next.

Given an array of integers bt of size n. Array bt denotes the burst time of each process. Calculate the average waiting time of all the processes and return the nearest integer which is smaller or equal to the output.
Note: Consider all process are available at time 0.

Example 1:
Input:
n = 5
bt = [4,3,7,1,2]
Output: 4
Explanation: After sorting burst times by shortest job policy, calculated average waiting time is 4.

Example 2:
Input:
n = 4
arr = [1,2,3,4]
Output: 2
Explanation: After sorting burst times by shortest job policy, calculated average waiting time is 2.

Constraints:
1 <= n <= 105
1 <= arr[i] <= 105 
*/

// Time Complexity: O(nlog(n))
// Space COmplexity: O(1)

import java.util.Arrays;

public class ShortestJobFirst {
    public static int shortestTime(int bt[]){
        int n = bt.length;
        Arrays.sort(bt);
        int time = 0,waitTime = 0;
        for(int i = 0;i<n;i++){
            waitTime += time;
            time += bt[i];
        }
        return waitTime/n;
    }
    public static void main(String[] args) {
        int bt[] = {4,3,7,1,2};
        System.out.println(shortestTime(bt));
    }
}
