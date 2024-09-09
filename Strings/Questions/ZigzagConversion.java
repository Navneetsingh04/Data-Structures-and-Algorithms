/*
L.C: 6. Zigzag Conversion
Medium
Topics
Companies
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);
Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */
public class ZigzagConversion {
    public static String zigzagConversion(String s, int numRows) {
        int length = s.length();
        
        // If the length of the string is equal to the number of rows
        // or numRows is 1, return the original string
        if (length == numRows || numRows == 1) {
            return s;
        }
        
        // Initialize a character array to store the converted string
        char[] ans = new char[length];
        int count = 0; // Initialize a count variable to keep track of the current position in the ans array
        
        // Iterate through each row in the zigzag pattern
        for (int i = 0; i < numRows; i++) {
            int j = i; // Initialize j to the current row index
            int k = 0; // Initialize k to calculate the gap between characters in the current row
            int m = 2 * (numRows - 1); // Initialize m as the number of characters in a cycle
            
            // Traverse the string in the current row
            while (j < length) {
                // Add the character at index j to the ans array
                ans[count++] = s.charAt(j);
                
                // Calculate the gap between characters in the current row
                // If i is 0 or the character is not at the corner of a cycle
                // Calculate the gap using the formula: 2 * (numRows - (i + 1))
                // Otherwise, calculate the gap using the formula: 2 * i
                if (i == 0 || ((i + j) % m) != 0) {
                    k = 2 * (numRows - (i + 1));
                } 
                else {
                    k = 2 * i;
                }
                
                // Move j to the next character in the current row
                j = j + k;
            }
        }
        
        // Convert the character array to a string and return
        return new String(ans);
    }
    public static void main(String args[]){
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String ans = zigzagConversion(s,numRows);
        System.out.println("String after ZigZag convesion: "+ans);
    }
}

