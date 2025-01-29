/*
codechef

Advitiya
Toofan wanted to write the string "ADVITIYA", but accidentally wrote the 8-letter string S instead. He wants to correct his mistake with the minimum number of steps.

In one step, Toofan can choose an index 
(1≤i≤N), and change Si to the next letter in the alphabet.
That is, change A→B,B→C,C→D, and so on.
The alphabet is considered cyclic, so Z can be changed to A.

For example, if S equals "ZARAGOZA",

Operating on the first index will turn S into "AARAGOZA".
Operating on the second index will instead turn S into "ZBRAGOZA".
Operating on the third index will instead turn S into "ZASAGOZA".
And so on for the other indices.
Find the minimum number of steps required to convert the string S into "ADVITIYA".

Input Format
The first line contains an integer T — the number of test cases.
The next T lines each contain a string S consisting of exactly 8 uppercase English letters.

Output Format
For each test case, output a single integer on a new line — the minimum number of steps to convert S into "ADVITIYA".
Constraints
1≤T≤1000
S has length 8.
Each character of S is an uppercase English letter.

Sample 1:
Input
2
ADVITIYA
ADVITIAA
Output
0
24
Explanation:
Test case 

1: S already equals "ADVITIYA", so 0 steps are needed.

Test case 2: "ADVITIAA" can be turned into "ADVITIYA" in 24 steps, by repeatedly operating on the 7-th character.
That is, "ADVITIAA" becomes "ADVITIBA", then "ADVITICA", then "ADVITIDA", and so on till it reaches "ADVITIYA".
*/

import java.util.Scanner;

public class Advitiya {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();
        String target = "ADVITIYA";
        while(T-- > 0){
            String str = s.nextLine();
            int count = 0;
            for(int i = 0;i<8;i++){
                char curr = str.charAt(i);
                char needed = target.charAt(i);
                int diff = (needed-curr+26)%26;
                count += diff;
            }
            System.out.println(count);
        }
        s.close();
    }
}
