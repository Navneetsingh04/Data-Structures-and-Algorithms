/*
L.c 242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 */
import java.util.Arrays;
public class Anagram {
    // 1st Appraoch : sort and compare
    // Time Complexity: O(nlogn)

    // public static boolean isAnagram(String s,String t){
    //     char[] string1 = s.toCharArray();
    //     char[] string2 = t.toCharArray();
    //     Arrays.sort(string1);
    //     Arrays.sort(string2);
    //     return Arrays.equals(string1,string2);
    // }


    //  1st Appraoch : using counting
    // Time Complexity: O(n+m)
    public static boolean isAnagram(String s,String t){
        int freqTable[] = new int[256];
        for(int i = 0;i<s.length();i++){
            freqTable[s.charAt(i)]++;
        }
        for(int i = 0;i<t.length();i++){
            freqTable[t.charAt(i)]--;
        }
        for(int i = 0;i<256;i++){
            if(freqTable[i] != 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s, t);
        if(result){
            System.out.println("Strings are Anagram");
        }
        else{
            System.out.println("String are not Anagram");
        }
    }
}