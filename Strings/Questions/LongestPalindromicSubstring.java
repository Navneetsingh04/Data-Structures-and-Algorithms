/*
L.c: 5. Longest Palindromic Substring
Given a string s, return the longest palindromic substring
in s.
Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 */
//1.Approach:  Brute Force
// Time Complexity : O(n^3) 
// Space Complexity : O(n) 
public class LongestPalindromicSubstring {
    static boolean isPalindrome(String str,int s,int end){
        while(s<end){
            if(str.charAt(s) != str.charAt(end)){
                return false;
            }
            s++;
            end--;
        }
        return true;
    }
    public static String longestPalindromicSubstring(String str){
        String ans = "";
        for(int i = 0;i<str.length();i++){
            for(int j = i;j<str.length();j++){
                if(isPalindrome(str,i,j)){
                    String subString = str.substring(i,j+1);
                    ans = subString.length()>ans.length()?subString:ans;
                }
            }
        }
        return ans;
    }
    public static void main(String args[]){
        String str = "babad";
        System.out.println("longeest Plindromic SubString is: "+longestPalindromicSubstring(str));
    }
}
