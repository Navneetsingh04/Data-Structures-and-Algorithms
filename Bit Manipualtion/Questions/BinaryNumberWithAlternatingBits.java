/*
L.C: 693. Binary Number with Alternating Bits

Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

 

Example 1:

Input: n = 5
Output: true
Explanation: The binary representation of 5 is: 101
Example 2:

Input: n = 7
Output: false
Explanation: The binary representation of 7 is: 111.
Example 3:

Input: n = 11
Output: false
Explanation: The binary representation of 11 is: 1011.
 

Constraints:

1 <= n <= 231 - 1
*/

// Time Complexity : O(logn);
// Space Complexity : O(1);

public class BinaryNumberWithAlternatingBits {
    public static boolean hasAlternatingBits(int n) {
        while(n != 0){
            int lastbit = n&1;
            int secondLastBit = (n>>1)&1;
            if((lastbit ^ secondLastBit) != 1){
                return false;
            }
            n >>= 1;
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(hasAlternatingBits(n));
    }
}
