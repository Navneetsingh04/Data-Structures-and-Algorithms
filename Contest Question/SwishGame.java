/*
Swish Game
Toofan is playing an exciting game where there are N rings, and for each ring, Toofan can either SWISH or PASS. The goal of the game is to achieve at least K swishes.

The game will end immediately when at least one of the following two conditions is met:

1. Toofan has finished all the N rings; or
2. it impossible to win the game any more.
This means it is impossible for Toofan to get at least K swishes, regardless of what he does with the remaining rings.


Toofan knows the value of K (the number of swishes he must achieve), and remembers the sequence of moves he made. However, he no longer remembers the value of N (the total number of rings).
You are given a string S of length M, denoting the moves Toofan made during the game. Each character of S is either S (denoting a swish) or P (denoting a pass).

Given that Toofan ended the game after exactly this sequence of M moves, what could the value of N be?

Input Format
> The first line of input contains a single integer T, denoting the number of test cases.
>Each test case consists of two lines of input.
->The first line contains two space-separated integers M and K — the number of moves made by Toofan, and the number of swishes he needs to achieve to win.
The second line contains a string 
S of length M, describing the game played by Toofan.

Output Format
For each testcase, output a single integer — the number of rings N in the game.
Constraints

-> 1≤T≤10 
-> 1≤K≤2⋅10 
-> 1≤M≤2⋅10 

Each character of S is either 'S' or 'P'.

The sum of M across all tests won't exceed 
2⋅10^5
It is guaranteed only 1 such value of answer - N exists.
Sample 1:
Input
2
3 4
SPP
3 1
PSS
Output
5
3
Explanation:
Test case 
1: Toofan has made one swish and two passes so far, and needs to achieve 4 swishes.

-> First move: Swish (It's still possible to win, so game continues)
-> Second move: Pass (It's still possible to win, so game continues)
-> Third move: Pass (It's impossible to win, so game ends, as you can't get 3 more swishes in just 2 rings left)
It can be proved that only N = 5 satisfies this condition.

Test case 

K=1, and Toofan already had 2 swishes when the game ended. This means he must've finished all N rings and won the game, so the answer is simply the number of moves he made, i.e. 
3
3.
*/

import java.util.Scanner;
public class SwishGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while (T-- > 0) {
            int M = s.nextInt();
            int K = s.nextInt();
            s.nextLine();
            String str = s.nextLine();

            int count = 0;
            for(char ch : str.toCharArray()) {
                if (ch == 'S') {
                    count++;
                }
            }
            if(count >= K) {
                System.out.println(M);
            } 
            else {
                System.out.println(M + (K - count - 1));
            }
        }
        s.close();
    }
}
