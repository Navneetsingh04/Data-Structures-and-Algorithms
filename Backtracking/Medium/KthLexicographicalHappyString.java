/*
L.C: 1415. The k-th Lexicographical String of All Happy Strings of Length n

A happy string is a string that:
consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.
Return the kth string of this list or return an empty string if there are less than k happy strings of length n.

Example 1:
Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".

Example 2:
Input: n = 1, k = 4
Output: ""
Explanation: There are only 3 happy strings of length 1.

Example 3:
Input: n = 3, k = 9
Output: "cab"
Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"

Constraints:
1 <= n <= 10
1 <= k <= 100 
*/

// import java.util.ArrayList;
// import java.util.List;

public class KthLexicographicalHappyString {
    // 1st Approach 
    // Time Complexity: O(n * 3 * 2^(n-1)) ~= O(n*2^n)
    // Space Complexity : O(n*2^n)


    // public static String getHappyString(int n,int k){
    //     StringBuilder sb = new StringBuilder();
    //     List<String> list = new ArrayList<>();
    //     solve(sb,list,n);
    //     if(list.size() < k) return "";
    //     return list.get(k-1);
    // }
    // public static void solve(StringBuilder sb,List<String> list,int n){
    //     if(sb.length() == n){
    //         list.add(sb.toString());
    //         return;
    //     }
    //     for(char ch = 'a';ch<='c';ch++){
    //         if(sb.length() > 0 && sb.charAt(sb.length()-1) == ch){
    //             continue;
    //         }
    //         sb.append(ch);
    //         solve(sb, list, n);
    //         sb.deleteCharAt(sb.length()-1);
    //     }
    // }

    // 2nd Approach
    // Time Complexity : O(n * 3 * 2^(n-1)) ~= O(n*2^n)
    // Space Compleity : O(n)

    public static String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        String ans[] = {""};
        int count[] = {0};
        solve(sb,n,k,count,ans);
        return ans[0];
    }
    public static void solve(StringBuilder sb,int n,int k,int count[],String ans[]){
        if(sb.length() == n){
            count[0]++;
            if(count[0] == k){
                ans[0] = sb.toString();
            }
            return;
        }
        for(char ch = 'a';ch<='c';ch++){
            if(sb.length() > 0 && sb.charAt(sb.length()-1) == ch){
                continue;
            }
            sb.append(ch);
            solve(sb,n,k,count,ans);
            if(!ans[0].isEmpty()) return;
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int k = 9;
        String ans = getHappyString(n, k);
        System.out.println(ans);
    }
}
