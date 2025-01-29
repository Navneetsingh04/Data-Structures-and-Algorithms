/*
White Wall
Toofan loves white walls! He recently painted a wall with some colors: Red (R), Green (G), and Blue (B). However, he realized that the wall doesn't look as bright and white as he imagined.

Toofan's wall has length N, meaning it has N positions placed in a line, and each position can be painted in one color — either red, blue, or green.
You are given a string S of length N, denoting the initial coloring of the wall.

A white wall is defined as a wall where every consecutive set of positions with length divisible by 3 contains equal numbers of R, G, and B.
Formally, for every pair of indices 

1≤L≤R≤N and (R−L+1) is divisible by 3, there must be an equal amount of R, G, and B in the substring 

For instance,
S= RGBR is an example of a white wall - the only substrings with length divisible by 3 are RGB (with 
L = 1 and R=4), which both have an equal number of each color.
S = RGBRGG is an example of a wall that's not white: choosing L = 1 and R=6 gives us a segment with length 
6 (which is a multiple of 3), which has three positions painted green but only one painted blue, which aren't equal.
Toofan can repaint a single position on the wall to any other color (R, G, or B) in one operation.
Your task is to determine the minimum number of operations required to transform the given wall into a white wall.

Input Format
The first line contains a single integer T — the number of test cases.
Each test case consists of two lines of input.
The first line contains an integer N — the length of the wall.
The second line contains a string S of length N, where each character is either R, G, or B, denoting the initial coloring of the wall.
Output Format
For each test case, print a single integer — the minimum number of operations needed to make the wall white.
Constraints
1≤T≤10 
3≤N≤3×10 
Si∈{R,G,B} for all 

1≤i≤N
It is guaranteed that the sum of all N across all test cases does not exceed 3×10^5.
Sample 1:
Input:
2
6
RGBRGG
3
RRR
Output
1
2
Explanation:
Test case 1:

Initial coloring: RGBRGG
This is not a white wall: as noted in the statement, 
L=1 and R=6 gives us a substring of length 6 with different numbers of red/blue/green parts.
Paint the 6-th position to B, to make the wall RGBRGB.
This can be verified to be a white wall.
The pairs (L,R) that must be checked are: 
(1,3),(2,4),(3,5),(4,6),(1,6).
Total changes: 1
*/

import java.util.Scanner;

public class WhiteWall {
    public static void main(String[] args) {
        String pattern[] = {"RGB","RBG","GRB","GBR","BRG","BGR"};
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int N = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            
            int minChange = Integer.MAX_VALUE;
            for(String p : pattern){
                int curr = 0;
                for(int i = 0;i<N;i++){
                    if(s.charAt(i) != p.charAt(i%3)){
                    curr++;
                    }
                }
                if(curr <minChange){
                    minChange = curr;
                }
            }
            System.out.println(minChange);
        }
        sc.close();
    }
}
