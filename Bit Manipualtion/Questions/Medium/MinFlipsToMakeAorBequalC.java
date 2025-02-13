/*
L.C: 1318. Minimum Flips to Make a OR b Equal to c

Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.

Example 1:
Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)

Example 2:
Input: a = 4, b = 2, c = 7
Output: 1

Example 3:
Input: a = 1, b = 2, c = 3
Output: 0
 
Constraints:
1 <= a <= 10^9
1 <= b <= 10^9
1 <= c <= 10^9 
*/
public class MinFlipsToMakeAorBequalC {
    public static int minFlips(int a,int b,int c){
        int flip = 0;
        for(int i = 0;i<30;i++){
            // Extracting th ith bit from a,b and c
            int bitA = (a>>i)&1;
            int bitB = (b>>i)&1;
            int bitC = (c>>i)&1;

            // if bitA|bitB != bitC then we need to flip the bits
            if((bitA | bitB) != bitC){
                // if both the bit a and are 1 and c = 0 then we need two flip
                if(bitA ==  1 && bitB == 1 && bitC == 0){
                    flip += 2;
                }
                else{
                    flip += 1;
                }
            }
        }
        return flip;
    }
    public static void main(String[] args) {
        int a = 2,b = 6,c = 5;
        System.out.println(minFlips(a, b, c));
    }
}
