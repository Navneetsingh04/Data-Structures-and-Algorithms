/*
L.C: 345. Reverse Vowels of a String
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
Example 1:
Input: s = "hello"
Output: "holle"
Example 2:
Input: s = "leetcode"
Output: "leotcede"
Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */
public class ReverseVowelOfString {
    public static boolean isVowel(char c){
        return c == 'a'||c == 'e' || c == 'i' ||c == 'o'||c == 'u'|| c == 'A'||c == 'E' || c == 'I' ||c == 'O' ||c == 'U';
    }
    public static String reverseVowelOfString(String str){
        char[] ch = str.toCharArray();
        int start = 0;
        int end = str.length()-1;
        while(start<end){
            if(isVowel(ch[start])){
                if(isVowel(ch[end])){
                    char temp = ch[start];
                    ch[start] = ch[end];
                    ch[end] = temp;
                    start++;
                    end--;
                }
                else{
                    end--;
                }
            }
            else{
                start++;
            }
        }
        return new String(ch);
    }
    public static void main(String args[]){
        String str = "Navneet Singh";
        String result = reverseVowelOfString(str);
        System.out.println("String afetr Reversing the vowels Only: "+result);
    }
}
