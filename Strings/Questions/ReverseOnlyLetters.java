/*
L.C: 917. Reverse Only Letters

Given a string s, reverse the string according to the following rules:
-> All the characters that are not English letters remain in the same position.
-> All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.
Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 */
public class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String str){
        char[]  ch = str.toCharArray();
        int s = 0;
        int end = str.length()-1;
        while(s<end){
        while(s<end && !Character.isLetter(ch[s])){
            s++;
        }
        while(s<end && !Character.isLetter(ch[end])){
            end--;
        }
        char temp = ch[s];
        ch[s] = ch[end];
        ch[end] = temp;
        s++;
        end--;
    }
    return new String(ch);
    }
    public static void main(String args[]){
        String s = "Test1ng-Leet=code-Q!";
        String ans = reverseOnlyLetters(s);
        System.out.println("String after Reversing the letters: "+ans);
    }
}
