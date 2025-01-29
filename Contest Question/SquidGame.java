/*
codechef
Squid Game - Piggy Bank
In the deadly "Squid Game," the participants start with 
N players. After the game ends, only K players survive. The prize pool increases based on the number of players eliminated.

Each eliminated player contributes a fixed amount of 
10,000 units to the prize pool.

Your task is to calculate the total prize money added to the pool, given the number of players N at the start of the game and the number of players who survive,K.

Input Format
The first line contains two integers N and K, where:

N is the total number of players at the start of the game.
K is the number of players still alive after the game.

Output Format
Print a single integer — the total prize money added to the pool.

Constraints
1 ≤ K < N ≤ 100

Sample 1:
Input: 10 5
Output: 50000
Explanation:
The game starts with 10 players, and 5 of them remain in the end. This means 5 players were eliminated, so the total prize pool is 5⋅10000=50000.

Sample 2:
Input:89 33
Output: 560000

Explanation:
The game starts with 89 players, and 33 of them remain in the end. This means 56 players were eliminated, so the total prize pool is 56⋅10000=560000. 
*/

import java.util.Scanner;

public class SquidGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        int rem = N-K;
        
        System.out.println(rem*10000);
        s.close();
    }
}
