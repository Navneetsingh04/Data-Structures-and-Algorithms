/*
L.C: 539. Minimum Time Difference

Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
 
Example 1:
Input: timePoints = ["23:59","00:00"]
Output: 1
Example 2:

Input: timePoints = ["00:00","23:59","00:00"]
Output: 0
 

Constraints:

2 <= timePoints.length <= 2 * 104
timePoints[i] is in the format "HH:MM". 
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {
    // Approach 1
    // Time Compllexity: O(nlogn)
    // Space Complexity : O(n)

    // public static int findMinDifference(List<String> timePoints){
    //     if(timePoints.size() > 24*60){
    //         return 0;
    //     }
    //     List<Integer> min = new ArrayList<>();
    //     for(String s : timePoints){
    //         String time[] = s.split(":");
    //         int minutes = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
    //         min.add(minutes);
    //     }
    //     Collections.sort(min);
    //     min.add(min.get(0)+24*60);
    //     int minDiff = Integer.MAX_VALUE;
    //     for(int i = 1;i<min.size();i++){
    //         int diff = min.get(i)-min.get(i-1);
    //         minDiff = Math.min(minDiff,diff);
    //     }
    //     return minDiff;
    // }

    // Approach 2
    // Time Compllexity: O(n)+O(1440)
    // Space Complexity : O(n)

    public static int findMinDifference(List<String> timePoints) {
        boolean mins[] = new boolean[1440];
        for(String time : timePoints){
            int h = Integer.parseInt(time.substring(0,2));
            int m =  Integer.parseInt(time.substring(3,5));
            int minutes = h*60+m;
            if(mins[minutes]) return 0;
            mins[minutes] = true;
        }
        int prev = -1;
        int firstVal = -1;
        int minDiff = Integer.MAX_VALUE;
        for(int curr = 0;curr<1440;curr++){
            if(mins[curr]){
                if(prev == -1){
                    firstVal = curr;
                    prev = curr;
                }
                else{
                    minDiff = Math.min(minDiff,curr-prev);
                    prev = curr;
                }
            }
        }
        if(prev != -1){
            minDiff = Math.min(minDiff,1440+firstVal-prev);
        }
        return minDiff;
    }
    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        Collections.addAll(timePoints,"23:59", "00:00", "12:34", "22:00");
        System.out.println("Minimum Time Difference is: "+findMinDifference(timePoints));
    }
}
