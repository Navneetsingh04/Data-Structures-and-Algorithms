/*
L.C: 72. Edit Distance

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 
Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 
Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters 
*/
public class EditDistance {
    public static int solve(String word1,String word2,int i,int j){
        if(i>=word1.length()){
            return word2.length()-j;
        }
        if(j >= word2.length()){
            return word1.length()-i;
        }
        int ans = 0;
        if(word1.charAt(i) == word2.charAt(j)){
            ans = 0 + solve(word1, word2, i+1, j+1);
        }
        else{
            // not match
            // insert
            int option1 = 1+solve(word1, word2, i, j+1);
            // remove
            int option2 = 1+solve(word1, word2, i+1, j);
            // replace
            int option3 = 1+solve(word1, word2, i+1, j+1);
            ans = Math.min(option1,Math.min(option2,option3));
        }
        return ans;
    }
    public static int minDistance(String word1,String word2){
        int i = 0;
        int j = 0;
        int ans = solve(word1,word2,i,j);
        return ans;
    }
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println("minimum number of operations required is: "+minDistance(word1, word2));
    }
}
