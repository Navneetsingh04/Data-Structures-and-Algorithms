/*
L.C: 1751. Maximum Number of Events That Can Be Attended II

You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi and ends at endDayi, and if you attend this event, you will receive a value of valuei. You are also given an integer k which represents the maximum number of events you can attend.

You can only attend one event at a time. If you choose to attend an event, you must attend the entire event. Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the other ends on the same day.

Return the maximum sum of values that you can receive by attending events.

Example 1:
Input: events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
Output: 7
Explanation: Choose the green events, 0 and 1 (0-indexed) for a total value of 4 + 3 = 7.

Example 2:
Input: events = [[1,2,4],[3,4,3],[2,3,10]], k = 2
Output: 10
Explanation: Choose event 2 for a total value of 10.
Notice that you cannot attend any other event as they overlap, and that you do not have to attend k events.

Example 3:
Input: events = [[1,1,1],[2,2,2],[3,3,3],[4,4,4]], k = 3
Output: 9
Explanation: Although the events do not overlap, you can only attend 3 events. Pick the highest valued three.
 
Constraints:
1 <= k <= events.length
1 <= k * events.length <= 106
1 <= startDayi <= endDayi <= 109
1 <= valuei <= 106 
*/

// Time Complexity: O(n*k*logn)
// Space Complexity: O(n*k)

import java.util.Arrays;
public class MaxNumOfEventAttendedII {
    static int n;
    static int[][] dp;
    public static int maxValue(int[][] events, int k) {
        n = events.length;
        Arrays.sort(events,(a,b) -> Integer.compare(a[0],b[0]));
        dp = new int[n+1][k+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return solve(events,0,k);
    }
    private static int solve(int[][] events,int index,int k){
        if(index >= n || k == 0){
            return 0;
        }
        if(dp[index][k] != -1){
            return dp[index][k];
        }
        // int start = events[index][0];
        int end = events[index][1];
        int value = events[index][2];

        int notTake = solve(events,index+1,k);
        int take = 0;
        int j = findNext(events,end);
        take = value+solve(events,j,k-1);
        return dp[index][k] = Math.max(notTake,take);
    } 
    // Binary Search to find event with start time > current event end time
    private static int findNext(int events[][],int endTime){
        int low = 0,high = n;
        while(low < high){
            int mid = low+(high-low)/2;
            if(events[mid][0] <= endTime){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int events[][] = {{1,2,4},{3,4,3},{2,3,10}};
        int k = 2;
        System.out.println(maxValue(events,k));
    }
}
