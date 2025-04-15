/*
L.C: 126. Word Ladder II

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].


Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"

Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 
Constraints:

1 <= beginWord.length <= 5
endWord.length == beginWord.length
1 <= wordList.length <= 500
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
The sum of all shortest transformation sequences does not exceed 105. 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// space complexity : O(n) 

public class WordLadderII {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }
        Queue<List<String>> q = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        q.add(list);
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;
        List<List<String>> ans = new ArrayList<>();
        while(!q.isEmpty()){
            List<String> ls = q.poll();
            // remove all word that are used in previous level to transform
            if(ls.size() > level){
                level++;
                for(String it : usedOnLevel){
                    set.remove(it);
                }
            }

            String word = ls.get(ls.size()-1);
            //store answer
            if(word.equals(endWord)){
                if(ans.size() == 0) ans.add(ls);
                else if(ans.get(0).size() == ls.size()){
                    ans.add(ls);
                }
            }
            for(int i = 0;i<word.length();i++){
                for(char c = 'a';c<='z';c++){
                    char ch[] = word.toCharArray();
                    ch[i] = c;
                    String replacedWord = new String(ch);
                    if(set.contains(replacedWord)){
                        ls.add(replacedWord);
                        List<String> temp = new ArrayList<>(ls);
                        q.add(temp);
                        usedOnLevel.add(replacedWord);
                        // mark as visited on the level
                        ls.remove(ls.size()-1);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> result = findLadders(beginWord, endWord, wordList);
        System.out.println(result);
    }
}
