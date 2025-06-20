/*
L.C: 151. Reverse Words in a String

Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 
Constraints:
1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s. 
*/

public class ReverseWordsInString {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static String reverseWords(String s){
        String str[] = s.trim().split("\\s+");
        int n = str.length;

        StringBuilder sb = new StringBuilder();
        for(int i = n-1;i>=0;i--){
            sb.append(str[i]);
            if(i > 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)

     public static String reverseWordsI(String s) {
        int n = s.length();
        int end = n-1;
        StringBuilder sb = new StringBuilder();
        while(end >= 0){
            while(end >= 0 && s.charAt(end) == ' '){
                end--;
            }
            if(end < 0) break;
            int start = end;
            while(start >= 0 && s.charAt(start) != ' '){
                start--;
            }
            sb.append(s.substring(start+1,end+1)).append(" ");
            end = start-1;
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
        System.out.println(reverseWordsI(s));
    }
}
