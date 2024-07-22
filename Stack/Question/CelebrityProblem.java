/*
The Celebrity Problem

A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
Return the index of the celebrity, if there is no celebrity return -1.
Note: Follow 0 based indexing.
Follow Up: Can you optimize it to O(N)
 

Example 1:

Input:
N = 3
M[][] = {{0 1 0},
         {0 0 0}, 
         {0 1 0}}
Output: 1
Explanation: 0th and 2nd person both
know 1. Therefore, 1 is the celebrity. 

Example 2:

Input:
N = 2
M[][] = {{0 1},
         {1 0}}
Output: -1
Explanation: The two people at the party both
know each other. None of them is a celebrity.

Constraints:
1 <= N <= 3000
0 <= M[][] <= 1
*/

import java.util.Stack;

public class CelebrityProblem{
    public static int celebrity(int arr[][],int n){
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            st.push(i);
        }
        // Discard Method to might get celebrity
        while(st.size() != 1){
            int a = st.peek();
            st.pop();
            int b = st.peek();
            st.pop();

            if(arr[a][b] == 1){
                // a is not a celerity
                st.push(b);
            }
            else{
                // b is not celebrity
                st.push(a);
            }
        }
        // checking the single person is celebrity or not

        int cel = st.peek();
        st.pop();
        for(int i = 0;i<n;i++){
            if(arr[cel][i] != 0){
                return -1;
            }
        }
        for(int i = 0;i<n;i++){
            if(arr[i][cel] == 0 && i != cel){
                return -1;
            }
        }
        return cel;
    }
    public static void main(String args[]){
        int arr[][] = new int[][]{{0,1,0},{0,0,0},{0,1,0}};
        int n = 3;
        int ans = celebrity(arr, n);
        System.out.println("Celebrity is "+ans);

    }
}
