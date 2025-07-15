/*
L.C: 3136. Valid Word

A word is considered valid if:
It contains a minimum of 3 characters.
It contains only digits (0-9), and English letters (uppercase and lowercase).
It includes at least one vowel.
It includes at least one consonant.
You are given a string word.

Return true if word is valid, otherwise, return false.
Notes:
'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
A consonant is an English letter that is not a vowel.

Example 1:
Input: word = "234Adas"
Output: true

Explanation:
This word satisfies the conditions.

Example 2:
Input: word = "b3"
Output: false
Explanation:
The length of this word is fewer than 3, and does not have a vowel.

Example 3:
Input: word = "a3$e"
Output: false
Explanation:
This word contains a '$' character and does not have a consonant.

Constraints:
1 <= word.length <= 20
word consists of English uppercase and lowercase letters, digits, '@', '#', and '$'. 
*/
public class ValidWord{
    public static boolean isValid(String word) {
        int n = word.length();
        if(n < 3) return false;

        String vowel = "aeiouAEIOU";
        boolean hasVowel = false;
        boolean hasCons = false;
        for(char ch : word.toCharArray()){
            if(!Character.isLetterOrDigit(ch)) return false;
            if(Character.isLetter(ch)){
                if(vowel.indexOf(ch) == -1){
                    hasVowel = true;
                }
                else{
                    hasCons = true;
                }
            }
        }
        return hasVowel && hasCons;
    }
    public static void main(String[] args) {
        String str = "Abc45878";
        System.out.println(isValid(str));
    }
}