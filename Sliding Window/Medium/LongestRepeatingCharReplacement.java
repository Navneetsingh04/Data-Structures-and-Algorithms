/*
L.C: 424. Longest Repeating Character Replacement

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 
Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length 
*/

// Time complexity: O(n)
// Space complexity: O(26)

public class LongestRepeatingCharReplacement {
    public static int characterReplacement(String s, int k) {
        int n  = s.length();
        int maxLen = 0,maxFreq = 0;
        int l = 0,r = 0;
        int hash[] = new int[26];
        while(r < n){
            char ch = s.charAt(r);
            hash[ch -'A']++;
            maxFreq = Math.max(maxFreq,hash[ch-'A']);
            while((r-l+1)- maxFreq > k){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    } 
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
}
