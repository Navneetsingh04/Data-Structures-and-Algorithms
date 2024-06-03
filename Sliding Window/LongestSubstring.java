/*
L.c 340: Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
 
Constraints:

1 <= s.length <= 5 * 104
0 <= k <= 50
 */
import java.util.*;
public class LongestSubstring {
    public static int longestSubstring(String str,int k){
        int n = str.length();
        int l = 0;
        int r = 0;
        int maxlen = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        for(r = 0;r<n;r++){
            int currCount = map.getOrDefault(str.charAt(r),0);
            map.put(str.charAt(r), currCount+1);
            while(map.size()>k){
                int count = map.get(str.charAt(l));
                if(count == 1){
                    map.remove(str.charAt(l));
                }
                else{
                    map.put(str.charAt(l),count-1);
                }
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
    public static void main(String args[]){
        // String str = "aaabbccd";
        // int k = 2;
        String str = "aabacbebebe";
        int k = 3;
        System.out.println("Longest subString with "+k+" Character is: "+longestSubstring(str, k));
    }
}
