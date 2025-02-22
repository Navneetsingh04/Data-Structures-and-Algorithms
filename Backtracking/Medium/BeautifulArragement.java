/*
L.C: 526. Beautiful Arrangement

Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:

perm[i] is divisible by i.
i is divisible by perm[i].
Given an integer n, return the number of the beautiful arrangements that you can construct.


Example 1:

Input: n = 2
Output: 2
Explanation: 
The first beautiful arrangement is [1,2]:
    - perm[1] = 1 is divisible by i = 1
    - perm[2] = 2 is divisible by i = 2
The second beautiful arrangement is [2,1]:
    - perm[1] = 2 is divisible by i = 1
    - i = 2 is divisible by perm[2] = 1
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 15
 */
public class BeautifulArragement {
    public static int ans = 0;
    public static void countArragementHelpher(int arr[],int n,int currNum){
        if(currNum == n+1){
            ans++;
            return;
        }
        for(int i = 1;i<=n;i++){
            if(arr[i] == 0 && (currNum%i == 0 ||i%currNum == 0)){
                arr[i] = currNum;
                countArragementHelpher(arr,n,currNum+1);
                arr[i] = 0;
            }
        }
    }
    public static int countArragement(int n){
        int arr[] = new int[n+1];
        ans = 0;
        countArragementHelpher(arr,n,1);
        return ans;
    }
    public static void main(String args[]){
        int n = 3;
        System.out.println("Total number of beautiful Arragement: "+countArragement(n));
    }
}
