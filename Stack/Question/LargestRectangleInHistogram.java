/*
L.C: 84. Largest Rectangle in Histogram

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
 */

import java.util.Stack;

public class LargestRectangleInHistogram {
    // public static int largestRectangleArea(int heights[]) {
    //     int n = heights.length;
    //     Stack<Integer> st = new Stack<>();
    //     int leftSmall[] = new int[n];
    //     int rightSmall[] = new int[n];
         
    //     // Fill leftSmall array
    //     for(int i = 0; i < n; i++) {
    //         while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
    //             st.pop();
    //         }
    //         if (st.isEmpty()) {
    //             leftSmall[i] = -1;
    //         }
    //         else {
    //             leftSmall[i] = st.peek();
    //         }
    //         st.push(i);
    //     }
         
    //      // Clear the stack to be re-used
    //     while(!st.isEmpty()){
    //         st.pop();
    //     }
         
    //      // Fill rightSmall array
    //     for (int i = n - 1; i >= 0; i--) {
    //         while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
    //             st.pop();
    //         }
    //         if (st.isEmpty()) {
    //             rightSmall[i] = n;
    //         }
    //         else {
    //             rightSmall[i] = st.peek();
    //         }
    //         st.push(i);
    //     }
         
    //      // Calculate the maximum area
    //     int maxA = 0;
    //     for (int i = 0; i < n; i++) {
    //         maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] - 1));
    //     }
    //     return maxA;
    // }
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i = 0;i<=n;i++){
            while(!st.isEmpty() && (i == n || heights[st.peek()]>=heights[i])){
                int height = heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()){
                    width = i;
                }
                else{
                    width = i-st.peek()-1;
                }
                maxArea = Math.max(maxArea,width*height);
            }
            st.push(i);
        }
        return maxArea;
    }
    public static void main(String args[]) {
        int arr[] = new int[]{2, 1, 5, 6, 2, 3, 1};
        int ans = largestRectangleArea(arr);
        System.out.println("Largest Rectangle area is "+ans); 
    }
}
 