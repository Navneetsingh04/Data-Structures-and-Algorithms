/*
CodeChef Starters 172D
Small Palindrome


Chef has X ones (1s) and Y twos (2s) in his collection. He wants to arrange all of them into the smallest possible palindrome number
Help Chef with the answer.

Note: X and Y are both even numbers.

Input Format
The first line of input will contain a single integer T, denoting the number of test cases.
The first and only line of each test case will contain two space-separated integers X, and Y — the amount of ones (1s) and twos (2s) respectively.

Output Format
For each test case, output on a new line the smallest possible palindrome number using X ones (1s) and Y twos (2s).
Constraints

1≤T≤50
0≤X,Y≤10
X and Y are both even
2≤X+Y≤10

Sample Input            
2
1 0
2 2
output: 11 121

Test case 
1
1: The only palindrome number that can be formed using 
2
2 ones (
1
1s) is 
11
11.

Test case 2: Two possible palindromic numbers can be formed using 2 ones (1s) and 2 twos (
2s) which are 1221 and 2112
The smaller palindromic number is 1221, so that is the answer for this case.
*/
import java.util.Scanner;

public class SmallPalindrome {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while(T-- > 0){
		    int X = s.nextInt();
		    int Y = s.nextInt();
		    
		    StringBuilder first = new StringBuilder();
		    
		    for(int i = 0 ;i<X/2;i++){
		        first.append("1");
		    }
		    for(int i = 0 ;i<Y/2;i++){
		        first.append("2");
		    }
		    String palindrome = first.toString() + first.reverse().toString();
		    System.out.println(palindrome);
		}
        s.close();
    }
}
