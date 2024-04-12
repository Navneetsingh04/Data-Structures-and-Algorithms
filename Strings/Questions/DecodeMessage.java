/*
L.C: 2325. Decode the Message

You are given the strings key and message, which represent a cipher key and a secret message, respectively. The steps to decode message are as follows:

1. Use the first appearance of all 26 lowercase English letters in key as the order of the substitution table.
2. Align the substitution table with the regular English alphabet.
3. Each letter in message is then substituted using the table.
4. Spaces ' ' are transformed to themselves.
For example, given key = "happy boy" (actual key would have at least one instance of each letter in the alphabet), we have the partial substitution table of ('h' -> 'a', 'a' -> 'b', 'p' -> 'c', 'y' -> 'd', 'b' -> 'e', 'o' -> 'f').
Return the decoded message.
Example 1:
Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
Output: "this is a secret"
Explanation: The diagram above shows the substitution table.
It is obtained by taking the first appearance of each letter in "the quick brown fox jumps over the lazy dog".
*/
// Time complexity : O(n+m)
// Space complexity : O(n)

public class DecodeMessage {
    public static String decodeMessage(String key,String message){
        // mapping the key from 'a'
        char start = 'a';
        char[] mapping = new char[256];
        for(char ch:key.toCharArray()){
            if(ch != ' ' && mapping[ch] == 0){
                mapping[ch] = start;
                start++;
            }
        }
        // using the Mapping
        StringBuilder ans = new StringBuilder();
        for(char ch:message.toCharArray()){
            if(ch == ' '){
                ans.append(' ');
            }
            else{
                char decodeChar = mapping[ch];
                ans.append(decodeChar);
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "ftafuuv sbfck";
        String ans = decodeMessage(key, message);
        System.out.println("The decoded message is: "+ans);
    }
}
