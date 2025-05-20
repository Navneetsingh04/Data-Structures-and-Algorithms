/*
L.C: 1358. Number of Substrings Containing All Three Characters

Given a string s consisting only of characters a, b and c.
Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

Example 2:
Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 

Example 3:
Input: s = "abc"
Output: 1
 
Constraints:
3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters. 
*/
public class NumOfSubstringsContainingAllThreeChar {

    // Approach 1: Sliding Window
    // T.C: O(n)
    // S.C: O(n)

    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int freq[] = new int[3];
        int i = 0,j = 0;

        while(j<n){
            freq[s.charAt(j) -'a']++;

            while(freq[0] > 0 && freq[1] >0 && freq[2] >0){
                count += n-j;
                freq[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return count;
    }

    // T.C: O(n)
    // S.C: O(1)

    public static int numberOfSubstringsI(String s) {
        int n = s.length();
        int count = 0;
        
        int lastSeen[] = {-1,-1,-1};
        int j =0;
        while(j<n){
            lastSeen[s.charAt(j) -'a'] = j;

            if(lastSeen[0]  != -1 && lastSeen[1]  != -1 && lastSeen[2]  != -1){
                int minIdx = Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2]));
                count += minIdx+1;
            }
            j++;
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
        System.out.println(numberOfSubstringsI(s)); 
    }
}
