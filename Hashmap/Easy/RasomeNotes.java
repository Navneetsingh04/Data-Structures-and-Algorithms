/*
L.C: 383. Ransom Note

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters. 
*/
public class RasomeNotes {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int n = ransomNote.length();
        int m = magazine.length();
        if(m < n) return false;
        int freq[] = new int[26];

        for(int i = 0;i<m;i++){
            freq[magazine.charAt(i)-'a']++;
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            if(freq[ransomNote.charAt(i)-'a'] > 0){
                count++;
                freq[ransomNote.charAt(i)-'a']--;
            }
            if(n == count) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
