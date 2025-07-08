/*
L.C: 1353. Maximum Number of Events That Can Be Attended

You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.
You can attend an event i at any day d where startDayi <= d <= endDayi. You can only attend one event at any time d.

Return the maximum number of events you can attend.

Example 1:
Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.

Example 2:
Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4
 
Constraints:
1 <= events.length <= 105
events[i].length == 2
1 <= startDayi <= endDayi <= 105 
*/

// Time Complexity : O(nlogn)
// Space Complexity : O(n)

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxNoOfEventAttenend {
    public static int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a,b) -> Integer.compare(a[0],b[0]));
        // Sort events by their start day
        // and use a priority queue to keep track of the end days of the events
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        int maxDay = 0;

        for(int event[] : events){
            maxDay = Math.max(maxDay,event[1]);
        }
        int i= 0;
        // Iterate through each day from 1 to maxDay
        // and add all the events that start on that day to the priority queue
        for(int day = 1;day <= maxDay; day++){
            while(i<n && events[i][0] == day){
                pq.add(events[i][0]);
                i++;
            }
            // if last day of event is less than current day then we can not attend that event beacuse it has already ended
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
            if(!pq.isEmpty()){
                pq.poll();
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int events[][] = {{1,1},{1,4},{2,2},{4,4},{3,4}};
        System.out.println(maxEvents(events));
    }
}
