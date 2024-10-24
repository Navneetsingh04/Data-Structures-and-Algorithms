/*
L.C: 1593. Split a String Into the Max Number of Unique Substrings

Given a string s, return the maximum number of unique substrings that the given string can be split into.

You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.

A substring is a contiguous sequence of characters within a string.

Example 1:
Input: s = "ababccc"
Output: 5
Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc']. Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.

Example 2:
Input: s = "aba"
Output: 2
Explanation: One way to split maximally is ['a', 'ba'].
Example 3:

Input: s = "aa"
Output: 1
Explanation: It is impossible to split the string any further.
 

Constraints:

1 <= s.length <= 16

s contains only lower case English letters.
*/
import java.util.HashSet;
import java.util.Set;
public class SplitMaxUniqueString {
    int maxCount = 0;
    public int maxUniqueSplit(String s) {
        maxCount = 0;
        Set<String> set = new HashSet<>();
        backtrack(s,0,set);
        return maxCount;
    }
    public void backtrack(String s,int index,Set<String> set){
        int n = s.length();
        if(index == n){
            maxCount = Math.max(maxCount,set.size());
            return;
        }
        for(int i = index;i<n;i++){
            String subString = s.substring(index,i+1);
            if(!set.contains(subString)){
                set.add(subString);
                backtrack(s,i+1,set);
                set.remove(subString);
            }
        }
    }
    public static void main(String[] args) {
        SplitMaxUniqueString obj = new SplitMaxUniqueString();
        String s = "ababccc";
        System.out.println(obj.maxUniqueSplit(s));
    }
}
