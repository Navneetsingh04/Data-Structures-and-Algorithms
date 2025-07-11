/*
Meeting Rooms

Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), determine if a person could add all meetings to their schedule without any conflicts.

Example 1:
Input: intervals = [(0,30),(5,10),(15,20)]
Output: false
Explanation:
(0,30) and (5,10) will conflict
(0,30) and (15,20) will conflict

Example 2:
Input: intervals = [(5,8),(9,15)]
Output: true
Note:
(0,8),(8,10) is not considered a conflict at 8

Constraints:
0 <= intervals.length <= 500
0 <= intervals[i].start < intervals[i].end <= 1,000,000
 
*/

// Time Complexity: O(nlogn)
// Space Complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class MeetingRooms {

    public static class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>(List.of(
            new Interval(0, 30),
            new Interval(5, 10),
            new Interval(15, 20)
        ));
        System.out.println(canAttendMeetings(intervals)); 
    }
}
