/*
L.C: 76. Minimum Window Substring

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 
Constraints:
m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters. 
*/
public class MinWindowSubstring {
    // Approach: Brute-force
    // Time Complexity: O(n^2)
    // Space Complexity: O(256)
    public static String minWindow(String s,String t){
        int n = s.length();
        int m = t.length();

        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;

        for(int i = 0;i<n;i++){
            int hash[] = new int[256];
            for(int j = 0;j<m;j++){
                hash[t.charAt(j)]++;
            }
            int count = 0;

            for(int j = i;j<n;j++){
                if(hash[s.charAt(j)] > 0){
                    count++;
                }
                hash[s.charAt(j)]--;
                if(count == m){
                    if(j-i+1 < minLen){
                        minLen = j-i+1;
                        sIndex = i;
                    }
                    break;
                }
            }
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex+minLen);
    }
    
    // Approach: Sliding Window
    // Time Complexity: O(2n)
    // Space Complexity: O(256)

    public static String minWindowI(String s,String t){
        int n = s.length();
        int m = t.length();
        int minLen = (int)1e9;
        int sIndex = -1;
        int l = 0,r= 0,count = 0;
        int hash[] = new int[256];

        for(int i = 0;i<m;i++){
            hash[t.charAt(i)]++;
        }

        while(r < n){
            if(hash[s.charAt(r)] > 0){
                count++;
            }
            hash[s.charAt(r)]--;
            while(count == m){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    sIndex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0){
                    count--;
                }
                l++;
            }
            r++;
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex+minLen);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
