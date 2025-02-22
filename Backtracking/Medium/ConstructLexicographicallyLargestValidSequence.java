/*
L.C: 1718. Construct the Lexicographically Largest Valid Sequence

Given an integer n, find a sequence that satisfies all of the following:
The integer 1 occurs once in the sequence.
Each integer between 2 and n occurs twice in the sequence.
For every integer i between 2 and n, the distance between the two occurrences of i is exactly i.
The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|.
Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is always a solution.
A sequence a is lexicographically larger than a sequence b (of the same length) if in the first position where a and b differ, sequence a has a number greater than the corresponding number in b. For example, [0,1,9,0] is lexicographically larger than [0,1,5,6] because the first position they differ is at the third number, and 9 is greater than 5.

Example 1:
Input: n = 3
Output: [3,1,2,3,2]
Explanation: [2,3,2,1,3] is also a valid sequence, but [3,1,2,3,2] is the lexicographically largest valid sequence.

Example 2:
Input: n = 5
Output: [5,3,1,4,3,5,2,4,2]

Constraints:
1 <= n <= 20
*/

import java.util.Arrays;

public class ConstructLexicographicallyLargestValidSequence {
    public static boolean backtrack(int i ,int n,int ans[],boolean use[]){
        if(i >= ans.length) return true;
        if(ans[i] != -1){
            return backtrack(i+1, n, ans, use);
        }
        for(int num= n;num>0;num--){
            if(use[num]) continue;
            use[num] = true;
            ans[i] = num;

            if(num == 1){
                if(backtrack(i+1, n, ans, use)){
                    return true;
                }
            }
            else{
                int j = i+ans[i];
                if(j<ans.length && ans[j] == -1){
                    ans[j] = num;
                    if(backtrack(i+1, n, ans, use)){
                        return true;
                    }
                    ans[j] = -1;
                }
            }
            use[num] = false;
            ans[i] = -1;
        }
        return false;
    }

    public static int[] constructDistancedSequence(int n){
        int ans[] = new int[2*n-1];
        Arrays.fill(ans,-1);
        boolean use[] = new boolean[n+1];
        backtrack(0,n,ans,use);
        return ans;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(constructDistancedSequence(n)));
    }
}
