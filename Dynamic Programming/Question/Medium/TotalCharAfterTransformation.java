/*
L.C3335. Total Characters in String After Transformations I

You are given a string s and an integer t, representing the number of transformations to perform. In one transformation, every character in s is replaced according to the following rules:

If the character is 'z', replace it with the string "ab".
Otherwise, replace it with the next character in the alphabet. For example, 'a' is replaced with 'b', 'b' is replaced with 'c', and so on.
Return the length of the resulting string after exactly t transformations.

Since the answer may be very large, return it modulo 109 + 7.

Example 1:
Input: s = "abcyy", t = 2
Output: 7

Explanation:
First Transformation (t = 1):
'a' becomes 'b'
'b' becomes 'c'
'c' becomes 'd'
'y' becomes 'z'
'y' becomes 'z'
String after the first transformation: "bcdzz"
Second Transformation (t = 2):
'b' becomes 'c'
'c' becomes 'd'
'd' becomes 'e'
'z' becomes "ab"
'z' becomes "ab"
String after the second transformation: "cdeabab"
Final Length of the string: The string is "cdeabab", which has 7 characters.

Example 2:
Input: s = "azbk", t = 1
Output: 5
Explanation:
First Transformation (t = 1):
'a' becomes 'b'
'z' becomes "ab"
'b' becomes 'c'
'k' becomes 'l'
String after the first transformation: "babcl"
Final Length of the string: The string is "babcl", which has 5 characters.
 
Constraints:

1 <= s.length <= 105
s consists only of lowercase English letters.
1 <= t <= 105
*/
public class TotalCharAfterTransformation {
    public static int lengthAfterTransformations(String s, int t) {
        int mod = (int)(1e9+7);
        int dp[][] = new int[t+1][26];

        for(char ch : s.toCharArray()){
            dp[0][ch-'a']++;
        }
        for(int step = 1; step<=t; step++){
            for(int i = 0;i<26;i++){
                if(i<25){
                    dp[step][i+1] = (dp[step][i+1]+dp[step-1][i])%mod;
                }
                else{
                    dp[step][0] = (dp[step][0] + dp[step-1][25])%mod;
                    dp[step][1] = (dp[step][1] + dp[step-1][25])%mod;
                }
            }
        }
        int ans = 0;
        for(int i = 0;i<26;i++){
            ans = (ans+dp[t][i])%mod;
        } 
        return ans;  
    }
    public static void main(String[] args) {
        String s = "abcyy";
        int t = 2;
        System.out.println(lengthAfterTransformations(s, t));
    }
}
