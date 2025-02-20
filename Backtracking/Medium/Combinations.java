/*
L.C: 77. Combinations

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.

Constraints:

1 <= n <= 20
1 <= k <= n 
*/
import java.util.ArrayList;
import java.util.List;
public class Combinations {
     public static void findCombination(int index,int n,int k,List<Integer> list,  List<List<Integer>> ans){
        if(k == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<=n;i++){
            list.add(i);
            findCombination(i+1,n,k-1,list,ans);
            list.remove(list.size()-1);
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(1,n,k,list,ans);
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> ans = combine(n, k);
        System.out.println(ans);
    }
}
