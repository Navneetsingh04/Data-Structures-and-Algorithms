/*
L.C: 49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 
Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */
import java.util.*;
public class GroupAnagram {
    public static List<List<String>> groupAnagram(String[] str){
        Map<String,List<String>> hm = new HashMap<>();
        for(String word:str){
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String sortedWord = new String(ch);
            if(!hm.containsKey(sortedWord)){
                hm.put(sortedWord, new ArrayList<>());
            }
            hm.get(sortedWord).add(word);
        }
        return new ArrayList<>(hm.values());
    }
    public static void main(String args[]){
        String[] str = new String[]{"eat","tea","tan","ate","nat","bat"};
       List<List<String>> result = groupAnagram(str);
       System.out.println(result);
    }
}
