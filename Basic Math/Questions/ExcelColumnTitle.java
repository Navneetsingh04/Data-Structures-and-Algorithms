/*
L.C: 168. Excel Sheet Column Title

Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 
Example 1:

Input: columnNumber = 1
Output: "A"
Example 2:

Input: columnNumber = 28
Output: "AB"
Example 3:

Input: columnNumber = 701
Output: "ZY"
 
Constraints:

1 <= columnNumber <= 231 - 1 
*/

// Time complexity : O(log26(n))
// Space complexity : O(log26(n))

public class ExcelColumnTitle {
    public static String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while(columnNumber > 0){
            // Decrement columnNumber to adjust for 1-indexing in Excel columns
            columnNumber--;
            ans.append((char)('A'+columnNumber%26));
            columnNumber /= 26;
        }
        return ans.reverse().toString();
    }
    public static void main(String[] args) {
        int columnNumber = 701;
        System.out.println(convertToTitle(columnNumber));
    }
}