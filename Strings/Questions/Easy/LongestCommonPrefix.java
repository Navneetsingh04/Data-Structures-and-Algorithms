/*
L.c: 14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] str){
        int i = 0;
        StringBuilder ans = new StringBuilder();
        while(i<str[0].length()){
            char currCh = str[0].charAt(i);
            for(String s:str){
            if(i>= s.length() || s.charAt(i) != currCh){
                return ans.toString();
            }
        }
        ans.append(currCh);
        i++;
    }
    return ans.toString();
    }
    public static void main(String args[]){
        String[] str = new String[]{"flower","flow","flight"};
        String result = longestCommonPrefix(str);
        System.out.println("The Lagrgest common Prefix is: "+result);
    }
}
