/*
GFG:  Maximize The Cut Segments

Given an integer n denoting the Length of a line segment. You need to cut the line segment in such a way that the cut length of a line segment each time is either x , y or z. Here x, y, and z are integers.
After performing all the cut operations, your total number of cut segments must be maximum. Return the maximum number of cut segments possible.

Note: if no segment can be cut then return 0.

Examples:

Input: n = 4, x = 2, y = 1, z = 1
Output: 4
Explanation: Total length is 4, and the cut
lengths are 2, 1 and 1.  We can make
maximum 4 segments each of length 1.
Input: n = 5, x = 5, y = 3, z = 2
Output: 2
Explanation: Here total length is 5, and
the cut lengths are 5, 3 and 2. We can
make two segments of lengths 3 and 2.

Constraints
1 <= n, x, y, z <= 104
*/
public class MaximizeTheCutSegment {
    public static int solveUsingRec(int n,int x,int y,int z,int dp[]){
        if(n == 0) return 0;
        if(n < 0) return Integer.MIN_VALUE;

        if(dp[n] != Integer.MIN_VALUE){
            return dp[n];
        }
        int option1 = Integer.MIN_VALUE; 
        int option2 = Integer.MIN_VALUE;
        int option3 = Integer.MIN_VALUE;
        if(x <= n){
            option1 = solveUsingRec(n-x, x, y, z, dp);
        }
        if(y <= n){
            option1 = solveUsingRec(n-y, x, y, z, dp);
        }
        if(z <= n){
            option1 = solveUsingRec(n-z, x, y, z, dp);
        }
        
        dp[n] = Math.max(option1,Math.max(option2, option3));
        return dp[n];
    }
    public static int maximizeCut(int n,int x,int y,int z){
        int dp[] = new int[n+1];
        for(int i = 0;i<=n;i++){
            dp[i] = Integer.MIN_VALUE;
        }
        int ans = solveUsingRec(n, x, y, z, dp);
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        int x = 2;
        int y = 1;
        int z = 1;
        System.out.println(maximizeCut(n, x, y, z));

    }    
}
