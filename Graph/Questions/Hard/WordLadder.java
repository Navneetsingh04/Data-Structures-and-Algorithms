/*
L.C: 127. Word Ladder

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique. 
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// Time Complexity: O(N*M*26) 
// Space Complexity: O(N) 
class Pair{
    String first;
    int second;
    Pair(String first,int second){
        this.first = first;
        this.second = second;
    }
}
public class WordLadder{
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) { 
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));;
        Set<String> set = new HashSet<>();
        for(String i : wordList){
            set.add(i);
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair p = q.poll();
            String word = p.first;
            int step = p.second;
            if(word.equals(endWord))  return step;
            for(int i = 0;i<word.length();i++){
                char ch[] = word.toCharArray();
                for(char c = 'a';c<='z';c++){
                    ch[i] = c;
                    String replacedChar = new String(ch);

                    if(set.contains(replacedChar)){
                        set.remove(replacedChar);
                        q.add(new Pair(replacedChar,step+1));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }
}