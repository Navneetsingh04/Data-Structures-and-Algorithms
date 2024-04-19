/*
Aggressive Cows
You are given an array consisting of n integers which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. You are given the task of assigning stalls to k cows such that the minimum distance between any two of them is the maximum possible.
The first line of input contains two space-separated integers n and k.
The second line contains n space-separated integers denoting the position of the stalls.

Example 1:

Input:
n=5 
k=3
stalls = [1 2 4 8 9]
Output:
3
Explanation:
The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows, in this case, is 3, 
which also is the largest among all possible ways.
Example 2:

Input:
n=5 
k=3
stalls = [10 1 2 7 5]
Output:
4
Explanation:
The first cow can be placed at stalls[0],
the second cow can be placed at stalls[1] and
the third cow can be placed at stalls[4].
The minimum distance between cows, in this case, is 4,
which also is the largest among all possible ways.
Your Task:
Complete the function int solve(), which takes integer n, k, and a vector stalls with n integers as input and returns the largest possible minimum distance between cows.

Expected Time Complexity: O(n*log(10^9)).
Expected Auxiliary Space: O(1).

Constraints:
2 <= n <= 10^5
2 <= k <= n
0 <= stalls[i] <= 10^9
*/
import java.util.*;
public class AggressiveCows{
    static boolean isPossible(int stalls[],int n,int k,int mid){
        // can we place k cows with at least mid distance between cows
        int count = 1;
        int position = stalls[0];
        for(int i = 0;i<n;i++){
            if(stalls[i]-position >= mid){
                count++;
                position = stalls[i]; //one more cow is placed
            }
            if(count==k)  return true;
        }
        return false;
    }
    public static int aggressiveCows(int stalls[],int n,int k){
        Arrays.sort(stalls);
        int s = 0;
        int end = stalls[n-1]-stalls[0];
        int ans = 0;
        while(s<=end){
            int mid = s+(end-s)/2;
            if(isPossible(stalls,n,k,mid)){
                ans = mid;
                s = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        // int arr[] = new int[]{1,2,4,8,9};
        int arr[] = new int[]{10,1,2,7,5};
        int n = arr.length;
        int k = 3;
        System.out.println("The minimum distance between cows is "+aggressiveCows(arr, n, k));
    }
}
