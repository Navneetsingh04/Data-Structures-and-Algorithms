/*
L.C: 30. Substring with Concatenation of All Words

You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.


Example 1:
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]

Explanation:
The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

Example 2:
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Explanation:

There is no concatenated substring.

Example 3:
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

Output: [6,9,12]

Explanation:

The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].

Constraints:

1 <= s.length <= 104
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstrWithConcatenationOfWords {
    
    // Time Complexity: O(n*k)
    // Space Complexity: O(k)

    public static List<Integer> findSubstring(String s,String[] words){
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        int m = words.length;
        int wordLen = words[0].length();
        int totalLen = m*wordLen;

        for(int i = 0;i<=n-totalLen;i++){
            String sub = s.substring(i, i+totalLen);
            if(isValid(sub,words,wordLen)){
                list.add(i);
            }
        }
        return list;
    }

    public static boolean isValid(String sub,String words[],int wordLen){
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        for(int i= 0;i<sub.length();i += wordLen){
            String curr = sub.substring(i, i+wordLen);
            if(!map.containsKey(curr)){
                return false;
            }
            map.put(curr,map.get(curr)-1);
            if(map.get(curr) == 0){
                map.remove(curr);
            }
        }
        return map.isEmpty();
    }

    // Time Complexity: O(n * wordLen)
    // Space Complexity: O(k)

    public static List<Integer> findSubstringI(String s, String[] words) {
        List<Integer> list = new ArrayList<>();

        int n = s.length();
        int m = words.length;
        int wordLen = words[0].length();
        int totalLen = m*wordLen;

        if(n < totalLen) return list;
        Map<String,Integer> map = new HashMap<>();

        for(String str : words){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        for(int i= 0;i<wordLen;i++){
            int left = i,right = i,count = 0;
            Map<String,Integer> seen = new HashMap<>();
            while(right+wordLen <= n){
                String sub = s.substring(right,right+wordLen);
                right += wordLen;
                if(map.containsKey(sub)){
                    seen.put(sub,seen.getOrDefault(sub,0)+1);
                    count++;
                    
                    while(seen.get(sub) > map.get(sub)){
                        String leftWord = s.substring(left,left+wordLen);
                        seen.put(leftWord,seen.get(leftWord)-1);
                        left += wordLen;
                        count--;
                    }
                    if(count == m){
                        list.add(left);
                    }
                }
                else{
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
		String words[] = {"word","good","best","good"};
		List<Integer> ans = findSubstringI(s,words);
		System.out.println(ans);
    }
}
