/*
L.C: 67. Add Binary

Given two binary strings a and b, return their sum as a binary string.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself. 
*/
public class AddBinary {
    public static String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        while(i >= 0 || j >= 0 || carry > 0){
            if(i >= 0){
                carry += a.charAt(i)-'0';
                i--;
            }
            if(j >= 0){
                carry += b.charAt(j)-'0';
                j--;
            }
            ans.append(carry%2);
            carry /= 2;
        }
        return ans.reverse().toString();
    }
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }
}
