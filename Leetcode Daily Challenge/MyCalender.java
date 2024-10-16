/*
L.C: 729. My Calendar I

You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.

A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).

The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

Implement the MyCalendar class:

MyCalendar() Initializes the calendar object.
boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 

Example 1:

Input
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
Output
[null, true, false, true]

Explanation
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
 

Constraints:

0 <= start < end <= 109
At most 1000 calls will be made to book.
*/
import java.util.TreeSet;

public class MyCalender{
    // Approach 1:brute force
    // Time complexity : O(n^2) 

    // List<int[]> calender;
    // public MyCalenderI(){
    //     calender = new ArrayList<>();
    // }
    // public boolean book(int start,int end){
    //     for(int curr[] : calender){
    //         if(!(end <= curr[0] || start >= curr[1])){
    //             return false;
    //         }
    //     } 
    //     calender.add(new int[]{start,end});
    //     return true;
    // }

    // Approach 1: lower Bound(set)
    // Time complexity : O(nlogn) 

    TreeSet<int[]> st;
    public MyCalender() {
        // Initialize the TreeSet with a custom comparator
        st = new TreeSet<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
    }

    public boolean book(int start, int end) {
        // Find the first event that starts after or at the same time of {start, end}
        int[] event = new int[]{start, end};
        int[] next = st.ceiling(event); // O(logN)

        // Check if the current event overlaps with the next event
        if (next != null && next[0] < end) {
            return false;
        }

        // Check if the current event overlaps with the previous event
        int[] prev = st.floor(event);
        if (prev != null && start < prev[1]) {
            return false;
        }

        // If no overlap, add the booking to the set
        st.add(new int[]{start, end});
        return true;
    }
    public static void main(String[] args) {
        MyCalender calender = new MyCalender();
        System.out.println(calender.book(0, 0));
        System.out.println(calender.book(10, 20));
        System.out.println(calender.book(15, 25));
        System.out.println(calender.book(20, 30));
    }
}