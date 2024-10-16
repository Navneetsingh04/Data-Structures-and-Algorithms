/*
L.C: 205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
 */
// Time complexity

public class IsomorphicString{
    public static boolean isomorphicString(String s,String t){
        int hash[] = new int[256];
        boolean istCharMapped[] = new boolean[256];
        for(int i = 0;i<s.length();i++){
            if(hash[s.charAt(i)] == 0 && !istCharMapped[t.charAt(i)]){
                hash[s.charAt(i)] = t.charAt(i);
                istCharMapped[t.charAt(i)] = true;
            }
        }
        for(int i = 0;i<s.length();i++){
            if(hash[s.charAt(i)] != t.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        boolean result = isomorphicString(s, t);
        if(result){
            System.out.println("String "+s+" and "+t+" are Isomorphic String");
        }
        else{
            System.out.println("Strings are not Isomorphic Strings");
        }
    }
}