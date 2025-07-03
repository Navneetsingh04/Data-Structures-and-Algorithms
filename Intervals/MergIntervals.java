/*
L.C: 56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergIntervals {
    // Time Comlexity: O(nlogn)+O(2n)
    // space Comlexity: O(n)
    // public static int[][] merge(int[][] intervals) {
    //     int n = intervals.length;
    //     Arrays.sort(intervals,new Comparator<int[]>(){
    //         public int compare(int[] a,int[] b){
    //             return a[0]-b[0];
    //         }
    //     });
    //     List<List<Integer>> ans = new ArrayList<>();
    //     for(int i = 0;i<n;i++){
    //         int start = intervals[i][0];
    //         int end = intervals[i][1];
    //         if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){
    //             continue;
    //         }
    //         for(int j = i+1;j<n;j++){
    //             if(intervals[j][0] <= end){
    //                 end = Math.max(end,intervals[j][1]);
    //             }
    //             else{
    //                 break;
    //             }
    //         }
    //         ans.add(Arrays.asList(start,end));
    //     }
    //     int[][] result = new int[ans.size()][2];
    //     for(int i = 0;i<ans.size();i++){
    //         result[i][0] = ans.get(i).get(0);
    //         result[i][1] = ans.get(i).get(1);
    //     }
    //     return result;
    // }
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        // Arrays.sort(intervals,new Comparator<int[]>(){
        //     public int compare(int[] a,int[] b){
        //         return a[0]-b[0];
        //     }
        // });
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(ans.isEmpty() || intervals[i][0] > ans.get(ans.size()-1)[1]){
                ans.add(intervals[i]);
            }
            else{
               ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1],intervals[i][1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        int intervals[][] = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = merge(intervals);
        for(int i[] : ans){
            System.out.print(Arrays.toString(i)+" ");
        }
    }
}