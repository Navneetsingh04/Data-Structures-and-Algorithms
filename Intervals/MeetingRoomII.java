/*
L.C: Meeting Rooms II

Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of days required to schedule all meetings without any conflicts.

Note: (0,8),(8,10) is not considered a conflict at 8.

Example 1:

Input: intervals = [(0,40),(5,10),(15,20)]

Output: 2
Explanation:
day1: (0,40)
day2: (5,10),(15,20)

Example 2:

Input: intervals = [(4,9)]

Output: 1
Constraints:

0 <= intervals.length <= 500
0 <= intervals[i].start < intervals[i].end <= 1,000,000
 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomII {
    static class Interval{
        int start,end;
        Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    // Approach 1: Using PriorityQueue
    // Time Complexity: O(nlogn)
    // Space Complexity: O(n)
    public static int minMeetingRooms(List<Interval> intervals){
        intervals.sort((a,b) -> a.start - b.start);
        PriorityQueue<Integer>  pq = new PriorityQueue<>();
        for(Interval i : intervals){
            if(!pq.isEmpty() && pq.peek() <= i.start){
                pq.poll();
            }
            pq.add(i.end);
        }
        return pq.size();
    }

    // Approach 2: Using two pointer
    // Time Complexity: O(nlogn)
    // Space Complexity: O(n)

    public static int minMeetingRoomsI(List<Interval> intervals){
        int n = intervals.size();
        int start[] = new int[n];
        int end[] = new int[n];

        for(int i = 0;i<n;i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int ans = 0, count = 0, i = 0,j = 0;
        
        while(i < start.length){
            if(start[i] < end[j]){
                i++;
                count++;
            }
            else{
                j++;
                count--;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>(List.of(
            new Interval(2, 4),
            new Interval(9, 12),
            new Interval(6, 10)
        ));

        System.out.println(minMeetingRooms(intervals));
        System.out.println(minMeetingRoomsI(intervals));
    }
}
