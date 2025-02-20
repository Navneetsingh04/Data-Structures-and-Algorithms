/*
codechef Starters 174 
Deletion and Difference
You're given an array A of length N. You can perform the following operation on it:

- Choose two indices i and j (1≤i<j≤∣A∣) such that Ai = Aj.
Delete both Ai and Aj from A,and append |Ai - Aj| to A.
The length of the array reduces by 1, and all remaining elements are re-indexed to start from 1.

Find the minimum possible length of A after performing this operation several (possibly, zero) times.

Input Format
The first line of input will contain a single integer T, denoting the number of test cases.
Each test case consists of two lines of input.
The first line of each test case contains a single integer N, denoting the length of A.
The second line contains N space-separated integers the element of A.

Output Format

For each test case, output on a new line a single integer: the minimum possible length of 
A
A after performing the given operation several times.

Constraints
- 1 <= T <= 10^5
- 1 <= N <= 2*10^5
- 0<=Ai<=N
- the sum of N over all test cases won't exceed 2.10^5
Sample 1:
Input
3
4
3 1 4 2
2
1 1
3
1 1 0
Output
4
1
1
Explanation:
Test Case 1 : There are no deletions we can do. Hence, the answer is 4,,the size of the initial array.
Test Case 2 : We can choose i = 1 ,j = 2.Note that A1 = A2 = 1, and then insert their difference 0 back into the array while deleting the 1s.thus, the final array becomes 0 of size 1.

*/
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class DeletitionAndDifference {
    public static void main (String[] args) 
	{
		// your code goes here
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while(T-- > 0){
            int N = s.nextInt();
            int A[] = new int[N];
            for(int i= 0;i<N;i++){
                A[i] = s.nextInt();
            }
            Map<Integer,Integer> map = new HashMap<>();
            for(int num : A){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            int k = 0;
            int sumZero = 0;
            int intialZero = map.getOrDefault(0,0);
            
            for(Map.Entry<Integer,Integer> e : map.entrySet()){
                int num = e.getKey();
                int count = e.getValue();
                
                if(num != 0){
                    sumZero += count/2;
                    
                    if(count%2 != 0){
                        k++;
                    }
                }
            }
            int totalZero = sumZero+intialZero;
            int minLength = k+(totalZero >= 1 ?1 : 0);
            System.out.println(minLength);
        }
        s.close();
	}
}
