/*
L.C: 1790. Check if One String Swap Can Make Strings Equal

You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.
Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.

Example 1:
Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".

Example 2:
Input: s1 = "attack", s2 = "defend"
Output: false
Explanation: It is impossible to make them equal with one string swap.

Example 3:
Input: s1 = "kelb", s2 = "kelb"
Output: true
Explanation: The two strings are already equal, so no string swap operation is required.
 
Constraints:
1 <= s1.length, s2.length <= 100
s1.length == s2.length
s1 and s2 consist of only lowercase English letters. 
*/
public class CheckOneSwapMakeStringEqual {
    public static String swap(String s,int i,int j){
        char ch[] = s.toCharArray();
        char temp = ch[i];
        ch[i]= ch[j];
        ch[j]= temp;
        return new String(ch);
    }
    public static boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int count = 0;
        int first = -1,second = -1;
        if(n != m) return false;
        for(int i = 0;i<n;i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(count > 2) return false;
                if(first == -1){
                    first = i;
                }
                else{
                    second = i;
                }
            }
        }
        if(count == 0) return true;
        if(count != 2) return false;
        return swap(s1,first,second).equals(s2);
    }
    public static void main(String[] args) {
        String s1 = "bank";
        String s2 = "knab";
        System.out.println(areAlmostEqual(s1, s2));
    }
}
