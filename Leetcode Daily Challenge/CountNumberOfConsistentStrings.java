/*
L.C : 1684. Count the Number of Consistent Strings

You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.
Return the number of consistent strings in the array words.

Example 1:
Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.

Example 2:
Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.

Example 3:
Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
 

Constraints:

1 <= words.length <= 104
1 <= allowed.length <= 26
1 <= words[i].length <= 10
The characters in allowed are distinct.
words[i] and allowed contain only lowercase English letters. 
*/

import java.util.HashSet;
import java.util.Set;
public class CountNumberOfConsistentStrings {
    // brute Force

    // Time Complexity: O(n*m*k)
    // Space Complexity: O(1)
    // public static int countConsistentStrings(String allowed,String[] words){
    //     int count = 0;
    //     // Iterate each word in the array of words
    //     for(String s : words){
    //         boolean isConsistent = true;
    //         // Iterate each charcater of current word
    //         for(int i = 0;i<s.length();i++){
    //             char ch = s.charAt(i);
    //             boolean isCharAllowed = false;
    //             // Checking if char is present in the allowed String or not
    //             for(int j = 0;j<allowed.length();j++){
    //                 if(allowed.charAt(j) == ch){
    //                     isCharAllowed = true;
    //                     break;
    //                 }
    //             }
    //             if(!isCharAllowed){
    //                 isConsistent = false;
    //             }
    //         }
    //         if(isConsistent){
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    public static int countConsistentStrings(String allowed,String words[]){
        Set<Character> set = new HashSet<>();
        for(int i = 0;i<allowed.length();i++){
            set.add(allowed.charAt(i));
        }
        int count = 0;
        for(String s : words){
            boolean isConsistent = true;
            for(int i = 0;i<s.length();i++){
                char currentChar = s.charAt(i);

                if(!set.contains(currentChar)){
                    isConsistent = false;
                    break;
                }
            }
            if(isConsistent){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
            String allowed = "ab";
            String words[] = {"ad","bd","aaab","baa","badab"};
            System.out.println(countConsistentStrings(allowed,words));
    }
}