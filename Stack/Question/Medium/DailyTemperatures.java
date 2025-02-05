/*
L.C: 739. Daily Temperatures

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]
 
Constraints:
1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
*/

import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperature){
        int n = temperature.length;
        int ans[] = new int[n];
        for(int i = 0;i<n;i++){
            ans[i] = 0;
        }
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && temperature[i]>temperature[st.peek()]){
                ans[st.peek()] = i-st.peek();
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int temperature[] = {73,74,75,71,69,72,76,73};
        int ans[] = dailyTemperatures(temperature);
        System.out.print("Next Warmer Temperature in days: ");
        for(int value: ans){
            System.out.print(value+",");
        }
    }
}