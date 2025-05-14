/*
L.C: 3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 
Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces. 
*/
public class LongestSubStringWithoutRepeatingChar {
    // Approach: Brute force
    // Time complexity: O(n^2)
    // Space complexity: O(255)
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        for(int i = 0;i<n;i++){
            int hash[] = new int[255];
            for(int j = i;j<n;j++){
                if(hash[s.charAt(j)] == 1) break;
                int len = j-i+1;
                maxLen = Math.max(len,maxLen);
                hash[s.charAt(j)] = 1;
            }
        }
        return maxLen;
    }
    // Approach: Sliding window
    // Time complexity: O(n)
    // Space complexity: O(256)
    public static int lengthOfLongestSubstringI(String s) {
        int n = s.length();
        int hash[] = new int[256];
        int l = 0, r = 0, maxLen = 0;
        while(r < n){
            if(hash[s.charAt(r)] != 0){
                l = Math.max(l,hash[s.charAt(r)]);
            }
            int len = r-l+1;
            maxLen = Math.max(len,maxLen);
            hash[s.charAt(r)] = r+1;
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstringI(s));
    }
}
