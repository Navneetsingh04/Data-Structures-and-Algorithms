/*
Painting Fence Algorithm
Given a fence with n posts and k colors, find out the number of ways of painting the fence such that at most 2 adjacent posts have the same color. Since the answer can be large, return it modulo 10^9 + 7.

Examples:
Input : n = 2 k = 4
Output : 16
Explanation: We have 4 colors and 2 posts.
Ways when both posts have same color : 4 
Ways when both posts have diff color :4(choices for 1st post) * 3(choices for 2nd post) = 12

Input : n = 3 k = 2
Output : 6
 */
public class PaintingFence {
    public static int getPaintWays(int n,int k){
        if(n == 1){
            return k;
        }
        if(n == 2){
            return k+k*(k-1);
        }
        int ans = (k-1)*(getPaintWays(n-1, k)+getPaintWays(n-2, k));
        return ans;
    }
    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println("Total Ways to Paint to fence: "+getPaintWays(n, k));
    }
}
