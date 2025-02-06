/*
L.C: 680. Valid Palindrome II
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:
Input: s = "aba"
Output: true
Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:
Input: s = "abc"
Output: false
 
Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
*/
public class ValidPalindromeII {
    static boolean checkPalindrome(String str,int s,int end){
        while(s<end){
            if(str.charAt(s) != str.charAt(end)){
                return false;
            }
            else{
                s++;
                end--;
            }
        }
        return true;
    }
    public static boolean validPalindrome(String str){
        int s = 0;
        int end = str.length()-1;
        while(s<end){
            if(str.charAt(s) == str.charAt(end)){
                s++;
                end--;
            }
            else{
                boolean ans1 = checkPalindrome(str, s+1, end);
                boolean ans2 = checkPalindrome(str, s, end-1);
                return ans1||ans2;
            }
        }
        return true;
    }
    public static void main(String args[]){
        // String str = "madarracam";
        String str = "abcrrrca";
        System.out.println(validPalindrome(str));
    }
}
