/*
L.C: 28. Find the Index of the First Occurrence in a String
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
 */
public class FirstIndexofFirstOccurrence {
    public static int strStr(String haystack,String needle){
        int n = haystack.length();
        int m = needle.length();
        for(int i = 0;i<=n-m;i++){
            for(int j = 0;j<=m;j++){
                if(needle.charAt(j) != haystack.charAt(i+j)){
                    break;
                }
                if(j == m-1){
                    return i;
                }
            }
        }
        return -1;
    }
    public static void  main(String args[]){
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println("First Index of first Ocurenece is: "+strStr(haystack, needle));

    }
}
