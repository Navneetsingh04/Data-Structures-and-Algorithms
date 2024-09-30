/*
L.C: 214. Shortest Palindrome

You are given a string s. You can convert s to a 
palindrome by adding characters in front of it.

Return the shortest palindrome you can find by performing this transformation.

Example 1:
Input: s = "aacecaaa"
Output: "aaacecaaa"

Example 2:
Input: s = "abcd"
Output: "dcbabcd"
 
Constraints:
0 <= s.length <= 5 * 104
s consists of lowercase English letters only.
*/
public class ShortestPalindrome {
    public static String shortestPalindrome(String s) {
        StringBuilder rev = new StringBuilder(s);
        rev.reverse();
        for(int i = 0;i<s.length();i++){
            if(s.substring(0,s.length()-i).equals(rev.substring(i))){
                return rev.substring(0,i)+s;
            }
        }
        return rev.append(s).toString();
    }
    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));
    }
}
