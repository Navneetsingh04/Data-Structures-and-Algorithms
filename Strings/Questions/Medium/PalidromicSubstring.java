/*
647. Palindromic Substrings
Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.
Example 1:
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
 */
public class PalidromicSubstring {
    static int expand(String str,int s,int end){
        int count = 0;
        while(s>=0 && end<str.length() && str.charAt(s) == str.charAt(end)){
            count++;
            s--;
            end++;
        }
        return count;
    }
    public static int countPalidromicSubstrings(String s){
        int totalCount = 0;
        for(int i = 0;i<s.length();i++){
            int oddAns = expand(s,i,i);
            int evenAns = expand(s,i,i+1);
            totalCount += oddAns+evenAns;
        }
        return totalCount;
    }
    public static void main(String args[]){
        String str = "aaa";
        System.out.println("Total number of palindromic substring is "+countPalidromicSubstrings(str));
    }
}