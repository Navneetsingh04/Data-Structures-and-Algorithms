/*
L.C: 386. Lexicographical Numbers

Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]
 

Constraints:

1 <= n <= 5 * 104 
*/
import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
     public static void solve(int curr,int n, List<Integer> list){
        if(curr > n){
            return;
        }
        list.add(curr);
        for(int i = 0;i<=9;i++){
            int newNum = curr*10+i;
            if(newNum > n){
                return;
            }
            solve(newNum,n,list);
        }
    }
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i<=9;i++){
            solve(i,n,list);
        }
        return list;
    }
    public static void main(String[] args) {
        int n = 18;
        System.out.println(lexicalOrder(n));
    }
}
