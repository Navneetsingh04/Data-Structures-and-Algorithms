/*
CodeChef Starters 172D
Streak Star

The Streak Value of an array B is defined as the maximum length of a non-decreasing subarray, more formally:

max.6(1≤i≤j≤N)(j−i+1)where Bi≤B i+1≤Bi+2≤⋯≤Bj
​
Chef has an array A of length N and a magical number X. You are allowed to perform the following operation at most once:

Select an index i, and update the element at Ai by multiplying it with X, i.e., set:=Ai⋅X
Your task is to find the maximum possible Streak Value achievable for array A.

Input Format
The first line of input will contain a single integer T, denoting the number of test cases.
Each test case consists of multiple lines of input.
The first line of each test case contains two space-separated integers N and X — the length of array and magical number respectively.
The second line of each test case contains N space-separated integers A1,A2,A3,...,An— the elements of the array.
Output Format
For each test case, output on a new line the maximum possible Streak Value of A.

Constraints

1≤T≤10^3
1≤N,X≤10^3
1≤Ai<=10^5
 
The sum of N over all test cases won't exceed 10^3.
Sample 1:
Input
Output
3
5 3
1 2 1 4 2
3 10
2 5 3
4 5
90 2 5 6
4
3
3
Explanation:
Test case 1: It is optimal to select index 3, which changes the array A to [1,2,3,4,2]. The Streak Value for the array [1,2,3,4,2] is 4, as the longest non-decreasing subarray is [1,2,3,4].
*/

import java.util.Scanner;

public class StreakStar {
    public static void main(String[] args) {
        	Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while(T-- > 0){
		    int N = s.nextInt();
		    int X = s.nextInt();
		    int A[] =  new int[N];
		    for(int i = 0;i<N;i++){
		        A[i]= s.nextInt();
		    }
		    int max = 1,current = 1;
		    for(int i = 1;i<N;i++){
		       if(A[i] >= A[i-1]){
		           current++;
		           max = Math.max(max,current);
		       }
		       else{
		           current = 1;
		       }
		    }
		    int maxAnswer = max;
		    for(int i = 0;i<N;i++){
		        current = 1;
		        int modifiedMax = 1;
		        for(int j = 1;j<N;j++){
		            int prev = (j-1 == i) ? A[j-1]*X :A[j-1];
		            int curr = (j == i) ? A[j]*X :A[j];
		            
		            if(curr >= prev){
		                current++;
		                modifiedMax = Math.max(modifiedMax,current);
		            }
		            else{
		                current = 1;
		            }
		        }
		        maxAnswer = Math.max(maxAnswer,modifiedMax);
		    }
		    System.out.println(maxAnswer);
        }
        s.close();
    }
}
